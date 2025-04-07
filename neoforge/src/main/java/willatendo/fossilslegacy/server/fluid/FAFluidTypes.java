package willatendo.fossilslegacy.server.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAFluidTypes {
    public static final SimpleRegistry<FluidType> FLUID_TYPES = SimpleRegistry.create(NeoForgeRegistries.Keys.FLUID_TYPES, FAUtils.ID);

    public static final SimpleHolder<FluidType> TAR_TYPE = FLUID_TYPES.register("tar", () -> new FluidType(FluidType.Properties.create().descriptionId("block.fossilslegacy.tar").canSwim(false).pathType(PathType.WATER).fallDistanceModifier(0.0F).supportsBoating(true).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH).addDripstoneDripping(PointedDripstoneBlock.WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK, ParticleTypes.DRIPPING_DRIPSTONE_WATER, Blocks.WATER_CAULDRON, SoundEvents.POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON)) {
        @Override
        public boolean canConvertToSource(FluidState fluidState, LevelReader levelReader, BlockPos blockPos) {
            if (levelReader instanceof ServerLevel serverLevel) {
                return serverLevel.getGameRules().getBoolean(FAGameRules.RULE_TAR_SOURCE_CONVERSION);
            }
            return super.canConvertToSource(fluidState, levelReader, blockPos);
        }

        @Override
        public PathType getBlockPathType(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Mob mob, boolean canFluidLog) {
            return canFluidLog ? super.getBlockPathType(fluidState, blockGetter, blockPos, mob, true) : null;
        }
    });
}
