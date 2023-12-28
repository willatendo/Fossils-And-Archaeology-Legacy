package willatendo.fossilslegacy.data;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.apache.commons.compress.utils.Lists;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyCustomProviders implements DataProvider {
	protected static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	protected final FabricDataOutput fabricDataOutput;
	protected final String modid;

	public FossilsLegacyCustomProviders(FabricDataOutput fabricDataOutput, String modid) {
		this.fabricDataOutput = fabricDataOutput;
		this.modid = modid;
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		Path path = this.fabricDataOutput.getOutputFolder();
		ArrayList<CompletableFuture> completableFutures = Lists.newArrayList();
		this.makeAllCustomProviders((saver) -> {
			completableFutures.add(DataProvider.saveStable(cachedOutput, saver.serialise(), path.resolve("data/" + this.modid + "/" + saver.id() + ".json")));
		});
		return CompletableFuture.allOf(completableFutures.stream().toArray(CompletableFuture[]::new));
	}

	public void makeAllCustomProviders(Consumer<Saver> features) {
		features.accept(new StructureSet("academy", 1, 32, 8, 1476272410));
		features.accept(new Structure("academy", FossilsLegacyBiomeTags.HAS_ACADEMY, "surface_structures"));
		features.accept(new StructureSet("weapon_shop", 1, 32, 8, 1476272411));
		features.accept(new Structure("weapon_shop", FossilsLegacyBiomeTags.HAS_WEAPON_SHOP, "surface_structures"));
		features.accept(new DamageType("javelin", 0.1F, "javelin", "when_caused_by_living_non_player"));
		features.accept(new DamageType("animal_starve", 0.0F, "animal_starve", "when_caused_by_living_non_player"));
		features.accept(new DamageType("dilophosaurus_envenomation", 0.1F, "dilophosaurus_envenomation", "when_caused_by_living_non_player"));
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
}
