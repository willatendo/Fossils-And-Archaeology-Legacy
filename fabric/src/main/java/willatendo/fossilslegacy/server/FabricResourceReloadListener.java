package willatendo.fossilslegacy.server;

import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public record FabricResourceReloadListener(ResourceLocation id, PreparableReloadListener preparableReloadListener) implements IdentifiableResourceReloadListener {
    @Override
    public ResourceLocation getFabricId() {
        return this.id();
    }

    @Override
    public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
        return this.preparableReloadListener().reload(preparationBarrier, resourceManager, backgroundExecutor, gameExecutor);
    }
}
