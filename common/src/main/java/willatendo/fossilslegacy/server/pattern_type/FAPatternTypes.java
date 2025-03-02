package willatendo.fossilslegacy.server.pattern_type;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.genetics.GeneticType;
import willatendo.fossilslegacy.server.pattern_type.information.CompositePatternInformation;
import willatendo.fossilslegacy.server.pattern_type.information.PackagePatternInformation;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public final class FAPatternTypes {
    public static final ResourceKey<PatternType> BASIC = FAPatternTypes.create("basic");

    private static ResourceKey<PatternType> create(String name) {
        return ResourceKey.create(FARegistries.PATTERN_TYPES, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<PatternType> bootstrapContext, ResourceKey<PatternType> resourceKey, PatternType patternType) {
        bootstrapContext.register(resourceKey, patternType);
    }

    private static void registerComposite(BootstrapContext<PatternType> bootstrapContext, ResourceKey<PatternType> resourceKey, GeneticType geneticType, int layer, String texturePath, TextureType... requiredTextures) {
        bootstrapContext.register(resourceKey, new PatternType(geneticType, new CompositePatternInformation(texturePath, layer, List.of(requiredTextures))));
    }

    private static void registerPackage(BootstrapContext<PatternType> bootstrapContext, ResourceKey<PatternType> resourceKey, GeneticType geneticType, String texturePath, TextureType... requiredTextures) {
        bootstrapContext.register(resourceKey, new PatternType(geneticType, new PackagePatternInformation(texturePath, List.of(requiredTextures))));
    }

    public static void bootstrap(BootstrapContext<PatternType> bootstrapContext) {
        FAPatternTypes.registerPackage(bootstrapContext, BASIC, GeneticType.DOMINANT, "", TextureType.BASE);
    }
}
