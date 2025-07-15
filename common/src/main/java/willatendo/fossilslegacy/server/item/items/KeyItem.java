package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.block.entity.entities.CageBlockEntity;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.UUID;

public class KeyItem extends Item {
    public KeyItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.LOCK.get())) {
            tooltipComponents.add(FAUtils.translation("item", "key.bound").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        ItemStack itemStack = useOnContext.getItemInHand();
        if (!itemStack.has(FADataComponents.LOCK.get())) {
            BlockPos blockPos = useOnContext.getClickedPos();
            Level level = useOnContext.getLevel();
            Player player = useOnContext.getPlayer();
            if (player.isCrouching() && level instanceof ServerLevel && level.getBlockEntity(blockPos) instanceof CageBlockEntity cageBlockEntity) {
                if (cageBlockEntity.getLock() == null) {
                    UUID lock = UUID.randomUUID();
                    cageBlockEntity.setLock(lock);
                    if (itemStack.getCount() == 1) {
                        itemStack.set(FADataComponents.LOCK.get(), lock);
                    } else {
                        ItemStack newItemStack = new ItemStack(itemStack.getItem());
                        newItemStack.set(FADataComponents.LOCK.get(), lock);
                        ItemUtils.createFilledResult(itemStack, player, newItemStack);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(useOnContext);
    }
}
