package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.entity.util.interfaces.HungerAccessor;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.util.interfaces.TameAccessor;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class SyringeItem extends Item {
    private final GeologicalTimeScale.Period period;
    private final Holder<PregnancyType> pregnancyType;
    protected final TagKey<ModelType> applicableModelTypes;

    public SyringeItem(GeologicalTimeScale.Period period, Holder<PregnancyType> pregnancyType, TagKey<ModelType> applicableModelTypes, Properties properties) {
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
            Holder<ModelType> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.coat_type", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (PregnantAnimal.getFromLivingEntity(livingEntity, player.level()) != null) {
            if (livingEntity instanceof AgeableMob ageableMob) {
                if (!ageableMob.isBaby()) {
                    PregnantAnimal<?> pregnantAnimal = PregnantAnimal.createFromLiving(livingEntity, player.level());
                    pregnantAnimal.setPregnancyType(this.getPregnancyType());
                    if (this.applicableModelTypes != null) {
                        HolderGetter<ModelType> coatTypeRegistry = pregnantAnimal.getLevel().holderLookup(FARegistries.MODEL_TYPES);
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
                PregnantAnimal<?> pregnantAnimal = PregnantAnimal.createFromLiving(livingEntity, player.level());
                pregnantAnimal.setPregnancyType(this.getPregnancyType());
                if (this.applicableModelTypes != null) {
                    HolderGetter<ModelType> coatTypeRegistry = pregnantAnimal.getLevel().holderLookup(FARegistries.MODEL_TYPES);
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
