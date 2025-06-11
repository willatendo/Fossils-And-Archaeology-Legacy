package willatendo.fossilslegacy.client.model.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Optional;

public record JsonBox(int textureXOffset, int textureYOffset, float xDimension, float xOrigin, float yDimension, float yOrigin, float zDimension, float zOrigin, Optional<Boolean> mirror) {
    public static final Codec<JsonBox> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("texture_x_offset").forGetter(JsonBox::textureXOffset), Codec.INT.fieldOf("texture_y_offset").forGetter(JsonBox::textureYOffset), Codec.FLOAT.fieldOf("x_dimension").forGetter(JsonBox::xDimension), Codec.FLOAT.fieldOf("x_origin").forGetter(JsonBox::xOrigin), Codec.FLOAT.fieldOf("y_dimension").forGetter(JsonBox::yDimension), Codec.FLOAT.fieldOf("y_origin").forGetter(JsonBox::yOrigin), Codec.FLOAT.fieldOf("z_dimension").forGetter(JsonBox::zDimension), Codec.FLOAT.fieldOf("z_origin").forGetter(JsonBox::zOrigin), Codec.BOOL.optionalFieldOf("mirror").forGetter(JsonBox::mirror)).apply(instance, JsonBox::new));

    public boolean isMirrored() {
        return this.mirror().orElse(false);
    }

    public static JsonBox.Builder builder(int textureXOffset, int textureYOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension) {
        return new JsonBox.Builder(textureXOffset, textureYOffset, xOrigin, yOrigin, zOrigin, xDimension, yDimension, zDimension);
    }

    public static final class Builder {
        private final int textureXOffset;
        private final int textureYOffset;
        private final float xOrigin;
        private final float yOrigin;
        private final float zOrigin;
        private final float xDimension;
        private final float yDimension;
        private final float zDimension;
        private boolean mirror = false;

        private Builder(int textureXOffset, int textureYOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension) {
            this.textureXOffset = textureXOffset;
            this.textureYOffset = textureYOffset;
            this.xOrigin = xOrigin;
            this.yOrigin = yOrigin;
            this.zOrigin = zOrigin;
            this.xDimension = xDimension;
            this.yDimension = yDimension;
            this.zDimension = zDimension;
        }

        public Builder mirror() {
            this.mirror = true;
            return this;
        }

        public JsonBox build() {
            return new JsonBox(this.textureXOffset, this.textureYOffset, this.xDimension, this.xOrigin, this.yDimension, this.yOrigin, this.zDimension, this.zOrigin, this.mirror ? Optional.of(true) : Optional.empty());
        }
    }
}
