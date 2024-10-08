package willatendo.fossilslegacy.server.entity.commands;

import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyCommandTypes {
    public static final SimpleRegistry<CommandType> COMMAND_TYPES = SimpleRegistry.create(FossilsLegacyRegistries.COMMAND_TYPES, FossilsLegacyUtils.ID);

    public static final SimpleHolder<CommandType> FOLLOW = FossilsLegacyCommandTypes.register("follow", 0);
    public static final SimpleHolder<CommandType> STAY = FossilsLegacyCommandTypes.register("stay", 1);
    public static final SimpleHolder<CommandType> FREE_MOVE = FossilsLegacyCommandTypes.register("free_move", 2);

    private static SimpleHolder<CommandType> register(String id, int code) {
        return COMMAND_TYPES.register(id, () -> new CommandType(id, code));
    }
}
