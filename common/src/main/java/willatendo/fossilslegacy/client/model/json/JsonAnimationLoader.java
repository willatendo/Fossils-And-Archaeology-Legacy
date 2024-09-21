package willatendo.fossilslegacy.client.model.json;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;

public class JsonAnimationLoader extends SimpleJsonResourceReloadListener {
    public static final JsonAnimationLoader INSTANCE = new JsonAnimationLoader();
    private static final Map<ResourceLocation, AnimationDefinition> ANIMATIONS = Maps.newHashMap();

    private JsonAnimationLoader() {
        super(new Gson(), "fossilslegacy/animations");
    }

    public static AnimationDefinition getAnimation(ResourceLocation resourceLocation) {
        return ANIMATIONS.get(resourceLocation);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        ANIMATIONS.clear();
        for (Map.Entry<ResourceLocation, JsonElement> entry : jsons.entrySet()) {
            try {
                this.load(entry.getValue().getAsJsonObject());
            } catch (Exception e) {
                FossilsLegacyUtils.LOGGER.error("Failed to load json animation! {}", e);
            }
        }

        FossilsLegacyUtils.LOGGER.info("Registered {} json animations!", ANIMATIONS.size());
    }

    private void load(JsonObject jsonObject) {
        ResourceLocation id = ResourceLocation.parse(GsonHelper.getAsString(jsonObject, "id"));
        float length = GsonHelper.getAsFloat(jsonObject, "length");
        AnimationDefinition.Builder builder = AnimationDefinition.Builder.withLength(length);
        boolean looping = GsonHelper.getAsBoolean(jsonObject, "looping");
        if (looping) {
            builder.looping();
        }
        JsonArray animations = GsonHelper.getAsJsonArray(jsonObject, "animations");
        for (JsonElement animationElement : animations.asList()) {
            JsonObject animation = animationElement.getAsJsonObject();
            String bone = GsonHelper.getAsString(animation, "bone");
            String target = GsonHelper.getAsString(animation, "target");
            JsonArray keyframe = GsonHelper.getAsJsonArray(animation, "keyframes");
            Keyframe[] keyframes = new Keyframe[keyframe.size()];
            List<JsonElement> keyframeElements = keyframe.asList();
            for (int i = 0; i < keyframeElements.size(); i++) {
                JsonElement keyframeElement = keyframeElements.get(i);
                JsonObject keyframeObject = keyframeElement.getAsJsonObject();
                float timestamp = GsonHelper.getAsFloat(keyframeObject, "timestamp");
                String interpolation = GsonHelper.getAsString(keyframeObject, "interpolation");
                String degreeVec = "degree_vec";
                String posVec = "pos_vec";
                String scaleVec = "scale_vec";
                boolean isDegreeVec = keyframeObject.has(degreeVec);
                boolean isPosVec = keyframeObject.has(posVec);
                boolean isScaleVec = keyframeObject.has(scaleVec);
                if (isDegreeVec) {
                    JsonObject degreeVecObject = GsonHelper.getAsJsonObject(keyframeObject, degreeVec);
                    float x = GsonHelper.getAsFloat(degreeVecObject, "x");
                    float y = GsonHelper.getAsFloat(degreeVecObject, "y");
                    float z = GsonHelper.getAsFloat(degreeVecObject, "z");
                    keyframes[i] = new Keyframe(timestamp, KeyframeAnimations.degreeVec(x, y, z), this.parseInterpolations(interpolation));
                }
                if (isPosVec) {
                    JsonObject posVecObject = GsonHelper.getAsJsonObject(keyframeObject, posVec);
                    float x = GsonHelper.getAsFloat(posVecObject, "x");
                    float y = GsonHelper.getAsFloat(posVecObject, "y");
                    float z = GsonHelper.getAsFloat(posVecObject, "z");
                    keyframes[i] = new Keyframe(timestamp, KeyframeAnimations.posVec(x, y, z), this.parseInterpolations(interpolation));
                }
                if (isScaleVec) {
                    JsonObject scaleVecObject = GsonHelper.getAsJsonObject(keyframeObject, scaleVec);
                    float x = GsonHelper.getAsFloat(scaleVecObject, "x");
                    float y = GsonHelper.getAsFloat(scaleVecObject, "y");
                    float z = GsonHelper.getAsFloat(scaleVecObject, "z");
                    keyframes[i] = new Keyframe(timestamp, KeyframeAnimations.scaleVec(x, y, z), this.parseInterpolations(interpolation));
                }
            }
            builder.addAnimation(bone, new AnimationChannel(this.parseTarget(target), keyframes));
        }

        ANIMATIONS.put(id, builder.build());
    }

    private AnimationChannel.Target parseTarget(String in) {
        if (in == "position") {
            return AnimationChannel.Targets.POSITION;
        } else if (in == "scale") {
            return AnimationChannel.Targets.SCALE;
        } else {
            return AnimationChannel.Targets.ROTATION;
        }
    }

    private AnimationChannel.Interpolation parseInterpolations(String in) {
        if (in == "catmullrom") {
            return AnimationChannel.Interpolations.CATMULLROM;
        } else {
            return AnimationChannel.Interpolations.LINEAR;
        }
    }
}
