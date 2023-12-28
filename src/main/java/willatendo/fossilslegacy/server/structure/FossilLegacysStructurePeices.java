package willatendo.fossilslegacy.server.structure;

import java.util.function.Supplier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType.StructureTemplateType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilLegacysStructurePeices {
	public static final SimpleRegistry<StructurePieceType> STRUCTURE_PIECE_TYPE = SimpleRegistry.create(BuiltInRegistries.STRUCTURE_PIECE, FossilsLegacyUtils.ID);

	public static final RegistryHolder<StructureTemplateType> ACADEMY = register("academy", () -> AcademyPieces.AcademyStructurePiece::new);
	public static final RegistryHolder<StructureTemplateType> WEAPON_SHOP = register("weapon_shop", () -> WeaponShopPieces.WeaponShopPiece::new);

	public static RegistryHolder<StructureTemplateType> register(String id, Supplier<StructureTemplateType> structureTemplateType) {
		return STRUCTURE_PIECE_TYPE.register(id, structureTemplateType);
	}

	public static void init() {
	}
}
