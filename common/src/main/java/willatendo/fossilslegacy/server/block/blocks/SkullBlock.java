package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.Direction;

public class SkullBlock extends GenericSkullBlock {
    public SkullBlock(Properties properties) {
        super(properties);
        this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH);
    }
}
