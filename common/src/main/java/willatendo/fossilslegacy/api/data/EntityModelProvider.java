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
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
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
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(), Map.of(), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName, BuiltInAnimationType animations, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(), Map.of(animationName, animations), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, BuiltInAnimationType animation1, String animationName2, BuiltInAnimationType animation2, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(), Map.of(animationName1, animation1, animationName2, animation2), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, BuiltInAnimationType animation1, String animationName2, BuiltInAnimationType animation2, String animationName3, BuiltInAnimationType animation3, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(), Map.of(animationName1, animation1, animationName2, animation2, animationName3, animation3), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, BuiltInAnimationType animation1, String animationName2, BuiltInAnimationType animation2, String animationName3, BuiltInAnimationType animation3, String animationName4, BuiltInAnimationType animation4, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(), Map.of(animationName1, animation1, animationName2, animation2, animationName3, animation3, animationName4, animation4), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName, ResourceLocation animation, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName, animation), Map.of(), headPieces));
    }

    protected void add(String id, LayerDefinition layerDefinition, String animationName1, ResourceLocation animation1, String animationName2, ResourceLocation animation2, String... headPieces) {
        this.models.add(new ModelHolder(this.mod(id), layerDefinition, Map.of(animationName1, animation1, animationName2, animation2), Map.of(), headPieces));
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
            model.builtInAnimations.forEach((animationName, builtInAnimationType) -> {
                JsonObject animationObject = new JsonObject();
                animationObject.addProperty("id", builtInAnimationType.getId().toString());
                JsonArray loadParts = new JsonArray();
                List.of(builtInAnimationType.loadParts()).forEach(loadParts::add);
                animationObject.add("load_parts", loadParts);
                animations.add(animationName, animationObject);
            });
            jsonObject.add("animations", animations);
            jsonObject.addProperty("model_id", id.toString());
            if (model.headPieces().length > 0) {
                JsonArray headPieces = new JsonArray();
                for (String headPiece : model.headPieces()) {
                    headPieces.add(headPiece);
                }
                jsonObject.add("head_pieces", headPieces);
            }
            jsonObject.addProperty("texture_height", layerDefinition.material.yTexSize);
            jsonObject.addProperty("texture_width", layerDefinition.material.xTexSize);
            JsonArray elementsArray = new JsonArray();
            this.createAllElements(elementsArray, layerDefinition.mesh.getRoot());
            jsonObject.add("elements", elementsArray);
            completableFutures.add(DataProvider.saveStable(cachedOutput, jsonObject, this.packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(this.modId).resolve("fossilslegacy").resolve("models").resolve(id.getPath() + ".json")));
        });
        return CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new));
    }

    private void createAllElements(JsonArray elementsArray, PartDefinition root) {
        root.children.forEach((name, partDefinition) -> {
            JsonObject elementObject = this.createElement(partDefinition, name);
            JsonArray childrenElementsArray = new JsonArray();
            this.createAllElements(childrenElementsArray, partDefinition);
            if (!childrenElementsArray.isEmpty()) {
                elementObject.add("elements", childrenElementsArray);
            }
            elementsArray.add(elementObject);
        });
    }

    private JsonObject createElement(PartDefinition partDefinition, String id) {
        JsonObject elementObject = new JsonObject();
        elementObject.addProperty("id", id);
        JsonArray boxesArray = new JsonArray();
        JsonObject poses = new JsonObject();
        for (CubeDefinition cubeDefinition : partDefinition.cubes) {
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
            boxesArray.add(box);
        }
        elementObject.add("boxes", boxesArray);
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
        elementObject.add("poses", poses);
        return elementObject;
    }

    @Override
    public String getName() {
        return "Entity Models: " + this.modId;
    }

    private record ModelHolder(ResourceLocation id, LayerDefinition layerDefinition, Map<String, ResourceLocation> animations, Map<String, BuiltInAnimationType> builtInAnimations, String... headPieces) {
    }
}
