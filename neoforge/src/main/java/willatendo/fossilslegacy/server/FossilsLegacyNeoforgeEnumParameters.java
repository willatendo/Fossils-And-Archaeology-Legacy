package willatendo.fossilslegacy.server;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.List;
import java.util.function.Supplier;

public class FossilsLegacyNeoforgeEnumParameters {
    public static Object getAnalyzationSearchParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getAnalyzationMiscParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyItems.VELOCIRAPTOR_DNA.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getArchaeologySearchParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getArchaeologyRestoreParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getArchaeologyRepairParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyItems.GOLDEN_JAVELIN.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getArchaeologyMiscParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyItems.RELIC_SCRAP));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getCultivationSearchParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getCultivationEggParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_EGG.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getCultivationPlantParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getCultivationMiscParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FossilsLegacyItems.TRICERATOPS_DNA.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }
}
