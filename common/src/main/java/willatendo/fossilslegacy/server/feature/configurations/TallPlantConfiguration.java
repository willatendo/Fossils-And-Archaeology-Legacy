package willatendo.fossilslegacy.server.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record TallPlantConfiguration(BlockStateProvider head, BlockStateProvider log, IntProvider height) implements FeatureConfiguration {
    public static final Codec<TallPlantConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(BlockStateProvider.CODEC.fieldOf("head").forGetter(TallPlantConfiguration::head), BlockStateProvider.CODEC.fieldOf("log").forGetter(TallPlantConfiguration::log), IntProvider.CODEC.fieldOf("height").forGetter(TallPlantConfiguration::height)).apply(instance, TallPlantConfiguration::new));
}
