package willatendo.fossilslegacy.client.resources;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.TextureAtlasHolder;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class StoneTabletTextureManager extends TextureAtlasHolder {
    public static final StoneTabletTextureManager INSTANCE = new StoneTabletTextureManager(Minecraft.getInstance().getTextureManager());

    public StoneTabletTextureManager(TextureManager textureManager) {
        super(textureManager, FossilsLegacyUtils.resource("textures/atlas/stone_tables.png"), FossilsLegacyUtils.resource("stone_tables"));
    }

    public TextureAtlasSprite get(StoneTabletVariant stoneTabletVariant) {
        return this.getSprite(stoneTabletVariant.assetId());
    }
}
