package willatendo.fossilslegacy.client.animation.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record JsonAnimation(List<JsonAnimationChannel> jsonAnimationChannels, float length, Optional<Boolean> loops) {
    public static final Codec<JsonAnimation> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(JsonAnimationChannel.CODEC).fieldOf("animation_channels").forGetter(JsonAnimation::jsonAnimationChannels), Codec.FLOAT.fieldOf("length").forGetter(JsonAnimation::length), Codec.BOOL.optionalFieldOf("looping").forGetter(JsonAnimation::loops)).apply(instance, JsonAnimation::new));

    public static JsonAnimation.Builder builder(float length) {
        return new JsonAnimation.Builder(length);
    }

    public boolean looping() {
        return this.loops.orElse(false);
    }

    public AnimationDefinition toAnimationDefinition() {
        AnimationDefinition.Builder builder = AnimationDefinition.Builder.withLength(this.length);
        if (this.looping()) {
            builder.looping();
        }
        this.jsonAnimationChannels().forEach(animation -> {
            KeyframeType target = animation.target();
            List<Keyframe> keyframes = new ArrayList<>();
            animation.jsonKeyframes().forEach(jsonKeyframe -> keyframes.add(new Keyframe(jsonKeyframe.timeStamp(), target.getVectorType().create(jsonKeyframe.vector().x(), jsonKeyframe.vector().y(), jsonKeyframe.vector().z()), jsonKeyframe.interpolation().equals("linear") ? AnimationChannel.Interpolations.LINEAR : AnimationChannel.Interpolations.CATMULLROM)));
            builder.addAnimation(animation.bone(), new AnimationChannel(target.getTarget(), keyframes.toArray(Keyframe[]::new)));
        });
        return builder.build();
    }

    public static final class Builder {
        private final List<JsonAnimationChannel> jsonAnimationChannels = new ArrayList<>();
        private final float length;
        private boolean loops = false;

        private Builder(float length) {
            this.length = length;
        }

        public Builder looping() {
            this.loops = true;
            return this;
        }

        public Builder addAnimation(String bone, String target, JsonKeyframe... jsonKeyframes) {
            this.jsonAnimationChannels.add(new JsonAnimationChannel(bone, KeyframeType.valueOf(target.toUpperCase()), List.of(jsonKeyframes)));
            return this;
        }

        public JsonAnimation build() {
            return new JsonAnimation(this.jsonAnimationChannels, this.length, this.loops ? Optional.of(true) : Optional.empty());
        }
    }
}
