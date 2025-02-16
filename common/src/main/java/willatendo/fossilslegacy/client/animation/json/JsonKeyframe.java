package willatendo.fossilslegacy.client.animation.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;

public record JsonKeyframe(Vector vector, String interpolation, float timeStamp) {
    public static final Codec<JsonKeyframe> CODEC = RecordCodecBuilder.create(instance -> instance.group(Vector.CODEC.fieldOf("vector").forGetter(JsonKeyframe::vector), Codec.STRING.fieldOf("interpolation").forGetter(JsonKeyframe::interpolation), ExtraCodecs.NON_NEGATIVE_FLOAT.fieldOf("timestamp").forGetter(JsonKeyframe::timeStamp)).apply(instance, JsonKeyframe::new));

    public static JsonKeyframe create(float timeStamp, float x, float y, float z, String interpolation) {
        return new JsonKeyframe(new JsonKeyframe.Vector(x, y, z), interpolation, timeStamp);
    }

    public record Vector(float x, float y, float z) {
        public static final Codec<Vector> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("x").forGetter(Vector::x), Codec.FLOAT.fieldOf("y").forGetter(Vector::y), Codec.FLOAT.fieldOf("z").forGetter(Vector::z)).apply(instance, Vector::new));
    }
}
