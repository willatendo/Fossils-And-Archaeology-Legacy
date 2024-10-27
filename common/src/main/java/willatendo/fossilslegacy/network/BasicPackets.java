package willatendo.fossilslegacy.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.client.toasts.CoatTypeToast;
import willatendo.fossilslegacy.server.block.entity.GeneModificationTableBlockEntity;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public final class BasicPackets {
    public static final ResourceLocation ALERT_UNLOCKED_COAT_TYPES = FossilsLegacyUtils.resource("alert_unlocked_coat_types");

    public static final ResourceLocation APPLY_GENE = FossilsLegacyUtils.resource("apply_gene");
    public static final ResourceLocation SINK = FossilsLegacyUtils.resource("sink");
    public static final ResourceLocation TIME_MACHINE_UPDATE = FossilsLegacyUtils.resource("time_machine_update");

    public static void clientboundAlertUnlockedCoatTypes(List<String> coatTypes, Level level) {
        Registry<CoatType> coatTypeRegistry = level.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES);
        List<Holder<CoatType>> coatTypeHolders = Lists.newArrayList();
        coatTypes.forEach(coatType -> coatTypeHolders.add(coatTypeRegistry.getHolder(ResourceLocation.parse(coatType)).get()));
        ToastComponent toastComponent = Minecraft.getInstance().getToasts();
        CoatTypeToast.addOrUpdate(toastComponent, coatTypeHolders);
    }

    public static void serverboundApplyGenePacket(BlockPos blockPos, String coatType, Level level) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof GeneModificationTableBlockEntity geneModificationTableBlockEntity) {
            ItemStack itemStack = geneModificationTableBlockEntity.getItem(0);
            geneModificationTableBlockEntity.setItem(0, ItemStack.EMPTY);
            Registry<CoatType> coatTypeRegistry = level.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES);
            Holder.Reference<CoatType> coatTypeHolder = coatTypeRegistry.getHolder(ResourceLocation.parse(coatType)).get();
            itemStack.set(FossilsLegacyDataComponents.COAT_TYPE.get(), coatTypeHolder);
            geneModificationTableBlockEntity.setItem(1, itemStack);
        }
    }

    public static void serverboundTimeMachineUpdatePacket(BlockPos blockPos, Level level) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.timeTravel();
        }
    }

    public static void serverboundSinkPacket(ServerPlayer serverPlayer, boolean shouldSink) {
        Entity entity = serverPlayer.getControlledVehicle();
        if (entity != null) {
            if (entity instanceof Futabasaurus futabasaurus) {
                futabasaurus.setShouldSink(shouldSink);
            }
        }
    }
}
