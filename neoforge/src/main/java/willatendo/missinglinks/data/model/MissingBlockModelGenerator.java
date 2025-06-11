package willatendo.missinglinks.data.model;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import willatendo.missinglinks.data.MissingModelTemplates;
import willatendo.missinglinks.data.MissingTextureSlot;
import willatendo.missinglinks.server.block.MissingBlocks;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.data.model.SimpleBlockModelGenerator;

public class MissingBlockModelGenerator extends SimpleBlockModelGenerator {
    public MissingBlockModelGenerator(BlockModelGenerators blockModelGenerators) {
        super(blockModelGenerators, MissingLinks2Utils.ID);
    }

    @Override
    public void run() {
        this.button(MissingBlocks.ANDESITE_BUTTON.get(), Blocks.ANDESITE);
        this.pressurePlate(MissingBlocks.ANDESITE_PRESSURE_PLATE.get(), Blocks.ANDESITE);
        this.lever(MissingBlocks.ANDESITE_LEVER.get(), Blocks.ANDESITE);
        this.slab(MissingBlocks.CALCITE_SLAB.get(), Blocks.CALCITE);
        this.stair(MissingBlocks.CALCITE_STAIRS.get(), Blocks.CALCITE);
        this.wall(MissingBlocks.CALCITE_WALL.get(), Blocks.CALCITE);
        this.button(MissingBlocks.CALCITE_BUTTON.get(), Blocks.CALCITE);
        this.pressurePlate(MissingBlocks.CALCITE_PRESSURE_PLATE.get(), Blocks.CALCITE);
        this.lever(MissingBlocks.CALCITE_LEVER.get(), Blocks.CALCITE);
        this.button(MissingBlocks.COBBLED_DEEPSLATE_BUTTON.get(), Blocks.COBBLED_DEEPSLATE);
        this.pressurePlate(MissingBlocks.COBBLED_DEEPSLATE_PRESSURE_PLATE.get(), Blocks.COBBLED_DEEPSLATE);
        this.lever(MissingBlocks.COBBLED_DEEPSLATE_LEVER.get(), Blocks.COBBLED_DEEPSLATE);
        this.button(MissingBlocks.COBBLESTONE_BUTTON.get(), Blocks.COBBLESTONE);
        this.pressurePlate(MissingBlocks.COBBLESTONE_PRESSURE_PLATE.get(), Blocks.COBBLESTONE);
        this.button(MissingBlocks.DIORITE_BUTTON.get(), Blocks.DIORITE);
        this.pressurePlate(MissingBlocks.DIORITE_PRESSURE_PLATE.get(), Blocks.DIORITE);
        this.lever(MissingBlocks.DIORITE_LEVER.get(), Blocks.DIORITE);
        this.button(MissingBlocks.GRANITE_BUTTON.get(), Blocks.GRANITE);
        this.pressurePlate(MissingBlocks.GRANITE_PRESSURE_PLATE.get(), Blocks.GRANITE);
        this.lever(MissingBlocks.GRANITE_LEVER.get(), Blocks.GRANITE);
        this.button(MissingBlocks.TUFF_BUTTON.get(), Blocks.TUFF);
        this.pressurePlate(MissingBlocks.TUFF_PRESSURE_PLATE.get(), Blocks.TUFF);
        this.lever(MissingBlocks.TUFF_LEVER.get(), Blocks.TUFF);
        this.lever(MissingBlocks.STONE_LEVER.get(), Blocks.STONE);
        this.wall(MissingBlocks.STONE_WALL.get(), Blocks.STONE);
    }

    private void button(Block button, Block base) {
        TextureMapping textureMapping = this.blockModelGenerators.texturedModels.getOrDefault(base, TexturedModel.CUBE.get(base)).getMapping();
        this.blockStateOutput.accept(BlockModelGenerators.createButton(button, ModelTemplates.BUTTON.create(button, textureMapping, this.modelOutput), ModelTemplates.BUTTON_PRESSED.create(button, textureMapping, this.modelOutput)));
        this.registerSimpleItemModel(button, ModelTemplates.BUTTON_INVENTORY.create(button, textureMapping, this.modelOutput));
    }

