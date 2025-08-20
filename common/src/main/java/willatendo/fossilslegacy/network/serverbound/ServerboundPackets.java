package willatendo.fossilslegacy.network.serverbound;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.block.entity.entities.DNARecombinatorBlockEntity;
import willatendo.fossilslegacy.server.block.entity.entities.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.gene.InheritedGene;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.criteria.FACriteriaTriggers;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;
import java.util.Optional;

public final class ServerboundPackets {
    public static void serverboundDamageHammerPacket(ServerboundDamageHammerPacket serverboundDamageHammerPacket, Player player) {
        int id = serverboundDamageHammerPacket.id();
        Level level = player.level();
        Entity entity = level.getEntity(id);
        if (entity instanceof Player thePlayer) {
            thePlayer.getMainHandItem().hurtAndBreak(1, thePlayer, EquipmentSlot.MAINHAND);
        }
    }

    public static void serverboundSetDNARecombinatorGenePacket(ServerboundSetDNARecombinatorGenePacket serverboundSetDNARecombinatorGenePacket, Player player) {
        Level level = player.level();
        BlockPos blockPos = serverboundSetDNARecombinatorGenePacket.blockPos();
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof DNARecombinatorBlockEntity DNARecombinatorBlockEntity) {
            Optional<String> modelType = serverboundSetDNARecombinatorGenePacket.modelType();
            Optional<String> skin = serverboundSetDNARecombinatorGenePacket.skin();
            Optional<String> pattern = serverboundSetDNARecombinatorGenePacket.pattern();
            ItemStack itemStack = DNARecombinatorBlockEntity.getItem(0);
            DNARecombinatorBlockEntity.setItem(0, ItemStack.EMPTY);
            if (modelType.isPresent() && skin.isPresent()) {
                Registry<ModelGene> modelTypeRegistry = level.registryAccess().lookupOrThrow(FARegistries.MODEL_GENE);
                Holder<ModelGene> modelGeneKey = modelTypeRegistry.get(ResourceLocation.parse(modelType.get())).get();
                ResourceKey<SkinGene> skinKey = ResourceKey.create(FARegistries.SKIN_GENE, ResourceLocation.parse(skin.get()));
                Optional<ResourceKey<PatternGene>> patternKey = pattern.map(patternId -> ResourceKey.create(FARegistries.PATTERN_GENE, ResourceLocation.parse(patternId)));
                itemStack.set(FADataComponents.MODEL_TYPE.get(), modelGeneKey);
                itemStack.set(FADataComponents.COSMETIC_GENE_HOLDER.get(), new CosmeticGeneHolder(InheritedGene.createModelGene(modelGeneKey.getRegisteredName()), skinKey, patternKey));
            } else {
                itemStack.remove(FADataComponents.MODEL_TYPE.get());
                itemStack.remove(FADataComponents.COSMETIC_GENE_HOLDER.get());
            }

            AttributeGeneHolder attributeGeneHolder = new AttributeGeneHolder();
            List<Optional<String>> attributeGenes = serverboundSetDNARecombinatorGenePacket.attributeGenes();
            for (int i = 0; i < attributeGenes.size(); i++) {
                Optional<String> gene = attributeGenes.get(i);
                if (gene.isPresent()) {
                    attributeGeneHolder.set(i, FABuiltInRegistries.GENE.get(ResourceLocation.parse(gene.get())).orElseThrow());
                }
            }
            if (!attributeGeneHolder.isEmpty()) {
                itemStack.set(FADataComponents.GENE_HOLDER.get(), attributeGeneHolder);
            } else if (itemStack.has(FADataComponents.GENE_HOLDER.get())) {
                itemStack.remove(FADataComponents.GENE_HOLDER.get());
            }

            DNARecombinatorBlockEntity.setItem(1, itemStack);
            if (player instanceof ServerPlayer serverPlayer) {
                FACriteriaTriggers.APPLY_GENE.get().trigger(serverPlayer);
            }
        }
    }

    public static void serverboundSetFossilPartPositionsPacket(ServerboundSetFossilPartPositionsPacket serverboundSetFossilPartPositionsPacket, Player player) {
        Level level = player.level();
        int id = serverboundSetFossilPartPositionsPacket.id();
        String part = serverboundSetFossilPartPositionsPacket.part();
        float x = serverboundSetFossilPartPositionsPacket.x();
        float y = serverboundSetFossilPartPositionsPacket.y();
        float z = serverboundSetFossilPartPositionsPacket.z();
        Entity entity = level.getEntity(id);
        if (entity instanceof Fossil fossil) {
            fossil.getFossilPositions().setPosition(part, x, y, z);
        }
    }

    public static void serverboundSetRotationsPacket(ServerboundSetFossilPartRotationsPacket serverboundSetFossilPartRotationsPacket, Player player) {
        Level level = player.level();
        int id = serverboundSetFossilPartRotationsPacket.id();
        String part = serverboundSetFossilPartRotationsPacket.part();
        float xRot = serverboundSetFossilPartRotationsPacket.xRot();
        float yRot = serverboundSetFossilPartRotationsPacket.yRot();
        float zRot = serverboundSetFossilPartRotationsPacket.zRot();
        Entity entity = level.getEntity(id);
        if (entity instanceof Fossil fossil) {
            fossil.getFossilRotations().setRotation(part, xRot, yRot, zRot);
        }
    }

    public static void serverboundStartTimeMachinePacket(ServerboundStartTimeMachinePacket serverboundStartTimeMachinePacket, Player player) {
        Level level = player.level();
        BlockPos blockPos = serverboundStartTimeMachinePacket.blockPos();
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.timeTravel(blockPos);
        }
    }

    public static void serverboundSinkPacket(ServerboundVehicleSinkPacket serverboundVehicleSinkPacket, Player player) {
        boolean shouldSink = serverboundVehicleSinkPacket.shouldSink();
        Entity entity = player.getControlledVehicle();
        if (entity != null) {
            if (entity instanceof Futabasaurus futabasaurus) {
                futabasaurus.setShouldSink(shouldSink);
            }
        }
    }
}
