package willatendo.fossilslegacy.client.animation.json;

import com.google.common.collect.Maps;
import com.mojang.serialization.JsonOps;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;

import java.util.HashMap;
import java.util.Map;

public final class JsonAnimationLoader extends SimpleJsonResourceReloadListener<JsonAnimation> {
    public static final JsonAnimationLoader INSTANCE = new JsonAnimationLoader();
    private static final FileToIdConverter ASSET_LISTER = FileToIdConverter.json("fossilslegacy/animations");
    private static final Map<ResourceLocation, JsonAnimation> ANIMATIONS = Maps.newHashMap();

    private JsonAnimationLoader() {
        super(JsonAnimation.CODEC, ASSET_LISTER);
    }

    public static boolean isBuiltIn(ResourceLocation id) {
        return BuiltInAnimationType.VALUES.containsKey(id);
    }

    public static BuiltInAnimationType getBuiltIn(ResourceLocation id) {
        return BuiltInAnimationType.VALUES.get(id);
    }

    public static AnimationDefinition getAnimation(ResourceLocation id) {
        return ANIMATIONS.get(id).toAnimationDefinition();
    }

    @Override
    protected Map<ResourceLocation, JsonAnimation> prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
        Map<ResourceLocation, JsonAnimation> map = new HashMap<>();
        scanDirectory(resourceManager, JsonAnimationLoader.ASSET_LISTER, JsonOps.INSTANCE, JsonAnimation.CODEC, map);
        return map;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonAnimation> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        BuiltInAnimationTypes.init();
        ANIMATIONS.clear();

        jsons.forEach((resourceLocation, jsonAnimation) -> ANIMATIONS.put(jsonAnimation.id(), jsonAnimation));
    }
}
