package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.FossilsLegacyForgeMod;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundApplyGenePacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.item.ForgeArticulatedFossilItem;
import willatendo.fossilslegacy.server.item.items.ArticulatedFossilItem;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.function.Supplier;

public class FossilsForgeHelper implements FossilsModloaderHelper {
    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String coatType) {
        ForgePacketHelper.sendToServer(new ServerboundApplyGenePacket(blockPos, coatType));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        ForgePacketHelper.sendToServer(new ServerboundTimeMachineUpdatePacket(blockPos));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec) {
        return FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> EntityDataSerializer.forValueType(streamCodec));
    }

    @Override
    public <T extends MapDecorationType> Holder<T> registerMapDecorationType(String id, Supplier<MapDecorationType> mapDecorationType) {
        return (Holder<T>) FossilsLegacyForgeMod.MAP_DECORATION_TYPES.register(id, mapDecorationType).getHolder().get();
    }

    @Override
    public ArticulatedFossilItem getArticulatedFossilItem(Item.Properties properties) {
        return new ForgeArticulatedFossilItem(properties);
    }

    @Override
    public GameRules.Key<GameRules.BooleanValue> createBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
        return GameRules.register(name, category, GameRules.BooleanValue.create(defaultValue));
    }

    @Override
    public RecipeBookType createRecipeBookType(String name) {
        return RecipeBookType.create(FAUtils.ID + name);
    }
}
