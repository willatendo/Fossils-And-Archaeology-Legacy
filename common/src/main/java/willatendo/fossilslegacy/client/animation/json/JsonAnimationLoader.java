package willatendo.fossilslegacy.client.animation.json;

import com.google.common.collect.Maps;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;

import java.util.Map;

public final class JsonAnimationLoader extends SimpleJsonResourceReloadListener<JsonAnimation> {
    public static final JsonAnimationLoader INSTANCE = new JsonAnimationLoader();
    private static final FileToIdConverter ASSET_LISTER = FileToIdConverter.json("fossilslegacy/animations");
    private static final Map<ResourceLocation, JsonAnimation> ANIMATIONS = Maps.newHashMap();
    private static final Map<ResourceLocation, BuiltInAnimationType> BUILT_IN_ANIMATIONS = Maps.newHashMap();

    private JsonAnimationLoader() {
        super(JsonAnimation.CODEC, ASSET_LISTER);
    }

    public static boolean isBuiltIn(ResourceLocation id) {
        return BUILT_IN_ANIMATIONS.containsKey(id);
    }

    public static BuiltInAnimationType getBuiltIn(ResourceLocation id) {
        return BUILT_IN_ANIMATIONS.get(id);
    }

    public static AnimationDefinition getAnimation(ResourceLocation id) {
        return ANIMATIONS.get(id).toAnimationDefinition();
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonAnimation> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        BuiltInAnimationTypes.init();
        ANIMATIONS.clear();
        BUILT_IN_ANIMATIONS.clear();

        jsons.forEach((resourceLocation, jsonAnimation) -> ANIMATIONS.put(jsonAnimation.id(), jsonAnimation));
    }
}
