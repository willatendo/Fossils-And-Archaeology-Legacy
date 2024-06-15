package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.FutabasaurusModel;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FutabasaurusRenderer extends DinosaurRenderer<Futabasaurus, FutabasaurusModel> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/futabasaurus/futabasaurus.png");

    public FutabasaurusRenderer(Context context) {
        super(context, new FutabasaurusModel(context.bakeLayer(FossilsLegacyModels.FUTABASAURUS)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Futabasaurus futabasaurus) {
        return TEXTURE;
    }
}
