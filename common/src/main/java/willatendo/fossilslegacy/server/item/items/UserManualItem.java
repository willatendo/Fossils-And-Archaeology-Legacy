package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.menu.menus.UserManuelMenu;
import willatendo.fossilslegacy.server.stats.FAStats;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;

public class UserManualItem extends Item {
    public UserManualItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(FAUtils.translation("item", "user_manuel.by").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        if (player instanceof ServerPlayer serverPlayer) {
            BlockPos blockPos = player.blockPosition();
            SimpleUtils.openContainer(new SimpleMenuProvider((windowId, inventory, playerIn) -> new UserManuelMenu(windowId, inventory, ContainerLevelAccess.create(level, blockPos)), Component.empty()), blockPos, serverPlayer);
            player.awardStat(FAStats.INTERACT_WITH_USER_MANUEL);
        }

        return InteractionResult.SUCCESS;
    }
}
