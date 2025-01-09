package willatendo.fossilslegacy.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.network.ServerboundApplyGenePacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.item.DinosaurSpawnEggItem;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.fossilslegacy.server.utils.Platform;
import willatendo.simplelibrary.client.util.FabricClientUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.FabricUtils;

import java.util.function.Supplier;

public class FossilsFabricHelper implements FossilsModloaderHelper {
    @Override
    public Platform getPlatform() {
        return Platform.FABRIC;
    }

    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String coatType) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        friendlyByteBuf.writeUtf(coatType);
        ClientPlayNetworking.send(new ServerboundApplyGenePacket(blockPos, coatType));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        FriendlyByteBuf friendlyByteBuf = PacketByteBufs.create();
        friendlyByteBuf.writeBlockPos(blockPos);
        ClientPlayNetworking.send(new ServerboundTimeMachineUpdatePacket(blockPos));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec) {
        EntityDataSerializer<Holder<T>> entityDataSerializer = EntityDataSerializer.forValueType(streamCodec);
        EntityDataSerializers.registerSerializer(entityDataSerializer);
        return () -> entityDataSerializer;
    }

    @Override
    public void registerPOI(SimpleRegistry<PoiType> simpleRegistry, String id, Supplier<PoiType> poiType) {
        PointOfInterestHelper.register(FossilsLegacyUtils.resource(id), poiType.get().maxTickets(), poiType.get().validRange(), poiType.get().matchingStates());
    }

    @Override
    public <T extends MapDecorationType> Holder<T> registerMapDecorationType(String id, Supplier<MapDecorationType> mapDecorationType) {
        return (Holder<T>) Registry.registerForHolder(BuiltInRegistries.MAP_DECORATION_TYPE, FossilsLegacyUtils.resource(id), mapDecorationType.get());
    }

    @Override
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new DinosaurSpawnEggItem(entityType.get(), primaryColor, secondaryColor, properties);
    }

    @Override
    public GameRules.Key<GameRules.BooleanValue> createBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
        return GameRuleRegistry.register(name, category, GameRuleFactory.createBooleanRule(defaultValue));
    }

    @Override
    public RecipeBookType createRecipeBookType(String name) {
        return FabricUtils.createRecipeBookType(name);
    }

    @Override
    public RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons) {
        return FabricClientUtils.createRecipeBookCategory(name);
    }
}
