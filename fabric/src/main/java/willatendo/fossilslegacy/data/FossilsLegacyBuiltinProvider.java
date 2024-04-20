package willatendo.fossilslegacy.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.RegistrySetBuilder.PatchedRegistries;
import net.minecraft.core.RegistrySetBuilder.RegistryBootstrap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistriesDatapackGenerator;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyConfiguredFeatures;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.entity.FossilsLegacyDamageTypes;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureSets;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructures;

public class FossilsLegacyBuiltinProvider extends RegistriesDatapackGenerator {
	private static final List<RegistryDataLoader.RegistryData<?>> DATA_PACK_REGISTRIES = new ArrayList<>(Stream.concat(RegistryDataLoader.WORLDGEN_REGISTRIES.stream(), RegistryDataLoader.DIMENSION_REGISTRIES.stream()).toList());
	private static final List<RegistryDataLoader.RegistryData<?>> DATA_PACK_REGISTRIES_VIEW = Collections.unmodifiableList(DATA_PACK_REGISTRIES);
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, (RegistryBootstrap) FossilsLegacyConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, (RegistryBootstrap) FossilsLegacyPlacedFeatures::bootstrap).add(Registries.DAMAGE_TYPE, (RegistryBootstrap) FossilsLegacyDamageTypes::bootstrap).add(Registries.STRUCTURE, (RegistryBootstrap) FossilsLegacyStructures::bootstrap).add(Registries.STRUCTURE_SET, (RegistryBootstrap) FossilsLegacyStructureSets::bootstrap);

	private final PackOutput packOutput;
	private final CompletableFuture<Provider> registries;
	private final Predicate<String> namespacePredicate;

	public FossilsLegacyBuiltinProvider(PackOutput packOutput, CompletableFuture<Provider> registries, Set<String> modIds) {
		super(packOutput, registries);
		this.namespacePredicate = modIds == null ? namespace -> true : modIds::contains;
		this.registries = registries;
		this.packOutput = packOutput;
	}

	public FossilsLegacyBuiltinProvider(FabricDataOutput fabricDataOuput, CompletableFuture<PatchedRegistries> registries, Set<String> modIds) {
		this(fabricDataOuput, registries.thenApply(RegistrySetBuilder.PatchedRegistries::patches), modIds);
	}

	public FossilsLegacyBuiltinProvider(FabricDataOutput fabricDataOuput, CompletableFuture<Provider> registries) {
		this(fabricDataOuput, FossilsLegacyBuiltinProvider.createLookup(registries, BUILDER), Collections.singleton(fabricDataOuput.getModId()));
	}

	public static CompletableFuture<PatchedRegistries> createLookup(CompletableFuture<Provider> completableFuture, RegistrySetBuilder registrySetBuilder) {
		return completableFuture.thenApply(provider -> {
			Cloner.Factory factory = new Cloner.Factory();
			FossilsLegacyBuiltinProvider.getDataPackRegistriesWithDimensions().forEach(registryData -> registryData.runWithArguments(factory::addCodec));
			return registrySetBuilder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), provider, factory);
		});
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		return this.registries.thenCompose((provider) -> {
			DynamicOps<JsonElement> dynamicOps = RegistryOps.create(JsonOps.INSTANCE, provider);
			return CompletableFuture.allOf(getDataPackRegistriesWithDimensions().flatMap((registryData) -> {
				return this.dumpRegistryCap(cachedOutput, provider, dynamicOps, registryData).stream();
			}).toArray(CompletableFuture[]::new));
		});
	}

	private <T> Optional<CompletableFuture<?>> dumpRegistryCap(CachedOutput cachedOutput, Provider provider, DynamicOps<JsonElement> dynamicOps, RegistryDataLoader.RegistryData<T> registryData) {
		ResourceKey<? extends Registry<T>> resourcekey = registryData.key();
		return provider.lookup(resourcekey).map((registryLookup) -> {
			PackOutput.PathProvider pathProvider = this.packOutput.createPathProvider(PackOutput.Target.DATA_PACK, prefixNamespace(resourcekey.location()));
			return CompletableFuture.allOf(registryLookup.listElements().filter(holder -> this.namespacePredicate.test(holder.key().location().getNamespace())).map((reference) -> {
				return dumpValue(pathProvider.json(reference.key().location()), cachedOutput, dynamicOps, registryData.elementCodec(), reference.value());
			}).toArray(CompletableFuture[]::new));
		});
	}

	public static Stream<RegistryDataLoader.RegistryData<?>> getDataPackRegistriesWithDimensions() {
		return DATA_PACK_REGISTRIES_VIEW.stream();
	}

	public static String prefixNamespace(ResourceLocation resourceLocation) {
		return resourceLocation.getNamespace().equals("minecraft") ? resourceLocation.getPath() : resourceLocation.getNamespace() + "/" + resourceLocation.getPath();
	}
}
