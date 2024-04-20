package willatendo.fossilslegacy.data;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.CultivatorBlock;
import willatendo.fossilslegacy.server.block.DrumBlock;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.JurassicFernBlock;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public class FossilsLegacyBlockStateProvider extends BlockStateProvider implements FossilsDataProvider.BasicBlockStateProvider {
    public FossilsLegacyBlockStateProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        FossilsDataProvider.addBlockStates(this);
    }

    @Override
    public void statesBlock(Block block, Property<Boolean> property, String inActiveModelName, ResourceLocation inActiveDown, ResourceLocation inActiveUp, ResourceLocation inActiveNorth, ResourceLocation inActiveSouth, ResourceLocation inActiveEast, ResourceLocation inActiveWest, ResourceLocation inActiveParticle, String activeModelName, ResourceLocation activeDown, ResourceLocation activeUp, ResourceLocation activeNorth, ResourceLocation activeSouth, ResourceLocation activeEast, ResourceLocation activeWest, ResourceLocation activeParticle) {
        this.getVariantBuilder(block).partialState().with(property, false).addModels(new ConfiguredModel(this.models().cube(inActiveModelName, inActiveDown, inActiveUp, inActiveNorth, inActiveSouth, inActiveEast, inActiveWest).texture("particle", inActiveParticle))).partialState().with(property, true).addModels(new ConfiguredModel(this.models().cube(activeModelName, activeDown, activeUp, activeNorth, activeSouth, activeEast, activeWest).texture("particle", activeParticle)));
    }

    @Override
    public void parent(Block block, String modelName, ResourceLocation model) {
        this.simpleBlock(block, this.models().withExistingParent(modelName, model));
    }

    @Override
    public void parent(Block block, String modelName, ResourceLocation model, Pair<String, ResourceLocation>... textureOverides) {
        BlockModelBuilder blockModelBuilder = this.models().withExistingParent(modelName, model);
        for (Pair<String, ResourceLocation> pair : textureOverides) {
            blockModelBuilder.texture(pair.getFirst(), pair.getSecond());
        }
        this.simpleBlock(block, blockModelBuilder);
    }

    @Override
    public void horizontalBlock(Block block, String modelName, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation south, ResourceLocation east, ResourceLocation west, ResourceLocation particle) {
        this.horizontalBlock(block, blockState -> this.models().cube(modelName, down, up, north, south, east, west).texture("particle", particle));
    }

    @Override
    public void horizontalBlockWithModelHolder(Block block, Function<BlockState, ModelHolder> model) {
        this.horizontalBlock(block, blockState -> {
            ModelHolder modelHolder = model.apply(blockState);
            return this.models().cube(modelHolder.modelName(), modelHolder.down(), modelHolder.up(), modelHolder.north(), modelHolder.south(), modelHolder.east(), modelHolder.west()).texture("particle", modelHolder.particle());
        });
    }

    @Override
    public void fernBlock(Block block) {
        this.getVariantBuilder(block).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_0", FossilsLegacyUtils.resource("block/fern_lower_0")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_1", FossilsLegacyUtils.resource("block/fern_lower_1")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_2", FossilsLegacyUtils.resource("block/fern_lower_2")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_3", FossilsLegacyUtils.resource("block/fern_lower_3")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_4", FossilsLegacyUtils.resource("block/fern_lower_4")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(this.models().crop("fern_lower_5", FossilsLegacyUtils.resource("block/fern_lower_5")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 0).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_0", FossilsLegacyUtils.resource("block/fern_upper_4")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 1).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_1", FossilsLegacyUtils.resource("block/fern_upper_4")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 2).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_2", FossilsLegacyUtils.resource("block/fern_upper_4")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 3).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_3", FossilsLegacyUtils.resource("block/fern_upper_4")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 4).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_4", FossilsLegacyUtils.resource("block/fern_upper_4")).renderType("cutout"))).partialState().with(JurassicFernBlock.GROWTH, 5).with(JurassicFernBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(this.models().crop("fern_upper_5", FossilsLegacyUtils.resource("block/fern_upper_5")).renderType("cutout")));
    }

    @Override
    public void drumBlock(Block block) {
        this.getVariantBuilder(block).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurCommand.FOLLOW).addModels(new ConfiguredModel(this.models().cube("drum_follow", new ResourceLocation("block/spruce_planks"), FossilsLegacyUtils.resource("block/drum_follow"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side")).texture("particle", FossilsLegacyUtils.resource("block/drum_side")))).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurCommand.FREE_MOVE).addModels(new ConfiguredModel(this.models().cube("drum_free_move", this.mcLoc("block/spruce_planks"), FossilsLegacyUtils.resource("block/drum_free_move"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side")).texture("particle", FossilsLegacyUtils.resource("block/drum_side")))).partialState().with(DrumBlock.DINOSAUR_ORDER, DinosaurCommand.STAY).addModels(new ConfiguredModel(this.models().cube("drum_stay", this.mcLoc("block/spruce_planks"), FossilsLegacyUtils.resource("block/drum_stay"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side"), FossilsLegacyUtils.resource("block/drum_side")).texture("particle", FossilsLegacyUtils.resource("block/drum_side"))));
    }
}
