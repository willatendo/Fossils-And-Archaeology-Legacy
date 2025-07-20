package willatendo.fossilslegacy.server.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.Gene;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.function.Function;

public final class GeneRegistry extends SimpleRegistry<Gene> {
    GeneRegistry(String modId) {
        super(FARegistries.GENE, modId);
    }

    public SimpleHolder<Gene> registerGene(String id, Function<ResourceKey<Gene>, Gene> gene) {
        ResourceKey<Gene> fullID = ResourceKey.create(this.registryKey, ResourceLocation.fromNamespaceAndPath(this.modId, id));
        return this.register(id, () -> gene.apply(fullID));
    }

    public static GeneRegistry createGene(String modId) {
        return new GeneRegistry(modId);
    }
}
