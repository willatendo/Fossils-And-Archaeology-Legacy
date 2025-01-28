package willatendo.fossilslegacy.server.command_type;

import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FACommandTypes {
    public static final SimpleRegistry<CommandType> COMMAND_TYPES = SimpleRegistry.create(FARegistries.COMMAND_TYPES, FossilsLegacyUtils.ID);

    public static final SimpleHolder<CommandType> FOLLOW = FACommandTypes.register("follow", 0);
    public static final SimpleHolder<CommandType> STAY = FACommandTypes.register("stay", 1);
    public static final SimpleHolder<CommandType> FREE_MOVE = FACommandTypes.register("free_move", 2);

    private static SimpleHolder<CommandType> register(String id, int code) {
        var commandType = COMMAND_TYPES.register(id, () -> new CommandType(id, code));
        CommandType.register(commandType, code, id);
        return commandType;
    }
}
