package willatendo.fossilslegacy.server.structure.piece;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
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
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class WeaponShopPieces {
    public static final ResourceLocation STRUCTURE_LOCATION = FossilsLegacyUtils.resource("weapon_shop");

    public static void addPieces(StructureTemplateManager struxtureTemplateManager, BlockPos blockPos, Rotation rotation, StructurePieceAccessor structurePieceAccessor, RandomSource randomSource) {
        structurePieceAccessor.addPiece(new WeaponShopPieces.WeaponShopPiece(struxtureTemplateManager, STRUCTURE_LOCATION, blockPos, rotation));
    }

    public static class WeaponShopPiece extends TemplateStructurePiece {
        public WeaponShopPiece(StructureTemplateManager struxtureTemplateManager, ResourceLocation structureLocation, BlockPos blockPos, Rotation rotation) {
            super(FossilsLegacyStructurePeices.WEAPON_SHOP.get(), 0, struxtureTemplateManager, structureLocation, structureLocation.toString(), makeSettings(rotation, structureLocation), blockPos);
        }

        public WeaponShopPiece(StructureTemplateManager struxtureTemplateManager, CompoundTag compoundTag) {
            super(FossilsLegacyStructurePeices.WEAPON_SHOP.get(), compoundTag, struxtureTemplateManager, (structureLocation) -> {
                return makeSettings(Rotation.valueOf(compoundTag.getString("Rot")), structureLocation);
            });
        }

        private static StructurePlaceSettings makeSettings(Rotation rotation, ResourceLocation structureLocation) {
            return (new StructurePlaceSettings()).setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
            compoundTag.putString("Rot", this.placeSettings.getRotation().name());
        }

        @Override
        protected void handleDataMarker(String data, BlockPos blockPos, ServerLevelAccessor serverLevelAccessor, RandomSource randomSource, BoundingBox boundingBox) {
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            ResourceLocation structure = new ResourceLocation(this.templateName);
            StructurePlaceSettings structurePlaceSettings = makeSettings(this.placeSettings.getRotation(), structure);
            BlockPos offsetPos = new BlockPos(3, 3, 5);
            BlockPos offsetedPos = this.templatePosition.offset(StructureTemplate.calculateRelativePosition(structurePlaceSettings, new BlockPos(3 - offsetPos.getX(), 0, -offsetPos.getZ())));
            int worldHeight = worldGenLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, offsetedPos.getX(), offsetedPos.getZ()) - 15;
            BlockPos templatePos = this.templatePosition;
            this.templatePosition = this.templatePosition.offset(0, worldHeight - 90 - 1, 0);
            super.postProcess(worldGenLevel, structureManager, chunkGenerator, randomSource, boundingBox, chunkPos, blockPos);
            this.templatePosition = templatePos;
        }
    }
}