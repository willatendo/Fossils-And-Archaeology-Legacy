package willatendo.fossilslegacy.server.dinopedia_entry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.dinopedia_entry.line.BuiltInDinopediaLines;
import willatendo.fossilslegacy.server.dinopedia_entry.line.CustomDinopediaLine;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLine;
import willatendo.fossilslegacy.server.dinopedia_entry.util.DinopediaEntityPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record DinopediaEntry(List<DinopediaLine> line, boolean drawEntity, boolean centerText) {
    public static final Codec<DinopediaEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(DinopediaLine.CODEC).fieldOf("line").forGetter(DinopediaEntry::line), Codec.BOOL.optionalFieldOf("draw_entity", false).forGetter(DinopediaEntry::drawEntity), Codec.BOOL.optionalFieldOf("center_text", false).forGetter(DinopediaEntry::centerText)).apply(instance, DinopediaEntry::new));

    public List<Component> getText(Entity entity, Player player) {
        ArrayList<Component> text = new ArrayList<>();
        this.line.forEach(dinopediaLine -> dinopediaLine.addText(text, entity, player));
        return text;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final List<DinopediaLine> text = new ArrayList<>();
        private boolean drawEntity = false;
        private boolean centerText = false;

        private Builder() {
        }

        public Builder addText(BuiltInDinopediaLines... builtInDinopediaLines) {
            this.text.addAll(Arrays.asList(builtInDinopediaLines));
            return this;
        }

        public Builder addText(Component... lines) {
            return this.addText(DinopediaEntityPredicate.Builder.always(), lines);
        }

        public Builder addText(DinopediaEntityPredicate dinopediaEntityPredicate, Component... lines) {
            List<CustomDinopediaLine> customDinopediaLines = new ArrayList<>();
            for (Component text : lines) {
                customDinopediaLines.add(new CustomDinopediaLine(text, dinopediaEntityPredicate));
            }
            this.text.addAll(customDinopediaLines);
            return this;
        }

        public Builder drawEntity() {
            this.drawEntity = true;
            return this;
        }

        public Builder centerText() {
            this.centerText = true;
            return this;
        }

        public DinopediaEntry build() {
            return new DinopediaEntry(this.text, this.drawEntity, this.centerText);
        }
    }
}
