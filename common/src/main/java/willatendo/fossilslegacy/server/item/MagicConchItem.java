package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.entity.util.CommandType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class MagicConchItem extends Item {
    public MagicConchItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        if (MagicConchItem.getOrder(itemStack) != null) {
            components.add(FossilsLegacyUtils.translation("item", BuiltInRegistries.ITEM.getKey(this).getPath() + ".desc", MagicConchItem.getOrder(itemStack).getComponent()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (MagicConchItem.getOrder(itemStack) != null) {
            player.getCooldowns().addCooldown(this, 10);

            for (Futabasaurus plesiosaurus : level.getEntitiesOfClass(Futabasaurus.class, new AABB(player.blockPosition()).inflate(30.0D))) {
                if (plesiosaurus.isOwnedBy(player)) {
                    if (level.isClientSide()) {
                        level.addParticle(ParticleTypes.NOTE, plesiosaurus.getBlockX(), plesiosaurus.getBlockY() + 1.2D, plesiosaurus.getBlockZ(), 0.0D, 0.0D, 0.0D);
                    }
                    plesiosaurus.setCommand(MagicConchItem.getOrder(itemStack));
                }
            }

            player.startUsingItem(interactionHand);
            player.sendSystemMessage(FossilsLegacyUtils.translation("item", "magic_conch.use", MagicConchItem.getOrder(itemStack).getComponent()));
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 140;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }

    public static CommandType getOrder(ItemStack itemStack) {
        return itemStack.get(FossilsLegacyDataComponents.COMMAND_TYPE.get());
    }

    public static void setOrder(ItemStack itemStack, CommandType commandType) {
        itemStack.set(FossilsLegacyDataComponents.COMMAND_TYPE.get(), commandType);
    }
}
