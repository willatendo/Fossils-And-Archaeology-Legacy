package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.client.TexturedModelDataProvider;
import willatendo.fossilslegacy.server.config.FabricConfigHelper;
import willatendo.fossilslegacy.server.menu.ExtendedMenuSupplier;
import willatendo.simplelibrary.server.util.FabricUtils;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(ExtendedMenuSupplier<T> extendedMenuSupplier) {
        return FabricUtils.createMenuType((windowId, inventory, friendlyByteBuf) -> extendedMenuSupplier.create(windowId, inventory, friendlyByteBuf));
    }

    @Override
    public <T> Registry<T> createRegistry(ResourceKey<Registry<T>> resourceKey) {
        return FabricRegistryBuilder.createSimple(resourceKey).buildAndRegister();
    }

    @Override
    public void regsiterKeyMapping(KeyMapping keyMapping) {
        KeyBindingHelper.registerKeyBinding(keyMapping);
    }

    @Override
    public boolean willAnimalsStarve() {
        return FabricConfigHelper.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsBreakBlocks() {
        return FabricConfigHelper.willAnimalsStarve();
    }

    @Override
    public boolean willAnimalsGrow() {
        return FabricConfigHelper.willAnimalsGrow();
    }

    @Override
    public boolean shouldAnuSpawn() {
        return FabricConfigHelper.shouldAnuSpawn();
    }

    @Override
    public boolean shouldEnableExperiments() {
        return FabricConfigHelper.shouldEnableExperiments();
    }

    @Override
    public <T extends Entity> void entityRendererRegistry(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider) {
        EntityRendererRegistry.<T>register(entityType, entityRendererProvider);
    }

    @Override
    public void entityModelLayerRegistry(ModelLayerLocation modelLayerLocation, TexturedModelDataProvider texturedModelDataProvider) {
        EntityModelLayerRegistry.registerModelLayer(modelLayerLocation, texturedModelDataProvider::createModelData);
    }
}
