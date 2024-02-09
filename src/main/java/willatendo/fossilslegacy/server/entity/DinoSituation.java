package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum DinoSituation implements Speaker {
	HUNGRY("hungry"),
	STARVE("starve"),
	LEARNED_CHESTS,
	Bytreate,
	NO_SPACE("no_space"),
	STARVE_ESCAPE,
	SJL_BITE,
	FULL("full"),
	TAME_TYRANNOSAURUS_ERROR_TOO_YOUNG("tame_tyrannosaurus_error_too_young"),
	TAME_TYRANNOSAURUS_ERROR_HEALTH("tame_tyrannosaurus_error_health");

	private Function<Player, Component> message;

	private DinoSituation(Function<Player, Component> message) {
		this.message = message;
	}

	private DinoSituation(String id) {
		this(player -> DinoSituation.basicSpeach(id));
	}

	private DinoSituation() {
		this("");
	}

	protected static Component basicSpeach(String id) {
		return FossilsLegacyUtils.translation("dinosaur", "speach." + id);
	}

	@Override
	public Component getMessage(Player player) {
		return this.message.apply(player);
	}
}
