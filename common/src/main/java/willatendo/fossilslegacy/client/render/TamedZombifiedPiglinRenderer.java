package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.ZombifiedPiglinModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.ZombifiedPiglinRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class TamedZombifiedPiglinRenderer extends HumanoidMobRenderer<Mob, ZombifiedPiglinRenderState, ZombifiedPiglinModel> {
    private static final ResourceLocation TEXTURE = FAUtils.mc("textures/entity/piglin/zombified_piglin.png");

    public TamedZombifiedPiglinRenderer(EntityRendererProvider.Context context, ModelLayerLocation adultModel, ModelLayerLocation babyModel, ModelLayerLocation innerArmorLayer, ModelLayerLocation outerArmorLayer, ModelLayerLocation innerArmorBaby, ModelLayerLocation outerArmorBaby) {
        super(context, new ZombifiedPiglinModel(context.bakeLayer(adultModel)), new ZombifiedPiglinModel(context.bakeLayer(babyModel)), 0.5F, PiglinRenderer.PIGLIN_CUSTOM_HEAD_TRANSFORMS);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidArmorModel(context.bakeLayer(innerArmorLayer)), new HumanoidArmorModel(context.bakeLayer(outerArmorLayer)), new HumanoidArmorModel(context.bakeLayer(innerArmorBaby)), new HumanoidArmorModel(context.bakeLayer(innerArmorBaby)), context.getEquipmentRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(ZombifiedPiglinRenderState zombifiedPiglinRenderState) {
        return TEXTURE;
    }

    @Override
    public ZombifiedPiglinRenderState createRenderState() {
        return new ZombifiedPiglinRenderState();
    }
}
