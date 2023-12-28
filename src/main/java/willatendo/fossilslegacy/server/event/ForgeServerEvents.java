package willatendo.fossilslegacy.server.event;

//@EventBusSubscriber(bus = Bus.FORGE, modid = FossilsLegacyUtils.ID)
//public class ForgeServerEvents {
//	@SubscribeEvent
//	public static void pigmanCreation(EntityStruckByLightningEvent event) {
//		if (event.getLightning() instanceof AncientLightningBolt ancientLightningBolt) {
//			if (event.getEntity() instanceof Pig pig) {
//				event.setCanceled(true);
//				Level level = ancientLightningBolt.level();
//				ZombifiedPigman zombifiedPigman = FossilsLegacyEntities.ZOMBIFIED_PIGMAN.get().create(level);
//				zombifiedPigman.tame(((Player) ancientLightningBolt.getOwner()));
//				zombifiedPigman.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
//				zombifiedPigman.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
//				zombifiedPigman.moveTo(pig.getX(), pig.getY(), pig.getZ());
//				zombifiedPigman.setHealth(zombifiedPigman.getMaxHealth());
//				level.addFreshEntity(zombifiedPigman);
//				pig.discard();
//			}
//		}
//	}
//}
