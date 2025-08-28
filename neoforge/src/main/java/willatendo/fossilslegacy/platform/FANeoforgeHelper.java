package willatendo.fossilslegacy.platform;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.network.PacketDistributor;
import willatendo.fossilslegacy.FossilsLegacyNeoforgeMod;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.HardenedTarBlock;
import willatendo.fossilslegacy.server.fluid.FAFluidTypes;
import willatendo.fossilslegacy.server.fluid.TarFluid;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.function.Supplier;

public class FANeoforgeHelper implements FAModloaderHelper {
    @Override
    public void sendToServer(CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToServer(customPacketPayload);
    }

    @Override
    public void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToPlayer(serverPlayer, customPacketPayload);
    }

    @Override
    public CreativeModeTab.Builder createCreativeModeTab(String id, List<String> after, List<String> before) {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();
        if (id.equals("fa_all")) {
            builder.withSearchBar();
        }
        return builder.title(FAUtils.translation("itemGroup", id)).withTabsAfter(after.stream().map(FAUtils::resource).toArray(ResourceLocation[]::new)).withTabsBefore(before.stream().map(FAUtils::resource).toArray(ResourceLocation[]::new));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, EntityDataSerializer<T> entityDataSerializer) {
        return FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> entityDataSerializer);
    }

    @Override
    public HardenedTarBlock getHardenedTarBlock(BlockBehaviour.Properties properties) {
        return new HardenedTarBlock(properties) {
            @Override
            public boolean isStickyBlock(BlockState blockState) {
                return blockState.getBlock() == FABlocks.HARDENED_TAR_BLOCK.get();
            }

            @Override
            public boolean canStickTo(BlockState blockState, BlockState otherBlockState) {
                if (blockState.getBlock() == FABlocks.HARDENED_TAR_BLOCK.get() && otherBlockState.getBlock() == Blocks.SLIME_BLOCK) {
                    return false;
                }
                if (blockState.getBlock() == FABlocks.HARDENED_TAR_BLOCK.get() && otherBlockState.getBlock() == Blocks.HONEY_BLOCK) {
                    return false;
                }
                return blockState.isStickyBlock() || otherBlockState.isStickyBlock();
            }
        };
    }

    @Override
    public TarFluid getFlowingTar() {
        return new TarFluid.Flowing() {
            @Override
            public FluidType getFluidType() {
                return FAFluidTypes.TAR_TYPE.get();
            }
        };
    }

    @Override
    public TarFluid getTar() {
        return new TarFluid.Source() {
            @Override
            public FluidType getFluidType() {
                return FAFluidTypes.TAR_TYPE.get();
            }
        };
    }

    @Override
    public GameRules.Key<GameRules.BooleanValue> createBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
        return GameRules.register(name, category, GameRules.BooleanValue.create(defaultValue));
    }

    @Override
    public GameRules.Key<GameRules.IntegerValue> createIntegerGameRule(String name, GameRules.Category category, int defaultValue) {
        return GameRules.register(name, category, GameRules.IntegerValue.create(defaultValue));
    }

    @Override
    public RecipeBookType createRecipeBookType(String name) {
        return RecipeBookType.valueOf(FAUtils.ID + name);
    }
}
