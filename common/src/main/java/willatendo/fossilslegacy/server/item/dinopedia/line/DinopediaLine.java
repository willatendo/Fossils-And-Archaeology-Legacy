package willatendo.fossilslegacy.server.item.dinopedia.line;

import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.Dinosaur;

import java.util.List;

public interface DinopediaLine {
    Codec<DinopediaLine> CODEC = FossilsLegacyBuiltInRegistries.DINOPEDIA_LINE_TYPES.byNameCodec().dispatch(DinopediaLine::type, DinopediaLineType::codec);

    DinopediaLineType<?> type();

    void addText(List<Component> text, Dinosaur dinosaur, Player player);
}
