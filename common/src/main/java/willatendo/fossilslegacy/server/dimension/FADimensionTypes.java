package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.OptionalLong;

public final class FADimensionTypes {
    public static final ResourceKey<DimensionType> ICE_AGE = FADimensionTypes.create("ice_age");
    public static final ResourceKey<DimensionType> PREHISTORY = FADimensionTypes.create("prehistory");

    public static ResourceKey<DimensionType> create(String name) {
        return ResourceKey.create(Registries.DIMENSION_TYPE, FAUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<DimensionType> bootstrapContext) {
        bootstrapContext.register(ICE_AGE, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0F, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
        bootstrapContext.register(PREHISTORY, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0F, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
    }
}
