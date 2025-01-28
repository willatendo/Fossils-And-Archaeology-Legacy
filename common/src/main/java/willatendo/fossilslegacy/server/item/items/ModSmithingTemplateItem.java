package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component GEM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", FossilsLegacyUtils.resource("scarab_gem_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component GEM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.scarab_gem_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GEM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.scarab_gem_upgrade.ingredient"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GEM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.scarab_gem_upgrade.base_slot_description")));
    private static final Component GEM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.scarab_gem_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_HELMET = FossilsLegacyUtils.mc("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = FossilsLegacyUtils.mc("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = FossilsLegacyUtils.mc("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = FossilsLegacyUtils.mc("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = FossilsLegacyUtils.mc("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = FossilsLegacyUtils.mc("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = FossilsLegacyUtils.mc("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = FossilsLegacyUtils.mc("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = FossilsLegacyUtils.mc("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_GEM = FossilsLegacyUtils.resource("item/empty_slot_gem");

    public ModSmithingTemplateItem(Component appliesTo, Component ingredients, Component upgradeDescription, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons) {
        super(appliesTo, ingredients, upgradeDescription, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons);
    }

    public static ModSmithingTemplateItem createGemUpgradeTemplate() {
        return new ModSmithingTemplateItem(GEM_UPGRADE_APPLIES_TO, GEM_UPGRADE_INGREDIENTS, GEM_UPGRADE, GEM_UPGRADE_BASE_SLOT_DESCRIPTION, GEM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createGemUpgradeIconList(), createGemUpgradeMaterialList());
    }

    private static List<ResourceLocation> createGemUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createGemUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_GEM);
    }
}
