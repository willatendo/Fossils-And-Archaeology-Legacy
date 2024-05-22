package willatendo.fossilslegacy.server.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import willatendo.fossilslegacy.server.structure.piece.WeaponShopPieces;

import java.util.Optional;

public class WeaponShopStructure extends Structure {
    public static final Codec<WeaponShopStructure> CODEC = simpleCodec(WeaponShopStructure::new);

    public WeaponShopStructure(Structure.StructureSettings structureSettings) {
        super(structureSettings);
    }

    @Override
    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext generationContext) {
        return onTopOfChunkCenter(generationContext, Heightmap.Types.WORLD_SURFACE_WG, (structurePiecesBuilder) -> {
            this.generatePieces(structurePiecesBuilder, generationContext);
        });
    }

    private void generatePieces(StructurePiecesBuilder structurePiecesBuilder, Structure.GenerationContext generationContext) {
        ChunkPos chunkPos = generationContext.chunkPos();
        WorldgenRandom worldgenRandom = generationContext.random();
        BlockPos blockPos = new BlockPos(chunkPos.getMinBlockX(), 90, chunkPos.getMinBlockZ());
        Rotation rotation = Rotation.getRandom(worldgenRandom);
        WeaponShopPieces.addPieces(generationContext.structureTemplateManager(), blockPos, rotation, structurePiecesBuilder, worldgenRandom);
    }

    @Override
    public StructureType<?> type() {
        return FossilsLegacyStructureTypes.WEAPON_SHOP.get();
    }
}