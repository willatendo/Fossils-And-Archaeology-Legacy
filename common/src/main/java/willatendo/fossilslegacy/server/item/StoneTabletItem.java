package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.entity.StoneTablet;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Optional;

public class StoneTabletItem extends Item {
    private static final Component TOOLTIP_RANDOM_VARIANT = FossilsLegacyUtils.translation("stone_tablet", "random").withStyle(ChatFormatting.GRAY);

    public StoneTabletItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        BlockPos blockPos = useOnContext.getClickedPos();
        Direction direction = useOnContext.getClickedFace();
        BlockPos relativePos = blockPos.relative(direction);
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();
        if (player != null && !this.mayPlace(player, direction, itemStack, relativePos)) {
            return InteractionResult.FAIL;
        } else {
            Level level = useOnContext.getLevel();
            StoneTablet hangingEntity = null;
            Optional<StoneTablet> stoneTablet = StoneTablet.create(level, relativePos, direction);
            if (!stoneTablet.isEmpty()) {
                hangingEntity = stoneTablet.get();
            }

            CustomData customData = itemStack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
            if (!customData.isEmpty()) {
                EntityType.updateCustomEntityTag(level, player, hangingEntity, customData);
            }

            if (hangingEntity != null) {
                if (hangingEntity.survives()) {
                    if (!level.isClientSide()) {
                        hangingEntity.playPlacementSound();
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingEntity.position());
                        level.addFreshEntity(hangingEntity);
                    }

                    itemStack.shrink(1);
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    return InteractionResult.CONSUME;
                }
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    protected boolean mayPlace(Player player, Direction direction, ItemStack itemStack, BlockPos blockPos) {
        return !direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> toolTips, TooltipFlag toolTipFlag) {
        super.appendHoverText(itemStack, tooltipContext, toolTips, toolTipFlag);
        CustomData customData = itemStack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
        if (!customData.isEmpty()) {
            customData.read(StoneTablet.VARIANT_MAP_CODEC).result().ifPresentOrElse(holder -> {
                holder.unwrapKey().ifPresent((resourceKey) -> {
                    toolTips.add(holder.value().getName().withStyle(ChatFormatting.YELLOW));
                    toolTips.add(holder.value().getAuthor().withStyle(ChatFormatting.GRAY));
                });
                toolTips.add(Component.translatable("painting.dimensions", Mth.positiveCeilDiv(holder.value().width(), 16), Mth.positiveCeilDiv(holder.value().height(), 16)));
            }, () -> {
                toolTips.add(TOOLTIP_RANDOM_VARIANT);
            });
        } else if (toolTipFlag.isCreative()) {
            toolTips.add(TOOLTIP_RANDOM_VARIANT);
        }
    }
}
