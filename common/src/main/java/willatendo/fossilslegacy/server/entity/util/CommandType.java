package willatendo.fossilslegacy.server.entity.util;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;

public record CommandType(String name, int id) implements StringRepresentable {
    public static final List<CommandType> COMMAND_TYPES = Lists.newArrayList();
    private static final Map<String, CommandType> STRING_TO_COMMAND = Maps.newHashMap();
    private static final Map<CommandType, String> COMMAND_TO_STRING = Maps.newHashMap();
    private static final Map<Integer, CommandType> INTEGER_TO_COMMAND = Maps.newHashMap();
    private static final Map<CommandType, Integer> COMMAND_TO_INTEGER = Maps.newHashMap();

    public static final Codec<CommandType> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.STRING.fieldOf("name").forGetter(CommandType::name), Codec.INT.fieldOf("id").forGetter(CommandType::id)).apply(instance, CommandType::new));
    public static final StreamCodec<ByteBuf, CommandType> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, CommandType::name, ByteBufCodecs.INT, CommandType::id, CommandType::new);

    public static CommandType FOLLOW;
    public static CommandType STAY;
    public static CommandType FREE_MOVE;

    public static CommandType getRandom() {
        return COMMAND_TYPES.get(RandomSource.create().nextInt(COMMAND_TYPES.size()));
    }

    public static CommandType get(String name) {
        return STRING_TO_COMMAND.get(name);
    }

    public static CommandType get(int id) {
        return INTEGER_TO_COMMAND.get(id);
    }

    public static String getName(CommandType commandType) {
        return COMMAND_TO_STRING.get(commandType);
    }

    public static int getId(CommandType commandType) {
        return COMMAND_TO_INTEGER.get(commandType);
    }

    public static CommandType getNext(CommandType commandType) {
        if (commandType.id() + 1 < STRING_TO_COMMAND.size()) {
            return INTEGER_TO_COMMAND.get(commandType.id() + 1);
        } else {
            return INTEGER_TO_COMMAND.get(0);
        }
    }

    public static void save(CompoundTag compoundTag, CommandType commandType) {
        compoundTag.putString("command", commandType.getSerializedName());
    }

    public static CommandType load(CompoundTag compoundTag) {
        return STRING_TO_COMMAND.getOrDefault(compoundTag.getString("command"), STAY);
    }

    public static void register() {
        int id = 0;
        FOLLOW = CommandType.register("follow", id++);
        STAY = CommandType.register("stay", id++);
        FREE_MOVE = CommandType.register("free_move", id++);
    }

    private static CommandType register(String name, int id) {
        if (id > -1 && !STRING_TO_COMMAND.containsKey(name) && !INTEGER_TO_COMMAND.containsKey(id)) {
            CommandType commandType = new CommandType(name, id);
            COMMAND_TYPES.add(commandType);
            STRING_TO_COMMAND.put(name, commandType);
            COMMAND_TO_STRING.put(commandType, name);
            INTEGER_TO_COMMAND.put(id, commandType);
            COMMAND_TO_INTEGER.put(commandType, id);
            return commandType;
        } else {
            FossilsLegacyUtils.LOGGER.info("Cannot register CommandType {} as its already exists or {} is already used!", name, id);
            return null;
        }
    }

    public Component getComponent() {
        return FossilsLegacyUtils.translation("command", this.name());
    }

    @Override
    public String getSerializedName() {
        return this.name();
    }
}
