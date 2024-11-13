package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyBiomeTags {
    private static final TagRegister<Biome> BIOME_TAGS = TagRegister.create(Registries.BIOME, FossilsLegacyUtils.ID);

    public static final TagKey<Biome> HAS_ACADEMY = BIOME_TAGS.register("has_structure/academy");
    public static final TagKey<Biome> HAS_MAYAN_TEMPLE = BIOME_TAGS.register("has_structure/mayan_temple");
    public static final TagKey<Biome> HAS_MOAI = BIOME_TAGS.register("has_structure/moai");
    public static final TagKey<Biome> HAS_TOTEM_POLE = BIOME_TAGS.register("has_structure/totem_pole");
    public static final TagKey<Biome> HAS_WEAPON_SHOP = BIOME_TAGS.register("has_structure/weapon_shop");
}
