package willatendo.fossilslegacy.server.pattern_type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;
import willatendo.fossilslegacy.server.entity.genetics.GeneticType;
import willatendo.fossilslegacy.server.pattern_type.information.PatternInformation;
import willatendo.fossilslegacy.server.registry.FARegistries;

public record PatternType(GeneticType geneticType, PatternInformation patternInformation) {
    public static final Codec<PatternType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(GeneticType.CODEC.fieldOf("genetic_type").forGetter(PatternType::geneticType), PatternInformation.CODEC.fieldOf("pattern_information").forGetter(PatternType::patternInformation)).apply(instance, PatternType::new));
    public static final Codec<Holder<PatternType>> CODEC = RegistryFileCodec.create(FARegistries.PATTERN_TYPES, DIRECT_CODEC);
}
