package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.criteria.FACriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.entities.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.level.FALevels;

public class ModCallbacks {
    public static final Event<EntityStruckByLighting> ENTITY_STRUCK_BY_LIGHTING = EventFactory.createArrayBacked(EntityStruckByLighting.class, callbacks -> (entity, lightningBolt) -> {
        for (EntityStruckByLighting callback : callbacks) {
            if (callback.onEntityStruckByLightning(entity, lightningBolt)) {
                return true;
            }
        }
        return false;
    });

    public static void callbacks() {
        ModCallbacks.lightning();
    }

    public static void lightning() {
        ModCallbacks.ENTITY_STRUCK_BY_LIGHTING.register((entity, lightningBolt) -> {
            if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
                if (entity instanceof Pig pig) {
                    Level level = ancientLightningBolt.level();
                    TamedZombifiedPiglin tamedZombifiedPiglin = FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get().create(level, EntitySpawnReason.TRIGGERED);
                    Player player = (Player) ancientLightningBolt.getOwner();
                    tamedZombifiedPiglin.tame(player);
                    if (player instanceof ServerPlayer serverPlayer) {
                        tamedZombifiedPiglin.sendMessageToPlayer(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SUMMON, serverPlayer);
                    }
                    tamedZombifiedPiglin.setItemInHand(InteractionHand.MAIN_HAND, FAItems.ANCIENT_SWORD.get().getDefaultInstance());
                    tamedZombifiedPiglin.setItemSlot(EquipmentSlot.HEAD, FAItems.ANCIENT_HELMET.get().getDefaultInstance());
                    tamedZombifiedPiglin.moveTo(pig.getX(), pig.getY(), pig.getZ());
                    tamedZombifiedPiglin.setHealth(tamedZombifiedPiglin.getMaxHealth());
                    level.addFreshEntity(tamedZombifiedPiglin);
                    if (player instanceof ServerPlayer serverPlayer) {
                        FACriteriaTriggers.TAME_ZOMBIFIED_PIGMAN.get().trigger(serverPlayer, tamedZombifiedPiglin);
                    }
                    pig.discard();
                    return false;
                }
            }
            return true;
        });
    }

    @FunctionalInterface
    public interface EntityStruckByLighting {
        boolean onEntityStruckByLightning(Entity entity, LightningBolt lightningBolt);
    }
}
