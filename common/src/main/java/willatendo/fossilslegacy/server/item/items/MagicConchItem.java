package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAEntityTypeTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class MagicConchItem extends Item {
    public MagicConchItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        if (MagicConchItem.getOrder(itemStack) != null) {
            components.add(FAUtils.translation("item", BuiltInRegistries.ITEM.getKey(this).getPath() + ".desc", MagicConchItem.getOrder(itemStack).value().getDescription()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Holder<CommandType> commandType = MagicConchItem.getOrder(itemStack);
        if (commandType != null) {
            List<Dinosaur> dinosaurs = level.getEntitiesOfClass(Dinosaur.class, new AABB(player.blockPosition()).inflate(30.0D)).stream().filter(livingEntity -> livingEntity.getType().is(FAEntityTypeTags.MAGIC_CONCH_COMMANDABLE)).toList();
            for (Dinosaur dinosaur : dinosaurs) {
                if (dinosaur.isOwnedBy(player)) {
                    if (level.isClientSide()) {
                        level.addParticle(ParticleTypes.NOTE, dinosaur.getBlockX(), dinosaur.getBlockY() + 1.2D, dinosaur.getBlockZ(), 0.0D, 0.0D, 0.0D);
                    }
                    dinosaur.setCommand(commandType);
                }
            }

            player.startUsingItem(interactionHand);
            level.playSound(player, player, FASoundEvents.MAGIC_CONCH_BLOW.get(), SoundSource.RECORDS, 1.0F, commandType.value().getPitch());
            player.displayClientMessage(FAUtils.translation("command_type", "magic_conch.use", MagicConchItem.getOrder(itemStack).value().getDescription()), true);
            player.awardStat(Stats.ITEM_USED.get(this));
            level.gameEvent(GameEvent.INSTRUMENT_PLAY, player.position(), GameEvent.Context.of(player));
            player.getCooldowns().addCooldown(itemStack, 10);
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 140;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.TOOT_HORN;
    }

    public static Holder<CommandType> getOrder(ItemStack itemStack) {
        return itemStack.get(FADataComponents.COMMAND_TYPE.get());
    }

    public static void setOrder(ItemStack itemStack, Holder<CommandType> commandType) {
        itemStack.set(FADataComponents.COMMAND_TYPE.get(), commandType);
    }
}
