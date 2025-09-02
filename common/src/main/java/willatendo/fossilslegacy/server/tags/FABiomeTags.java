package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FABiomeTags {
    private static final TagRegister<Biome> BIOME_TAGS = TagRegister.create(Registries.BIOME, FAUtils.ID);

    public static final TagKey<Biome> HAS_ACADEMY = BIOME_TAGS.register("has_structure/academy");
    public static final TagKey<Biome> HAS_LAB = BIOME_TAGS.register("has_structure/lab");
    public static final TagKey<Biome> HAS_MACHU_PICCHU = BIOME_TAGS.register("has_structure/machu_picchu");
    public static final TagKey<Biome> HAS_MAYAN_TEMPLE = BIOME_TAGS.register("has_structure/mayan_temple");
    public static final TagKey<Biome> HAS_MOAI = BIOME_TAGS.register("has_structure/moai");
    public static final TagKey<Biome> HAS_PIRATE_SHIP = BIOME_TAGS.register("has_structure/pirate_ship");
    public static final TagKey<Biome> HAS_TOTEM_POLE = BIOME_TAGS.register("has_structure/totem_pole");
    public static final TagKey<Biome> HAS_WEAPON_SHOP = BIOME_TAGS.register("has_structure/weapon_shop");
}
