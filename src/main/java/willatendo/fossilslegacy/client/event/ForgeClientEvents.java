package willatendo.fossilslegacy.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.ComputeCameraAngles;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@EventBusSubscriber(bus = Bus.FORGE, modid = FossilsLegacyUtils.ID, value = Dist.CLIENT)
public class ForgeClientEvents {
	@SubscribeEvent
	public static void cameraSetup(ComputeCameraAngles event) {
//		Player player = Minecraft.getInstance().player;
//		if (!Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
//			if (player.isPassenger()) {
//				if (player.getVehicle() instanceof Mammoth mammoth) {
//					event.setPitch(360.0F);
//				}
//			}
//		}
	}
}
