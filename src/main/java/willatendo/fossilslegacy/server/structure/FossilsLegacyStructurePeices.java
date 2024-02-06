package willatendo.fossilslegacy.server.structure;

import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType.StructureTemplateType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyStructurePeices {
	public static final SimpleRegistry<StructurePieceType> STRUCTURE_PIECE_TYPE = SimpleRegistry.create(Registries.STRUCTURE_PIECE, FossilsLegacyUtils.ID);

	public static final SimpleHolder<StructureTemplateType> ACADEMY = register("academy", () -> AcademyPieces.AcademyStructurePiece::new);
	public static final SimpleHolder<StructureTemplateType> WEAPON_SHOP = register("weapon_shop", () -> WeaponShopPieces.WeaponShopPiece::new);

	public static SimpleHolder<StructureTemplateType> register(String id, Supplier<StructureTemplateType> structureTemplateType) {
		return STRUCTURE_PIECE_TYPE.register(id, structureTemplateType);
	}

	public static void init() {
		FabricRegister.register(STRUCTURE_PIECE_TYPE);
	}
}
