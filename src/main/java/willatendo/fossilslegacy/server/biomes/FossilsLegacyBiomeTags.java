package willatendo.fossilslegacy.server.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyBiomeTags {
	public static final TagRegister<Biome> BIOME_TAGS = SimpleUtils.create(Registries.BIOME, FossilsLegacyUtils.ID);

	public static final TagKey<Biome> HAS_ACADEMY = BIOME_TAGS.register("has_structure/academy");
	public static final TagKey<Biome> HAS_WEAPON_SHOP = BIOME_TAGS.register("has_structure/weapon_shop");
}
