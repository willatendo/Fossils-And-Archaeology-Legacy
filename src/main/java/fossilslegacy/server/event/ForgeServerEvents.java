package fossilslegacy.server.event;

import fossilslegacy.server.entity.AncientLightningBolt;
import fossilslegacy.server.entity.FossilsLegacyEntities;
import fossilslegacy.server.entity.ZombifiedPigman;
import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

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
				level.addFreshEntity(zombifiedPigman);
				pig.discard();
			}
		}
	}
}
