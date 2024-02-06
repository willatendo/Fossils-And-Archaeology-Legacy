package willatendo.fossilslegacy.data;

import java.util.function.Consumer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.criteria.AnuOnEarthTrigger;
import willatendo.fossilslegacy.server.criteria.TameZombifiedPigmanTrigger;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.SimpleAdvancementProvider.AdvancementGenerator;

public class FossilsLegacyAdvancementProvider implements AdvancementGenerator {
	@Override
	public void generate(Provider provider, Consumer<AdvancementHolder> saver) {
		// Legacy Advancements
		AdvancementHolder legacyRoot = Advancement.Builder.advancement().display(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyUtils.translation("advancements", "legacy.root.title"), FossilsLegacyUtils.translation("advancements", "legacy.root.desc"), new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), AdvancementType.TASK, false, false, false).addCriterion("ticks", PlayerTrigger.TriggerInstance.tick()).save(saver, FossilsLegacyUtils.resource("legacy/root").toString());
		Advancement.Builder.advancement().parent(legacyRoot).display(FossilsLegacyItems.FOSSIL.get(), FossilsLegacyUtils.translation("advancements", "legacy.fossil.title"), FossilsLegacyUtils.translation("advancements", "legacy.fossil.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_fossil", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.FOSSIL.get())).save(saver, FossilsLegacyUtils.resource("legacy/fossil").toString());
		AdvancementHolder relicScraps = Advancement.Builder.advancement().parent(legacyRoot).display(FossilsLegacyItems.RELIC_SCRAP.get(), FossilsLegacyUtils.translation("advancements", "legacy.relic_scrap.title"), FossilsLegacyUtils.translation("advancements", "legacy.relic_scrap.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_relic_scrap", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.RELIC_SCRAP.get())).save(saver, FossilsLegacyUtils.resource("legacy/relic_scrap").toString());
		AdvancementHolder ancientSwordArtifact = Advancement.Builder.advancement().parent(relicScraps).display(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), FossilsLegacyUtils.translation("advancements", "legacy.ancient_sword_artifact.title"), FossilsLegacyUtils.translation("advancements", "legacy.ancient_sword_artifact.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_sword_artifact", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get())).save(saver, FossilsLegacyUtils.resource("legacy/sword_artifact").toString());
		AdvancementHolder ancientSword = Advancement.Builder.advancement().parent(ancientSwordArtifact).display(FossilsLegacyItems.ANCIENT_SWORD.get(), FossilsLegacyUtils.translation("advancements", "legacy.ancient_sword.title"), FossilsLegacyUtils.translation("advancements", "legacy.ancient_sword.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_ancient_sword", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_SWORD.get())).save(saver, FossilsLegacyUtils.resource("legacy/ancient_sword").toString());
		Advancement.Builder.advancement().parent(ancientSword).display(FossilsLegacyItems.ANCIENT_SWORD.get(), FossilsLegacyUtils.translation("advancements", "legacy.pigman.title"), FossilsLegacyUtils.translation("advancements", "legacy.pigman.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("created_pigman", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_SWORD.get())).save(saver, FossilsLegacyUtils.resource("legacy/pigman").toString());
		AdvancementHolder ancientHelmetArtifact = Advancement.Builder.advancement().parent(relicScraps).display(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), FossilsLegacyUtils.translation("advancements", "legacy.ancient_helmet_artifact.title"), FossilsLegacyUtils.translation("advancements", "legacy.ancient_helmet_artifact.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_helmet_artifact", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get())).save(saver, FossilsLegacyUtils.resource("legacy/helmet_artifact").toString());
		AdvancementHolder ancientHelmet = Advancement.Builder.advancement().parent(ancientHelmetArtifact).display(FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyUtils.translation("advancements", "legacy.ancient_helmet.title"), FossilsLegacyUtils.translation("advancements", "legacy.ancient_helmet.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_ancient_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_HELMET.get())).save(saver, FossilsLegacyUtils.resource("legacy/ancient_helmet").toString());
		Advancement.Builder.advancement().parent(ancientHelmet).display(FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyUtils.translation("advancements", "legacy.tamed_pigman.title"), FossilsLegacyUtils.translation("advancements", "legacy.tamed_pigman.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("tamed_pigman", TameZombifiedPigmanTrigger.TriggerInstance.tamedAnimal()).save(saver, FossilsLegacyUtils.resource("legacy/tamed_pigman").toString());
		AdvancementHolder archaeologyWorkbench = Advancement.Builder.advancement().parent(relicScraps).display(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyUtils.translation("advancements", "legacy.archaeology_workbench.title"), FossilsLegacyUtils.translation("advancements", "legacy.archaeology_workbench.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_archaeology_workbench", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get())).save(saver, FossilsLegacyUtils.resource("legacy/archaeology_workbench").toString());
		Advancement.Builder.advancement().parent(archaeologyWorkbench).display(FossilsLegacyItems.STONE_TABLET.get(), FossilsLegacyUtils.translation("advancements", "legacy.stone_tablet.title"), FossilsLegacyUtils.translation("advancements", "legacy.stone_tablet.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("used_stone_tablet", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location(), ItemPredicate.Builder.item().of(FossilsLegacyItems.STONE_TABLET.get()))).save(saver, FossilsLegacyUtils.resource("legacy/stone_tablet").toString());
		AdvancementHolder skull = Advancement.Builder.advancement().parent(legacyRoot).display(FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyUtils.translation("advancements", "legacy.skull_block.title"), FossilsLegacyUtils.translation("advancements", "legacy.skull_block.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("has_skull_block", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(saver, FossilsLegacyUtils.resource("legacy/skull_block").toString());
		Advancement.Builder.advancement().parent(skull).display(FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyUtils.translation("advancements", "legacy.skeletons.title"), FossilsLegacyUtils.translation("advancements", "legacy.skeletons.desc"), null, AdvancementType.TASK, true, true, true).addCriterion("killed_skeletons", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(FossilsLegacyEntities.DROWNED_PIRATE.get()))).save(saver, FossilsLegacyUtils.resource("legacy/skeleton").toString());

		// Anu Advancements
		Advancement.Builder.advancement().display(Blocks.LAPIS_BLOCK, FossilsLegacyUtils.translation("advancements", "anu.root.title"), FossilsLegacyUtils.translation("advancements", "anu.root.desc"), new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), AdvancementType.TASK, false, false, false).addCriterion("anu_on_earth", AnuOnEarthTrigger.TriggerInstance.anuOnEarth()).save(saver, FossilsLegacyUtils.resource("anu/root").toString());
	}
}
