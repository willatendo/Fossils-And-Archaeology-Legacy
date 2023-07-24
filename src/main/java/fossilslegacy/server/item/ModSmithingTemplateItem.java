package fossilslegacy.server.item;

import java.util.List;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
	private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
	private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
	private static final Component GEM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", FossilsLegacyUtils.resource("gem_upgrade"))).withStyle(TITLE_FORMAT);
	private static final Component GEM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.gem_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
	private static final Component GEM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.gem_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
	private static final Component GEM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.gem_upgrade.base_slot_description")));
	private static final Component GEM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", FossilsLegacyUtils.resource("smithing_template.gem_upgrade.additions_slot_description")));
	private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
	private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
	private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
	private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
	private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
	private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
	private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
	private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
	private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
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
