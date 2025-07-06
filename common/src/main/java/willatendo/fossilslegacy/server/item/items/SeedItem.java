package willatendo.fossilslegacy.server.item.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;

import java.util.List;

public class SeedItem extends Item {
    private final Block block;

    public SeedItem(Block block, Properties properties) {
        super(properties);
        this.block = block;
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));
        return !interactionResult.consumesAction() && useOnContext.getItemInHand().has(DataComponents.CONSUMABLE) ? super.use(useOnContext.getLevel(), useOnContext.getPlayer(), useOnContext.getHand()) : interactionResult;
    }

    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!this.getBlock().isEnabled(blockPlaceContext.getLevel().enabledFeatures())) {
            return InteractionResult.FAIL;
        } else if (!blockPlaceContext.canPlace()) {
            return InteractionResult.FAIL;
        } else {
            BlockPlaceContext updatedBlockPlaceContext = this.updatePlacementContext(blockPlaceContext);
            if (updatedBlockPlaceContext == null) {
                return InteractionResult.FAIL;
            } else {
                BlockState blockState = this.getPlacementState(updatedBlockPlaceContext);
                if (blockState == null) {
                    return InteractionResult.FAIL;
                } else if (!this.placeBlock(updatedBlockPlaceContext, blockState)) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPos blockPos = updatedBlockPlaceContext.getClickedPos();
                    Level level = updatedBlockPlaceContext.getLevel();
                    Player player = updatedBlockPlaceContext.getPlayer();
                    ItemStack itemStack = updatedBlockPlaceContext.getItemInHand();
                    BlockState blockStateAt = level.getBlockState(blockPos);
                    if (blockStateAt.is(blockState.getBlock())) {
                        blockStateAt = this.updateBlockStateFromTag(blockPos, level, itemStack, blockStateAt);
                        this.updateCustomBlockEntityTag(blockPos, level, player, itemStack, blockStateAt);
                        updateBlockEntityComponents(level, blockPos, itemStack);
                        blockStateAt.getBlock().setPlacedBy(level, blockPos, blockStateAt, player, itemStack);
                        if (player instanceof ServerPlayer serverPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, blockPos, itemStack);
                        }
                    }

                    SoundType soundType = blockStateAt.getSoundType();
                    level.playSound(player, blockPos, this.getPlaceSound(blockStateAt), SoundSource.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
                    level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(player, blockStateAt));
                    itemStack.consume(1, player);
                    return InteractionResult.SUCCESS;
                }
            }
        }
    }

    protected SoundEvent getPlaceSound(BlockState state) {
        return state.getSoundType().getPlaceSound();
    }


    public BlockPlaceContext updatePlacementContext(BlockPlaceContext blockPlaceContext) {
        return blockPlaceContext;
    }

    private static void updateBlockEntityComponents(Level level, BlockPos blockPos, ItemStack itemStack) {
        BlockEntity blockentity = level.getBlockEntity(blockPos);
        if (blockentity != null) {
            blockentity.applyComponentsFromItemStack(itemStack);
            blockentity.setChanged();
        }
    }

    protected boolean updateCustomBlockEntityTag(BlockPos blockPos, Level level, Player player, ItemStack itemStack, BlockState blockState) {
        return SeedItem.updateCustomBlockEntityTag(level, player, blockPos, itemStack);
    }


    protected BlockState getPlacementState(BlockPlaceContext blockPlaceContext) {
        BlockState blockState = this.getBlock().getStateForPlacement(blockPlaceContext);
        return blockState != null && this.canPlace(blockPlaceContext, blockState) ? blockState : null;
    }

    private BlockState updateBlockStateFromTag(BlockPos blockPos, Level level, ItemStack itemStack, BlockState blockState) {
        BlockItemStateProperties blockItemStateProperties = itemStack.getOrDefault(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY);
        if (blockItemStateProperties.isEmpty()) {
            return blockState;
        } else {
            BlockState appliedBlockState = blockItemStateProperties.apply(blockState);
            if (appliedBlockState != blockState) {
                level.setBlock(blockPos, appliedBlockState, 2);
            }

            return appliedBlockState;
        }
    }

    protected boolean canPlace(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        Player player = blockPlaceContext.getPlayer();
        CollisionContext collisionContext = player == null ? CollisionContext.empty() : CollisionContext.of(player);
        return (!this.mustSurvive() || blockState.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) && blockPlaceContext.getLevel().isUnobstructed(blockState, blockPlaceContext.getClickedPos(), collisionContext);
    }

    protected boolean mustSurvive() {
        return true;
    }

    protected boolean placeBlock(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        return blockPlaceContext.getLevel().setBlock(blockPlaceContext.getClickedPos(), blockState, 11);
    }

    public static boolean updateCustomBlockEntityTag(Level level, Player player, BlockPos blockPos, ItemStack itemStack) {
        if (level.isClientSide) {
            return false;
        } else {
            CustomData customData = itemStack.getOrDefault(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY);
            if (!customData.isEmpty()) {
                BlockEntityType<?> blockentitytype = customData.parseEntityType(level.registryAccess(), Registries.BLOCK_ENTITY_TYPE);
                if (blockentitytype == null) {
                    return false;
                }

                BlockEntity blockEntity = level.getBlockEntity(blockPos);
                if (blockEntity != null) {
                    BlockEntityType<?> blockEntityType = blockEntity.getType();
                    if (blockEntityType != blockentitytype) {
                        return false;
                    }

                    if (blockEntityType.onlyOpCanSetNbt() && (player == null || !player.canUseGameMasterBlocks())) {
                        return false;
                    }

                    return customData.loadInto(blockEntity, level.registryAccess());
                }
            }

            return false;
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> tooltips, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltips, tooltipFlag);
        this.getBlock().appendHoverText(itemStack, tooltipContext, tooltips, tooltipFlag);
    }

    @Override
    public boolean shouldPrintOpWarning(ItemStack itemStack, Player player) {
        if (player != null && player.getPermissionLevel() >= 2) {
            CustomData customData = itemStack.get(DataComponents.BLOCK_ENTITY_DATA);
            if (customData != null) {
                BlockEntityType<?> blockEntityType = customData.parseEntityType(player.level().registryAccess(), Registries.BLOCK_ENTITY_TYPE);
                return blockEntityType != null && blockEntityType.onlyOpCanSetNbt();
            }
        }

        return false;
    }

    public Block getBlock() {
        return this.block;
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return !(this.getBlock() instanceof ShulkerBoxBlock);
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity) {
        ItemContainerContents itemContainerContents = itemEntity.getItem().set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        if (itemContainerContents != null) {
            ItemUtils.onContainerDestroyed(itemEntity, itemContainerContents.nonEmptyItemsCopy());
        }
    }

    @Override
    public FeatureFlagSet requiredFeatures() {
        return this.getBlock().requiredFeatures();
    }
}
