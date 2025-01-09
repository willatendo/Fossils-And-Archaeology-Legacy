package willatendo.fossilslegacy.platform;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.FossilsLegacyForgeMod;
import willatendo.fossilslegacy.network.ForgePacketHelper;
import willatendo.fossilslegacy.network.ServerboundApplyGenePacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.item.ArticulatedFossilItem;
import willatendo.fossilslegacy.server.item.ForgeArticulatedFossilItem;
import willatendo.fossilslegacy.server.item.ForgeDinosaurSpawnEggItem;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.fossilslegacy.server.utils.Platform;

import java.util.function.Supplier;

public class FossilsForgeHelper implements FossilsModloaderHelper {
    @Override
    public Platform getPlatform() {
        return Platform.FORGE;
    }

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
    public SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties) {
        return new ForgeDinosaurSpawnEggItem(entityType, primaryColor, secondaryColor, properties);
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
        return RecipeBookType.create(FossilsLegacyUtils.ID + name);
    }

    @Override
    public RecipeBookCategories createRecipeBookCategory(String name, ItemStack... icons) {
        return RecipeBookCategories.create(FossilsLegacyUtils.ID + name, icons);
    }
}
