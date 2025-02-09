package willatendo.fossilslegacy.server.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAEquipmentAssets {
    public static final ResourceKey<EquipmentAsset> ANCIENT = register("ancient");
    public static final ResourceKey<EquipmentAsset> SCARAB_GEM = register("scarab_gem");

    private static ResourceKey<EquipmentAsset> register(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, FAUtils.resource(name));
    }
}
