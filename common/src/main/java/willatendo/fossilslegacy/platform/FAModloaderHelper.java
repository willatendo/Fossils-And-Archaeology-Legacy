package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fluid.TarFluid;
import willatendo.fossilslegacy.server.item.items.ArticulatedFossilItem;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.Optional;
import java.util.function.Supplier;

public interface FAModloaderHelper {
    FAModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FAModloaderHelper.class);

    // Platform
    void sendApplyGenePacket(BlockPos blockPos, String modelType, String skin, Optional<String> pattern);

    void sendSetRotation(int id, String part, float xRot, float yRot, float zRot);

    void sendSetPosition(int id, String part, float x, float y, float z);

    void sendTimeMachinePacket(BlockPos blockPos);

    void sendFossilMenuPacket(ServerPlayer serverPlayer, int id, FossilRotations fossilRotations, FossilPositions fossilPositions, String fossilVariant);

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

    default TarFluid getFlowingTar() {
        return new TarFluid.Flowing();
    }

    default TarFluid getTar() {
        return new TarFluid.Source();
    }

    GameRules.Key<GameRules.BooleanValue> createBooleanGameRule(String name, GameRules.Category category, boolean defaultValue);

    RecipeBookType createRecipeBookType(String name);
}
