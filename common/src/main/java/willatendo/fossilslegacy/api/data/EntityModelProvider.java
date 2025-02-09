package willatendo.fossilslegacy.api.data;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public abstract class EntityModelProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;
    private final String modId;
    protected final Map<ResourceLocation, JsonModel> jsonModels = new HashMap<>();

    public EntityModelProvider(PackOutput packOutput, String modId) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "fossilslegacy/models");
        this.modId = modId;
    }

    protected void add(EntityModelHolder entityModelHolder) {
        List<ResourceLocation> walkAnimations = new ArrayList<>();
        List<ResourceLocation> swimAnimations = new ArrayList<>();
        List<ResourceLocation> flyAnimations = new ArrayList<>();
        List<ResourceLocation> floatDownAnimations = new ArrayList<>();
        List<ResourceLocation> headAnimations = new ArrayList<>();
        List<ResourceLocation> shakeAnimations = new ArrayList<>();
        List<ResourceLocation> sitAnimations = new ArrayList<>();
        List<ResourceLocation> tailAnimations = new ArrayList<>();
        List<ResourceLocation> landAnimations = new ArrayList<>();
        entityModelHolder.animations().forEach((type, animations) -> {
            switch (type) {
                case "walk" -> walkAnimations.addAll(animations);
                case "swim" -> swimAnimations.addAll(animations);
                case "fly" -> flyAnimations.addAll(animations);
                case "float_down" -> floatDownAnimations.addAll(animations);
                case "head" -> headAnimations.addAll(animations);
                case "shake" -> shakeAnimations.addAll(animations);
                case "sit" -> sitAnimations.addAll(animations);
                case "tail" -> tailAnimations.addAll(animations);
                case "land" -> landAnimations.addAll(animations);
            }
        });

        List<JsonModel.Element> elements = new ArrayList<>();
        LayerDefinition layerDefinition = entityModelHolder.layerDefinition();
        this.createElements(elements, layerDefinition.mesh.getRoot());
        Optional<List<String>> headPieces = Optional.empty();
        if (entityModelHolder.headPieces().length > 0) {
            headPieces = Optional.of(List.of(entityModelHolder.headPieces()));
        }
        this.jsonModels.put(entityModelHolder.id(), new JsonModel(new JsonModel.Animations(Optional.of(walkAnimations), Optional.of(swimAnimations), Optional.of(flyAnimations), Optional.of(floatDownAnimations), Optional.of(headAnimations), Optional.of(shakeAnimations), Optional.of(sitAnimations), Optional.of(tailAnimations), Optional.of(landAnimations)), elements, headPieces, entityModelHolder.id(), entityModelHolder.overrideReset(), layerDefinition.material.xTexSize, layerDefinition.material.yTexSize));
    }

    private void createElements(List<JsonModel.Element> elements, PartDefinition partDefinition) {
        List<JsonModel.Box> boxes = new ArrayList<>();
        partDefinition.cubes.forEach(cubeDefinition -> {
            Optional<Boolean> mirror = Optional.empty();
            if (cubeDefinition.mirror) {
                mirror = Optional.of(true);
            }
            boxes.add(new JsonModel.Box((int) cubeDefinition.texCoord.u(), (int) cubeDefinition.texCoord.v(), (int) cubeDefinition.origin.x(), (int) cubeDefinition.dimensions.x(), (int) cubeDefinition.origin.y(), (int) cubeDefinition.dimensions.y(), (int) cubeDefinition.origin.z(), (int) cubeDefinition.dimensions.z(), mirror));
        });
        Optional<Float> xRot = Optional.empty();
        Optional<Float> yRot = Optional.empty();
        Optional<Float> zRot = Optional.empty();
        if (partDefinition.partPose.xRot() != 0.0F || partDefinition.partPose.yRot() != 0.0F || partDefinition.partPose.zRot() != 0.0F) {
            xRot = Optional.of(partDefinition.partPose.xRot());
            yRot = Optional.of(partDefinition.partPose.yRot());
            zRot = Optional.of(partDefinition.partPose.zRot());
        }
        List<JsonModel.SubElement> children = new ArrayList<>();
        partDefinition.children.forEach((name, childrenPartDefinition) -> this.createSubElements(children, partDefinition));
        elements.add(new JsonModel.Element(boxes, null, new JsonModel.Pose(partDefinition.partPose.x(), partDefinition.partPose.y(), partDefinition.partPose.z(), xRot, yRot, zRot), !children.isEmpty() ? Optional.of(children) : Optional.empty()));
    }

    private void createSubElements(List<JsonModel.SubElement> subElements, PartDefinition partDefinition) {
        List<JsonModel.Box> boxes = new ArrayList<>();
        partDefinition.cubes.forEach(cubeDefinition -> {
            Optional<Boolean> mirror = Optional.empty();
            if (cubeDefinition.mirror) {
                mirror = Optional.of(true);
            }
            boxes.add(new JsonModel.Box((int) cubeDefinition.texCoord.u(), (int) cubeDefinition.texCoord.v(), (int) cubeDefinition.origin.x(), (int) cubeDefinition.dimensions.x(), (int) cubeDefinition.origin.y(), (int) cubeDefinition.dimensions.y(), (int) cubeDefinition.origin.z(), (int) cubeDefinition.dimensions.z(), mirror));
        });
        Optional<Float> xRot = Optional.empty();
        Optional<Float> yRot = Optional.empty();
        Optional<Float> zRot = Optional.empty();
        if (partDefinition.partPose.xRot() != 0.0F || partDefinition.partPose.yRot() != 0.0F || partDefinition.partPose.zRot() != 0.0F) {
            xRot = Optional.of(partDefinition.partPose.xRot());
            yRot = Optional.of(partDefinition.partPose.yRot());
            zRot = Optional.of(partDefinition.partPose.zRot());
        }
        List<JsonModel.Element> children = new ArrayList<>();
        partDefinition.children.forEach((name, childrenPartDefinition) -> this.createElements(children, partDefinition));
        subElements.add(new JsonModel.SubElement(boxes, null, new JsonModel.Pose(partDefinition.partPose.x(), partDefinition.partPose.y(), partDefinition.partPose.z(), xRot, yRot, zRot), !children.isEmpty() ? Optional.of(children) : Optional.empty()));
    }

    protected abstract void getAll();

    protected ResourceLocation mod(String name) {
        return SimpleUtils.resource(this.modId, name);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.getAll();
        return DataProvider.saveAll(cachedOutput, JsonModel.CODEC, this.pathProvider::json, this.jsonModels);
    }

    @Override
    public String getName() {
        return "Entity Models: " + this.modId;
    }
}
