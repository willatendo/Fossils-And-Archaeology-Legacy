package willatendo.fossilslegacy.api.data;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class EntityModelProvider implements DataProvider {
    private final PackOutput packOutput;
    private final String modId;
    protected final Map<ResourceLocation, JsonModel> jsonModels = new HashMap<>();

    public EntityModelProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected void add(ResourceLocation modelId, JsonModel jsonModel) {
        this.jsonModels.put(modelId, jsonModel);
    }

    protected abstract void getAll();

    protected ResourceLocation mod(String name) {
        return SimpleUtils.resource(this.modId, name);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.jsonModels.clear();
        this.getAll();
        return DataProvider.saveAll(cachedOutput, JsonModel.CODEC, this.packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "fossilslegacy/models"), this.jsonModels);
    }

    @Override
    public String getName() {
        return "Entity Models: " + this.modId;
    }
}
