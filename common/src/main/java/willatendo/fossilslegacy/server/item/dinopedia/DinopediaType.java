package willatendo.fossilslegacy.server.item.dinopedia;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;

import java.util.List;

public record DinopediaType(List<ResourceKey<DinopediaEntry>> dinopediaEntries) {
    public static final Codec<DinopediaType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(ResourceKey.codec(FossilsLegacyRegistries.DINOPEDIA_ENTRY)).fieldOf("dinopedia_entries").forGetter(DinopediaType::dinopediaEntries)).apply(instance, DinopediaType::new));


}
