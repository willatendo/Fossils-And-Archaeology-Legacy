package willatendo.fossilslegacy.server.entity.variants;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public record StoneTabletVariant(String name, int width, int height) {
	public ResourceLocation getTexture() {
		return FossilsLegacyUtils.resource("textures/entity/stone_tablet/" + this.name + ".png");
	}

	public MutableComponent getName() {
		return FossilsLegacyUtils.translation("stone_tablet", this.name + ".title");
	}

	public MutableComponent getAuthor() {
		return FossilsLegacyUtils.translation("stone_tablet", this.name + ".author");
	}
}
