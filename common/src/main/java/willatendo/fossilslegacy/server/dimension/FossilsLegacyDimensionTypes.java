package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.OptionalLong;

public class FossilsLegacyDimensionTypes {
    public static final ResourceKey<DimensionType> PREHISTORY = create("prehistory");

    public static ResourceKey<DimensionType> create(String name) {
        return ResourceKey.create(Registries.DIMENSION_TYPE, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstapContext<DimensionType> bootstapContext) {
        bootstapContext.register(PREHISTORY, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0F, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
    }
}
