package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.AbstractTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.server.entity.Tyrannosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TyrannosaurusRenderer extends MobRenderer<Tyrannosaurus, AbstractTyrannosaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/tyrannosaurus/tyrannosaurus.png");
    public static final ResourceLocation AGRESSIVE_TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/tyrannosaurus/aggressive_tyrannosaurus.png");
    public static final ResourceLocation WEAK_TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/tyrannosaurus/weak_tyrannosaurus.png");

    private final TyrannosaurusModel tyrannosaurusModel;
    private final KnockedOutTyrannosaurusModel knockedOutTyrannosaurusModel;

    public TyrannosaurusRenderer(Context context) {
        super(context, new TyrannosaurusModel(context.bakeLayer(FossilsLegacyModels.TYRANNOSAURUS)), 0.3F);
        this.tyrannosaurusModel = new TyrannosaurusModel(context.bakeLayer(FossilsLegacyModels.TYRANNOSAURUS));
        this.knockedOutTyrannosaurusModel = new KnockedOutTyrannosaurusModel(context.bakeLayer(FossilsLegacyModels.KNOCKED_OUT_TYRANNOSAURUS));
    }

    @Override
    public void render(Tyrannosaurus tyrannosaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
        this.model = tyrannosaurus.isKnockedOut() ? this.knockedOutTyrannosaurusModel : this.tyrannosaurusModel;
        super.render(tyrannosaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(Tyrannosaurus tyrannosaurus) {
        return tyrannosaurus.isKnockedOut() ? WEAK_TEXTURE : (tyrannosaurus.isTame() || tyrannosaurus.isBaby()) ? TEXTURE : AGRESSIVE_TEXTURE;
    }
}
