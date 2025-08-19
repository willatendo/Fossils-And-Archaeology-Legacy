package willatendo.fossilslegacy.server.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGene;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.function.Function;

public final class GeneRegistry extends SimpleRegistry<AttributeGene> {
    GeneRegistry(String modId) {
        super(FARegistries.ATTRIBUTE_GENE, modId);
    }

    public SimpleHolder<AttributeGene> registerGene(String id, Function<ResourceKey<AttributeGene>, AttributeGene> gene) {
        ResourceKey<AttributeGene> fullID = ResourceKey.create(this.registryKey, ResourceLocation.fromNamespaceAndPath(this.modId, id));
        return this.register(id, () -> gene.apply(fullID));
    }

    public static GeneRegistry createGene(String modId) {
        return new GeneRegistry(modId);
    }
}
