package willatendo.fossilslegacy.server.utils;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public record DinosaurCommand(String order) implements StringRepresentable {
    public static final Map<String, DinosaurCommand> COMMANDS = new HashMap<String, DinosaurCommand>();
    public static final List<DinosaurCommand> DINOSAUR_COMMANDS = new ArrayList<>();

    public static final DinosaurCommand FOLLOW = DinosaurCommand.create("follow");
    public static final DinosaurCommand STAY = DinosaurCommand.create("stay");
    public static final DinosaurCommand FREE_MOVE = DinosaurCommand.create("free_move");

    public static final Codec<DinosaurCommand> CODEC = Codec.STRING.xmap(DinosaurCommand::new, DinosaurCommand::getOrder);
    public static final StreamCodec<ByteBuf, DinosaurCommand> STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(DinosaurCommand::new, DinosaurCommand::getOrder);

    private static DinosaurCommand create(String order) {
        DinosaurCommand dinosaurCommand = new DinosaurCommand(order);
        DINOSAUR_COMMANDS.add(dinosaurCommand);
        COMMANDS.put(order, dinosaurCommand);
        return dinosaurCommand;
    }

    public static List<DinosaurCommand> values() {
        return DINOSAUR_COMMANDS;
    }

    public Component getComponent() {
        return FossilsLegacyUtils.translation("command", this.order);
    }

    public String getOrder() {
        return this.order;
    }

    public static DinosaurCommand getRandom() {
        RandomSource randomSource = RandomSource.create();
        return DINOSAUR_COMMANDS.get(randomSource.nextInt(3));
    }

    @Override
    public String getSerializedName() {
        return this.order;
    }

    public static DinosaurCommand getNext(DinosaurCommand dinosaurOrder) {
        if (dinosaurOrder == STAY) {
            return FOLLOW;
        } else if (dinosaurOrder == FOLLOW) {
            return FREE_MOVE;
        } else if (dinosaurOrder == FREE_MOVE) {
            return STAY;
        } else {
            return null;
        }
    }

    @Deprecated
    public static void save(CompoundTag compoundTag, DinosaurCommand dinosaurCommand) {
        compoundTag.putString("Command", dinosaurCommand.getOrder());
    }


    @Deprecated
    public static DinosaurCommand load(CompoundTag compoundTag) {
        return COMMANDS.getOrDefault(compoundTag.getString("Command"), FREE_MOVE);
    }

    public static DinosaurCommand getFromString(String order) {
        return COMMANDS.get(order);
    }

    public static DinosaurCommand getFromInteger(int order) {
        return order == 1 ? FOLLOW : order == 2 ? STAY : FREE_MOVE;
    }

    public int getAsInt() {
        return this == FOLLOW ? 1 : this == STAY ? 2 : 3;
    }
}
