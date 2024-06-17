package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class FossilsLegacyArmorMaterials {
    public static final SimpleRegistry<ArmorMaterial> ARMOR_MATERIALS = SimpleRegistry.create(Registries.ARMOR_MATERIAL, FossilsLegacyUtils.ID);

    public static final SimpleHolder<ArmorMaterial> ANCIENT = register("ancient", (EnumMap) Util.make(new EnumMap(ArmorItem.Type.class), (types) -> {
        types.put(ArmorItem.Type.BOOTS, 2);
        types.put(ArmorItem.Type.LEGGINGS, 5);
        types.put(ArmorItem.Type.CHESTPLATE, 6);
        types.put(ArmorItem.Type.HELMET, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.of(new ItemLike[]{Items.NETHERITE_INGOT});
    });

    private static SimpleHolder<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defenseMap, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(FossilsLegacyUtils.resource(id)));
        return register(id, defenseMap, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, layers);
    }

    private static SimpleHolder<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defenseMap, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> defense = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] types = Type.values();

        for (int i = 0; i < types.length; ++i) {
            ArmorItem.Type type = types[i];
            defense.put(type, defenseMap.get(type));
        }

        return ARMOR_MATERIALS.register(id, () -> new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(ARMOR_MATERIALS);
    }
}
