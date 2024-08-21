package willatendo.fossilslegacy.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.network.ServerboundSinkPacket;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.inventory.FossilsLegacyRecipeBookTypes;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import willatendo.simplelibrary.client.event.FabricKeyMappingRegister;
import willatendo.simplelibrary.client.event.FabricMenuScreenRegister;
import willatendo.simplelibrary.client.event.FabricModelLayerRegister;
import willatendo.simplelibrary.client.event.FabricModelRegister;
import willatendo.simplelibrary.server.util.RecipeBookRegistry;

import java.util.List;

public class FossilsLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.JURASSIC_FERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FossilsLegacyBlocks.POTTED_LEPIDODENDRON_SAPLING.get(), RenderType.cutout());

        ColorProviderRegistry.ITEM.register((itemStack, tintIndex) -> {
            BlockState blockState = ((BlockItem) itemStack.getItem()).getBlock().defaultBlockState();
            BlockColors blockColors = Minecraft.getInstance().getBlockColors();
            return blockColors.getColor(blockState, null, null, tintIndex);
        }, FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get());
        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> {
            return blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor();
        }, FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get());

        FossilsLegacyClient.signSheets();

        FossilsLegacyClient.keyMappingEvent(new FabricKeyMappingRegister());

        FossilsLegacyClient.modelLayerEvent(new FabricModelLayerRegister());

        FossilsLegacyClient.modelEvent(new FabricModelRegister());

        FossilsLegacyClient.menuScreenEvent(new FabricMenuScreenRegister());

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            Player player = minecraft.player;
            if (player != null) {
                if (player.isPassenger()) {
                    if (player.getVehicle() instanceof Futabasaurus) {
                        if (FossilsLegacyKeys.SINK.isDown()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(true));
                        }
                        if (!FossilsLegacyKeys.SINK.consumeClick()) {
                            ClientPlayNetworking.send(new ServerboundSinkPacket(false));
                        }
                    }
                }
            }
        });

        RecipeBookRegistry.registerBookCategories(FossilsLegacyRecipeBookTypes.ANALYZER, List.of(FossilsLegacyRecipeBookCategories.ANALYZATION_SEARCH, FossilsLegacyRecipeBookCategories.ANALYZATION_MISC));
        RecipeBookRegistry.registerBookCategories(FossilsLegacyRecipeBookTypes.ARCHAEOLOGY_WORKBENCH, List.of(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        RecipeBookRegistry.registerBookCategories(FossilsLegacyRecipeBookTypes.CULTIVATOR, List.of(FossilsLegacyRecipeBookCategories.CULTIVATION_SEARCH, FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS, FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS, FossilsLegacyRecipeBookCategories.CULTIVATION_MISC));

        RecipeBookRegistry.registerAggregateCategory(FossilsLegacyRecipeBookCategories.ANALYZATION_SEARCH, List.of(FossilsLegacyRecipeBookCategories.ANALYZATION_MISC));
        RecipeBookRegistry.registerAggregateCategory(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_SEARCH, List.of(FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR, FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC));
        RecipeBookRegistry.registerAggregateCategory(FossilsLegacyRecipeBookCategories.CULTIVATION_SEARCH, List.of(FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS, FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS, FossilsLegacyRecipeBookCategories.CULTIVATION_MISC));

        RecipeBookRegistry.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ANALYZATION.get(), recipeHolder -> {
            AnalyzationRecipe analyzationRecipe = (AnalyzationRecipe) recipeHolder.value();
            switch (analyzationRecipe.analyzationBookCategory) {
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.ANALYZATION_MISC;
            }
        });
        RecipeBookRegistry.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get(), recipeHolder -> {
            ArchaeologyRecipe archaeologyRecipe = (ArchaeologyRecipe) recipeHolder.value();
            switch (archaeologyRecipe.archaeologyBookCategory) {
                case RESTORE:
                    return FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE;
                case REPAIR:
                    return FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR;
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC;
            }
        });
        RecipeBookRegistry.registerRecipeCategoryFinder(FossilsLegacyRecipeTypes.CULTIVATION.get(), recipeHolder -> {
            CultivationRecipe cultivationRecipe = (CultivationRecipe) recipeHolder.value();
            switch (cultivationRecipe.cultivationBookCategory) {
                case EGG:
                    return FossilsLegacyRecipeBookCategories.CULTIVATION_EGGS;
                case PLANT:
                    return FossilsLegacyRecipeBookCategories.CULTIVATION_PLANTS;
                default:
                case MISC:
                    return FossilsLegacyRecipeBookCategories.CULTIVATION_MISC;
            }
        });

        ImmutableMap.Builder<RecipeBookType, Pair<String, String>> tagFields = ImmutableMap.<RecipeBookType, Pair<String, String>>builder().putAll(RecipeBookSettings.TAG_FIELDS);
        tagFields.put(FossilsLegacyRecipeBookTypes.ARCHAEOLOGY_WORKBENCH, Pair.of("isArchaeologyWorkbenchGuiOpen", "isArchaeologyWorkbenchFilteringCraftable"));
        tagFields.put(FossilsLegacyRecipeBookTypes.CULTIVATOR, Pair.of("isCultivatorGuiOpen", "isCultivatorFilteringCraftable"));
        tagFields.put(FossilsLegacyRecipeBookTypes.ANALYZER, Pair.of("isAnalyzerGuiOpen", "isAnalyzerFilteringCraftable"));
        RecipeBookSettings.TAG_FIELDS = tagFields.build();
    }
}
