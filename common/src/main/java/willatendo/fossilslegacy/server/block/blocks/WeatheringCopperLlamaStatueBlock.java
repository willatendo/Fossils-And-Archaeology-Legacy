package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperLlamaStatueBlock extends LlamaStatueBlock implements WeatheringCopper {
    public static final MapCodec<WeatheringCopperLlamaStatueBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), Block.propertiesCodec()).apply(instance, WeatheringCopperLlamaStatueBlock::new));
    private final WeatheringCopper.WeatherState weatherState;

    @Override
    public MapCodec<? extends WeatheringCopperLlamaStatueBlock> codec() {
        return CODEC;
    }

    public WeatheringCopperLlamaStatueBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.changeOverTime(blockState, serverLevel, blockPos, randomSource);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopper.getNext(blockState.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
