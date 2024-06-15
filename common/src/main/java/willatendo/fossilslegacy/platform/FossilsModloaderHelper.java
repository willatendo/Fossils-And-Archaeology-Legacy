package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.portal.PortalInfo;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.function.Supplier;

public interface FossilsModloaderHelper {
    public static final FossilsModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(FossilsModloaderHelper.class);

    // Platform
    void sendTimeMachinePacket(BlockPos blockPos);

    void changeDimensions(Player player, ServerLevel serverLevel, PortalInfo portalInfo, BlockPos timeMachineBlockPos);

    <T> SimpleHolder<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec);

    SpawnEggItem createDinosaurSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int primaryColor, int secondaryColor, Item.Properties properties);

    // Config
    boolean featheredDinosaurs();

    boolean willAnimalsStarve();

    boolean willAnimalsBreakBlocks();

    boolean willAnimalsGrow();

    boolean shouldAnuSpawn();
}
