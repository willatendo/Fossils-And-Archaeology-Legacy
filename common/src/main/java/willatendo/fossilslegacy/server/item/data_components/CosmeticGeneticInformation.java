package willatendo.fossilslegacy.server.item.data_components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public record CosmeticGeneticInformation(Optional<TagKey<ModelType>> carriedModelInformation, Optional<TagKey<Pattern>> carriedSkinsInformation, Optional<TagKey<Pattern>> carriedPatternsInformation) {
    public static final Codec<CosmeticGeneticInformation> CODEC = RecordCodecBuilder.create(instance -> instance.group(TagKey.codec(FARegistries.MODEL_TYPES).optionalFieldOf("carried_model_information").forGetter(CosmeticGeneticInformation::carriedModelInformation), TagKey.codec(FARegistries.PATTERN).optionalFieldOf("carried_skins_information").forGetter(CosmeticGeneticInformation::carriedSkinsInformation), TagKey.codec(FARegistries.PATTERN).optionalFieldOf("carried_patterns_information").forGetter(CosmeticGeneticInformation::carriedPatternsInformation)).apply(instance, CosmeticGeneticInformation::new));
    public static final StreamCodec<ByteBuf, CosmeticGeneticInformation> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.optional(TagKey.streamCodec(FARegistries.MODEL_TYPES)), CosmeticGeneticInformation::carriedModelInformation, ByteBufCodecs.optional(TagKey.streamCodec(FARegistries.PATTERN)), CosmeticGeneticInformation::carriedSkinsInformation, ByteBufCodecs.optional(TagKey.streamCodec(FARegistries.PATTERN)), CosmeticGeneticInformation::carriedPatternsInformation, CosmeticGeneticInformation::new);
}
