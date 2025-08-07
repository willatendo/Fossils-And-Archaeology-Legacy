package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.cauldron.FACauldronInteraction;

public class CookedChickenSoupCauldronBlock extends RawSoupCauldronBlock {
    public static final MapCodec<CookedChickenSoupCauldronBlock> CODEC = Block.simpleCodec(CookedChickenSoupCauldronBlock::new);

    public CookedChickenSoupCauldronBlock(Properties properties) {
        super(FACauldronInteraction.COOKED_CHICKEN_SOUP, properties);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> codec() {
        return CODEC;
    }
}