    private void pressurePlate(Block pressurePlate, Block base) {
        TextureMapping textureMapping = this.blockModelGenerators.texturedModels.getOrDefault(base, TexturedModel.CUBE.get(base)).getMapping();
        this.blockStateOutput.accept(BlockModelGenerators.createPressurePlate(pressurePlate, ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlate, textureMapping, this.modelOutput), ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlate, textureMapping, this.modelOutput)));
    }

    private void lever(Block lever, Block base) {
        ResourceLocation leverModel = MissingModelTemplates.TEMPLATE_LEVER.create(lever, new TextureMapping().put(MissingTextureSlot.LEVER, ModelLocationUtils.getModelLocation(lever)).put(MissingTextureSlot.BASE, ModelLocationUtils.getModelLocation(base)).put(TextureSlot.PARTICLE, ModelLocationUtils.getModelLocation(base)), this.modelOutput);
        ResourceLocation onLevelModel = MissingModelTemplates.TEMPLATE_LEVER_ON.createWithSuffix(lever, "_on", new TextureMapping().put(MissingTextureSlot.LEVER, ModelLocationUtils.getModelLocation(lever)).put(MissingTextureSlot.BASE, ModelLocationUtils.getModelLocation(base)).put(TextureSlot.PARTICLE, ModelLocationUtils.getModelLocation(base)), this.modelOutput);
        this.registerSimpleItemModel(lever, this.blockModelGenerators.createFlatItemModelWithBlockTexture(lever.asItem(), lever));
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(lever).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.POWERED, leverModel, onLevelModel)).with(PropertyDispatch.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING).select(AttachFace.CEILING, Direction.NORTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).select(AttachFace.CEILING, Direction.EAST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).select(AttachFace.CEILING, Direction.SOUTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)).select(AttachFace.CEILING, Direction.WEST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(AttachFace.FLOOR, Direction.NORTH, Variant.variant()).select(AttachFace.FLOOR, Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(AttachFace.FLOOR, Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).select(AttachFace.FLOOR, Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).select(AttachFace.WALL, Direction.NORTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)).select(AttachFace.WALL, Direction.EAST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(AttachFace.WALL, Direction.SOUTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).select(AttachFace.WALL, Direction.WEST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))));
    }

    private void slab(Block slab, Block base) {
        TextureMapping textureMapping = this.blockModelGenerators.texturedModels.getOrDefault(base, TexturedModel.CUBE.get(base)).getMapping();
        ResourceLocation bottomModel = ModelTemplates.SLAB_BOTTOM.create(slab, textureMapping, this.modelOutput);
        this.blockStateOutput.accept(BlockModelGenerators.createSlab(slab, bottomModel, ModelTemplates.SLAB_TOP.create(slab, textureMapping, this.modelOutput), ModelLocationUtils.getModelLocation(base)));
        this.registerSimpleItemModel(slab, bottomModel);
    }

    private void stair(Block stair, Block base) {
        TextureMapping textureMapping = this.blockModelGenerators.texturedModels.getOrDefault(base, TexturedModel.CUBE.get(base)).getMapping();
        ResourceLocation straightModel = ModelTemplates.STAIRS_STRAIGHT.create(stair, textureMapping, this.modelOutput);
        this.blockStateOutput.accept(BlockModelGenerators.createStairs(stair, ModelTemplates.STAIRS_INNER.create(stair, textureMapping, this.modelOutput), straightModel, ModelTemplates.STAIRS_OUTER.create(stair, textureMapping, this.modelOutput)));
        this.registerSimpleItemModel(stair, straightModel);
    }

    private void wall(Block wall, Block base) {
        TextureMapping textureMapping = this.blockModelGenerators.texturedModels.getOrDefault(base, TexturedModel.CUBE.get(base)).getMapping();
        this.blockStateOutput.accept(BlockModelGenerators.createWall(wall, ModelTemplates.WALL_POST.create(wall, textureMapping, this.modelOutput), ModelTemplates.WALL_LOW_SIDE.create(wall, textureMapping, this.modelOutput), ModelTemplates.WALL_TALL_SIDE.create(wall, textureMapping, this.modelOutput)));
        this.registerSimpleItemModel(wall, ModelTemplates.WALL_INVENTORY.create(wall, textureMapping, this.modelOutput));
    }
}
