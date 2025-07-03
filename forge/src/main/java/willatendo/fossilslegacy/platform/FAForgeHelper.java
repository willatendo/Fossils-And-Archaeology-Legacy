package willatendo.fossilslegacy.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.fluids.FluidType;
import willatendo.fossilslegacy.FossilsLegacyForgeMod;
import willatendo.fossilslegacy.network.*;
import willatendo.fossilslegacy.network.clientbound.ClientboundFossilScreenPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetFossilPartPositionsPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetFossilPartRotationsPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetDNARecombinatorGenePacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundStartTimeMachinePacket;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fluid.FAFluidTypes;
import willatendo.fossilslegacy.server.fluid.TarFluid;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;
import java.util.function.Supplier;

public class FAForgeHelper implements FAModloaderHelper {
    @Override
    public void sendApplyGenePacket(BlockPos blockPos, String modelType, String skin, Optional<String> pattern) {
        ForgePacketHelper.sendToServer(new ServerboundSetDNARecombinatorGenePacket(blockPos, modelType, skin, pattern));
    }

    @Override
    public void sendSetRotation(int id, String part, float xRot, float yRot, float zRot) {
        ForgePacketHelper.sendToServer(new ServerboundSetFossilPartRotationsPacket(id, part, xRot, yRot, zRot));
    }

    @Override
    public void sendSetPosition(int id, String part, float x, float y, float z) {
        ForgePacketHelper.sendToServer(new ServerboundSetFossilPartPositionsPacket(id, part, x, y, z));
    }

    @Override
    public void sendTimeMachinePacket(BlockPos blockPos) {
        ForgePacketHelper.sendToServer(new ServerboundStartTimeMachinePacket(blockPos));
    }

    @Override
    public void sendFossilMenuPacket(ServerPlayer serverPlayer, int id, FossilRotations fossilRotations, FossilPositions fossilPositions, String fossilVariant) {
        ForgePacketHelper.sendToClient(serverPlayer, new ClientboundFossilScreenPacket(id, fossilRotations, fossilPositions, fossilVariant));
    }

    @Override
    public <T> Supplier<EntityDataSerializer<T>> registerDataSerializer(String id, EntityDataSerializer<T> entityDataSerializer) {
        return FossilsLegacyForgeMod.ENTITY_DATA_SERIALIZER.register(id, () -> entityDataSerializer);
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
        return RecipeBookType.create(FAUtils.ID + name);
    }
}
