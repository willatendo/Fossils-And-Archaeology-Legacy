package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.AbstractTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.Tyrannosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TyrannosaurusRenderer extends MobRenderer<Dinosaur, AbstractTyrannosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus.png");
    public static final ResourceLocation AGRESSIVE_TEXTURE = FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/aggressive_tyrannosaurus.png");
    public static final ResourceLocation WEAK_TEXTURE = FossilsLegacyUtils.resource("textures/entity/tyrannosaurus/weak_tyrannosaurus.png");

    private final TyrannosaurusModel tyrannosaurusModel;
    private final KnockedOutTyrannosaurusModel knockedOutTyrannosaurusModel;

    public TyrannosaurusRenderer(Context context) {
        super(context, new TyrannosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.TYRANNOSAURUS)), 0.3F);
        this.tyrannosaurusModel = new TyrannosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.TYRANNOSAURUS));
        this.knockedOutTyrannosaurusModel = new KnockedOutTyrannosaurusModel(context.bakeLayer(FossilsLegacyModelLayers.TYRANNOSAURUS_KNOCKED_OUT));
    }

    @Override
    public void render(Dinosaur dinosaur, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.model = ((Tyrannosaurus) dinosaur).isKnockedOut() ? this.knockedOutTyrannosaurusModel : this.tyrannosaurusModel;
        super.render(dinosaur, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(Dinosaur dinosaur) {
        return ((Tyrannosaurus) dinosaur).isKnockedOut() ? WEAK_TEXTURE : (dinosaur.isTame() || dinosaur.isBaby()) ? TEXTURE : AGRESSIVE_TEXTURE;
    }
}
