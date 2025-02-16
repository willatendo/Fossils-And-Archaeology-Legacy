package willatendo.fossilslegacy.api.data;

import com.google.common.collect.Maps;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AnimationProvider implements DataProvider {
    private final Map<ResourceLocation, JsonAnimation> jsonAnimations = Maps.newHashMap();
    private final PackOutput packOutput;
    private final String modId;

    public AnimationProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected void addAnimation(ResourceLocation resourceLocation, JsonAnimation jsonAnimation) {
        this.jsonAnimations.put(resourceLocation, jsonAnimation);
    }

    protected abstract void getAll();

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.getAll();
        return DataProvider.saveAll(cachedOutput, JsonAnimation.CODEC, this.packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "fossilslegacy/animations"), this.jsonAnimations);
    }

    @Override
    public String getName() {
        return "Animations: " + this.modId;
    }
}
