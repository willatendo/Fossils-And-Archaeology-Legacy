package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.block.entity.entities.GeneModificationTableBlockEntity;
import willatendo.fossilslegacy.server.block.entity.entities.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class BasicPackets {
    public static final ResourceLocation APPLY_GENE = FAUtils.resource("apply_gene");
    public static final ResourceLocation SINK = FAUtils.resource("sink");
    public static final ResourceLocation TIME_MACHINE_UPDATE = FAUtils.resource("time_machine_update");

    public static void serverboundApplyGenePacket(BlockPos blockPos, String modelType, String pattern, Level level) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof GeneModificationTableBlockEntity geneModificationTableBlockEntity) {
            ItemStack itemStack = geneModificationTableBlockEntity.getItem(0);
            geneModificationTableBlockEntity.setItem(0, ItemStack.EMPTY);
            Registry<ModelType> modelTypeRegistry = level.registryAccess().lookupOrThrow(FARegistries.MODEL_TYPES);
            Registry<Pattern> patternRegistry = level.registryAccess().lookupOrThrow(FARegistries.PATTERN);
            Holder.Reference<ModelType> modelTypeHolder = modelTypeRegistry.get(ResourceLocation.parse(modelType)).get();
            Holder.Reference<Pattern> patternHolder = patternRegistry.get(ResourceLocation.parse(pattern)).get();
            itemStack.set(FADataComponents.MODEL_TYPE.get(), modelTypeHolder);
            itemStack.set(FADataComponents.PATTERN.get(), patternHolder);
            geneModificationTableBlockEntity.setItem(1, itemStack);
        }
    }

    public static void serverboundTimeMachineUpdatePacket(BlockPos blockPos, Level level) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.timeTravel(blockPos);
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
