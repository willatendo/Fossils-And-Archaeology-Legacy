package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.util.interfaces.HungerAccessor;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.util.interfaces.TameAccessor;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyringeItem extends Item {
    private static final Map<EntityType<? extends LivingEntity>, EntityType<? extends PregnantAnimal<?>>> ENTITY_TO_PREGNANCY = new HashMap<>();
    private final GeologicalTimeScale.Period period;
    private final Holder<PregnancyType> pregnancyType;
    protected final TagKey<ModelGene> applicableModelTypes;

    public static void addEntityToPregnancy(EntityType<? extends LivingEntity> animalEntityType, EntityType<? extends PregnantAnimal<?>> pregnantEntityType) {
        ENTITY_TO_PREGNANCY.put(animalEntityType, pregnantEntityType);
    }

    static {
        SyringeItem.addEntityToPregnancy(EntityType.ARMADILLO, FAEntityTypes.PREGNANT_ARMADILLO.get());
        SyringeItem.addEntityToPregnancy(EntityType.CAT, FAEntityTypes.PREGNANT_CAT.get());
        SyringeItem.addEntityToPregnancy(EntityType.COW, FAEntityTypes.PREGNANT_DOLPHIN.get());
        SyringeItem.addEntityToPregnancy(EntityType.DONKEY, FAEntityTypes.PREGNANT_DONKEY.get());
        SyringeItem.addEntityToPregnancy(FAEntityTypes.ELASMOTHERIUM.get(), FAEntityTypes.PREGNANT_ELASMOTHERIUM.get());
        SyringeItem.addEntityToPregnancy(EntityType.FOX, FAEntityTypes.PREGNANT_FOX.get());
        SyringeItem.addEntityToPregnancy(EntityType.GOAT, FAEntityTypes.PREGNANT_GOAT.get());
        SyringeItem.addEntityToPregnancy(EntityType.HORSE, FAEntityTypes.PREGNANT_HORSE.get());
        SyringeItem.addEntityToPregnancy(EntityType.LLAMA, FAEntityTypes.PREGNANT_LLAMA.get());
        SyringeItem.addEntityToPregnancy(FAEntityTypes.MAMMOTH.get(), FAEntityTypes.PREGNANT_MAMMOTH.get());
        SyringeItem.addEntityToPregnancy(EntityType.MULE, FAEntityTypes.PREGNANT_MULE.get());
        SyringeItem.addEntityToPregnancy(EntityType.OCELOT, FAEntityTypes.PREGNANT_OCELOT.get());
        SyringeItem.addEntityToPregnancy(EntityType.PANDA, FAEntityTypes.PREGNANT_PANDA.get());
        SyringeItem.addEntityToPregnancy(EntityType.PIG, FAEntityTypes.PREGNANT_PIG.get());
        SyringeItem.addEntityToPregnancy(EntityType.POLAR_BEAR, FAEntityTypes.PREGNANT_POLAR_BEAR.get());
        SyringeItem.addEntityToPregnancy(EntityType.RABBIT, FAEntityTypes.PREGNANT_RABBIT.get());
        SyringeItem.addEntityToPregnancy(EntityType.SHEEP, FAEntityTypes.PREGNANT_SHEEP.get());
        SyringeItem.addEntityToPregnancy(FAEntityTypes.SMILODON.get(), FAEntityTypes.PREGNANT_SMILODON.get());
        SyringeItem.addEntityToPregnancy(EntityType.WOLF, FAEntityTypes.PREGNANT_WOLF.get());
    }

    public SyringeItem(GeologicalTimeScale.Period period, Holder<PregnancyType> pregnancyType, TagKey<ModelGene> applicableModelTypes, Properties properties) {
        super(properties);
        this.period = period;
        this.pregnancyType = pregnancyType;
        this.applicableModelTypes = applicableModelTypes;
    }

    public SyringeItem(GeologicalTimeScale.Period period, Holder<PregnancyType> pregnancyType, Properties properties) {
        this(period, pregnancyType, null, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            Holder<ModelGene> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "model_type", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.COSMETIC_GENE_HOLDER.get())) {
            CosmeticGeneHolder cosmeticGeneHolder = itemStack.get(FADataComponents.COSMETIC_GENE_HOLDER.get());
            tooltipComponents.add(FAUtils.translation("item", "skinGenes", cosmeticGeneHolder.getDisplayName(tooltipContext.registries())).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (ENTITY_TO_PREGNANCY.containsKey(livingEntity.getType())) {
            Level level = player.level();
            PregnantAnimal<?> pregnantAnimal = ENTITY_TO_PREGNANCY.get(livingEntity.getType()).create(level, EntitySpawnReason.NATURAL);
            if (livingEntity instanceof AgeableMob ageableMob) {
                if (!ageableMob.isBaby()) {
                    CompoundTag compoundTag = new CompoundTag();
                    livingEntity.save(compoundTag);
                    ((LivingEntity) pregnantAnimal).load(compoundTag);
                    livingEntity.remove(Entity.RemovalReason.DISCARDED);
                    level.addFreshEntity((LivingEntity) pregnantAnimal);

                    pregnantAnimal.setPregnancyType(this.getPregnancyType());
                    if (this.applicableModelTypes != null) {
                        HolderGetter<ModelGene> coatTypeRegistry = pregnantAnimal.getLevel().holderLookup(FARegistries.MODEL_GENE);
                        pregnantAnimal.setOffspringModelType(coatTypeRegistry.getOrThrow(this.applicableModelTypes).getRandomElement(pregnantAnimal.getLevel().getRandom()).get());
                    }
                    pregnantAnimal.setRemainingPregnancyTime(0);
                    if (pregnantAnimal instanceof HungerAccessor hungerAccessor) {
                        hungerAccessor.setHunger(((HungerAccessor) pregnantAnimal).getHunger());
                    }
                    if (pregnantAnimal instanceof TameAccessor tameAccessor) {
                        tameAccessor.setOwnerUUID(((TameAccessor) pregnantAnimal).getOwnerUUID());
                    }
                    itemStack.shrink(1);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.PASS;
                }
            } else {
                CompoundTag compoundTag = new CompoundTag();
                livingEntity.save(compoundTag);
                ((LivingEntity) pregnantAnimal).load(compoundTag);
                livingEntity.remove(Entity.RemovalReason.DISCARDED);
                level.addFreshEntity((LivingEntity) pregnantAnimal);

                pregnantAnimal.setPregnancyType(this.getPregnancyType());
                if (this.applicableModelTypes != null) {
                    HolderGetter<ModelGene> coatTypeRegistry = pregnantAnimal.getLevel().holderLookup(FARegistries.MODEL_GENE);
                    pregnantAnimal.setOffspringModelType(coatTypeRegistry.getOrThrow(this.applicableModelTypes).getRandomElement(pregnantAnimal.getLevel().getRandom()).get());
                }
                pregnantAnimal.setRemainingPregnancyTime(0);
                if (pregnantAnimal instanceof HungerAccessor hungerAccessor) {
                    hungerAccessor.setHunger(((HungerAccessor) pregnantAnimal).getHunger());
                }
                if (pregnantAnimal instanceof TameAccessor tameAccessor) {
                    tameAccessor.setOwnerUUID(((TameAccessor) pregnantAnimal).getOwnerUUID());
                }
                itemStack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }

    public Holder<PregnancyType> getPregnancyType() {
        return this.pregnancyType;
    }
}
