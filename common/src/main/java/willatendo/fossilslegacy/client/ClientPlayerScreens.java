package willatendo.fossilslegacy.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.client.screen.DinopediaScreen;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;

public class ClientPlayerScreens {
    public static void openDinopediaScreen(Player player, LivingEntity livingEntity, DinopediaInformation dinopediaInformation) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setScreen(new DinopediaScreen(player, livingEntity, dinopediaInformation));
    }
}
