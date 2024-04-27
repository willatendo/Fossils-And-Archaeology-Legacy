package willatendo.fossilslegacy.experiments.server.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEggVariants;
import willatendo.fossilslegacy.experiments.server.entity.FossilsExperimentsEntityTypes;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.item.FossilsLegacyFoods;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyTiers;
import willatendo.simplelibrary.server.registry.SimpleHolder;

import static willatendo.fossilslegacy.server.item.FossilsLegacyItems.ITEMS;

public class FossilsExperimentsItems {
    public static final SimpleHolder<CoinItem> OVERWORLD_COIN = ITEMS.register("overworld_coin", () -> new CoinItem(Level.OVERWORLD, new Item.Properties()));
    public static final SimpleHolder<CoinItem> NETHER_COIN = ITEMS.register("nether_coin", () -> new CoinItem(Level.NETHER, new Item.Properties()));
    public static final SimpleHolder<CoinItem> PREHISTORIC_COIN = ITEMS.register("prehistoric_coin", () -> new CoinItem(Level.OVERWORLD, new Item.Properties()));
    public static final SimpleHolder<ExperimentalItem> CARNOTAURUS_DNA = ITEMS.register("carnotaurus_dna", () -> new ExperimentalItem(new Item.Properties()));
    public static final SimpleHolder<ExperimentalItem> CRYOLOPHOSAURUS_DNA = ITEMS.register("cryolophosaurus_dna", () -> new ExperimentalItem(new Item.Properties()));
    public static final SimpleHolder<ExperimentalItem> THERIZINOSAURUS_DNA = ITEMS.register("therizinosaurus_dna", () -> new ExperimentalItem(new Item.Properties()));
    public static final SimpleHolder<ExperimentalEggItem> CARNOTAURUS_EGG = ITEMS.register("carnotaurus_egg", () -> new ExperimentalEggItem(FossilsExperimentsEggVariants.CARNOTAURUS, new Item.Properties().stacksTo(1)));
    public static final SimpleHolder<ExperimentalEggItem> CRYOLOPHOSAURUS_EGG = ITEMS.register("cryolophosaurus_egg", () -> new ExperimentalEggItem(FossilsExperimentsEggVariants.CRYOLOPHOSAURUS, new Item.Properties().stacksTo(1)));
    public static final SimpleHolder<ExperimentalEggItem> THERIZINOSAURUS_EGG = ITEMS.register("therizinosaurus_egg", () -> new ExperimentalEggItem(FossilsExperimentsEggVariants.THERIZINOSAURUS, new Item.Properties().stacksTo(1)));
    public static final SimpleHolder<ExperimentalItem> RAW_CARNOTAURUS_MEAT = ITEMS.register("raw_carnotaurus_meat", () -> new ExperimentalItem(new Item.Properties().food(FossilsLegacyFoods.RAW_DINOSAUR_MEAT)));
    public static final SimpleHolder<ExperimentalItem> RAW_CRYOLOPHOSAURUS_MEAT = ITEMS.register("raw_cryolophosaurus_meat", () -> new ExperimentalItem(new Item.Properties().food(FossilsLegacyFoods.RAW_DINOSAUR_MEAT)));
    public static final SimpleHolder<ExperimentalItem> RAW_THERIZINOSAURUS_MEAT = ITEMS.register("raw_therizinosaurus_meat", () -> new ExperimentalItem(new Item.Properties().food(FossilsLegacyFoods.RAW_DINOSAUR_MEAT)));
    public static final SimpleHolder<ExperimentalItem> COOKED_CARNOTAURUS_MEAT = ITEMS.register("cooked_carnotaurus_meat", () -> new ExperimentalItem(new Item.Properties().food(FossilsLegacyFoods.COOKED_DINOSAUR_MEAT)));
    public static final SimpleHolder<ExperimentalItem> COOKED_CRYOLOPHOSAURUS_MEAT = ITEMS.register("cooked_cryolophosaurus_meat", () -> new ExperimentalItem(new Item.Properties().food(FossilsLegacyFoods.COOKED_DINOSAUR_MEAT)));
    public static final SimpleHolder<ExperimentalItem> COOKED_THERIZINOSAURUS_MEAT = ITEMS.register("cooked_therizinosaurus_meat", () -> new ExperimentalItem(new Item.Properties().food(FossilsLegacyFoods.COOKED_DINOSAUR_MEAT)));
    public static final SimpleHolder<TherizinosaurusClawsItem> THERIZINOSAURUS_CLAWS = ITEMS.register("therizinosaurus_claws", () -> new TherizinosaurusClawsItem(0, -3.0F, FossilsLegacyTiers.DAGGER, new Item.Properties()));
    public static final SimpleHolder<SpawnEggItem> CARNOTAURUS_SPAWN_EGG = ITEMS.register("carnotaurus_spawn_egg", () -> FossilsModloaderHelper.INSTANCE.createExperimentalDinosaurSpawnEgg(() -> FossilsExperimentsEntityTypes.CARNOTAURUS.get(), 0xbf5242, 0x371c18, new Item.Properties()));
    public static final SimpleHolder<SpawnEggItem> CRYOLOPHOSAURUS_SPAWN_EGG = ITEMS.register("cryolophosaurus_spawn_egg", () -> FossilsModloaderHelper.INSTANCE.createExperimentalDinosaurSpawnEgg(() -> FossilsExperimentsEntityTypes.CRYOLOPHOSAURUS.get(), 0x547096, 0xec353c, new Item.Properties()));
    public static final SimpleHolder<SpawnEggItem> THERIZINOSAURUS_SPAWN_EGG = ITEMS.register("therizinosaurus_spawn_egg", () -> FossilsModloaderHelper.INSTANCE.createExperimentalDinosaurSpawnEgg(() -> FossilsExperimentsEntityTypes.THERIZINOSAURUS.get(), 0x626c44, 0xcf561e, new Item.Properties()));

    public static void init() {
        FossilsLegacyItems.ITEMS.register("time_machine", () -> new ExperimentalBlockItem(FossilsExperimentsBlocks.TIME_MACHINE.get(), new Item.Properties().fireResistant()));
    }
}
