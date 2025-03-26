package willatendo.fossilslegacy.server.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.MissingMappingsEvent;
import willatendo.fossilslegacy.server.criteria.FLCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.entities.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.event.modification.ForgeIdModification;
import willatendo.simplelibrary.server.event.modification.ForgeStructurePoolModification;
import willatendo.simplelibrary.server.event.modification.ForgeVillagerTradeModification;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FAUtils.ID)
public class ForgeServerEvents {
    @SubscribeEvent
    public static void entityStruckByLightningEvent(EntityStruckByLightningEvent event) {
        if (event.getLightning() instanceof AncientLightningBolt ancientLightningBolt) {
            if (event.getEntity() instanceof Pig pig) {
                event.setCanceled(true);
                Level level = ancientLightningBolt.level();
                TamedZombifiedPiglin tamedZombifiedPiglin = FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get().create(level, EntitySpawnReason.EVENT);
                Player player = (Player) ancientLightningBolt.getOwner();
                tamedZombifiedPiglin.tame(player);
                tamedZombifiedPiglin.setItemInHand(InteractionHand.MAIN_HAND, FAItems.ANCIENT_SWORD.get().getDefaultInstance());
                tamedZombifiedPiglin.setItemSlot(EquipmentSlot.HEAD, FAItems.ANCIENT_HELMET.get().getDefaultInstance());
                tamedZombifiedPiglin.moveTo(pig.getX(), pig.getY(), pig.getZ());
                tamedZombifiedPiglin.setHealth(tamedZombifiedPiglin.getMaxHealth());
                level.addFreshEntity(tamedZombifiedPiglin);
                if (player instanceof ServerPlayer serverPlayer) {
                    FLCriteriaTriggers.TAME_ZOMBIFIED_PIGMAN.get().trigger(serverPlayer, tamedZombifiedPiglin);
                }
                pig.discard();
            }
        }
    }

    @SubscribeEvent
    public static void villagerTradesEvent(VillagerTradesEvent event) {
        BasicEvents.villagerTradesEvent(new ForgeVillagerTradeModification(event));
    }

    @SubscribeEvent
    public static void serverAboutToStartEvent(ServerAboutToStartEvent event) {
        BasicEvents.structurePoolModification(new ForgeStructurePoolModification(event));
    }

    @SubscribeEvent
    public static void event(MissingMappingsEvent event) {
        BasicEvents.idModification(new ForgeIdModification(FAUtils.ID, event));
    }
}
