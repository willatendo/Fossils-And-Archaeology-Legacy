package willatendo.fossilslegacy.client.model.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public record JsonElement(List<JsonBox> boxes, String id, JsonPose jsonPose, Optional<List<JsonElement>> jsonElements) {
    public static final Codec<JsonElement> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(JsonBox.CODEC).fieldOf("boxes").forGetter(JsonElement::boxes), Codec.STRING.fieldOf("id").forGetter(JsonElement::id), JsonPose.CODEC.fieldOf("poses").forGetter(JsonElement::jsonPose), Codec.list(Codec.<JsonElement>recursive(JsonElement.class.getSimpleName(), codec -> RecordCodecBuilder.create(recursedInstance -> recursedInstance.group(Codec.list(JsonBox.CODEC).fieldOf("boxes").forGetter(JsonElement::boxes), Codec.STRING.fieldOf("id").forGetter(JsonElement::id), JsonPose.CODEC.fieldOf("poses").forGetter(JsonElement::jsonPose), Codec.list(codec).optionalFieldOf("elements").forGetter(JsonElement::jsonElements)).apply(recursedInstance, JsonElement::new)))).optionalFieldOf("elements").forGetter(JsonElement::jsonElements)).apply(instance, JsonElement::new));

    public boolean hasChild() {
        return this.jsonElements.isPresent();
    }

    public static JsonElement.Builder builder(String name, JsonPose jsonPose) {
        return new JsonElement.Builder(name, jsonPose);
    }

    public static final class Builder {
        private final List<JsonBox> jsonBox = new ArrayList<>();
        private final List<JsonElement> children = new ArrayList<>();
        private final String name;
        private final JsonPose jsonPose;

        private Builder(String name, JsonPose jsonPose) {
            this.name = name;
            this.jsonPose = jsonPose;
        }

        public Builder addBox(JsonBox jsonBox) {
            this.jsonBox.add(jsonBox);
            return this;
        }

        public Builder addBox(int textureXOffset, int textureYOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension, boolean mirror) {
            JsonBox.Builder builder = JsonBox.builder(textureXOffset, textureYOffset, xOrigin, yOrigin, zOrigin, xDimension, yDimension, zDimension);
            if (mirror) {
                builder.mirror();
            }
            this.addBox(builder.build());
            return this;
        }

        public Builder addBox(int textureXOffset, int textureYOffset, float xOrigin, float yOrigin, float zOrigin, float xDimension, float yDimension, float zDimension) {
            this.addBox(textureXOffset, textureYOffset, xOrigin, yOrigin, zOrigin, xDimension, yDimension, zDimension, false);
            return this;
        }

        public Builder addChild(JsonElement jsonElement) {
            this.children.add(jsonElement);
            return this;
        }

        public Builder addOrReplaceChild(String name, Function<Builder, JsonElement> jsonElement, JsonPose jsonPose) {
            this.addChild(jsonElement.apply(JsonElement.builder(name, jsonPose)));
            return this;
        }

        public JsonElement build() {
            return new JsonElement(this.jsonBox, this.name, this.jsonPose, this.children.isEmpty() ? Optional.empty() : Optional.of(this.children));
        }
    }
}
