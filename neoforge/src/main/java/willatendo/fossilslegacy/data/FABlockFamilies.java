package willatendo.fossilslegacy.data;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.FABlocks;

import java.util.Map;
import java.util.stream.Stream;

public class FABlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    static {
        FABlockFamilies.familyBuilder(FABlocks.ARAUCARIA_PLANKS.get()).button(FABlocks.ARAUCARIA_BUTTON.get()).fence(FABlocks.ARAUCARIA_FENCE.get()).fenceGate(FABlocks.ARAUCARIA_FENCE_GATE.get()).pressurePlate(FABlocks.ARAUCARIA_PRESSURE_PLATE.get()).sign(FABlocks.ARAUCARIA_SIGN.get(), FABlocks.ARAUCARIA_WALL_SIGN.get()).slab(FABlocks.ARAUCARIA_SLAB.get()).stairs(FABlocks.ARAUCARIA_STAIRS.get()).door(FABlocks.ARAUCARIA_DOOR.get()).trapdoor(FABlocks.ARAUCARIA_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.ARAUCARIOXYLON_PLANKS.get()).button(FABlocks.ARAUCARIOXYLON_BUTTON.get()).fence(FABlocks.ARAUCARIOXYLON_FENCE.get()).fenceGate(FABlocks.ARAUCARIOXYLON_FENCE_GATE.get()).pressurePlate(FABlocks.ARAUCARIOXYLON_PRESSURE_PLATE.get()).sign(FABlocks.ARAUCARIOXYLON_SIGN.get(), FABlocks.ARAUCARIOXYLON_WALL_SIGN.get()).slab(FABlocks.ARAUCARIOXYLON_SLAB.get()).stairs(FABlocks.ARAUCARIOXYLON_STAIRS.get()).door(FABlocks.ARAUCARIOXYLON_DOOR.get()).trapdoor(FABlocks.ARAUCARIOXYLON_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.ARCHAEOPTERIS_PLANKS.get()).button(FABlocks.ARCHAEOPTERIS_BUTTON.get()).fence(FABlocks.ARCHAEOPTERIS_FENCE.get()).fenceGate(FABlocks.ARCHAEOPTERIS_FENCE_GATE.get()).pressurePlate(FABlocks.ARCHAEOPTERIS_PRESSURE_PLATE.get()).sign(FABlocks.ARCHAEOPTERIS_SIGN.get(), FABlocks.ARCHAEOPTERIS_WALL_SIGN.get()).slab(FABlocks.ARCHAEOPTERIS_SLAB.get()).stairs(FABlocks.ARCHAEOPTERIS_STAIRS.get()).door(FABlocks.ARCHAEOPTERIS_DOOR.get()).trapdoor(FABlocks.ARCHAEOPTERIS_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.CALAMITES_PLANKS.get()).button(FABlocks.CALAMITES_BUTTON.get()).fence(FABlocks.CALAMITES_FENCE.get()).fenceGate(FABlocks.CALAMITES_FENCE_GATE.get()).pressurePlate(FABlocks.CALAMITES_PRESSURE_PLATE.get()).sign(FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get()).slab(FABlocks.CALAMITES_SLAB.get()).stairs(FABlocks.CALAMITES_STAIRS.get()).door(FABlocks.CALAMITES_DOOR.get()).trapdoor(FABlocks.CALAMITES_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.CORDAITES_PLANKS.get()).button(FABlocks.CORDAITES_BUTTON.get()).fence(FABlocks.CORDAITES_FENCE.get()).fenceGate(FABlocks.CORDAITES_FENCE_GATE.get()).pressurePlate(FABlocks.CORDAITES_PRESSURE_PLATE.get()).sign(FABlocks.CORDAITES_SIGN.get(), FABlocks.CORDAITES_WALL_SIGN.get()).slab(FABlocks.CORDAITES_SLAB.get()).stairs(FABlocks.CORDAITES_STAIRS.get()).door(FABlocks.CORDAITES_DOOR.get()).trapdoor(FABlocks.CORDAITES_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.GINKGO_PLANKS.get()).button(FABlocks.GINKGO_BUTTON.get()).fence(FABlocks.GINKGO_FENCE.get()).fenceGate(FABlocks.GINKGO_FENCE_GATE.get()).pressurePlate(FABlocks.GINKGO_PRESSURE_PLATE.get()).sign(FABlocks.GINKGO_SIGN.get(), FABlocks.GINKGO_WALL_SIGN.get()).slab(FABlocks.GINKGO_SLAB.get()).stairs(FABlocks.GINKGO_STAIRS.get()).door(FABlocks.GINKGO_DOOR.get()).trapdoor(FABlocks.GINKGO_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.LEPIDODENDRON_PLANKS.get()).button(FABlocks.LEPIDODENDRON_BUTTON.get()).fence(FABlocks.LEPIDODENDRON_FENCE.get()).fenceGate(FABlocks.LEPIDODENDRON_FENCE_GATE.get()).pressurePlate(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get()).sign(FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get()).slab(FABlocks.LEPIDODENDRON_SLAB.get()).stairs(FABlocks.LEPIDODENDRON_STAIRS.get()).door(FABlocks.LEPIDODENDRON_DOOR.get()).trapdoor(FABlocks.LEPIDODENDRON_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.SIGILLARIA_PLANKS.get()).button(FABlocks.SIGILLARIA_BUTTON.get()).fence(FABlocks.SIGILLARIA_FENCE.get()).fenceGate(FABlocks.SIGILLARIA_FENCE_GATE.get()).pressurePlate(FABlocks.SIGILLARIA_PRESSURE_PLATE.get()).sign(FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get()).slab(FABlocks.SIGILLARIA_SLAB.get()).stairs(FABlocks.SIGILLARIA_STAIRS.get()).door(FABlocks.SIGILLARIA_DOOR.get()).trapdoor(FABlocks.SIGILLARIA_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        FABlockFamilies.familyBuilder(FABlocks.WOLLEMIA_PLANKS.get()).button(FABlocks.WOLLEMIA_BUTTON.get()).fence(FABlocks.WOLLEMIA_FENCE.get()).fenceGate(FABlocks.WOLLEMIA_FENCE_GATE.get()).pressurePlate(FABlocks.WOLLEMIA_PRESSURE_PLATE.get()).sign(FABlocks.WOLLEMIA_SIGN.get(), FABlocks.WOLLEMIA_WALL_SIGN.get()).slab(FABlocks.WOLLEMIA_SLAB.get()).stairs(FABlocks.WOLLEMIA_STAIRS.get()).door(FABlocks.WOLLEMIA_DOOR.get()).trapdoor(FABlocks.WOLLEMIA_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    }

    private static BlockFamily.Builder familyBuilder(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = MAP.put(baseBlock, builder.getFamily());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
