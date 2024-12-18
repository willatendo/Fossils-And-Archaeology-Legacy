package willatendo.fossilslegacy.api.data;

import com.google.common.collect.Lists;
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
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AnimationProvider implements DataProvider {
    private final Map<ResourceLocation, AnimationDefinition> jsonAnimations = Maps.newHashMap();
    private final List<BuiltInAnimationType> builtInAnimations = Lists.newArrayList();
    private final PackOutput packOutput;
    private final String modId;

    public AnimationProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected void addAnimation(ResourceLocation resourceLocation, AnimationDefinition animationDefinition) {
        this.jsonAnimations.put(resourceLocation, animationDefinition);
    }

    protected void addBuiltIn(BuiltInAnimationType builtInAnimationType) {
        this.builtInAnimations.add(builtInAnimationType);
    }

    protected abstract void getAll();

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.getAll();
        List<CompletableFuture<?>> completableFutures = Lists.newArrayList();
        this.jsonAnimations.forEach((resourceLocation, animationDefinition) -> {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "json");
            jsonObject.addProperty("id", resourceLocation.toString());
            jsonObject.addProperty("length", animationDefinition.lengthInSeconds());
            jsonObject.addProperty("looping", animationDefinition.looping());
            JsonArray animations = new JsonArray();
            animationDefinition.boneAnimations().forEach((bone, animationChannels) -> {
                JsonObject animation = new JsonObject();
                animation.addProperty("bone", bone);
                JsonArray keyframes = new JsonArray();
                animationChannels.forEach(animationChannel -> {
                    AnimationChannel.Target target = animationChannel.target();
                    for (Keyframe keyframe : animationChannel.keyframes()) {
                        JsonObject keyframeObject = new JsonObject();
                        keyframeObject.addProperty("target", this.parse(target));
                        keyframeObject.addProperty("timestamp", keyframe.timestamp());
                        if (keyframe.interpolation() == AnimationChannel.Interpolations.LINEAR) {
                            keyframeObject.addProperty("interpolation", "linear");
                            if (target == AnimationChannel.Targets.ROTATION) {
                                JsonObject degreeVec = new JsonObject();
                                degreeVec.addProperty("x", keyframe.target().x() / 0.017453292F);
                                degreeVec.addProperty("y", keyframe.target().y() / 0.017453292F);
                                degreeVec.addProperty("z", keyframe.target().z() / 0.017453292F);
                                keyframeObject.add("degree_vec", degreeVec);
                            }
                            if (target == AnimationChannel.Targets.POSITION) {
                                JsonObject posVec = new JsonObject();
                                posVec.addProperty("x", keyframe.target().x());
                                posVec.addProperty("y", -keyframe.target().y());
                                posVec.addProperty("z", keyframe.target().z());
                                keyframeObject.add("pos_vec", posVec);
                            }
                            if (target == AnimationChannel.Targets.SCALE) {
                                JsonObject scaleVec = new JsonObject();
                                scaleVec.addProperty("x", keyframe.target().x() + 1.0F);
                                scaleVec.addProperty("y", keyframe.target().y() + 1.0F);
                                scaleVec.addProperty("z", keyframe.target().z() + 1.0F);
                                keyframeObject.add("scale_vec", scaleVec);
                            }
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
        this.builtInAnimations.forEach((builtInAnimations) -> {
            ResourceLocation resourceLocation = builtInAnimations.getId();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "built_in");
            jsonObject.addProperty("id", resourceLocation.toString());
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
