package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Map;

public final class FATrimMaterials {
    public static final ResourceKey<TrimMaterial> AMBER = FATrimMaterials.create("amber");
    public static final ResourceKey<TrimMaterial> JADE = FATrimMaterials.create("jade");

    private static ResourceKey<TrimMaterial> create(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<TrimMaterial> bootstrapContext, ResourceKey<TrimMaterial> resourceKey, Item ingredient, Style style) {
        register(bootstrapContext, resourceKey, ingredient, style, Map.of());
    }

    private static void register(BootstrapContext<TrimMaterial> bootstrapContext, ResourceKey<TrimMaterial> resourceKey, Item ingredient, Style style, Map<ResourceKey<EquipmentAsset>, String> overrideArmorMaterials) {
        bootstrapContext.register(resourceKey, TrimMaterial.create(resourceKey.location().getPath(), ingredient, Component.translatable(Util.makeDescriptionId("trim_material", resourceKey.location())).withStyle(style), overrideArmorMaterials));
    }

    public static void bootstrap(BootstrapContext<TrimMaterial> bootstrapContext) {
        FATrimMaterials.register(bootstrapContext, AMBER, FAItems.AMBER.get(), Style.EMPTY.withColor(0xD36A0B));
        FATrimMaterials.register(bootstrapContext, JADE, FAItems.JADE.get(), Style.EMPTY.withColor(0x51E392));
    }
}
