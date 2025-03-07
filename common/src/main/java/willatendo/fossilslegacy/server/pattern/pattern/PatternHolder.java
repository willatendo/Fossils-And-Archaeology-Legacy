package willatendo.fossilslegacy.server.pattern.pattern;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public record PatternHolder(Holder<Pattern> skin, Optional<Holder<Pattern>> pattern) {
    public static final Codec<PatternHolder> CODEC = RecordCodecBuilder.create(instance -> instance.group(Pattern.CODEC.fieldOf("skin").forGetter(PatternHolder::skin), Pattern.CODEC.optionalFieldOf("skin").forGetter(PatternHolder::pattern)).apply(instance, PatternHolder::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, PatternHolder> STREAM_CODEC = StreamCodec.composite(Pattern.STREAM_CODEC, PatternHolder::skin, ByteBufCodecs.optional(Pattern.STREAM_CODEC), PatternHolder::pattern, PatternHolder::new);

    public PatternHolder(Holder<Pattern> skin) {
        this(skin, Optional.empty());
    }

    public boolean hasPattern() {
        return this.pattern.isPresent();
    }

    public int getGeneColor() {
        return this.hasPattern() ? 0x000000 : this.skin.value().geneColor();
    }

    public Component getDisplayName() {
        if (this.hasPattern()) {
            return FAUtils.translation("pattern_holder", "composite", this.skin().value().patternName(), this.pattern().get().value().patternName());
        } else {
            return this.skin().value().patternName();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PatternHolder patternHolder) {
            return (this.hasPattern() && patternHolder.hasPattern()) ? this.pattern.get() == patternHolder.pattern.get() && this.skin() == patternHolder.skin() : (!this.hasPattern() && !patternHolder.hasPattern()) && this.skin() == patternHolder.skin();
        }
        return false;
    }
}
