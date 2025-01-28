package willatendo.fossilslegacy.server.command_type;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Map;

public final class CommandType {
    public static final Map<Integer, Holder<CommandType>> COMMAND_TYPES_BY_CODE = Maps.newHashMap();
    public static final Map<String, Holder<CommandType>> COMMAND_TYPES_BY_STRING = Maps.newHashMap();

    public static final Codec<CommandType> DIRECT_CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.STRING.fieldOf("name").forGetter(CommandType::getName), Codec.INT.fieldOf("code").forGetter(CommandType::getCode)).apply(instance, CommandType::new));
    public static final Codec<Holder<CommandType>> CODEC = RegistryFileCodec.create(FARegistries.COMMAND_TYPES, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, CommandType> DIRECT_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, CommandType::getName, ByteBufCodecs.INT, CommandType::getCode, CommandType::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<CommandType>> STREAM_CODEC = ByteBufCodecs.holder(FARegistries.COMMAND_TYPES, DIRECT_STREAM_CODEC);

    private String descriptionId;
    private String name;
    private int code;

    public CommandType(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    private int getCode() {
        return this.code;
    }

    private String getOrCreateDescriptionId() {
        if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("command_type", FABuiltInRegistries.COMMAND_TYPES.getKey(this));
        }

        return this.descriptionId;
    }

    public Component getDescription() {
        return Component.translatable(this.getOrCreateDescriptionId());
    }

    public static Holder<CommandType> get(String commandType) {
        return COMMAND_TYPES_BY_CODE.getOrDefault(COMMAND_TYPES_BY_STRING.get(commandType).value().getCode(), FACommandTypes.FOLLOW);
    }

    public static Holder<CommandType> getNext(String commandType) {
        return COMMAND_TYPES_BY_CODE.getOrDefault(COMMAND_TYPES_BY_STRING.get(commandType).value().getCode() + 1, FACommandTypes.FOLLOW);
    }

    public static Holder<CommandType> getNext(Holder<CommandType> commandType) {
        return COMMAND_TYPES_BY_CODE.getOrDefault(commandType.value().getCode() + 1, FACommandTypes.FOLLOW);
    }

    public static void register(Holder<CommandType> commandType, int code, String name) {
        CommandType.COMMAND_TYPES_BY_CODE.put(code, commandType);
        CommandType.COMMAND_TYPES_BY_STRING.put(name, commandType);
    }
}
