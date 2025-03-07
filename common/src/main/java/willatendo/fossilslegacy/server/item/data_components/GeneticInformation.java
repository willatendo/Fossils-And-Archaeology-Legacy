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

public record GeneticInformation(Optional<TagKey<ModelType>> carriedModelInformation, Optional<TagKey<Pattern>> carriedSkinsInformation, Optional<TagKey<Pattern>> carriedPatternsInformation) {
    public static final Codec<GeneticInformation> CODEC = RecordCodecBuilder.create(instance -> instance.group(TagKey.codec(FARegistries.MODEL_TYPES).optionalFieldOf("carried_model_information").forGetter(GeneticInformation::carriedModelInformation), TagKey.codec(FARegistries.PATTERN).optionalFieldOf("carried_skins_information").forGetter(GeneticInformation::carriedSkinsInformation), TagKey.codec(FARegistries.PATTERN).optionalFieldOf("carried_patterns_information").forGetter(GeneticInformation::carriedPatternsInformation)).apply(instance, GeneticInformation::new));
    public static final StreamCodec<ByteBuf, GeneticInformation> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.optional(TagKey.streamCodec(FARegistries.MODEL_TYPES)), GeneticInformation::carriedModelInformation, ByteBufCodecs.optional(TagKey.streamCodec(FARegistries.PATTERN)), GeneticInformation::carriedSkinsInformation, ByteBufCodecs.optional(TagKey.streamCodec(FARegistries.PATTERN)), GeneticInformation::carriedPatternsInformation, GeneticInformation::new);
}
