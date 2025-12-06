package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
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
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.entity.entities.DecorationPlaque;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.Optional;

public class DecorationPlaqueItem extends Item {
    public DecorationPlaqueItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (itemStack.has(FADataComponents.DECORATION_PLAQUE_TYPE.get())) {
            DecorationPlaqueType decorationPlaqueType = itemStack.get(FADataComponents.DECORATION_PLAQUE_TYPE.get()).value();
            tooltipComponents.add(FAUtils.translation("item", "decoration_plaque.type", decorationPlaqueType.translation()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        if (player.isCrouching()) {
            ItemStack itemStack = player.getMainHandItem();
            HolderLookup<DecorationPlaqueType> holderLookup = level.holderLookup(FARegistries.DECORATION_PLAQUE_TYPE);
            List<Holder.Reference<DecorationPlaqueType>> decorationPlaqueTypes = holderLookup.listElements().toList();
            if (itemStack.has(FADataComponents.DECORATION_PLAQUE_TYPE.get())) {
                int index = decorationPlaqueTypes.indexOf(itemStack.get(FADataComponents.DECORATION_PLAQUE_TYPE.get()));
                if (index + 1 < decorationPlaqueTypes.size()) {
                    itemStack.set(FADataComponents.DECORATION_PLAQUE_TYPE.get(), decorationPlaqueTypes.get(index + 1));
                } else {
                    itemStack.remove(FADataComponents.DECORATION_PLAQUE_TYPE.get());
                }
            } else {
                itemStack.set(FADataComponents.DECORATION_PLAQUE_TYPE.get(), decorationPlaqueTypes.getFirst());
            }
            player.setItemInHand(InteractionHand.MAIN_HAND, itemStack);
            return InteractionResult.SUCCESS;
        }
        return super.use(level, player, interactionHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        if (player != null && !player.isCrouching()) {
            BlockPos blockPos = useOnContext.getClickedPos();
            Direction direction = useOnContext.getClickedFace();
            BlockPos relativePos = blockPos.relative(direction);

            ItemStack itemStack = useOnContext.getItemInHand();
            if (player != null && !this.mayPlace(player, direction, itemStack, relativePos)) {
                if (direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack)) {
                    return super.useOn(useOnContext);
                }
                return InteractionResult.FAIL;
            } else {
                Level level = useOnContext.getLevel();
                DecorationPlaque decorationPlaque = null;
                Optional<DecorationPlaque> optionalDecorationPlaque = DecorationPlaque.create(level, relativePos, direction);
                if (!optionalDecorationPlaque.isEmpty()) {
                    decorationPlaque = optionalDecorationPlaque.get();
                }

                CustomData customData = itemStack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
                if (!customData.isEmpty()) {
                    EntityType.updateCustomEntityTag(level, player, decorationPlaque, customData);
                }

                if (decorationPlaque != null) {
                    if (itemStack.has(FADataComponents.DECORATION_PLAQUE_TYPE.get())) {
                        Holder<DecorationPlaqueType> decorationPlaqueType = itemStack.get(FADataComponents.DECORATION_PLAQUE_TYPE.get());
                        decorationPlaque.setVariant(decorationPlaqueType);
                    }
                    if (decorationPlaque.survives()) {
                        if (!level.isClientSide()) {
                            decorationPlaque.playPlacementSound();
                            level.gameEvent(player, GameEvent.ENTITY_PLACE, decorationPlaque.position());
                            level.addFreshEntity(decorationPlaque);
                        }

                        itemStack.shrink(1);
                        return InteractionResult.SUCCESS;
                    } else {
                        return InteractionResult.CONSUME;
                    }
                } else {
                    return InteractionResult.CONSUME;
                }
            }
        } else {
            return super.useOn(useOnContext);
        }
    }

    protected boolean mayPlace(Player player, Direction direction, ItemStack itemStack, BlockPos blockPos) {
        return !direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack);
    }
}
