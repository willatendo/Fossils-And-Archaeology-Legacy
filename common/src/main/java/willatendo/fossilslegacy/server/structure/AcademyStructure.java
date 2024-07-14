package willatendo.fossilslegacy.server.structure;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import willatendo.fossilslegacy.server.structure.holes.RelicHoleList;
import willatendo.fossilslegacy.server.structure.piece.AcademyPieces;

import java.util.List;
import java.util.Optional;

public class AcademyStructure extends Structure {
    public static final MapCodec<AcademyStructure> CODEC = simpleCodec(AcademyStructure::new);
    private RelicHoleList relicHoleList;

    public AcademyStructure(Structure.StructureSettings structureSettings) {
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
        AcademyPieces.addPieces(generationContext.structureTemplateManager(), blockPos, rotation, structurePiecesBuilder, worldgenRandom);
    }

    @Override
    public void afterPlace(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, PiecesContainer piecesContainer) {
        List<BlockPos> blockPoses = BlockPos.betweenClosedStream(piecesContainer.calculateBoundingBox()).toList();

        this.relicHoleList = new RelicHoleList(randomSource, blockPoses, 5, 3);
        blockPoses.forEach(blockPos -> {
            if (randomSource.nextInt(2) == 1) {
                if (worldGenLevel.getBlockState(blockPos).is(Blocks.BRICKS)) {
                    worldGenLevel.setBlock(blockPos, Blocks.STONE_BRICKS.defaultBlockState(), 3);
                }
            }
            if (this.relicHoleList.isHole(blockPos)) {
                worldGenLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
            }
        });
    }

    @Override
    public StructureType<?> type() {
        return FossilsLegacyStructureTypes.ACADEMY.get();
    }
}