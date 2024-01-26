package willatendo.fossilslegacy.server.event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.event.EntityStruckByLightningCallback;
import willatendo.simplelibrary.server.event.StruckByLightningCallback;

public class ModCallbacks {
	public static void callbacks() {
		lightning();
	}

	public static void lightning() {
		StruckByLightningCallback.EVENT.register((entity, lightningBolt) -> {
			if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
				if (entity instanceof Pig pig) {
					return false;
				}
				return true;
			}
			return true;
		});

		EntityStruckByLightningCallback.EVENT.register((entity, lightningBolt) -> {
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
				}
			}
		});
	}
}
