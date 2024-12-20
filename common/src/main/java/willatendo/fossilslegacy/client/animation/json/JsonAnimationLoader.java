package willatendo.fossilslegacy.client.animation.json;

import com.google.common.collect.Lists;
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
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class JsonAnimationLoader extends SimpleJsonResourceReloadListener {
    public static final JsonAnimationLoader INSTANCE = new JsonAnimationLoader();
    private static final Map<ResourceLocation, AnimationDefinition> ANIMATIONS = Maps.newHashMap();
    private static final Map<ResourceLocation, BuiltInAnimationType> BUILT_IN_ANIMATIONS = Maps.newHashMap();

    private JsonAnimationLoader() {
        super(new Gson(), "fossilslegacy/animations");
    }

    public static boolean isBuiltIn(ResourceLocation id) {
        return BUILT_IN_ANIMATIONS.containsKey(id);
    }

    public static BuiltInAnimationType getBuiltIn(ResourceLocation id) {
        return BUILT_IN_ANIMATIONS.get(id);
    }

    public static AnimationDefinition getAnimation(ResourceLocation id) {
        return ANIMATIONS.get(id);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        BuiltInAnimationTypes.init();
        ANIMATIONS.clear();
        BUILT_IN_ANIMATIONS.clear();

        for (Map.Entry<ResourceLocation, JsonElement> entry : jsons.entrySet()) {
            try {
                this.load(entry.getValue().getAsJsonObject());
            } catch (Exception e) {
                FossilsLegacyUtils.LOGGER.error("Failed to load json animation! {}", e);
            }
        }
    }

    private void load(JsonObject jsonObject) {
        String type = GsonHelper.getAsString(jsonObject, "type");
        ResourceLocation id = ResourceLocation.parse(GsonHelper.getAsString(jsonObject, "id"));
        if (type.equals("json")) {
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
                JsonArray keyframe = GsonHelper.getAsJsonArray(animation, "keyframes");
                List<Keyframe> rotationKeyframes = Lists.newArrayList();
                List<Keyframe> positionKeyframes = Lists.newArrayList();
                List<Keyframe> scaleKeyframes = Lists.newArrayList();
                List<JsonElement> keyframeElements = keyframe.asList();
                for (JsonElement keyframeElement : keyframeElements) {
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
                        rotationKeyframes.add(new Keyframe(timestamp, KeyframeAnimations.degreeVec(x, y, z), this.parseInterpolations(interpolation)));
                    }
                    if (isPosVec) {
                        JsonObject posVecObject = GsonHelper.getAsJsonObject(keyframeObject, posVec);
                        float x = GsonHelper.getAsFloat(posVecObject, "x");
                        float y = GsonHelper.getAsFloat(posVecObject, "y");
                        float z = GsonHelper.getAsFloat(posVecObject, "z");
                        positionKeyframes.add(new Keyframe(timestamp, KeyframeAnimations.posVec(x, y, z), this.parseInterpolations(interpolation)));
                    }
                    if (isScaleVec) {
                        JsonObject scaleVecObject = GsonHelper.getAsJsonObject(keyframeObject, scaleVec);
                        float x = GsonHelper.getAsFloat(scaleVecObject, "x");
                        float y = GsonHelper.getAsFloat(scaleVecObject, "y");
                        float z = GsonHelper.getAsFloat(scaleVecObject, "z");
                        scaleKeyframes.add(new Keyframe(timestamp, KeyframeAnimations.scaleVec(x, y, z), this.parseInterpolations(interpolation)));
                    }
                }
                if (!rotationKeyframes.isEmpty()) {
                    builder.addAnimation(bone, new AnimationChannel(AnimationChannel.Targets.ROTATION, rotationKeyframes.toArray(Keyframe[]::new)));
                }
                if (!positionKeyframes.isEmpty()) {
                    builder.addAnimation(bone, new AnimationChannel(AnimationChannel.Targets.POSITION, positionKeyframes.toArray(Keyframe[]::new)));
                }
                if (!scaleKeyframes.isEmpty()) {
                    builder.addAnimation(bone, new AnimationChannel(AnimationChannel.Targets.SCALE, scaleKeyframes.toArray(Keyframe[]::new)));
                }
            }

            ANIMATIONS.put(id, builder.build());
        } else if (type.equals("built_in")) {
            BUILT_IN_ANIMATIONS.put(id, BuiltInAnimationType.get(id));
        }
    }

    private AnimationChannel.Interpolation parseInterpolations(String in) {
        if (Objects.equals(in, "catmullrom")) {
            return AnimationChannel.Interpolations.CATMULLROM;
        } else {
            return AnimationChannel.Interpolations.LINEAR;
        }
    }
}
