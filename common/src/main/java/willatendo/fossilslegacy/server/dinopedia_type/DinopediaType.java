package willatendo.fossilslegacy.server.dinopedia_type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.dinopedia_entry.DinopediaEntry;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;

public record DinopediaType(List<ResourceKey<DinopediaEntry>> dinopediaEntries) {
    public static final Codec<DinopediaType> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(ResourceKey.codec(FARegistries.DINOPEDIA_ENTRY)).fieldOf("dinopedia_entries").forGetter(DinopediaType::dinopediaEntries)).apply(instance, DinopediaType::new));
}
