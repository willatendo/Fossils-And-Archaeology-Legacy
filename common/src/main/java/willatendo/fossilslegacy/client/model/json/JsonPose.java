package willatendo.fossilslegacy.client.model.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.geom.PartPose;

public record JsonPose(float x, float y, float z, float xRot, float yRot, float zRot) {
    public static final Codec<JsonPose> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("x").forGetter(JsonPose::x), Codec.FLOAT.fieldOf("y").forGetter(JsonPose::y), Codec.FLOAT.fieldOf("z").forGetter(JsonPose::z), Codec.FLOAT.fieldOf("x_rot").forGetter(JsonPose::xRot), Codec.FLOAT.fieldOf("y_rot").forGetter(JsonPose::yRot), Codec.FLOAT.fieldOf("z_rot").forGetter(JsonPose::zRot)).apply(instance, JsonPose::new));

    public boolean hasRot() {
        return this.xRot() != 0.0F || this.yRot() != 0.0F || this.zRot() != 0.0F;
    }

    public PartPose toPartPose() {
        return this.hasRot() ? PartPose.offsetAndRotation(this.x(), this.y(), this.z(), this.xRot(), this.yRot(), this.zRot()) : PartPose.offset(this.x(), this.y(), this.z());
    }

    public static JsonPose offset(float x, float y, float z) {
        return JsonPose.builder(x, y, z).build();
    }

    public static JsonPose offsetAndRotation(float x, float y, float z, float xRot, float yRot, float zRot) {
        return JsonPose.builder(x, y, z).withRot(xRot, yRot, zRot).build();
    }

    private static JsonPose.Builder builder(float x, float y, float z) {
        return new JsonPose.Builder(x, y, z);
    }

    public static final class Builder {
        private final float x;
        private final float y;
        private final float z;
        private float xRot = 0.0F;
        private float yRot = 0.0F;
        private float zRot = 0.0F;

        private Builder(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Builder withRot(float xRot, float yRot, float zRot) {
            this.xRot = xRot;
            this.yRot = yRot;
            this.zRot = zRot;
            return this;
        }

        public JsonPose build() {
            return new JsonPose(this.x, this.y, this.z, this.xRot, this.yRot, this.zRot);
        }
    }
}
