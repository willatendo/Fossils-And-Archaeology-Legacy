package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;

public class AmberBlock extends Block implements BeaconBeamBlock {
    public static final MapCodec<AmberBlock> CODEC = Block.simpleCodec(AmberBlock::new);

    public AmberBlock(Properties properties) {
        super(properties);
    }

    @Override
    public DyeColor getColor() {
        return DyeColor.ORANGE;
    }
}
