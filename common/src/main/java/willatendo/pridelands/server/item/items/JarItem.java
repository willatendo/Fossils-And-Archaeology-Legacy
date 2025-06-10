package willatendo.pridelands.server.item.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import willatendo.pridelands.server.item.PridelandsItems;

import java.util.HashMap;
import java.util.Map;

public class JarItem extends Item implements DispensibleContainerItem {
    public static final Map<Item, Item> FLUID_TO_JAR = new HashMap<>();
    public final Fluid content;

    public JarItem(Fluid content, Properties properties) {
        super(properties);
        this.content = content;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        BlockHitResult blockHitResult = Item.getPlayerPOVHitResult(level, player, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return InteractionResult.PASS;
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResult.PASS;
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getDirection();
            BlockPos relativeBlockPos = blockPos.relative(direction);
            if (level.mayInteract(player, blockPos) && player.mayUseItemAt(relativeBlockPos, direction, itemStack)) {
                BlockState blockState;
                ItemStack bucketItemStack;
                if (this.content == Fluids.EMPTY) {
                    blockState = level.getBlockState(blockPos);
                    Block block = blockState.getBlock();
                    if (block instanceof BucketPickup bucketPickup) {
                        ItemStack pickup = bucketPickup.pickupBlock(player, level, blockPos, blockState);
                        bucketItemStack = pickup.isEmpty() ? ItemStack.EMPTY : new ItemStack(FLUID_TO_JAR.get(pickup.getItem()));
                        if (!bucketItemStack.isEmpty()) {
                            player.awardStat(Stats.ITEM_USED.get(this));
                            bucketPickup.getPickupSound().ifPresent(soundEvent -> player.playSound(soundEvent, 1.0F, 1.0F));
                            level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);
                            ItemStack filledResult = ItemUtils.createFilledResult(itemStack, player, bucketItemStack);
                            if (!level.isClientSide) {
                                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, bucketItemStack);
                            }

                            return InteractionResult.SUCCESS.heldItemTransformedTo(filledResult);
                        }
                    }

                    return InteractionResult.FAIL;
                } else {
                    blockState = level.getBlockState(blockPos);
                    BlockPos blockStateBlockPos = blockState.getBlock() instanceof LiquidBlockContainer && this.content == Fluids.WATER ? blockPos : relativeBlockPos;
                    if (this.emptyContents(player, level, blockStateBlockPos, blockHitResult)) {
                        this.checkExtraContent(player, level, itemStack, blockStateBlockPos);
                        if (player instanceof ServerPlayer serverPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, blockStateBlockPos, itemStack);
                        }

                        player.awardStat(Stats.ITEM_USED.get(this));
                        bucketItemStack = ItemUtils.createFilledResult(itemStack, player, getEmptySuccessItem(itemStack, player));
                        return InteractionResult.SUCCESS.heldItemTransformedTo(bucketItemStack);
                    } else {
                        return InteractionResult.FAIL;
                    }
                }
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    public static ItemStack getEmptySuccessItem(ItemStack bucketItemStack, Player player) {
        return !player.hasInfiniteMaterials() ? new ItemStack(PridelandsItems.PRIDESTONE_JAR.get()) : bucketItemStack;
    }

    @Override
    public void checkExtraContent(Player player, Level level, ItemStack itemStack, BlockPos blockPos) {
    }

    @Override
    public boolean emptyContents(Player player, Level level, BlockPos blockPos, BlockHitResult blockHitResult) {
        if (!(this.content instanceof FlowingFluid flowingFluid)) {
            return false;
        } else {
            boolean canBeReplaced;
            BlockState blockState;
            boolean isAirOrCanBeReplaced;
            Block block;
            label72:
            {
                label71:
                {
                    blockState = level.getBlockState(blockPos);
                    block = blockState.getBlock();
                    canBeReplaced = blockState.canBeReplaced(this.content);
                    if (!blockState.isAir() && !canBeReplaced) {
                        if (!(block instanceof LiquidBlockContainer liquidBlockContainer)) {
                            break label71;
                        }

                        if (!liquidBlockContainer.canPlaceLiquid(player, level, blockPos, blockState, this.content)) {
                            break label71;
                        }
                    }

                    isAirOrCanBeReplaced = true;
                    break label72;
                }

                isAirOrCanBeReplaced = false;
            }

            if (!isAirOrCanBeReplaced) {
                return blockHitResult != null && this.emptyContents(player, level, blockHitResult.getBlockPos().relative(blockHitResult.getDirection()), null);
            } else if (level.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
                int x = blockPos.getX();
                int y = blockPos.getY();
                int z = blockPos.getZ();
                level.playSound(player, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.8F);

                for (int k = 0; k < 8; ++k) {
                    level.addParticle(ParticleTypes.LARGE_SMOKE, (double) x + Math.random(), (double) y + Math.random(), (double) z + Math.random(), 0.0, 0.0, 0.0);
                }

                return true;
            } else {
                if (block instanceof LiquidBlockContainer liquidBlockContainer) {
                    if (this.content == Fluids.WATER) {
                        liquidBlockContainer.placeLiquid(level, blockPos, blockState, flowingFluid.getSource(false));
                        this.playEmptySound(player, level, blockPos);
                        return true;
                    }
                }

                if (!level.isClientSide && canBeReplaced && !blockState.liquid()) {
                    level.destroyBlock(blockPos, true);
                }

                if (!level.setBlock(blockPos, this.content.defaultFluidState().createLegacyBlock(), 11) && !blockState.getFluidState().isSource()) {
                    return false;
                } else {
                    this.playEmptySound(player, level, blockPos);
                    return true;
                }
            }
        }
    }

    protected void playEmptySound(Player player, LevelAccessor levelAccessor, BlockPos blockPos) {
        SoundEvent soundEvent = this.content.is(FluidTags.LAVA) ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY;
        levelAccessor.playSound(player, blockPos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
        levelAccessor.gameEvent(player, GameEvent.FLUID_PLACE, blockPos);
    }
}
