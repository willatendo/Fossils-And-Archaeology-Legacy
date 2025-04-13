package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.Vec3;

public class TarBlock extends LiquidBlock {
    public TarBlock(FlowingFluid flowingFluid, Properties properties) {
        super(flowingFluid, properties);
    }

    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        Vec3 vec3 = new Vec3(0.25, 0.05000000074505806, 0.25);
        entity.makeStuckInBlock(state, vec3);
    }
}
