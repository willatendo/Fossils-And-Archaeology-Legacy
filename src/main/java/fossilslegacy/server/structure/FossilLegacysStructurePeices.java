package fossilslegacy.server.structure;

import java.util.function.Supplier;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType.StructureTemplateType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FossilLegacysStructurePeices {
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPE = DeferredRegister.create(Registries.STRUCTURE_PIECE, FossilsLegacyUtils.ID);

	public static final RegistryObject<StructurePieceType> ACADEMY = register("academy", () -> AcademyPieces.AcademyStructurePiece::new);
	public static final RegistryObject<StructurePieceType> WEAPON_SHOP = register("weapon_shop", () -> WeaponShopPieces.WeaponShopPiece::new);

	public static RegistryObject<StructurePieceType> register(String id, Supplier<StructureTemplateType> structureTemplateType) {
		return STRUCTURE_PIECE_TYPE.register(id, structureTemplateType);
	}
}
