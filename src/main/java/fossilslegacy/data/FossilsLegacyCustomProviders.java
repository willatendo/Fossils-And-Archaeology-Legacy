package fossilslegacy.data;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.apache.commons.compress.utils.Lists;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import fossilslegacy.server.biomes.FossilsLegacyBiomeTags;
import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.ForgeRegistries;

public class FossilsLegacyCustomProviders implements DataProvider {
	protected static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	protected final PackOutput packOutput;
	protected final String modid;

	public FossilsLegacyCustomProviders(PackOutput packOutput, String modid) {
		this.packOutput = packOutput;
		this.modid = modid;
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		Path path = this.packOutput.getOutputFolder();
		ArrayList<CompletableFuture> completableFutures = Lists.newArrayList();
		this.makeAllCustomProviders((saver) -> {
			completableFutures.add(DataProvider.saveStable(cachedOutput, saver.serialise(), path.resolve("data/" + this.modid + "/" + saver.id() + ".json")));
		});
		return CompletableFuture.allOf(completableFutures.stream().toArray(CompletableFuture[]::new));
	}

	public void makeAllCustomProviders(Consumer<Saver> features) {
		features.accept(new OreFeature("ore_fossil", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.FOSSIL_ORE.get().defaultBlockState())), 8)));
		features.accept(new OrePlacement("ore_fossil", FossilsLegacyUtils.resource("ore_fossil"), 25, "minecraft:trapezoid", 128, 10));
		features.accept(new BiomeModifer("fossil_ore", new ResourceLocation("forge", "add_features"), "forge:any", FossilsLegacyUtils.resource("ore_fossil"), Decoration.UNDERGROUND_ORES));
		features.accept(new OreFeature("ore_permafrost", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.PERMAFROST.get().defaultBlockState())), 8)));
		features.accept(new OrePlacement("ore_permafrost", FossilsLegacyUtils.resource("ore_permafrost"), 25, "minecraft:trapezoid", 256, 25));
		features.accept(new BiomeModifer("permafrost_ore", new ResourceLocation("forge", "add_features"), "forge:any", FossilsLegacyUtils.resource("ore_permafrost"), Decoration.UNDERGROUND_ORES));
		features.accept(new StructureSet("academy", 1, 32, 8, 1476272410));
		features.accept(new Structure("academy", FossilsLegacyBiomeTags.HAS_ACADEMY, "surface_structures"));
		features.accept(new StructureSet("weapon_shop", 1, 32, 8, 1476272411));
		features.accept(new Structure("weapon_shop", FossilsLegacyBiomeTags.HAS_WEAPON_SHOP, "surface_structures"));
		features.accept(new DamageType("javelin", 0.1F, "javelin", "when_caused_by_living_non_player"));
	}

	@Override
	public String getName() {
		return "Custom";
	}

	public static interface Saver {
		String id();

		JsonObject serialise();
	}

	public static record DamageType(String id, float exhaustion, String messageId, String scaling) implements Saver {
		@Override
		public String id() {
			return "damage_type/" + this.id;
		}

		@Override
		public JsonObject serialise() {
			JsonObject damageType = new JsonObject();
			damageType.addProperty("exhaustion", this.exhaustion);
			damageType.addProperty("message_id", this.messageId);
			damageType.addProperty("scaling", this.scaling);
			return damageType;
		}
	}

	public static record StructureSet(String id, int weight, int spacing, int separation, int salt) implements Saver {
		@Override
		public String id() {
			return "worldgen/structure_set/" + this.id;
		}

		@Override
		public JsonObject serialise() {
			JsonObject structureSet = new JsonObject();
			JsonArray structures = new JsonArray();
			JsonObject structure = new JsonObject();
			structure.addProperty("structure", FossilsLegacyUtils.ID + ":" + this.id);
			structure.addProperty("weight", this.weight);
			structures.add(structure);
			structureSet.add("structures", structures);
			JsonObject placement = new JsonObject();
			placement.addProperty("type", "minecraft:random_spread");
			placement.addProperty("spacing", this.spacing);
			placement.addProperty("separation", this.separation);
			placement.addProperty("salt", this.salt);
			structureSet.add("placement", placement);
			return structureSet;
		}
	}

	public static record Structure(String id, TagKey<Biome> biomes, String step) implements Saver {
		@Override
		public String id() {
			return "worldgen/structure/" + this.id;
		}

		@Override
		public JsonObject serialise() {
			JsonObject structure = new JsonObject();
			structure.addProperty("type", FossilsLegacyUtils.ID + ":" + this.id);
			structure.addProperty("biomes", "#" + this.biomes.location().toString());
			JsonObject spawnOverrides = new JsonObject();
			structure.add("spawn_overrides", spawnOverrides);
			structure.addProperty("step", step);
			return structure;
		}
	}

	public static record OreFeature(String id, Feature<?> feature, OreConfiguration oreConfiguration) implements Saver {
		@Override
		public String id() {
			return "worldgen/configured_feature/" + this.id;
		}

		@Override
		public JsonObject serialise() {
			JsonObject feature = new JsonObject();
			feature.addProperty("type", ForgeRegistries.FEATURES.getKey(this.feature).toString());
			JsonObject configuration = new JsonObject();
			configuration.addProperty("discard_chance_on_air_exposure", this.oreConfiguration.discardChanceOnAirExposure);
			configuration.addProperty("size", this.oreConfiguration.size);
			JsonArray targets = new JsonArray();
			for (TargetBlockState targetStates : this.oreConfiguration.targetStates) {
				JsonObject target = new JsonObject();
				JsonObject state = new JsonObject();
				state.addProperty("Name", ForgeRegistries.BLOCKS.getKey(targetStates.state.getBlock()).toString());
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
			feature.add("config", configuration);
			return feature;
		}
	}

	public static record OrePlacement(String id, ResourceLocation feature, int count, String type, int maxHeight, int minHeight) implements Saver {
		@Override
		public String id() {
			return "worldgen/placed_feature/" + this.id;
		}

		@Override
		public JsonObject serialise() {
			JsonObject feature = new JsonObject();
			feature.addProperty("feature", this.feature.toString());
			JsonArray placement = new JsonArray();
			JsonObject count = new JsonObject();
			count.addProperty("type", "minecraft:count");
			count.addProperty("count", this.count);
			placement.add(count);
			JsonObject inSquare = new JsonObject();
			inSquare.addProperty("type", "minecraft:in_square");
			placement.add(inSquare);
			JsonObject heightRange = new JsonObject();
			heightRange.addProperty("type", "minecraft:height_range");
			JsonObject height = new JsonObject();
			height.addProperty("type", this.type);
			JsonObject min = new JsonObject();
			min.addProperty("absolute", this.minHeight);
			height.add("min_inclusive", min);
			JsonObject max = new JsonObject();
			max.addProperty("absolute", this.maxHeight);
			height.add("max_inclusive", max);
			heightRange.add("height", height);
			placement.add(heightRange);
			JsonObject biome = new JsonObject();
			biome.addProperty("type", "minecraft:biome");
			placement.add(biome);
			feature.add("placement", placement);
			return feature;
		}
	}

	public static record BiomeModifer(String id, ResourceLocation type, String biome, ResourceLocation feature, Decoration decoration) implements Saver {
		@Override
		public String id() {
			return "forge/biome_modifier/" + this.id;
		}

		@Override
		public JsonObject serialise() {
			JsonObject biomeModifier = new JsonObject();
			biomeModifier.addProperty("type", this.type.toString());
			JsonObject biomes = new JsonObject();
			biomes.addProperty("type", this.biome);
			biomeModifier.add("biomes", biomes);
			biomeModifier.addProperty("features", this.feature.toString());
			biomeModifier.addProperty("step", this.decoration.getName());
			return biomeModifier;
		}
	}
}
