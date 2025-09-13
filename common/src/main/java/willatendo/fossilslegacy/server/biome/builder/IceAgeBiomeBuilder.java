package willatendo.fossilslegacy.server.biome.builder;

import com.mojang.datafixers.util.Pair;
import net.minecraft.SharedConstants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import willatendo.fossilslegacy.server.biome.biomes.IceAgeBiomes;

import java.util.function.Consumer;

public final class IceAgeBiomeBuilder {
    private final Climate.Parameter fullRange = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter mauritiusContinentalness;
    private final Climate.Parameter deepOceanContinentalness;
    private final Climate.Parameter oceanContinentalness;
    private final Climate.Parameter coastContinentalness;
    private final Climate.Parameter inlandContinentalness;
    private final Climate.Parameter nearInlandContinentalness;
    private final Climate.Parameter midInlandContinentalness;
    private final Climate.Parameter farInlandContinentalness;
    private final ResourceKey<Biome>[][] middleBiomes;
    private final ResourceKey<Biome>[][] plateauBiomes;
    private final ResourceKey<Biome>[][] beachBiomes;
    private final ResourceKey<Biome>[][] riverBiomes;

    public IceAgeBiomeBuilder() {
        this.mauritiusContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
        this.deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
        this.oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
        this.coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
        this.inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
        this.nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
        this.midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
        this.farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
        this.middleBiomes = new ResourceKey[][]{{IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_FOREST}, {IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_FOREST, IceAgeBiomes.COLD_FOREST, IceAgeBiomes.COLD_FOREST}, {IceAgeBiomes.COLD_FOREST, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS}, {IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.SAVANNA, IceAgeBiomes.SAVANNA, IceAgeBiomes.SAVANNA, IceAgeBiomes.DESERT}, {IceAgeBiomes.JUNGLE, IceAgeBiomes.SAVANNA, IceAgeBiomes.DESERT, IceAgeBiomes.DESERT, IceAgeBiomes.DESERT}};
        this.plateauBiomes = new ResourceKey[][]{{IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_FOREST, IceAgeBiomes.FROZEN_FOREST}, {IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_PLAINS, IceAgeBiomes.FROZEN_FOREST, IceAgeBiomes.FROZEN_FOREST, IceAgeBiomes.FROZEN_FOREST}, {IceAgeBiomes.COLD_FOREST, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.COLD_PLAINS}, {IceAgeBiomes.COLD_PLAINS, IceAgeBiomes.SAVANNA, IceAgeBiomes.SAVANNA, IceAgeBiomes.SAVANNA, IceAgeBiomes.SAVANNA}, {IceAgeBiomes.JUNGLE, IceAgeBiomes.JUNGLE, IceAgeBiomes.SAVANNA, IceAgeBiomes.DESERT, IceAgeBiomes.DESERT}};
        this.beachBiomes = new ResourceKey[][]{{IceAgeBiomes.COLD_BEACH, IceAgeBiomes.COLD_BEACH, IceAgeBiomes.COLD_BEACH, IceAgeBiomes.COLD_BEACH, IceAgeBiomes.COLD_BEACH}, {IceAgeBiomes.COLD_BEACH, IceAgeBiomes.COLD_BEACH, IceAgeBiomes.COLD_BEACH, IceAgeBiomes.BEACH, IceAgeBiomes.BEACH}, {IceAgeBiomes.BEACH, IceAgeBiomes.BEACH, IceAgeBiomes.BEACH, IceAgeBiomes.BEACH, IceAgeBiomes.BEACH}, {IceAgeBiomes.BEACH, IceAgeBiomes.BEACH, IceAgeBiomes.STONY_BEACH, IceAgeBiomes.STONY_BEACH, IceAgeBiomes.STONY_BEACH}, {IceAgeBiomes.STONY_BEACH, IceAgeBiomes.STONY_BEACH, IceAgeBiomes.STONY_BEACH, IceAgeBiomes.STONY_BEACH, IceAgeBiomes.STONY_BEACH}};
        this.riverBiomes = new ResourceKey[][]{{IceAgeBiomes.COLD_RIVER, IceAgeBiomes.COLD_RIVER, IceAgeBiomes.COLD_RIVER, IceAgeBiomes.COLD_RIVER, IceAgeBiomes.COLD_RIVER}, {IceAgeBiomes.COLD_RIVER, IceAgeBiomes.COLD_RIVER, IceAgeBiomes.COLD_RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER}, {IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER}, {IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER}, {IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER, IceAgeBiomes.RIVER}};
    }

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point) {
        if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
            this.addDebugBiomes(point);
        } else {
            this.addOffCoastBiomes(point);
            this.addInlandBiomes(point);
        }
    }

    private void addDebugBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point) {
        HolderLookup.Provider provider = VanillaRegistries.createLookup();
        HolderGetter<DensityFunction> densityFunctionGetter = provider.lookupOrThrow(Registries.DENSITY_FUNCTION);
        DensityFunctions.Spline.Coordinate continentsCoordinate = new DensityFunctions.Spline.Coordinate(densityFunctionGetter.getOrThrow(NoiseRouterData.CONTINENTS));
        DensityFunctions.Spline.Coordinate erosionCoordinate = new DensityFunctions.Spline.Coordinate(densityFunctionGetter.getOrThrow(NoiseRouterData.EROSION));
        DensityFunctions.Spline.Coordinate ridgesFoldedCoordinate = new DensityFunctions.Spline.Coordinate(densityFunctionGetter.getOrThrow(NoiseRouterData.RIDGES_FOLDED));
        point.accept(Pair.of(Climate.parameters(this.fullRange, this.fullRange, this.fullRange, this.fullRange, Climate.Parameter.point(0.0F), this.fullRange, 0.01F), IceAgeBiomes.COLD_PLAINS));
        CubicSpline<?, ?> erosionOffsetSpline = TerrainProvider.buildErosionOffsetSpline(erosionCoordinate, ridgesFoldedCoordinate, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, -0.03F, false, false, ToFloatFunction.IDENTITY);
        float[] locations;
        float location;
        if (erosionOffsetSpline instanceof CubicSpline.Multipoint<?, ?> multipoint) {
            ResourceKey<Biome> desert = IceAgeBiomes.DESERT;
            locations = multipoint.locations();

            for (int i = 0; i < locations.length; ++i) {
                location = locations[i];
                point.accept(Pair.of(Climate.parameters(this.fullRange, this.fullRange, this.fullRange, Climate.Parameter.point(location), Climate.Parameter.point(0.0F), this.fullRange, 0.0F), desert));
            }
        }

        CubicSpline<?, ?> overworldOffset = TerrainProvider.overworldOffset(continentsCoordinate, erosionCoordinate, ridgesFoldedCoordinate, false);
        if (overworldOffset instanceof CubicSpline.Multipoint<?, ?> multipoint) {
            locations = multipoint.locations();

            for (int i = 0; i < locations.length; ++i) {
                location = locations[i];
                point.accept(Pair.of(Climate.parameters(this.fullRange, this.fullRange, Climate.Parameter.point(location), this.fullRange, Climate.Parameter.point(0.0F), this.fullRange, 0.0F), IceAgeBiomes.FROZEN_FOREST));
            }
        }

    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point) {
        this.addSurfaceBiome(point, this.fullRange, this.fullRange, this.mauritiusContinentalness, this.fullRange, this.fullRange, 0.0F, IceAgeBiomes.MAURITIUS);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            this.addSurfaceBiome(point, temperature, this.fullRange, this.deepOceanContinentalness, this.fullRange, this.fullRange, 0.0F, IceAgeBiomes.DEEP_OCEAN);
            this.addSurfaceBiome(point, temperature, this.fullRange, this.oceanContinentalness, this.fullRange, this.fullRange, 0.0F, IceAgeBiomes.OCEAN);
        }
    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point) {
        this.addMidSlice(point, Climate.Parameter.span(-1.0F, -0.93333334F));
        this.addHighSlice(point, Climate.Parameter.span(-0.93333334F, -0.7666667F));
        this.addPeaks(point, Climate.Parameter.span(-0.7666667F, -0.56666666F));
        this.addHighSlice(point, Climate.Parameter.span(-0.56666666F, -0.4F));
        this.addMidSlice(point, Climate.Parameter.span(-0.4F, -0.26666668F));
        this.addLowSlice(point, Climate.Parameter.span(-0.26666668F, -0.05F));
        this.addValleys(point, Climate.Parameter.span(-0.05F, 0.05F));
        this.addLowSlice(point, Climate.Parameter.span(0.05F, 0.26666668F));
        this.addMidSlice(point, Climate.Parameter.span(0.26666668F, 0.4F));
        this.addHighSlice(point, Climate.Parameter.span(0.4F, 0.56666666F));
        this.addPeaks(point, Climate.Parameter.span(0.56666666F, 0.7666667F));
        this.addHighSlice(point, Climate.Parameter.span(0.7666667F, 0.93333334F));
        this.addMidSlice(point, Climate.Parameter.span(0.93333334F, 1.0F));
    }

    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point, Climate.Parameter span) {
        for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
            Climate.Parameter temperature = this.temperatures[temperatureIndex];

            for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
                Climate.Parameter humidity = this.humidities[humidityIndex];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(temperatureIndex, humidityIndex);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(temperatureIndex, humidityIndex);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], span, 0.0F, plateauBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.midInlandContinentalness, this.erosions[3], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.farInlandContinentalness, this.erosions[3], span, 0.0F, plateauBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, middleBiome);
            }
        }
    }

    private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point, Climate.Parameter span) {
        for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
            Climate.Parameter temperature = this.temperatures[temperatureIndex];

            for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
                Climate.Parameter humidity = this.humidities[humidityIndex];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(temperatureIndex, humidityIndex);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(temperatureIndex, humidityIndex);
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, this.erosions[0], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, this.erosions[1], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], span, 0.0F, plateauBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.midInlandContinentalness, this.erosions[3], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.farInlandContinentalness, this.erosions[3], span, 0.0F, plateauBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, middleBiome);
            }
        }

    }

    private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point, Climate.Parameter span) {
        this.addSurfaceBiome(point, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.fullRange, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, IceAgeBiomes.SWAMP);

        for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
            Climate.Parameter temperature = this.temperatures[temperatureIndex];

            for (int humidityIndex = 0; humidityIndex < this.humidities.length; ++humidityIndex) {
                Climate.Parameter humidity = this.humidities[humidityIndex];
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), span, 0.0F, this.pickBeachBiome(temperatureIndex, humidityIndex));
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(temperatureIndex, humidityIndex);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(temperatureIndex, humidityIndex);
                ResourceKey<Biome> beachBiome = this.pickBeachBiome(temperatureIndex, humidityIndex);
                ResourceKey<Biome> shatteredCoastBiome = this.pickShatteredCoastBiome(temperatureIndex, humidityIndex, span);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.farInlandContinentalness, this.erosions[1], span, 0.0F, temperatureIndex == 0 ? middleBiome : plateauBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, this.erosions[2], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.midInlandContinentalness, this.erosions[2], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.farInlandContinentalness, this.erosions[2], span, 0.0F, plateauBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], span, 0.0F, middleBiome);
                if (span.max() < 0L) {
                    this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[4], span, 0.0F, beachBiome);
                    this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], span, 0.0F, middleBiome);
                } else {
                    this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], span, 0.0F, middleBiome);
                }

                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[5], span, 0.0F, shatteredCoastBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], span, 0.0F, middleBiome);
                if (span.max() < 0L) {
                    this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[6], span, 0.0F, beachBiome);
                } else {
                    this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[6], span, 0.0F, middleBiome);
                }

                if (temperatureIndex == 0) {
                    this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, middleBiome);
                }
            }
        }

    }

    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point, Climate.Parameter span) {
        this.addSurfaceBiome(point, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.fullRange, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, IceAgeBiomes.SWAMP);

        for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
            Climate.Parameter temperature = this.temperatures[temperatureIndex];

            for (int humdityIndex = 0; humdityIndex < this.humidities.length; ++humdityIndex) {
                Climate.Parameter humidity = this.humidities[humdityIndex];
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), span, 0.0F, this.pickBeachBiome(temperatureIndex, humdityIndex));
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(temperatureIndex, humdityIndex);
                ResourceKey<Biome> beachBiome = this.pickBeachBiome(temperatureIndex, humdityIndex);
                ResourceKey<Biome> shatteredCoastBiome = this.pickShatteredCoastBiome(temperatureIndex, humdityIndex, span);
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), span, 0.0F, beachBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[5], span, 0.0F, shatteredCoastBiome);
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], span, 0.0F, middleBiome);
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[6], span, 0.0F, beachBiome);
                if (temperatureIndex == 0) {
                    this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, middleBiome);
                }
            }
        }

    }

    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point, Climate.Parameter span) {
        this.addSurfaceBiome(point, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.fullRange, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, IceAgeBiomes.SWAMP);

        for (int temperatureIndex = 0; temperatureIndex < this.temperatures.length; ++temperatureIndex) {
            Climate.Parameter temperature = this.temperatures[temperatureIndex];

            for (int humitityIndex = 0; humitityIndex < this.humidities.length; ++humitityIndex) {
                Climate.Parameter humidity = this.humidities[humitityIndex];
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, span.max() < 0L ? this.pickBeachBiome(temperatureIndex, humitityIndex) : this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, span.max() < 0L ? this.pickBeachBiome(temperatureIndex, humitityIndex) : this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, span.max() < 0L ? this.pickBeachBiome(temperatureIndex, humitityIndex) : this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[6], span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[6], span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, this.coastContinentalness, this.erosions[6], span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], span, 0.0F, this.pickRiverBiome(temperatureIndex, humitityIndex));
                this.addSurfaceBiome(point, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), span, 0.0F, IceAgeBiomes.COLD_PLAINS);
            }
        }

    }

    private ResourceKey<Biome> pickMiddleBiome(int temperature, int humidity) {
        return this.middleBiomes[temperature][humidity];
    }

    private ResourceKey<Biome> pickShatteredCoastBiome(int temperature, int humidity, Climate.Parameter span) {
        return span.max() >= 0L ? this.pickMiddleBiome(temperature, humidity) : this.pickBeachBiome(temperature, humidity);
    }

    private ResourceKey<Biome> pickBeachBiome(int temperature, int humidity) {
        return this.beachBiomes[temperature][humidity];
    }

    private ResourceKey<Biome> pickRiverBiome(int temperature, int humidity) {
        return this.riverBiomes[temperature][humidity];
    }

    private ResourceKey<Biome> pickPlateauBiome(int temperature, int humidity) {
        return this.plateauBiomes[temperature][humidity];
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> point, Climate.Parameter temperatureRange, Climate.Parameter humidityRange, Climate.Parameter continentalnessRange, Climate.Parameter erosionRange, Climate.Parameter depthRange, float weirdness, ResourceKey<Biome> biome) {
        point.accept(Pair.of(Climate.parameters(temperatureRange, humidityRange, continentalnessRange, erosionRange, Climate.Parameter.point(0.0F), depthRange, weirdness), biome));
        point.accept(Pair.of(Climate.parameters(temperatureRange, humidityRange, continentalnessRange, erosionRange, Climate.Parameter.point(1.0F), depthRange, weirdness), biome));
    }
}
