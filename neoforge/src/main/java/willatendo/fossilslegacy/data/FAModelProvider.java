package willatendo.fossilslegacy.data;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
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
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.block.FABlocks;
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
        //       this.getBuilder("articulated_fossil").parent(new ModelFile.UncheckedModelFile("builtin/entity")).texture("particle", this.modLoc("item/articulated_fossil")).transforms().transform(ItemDisplayContext.GUI).rotation(30.0F, 135.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(0.625F, 0.625F, 0.625F).end().transform(ItemDisplayContext.GROUND).rotation(0.0F, 0.0F, 0.0F).translation(0.0F, 3.0F, 0.0F).scale(0.25F, 0.25F, 0.25F).end().transform(ItemDisplayContext.HEAD).rotation(0.0F, 180.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(1.0F, 1.0F, 1.0F).end().transform(ItemDisplayContext.FIXED).rotation(0.0F, 0.0F, 0.0F).translation(0.0F, 3.0F, 0.0F).scale(0.5F, 0.5F, 0.5F).end().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75.0F, 135.0F, 0.0F).translation(0.0F, 2.5F, 0.0F).scale(0.375F, 0.375F, 0.375F).end().transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, 135.0F, 0.0F).translation(0.0F, 0.0F, 0.0F).scale(0.4F, 0.4F, 0.4F).end();
        itemModelGenerators.declareCustomModelItem(FAItems.ARTICULATED_FOSSIL.get());
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
        armorItems.add(new ArmorItemInfo(FAItems.ANCIENT_LEGGINGS.get(), FAEquipmentAssets.ANCIENT, "leggins"));
        armorItems.add(new ArmorItemInfo(FAItems.ANCIENT_BOOTS.get(), FAEquipmentAssets.ANCIENT, "boots"));
        handheldItems.add(FAItems.SCARAB_GEM_SWORD.get());
        handheldItems.add(FAItems.SCARAB_GEM_SHOVEL.get());
        handheldItems.add(FAItems.SCARAB_GEM_PICKAXE.get());
        handheldItems.add(FAItems.SCARAB_GEM_AXE.get());
        handheldItems.add(FAItems.SCARAB_GEM_HOE.get());
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_HELMET.get(), FAEquipmentAssets.SCARAB_GEM, "helmet"));
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_CHESTPLATE.get(), FAEquipmentAssets.SCARAB_GEM, "chestplate"));
        armorItems.add(new ArmorItemInfo(FAItems.SCARAB_GEM_LEGGINGS.get(), FAEquipmentAssets.SCARAB_GEM, "leggins"));
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
        texturedItems.forEach(itemInfo -> itemInfo.modelTemplate().create(itemInfo.item(), new TextureMapping().put(TextureSlot.LAYER0, itemInfo.texture()), itemModelGenerators.modelOutput));
        armorItems.forEach(armorItemInfo -> itemModelGenerators.generateTrimmableItem(armorItemInfo.item(), armorItemInfo.equipmentAsset(), armorItemInfo.name(), false));
        spawnEggItems.forEach(spawnEggItemInfo -> itemModelGenerators.generateSpawnEgg(spawnEggItemInfo.item(), spawnEggItemInfo.primaryColor(), spawnEggItemInfo.secondaryColor()));
    }

    private void generateBlockModels(BlockModelGenerators blockModelGenerators) {
        FABlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(blockFamily -> blockModelGenerators.family(blockFamily.getBaseBlock()).generateFor(blockFamily));
        this.createFossil(blockModelGenerators, FABlocks.FOSSIL_ORE.get(), false, "shells", "raptor_leg", "tyrannosaurus_skull");
        this.createFossil(blockModelGenerators, FABlocks.DEEPSLATE_FOSSIL_ORE.get(), true, "shells", "anomalocaris", "trilobite");

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

    private void createFossil(BlockModelGenerators blockModelGenerators, Block fossil, boolean deepslate, String... variantNames) {
        List<Variant> variants = Lists.newArrayList();
        for (String variantName : variantNames) {
            String blockId = BuiltInRegistries.BLOCK.getKey(fossil).getPath();
            String texturePath = deepslate ? "blocks/deepslate_" + variantName + "_" + blockId.replace("deepslate_", "") : "blocks/" + variantName + "_" + blockId;
            variants.add(Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_ALL.create(fossil, TextureMapping.cube(this.modLocation(texturePath)), blockModelGenerators.modelOutput)));
        }
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(fossil, variants.toArray(Variant[]::new)));
    }

    private void createSkull(BlockModelGenerators blockModelGenerators, Block skull) {

    }

    private void forAllItems(ItemModelGenerators itemModelGenerators, List<Item> items, ModelTemplate modelTemplate) {
        items.forEach(item -> itemModelGenerators.createFlatItemModel(item, modelTemplate));
    }

    private record ItemInfo(Item item, ResourceLocation texture, ModelTemplate modelTemplate) {
    }

    private record ArmorItemInfo(Item item, ResourceKey<EquipmentAsset> equipmentAsset, String name) {
    }

    private record SpawnEggItemInfo(Item item, int primaryColor, int secondaryColor) {
    }
}
