package willatendo.fossilslegacy.client.animation.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record JsonAnimation(List<Animation> animations, ResourceLocation id, float length, Optional<Boolean> loops) {
    public static final Codec<JsonAnimation> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(JsonAnimation.Animation.CODEC).fieldOf("animations").forGetter(JsonAnimation::animations), ResourceLocation.CODEC.fieldOf("id").forGetter(JsonAnimation::id), Codec.FLOAT.fieldOf("length").forGetter(JsonAnimation::length), Codec.BOOL.optionalFieldOf("looping").forGetter(JsonAnimation::loops)).apply(instance, JsonAnimation::new));

    public boolean looping() {
        return this.loops.orElse(false);
    }

    public AnimationDefinition toAnimationDefinition() {
        AnimationDefinition.Builder builder = AnimationDefinition.Builder.withLength(this.length);
        if (this.looping()) {
            builder.looping();
        }
        this.animations().forEach(animation -> {
            AnimationChannel.Target target = null;
            switch (animation.target()) {
                case "position" -> target = AnimationChannel.Targets.POSITION;
                case "scale" -> target = AnimationChannel.Targets.SCALE;
                default -> target = AnimationChannel.Targets.ROTATION;
            }
            List<Keyframe> keyframes = new ArrayList<>();
            animation.jsonKeyframes().forEach(jsonKeyframe -> keyframes.add(new Keyframe(jsonKeyframe.timeStamp(), new Vector3f(jsonKeyframe.vector().x(), jsonKeyframe.vector().y(), jsonKeyframe.vector().z()), jsonKeyframe.interpolation().equals("linear") ? AnimationChannel.Interpolations.LINEAR : AnimationChannel.Interpolations.CATMULLROM)));
            builder.addAnimation(animation.bone(), new AnimationChannel(target, keyframes.toArray(Keyframe[]::new)));
        });
        return builder.build();
    }

    public record Animation(String bone, String target, List<JsonKeyframe> jsonKeyframes) {
        public static final Codec<JsonAnimation.Animation> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.STRING.fieldOf("bone").forGetter(JsonAnimation.Animation::bone), Codec.STRING.fieldOf("target").forGetter(JsonAnimation.Animation::target), Codec.list(JsonKeyframe.CODEC).fieldOf("keyframes").forGetter(JsonAnimation.Animation::jsonKeyframes)).apply(instance, JsonAnimation.Animation::new));
    }

    public record JsonKeyframe(Vector vector, String interpolation, float timeStamp) {
        public static final Codec<JsonKeyframe> CODEC = RecordCodecBuilder.create(instance -> instance.group(JsonAnimation.Vector.CODEC.fieldOf("vector").forGetter(JsonKeyframe::vector), Codec.STRING.fieldOf("interpolation").forGetter(JsonKeyframe::interpolation), ExtraCodecs.NON_NEGATIVE_FLOAT.fieldOf("timestamp").forGetter(JsonKeyframe::timeStamp)).apply(instance, JsonKeyframe::new));
    }

    public record Vector(float x, float y, float z) {
        public static final Codec<JsonAnimation.Vector> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("x").forGetter(Vector::x), Codec.FLOAT.fieldOf("y").forGetter(Vector::y), Codec.FLOAT.fieldOf("z").forGetter(Vector::z)).apply(instance, Vector::new));
    }
}
