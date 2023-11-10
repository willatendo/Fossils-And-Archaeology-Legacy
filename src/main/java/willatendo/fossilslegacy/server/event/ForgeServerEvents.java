package willatendo.fossilslegacy.server.event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.fossilslegacy.server.entity.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.entity.ZombifiedPigman;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@EventBusSubscriber(bus = Bus.FORGE, modid = FossilsLegacyUtils.ID)
public class ForgeServerEvents {
	@SubscribeEvent
	public static void pigmanCreation(EntityStruckByLightningEvent event) {
		if (event.getLightning() instanceof AncientLightningBolt ancientLightningBolt) {
			if (event.getEntity() instanceof Pig pig) {
				event.setCanceled(true);
				Level level = ancientLightningBolt.level();
				ZombifiedPigman zombifiedPigman = FossilsLegacyEntities.ZOMBIFIED_PIGMAN.get().create(level);
				zombifiedPigman.tame(((Player) ancientLightningBolt.getOwner()));
				zombifiedPigman.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
				zombifiedPigman.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
				zombifiedPigman.moveTo(pig.getX(), pig.getY(), pig.getZ());
				zombifiedPigman.setHealth(zombifiedPigman.getMaxHealth());
				level.addFreshEntity(zombifiedPigman);
				pig.discard();
			}
		}
	}
}
