package willatendo.fossilslegacy.server.dinopedia_entry.line;

import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;

import java.util.List;

public interface DinopediaLine {
    Codec<DinopediaLine> CODEC = FABuiltInRegistries.DINOPEDIA_LINE_TYPES.byNameCodec().dispatch(DinopediaLine::type, DinopediaLineType::codec);

    DinopediaLineType<?> type();

    void addText(List<Component> text, Entity entity, Player player);
}
