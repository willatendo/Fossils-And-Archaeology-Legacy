package willatendo.fossilslegacy.api.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class EntityModelProvider implements DataProvider {
    private final PackOutput packOutput;
    private final String modId;
    protected final List<ModelHolder> models = Lists.newArrayList();

    public EntityModelProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected void add(String id, LayerDefinition layerDefinition, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName, BuiltInAnimationType animations, String... headPieces) {
        this.add(id, layerDefinition, animationName, animations.getId(), headPieces);
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, BuiltInAnimationType animation1, String animationName2, BuiltInAnimationType animation2, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName1, animation1.getId(), animationName2, animation2.getId()), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, BuiltInAnimationType animation1, String animationName2, BuiltInAnimationType animation2, String animationName3, BuiltInAnimationType animation3, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName1, animation1.getId(), animationName2, animation2.getId(), animationName3, animation3.getId()), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, BuiltInAnimationType animation1, String animationName2, BuiltInAnimationType animation2, String animationName3, BuiltInAnimationType animation3, String animationName4, BuiltInAnimationType animation4, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName1, animation1.getId(), animationName2, animation2.getId(), animationName3, animation3.getId(), animationName4, animation4.getId()), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName, ResourceLocation animation, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName, animation), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, ResourceLocation animation1, String animationName2, ResourceLocation animation2, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName1, animation1, animationName2, animation2), headPieces));
    }

    protected abstract void getAll();

    protected ResourceLocation mod(String name) {
        return SimpleUtils.resource(this.modId, name);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.models.clear();
        this.getAll();
        List<CompletableFuture<?>> completableFutures = Lists.newArrayList();
        this.models.forEach(model -> {
            ResourceLocation id = model.id();
            LayerDefinition layerDefinition = model.layerDefinition();
            JsonObject jsonObject = new JsonObject();
            JsonObject animations = new JsonObject();
            model.animations().forEach((animationName, animation) -> {
                animations.addProperty(animationName, animation.toString());
            });
            jsonObject.add("animations", animations);
            jsonObject.addProperty("model_layer_location", id.toString());
            if (model.headPieces().length > 0) {
                JsonArray headPieces = new JsonArray();
                for (String headPiece : model.headPieces()) {
                    headPieces.add(headPiece);
                }
                jsonObject.add("head_pieces", headPieces);
            }
            jsonObject.addProperty("texture_height", layerDefinition.material.yTexSize);
            jsonObject.addProperty("texture_width", layerDefinition.material.xTexSize);
            JsonArray elements = new JsonArray();
            PartDefinition root = layerDefinition.mesh.getRoot();
            for (Map.Entry<String, PartDefinition> entry1 : root.children.entrySet()) {
                PartDefinition partDefinition1 = entry1.getValue();
                this.createEntry(elements, null, partDefinition1, entry1.getKey());
                for (Map.Entry<String, PartDefinition> children1 : partDefinition1.children.entrySet()) {
                    PartDefinition partDefinition2 = children1.getValue();
                    this.createEntry(elements, entry1.getKey(), partDefinition2, children1.getKey());
                    for (Map.Entry<String, PartDefinition> children2 : partDefinition2.children.entrySet()) {
                        PartDefinition partDefinition3 = children2.getValue();
                        this.createEntry(elements, children1.getKey(), partDefinition3, children2.getKey());
                        for (Map.Entry<String, PartDefinition> children3 : partDefinition3.children.entrySet()) {
                            PartDefinition partDefinition4 = children3.getValue();
                            this.createEntry(elements, children2.getKey(), partDefinition4, children3.getKey());
                            for (Map.Entry<String, PartDefinition> children4 : partDefinition4.children.entrySet()) {
                                PartDefinition partDefinition5 = children4.getValue();
                                this.createEntry(elements, children3.getKey(), partDefinition5, children4.getKey());
                                for (Map.Entry<String, PartDefinition> children5 : partDefinition5.children.entrySet()) {
                                    PartDefinition partDefinition6 = children5.getValue();
                                    this.createEntry(elements, children4.getKey(), partDefinition6, children5.getKey());
                                    for (Map.Entry<String, PartDefinition> children6 : partDefinition6.children.entrySet()) {
                                        PartDefinition partDefinition7 = children6.getValue();
                                        this.createEntry(elements, children5.getKey(), partDefinition7, children6.getKey());
                                        for (Map.Entry<String, PartDefinition> children7 : partDefinition7.children.entrySet()) {
                                            PartDefinition partDefinition8 = children7.getValue();
                                            this.createEntry(elements, children6.getKey(), partDefinition8, children7.getKey());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            jsonObject.add("elements", elements);
            completableFutures.add(DataProvider.saveStable(cachedOutput, jsonObject, this.packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(this.modId).resolve("fossilslegacy").resolve("models").resolve(id.getPath() + ".json")));
        });
        return CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new));
    }

    private void createEntry(JsonArray elements, String parent, PartDefinition partDefinition, String id) {
        JsonObject element = new JsonObject();
        element.addProperty("id", id);
        if (parent != null) {
            element.addProperty("parent", parent);
        }
        List<CubeDefinition> cubeDefinitions = partDefinition.cubes;
        JsonArray boxes = new JsonArray();
        for (CubeDefinition cubeDefinition : cubeDefinitions) {
            JsonObject box = new JsonObject();
            box.addProperty("texture_x_offset", (int) cubeDefinition.texCoord.u());
            box.addProperty("texture_y_offset", (int) cubeDefinition.texCoord.v());
            box.addProperty("x_origin", cubeDefinition.origin.x());
            box.addProperty("y_origin", cubeDefinition.origin.y());
            box.addProperty("z_origin", cubeDefinition.origin.z());
            box.addProperty("x_dimension", cubeDefinition.dimensions.x());
            box.addProperty("y_dimension", cubeDefinition.dimensions.y());
            box.addProperty("z_dimension", cubeDefinition.dimensions.z());
            if (cubeDefinition.mirror) {
                box.addProperty("mirror", true);
            }
            boxes.add(box);
        }
        element.add("boxes", boxes);
        JsonObject poses = new JsonObject();
        PartPose partPose = partDefinition.partPose;
        poses.addProperty("x", partPose.x);
        poses.addProperty("y", partPose.y);
        poses.addProperty("z", partPose.z);
        if (partPose.xRot != 0.0F) {
            poses.addProperty("x_rot", partPose.xRot);
        }
        if (partPose.yRot != 0.0F) {
            poses.addProperty("y_rot", partPose.yRot);
        }
        if (partPose.zRot != 0.0F) {
            poses.addProperty("z_rot", partPose.zRot);
        }
        element.add("poses", poses);
        elements.add(element);
    }

    @Override
    public String getName() {
        return "Entity Models: " + this.modId;
    }

    private record ModelHolder(ResourceLocation id, LayerDefinition layerDefinition, Map<String, ResourceLocation> animations, String... headPieces) {
    }
}
