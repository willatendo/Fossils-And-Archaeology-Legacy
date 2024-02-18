package willatendo.fossilslegacy.server.entity;

import java.util.function.Function;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum DinoSituation implements SpeakerType {
	HUNGRY("hungry"),
	STARVE("starve"),
	LEARNED_CHESTS("learned_chests"),
	TAME_WITH_TREAT("tame_with_treat"),
	NO_SPACE("no_space"),
	ESCAPE("escape"),
	SJL_BITE("sjl_bite"),
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

	protected static Component basicSpeach(String id) {
		return FossilsLegacyUtils.translation("dinosaur", "speach." + id);
	}

	@Override
	public Component getMessage(Player player) {
		return this.message.apply(player);
	}
}
