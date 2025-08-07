package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.cauldron.FACauldronInteraction;

public class CookedBerryMedleyCauldronBlock extends RawSoupCauldronBlock {
    public static final MapCodec<CookedBerryMedleyCauldronBlock> CODEC = Block.simpleCodec(CookedBerryMedleyCauldronBlock::new);

    public CookedBerryMedleyCauldronBlock(Properties properties) {
        super(FACauldronInteraction.COOKED_BERRY_MEDLEY, properties);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> codec() {
        return CODEC;
    }
}
