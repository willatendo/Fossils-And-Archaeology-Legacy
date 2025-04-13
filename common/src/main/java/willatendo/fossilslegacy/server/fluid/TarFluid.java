package willatendo.fossilslegacy.server.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.particles.FAParticleTypes;
import willatendo.fossilslegacy.server.tags.FAFluidTags;

import java.util.Optional;

public abstract class TarFluid extends FlowingFluid {
    @Override
    public Fluid getFlowing() {
        return FAFluids.FLOWING_TAR.get();
    }

    @Override
    public Fluid getSource() {
        return FAFluids.TAR.get();
    }

    @Override
    public Item getBucket() {
        return FAItems.TAR_BUCKET.get();
    }

    @Override
    public ParticleOptions getDripParticle() {
        return FAParticleTypes.DRIPPING_TAR.get();
    }

    @Override
    protected boolean canConvertToSource(ServerLevel serverLevel) {
        return serverLevel.getGameRules().getBoolean(FAGameRules.RULE_TAR_SOURCE_CONVERSION);
    }
    
    @Override
    protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        BlockEntity blockEntity = blockState.hasBlockEntity() ? levelAccessor.getBlockEntity(blockPos) : null;
        Block.dropResources(blockState, levelAccessor, blockPos, blockEntity);
    }

    @Override
    public int getSlopeFindDistance(LevelReader levelReader) {
        return 1;
    }

    @Override
    public BlockState createLegacyBlock(FluidState fluidState) {
        return FABlocks.TAR.get().defaultBlockState().setValue(LiquidBlock.LEVEL, FlowingFluid.getLegacyLevel(fluidState));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == FAFluids.TAR.get() || fluid == FAFluids.FLOWING_TAR.get();
    }

    @Override
    public int getDropOff(LevelReader levelReader) {
        return 7;
    }

    @Override
    public int getTickDelay(LevelReader levelReader) {
        return 50;
    }

    @Override
    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockReader, BlockPos blockPos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(FAFluidTags.TAR);
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }

    public static class Source extends TarFluid {
        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return 8;
        }
    }

    public static class Flowing extends TarFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(FlowingFluid.LEVEL);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(FlowingFluid.LEVEL);
        }
    }
}
