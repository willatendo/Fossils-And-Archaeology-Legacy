package willatendo.fossilslegacy.server;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;

import java.util.List;
import java.util.function.Supplier;

public class FANeoforgeEnumParameters {
    public static Object getAnalyzationSearchParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getAnalyzationMiscParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FAItems.VELOCIRAPTOR_DNA.get()));
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
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FAItems.ANCIENT_SHOVEL_ARTIFACT.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getArchaeologyRepairParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FAItems.GOLDEN_JAVELIN.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getArchaeologyMiscParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FAItems.RELIC_SCRAP));
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
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FAItems.TYRANNOSAURUS_EGG.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getCultivationPlantParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FABlocks.LEPIDODENDRON_SAPLING.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }

    public static Object getCultivationMiscParameters(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 ->
                    (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(FAItems.TRICERATOPS_DNA.get()));
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }
}
