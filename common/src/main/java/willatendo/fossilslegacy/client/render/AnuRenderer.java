package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.client.render.layer.AnuOverlayLayer;
import willatendo.fossilslegacy.server.entity.entities.Anu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnuRenderer extends MobRenderer<Anu, AnuModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/anu/anu.png");
    public static final ResourceLocation CHARGING = FossilsLegacyUtils.resource("textures/entity/anu/anu_charging.png");

    public AnuRenderer(Context context) {
        super(context, new AnuModel(context.bakeLayer(FAModelLayers.ANU)), 0.3F);
        this.addLayer(new CustomHeadLayer(this, context.getModelSet(), 1.0F, 1.0F, 1.0F, context.getItemInHandRenderer()));
        this.addLayer(new ElytraLayer(this, context.getModelSet()));
        this.addLayer(new ItemInHandLayer(this, context.getItemInHandRenderer()));
        this.addLayer(new AnuOverlayLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Anu anu) {
        return anu.isCharging() ? CHARGING : TEXTURE;
    }
}
