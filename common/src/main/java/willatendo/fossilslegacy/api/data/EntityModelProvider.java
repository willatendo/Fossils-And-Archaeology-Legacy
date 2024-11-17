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
import java.util.concurrent.CompletableFuture;

public abstract class EntityModelProvider implements DataProvider {
    private final PackOutput packOutput;
    private final String modId;
    protected final List<EntityModelHolder> models = Lists.newArrayList();

    public EntityModelProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected void add(EntityModelHolder entityModelHolder) {
        this.models.add(entityModelHolder);
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
            JsonObject animationsObject = new JsonObject();
            model.animations().forEach((animationName, animations) -> {
                if (animations.length > 1) {
                    JsonArray animationsArray = new JsonArray();
                    for (ResourceLocation animation : animations) {
                        animationsArray.add(animation.toString());
                    }
                    animationsObject.add(animationName, animationsArray);
                } else {
                    animationsObject.addProperty(animationName, animations[0].toString());
                }
            });
            model.builtInAnimations().forEach((animationName, builtInAnimationTypes) -> {
                if (builtInAnimationTypes.length > 1) {
                    JsonArray animationsArray = new JsonArray();
                    for (BuiltInAnimationType builtInAnimationType : builtInAnimationTypes) {
                        animationsArray.add(builtInAnimationType.getId().toString());
                    }
                    animationsObject.add(animationName, animationsArray);
                } else {
                    animationsObject.addProperty(animationName, builtInAnimationTypes[0].getId().toString());
                }
            });
            jsonObject.add("animations", animationsObject);
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
            if (model.colored()) {
                jsonObject.addProperty("colored", true);
            }
            if (model.overrideReset()) {
                jsonObject.addProperty("override_reset", true);
            }
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
}
