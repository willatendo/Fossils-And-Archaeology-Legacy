package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public final class FAArmorMaterials {
    public static final ArmorMaterial ANCIENT = new ArmorMaterial(15, Util.make(new EnumMap(ArmorType.class), (types) -> {
        types.put(ArmorType.BOOTS, 2);
        types.put(ArmorType.LEGGINGS, 5);
        types.put(ArmorType.CHESTPLATE, 6);
        types.put(ArmorType.HELMET, 2);
        types.put(ArmorType.BODY, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, null, FAEquipmentAssets.ANCIENT);
    public static final ArmorMaterial SCARAB_GEM = new ArmorMaterial(40, Util.make(new EnumMap(ArmorType.class), (types) -> {
        types.put(ArmorType.BOOTS, 3);
        types.put(ArmorType.LEGGINGS, 6);
        types.put(ArmorType.CHESTPLATE, 8);
        types.put(ArmorType.HELMET, 3);
        types.put(ArmorType.BODY, 11);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 5.0F, 0.2F, null, FAEquipmentAssets.SCARAB_GEM);
}
