package willatendo.fossilslegacy.client.model.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record JsonModel(JsonModel.Animations animations, List<JsonModel.Element> elements, Optional<List<String>> headPieces, ResourceLocation modelId, Optional<Boolean> overrideReset, int textureHeight, int textureWidth) {
    public static final Codec<JsonModel> CODEC = RecordCodecBuilder.create(instance -> instance.group(JsonModel.Animations.CODEC.fieldOf("animations").forGetter(JsonModel::animations), Codec.list(JsonModel.Element.CODEC).fieldOf("elements").forGetter(JsonModel::elements), Codec.list(Codec.STRING).optionalFieldOf("head_pieces").forGetter(JsonModel::headPieces), ResourceLocation.CODEC.fieldOf("model_id").forGetter(JsonModel::modelId), Codec.BOOL.optionalFieldOf("override_reset").forGetter(JsonModel::overrideReset), Codec.INT.fieldOf("texture_height").forGetter(JsonModel::textureHeight), Codec.INT.fieldOf("texture_width").forGetter(JsonModel::textureWidth)).apply(instance, JsonModel::new));

    public boolean isOverrideReset() {
        return this.overrideReset().orElse(false);
    }

    public LayerDefinition createModel() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        this.elements.forEach(element -> this.loadElement(element, root));
        return LayerDefinition.create(meshDefinition, this.textureWidth(), this.textureHeight());
    }

    private void loadElement(JsonModel.Element element, PartDefinition parent) {
        CubeListBuilder cubeListBuilder = CubeListBuilder.create();
        element.boxes().forEach(box -> {
            cubeListBuilder.texOffs(box.textureXOffset(), box.textureYOffset()).addBox(box.xOrigin(), box.yOrigin(), box.zOrigin(), box.xDimension(), box.yDimension(), box.zDimension());
            if (box.isMirrored()) {
                cubeListBuilder.mirror();
            }
        });
        PartDefinition partDefinition = parent.addOrReplaceChild(element.id(), cubeListBuilder, element.pose().toPartPose());
        if (element.hasChild()) {
            element.elements.get().forEach(subElement -> this.loadSubElement(subElement, partDefinition));
        }
    }

    private void loadSubElement(JsonModel.SubElement subElement, PartDefinition parent) {
        CubeListBuilder cubeListBuilder = CubeListBuilder.create();
        subElement.boxes().forEach(box -> {
            cubeListBuilder.texOffs(box.textureXOffset(), box.textureYOffset()).addBox(box.xOrigin(), box.yOrigin(), box.zOrigin(), box.xDimension(), box.yDimension(), box.zDimension());
            if (box.isMirrored()) {
                cubeListBuilder.mirror();
            }
        });
        PartDefinition partDefinition = parent.addOrReplaceChild(subElement.id(), cubeListBuilder, subElement.pose().toPartPose());
        if (subElement.hasChild()) {
            subElement.elements.get().forEach(element -> this.loadElement(element, partDefinition));
        }
    }

    public List<String> getLoadParts() {
        List<String> loadParts = new ArrayList<>();
        this.elements().forEach(element -> this.getLoadParts(element, loadParts));
        return loadParts;
    }

    private void getLoadParts(JsonModel.Element element, List<String> loadParts) {
        loadParts.add(element.id());
        if (element.hasChild()) {
            element.elements().get().forEach(subElement -> this.getLoadParts(subElement, loadParts));
        }
    }

    private void getLoadParts(JsonModel.SubElement subElement, List<String> loadParts) {
        loadParts.add(subElement.id());
        if (subElement.hasChild()) {
            subElement.elements().get().forEach(element -> this.getLoadParts(element, loadParts));
        }
    }

    public record Animations(Optional<List<ResourceLocation>> walkAnimation, Optional<List<ResourceLocation>> swimAnimation, Optional<List<ResourceLocation>> flyAnimation, Optional<List<ResourceLocation>> floatDownAnimation, Optional<List<ResourceLocation>> headAnimation, Optional<List<ResourceLocation>> shakeAnimation, Optional<List<ResourceLocation>> sitAnimation, Optional<List<ResourceLocation>> tailAnimation, Optional<List<ResourceLocation>> landAnimation) {
        public static final Codec<JsonModel.Animations> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(ResourceLocation.CODEC).optionalFieldOf("walk").forGetter(Animations::walkAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("swim").forGetter(Animations::swimAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("fly").forGetter(Animations::flyAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("float_down").forGetter(Animations::floatDownAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("head").forGetter(Animations::headAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("shake").forGetter(Animations::shakeAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("sit").forGetter(Animations::sitAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("tail").forGetter(Animations::tailAnimation), Codec.list(ResourceLocation.CODEC).optionalFieldOf("land").forGetter(Animations::landAnimation)).apply(instance, JsonModel.Animations::new));

        public AnimationHolder toAnimationHolder() {
            return new AnimationHolder(this.walkAnimation().orElse(List.of()), this.swimAnimation().orElse(List.of()), this.flyAnimation().orElse(List.of()), this.floatDownAnimation().orElse(List.of()), this.headAnimation().orElse(List.of()), this.shakeAnimation().orElse(List.of()), this.sitAnimation().orElse(List.of()), this.tailAnimation().orElse(List.of()), this.landAnimation().orElse(List.of()));
        }
    }

    public record Element(List<JsonModel.Box> boxes, String id, JsonModel.Pose pose, Optional<List<SubElement>> elements) {
        public static final Codec<JsonModel.Element> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(JsonModel.Box.CODEC).fieldOf("boxes").forGetter(JsonModel.Element::boxes), Codec.STRING.fieldOf("id").forGetter(JsonModel.Element::id), JsonModel.Pose.CODEC.fieldOf("poses").forGetter(JsonModel.Element::pose), Codec.list(JsonModel.SubElement.CODEC).optionalFieldOf("elements").forGetter(JsonModel.Element::elements)).apply(instance, JsonModel.Element::new));

        public boolean hasChild() {
            return this.elements().isPresent() && !this.elements().get().isEmpty();
        }
    }

    public record SubElement(List<JsonModel.Box> boxes, String id, JsonModel.Pose pose, Optional<List<Element>> elements) {
        public static final Codec<JsonModel.SubElement> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.list(JsonModel.Box.CODEC).fieldOf("boxes").forGetter(JsonModel.SubElement::boxes), Codec.STRING.fieldOf("id").forGetter(JsonModel.SubElement::id), JsonModel.Pose.CODEC.fieldOf("poses").forGetter(JsonModel.SubElement::pose), Codec.list(JsonModel.Element.CODEC).optionalFieldOf("elements").forGetter(JsonModel.SubElement::elements)).apply(instance, JsonModel.SubElement::new));

        public boolean hasChild() {
            return this.elements().isPresent() && !this.elements().get().isEmpty();
        }
    }

    public record Box(int textureXOffset, int textureYOffset, int xDimension, int xOrigin, int yDimension, int yOrigin, int zDimension, int zOrigin, Optional<Boolean> mirror) {
        public static final Codec<JsonModel.Box> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("texture_x_offset").forGetter(JsonModel.Box::textureXOffset), Codec.INT.fieldOf("texture_y_offset").forGetter(JsonModel.Box::textureYOffset), Codec.INT.fieldOf("x_dimension").forGetter(JsonModel.Box::xDimension), Codec.INT.fieldOf("x_origin").forGetter(JsonModel.Box::xOrigin), Codec.INT.fieldOf("y_dimension").forGetter(JsonModel.Box::yDimension), Codec.INT.fieldOf("y_origin").forGetter(JsonModel.Box::yOrigin), Codec.INT.fieldOf("z_dimension").forGetter(JsonModel.Box::zDimension), Codec.INT.fieldOf("z_origin").forGetter(JsonModel.Box::zOrigin), Codec.BOOL.optionalFieldOf("mirror").forGetter(JsonModel.Box::mirror)).apply(instance, JsonModel.Box::new));

        public boolean isMirrored() {
            return this.mirror().orElse(false);
        }
    }

    public record Pose(float x, float y, float z, Optional<Float> xRot, Optional<Float> yRot, Optional<Float> zRot) {
        public static final Codec<JsonModel.Pose> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("x").forGetter(JsonModel.Pose::x), Codec.FLOAT.fieldOf("y").forGetter(JsonModel.Pose::y), Codec.FLOAT.fieldOf("z").forGetter(JsonModel.Pose::z), Codec.FLOAT.optionalFieldOf("x_rot").forGetter(JsonModel.Pose::xRot), Codec.FLOAT.optionalFieldOf("y_rot").forGetter(JsonModel.Pose::yRot), Codec.FLOAT.optionalFieldOf("z_rot").forGetter(JsonModel.Pose::zRot)).apply(instance, JsonModel.Pose::new));

        public boolean hasRot() {
            return this.xRot().isPresent() || this.yRot().isPresent() || this.zRot().isPresent();
        }

        public PartPose toPartPose() {
            return this.hasRot() ? PartPose.offsetAndRotation(this.x(), this.y(), this.z(), this.xRot().orElse(0.0F), this.yRot().orElse(0.0F), this.zRot().orElse(0.0F)) : PartPose.offset(this.x(), this.y(), this.z());
        }
    }
}
