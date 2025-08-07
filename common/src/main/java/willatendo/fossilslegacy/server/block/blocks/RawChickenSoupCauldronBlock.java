package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.cauldron.FACauldronInteraction;

public class RawChickenSoupCauldronBlock extends RawSoupCauldronBlock {
    public static final MapCodec<RawChickenSoupCauldronBlock> CODEC = Block.simpleCodec(RawChickenSoupCauldronBlock::new);

    public RawChickenSoupCauldronBlock(Properties properties) {
        super(FACauldronInteraction.RAW_CHICKEN_SOUP, properties);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> codec() {
        return CODEC;
    }
}
