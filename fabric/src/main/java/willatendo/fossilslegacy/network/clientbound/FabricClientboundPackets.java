package willatendo.fossilslegacy.network.clientbound;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeMap;
import willatendo.fossilslegacy.client.FossilsLegacyClient;

public final class FabricClientboundPackets {
    public static void clientboundOpenDinopediaScreenPacket(ClientboundRecipeContentPacket clientboundRecipeContentPacket, Player player) {
        FossilsLegacyClient.addRecipes(RecipeMap.create(clientboundRecipeContentPacket.recipes()));
    }
}
