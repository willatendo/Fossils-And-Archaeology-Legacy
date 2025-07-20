package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Unit;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.data_components.CosmeticGeneticInformation;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.PatternHolder;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.UUID;

public final class FADataComponents {
    public static final SimpleRegistry<DataComponentType<?>> DATA_COMPONENT_TYPES = SimpleRegistry.create(Registries.DATA_COMPONENT_TYPE, FAUtils.ID);

    public static final SimpleHolder<DataComponentType<Unit>> BURNING = DATA_COMPONENT_TYPES.register("burning", () -> DataComponentType.<Unit>builder().persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Holder<CommandType>>> COMMAND_TYPE = DATA_COMPONENT_TYPES.register("command_type", () -> DataComponentType.<Holder<CommandType>>builder().persistent(CommandType.CODEC).networkSynchronized(CommandType.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<CosmeticGeneticInformation>> COSMETIC_GENETIC_INFORMATION = DATA_COMPONENT_TYPES.register("cosmetic_genetic_information", () -> DataComponentType.<CosmeticGeneticInformation>builder().persistent(CosmeticGeneticInformation.CODEC).networkSynchronized(CosmeticGeneticInformation.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Holder<FossilVariant>>> FOSSIL_VARIANT = DATA_COMPONENT_TYPES.register("fossil_variant", () -> DataComponentType.<Holder<FossilVariant>>builder().persistent(FossilVariant.CODEC).networkSynchronized(FossilVariant.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<UUID>> GENETIC_CODE = DATA_COMPONENT_TYPES.register("genetic_code", () -> DataComponentType.<UUID>builder().persistent(UUIDUtil.CODEC).networkSynchronized(UUIDUtil.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Holder<ModelType>>> MODEL_TYPE = DATA_COMPONENT_TYPES.register("model_type", () -> DataComponentType.<Holder<ModelType>>builder().persistent(ModelType.CODEC).networkSynchronized(ModelType.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<PatternHolder>> PATTERN_HOLDER = DATA_COMPONENT_TYPES.register("pattern_holder", () -> DataComponentType.<PatternHolder>builder().persistent(PatternHolder.CODEC).networkSynchronized(PatternHolder.STREAM_CODEC).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<Integer>> PURITY = DATA_COMPONENT_TYPES.register("purity", () -> DataComponentType.<Integer>builder().persistent(ExtraCodecs.intRange(1, 100)).networkSynchronized(ByteBufCodecs.VAR_INT).cacheEncoding().build());
    public static final SimpleHolder<DataComponentType<UUID>> LOCK = DATA_COMPONENT_TYPES.register("lock", () -> DataComponentType.<UUID>builder().persistent(UUIDUtil.CODEC).networkSynchronized(UUIDUtil.STREAM_CODEC).cacheEncoding().build());
}