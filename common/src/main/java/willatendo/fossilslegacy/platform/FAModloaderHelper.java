package willatendo.fossilslegacy.platform;

import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.state.BlockBehaviour;
import willatendo.fossilslegacy.server.block.blocks.HardenedTarBlock;
import willatendo.fossilslegacy.server.fluid.TarFluid;
import willatendo.fossilslegacy.server.item.items.ArticulatedFossilItem;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;
import java.util.function.Supplier;

public interface FAModloaderHelper {
    FAModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FAModloaderHelper.class);

    // Platform
    void sendToServer(CustomPacketPayload customPacketPayload);

    void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload);

    CreativeModeTab.Builder createCreativeModeTab(String id, List<String> after, List<String> before);

    default <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec) {
        return this.registerDataSerializer(id, EntityDataSerializer.forValueType(streamCodec));
    }

    <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, EntityDataSerializer<T> entityDataSerializer);

    default void registerPOI(SimpleRegistry<PoiType> simpleRegistry, String id, Supplier<PoiType> poiType) {
        simpleRegistry.register(id, poiType);
    }

    default ArticulatedFossilItem getArticulatedFossilItem(Item.Properties properties) {
        return new ArticulatedFossilItem(properties);
    }

    default HardenedTarBlock getHardenedTarBlock(BlockBehaviour.Properties properties) {
        return new HardenedTarBlock(properties);
    }

    default TarFluid getFlowingTar() {
        return new TarFluid.Flowing();
    }

    default TarFluid getTar() {
        return new TarFluid.Source();
    }

    GameRules.Key<GameRules.BooleanValue> createBooleanGameRule(String name, GameRules.Category category, boolean defaultValue);

    GameRules.Key<GameRules.IntegerValue> createIntegerGameRule(String name, GameRules.Category category, int defaultValue);

    RecipeBookType createRecipeBookType(String name);
}
