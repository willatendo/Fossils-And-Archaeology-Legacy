package fossilslegacy.server.structure;

import fossilslegacy.server.item.FossilsLegacyLootTables;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
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

public class AcademyPieces {
	public static final ResourceLocation STRUCTURE_LOCATION = FossilsLegacyUtils.resource("academy");

	public static void addPieces(StructureTemplateManager struxtureTemplateManager, boolean isStoneBricks, BlockPos blockPos, Rotation rotation, StructurePieceAccessor structurePieceAccessor, RandomSource randomSource) {
		structurePieceAccessor.addPiece(new AcademyPieces.AcademyStructurePiece(struxtureTemplateManager, STRUCTURE_LOCATION, isStoneBricks, blockPos, rotation));
	}

	public static class AcademyStructurePiece extends TemplateStructurePiece {
		private final boolean isStoneBricks;

		public AcademyStructurePiece(StructureTemplateManager struxtureTemplateManager, ResourceLocation structureLocation, boolean isStoneBricks, BlockPos blockPos, Rotation rotation) {
			super(FossilLegacysStructurePeices.ACADEMY.get(), 0, struxtureTemplateManager, structureLocation, structureLocation.toString(), makeSettings(rotation, structureLocation), blockPos);
			this.isStoneBricks = isStoneBricks;
		}

		public AcademyStructurePiece(StructureTemplateManager struxtureTemplateManager, CompoundTag compoundTag) {
			super(FossilLegacysStructurePeices.ACADEMY.get(), compoundTag, struxtureTemplateManager, (structureLocation) -> {
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
			if ("academy_loot".equals(data)) {
				serverLevelAccessor.setBlock(blockPos, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH), 3);
				BlockEntity blockEntity = serverLevelAccessor.getBlockEntity(blockPos);
				if (blockEntity instanceof ChestBlockEntity chestBlockEntity) {
					chestBlockEntity.setLootTable(FossilsLegacyLootTables.ACADEMY_LOOT, randomSource.nextLong());
				}
			}
			if ("academy_disc".equals(data)) {
				serverLevelAccessor.setBlock(blockPos, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH), 3);
				BlockEntity blockEntity = serverLevelAccessor.getBlockEntity(blockPos);
				if (blockEntity instanceof ChestBlockEntity chestBlockEntity) {
					chestBlockEntity.setLootTable(FossilsLegacyLootTables.ACADEMY_DISC, randomSource.nextLong());
				}
			}
			if ("academy_loot_right".equals(data)) {
				serverLevelAccessor.setBlock(blockPos, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.TYPE, ChestType.RIGHT).setValue(ChestBlock.FACING, Direction.NORTH), 3);
				BlockEntity blockEntity = serverLevelAccessor.getBlockEntity(blockPos);
				if (blockEntity instanceof ChestBlockEntity chestBlockEntity) {
					chestBlockEntity.setLootTable(FossilsLegacyLootTables.ACADEMY_LOOT, randomSource.nextLong());
				}
			}
			if ("academy_loot_left".equals(data)) {
				serverLevelAccessor.setBlock(blockPos, Blocks.CHEST.defaultBlockState().setValue(ChestBlock.TYPE, ChestType.LEFT).setValue(ChestBlock.FACING, Direction.NORTH), 3);
				BlockEntity blockEntity = serverLevelAccessor.getBlockEntity(blockPos);
				if (blockEntity instanceof ChestBlockEntity chestBlockEntity) {
					chestBlockEntity.setLootTable(FossilsLegacyLootTables.ACADEMY_LOOT, randomSource.nextLong());
				}
			}
		}

		@Override
		public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
			ResourceLocation structure = new ResourceLocation(this.templateName);
			StructurePlaceSettings structurePlaceSettings = makeSettings(this.placeSettings.getRotation(), structure);
			BlockPos offsetPos = new BlockPos(3, 3, 5);
			BlockPos offsetedPos = this.templatePosition.offset(StructureTemplate.calculateRelativePosition(structurePlaceSettings, new BlockPos(3 - offsetPos.getX(), 0, -offsetPos.getZ())));
			int worldHeight = worldGenLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, offsetedPos.getX(), offsetedPos.getZ());
			BlockPos templatePos = this.templatePosition;
			this.templatePosition = this.templatePosition.offset(0, worldHeight - 90 - 1, 0);
			super.postProcess(worldGenLevel, structureManager, chunkGenerator, randomSource, boundingBox, chunkPos, blockPos);
			if (this.isStoneBricks) {
				BlockPos.betweenClosedStream(this.getBoundingBox()).forEach((blockPoses) -> {
					if (worldGenLevel.getBlockState(blockPoses).is(Blocks.BRICKS)) {
						worldGenLevel.setBlock(blockPoses, Blocks.STONE_BRICKS.defaultBlockState(), 3);
					}
				});
			}
			this.templatePosition = templatePos;
		}
	}
}