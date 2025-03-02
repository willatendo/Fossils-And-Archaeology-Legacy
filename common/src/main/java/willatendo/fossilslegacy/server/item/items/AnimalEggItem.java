package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.ThrownAnimalEgg;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.function.Supplier;

public class AnimalEggItem extends Item implements ProjectileItem {
    private final Supplier<EntityType<? extends Animal>> animal;
    private final GeologicalTimeScale.Period period;
    private final boolean incubated;
    private TagKey<ModelType> coatTypes;

    public AnimalEggItem(GeologicalTimeScale.Period period, Supplier<EntityType<? extends Animal>> animal, boolean incubated, Properties properties) {
        super(properties);
        this.period = period;
        this.animal = animal;
        this.incubated = incubated;
    }

    public AnimalEggItem(GeologicalTimeScale.Period period, Supplier<EntityType<? extends Animal>> animal, boolean incubated, TagKey<ModelType> coatTypes, Properties properties) {
        this(period, animal, incubated, properties);
        this.coatTypes = coatTypes;
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
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            ThrownAnimalEgg thrownAnimalEgg = new ThrownAnimalEgg(level, player, this.animal.get(), this.incubated, player.getItemInHand(interactionHand));
            if (this.coatTypes != null) {
                thrownAnimalEgg.setModelType(level.holderLookup(FARegistries.MODEL_TYPES).getOrThrow(this.coatTypes).getRandomElement(level.getRandom()).get());
            }
            thrownAnimalEgg.setItem(itemStack);
            thrownAnimalEgg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(thrownAnimalEgg);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemStack.consume(1, player);

        return InteractionResult.SUCCESS;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return new ThrownAnimalEgg(level, position.x(), position.y(), position.z(), this.animal.get(), this.incubated, itemStack);
    }
}
