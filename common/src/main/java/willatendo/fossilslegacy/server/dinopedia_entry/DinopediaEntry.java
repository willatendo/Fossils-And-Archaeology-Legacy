package willatendo.fossilslegacy.server.dinopedia_entry;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.dinopedia_entry.line.BuiltInDinopediaLines;
import willatendo.fossilslegacy.server.dinopedia_entry.line.CustomDinopediaLine;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLine;
import willatendo.fossilslegacy.server.dinopedia_entry.util.DinopediaEntityPredicate;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record DinopediaEntry(List<DinopediaLine> line, boolean drawEntity, boolean centerText, Optional<List<DisplayedItems>> displayedItems) {
    public static final Codec<DinopediaEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(DinopediaLine.CODEC).fieldOf("line").forGetter(DinopediaEntry::line), Codec.BOOL.optionalFieldOf("draw_entity", false).forGetter(DinopediaEntry::drawEntity), Codec.BOOL.optionalFieldOf("center_text", false).forGetter(DinopediaEntry::centerText), Codec.list(DisplayedItems.CODEC).optionalFieldOf("displayed_items").forGetter(DinopediaEntry::displayedItems)).apply(instance, DinopediaEntry::new));

    public List<Component> getText(Entity entity, Player player) {
        ArrayList<Component> text = new ArrayList<>();
        this.line.forEach(dinopediaLine -> dinopediaLine.addText(text, entity, player));
        return text;
    }

    public static Builder of() {
        return new Builder();
    }

    public record DisplayedItems(Component description, TagKey<Item> displayedItems) {
        public static final Codec<DinopediaEntry.DisplayedItems> CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("description").forGetter(DinopediaEntry.DisplayedItems::description), TagKey.codec(Registries.ITEM).fieldOf("displayed_items").forGetter(DinopediaEntry.DisplayedItems::displayedItems)).apply(instance, DinopediaEntry.DisplayedItems::new));
    }

    public static final class Builder {
        private final List<DinopediaLine> text = new ArrayList<>();
        private boolean drawEntity = false;
        private boolean centerText = false;
        private List<DinopediaEntry.DisplayedItems> displayedItems = new ArrayList<>();

        private Builder() {
        }

        public DinopediaEntry.Builder addText(BuiltInDinopediaLines... builtInDinopediaLines) {
            this.text.addAll(Arrays.asList(builtInDinopediaLines));
            return this;
        }

        public DinopediaEntry.Builder addText(Component... lines) {
            return this.addText(DinopediaEntityPredicate.Builder.always(), lines);
        }

        public DinopediaEntry.Builder addText(DinopediaEntityPredicate dinopediaEntityPredicate, Component... lines) {
            List<CustomDinopediaLine> customDinopediaLines = new ArrayList<>();
            for (Component text : lines) {
                customDinopediaLines.add(new CustomDinopediaLine(text, dinopediaEntityPredicate));
            }
            this.text.addAll(customDinopediaLines);
            return this;
        }

        public DinopediaEntry.Builder drawEntity() {
            this.drawEntity = true;
            return this;
        }

        public DinopediaEntry.Builder centerText() {
            this.centerText = true;
            return this;
        }

        public DinopediaEntry.Builder displayItems(Component component, TagKey<Item> displayedItems) {
            this.displayedItems.add(new DinopediaEntry.DisplayedItems(component, displayedItems));
            return this;
        }

        public DinopediaEntry build() {
            return new DinopediaEntry(this.text, this.drawEntity, this.centerText, this.displayedItems.isEmpty() ? Optional.empty() : Optional.of(this.displayedItems));
        }
    }
}
