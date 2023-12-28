package willatendo.fossilslegacy.server.structure;

import com.mojang.serialization.Codec;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilLegacyStructureTypes {
	public static final SimpleRegistry<StructureType<?>> STRUCTURE_TYPE = SimpleRegistry.create(BuiltInRegistries.STRUCTURE_TYPE, FossilsLegacyUtils.ID);

	public static final RegistryHolder<StructureType<AcademyStructure>> ACADEMY = STRUCTURE_TYPE.register("academy", () -> new StructureType<AcademyStructure>() {
		@Override
		public Codec<AcademyStructure> codec() {
			return AcademyStructure.CODEC;
		}
	});

	public static final RegistryHolder<StructureType<WeaponShopStructure>> WEAPON_SHOP = STRUCTURE_TYPE.register("weapon_shop", () -> new StructureType<WeaponShopStructure>() {
		@Override
		public Codec<WeaponShopStructure> codec() {
			return WeaponShopStructure.CODEC;
		}
	});

	public static void init() {
	}
}
