package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.level.GameRules;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.network.PacketDistributor;
import willatendo.fossilslegacy.FossilsLegacyNeoforgeMod;
import willatendo.fossilslegacy.network.ServerboundApplyGenePacket;
import willatendo.fossilslegacy.network.ServerboundTimeMachineUpdatePacket;
import willatendo.fossilslegacy.server.fluid.FAFluidTypes;
import willatendo.fossilslegacy.server.fluid.TarFluid;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;
import java.util.function.Supplier;

public class FossilsNeoforgeHelper implements FossilsModloaderHelper {
    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String modelType, String skin, Optional<String> pattern) {
        PacketDistributor.sendToServer(new ServerboundApplyGenePacket(blockPos, modelType, skin, pattern));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        PacketDistributor.sendToServer(new ServerboundTimeMachineUpdatePacket(blockPos));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<Holder<T>>> registerDataSerializer(String id, StreamCodec<RegistryFriendlyByteBuf, Holder<T>> streamCodec) {
        return FossilsLegacyNeoforgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> EntityDataSerializer.forValueType(streamCodec));
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
    public RecipeBookType createRecipeBookType(String name) {
        return RecipeBookType.valueOf(FAUtils.ID + name);
    }
}
