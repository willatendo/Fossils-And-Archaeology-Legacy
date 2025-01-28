package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;

public class SkullBlock extends GenericSkullBlock implements Equipable {
    public SkullBlock(Properties properties) {
        super(properties);
        this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
