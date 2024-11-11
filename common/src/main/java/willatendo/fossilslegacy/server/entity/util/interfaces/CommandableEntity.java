package willatendo.fossilslegacy.server.entity.util.interfaces;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;

public interface CommandableEntity extends SimpleRegistryAccessAccessor {
    MapCodec<Holder<CommandType>> VARIANT_MAP_CODEC = CommandType.CODEC.fieldOf("CommandType");
    Codec<Holder<CommandType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

    Holder<CommandType> getCommand();

    void setCommand(Holder<CommandType> dinosaurOrder);

    CommandingType commandItems();

    default boolean isOrderedToSit() {
        return this.getCommand().is(FossilsLegacyCommandTypes.STAY.getKey());
    }

    default boolean willListenToDrum(Player player, InteractionHand interactionHand) {
        return this.commandItems().canCommandWithItem(player.getItemInHand(interactionHand));
    }

    default void addCommandType(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.getRegistryAccess().createSerializationContext(NbtOps.INSTANCE), this.getCommand()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
    }

    default void readCommandType(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.getRegistryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setCommand);
    }
}
