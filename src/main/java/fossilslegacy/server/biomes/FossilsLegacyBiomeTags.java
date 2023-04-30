package fossilslegacy.server.biomes;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class FossilsLegacyBiomeTags {
	public static final TagKey<Biome> HAS_ACADEMY = create("has_structure/academy");
	public static final TagKey<Biome> HAS_WEAPON_SHOP = create("has_structure/weapon_shop");

	public static TagKey<Biome> create(String name) {
		return TagKey.create(Registries.BIOME, FossilsLegacyUtils.resource(name));
	}
}
