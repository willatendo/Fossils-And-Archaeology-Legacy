package willatendo.fossilslegacy.data;

import java.util.function.Consumer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.BlockPredicate;
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
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.criteria.TameZombifiedPigmanTrigger;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyAdvancementProvider implements AdvancementGenerator {
	@Override
	public void generate(Provider provider, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
		// Legacy Advancements
		Advancement legacyRoot = Advancement.Builder.advancement().display(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyUtils.translation("advancements", "legacy.root.title"), FossilsLegacyUtils.translation("advancements", "legacy.root.desc"), new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), FrameType.TASK, false, false, false).addCriterion("ticks", PlayerTrigger.TriggerInstance.tick()).save(saver, FossilsLegacyUtils.resource("legacy/root"), existingFileHelper);
//		Advancement fossil =
		Advancement.Builder.advancement().parent(legacyRoot).display(FossilsLegacyItems.FOSSIL.get(), FossilsLegacyUtils.translation("advancements", "legacy.fossil.title"), FossilsLegacyUtils.translation("advancements", "legacy.fossil.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_fossil", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.FOSSIL.get())).save(saver, FossilsLegacyUtils.resource("legacy/fossil"), existingFileHelper);
		Advancement relicScraps = Advancement.Builder.advancement().parent(legacyRoot).display(FossilsLegacyItems.RELIC_SCRAP.get(), FossilsLegacyUtils.translation("advancements", "legacy.relic_scrap.title"), FossilsLegacyUtils.translation("advancements", "legacy.relic_scrap.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_relic_scrap", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.RELIC_SCRAP.get())).save(saver, FossilsLegacyUtils.resource("legacy/relic_scrap"), existingFileHelper);
		Advancement swordArtifact = Advancement.Builder.advancement().parent(relicScraps).display(FossilsLegacyItems.SWORD_ARTIFACT.get(), FossilsLegacyUtils.translation("advancements", "legacy.sword_artifact.title"), FossilsLegacyUtils.translation("advancements", "legacy.sword_artifact.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_sword_artifact", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.SWORD_ARTIFACT.get())).save(saver, FossilsLegacyUtils.resource("legacy/sword_artifact"), existingFileHelper);
		Advancement ancientSword = Advancement.Builder.advancement().parent(swordArtifact).display(FossilsLegacyItems.ANCIENT_SWORD.get(), FossilsLegacyUtils.translation("advancements", "legacy.ancient_sword.title"), FossilsLegacyUtils.translation("advancements", "legacy.ancient_sword.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_ancient_sword", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_SWORD.get())).save(saver, FossilsLegacyUtils.resource("legacy/ancient_sword"), existingFileHelper);
		Advancement.Builder.advancement().parent(ancientSword).display(FossilsLegacyItems.ANCIENT_SWORD.get(), FossilsLegacyUtils.translation("advancements", "legacy.pigman.title"), FossilsLegacyUtils.translation("advancements", "legacy.pigman.desc"), null, FrameType.TASK, true, true, true).addCriterion("created_pigman", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_SWORD.get())).save(saver, FossilsLegacyUtils.resource("legacy/pigman"), existingFileHelper);
		Advancement helmetArtifact = Advancement.Builder.advancement().parent(relicScraps).display(FossilsLegacyItems.HELMET_ARTIFACT.get(), FossilsLegacyUtils.translation("advancements", "legacy.helmet_artifact.title"), FossilsLegacyUtils.translation("advancements", "legacy.helmet_artifact.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_helmet_artifact", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.HELMET_ARTIFACT.get())).save(saver, FossilsLegacyUtils.resource("legacy/helmet_artifact"), existingFileHelper);
		Advancement ancientHelmet = Advancement.Builder.advancement().parent(helmetArtifact).display(FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyUtils.translation("advancements", "legacy.ancient_helmet.title"), FossilsLegacyUtils.translation("advancements", "legacy.ancient_helmet.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_ancient_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyItems.ANCIENT_HELMET.get())).save(saver, FossilsLegacyUtils.resource("legacy/ancient_helmet"), existingFileHelper);
		Advancement.Builder.advancement().parent(ancientHelmet).display(FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyUtils.translation("advancements", "legacy.tamed_pigman.title"), FossilsLegacyUtils.translation("advancements", "legacy.tamed_pigman.desc"), null, FrameType.TASK, true, true, true).addCriterion("tamed_pigman", TameZombifiedPigmanTrigger.TriggerInstance.tamedAnimal()).save(saver, FossilsLegacyUtils.resource("legacy/tamed_pigman"), existingFileHelper);
		Advancement archaeologyWorkbench = Advancement.Builder.advancement().parent(relicScraps).display(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyUtils.translation("advancements", "legacy.archaeology_workbench.title"), FossilsLegacyUtils.translation("advancements", "legacy.archaeology_workbench.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_archaeology_workbench", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get())).save(saver, FossilsLegacyUtils.resource("legacy/archaeology_workbench"), existingFileHelper);
		Advancement.Builder.advancement().parent(archaeologyWorkbench).display(FossilsLegacyItems.STONE_HIEROGLYPH.get(), FossilsLegacyUtils.translation("advancements", "legacy.stone_hieroglyph.title"), FossilsLegacyUtils.translation("advancements", "legacy.stone_hieroglyph.desc"), null, FrameType.TASK, true, true, true).addCriterion("used_stone_hieroglyph", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.ANY), ItemPredicate.Builder.item().of(FossilsLegacyItems.STONE_HIEROGLYPH.get()))).save(saver, FossilsLegacyUtils.resource("legacy/stone_hieroglyph"), existingFileHelper);
		Advancement skull = Advancement.Builder.advancement().parent(legacyRoot).display(FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyUtils.translation("advancements", "legacy.skull_block.title"), FossilsLegacyUtils.translation("advancements", "legacy.skull_block.desc"), null, FrameType.TASK, true, true, true).addCriterion("has_skull_block", InventoryChangeTrigger.TriggerInstance.hasItems(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(saver, FossilsLegacyUtils.resource("legacy/skull_block"), existingFileHelper);
		Advancement.Builder.advancement().parent(skull).display(FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyUtils.translation("advancements", "legacy.skeletons.title"), FossilsLegacyUtils.translation("advancements", "legacy.skeletons.desc"), null, FrameType.TASK, true, true, true).addCriterion("killed_skeletons", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(FossilsLegacyEntities.DROWNED_PIRATE.get()))).save(saver, FossilsLegacyUtils.resource("legacy/skeleton"), existingFileHelper);

		// Anu Advancements
//		Advancement anuRoot = 
		Advancement.Builder.advancement().display(Blocks.LAPIS_BLOCK, FossilsLegacyUtils.translation("advancements", "anu.root.title"), FossilsLegacyUtils.translation("advancements", "anu.root.desc"), new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), FrameType.TASK, false, false, false).addCriterion("ticks", PlayerTrigger.TriggerInstance.tick()).save(saver, FossilsLegacyUtils.resource("anu/root"), existingFileHelper);
	}
}