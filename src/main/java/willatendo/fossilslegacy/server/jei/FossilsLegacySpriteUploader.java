package willatendo.fossilslegacy.server.jei;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacySpriteUploader extends TextureAtlasHolder {
	public FossilsLegacySpriteUploader(TextureManager textureManager) {
		super(textureManager, FossilsLegacyJEI.FOSSILS_LEGACY_TEXTURE_ATLAS, new ResourceLocation(FossilsLegacyUtils.ID, "fossils_legacy_jei"));
	}

	@Override
	public TextureAtlasSprite getSprite(ResourceLocation resourceLocation) {
		return super.getSprite(resourceLocation);
	}
}
