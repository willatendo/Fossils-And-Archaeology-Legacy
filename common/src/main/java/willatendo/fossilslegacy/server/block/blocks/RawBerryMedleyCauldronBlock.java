package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.cauldron.FACauldronInteraction;

public class RawBerryMedleyCauldronBlock extends RawSoupCauldronBlock {
    public static final MapCodec<RawBerryMedleyCauldronBlock> CODEC = Block.simpleCodec(RawBerryMedleyCauldronBlock::new);

    public RawBerryMedleyCauldronBlock(Properties properties) {
        super(FACauldronInteraction.RAW_BERRY_MEDLEY, properties);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> codec() {
        return CODEC;
    }
}
