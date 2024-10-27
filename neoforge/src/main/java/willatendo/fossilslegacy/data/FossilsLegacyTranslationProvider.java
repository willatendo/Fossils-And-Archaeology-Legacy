package willatendo.fossilslegacy.data;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.util.GsonHelper;
import net.neoforged.fml.loading.FMLPaths;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class FossilsLegacyTranslationProvider implements DataProvider {
    private static final Gson GSON = new Gson();
    private final FossilsLegacyLanguageProvider fossilsLegacyLanguageProvider;
    private final PackOutput packOutput;
    private final String modId;
    private final String[] translations;

    public FossilsLegacyTranslationProvider(FossilsLegacyLanguageProvider fossilsLegacyLanguageProvider, PackOutput packOutput, String modId, String... translations) {
        this.fossilsLegacyLanguageProvider = fossilsLegacyLanguageProvider;
        this.packOutput = packOutput;
        this.modId = modId;
        this.translations = translations;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        List<CompletableFuture<?>> completableFutures = Lists.newArrayList();
        JsonObject translationsObject = GSON.fromJson(new InputStreamReader(FossilsLegacyTranslationProvider.class.getClassLoader().getResourceAsStream("assets/" + this.modId + "/translations.json"), StandardCharsets.UTF_8), JsonObject.class);
        for (String translation : this.translations) {
            completableFutures.add(this.createLang(cachedOutput, translation, translationsObject));
        }
        return CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new));
    }

    private CompletableFuture<?> createLang(CachedOutput cachedOutput, String translation, JsonObject translationsObject) {
        Map<String, String> data = Maps.newHashMap();
        for (Map.Entry<String, String> untranslatedData : this.fossilsLegacyLanguageProvider.translations.entrySet()) {
            String key = untranslatedData.getKey();
            if (translationsObject.has(key)) {
                JsonObject translationsJsonObject = GsonHelper.getAsJsonObject(translationsObject, key);
                if (translationsJsonObject.has(translation)) {
                    data.put(key, GsonHelper.getAsString(translationsJsonObject, translation));
                }
            }
        }
        return !this.fossilsLegacyLanguageProvider.translations.isEmpty() ? this.save(cachedOutput, data, this.packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(this.modId).resolve("lang").resolve(translation + ".json")) : CompletableFuture.allOf();
    }

    private CompletableFuture<?> save(CachedOutput cachedOutput, Map<String, String> data, Path path) {
        JsonObject jsonObject = new JsonObject();
        data.forEach(jsonObject::addProperty);
        return DataProvider.saveStable(cachedOutput, jsonObject, path);
    }

    @Override
    public String getName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Translations: " + this.modId + " (");
        for (int i = 0; i < this.translations.length; i++) {
            String translation = this.translations[i];
            stringBuilder.append(translation);
            if (i + 1 != this.translations.length) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
