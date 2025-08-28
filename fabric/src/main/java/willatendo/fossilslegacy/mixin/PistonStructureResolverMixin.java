package willatendo.fossilslegacy.mixin;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import willatendo.fossilslegacy.server.block.FABlocks;

@Mixin(PistonStructureResolver.class)
public class PistonStructureResolverMixin {
    @Inject(at = @At("HEAD"), method = "isSticky", cancellable = true)
    private static void isSticky(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.is(FABlocks.HARDENED_TAR_BLOCK.get())) {
            cir.setReturnValue(Boolean.valueOf(true));
        }
    }

    @Inject(at = @At("HEAD"), method = "canStickToEachOther", cancellable = true)
    private static void canStickToEachOther(BlockState blockState, BlockState otherBlockState, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.is(FABlocks.HARDENED_TAR_BLOCK.get())) {
            if (otherBlockState.is(Blocks.SLIME_BLOCK)) {
                cir.setReturnValue(Boolean.valueOf(false));
            }
            if (otherBlockState.is(Blocks.HONEY_BLOCK)) {
                cir.setReturnValue(Boolean.valueOf(false));
            }
        }
        if (blockState.is(Blocks.HONEY_BLOCK) && otherBlockState.is(FABlocks.HARDENED_TAR_BLOCK.get())) {
            cir.setReturnValue(Boolean.valueOf(false));
        } else if (blockState.is(Blocks.SLIME_BLOCK) && otherBlockState.is(FABlocks.HARDENED_TAR_BLOCK.get())) {
            cir.setReturnValue(Boolean.valueOf(false));
        }
    }
}
