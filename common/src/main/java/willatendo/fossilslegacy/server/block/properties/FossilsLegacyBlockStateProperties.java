package willatendo.fossilslegacy.server.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class FossilsLegacyBlockStateProperties {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public static final StringProperty COMMAND_TYPE = StringProperty.create("command_type", "follow", "stay", "free_move");
}
