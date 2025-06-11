package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    private static final Component GEM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", FAUtils.resource("smithing_template.scarab_gem_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE);
    private static final Component GEM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", FAUtils.resource("smithing_template.scarab_gem_upgrade.ingredient"))).withStyle(ChatFormatting.BLUE);
    private static final Component GEM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", FAUtils.resource("smithing_template.scarab_gem_upgrade.base_slot_description")));
    private static final Component GEM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", FAUtils.resource("smithing_template.scarab_gem_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_GEM = FAUtils.resource("container/slot/scarab_gem");

    public ModSmithingTemplateItem(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties);
    }

    public static ModSmithingTemplateItem createGemUpgradeTemplate(Properties properties) {
        return new ModSmithingTemplateItem(GEM_UPGRADE_APPLIES_TO, GEM_UPGRADE_INGREDIENTS, GEM_UPGRADE_BASE_SLOT_DESCRIPTION, GEM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createGemUpgradeIconList(), createGemUpgradeMaterialList(), properties);
    }

    private static List<ResourceLocation> createGemUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createGemUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_GEM);
    }
}
