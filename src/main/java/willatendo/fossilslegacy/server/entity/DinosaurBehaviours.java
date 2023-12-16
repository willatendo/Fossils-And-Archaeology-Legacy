package willatendo.fossilslegacy.server.entity;

import java.util.Optional;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.behaviours.PlayerCommandableInfo;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class DinosaurBehaviours {
	private Optional<PlayerCommandableInfo> playerCommandableInfo = Optional.empty();
	private Optional<PlayerCommandableAccess> playerCommandableAccess = Optional.empty();

	public void enableCommanding(PlayerCommandableInfo playerCommandableInfo, PlayerCommandableAccess playerCommandableAccess) {
		this.playerCommandableInfo = Optional.of(playerCommandableInfo);
		this.playerCommandableAccess = Optional.of(playerCommandableAccess);
	}

	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (!this.playerCommandableInfo.isEmpty() && !this.playerCommandableAccess.isEmpty()) {
			PlayerCommandableInfo playerCommandableInfo = this.playerCommandableInfo.get();
			if (playerCommandableInfo.isCommandItem(itemStack)) {
				PlayerCommandableAccess playerCommandableAccess = this.playerCommandableAccess.get();
				playerCommandableAccess.setCommand(DinosaurCommand.getNext(playerCommandableAccess.getCommand()));
				player.displayClientMessage(FossilsLegacyUtils.translation("order", "order.use", playerCommandableAccess.getCommand().getComponent().getString()), true);
				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.PASS;
	}
}
