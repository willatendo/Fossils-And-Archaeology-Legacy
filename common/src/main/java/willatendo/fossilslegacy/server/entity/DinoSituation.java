package willatendo.fossilslegacy.server.entity;

import com.google.common.base.Function;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public enum DinoSituation implements SpeakerType<Dinosaur> {
	HUNGRY("hungry"),
	STARVE("starve"),
	LEARNED_CHESTS("learned_chests"),
	TAME_WITH_TREAT("tame_with_treat"),
	NO_SPACE("no_space"),
	STARVE_ESCAPE("starve_escape"),
	HURT_ESCAPE("hurt_escape"),
	FULL("full"),
	TAME_TYRANNOSAURUS_ERROR_TOO_YOUNG("tame_tyrannosaurus_error_too_young"),
	TAME_TYRANNOSAURUS_ERROR_HEALTH("tame_tyrannosaurus_error_health");

	private final Function<Dinosaur, Component> message;
	private final String translationKey;

	private DinoSituation(Function<Dinosaur, Component> message, String translationKey) {
		this.message = message;
		this.translationKey = translationKey;
	}

	private DinoSituation(String id) {
		this(DinoSituation.basicSpeach(id), "dinosaur.fossilslegacy.speach." + id);
	}

	protected static Function<Dinosaur, Component> basicSpeach(String id) {
		return dinosaur -> FossilsLegacyUtils.translation("dinosaur", "speach." + id, dinosaur.getDisplayName());
	}

	public String getTranslationKey() {
		return this.translationKey;
	}

	@Override
	public Component getMessage(Player player, Dinosaur dinosaur) {
		return this.message.apply(dinosaur);
	}
}
