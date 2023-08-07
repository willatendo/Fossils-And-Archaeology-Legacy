package willatendo.fossilslegacy.data;

import com.google.gson.JsonObject;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.simplelibrary.data.SimpleBiomeModifierProvider;

public class FossilsLegacyBiomeModiferProvider extends SimpleBiomeModifierProvider {
	public FossilsLegacyBiomeModiferProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void allBiomeModifiers() {
		this.addPlacedFeature(FossilsLegacyPlacedFeatures.ORE_FOSSIL, Decoration.UNDERGROUND_ORES);
		this.addPlacedFeature(FossilsLegacyPlacedFeatures.ORE_PERMAFROST, Decoration.UNDERGROUND_ORES);
	}

	public void addPlacedFeature(ResourceKey<PlacedFeature> placedFeature, Decoration decoration) {
		this.addPlacedFeature("add_" + placedFeature.location().getPath() + "_to_all_biomes", placedFeature, decoration);
	}

	public void addPlacedFeature(String id, ResourceKey<PlacedFeature> placedFeature, Decoration decoration) {
		JsonObject addPlacedFeature = new JsonObject();
		addPlacedFeature.addProperty("type", "forge:add_features");
		JsonObject biomes = new JsonObject();
		biomes.addProperty("type", "forge:any");
		addPlacedFeature.add("biomes", biomes);
		addPlacedFeature.addProperty("features", placedFeature.location().toString());
		addPlacedFeature.addProperty("step", decoration.getName());
		BIOME_MODIFERS.put(id, addPlacedFeature);
	}

	@Override
	public String getName() {
		return "fossilslegacy: Biome Modifiers";
	}
}
