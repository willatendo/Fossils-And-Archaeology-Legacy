package willatendo.fossilslegacy.server.event;

public class ModCallbacks {
	public static void callbacks() {
		lightning();
	}

	public static void lightning() {
//		EntityEvents.STRUCK_BY_LIGHTING.register((entity, lightningBolt) -> {
//			if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
//				if (entity instanceof Pig pig) {
//					return false;
//				}
//				return true;
//			}
//			return true;
//		});

//		EntityEvents.STRUCK_BY_LIGHTING.register((entity, lightningBolt) -> {
//			if (lightningBolt instanceof AncientLightningBolt ancientLightningBolt) {
//				if (entity instanceof Pig pig) {
//					Level level = ancientLightningBolt.level();
//					TamedZombifiedPiglin zombifiedPigman = FossilsLegacyEntities.TAMED_ZOMBIFIED_PIGLIN.get().create(level);
//					zombifiedPigman.tame(((Player) ancientLightningBolt.getOwner()));
//					zombifiedPigman.sendMessageToPlayer(TamedZombifiedPiglin.TameZombifiedPiglinSpeaker.SUMMON, ((Player) ancientLightningBolt.getOwner()));
//					zombifiedPigman.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
//					zombifiedPigman.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
//					zombifiedPigman.moveTo(pig.getX(), pig.getY(), pig.getZ());
//					zombifiedPigman.setHealth(zombifiedPigman.getMaxHealth());
//					level.addFreshEntity(zombifiedPigman);
//					pig.discard();
//					return false;
//				}
//			}
//			return true;
//		});
	}
}
