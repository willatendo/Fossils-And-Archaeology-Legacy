package willatendo.fossilslegacy.server.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

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
		lightning();
	}

	public static void lightning() {
		ModCallbacks.ENTITY_STRUCK_BY_LIGHTING.register((entity, lightningBolt) -> {
			if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
				if (entity instanceof Pig pig) {
					Level level = ancientLightningBolt.level();
					TamedZombifiedPiglin zombifiedPigman = FossilsLegacyEntities.TAMED_ZOMBIFIED_PIGLIN.get().create(level);
					zombifiedPigman.tame(((Player) ancientLightningBolt.getOwner()));
					zombifiedPigman.sendMessageToPlayer(TamedZombifiedPiglin.TameZombifiedPiglinSpeaker.SUMMON, ((Player) ancientLightningBolt.getOwner()));
					zombifiedPigman.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
					zombifiedPigman.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
					zombifiedPigman.moveTo(pig.getX(), pig.getY(), pig.getZ());
					zombifiedPigman.setHealth(zombifiedPigman.getMaxHealth());
					level.addFreshEntity(zombifiedPigman);
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
