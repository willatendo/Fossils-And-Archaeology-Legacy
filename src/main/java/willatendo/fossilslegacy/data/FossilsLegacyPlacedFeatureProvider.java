package willatendo.fossilslegacy.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.data.PackOutput;
import willatendo.simplelibrary.data.SimplePlacedFeatureProvider;

public class FossilsLegacyPlacedFeatureProvider extends SimplePlacedFeatureProvider {
	public FossilsLegacyPlacedFeatureProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void allPlacedFeatures() {
		this.simplePlacedFeature("fossilslegacy:ore_fossil", "ore_fossil", this.orePlacement(25, "minecraft:trapezoid", 128, 10));
		this.simplePlacedFeature("fossilslegacy:ore_permafrost", "ore_permafrost", this.orePlacement(25, "minecraft:trapezoid", 256, 25));
	}

	public JsonArray orePlacement(int count, String type, int maxHeight, int minHeight) {
		JsonArray placement = new JsonArray();
		JsonObject counts = new JsonObject();
		counts.addProperty("type", "minecraft:count");
		counts.addProperty("count", count);
		placement.add(counts);
		JsonObject inSquare = new JsonObject();
		inSquare.addProperty("type", "minecraft:in_square");
		placement.add(inSquare);
		JsonObject heightRange = new JsonObject();
		heightRange.addProperty("type", "minecraft:height_range");
		JsonObject height = new JsonObject();
		height.addProperty("type", type);
		JsonObject min = new JsonObject();
		min.addProperty("absolute", minHeight);
		height.add("min_inclusive", min);
		JsonObject max = new JsonObject();
		max.addProperty("absolute", maxHeight);
		height.add("max_inclusive", max);
		heightRange.add("height", height);
		placement.add(heightRange);
		JsonObject biome = new JsonObject();
		biome.addProperty("type", "minecraft:biome");
		placement.add(biome);
		return placement;
	}
}
