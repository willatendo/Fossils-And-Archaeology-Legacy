package willatendo.fossilslegacy.api.data;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AnimationProvider implements DataProvider {
    private final PackOutput packOutput;
    private final String modId;

    public AnimationProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected abstract void getAll(Map<ResourceLocation, AnimationDefinition> animationDefinitions);


    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        Map<ResourceLocation, AnimationDefinition> animationDefinitions = Maps.newHashMap();
        this.getAll(animationDefinitions);
        List<CompletableFuture<?>> completableFutures = Lists.newArrayList();
        animationDefinitions.forEach((resourceLocation, animationDefinition) -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", resourceLocation.toString());
            jsonObject.addProperty("length", animationDefinition.lengthInSeconds());
            jsonObject.addProperty("looping", animationDefinition.looping());
            JsonArray animations = new JsonArray();
            animationDefinition.boneAnimations().forEach((bone, animationChannels) -> {
                JsonObject animation = new JsonObject();
                animation.addProperty("bone", bone);
                animation.addProperty("target", this.parse(animationChannels.getFirst().target()));
                JsonArray keyframes = new JsonArray();
                animationChannels.forEach(animationChannel -> {
                    for (Keyframe keyframe : animationChannel.keyframes()) {
                        JsonObject keyframeObject = new JsonObject();
                        keyframeObject.addProperty("timestamp", keyframe.timestamp());
                        if (keyframe.interpolation() == AnimationChannel.Interpolations.LINEAR) {
                            keyframeObject.addProperty("interpolation", "linear");
                            JsonObject degreeVec = new JsonObject();
                            degreeVec.addProperty("x", keyframe.target().x() / 0.017453292F);
                            degreeVec.addProperty("y", keyframe.target().y() / 0.017453292F);
                            degreeVec.addProperty("z", keyframe.target().z() / 0.017453292F);
                            keyframeObject.add("degree_vec", degreeVec);
                        }
                        keyframes.add(keyframeObject);
                    }
                });
                animation.add("keyframes", keyframes);
                animations.add(animation);
            });
            jsonObject.add("animations", animations);
            completableFutures.add(DataProvider.saveStable(cachedOutput, jsonObject, this.packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(this.modId).resolve("fossilslegacy").resolve("animations").resolve(resourceLocation.getPath() + ".json")));
        });

        return CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new));
    }

    private String parse(AnimationChannel.Target target) {
        return target == AnimationChannel.Targets.SCALE ? "scale" : target == AnimationChannel.Targets.POSITION ? "position" : "rotation";
    }

    @Override
    public String getName() {
        return "Animations: " + this.modId;
    }
}
