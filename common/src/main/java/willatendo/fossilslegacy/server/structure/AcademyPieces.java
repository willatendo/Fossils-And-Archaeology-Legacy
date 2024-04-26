package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import willatendo.fossilslegacy.server.structure.holes.RelicHoleList;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class AcademyPieces {
    public static final ResourceLocation STRUCTURE_LOCATION = FossilsLegacyUtils.resource("academy");

    public static void addPieces(StructureTemplateManager struxtureTemplateManager, boolean isStoneBricks, BlockPos blockPos, Rotation rotation, StructurePieceAccessor structurePieceAccessor, RandomSource randomSource) {
        structurePieceAccessor.addPiece(new AcademyPieces.AcademyStructurePiece(struxtureTemplateManager, STRUCTURE_LOCATION, isStoneBricks, blockPos, rotation));
    }

    public static class AcademyStructurePiece extends TemplateStructurePiece {
        private final boolean isStoneBricks;
        private RelicHoleList relicHoleList;

        public AcademyStructurePiece(StructureTemplateManager struxtureTemplateManager, ResourceLocation structureLocation, boolean isStoneBricks, BlockPos blockPos, Rotation rotation) {
            super(FossilsLegacyStructurePeices.ACADEMY.get(), 0, struxtureTemplateManager, structureLocation, structureLocation.toString(), makeSettings(rotation, structureLocation), blockPos);
            this.isStoneBricks = isStoneBricks;
        }

        public AcademyStructurePiece(StructureTemplateManager struxtureTemplateManager, CompoundTag compoundTag) {
            super(FossilsLegacyStructurePeices.ACADEMY.get(), compoundTag, struxtureTemplateManager, (structureLocation) -> {
                return makeSettings(Rotation.valueOf(compoundTag.getString("Rot")), structureLocation);
            });
            this.isStoneBricks = compoundTag.getBoolean("IsStoneBricks");
        }

        private static StructurePlaceSettings makeSettings(Rotation rotation, ResourceLocation structureLocation) {
            return (new StructurePlaceSettings()).setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
            compoundTag.putString("Rot", this.placeSettings.getRotation().name());
            compoundTag.putBoolean("IsStoneBricks", this.isStoneBricks);
        }

        @Override
        protected void handleDataMarker(String data, BlockPos blockPos, ServerLevelAccessor serverLevelAccessor, RandomSource randomSource, BoundingBox boundingBox) {
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            ResourceLocation structure = new ResourceLocation(this.templateName);
            StructurePlaceSettings structurePlaceSettings = makeSettings(this.placeSettings.getRotation(), structure);
            BlockPos offsetPos = new BlockPos(3, 0, 5);
            BlockPos offsetedPos = this.templatePosition.offset(StructureTemplate.calculateRelativePosition(structurePlaceSettings, new BlockPos(3 - offsetPos.getX(), 0, -offsetPos.getZ())));
            int worldHeight = worldGenLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, offsetedPos.getX(), offsetedPos.getZ());
            BlockPos templatePos = this.templatePosition;
            this.templatePosition = this.templatePosition.offset(0, worldHeight - 90 - 1, 0);
            super.postProcess(worldGenLevel, structureManager, chunkGenerator, randomSource, boundingBox, chunkPos, blockPos);
            List<BlockState> blockStates = new ArrayList<>();
            BlockPos.betweenClosedStream(this.getBoundingBox()).forEach(blockPoses -> {
                blockStates.add(worldGenLevel.getBlockState(blockPoses));
            });
            this.relicHoleList = new RelicHoleList(blockStates, structurePlaceSettings.getRotation(), this.templatePosition, worldGenLevel.getRandom(), 24, 26, 27, 7, 3);
            BlockPos.betweenClosedStream(this.getBoundingBox()).forEach((blockPoses) -> {
                if (this.isStoneBricks) {
                    if (worldGenLevel.getBlockState(blockPoses).is(Blocks.BRICKS)) {
                        worldGenLevel.setBlock(blockPoses, Blocks.STONE_BRICKS.defaultBlockState(), 3);
                    }
                }
                if (this.relicHoleList.isHole(blockPoses)) {
                    worldGenLevel.setBlock(blockPoses, Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
                }
            });
            this.templatePosition = templatePos;
        }
    }
}