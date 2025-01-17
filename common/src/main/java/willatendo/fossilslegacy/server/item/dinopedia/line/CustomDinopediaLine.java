package willatendo.fossilslegacy.server.item.dinopedia.line;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.item.dinopedia.DinopediaEntityPredicate;

import java.util.List;

public record CustomDinopediaLine(Component text, DinopediaEntityPredicate canDisplay) implements DinopediaLine {
    public static final MapCodec<CustomDinopediaLine> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("text").forGetter(CustomDinopediaLine::text), DinopediaEntityPredicate.CODEC.fieldOf("can_display").forGetter(CustomDinopediaLine::canDisplay)).apply(instance, CustomDinopediaLine::new));

    @Override
    public DinopediaLineType<?> type() {
        return FossilsLegacyDinopediaLineTypes.CUSTOM.get();
    }

    @Override
    public void addText(List<Component> text, Dinosaur dinosaur, Player player) {
        if (this.canDisplay.matches(player, dinosaur)) {
            text.add(this.text);
        }
    }
}
