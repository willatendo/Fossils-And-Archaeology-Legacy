package willatendo.fossilslegacy.client.resources;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class DecorationPlaqueTextureManager extends TextureAtlasHolder {
    public static final DecorationPlaqueTextureManager INSTANCE = new DecorationPlaqueTextureManager(Minecraft.getInstance().getTextureManager());

    public DecorationPlaqueTextureManager(TextureManager textureManager) {
        super(textureManager, FAUtils.resource("textures/atlas/decoration_plaques.png"), FAUtils.resource("decoration_plaques"));
    }

    public TextureAtlasSprite get(DecorationPlaqueType decorationPlaqueType) {
        return this.getSprite(decorationPlaqueType.assetId());
    }

    public TextureAtlasSprite get(ResourceLocation asset) {
        return this.getSprite(asset);
    }
}
