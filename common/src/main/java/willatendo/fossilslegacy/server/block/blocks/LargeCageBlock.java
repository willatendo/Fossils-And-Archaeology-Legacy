package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;

public class LargeCageBlock extends Block {
    public static final MapCodec<LargeCageBlock> CODEC = Block.simpleCodec(LargeCageBlock::new);

    public LargeCageBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
