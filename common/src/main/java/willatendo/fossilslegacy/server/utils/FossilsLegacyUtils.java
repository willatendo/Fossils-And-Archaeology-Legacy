package willatendo.fossilslegacy.server.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class FossilsLegacyUtils {
    public static final String ID = "fossilslegacy";
    public static final Logger LOGGER = LoggerFactory.getLogger(FossilsLegacyUtils.ID);

    public static ResourceLocation resource(String path) {
        return SimpleUtils.resource(ID, path);
    }

    public static ResourceLocation mc(String path) {
        return SimpleUtils.mc(path);
    }

    public static MutableComponent fullTranslation(String in) {
        return Component.translatable(in);
    }

    public static MutableComponent translation(String type, String name) {
        return Component.translatable(type + "." + ID + "." + name);
    }

    public static MutableComponent translation(String type, String name, Object... args) {
        return Component.translatable(type + "." + ID + "." + name, args);
    }

    public static String getTagTranslationKey(TagKey<?> tagKey) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag.");
        ResourceLocation registryIdentifier = tagKey.registry().location();
        ResourceLocation tagIdentifier = tagKey.location();
        stringBuilder.append(registryIdentifier.toShortLanguageKey().replace("/", ".")).append(".").append(tagIdentifier.getNamespace()).append(".").append(tagIdentifier.getPath().replace("/", "."));
        return stringBuilder.toString();
    }
}
