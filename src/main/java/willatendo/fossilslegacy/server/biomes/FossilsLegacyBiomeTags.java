package willatendo.fossilslegacy.server.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyBiomeTags {
	public static final TagKey<Biome> HAS_ACADEMY = create("has_structure/academy");
	public static final TagKey<Biome> HAS_WEAPON_SHOP = create("has_structure/weapon_shop");

	public static TagKey<Biome> create(String name) {
		return TagKey.create(Registries.BIOME, FossilsLegacyUtils.resource(name));
	}
}
