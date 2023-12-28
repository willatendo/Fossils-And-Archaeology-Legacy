package willatendo.fossilslegacy.data;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.simplelibrary.data.SimpleConfiguredFeatureProvider;

public class FossilsLegacyConfiguredFeatureProvider extends SimpleConfiguredFeatureProvider {
	public FossilsLegacyConfiguredFeatureProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void allConfiguredFeatures() {
		this.simpleConfiguredFeature(Feature.ORE, "ore_fossil", this.oreFeature(8, List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.FOSSIL_ORE.get().defaultBlockState()))));
		this.simpleConfiguredFeature(Feature.ORE, "ore_permafrost", this.oreFeature(8, List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.PERMAFROST.get().defaultBlockState()))));
	}

	public JsonObject oreFeature(int size, List<? extends TargetBlockState> states) {
		JsonObject configuration = new JsonObject();
		configuration.addProperty("discard_chance_on_air_exposure", 0.0F);
		configuration.addProperty("size", size);
		JsonArray targets = new JsonArray();
		for (TargetBlockState targetStates : states) {
			JsonObject target = new JsonObject();
			JsonObject state = new JsonObject();
			state.addProperty("Name", BuiltInRegistries.BLOCK.getKey(targetStates.state.getBlock()).toString());
			target.add("state", state);
			JsonObject targetState = new JsonObject();
			RuleTest ruleTest = targetStates.target;
			if (ruleTest instanceof TagMatchTest tagMatchTest) {
				targetState.addProperty("predicate_type", "minecraft:tag_match");
				targetState.addProperty("tag", "minecraft:stone_ore_replaceables");
			}
			target.add("target", targetState);
			targets.add(target);
		}
		configuration.add("targets", targets);
		return configuration;
	}
}
