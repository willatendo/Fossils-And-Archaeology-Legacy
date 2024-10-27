package willatendo.fossilslegacy.client;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.fossilslegacy.server.utils.Platform;

import java.util.List;

public final class PlayerUnlockedCoatTypesHelper {
    public static List<Holder<CoatType>> getUnlocked(Player player) {
        CompoundTag persistentData = FossilsModloaderHelper.INSTANCE.getPlayerData(player);
        CompoundTag data = persistentData.getCompound(FossilsModloaderHelper.INSTANCE.getPlatform() == Platform.FABRIC ? FossilsLegacyUtils.ID + "." + FossilsLegacyUtils.PERSISTED_NBT_TAG : FossilsLegacyUtils.PERSISTED_NBT_TAG);
        ListTag unlockedCoatTypes = data.getList("UnlockedCoatTypes", 8);
        Registry<CoatType> coatTypeRegistry = player.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES);
        List<Holder<CoatType>> coatTypeHolders = Lists.newArrayList();
        unlockedCoatTypes.forEach(tag -> {
            if (tag instanceof StringTag stringTag) {
                coatTypeHolders.add(coatTypeRegistry.getHolder(ResourceLocation.parse(stringTag.getAsString())).get());
            }
        });
        FossilsLegacyUtils.LOGGER.info("Size: {}", coatTypeHolders.size());
        return coatTypeHolders;
    }

    public static void grantAllLegacyCoatTypes(Player player) {
        CompoundTag persistentData = FossilsModloaderHelper.INSTANCE.getPlayerData(player);
        CompoundTag data = persistentData.getCompound(FossilsModloaderHelper.INSTANCE.getPlatform() == Platform.FABRIC ? FossilsLegacyUtils.ID + "." + FossilsLegacyUtils.PERSISTED_NBT_TAG : FossilsLegacyUtils.PERSISTED_NBT_TAG);
        List<String> legacyCoatTypes = Lists.newArrayList();
        Registry<CoatType> coatTypeRegistry = player.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES);
        coatTypeRegistry.getTag(FossilsLegacyCoatTypeTags.LEGACY).get().forEach(coatTypeHolder -> legacyCoatTypes.add(coatTypeHolder.getRegisteredName()));
        ListTag unlockedCoatTypes = new ListTag();

        for (int i = 0; i < legacyCoatTypes.size(); i++) {
            unlockedCoatTypes.add(i, StringTag.valueOf(legacyCoatTypes.get(i)));
        }

        data.put("UnlockedCoatTypes", unlockedCoatTypes);
        FossilsModloaderHelper.INSTANCE.setPlayerData(persistentData, data);
        if (player instanceof ServerPlayer serverPlayer) {
            FossilsModloaderHelper.INSTANCE.sendAlertUnlockedCoatTypesPacket(serverPlayer, legacyCoatTypes);
        }
    }
}
