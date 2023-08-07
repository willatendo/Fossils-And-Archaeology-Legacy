package willatendo.fossilslegacy.server.structure;

import com.mojang.serialization.Codec;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilLegacyStructureTypes {
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registries.STRUCTURE_TYPE, FossilsLegacyUtils.ID);

	public static final RegistryObject<StructureType<AcademyStructure>> ACADEMY = STRUCTURE_TYPE.register("academy", () -> new StructureType<AcademyStructure>() {
		@Override
		public Codec<AcademyStructure> codec() {
			return AcademyStructure.CODEC;
		}
	});

	public static final RegistryObject<StructureType<WeaponShopStructure>> WEAPON_SHOP = STRUCTURE_TYPE.register("weapon_shop", () -> new StructureType<WeaponShopStructure>() {
		@Override
		public Codec<WeaponShopStructure> codec() {
			return WeaponShopStructure.CODEC;
		}
	});
}
