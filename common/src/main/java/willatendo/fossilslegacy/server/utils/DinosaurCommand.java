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

public class DinosaurCommand implements StringRepresentable {
    public static final DinosaurCommand FOLLOW = new DinosaurCommand("follow");
    public static final DinosaurCommand STAY = new DinosaurCommand("stay");
    public static final DinosaurCommand FREE_MOVE = new DinosaurCommand("free_move");

    public static final Codec<DinosaurCommand> CODEC = Codec.STRING.xmap(DinosaurCommand::new, DinosaurCommand::getOrder);
    public static final StreamCodec<ByteBuf, DinosaurCommand> STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(DinosaurCommand::new, DinosaurCommand::getOrder);

    public static final Map<String, DinosaurCommand> COMMANDS = new HashMap<String, DinosaurCommand>();
    public static final List<DinosaurCommand> DINOSAUR_COMMANDS = new ArrayList<>();
    private final Component component;
    private final String order;

    private DinosaurCommand(String order) {
        this.order = order;
        this.component = FossilsLegacyUtils.translation("command", order);
        DINOSAUR_COMMANDS.add(this);
        COMMANDS.put(order, this);
    }

    public Component getComponent() {
        return this.component;
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
        return COMMANDS.get(compoundTag.getString("Command"));
    }

    public static DinosaurCommand getFromString(String order) {
        return COMMANDS.get(order);
    }
}
