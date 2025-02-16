package willatendo.fossilslegacy.data;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.client.model.ArticulatedFossilSpecialRenderer;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.DrumBlock;
import willatendo.fossilslegacy.server.block.blocks.FeederBlock;
import willatendo.fossilslegacy.server.block.blocks.JurassicFernBlock;
import willatendo.fossilslegacy.server.block.blocks.SoupCauldronBlock;
import willatendo.fossilslegacy.server.block.properties.FABlockStateProperties;
import willatendo.fossilslegacy.server.item.FAEquipmentAssets;
import willatendo.fossilslegacy.server.item.FAItems;

import java.util.ArrayList;
import java.util.List;

public class FAModelProvider extends ModelProvider {
    public FAModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators) {
        this.generateItemModels(itemModelGenerators);
        this.generateBlockModels(blockModelGenerators);
    }

    private void generateItemModels(ItemModelGenerators itemModelGenerators) {
        ArrayList<Item> basicItems = new ArrayList<>();
        ArrayList<ItemInfo> texturedItems = new ArrayList<>();
        ArrayList<Item> handheldItems = new ArrayList<>();
        ArrayList<ArmorItemInfo> armorItems = new ArrayList<>();
        ArrayList<SpawnEggItemInfo> spawnEggItems = new ArrayList<>();
        basicItems.add(FAItems.FOSSIL.get());
        basicItems.add(FAItems.TRICERATOPS_DNA.get());
        basicItems.add(FAItems.VELOCIRAPTOR_DNA.get());
        basicItems.add(FAItems.TYRANNOSAURUS_DNA.get());
        basicItems.add(FAItems.PTERANODON_DNA.get());
        basicItems.add(FAItems.NAUTILUS_DNA.get());
        basicItems.add(FAItems.FUTABASAURUS_DNA.get());
        basicItems.add(FAItems.MOSASAURUS_DNA.get());
        basicItems.add(FAItems.STEGOSAURUS_DNA.get());
        basicItems.add(FAItems.DILOPHOSAURUS_DNA.get());
        basicItems.add(FAItems.BRACHIOSAURUS_DNA.get());
        basicItems.add(FAItems.CARNOTAURUS_DNA.get());
        basicItems.add(FAItems.CRYOLOPHOSAURUS_DNA.get());
        basicItems.add(FAItems.THERIZINOSAURUS_DNA.get());
        basicItems.add(FAItems.PACHYCEPHALOSAURUS_DNA.get());
        basicItems.add(FAItems.COMPSOGNATHUS_DNA.get());
        basicItems.add(FAItems.GALLIMIMUS_DNA.get());
        basicItems.add(FAItems.SPINOSAURUS_DNA.get());
        basicItems.add(FAItems.ANKYLOSAURUS_DNA.get());
        basicItems.add(FAItems.DIMETRODON_DNA.get());
        basicItems.add(FAItems.JURASSIC_FERN_DNA.get());
        basicItems.add(FAItems.LEPIDODENDRON_DNA.get());
        basicItems.add(FAItems.SIGILLARIA_DNA.get());
        basicItems.add(FAItems.CALAMITES_DNA.get());
        basicItems.add(FAItems.TRICERATOPS_EGG.get());
        basicItems.add(FAItems.VELOCIRAPTOR_EGG.get());
        basicItems.add(FAItems.TYRANNOSAURUS_EGG.get());
        basicItems.add(FAItems.PTERANODON_EGG.get());
        basicItems.add(FAItems.NAUTILUS_EGGS.get());
        basicItems.add(FAItems.FUTABASAURUS_EGG.get());
        basicItems.add(FAItems.MOSASAURUS_EGG.get());
        basicItems.add(FAItems.STEGOSAURUS_EGG.get());
        basicItems.add(FAItems.DILOPHOSAURUS_EGG.get());
        basicItems.add(FAItems.BRACHIOSAURUS_EGG.get());
        basicItems.add(FAItems.CARNOTAURUS_EGG.get());
        basicItems.add(FAItems.CRYOLOPHOSAURUS_EGG.get());
        basicItems.add(FAItems.THERIZINOSAURUS_EGG.get());
        basicItems.add(FAItems.PACHYCEPHALOSAURUS_EGG.get());
        basicItems.add(FAItems.COMPSOGNATHUS_EGG.get());
        basicItems.add(FAItems.GALLIMIMUS_EGG.get());
        basicItems.add(FAItems.SPINOSAURUS_EGG.get());
        basicItems.add(FAItems.ANKYLOSAURUS_EGG.get());
        basicItems.add(FAItems.DIMETRODON_EGG.get());
        basicItems.add(FAItems.RAW_TRICERATOPS.get());
        basicItems.add(FAItems.RAW_VELOCIRAPTOR.get());
        basicItems.add(FAItems.RAW_TYRANNOSAURUS.get());
        basicItems.add(FAItems.RAW_PTERANODON.get());
        basicItems.add(FAItems.NAUTILUS.get());
        basicItems.add(FAItems.RAW_FUTABASAURUS.get());
        basicItems.add(FAItems.RAW_MOSASAURUS.get());
        basicItems.add(FAItems.RAW_STEGOSAURUS.get());
        basicItems.add(FAItems.RAW_DILOPHOSAURUS.get());
        basicItems.add(FAItems.RAW_BRACHIOSAURUS.get());
        basicItems.add(FAItems.RAW_SMILODON.get());
        basicItems.add(FAItems.RAW_MAMMOTH.get());
        basicItems.add(FAItems.RAW_CARNOTAURUS.get());
        basicItems.add(FAItems.RAW_CRYOLOPHOSAURUS.get());
        basicItems.add(FAItems.RAW_THERIZINOSAURUS.get());
        basicItems.add(FAItems.RAW_PACHYCEPHALOSAURUS.get());
        basicItems.add(FAItems.RAW_COMPSOGNATHUS.get());
        basicItems.add(FAItems.RAW_DODO.get());
        basicItems.add(FAItems.RAW_MOA.get());
        basicItems.add(FAItems.RAW_GALLIMIMUS.get());
        basicItems.add(FAItems.RAW_SPINOSAURUS.get());
        basicItems.add(FAItems.RAW_ANKYLOSAURUS.get());
        basicItems.add(FAItems.RAW_DIMETRODON.get());
        basicItems.add(FAItems.COOKED_TRICERATOPS.get());
        basicItems.add(FAItems.COOKED_VELOCIRAPTOR.get());
        basicItems.add(FAItems.COOKED_TYRANNOSAURUS.get());
        basicItems.add(FAItems.COOKED_PTERANODON.get());
        basicItems.add(FAItems.SIO_CHIU_LE.get());
        basicItems.add(FAItems.COOKED_FUTABASAURUS.get());
        basicItems.add(FAItems.COOKED_MOSASAURUS.get());
        basicItems.add(FAItems.COOKED_STEGOSAURUS.get());
        basicItems.add(FAItems.COOKED_DILOPHOSAURUS.get());
        basicItems.add(FAItems.COOKED_BRACHIOSAURUS.get());
        basicItems.add(FAItems.COOKED_SMILODON.get());
        basicItems.add(FAItems.COOKED_MAMMOTH.get());
        basicItems.add(FAItems.COOKED_CARNOTAURUS.get());
        basicItems.add(FAItems.COOKED_CRYOLOPHOSAURUS.get());
        basicItems.add(FAItems.COOKED_THERIZINOSAURUS.get());
        basicItems.add(FAItems.COOKED_PACHYCEPHALOSAURUS.get());
        basicItems.add(FAItems.COOKED_COMPSOGNATHUS.get());
        basicItems.add(FAItems.COOKED_DODO.get());
        basicItems.add(FAItems.COOKED_MOA.get());
        basicItems.add(FAItems.COOKED_GALLIMIMUS.get());
        basicItems.add(FAItems.COOKED_SPINOSAURUS.get());
        basicItems.add(FAItems.COOKED_ANKYLOSAURUS.get());
        basicItems.add(FAItems.COOKED_DIMETRODON.get());
        basicItems.add(FAItems.TYRANNOSAURUS_TOOTH.get());
        handheldItems.add(FAItems.TOOTH_DAGGER.get());
        this.generateTherizinosaurusClaw(itemModelGenerators, FAItems.THERIZINOSAURUS_CLAWS.get());
        handheldItems.add(FAItems.SKULL_STICK.get());
        basicItems.add(FAItems.DINOPEDIA.get());
        basicItems.add(FAItems.RAW_CHICKEN_SOUP_BUCKET.get());
        basicItems.add(FAItems.RAW_BERRY_MEDLEY_BUCKET.get());
        basicItems.add(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        basicItems.add(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get());
        basicItems.add(FAItems.CHICKEN_ESSENCE_BOTTLE.get());
        basicItems.add(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get());
        handheldItems.add(FAItems.LEGACY_GENETIC_CODE.get());
        basicItems.add(FAItems.NAUTILUS_SHELL.get());
        handheldItems.add(FAItems.FROZEN_MEAT.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_FROZEN_MEAT.get(), this.modLocation("item/frozen_meat"), ModelTemplates.FLAT_HANDHELD_ITEM));
        basicItems.add(FAItems.ARMADILLO_DNA.get());
        basicItems.add(FAItems.AXOLOTL_DNA.get());
        basicItems.add(FAItems.CAT_DNA.get());
        basicItems.add(FAItems.CHICKEN_DNA.get());
        basicItems.add(FAItems.COW_DNA.get());
        basicItems.add(FAItems.DOLPHIN_DNA.get());
        basicItems.add(FAItems.DONKEY_DNA.get());
        basicItems.add(FAItems.FOX_DNA.get());
        basicItems.add(FAItems.FROG_DNA.get());
        basicItems.add(FAItems.GOAT_DNA.get());
        basicItems.add(FAItems.HORSE_DNA.get());
        basicItems.add(FAItems.LLAMA_DNA.get());
        basicItems.add(FAItems.MULE_DNA.get());
        basicItems.add(FAItems.OCELOT_DNA.get());
        basicItems.add(FAItems.PANDA_DNA.get());
        basicItems.add(FAItems.PARROT_DNA.get());
        basicItems.add(FAItems.PIG_DNA.get());
        basicItems.add(FAItems.POLAR_BEAR_DNA.get());
        basicItems.add(FAItems.RABBIT_DNA.get());
        basicItems.add(FAItems.SHEEP_DNA.get());
        basicItems.add(FAItems.WOLF_DNA.get());
        basicItems.add(FAItems.SMILODON_DNA.get());
        basicItems.add(FAItems.MAMMOTH_DNA.get());
        basicItems.add(FAItems.DODO_DNA.get());
        basicItems.add(FAItems.MOA_DNA.get());
        basicItems.add(FAItems.ARMADILLO_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.CAT_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.INCUBATED_CHICKEN_EGG.get());
        basicItems.add(FAItems.COW_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.DOLPHIN_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.DONKEY_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.FOX_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.GOAT_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.HORSE_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.LLAMA_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.MULE_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.OCELOT_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.PANDA_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.INCUBATED_PARROT_EGG.get());
        basicItems.add(FAItems.PIG_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.RABBIT_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.SHEEP_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.WOLF_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.SMILODON_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.MAMMOTH_EMBRYO_SYRINGE.get());
        basicItems.add(FAItems.INCUBATED_DODO_EGG.get());
        basicItems.add(FAItems.INCUBATED_MOA_EGG.get());
        basicItems.add(FAItems.DODO_EGG.get());
        basicItems.add(FAItems.MOA_EGG.get());
        basicItems.add(FAItems.MAGIC_CONCH.get());
        basicItems.add(FAItems.JURASSIC_FERN_SPORES.get());
        itemModelGenerators.itemModelOutput.accept(FAItems.ARTICULATED_FOSSIL.get(), ItemModelUtils.specialModel(FAModelTemplates.TEMPLATE_ARTICULATED_FOSSIL.create(FAItems.ARTICULATED_FOSSIL.get(), new TextureMapping().put(TextureSlot.PARTICLE, this.modLocation("item/articulated_fossil")), itemModelGenerators.modelOutput), new ArticulatedFossilSpecialRenderer.Unbaked()));
        basicItems.add(FAItems.RELIC_SCRAP.get());
        basicItems.add(FAItems.STONE_TABLET.get());
        handheldItems.add(FAItems.ANCIENT_SWORD_ARTIFACT.get());
        handheldItems.add(FAItems.ANCIENT_SHOVEL_ARTIFACT.get());
        handheldItems.add(FAItems.ANCIENT_PICKAXE_ARTIFACT.get());
        handheldItems.add(FAItems.ANCIENT_AXE_ARTIFACT.get());
        handheldItems.add(FAItems.ANCIENT_HOE_ARTIFACT.get());
        basicItems.add(FAItems.ANCIENT_HELMET_ARTIFACT.get());
        basicItems.add(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        basicItems.add(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        basicItems.add(FAItems.ANCIENT_BOOTS_ARTIFACT.get());
        basicItems.add(FAItems.SCARAB_GEM.get());
        basicItems.add(FAItems.JADE.get());
        basicItems.add(FAItems.JADE_OCELOT.get());
        basicItems.add(FAItems.JADE_VILLAGER.get());
        basicItems.add(FAItems.CODEX.get());
        basicItems.add(FAItems.QUIPU.get());
        handheldItems.add(FAItems.ANCIENT_SWORD.get());
        handheldItems.add(FAItems.ANCIENT_SHOVEL.get());
        handheldItems.add(FAItems.ANCIENT_PICKAXE.get());
        handheldItems.add(FAItems.ANCIENT_AXE.get());
        handheldItems.add(FAItems.ANCIENT_HOE.get());
        armorItems.add(new ArmorItemInfo(FAItems.ANCIENT_HELMET.get(), FAEquipmentAssets.ANCIENT, "helmet"));
        armorItems.add(new ArmorItemInfo(FAItems.ANCIENT_CHESTPLATE.get(), FAEquipmentAssets.ANCIENT, "chestplate"));
        armorItems.add(new ArmorItemInfo(FAItems.ANCIENT_LEGGINGS.get(), FAEquipmentAssets.ANCIENT, "leggings"));
        armorItems.add(new ArmorItemInfo(FAItems.ANCIENT_BOOTS.get(), FAEquipmentAssets.ANCIENT, "boots"));
        handheldItems.add(FAItems.SCARAB_GEM_SWORD.get());
        handheldItems.add(FAItems.SCARAB_GEM_SHOVEL.get());
        handheldItems.add(FAItems.SCARAB_GEM_PICKAXE.get());
        handheldItems.add(FAItems.SCARAB_GEM_AXE.get());
        handheldItems.add(FAItems.SCARAB_GEM_HOE.get());
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_HELMET.get(), FAEquipmentAssets.SCARAB_GEM, "helmet"));
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_CHESTPLATE.get(), FAEquipmentAssets.SCARAB_GEM, "chestplate"));
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_LEGGINGS.get(), FAEquipmentAssets.SCARAB_GEM, "leggings"));
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_BOOTS.get(), FAEquipmentAssets.SCARAB_GEM, "boots"));
        basicItems.add(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItems.add(FAItems.WOODEN_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_WOODEN_JAVELIN.get(), this.modLocation("item/wooden_javelin"), ModelTemplates.FLAT_ITEM));
        basicItems.add(FAItems.STONE_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_STONE_JAVELIN.get(), this.modLocation("item/stone_javelin"), ModelTemplates.FLAT_ITEM));
        basicItems.add(FAItems.IRON_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_IRON_JAVELIN.get(), this.modLocation("item/iron_javelin"), ModelTemplates.FLAT_ITEM));
        basicItems.add(FAItems.GOLDEN_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_GOLDEN_JAVELIN.get(), this.modLocation("item/golden_javelin"), ModelTemplates.FLAT_ITEM));
        basicItems.add(FAItems.DIAMOND_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_DIAMOND_JAVELIN.get(), this.modLocation("item/diamond_javelin"), ModelTemplates.FLAT_ITEM));
        basicItems.add(FAItems.NETHERITE_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_NETHERITE_JAVELIN.get(), this.modLocation("item/netherite_javelin"), ModelTemplates.FLAT_ITEM));
        basicItems.add(FAItems.SCARAB_GEM_JAVELIN.get());
        texturedItems.add(new ItemInfo(FAItems.BROKEN_SCARAB_GEM_JAVELIN.get(), this.modLocation("item/scarab_gem_javelin"), ModelTemplates.FLAT_ITEM));

        spawnEggItems.add(new SpawnEggItemInfo(FAItems.ANU_SPAWN_EGG.get(), 0x432600, 0xa62c14));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.FAILURESAURUS_SPAWN_EGG.get(), 0x51e6a5, 0x1b5128));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.BRACHIOSAURUS_SPAWN_EGG.get(), 0x3b3e55, 0x7f8ba1));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.DILOPHOSAURUS_SPAWN_EGG.get(), 0x686442, 0xf1bc2c));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.FUTABASAURUS_SPAWN_EGG.get(), 0xca6700, 0xb92200));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.MAMMOTH_SPAWN_EGG.get(), 0x3d2700, 0x211500));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.MOSASAURUS_SPAWN_EGG.get(), 0x0d7346, 0xffe1a7));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.NAUTILUS_SPAWN_EGG.get(), 0xc1c1c1, 0xa95453));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.PTERANODON_SPAWN_EGG.get(), 0x7c5d89, 0x450e5b));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.SMILODON_SPAWN_EGG.get(), 0xefa745, 0x9a6527));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.STEGOSAURUS_SPAWN_EGG.get(), 0x839d00, 0x785f00));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.TRICERATOPS_SPAWN_EGG.get(), 0xc2ff51, 0x638a25));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.TYRANNOSAURUS_SPAWN_EGG.get(), 0x918066, 0x4f473a));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.VELOCIRAPTOR_SPAWN_EGG.get(), 0x66965f, 0x884c2e));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.CARNOTAURUS_SPAWN_EGG.get(), 0xbf5242, 0x371c18));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.CRYOLOPHOSAURUS_SPAWN_EGG.get(), 0x547096, 0xec353c));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.THERIZINOSAURUS_SPAWN_EGG.get(), 0x626c44, 0xcf561e));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get(), 0xc06929, 0x2e1a0b));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.COMPSOGNATHUS_SPAWN_EGG.get(), 0x2b482a, 0x172116));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.DODO_SPAWN_EGG.get(), 0x5a5a5a, 0x928b81));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.MOA_SPAWN_EGG.get(), 0x352a17, 0x0f0030));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.GALLIMIMUS_SPAWN_EGG.get(), 0x6e4110, 0x333226));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.SPINOSAURUS_SPAWN_EGG.get(), 0x26261d, 0x646552));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.ANKYLOSAURUS_SPAWN_EGG.get(), 0x533a1b, 0x2d200f));
        spawnEggItems.add(new SpawnEggItemInfo(FAItems.DIMETRODON_SPAWN_EGG.get(), 0x291e26, 0x4a2125));
        basicItems.add(FAItems.LEPIDODENDRON_BOAT.get());
        basicItems.add(FAItems.LEPIDODENDRON_CHEST_BOAT.get());
        basicItems.add(FAItems.SIGILLARIA_BOAT.get());
        basicItems.add(FAItems.SIGILLARIA_CHEST_BOAT.get());
        basicItems.add(FAItems.CALAMITES_BOAT.get());
        basicItems.add(FAItems.CALAMITES_CHEST_BOAT.get());

        basicItems.add(FAItems.OVERWORLD_COIN.get());
        basicItems.add(FAItems.ICE_AGE_COIN.get());
        basicItems.add(FAItems.PREHISTORIC_COIN.get());

        texturedItems.add(new ItemInfo(FAItems.DEBUG_MAX_HUNGER.get(), this.mcLocation("item/bone"), ModelTemplates.FLAT_HANDHELD_ITEM));
        texturedItems.add(new ItemInfo(FAItems.DEBUG_MAX_HEALTH.get(), this.mcLocation("item/bone"), ModelTemplates.FLAT_HANDHELD_ITEM));
        texturedItems.add(new ItemInfo(FAItems.DEBUG_FULL_GROWN.get(), this.mcLocation("item/bone"), ModelTemplates.FLAT_HANDHELD_ITEM));
        texturedItems.add(new ItemInfo(FAItems.DEBUG_BABY.get(), this.mcLocation("item/bone"), ModelTemplates.FLAT_HANDHELD_ITEM));
        texturedItems.add(new ItemInfo(FAItems.DEBUG_TAME.get(), this.mcLocation("item/bone"), ModelTemplates.FLAT_HANDHELD_ITEM));
        texturedItems.add(new ItemInfo(FAItems.DEBUG_CHANGE_GENETICS.get(), this.mcLocation("item/bone"), ModelTemplates.FLAT_HANDHELD_ITEM));

        this.forAllItems(itemModelGenerators, basicItems, ModelTemplates.FLAT_ITEM);
        this.forAllItems(itemModelGenerators, handheldItems, ModelTemplates.FLAT_HANDHELD_ITEM);
        texturedItems.forEach(itemInfo -> itemModelGenerators.itemModelOutput.accept(itemInfo.item(), ItemModelUtils.plainModel(itemInfo.modelTemplate().create(itemInfo.item(), new TextureMapping().put(TextureSlot.LAYER0, itemInfo.texture()), itemModelGenerators.modelOutput))));
        armorItems.forEach(armorItemInfo -> itemModelGenerators.generateTrimmableItem(armorItemInfo.item(), armorItemInfo.equipmentAsset(), armorItemInfo.name(), false));
        spawnEggItems.forEach(spawnEggItemInfo -> itemModelGenerators.generateSpawnEgg(spawnEggItemInfo.item(), spawnEggItemInfo.primaryColor(), spawnEggItemInfo.secondaryColor()));
    }

    private void generateBlockModels(BlockModelGenerators blockModelGenerators) {
        FABlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(blockFamily -> blockModelGenerators.family(blockFamily.getBaseBlock()).generateFor(blockFamily));
        this.createFossil(blockModelGenerators, FABlocks.FOSSIL_ORE.get(), false, "shells", "raptor_leg", "tyrannosaurus_skull");
        this.createFossil(blockModelGenerators, FABlocks.DEEPSLATE_FOSSIL_ORE.get(), true, "shells", "anomalocaris", "trilobite");
        this.createSkull(blockModelGenerators, FABlocks.SKULL_BLOCK.get(), this.modLocation("block/skull_front"));
        this.createSkull(blockModelGenerators, FABlocks.SKULL_LANTERN_BLOCK.get(), this.modLocation("block/skull_lantern_front"));
        this.createAnalyzer(blockModelGenerators, FABlocks.ANALYZER.get());
        this.createCultivator(blockModelGenerators, FABlocks.WHITE_CULTIVATOR.get(), "white");
        this.createCultivator(blockModelGenerators, FABlocks.ORANGE_CULTIVATOR.get(), "orange");
        this.createCultivator(blockModelGenerators, FABlocks.MAGENTA_CULTIVATOR.get(), "magenta");
        this.createCultivator(blockModelGenerators, FABlocks.LIGHT_BLUE_CULTIVATOR.get(), "light_blue");
        this.createCultivator(blockModelGenerators, FABlocks.YELLOW_CULTIVATOR.get(), "yellow");
        this.createCultivator(blockModelGenerators, FABlocks.LIME_CULTIVATOR.get(), "lime");
        this.createCultivator(blockModelGenerators, FABlocks.PINK_CULTIVATOR.get(), "pink");
        this.createCultivator(blockModelGenerators, FABlocks.GRAY_CULTIVATOR.get(), "gray");
        this.createCultivator(blockModelGenerators, FABlocks.LIGHT_GRAY_CULTIVATOR.get(), "light_gray");
        this.createCultivator(blockModelGenerators, FABlocks.CYAN_CULTIVATOR.get(), "cyan");
        this.createCultivator(blockModelGenerators, FABlocks.PURPLE_CULTIVATOR.get(), "purple");
        this.createCultivator(blockModelGenerators, FABlocks.BLUE_CULTIVATOR.get(), "blue");
        this.createCultivator(blockModelGenerators, FABlocks.BROWN_CULTIVATOR.get(), "brown");
        this.createCultivator(blockModelGenerators, FABlocks.GREEN_CULTIVATOR.get(), "green");
        this.createCultivator(blockModelGenerators, FABlocks.RED_CULTIVATOR.get(), "red");
        this.createCultivator(blockModelGenerators, FABlocks.BLACK_CULTIVATOR.get(), "black");
        this.createArchaeologyWorkbench(blockModelGenerators, FABlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.createPalaeontologyTable(blockModelGenerators, FABlocks.PALAEONTOLOGY_TABLE.get());
        this.createGeneModificationTable(blockModelGenerators, FABlocks.GENE_MODIFICATION_TABLE.get());
        this.createJurassicFern(blockModelGenerators, FABlocks.JURASSIC_FERN.get());
        this.createDrum(blockModelGenerators, FABlocks.DRUM.get());
        this.createFeeder(blockModelGenerators, FABlocks.FEEDER.get());
        this.createAxolotlSpawn(blockModelGenerators, FABlocks.AXOLOTLSPAWN.get());
        this.createTimeMachine(blockModelGenerators, FABlocks.TIME_MACHINE.get());
        this.createCauldron(blockModelGenerators, FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), this.modLocation("block/raw_chicken_soup"));
        this.createCauldron(blockModelGenerators, FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), this.modLocation("block/cooked_chicken_soup"));
        this.createCauldron(blockModelGenerators, FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), this.modLocation("block/raw_berry_medley"));
        this.createCauldron(blockModelGenerators, FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), this.modLocation("block/cooked_berry_medley"));
        this.createBasic(blockModelGenerators, FABlocks.PERMAFROST.get());
        this.createBasic(blockModelGenerators, FABlocks.ICED_STONE.get());
        this.createMayanVase(blockModelGenerators, FABlocks.MAYAN_VASE.get(), this.modLocation("block/mayan_pot_side"));
        this.createMayanVase(blockModelGenerators, FABlocks.MAYAN_JADE_VASE.get(), this.modLocation("block/mayan_pot_side_jade"));
        this.createMayanVase(blockModelGenerators, FABlocks.MAYAN_OCELOT_VASE.get(), this.modLocation("block/mayan_pot_side_ocelot"));
        this.createMayanVase(blockModelGenerators, FABlocks.MAYAN_VILLAGER_VASE.get(), this.modLocation("block/mayan_pot_side_villager"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.IRON_LLAMA_STATUE.get(), this.modLocation("block/iron_llama_statue"), this.mcLocation("block/iron_block"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.COPPER_LLAMA_STATUE.get(), this.modLocation("block/copper_llama_statue"), this.mcLocation("block/copper_block"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/exposed_copper_llama_statue"), this.mcLocation("block/exposed_copper"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/weathered_copper_llama_statue"), this.mcLocation("block/weathered_copper"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/oxidized_copper_llama_statue"), this.mcLocation("block/oxidized_copper"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.WAXED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/copper_llama_statue"), this.mcLocation("block/copper_block"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/exposed_copper_llama_statue"), this.mcLocation("block/exposed_copper"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/weathered_copper_llama_statue"), this.mcLocation("block/weathered_copper"));
        this.createLlamaStatue(blockModelGenerators, FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get(), this.modLocation("block/oxidized_copper_llama_statue"), this.mcLocation("block/oxidized_copper"));
        blockModelGenerators.woodProvider(FABlocks.CALAMITES_LOG.get()).logWithHorizontal(FABlocks.CALAMITES_LOG.get()).wood(FABlocks.CALAMITES_WOOD.get());
        blockModelGenerators.woodProvider(FABlocks.STRIPPED_CALAMITES_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_CALAMITES_LOG.get()).wood(FABlocks.STRIPPED_CALAMITES_WOOD.get());
        blockModelGenerators.createHangingSign(FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get());
        blockModelGenerators.createPlantWithDefaultItem(FABlocks.CALAMITES_SAPLING.get(), FABlocks.POTTED_CALAMITES_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createTintedLeaves(FABlocks.CALAMITES_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        blockModelGenerators.woodProvider(FABlocks.LEPIDODENDRON_LOG.get()).logWithHorizontal(FABlocks.LEPIDODENDRON_LOG.get()).wood(FABlocks.LEPIDODENDRON_WOOD.get());
        blockModelGenerators.woodProvider(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get()).wood(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        blockModelGenerators.createHangingSign(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get());
        blockModelGenerators.createPlantWithDefaultItem(FABlocks.LEPIDODENDRON_SAPLING.get(), FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createTintedLeaves(FABlocks.LEPIDODENDRON_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        blockModelGenerators.woodProvider(FABlocks.SIGILLARIA_LOG.get()).logWithHorizontal(FABlocks.SIGILLARIA_LOG.get()).wood(FABlocks.SIGILLARIA_WOOD.get());
        blockModelGenerators.woodProvider(FABlocks.STRIPPED_SIGILLARIA_LOG.get()).logWithHorizontal(FABlocks.STRIPPED_SIGILLARIA_LOG.get()).wood(FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
        blockModelGenerators.createHangingSign(FABlocks.STRIPPED_SIGILLARIA_LOG.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get());
        blockModelGenerators.createPlantWithDefaultItem(FABlocks.SIGILLARIA_SAPLING.get(), FABlocks.POTTED_SIGILLARIA_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createTintedLeaves(FABlocks.SIGILLARIA_LEAVES.get(), TexturedModel.LEAVES, -12012264);
    }

    private void generateTherizinosaurusClaw(ItemModelGenerators itemModelGenerators, Item therizinosaursClawItem) {
        ItemModel.Unbaked flatUnbaked = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(therizinosaursClawItem, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked unbaked3d = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(therizinosaursClawItem, "_in_hand"));
        itemModelGenerators.itemModelOutput.accept(therizinosaursClawItem, ItemModelGenerators.createFlatModelDispatch(flatUnbaked, unbaked3d));
    }

    private void createBasic(BlockModelGenerators blockModelGenerators, Block block) {
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_ALL.create(block, TextureMapping.cube(block), blockModelGenerators.modelOutput)));
    }

    private void createFossil(BlockModelGenerators blockModelGenerators, Block fossil, boolean deepslate, String... variantNames) {
        List<Variant> variants = Lists.newArrayList();
        for (int i = 0; i < variantNames.length; i++) {
            String variantName = variantNames[i];
            String blockId = BuiltInRegistries.BLOCK.getKey(fossil).getPath();
            String texturePath = deepslate ? "block/deepslate_" + variantName + "_" + blockId.replace("deepslate_", "") : "block/" + variantName + "_" + blockId;
            ResourceLocation model = ModelTemplates.CUBE_ALL.create(this.modLocation(texturePath), TextureMapping.cube(this.modLocation(texturePath)), blockModelGenerators.modelOutput);
            variants.add(Variant.variant().with(VariantProperties.MODEL, model));
            if (i == 0) {
                blockModelGenerators.registerSimpleItemModel(fossil, model);
            }
        }
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(fossil, variants.toArray(Variant[]::new)));
    }

    private void createSkull(BlockModelGenerators blockModelGenerators, Block skull, ResourceLocation frontTexture) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(skull, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(skull, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/skull")).put(TextureSlot.EAST, this.modLocation("block/skull_crack")).put(TextureSlot.NORTH, frontTexture).put(TextureSlot.PARTICLE, this.modLocation("block/skull_crack")).put(TextureSlot.SOUTH, this.modLocation("block/skull_crack")).put(TextureSlot.UP, this.modLocation("block/skull")).put(TextureSlot.WEST, this.modLocation("block/skull_crack")), blockModelGenerators.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createAnalyzer(BlockModelGenerators blockModelGenerators, Block analyzer) {
        this.createActiveType(blockModelGenerators, analyzer, ModelTemplates.CUBE.create(analyzer, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/analyzer_top")).put(TextureSlot.EAST, this.modLocation("block/analyzer_side")).put(TextureSlot.NORTH, this.modLocation("block/analyzer_front_off")).put(TextureSlot.PARTICLE, this.modLocation("block/analyzer_side")).put(TextureSlot.SOUTH, this.modLocation("block/analyzer_back")).put(TextureSlot.UP, this.modLocation("block/analyzer_top")).put(TextureSlot.WEST, this.modLocation("block/analyzer_side")), blockModelGenerators.modelOutput), ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(analyzer).withSuffix("_active"), new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/analyzer_top")).put(TextureSlot.EAST, this.modLocation("block/analyzer_side")).put(TextureSlot.NORTH, this.modLocation("block/analyzer_front_on")).put(TextureSlot.PARTICLE, this.modLocation("block/analyzer_side")).put(TextureSlot.SOUTH, this.modLocation("block/analyzer_back")).put(TextureSlot.UP, this.modLocation("block/analyzer_top")).put(TextureSlot.WEST, this.modLocation("block/analyzer_side")), blockModelGenerators.modelOutput), FABlockStateProperties.ACTIVE, true);
    }

    private void createCultivator(BlockModelGenerators blockModelGenerators, Block cultivator, String color) {
        this.createActiveType(blockModelGenerators, cultivator, FAModelTemplates.TEMPLATE_CULTIVATOR.create(cultivator, new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_cultivator_side")).put(TextureSlot.TOP, this.modLocation("block/" + color + "_cultivator_top")), blockModelGenerators.modelOutput), FAModelTemplates.TEMPLATE_CULTIVATOR_ACTIVE.create(ModelLocationUtils.getModelLocation(cultivator).withSuffix("_active"), new TextureMapping().put(TextureSlot.SIDE, this.modLocation("block/" + color + "_cultivator_side")).put(TextureSlot.TOP, this.modLocation("block/" + color + "_cultivator_top")), blockModelGenerators.modelOutput), FABlockStateProperties.ACTIVE, false);
    }

    private void createArchaeologyWorkbench(BlockModelGenerators blockModelGenerators, Block archeologyWorkbench) {
        this.createActiveType(blockModelGenerators, archeologyWorkbench, ModelTemplates.CUBE.create(archeologyWorkbench, new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/archaeology_workbench_bottom")).put(TextureSlot.EAST, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.NORTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.PARTICLE, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.SOUTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.UP, this.modLocation("block/archaeology_workbench_top_off")).put(TextureSlot.WEST, this.modLocation("block/archaeology_workbench_side")), blockModelGenerators.modelOutput), ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(archeologyWorkbench).withSuffix("_active"), new TextureMapping().put(TextureSlot.DOWN, this.modLocation("block/archaeology_workbench_bottom")).put(TextureSlot.EAST, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.NORTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.PARTICLE, this.modLocation("block/archaeology_workbench_side")).put(TextureSlot.SOUTH, this.modLocation("block/archaeology_workbench_books")).put(TextureSlot.UP, this.modLocation("block/archaeology_workbench_top_on")).put(TextureSlot.WEST, this.modLocation("block/archaeology_workbench_side")), blockModelGenerators.modelOutput), FABlockStateProperties.ACTIVE, true);
    }

    private void createPalaeontologyTable(BlockModelGenerators blockModelGenerators, Block palaeontologyTable) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(palaeontologyTable, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP.create(palaeontologyTable, new TextureMapping().put(TextureSlot.BOTTOM, this.modLocation("block/lepidodendron_planks")).put(TextureSlot.PARTICLE, this.modLocation("block/palaeontology_table_side")).put(TextureSlot.SIDE, this.modLocation("block/palaeontology_table_side")).put(TextureSlot.TOP, this.modLocation("block/palaeontology_table_top")), blockModelGenerators.modelOutput))));
    }

    private void createActiveType(BlockModelGenerators blockModelGenerators, Block block, ResourceLocation inactive, ResourceLocation active, BooleanProperty booleanProperty, boolean directional) {
        MultiVariantGenerator multiVariantGenerator = MultiVariantGenerator.multiVariant(block, Variant.variant()).with(BlockModelGenerators.createBooleanModelDispatch(booleanProperty, active, inactive));
        if (directional) {
            multiVariantGenerator.with(BlockModelGenerators.createHorizontalFacingDispatch());
        }
        blockModelGenerators.blockStateOutput.accept(multiVariantGenerator);
    }

    private void createGeneModificationTable(BlockModelGenerators blockModelGenerators, Block geneModificationTable) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(geneModificationTable, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_GENE_MODIFICATION_TABLE.create(geneModificationTable, new TextureMapping().put(TextureSlot.FRONT, this.modLocation("block/gene_modification_table_front_off")), blockModelGenerators.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void createJurassicFern(BlockModelGenerators blockModelGenerators, Block jurassicFern) {
        blockModelGenerators.registerSimpleItemModel(jurassicFern, ModelTemplates.FLAT_ITEM.create(jurassicFern, new TextureMapping().put(TextureSlot.LAYER0, this.modLocation("block/fern_lower_3")), blockModelGenerators.modelOutput));
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(jurassicFern).with(PropertyDispatch.properties(JurassicFernBlock.HALF, JurassicFernBlock.GROWTH).select(DoubleBlockHalf.LOWER, 0, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.LOWER, 0))).select(DoubleBlockHalf.LOWER, 1, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.LOWER, 1))).select(DoubleBlockHalf.LOWER, 2, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.LOWER, 2))).select(DoubleBlockHalf.LOWER, 3, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.LOWER, 3))).select(DoubleBlockHalf.LOWER, 4, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.LOWER, 4))).select(DoubleBlockHalf.LOWER, 5, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.LOWER, 5))).select(DoubleBlockHalf.UPPER, 0, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.UPPER, 0))).select(DoubleBlockHalf.UPPER, 1, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.UPPER, 1))).select(DoubleBlockHalf.UPPER, 2, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.UPPER, 2))).select(DoubleBlockHalf.UPPER, 3, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.UPPER, 3))).select(DoubleBlockHalf.UPPER, 4, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.UPPER, 4))).select(DoubleBlockHalf.UPPER, 5, Variant.variant().with(VariantProperties.MODEL, this.createJurassicFernModel(blockModelGenerators, jurassicFern, DoubleBlockHalf.UPPER, 5)))));
    }

    private ResourceLocation createJurassicFernModel(BlockModelGenerators blockModelGenerators, Block jurassicFern, DoubleBlockHalf doubleBlockHalf, int growthStage) {
        int i = (doubleBlockHalf == DoubleBlockHalf.UPPER && growthStage < 4) ? 4 : growthStage;
        return FAModelTemplates.TEMPLATE_COLORED_CROP.create(ModelLocationUtils.getModelLocation(jurassicFern).withSuffix("_" + doubleBlockHalf.getSerializedName() + "_" + growthStage), new TextureMapping().put(TextureSlot.CROP, this.modLocation("block/jurassic_fern_colored_" + doubleBlockHalf.getSerializedName() + "_" + i)).put(FATextureSlot.CROP_LEAVES, this.modLocation("block/jurassic_fern_leaves_" + doubleBlockHalf.getSerializedName() + "_" + i)), blockModelGenerators.modelOutput);
    }

    private void createDrum(BlockModelGenerators blockModelGenerators, Block drum) {
        ResourceLocation followModel = ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_follow"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_follow")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), blockModelGenerators.modelOutput);
        blockModelGenerators.registerSimpleItemModel(drum, followModel);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(drum).with(PropertyDispatch.property(DrumBlock.COMMAND_TYPE_PROPERTY).select("follow", Variant.variant().with(VariantProperties.MODEL, followModel)).select("stay", Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_stay"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_stay")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), blockModelGenerators.modelOutput))).select("free_move", Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(drum).withSuffix("_free_move"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/spruce_planks")).put(TextureSlot.EAST, this.modLocation("block/drum_side")).put(TextureSlot.NORTH, this.modLocation("block/drum_side")).put(TextureSlot.PARTICLE, this.modLocation("block/drum_side")).put(TextureSlot.SOUTH, this.modLocation("block/drum_side")).put(TextureSlot.UP, this.modLocation("block/drum_free_move")).put(TextureSlot.WEST, this.modLocation("block/drum_side")), blockModelGenerators.modelOutput)))));
    }

    private void createFeeder(BlockModelGenerators blockModelGenerators, Block feeder) {
        ResourceLocation emptyModel = ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_empty"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/smooth_stone")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_empty")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), blockModelGenerators.modelOutput);
        blockModelGenerators.registerSimpleItemModel(feeder, emptyModel);
        this.createActiveType(blockModelGenerators, feeder, emptyModel, ModelTemplates.CUBE.create(ModelLocationUtils.getModelLocation(feeder).withSuffix("_full"), new TextureMapping().put(TextureSlot.DOWN, this.mcLocation("block/smooth_stone")).put(TextureSlot.EAST, this.modLocation("block/feeder_side")).put(TextureSlot.NORTH, this.modLocation("block/feeder_front")).put(TextureSlot.PARTICLE, this.modLocation("block/feeder_side")).put(TextureSlot.SOUTH, this.modLocation("block/feeder_side")).put(TextureSlot.UP, this.modLocation("block/feeder_top_empty")).put(TextureSlot.WEST, this.modLocation("block/feeder_side")), blockModelGenerators.modelOutput), FeederBlock.HAS_FOOD, true);
    }

    private void createAxolotlSpawn(BlockModelGenerators blockModelGenerators, Block axolotlSpawn) {
        blockModelGenerators.registerSimpleFlatItemModel(axolotlSpawn);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(axolotlSpawn, FAModelTemplates.FROGSPAWN.create(axolotlSpawn, new TextureMapping().put(TextureSlot.TEXTURE, this.modLocation("block/axolotlspawn")).put(TextureSlot.PARTICLE, this.modLocation("block/axolotlspawn")), blockModelGenerators.modelOutput)));
    }

    private void createTimeMachine(BlockModelGenerators blockModelGenerators, Block timeMachine) {
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(timeMachine, FAModelTemplates.TEMPLATE_TIME_MACHINE.create(timeMachine, new TextureMapping(), blockModelGenerators.modelOutput)));
    }

    private void createCauldron(BlockModelGenerators blockModelGenerators, Block cauldron, ResourceLocation texture) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(cauldron).with(PropertyDispatch.property(SoupCauldronBlock.LEVEL).select(1, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_1, 1, texture))).select(2, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_2, 2, texture))).select(3, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_3, 3, texture))).select(4, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_4, 4, texture))).select(5, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_5, 5, texture))).select(6, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_6, 6, texture))).select(7, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_7, 7, texture))).select(8, Variant.variant().with(VariantProperties.MODEL, this.createCauldonModel(blockModelGenerators, cauldron, FAModelTemplates.TEMPLATE_SOUP_CAULDRON_8, 8, texture)))));
    }

    private ResourceLocation createCauldonModel(BlockModelGenerators blockModelGenerators, Block cauldron, ModelTemplate modelTemplate, int i, ResourceLocation texture) {
        return modelTemplate.create(ModelLocationUtils.getModelLocation(cauldron).withSuffix("_" + i), new TextureMapping().put(TextureSlot.CONTENT, texture), blockModelGenerators.modelOutput);
    }

    private void createMayanVase(BlockModelGenerators blockModelGenerators, Block mayanVase, ResourceLocation texture) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(mayanVase, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_VASE.create(mayanVase, new TextureMapping().put(TextureSlot.SIDE, texture), blockModelGenerators.modelOutput))));
    }

    private void createLlamaStatue(BlockModelGenerators blockModelGenerators, Block llama, ResourceLocation texture, ResourceLocation particle) {
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(llama, Variant.variant().with(VariantProperties.MODEL, FAModelTemplates.TEMPLATE_LLAMA.create(llama, new TextureMapping().put(TextureSlot.TEXTURE, texture).put(TextureSlot.PARTICLE, particle), blockModelGenerators.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private void forAllItems(ItemModelGenerators itemModelGenerators, List<Item> items, ModelTemplate modelTemplate) {
        items.forEach(item -> itemModelGenerators.generateFlatItem(item, modelTemplate));
    }

    private record ItemInfo(Item item, ResourceLocation texture, ModelTemplate modelTemplate) {
    }

    private record ArmorItemInfo(Item item, ResourceKey<EquipmentAsset> equipmentAsset, String name) {
    }

    private record SpawnEggItemInfo(Item item, int primaryColor, int secondaryColor) {
    }
}
