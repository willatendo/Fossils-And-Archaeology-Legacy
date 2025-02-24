package willatendo.fossilslegacy.client.animation.json;

import com.mojang.serialization.Codec;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.StringRepresentable;
import org.joml.Vector3f;

public enum KeyframeType implements StringRepresentable {
    ROTATION("rotation", AnimationChannel.Targets.ROTATION, KeyframeAnimations::degreeVec),
    POSITION("position", AnimationChannel.Targets.POSITION, KeyframeAnimations::posVec),
    SCALE("scale", AnimationChannel.Targets.SCALE, KeyframeAnimations::scaleVec);

    public static final Codec<KeyframeType> CODEC = StringRepresentable.fromValues(KeyframeType::values);

    private final String name;
    private final AnimationChannel.Target target;
    private final KeyframeType.VectorType vectorType;

    KeyframeType(String name, AnimationChannel.Target target, KeyframeType.VectorType vectorType) {
        this.name = name;
        this.target = target;
        this.vectorType = vectorType;
    }

    public AnimationChannel.Target getTarget() {
        return this.target;
    }

    public KeyframeType.VectorType getVectorType() {
        return this.vectorType;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @FunctionalInterface
    public interface VectorType {
        Vector3f create(float x, float y, float z);
    }
}
