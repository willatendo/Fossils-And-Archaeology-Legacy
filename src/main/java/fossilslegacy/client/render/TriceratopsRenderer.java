package fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import fossilslegacy.client.FossilsLegacyModels;
import fossilslegacy.client.model.triceratops.AbstractTriceratopsModel;
import fossilslegacy.client.model.triceratops.BabyTriceratopsModel;
import fossilslegacy.client.model.triceratops.TriceratopsModel;
import fossilslegacy.server.entity.Triceratops;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TriceratopsRenderer extends MobRenderer<Triceratops, AbstractTriceratopsModel> {
	private final BabyTriceratopsModel babyTriceratopsModel;
	private final TriceratopsModel triceratopsModel;

	public TriceratopsRenderer(Context context, BabyTriceratopsModel babyTriceratopsModel) {
		super(context, babyTriceratopsModel, 0.15F);
		this.babyTriceratopsModel = babyTriceratopsModel;
		this.triceratopsModel = new TriceratopsModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS_ADULT));
	}

	@Override
	public void render(Triceratops triceratops, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.model = triceratops.isBaby() ? this.babyTriceratopsModel : this.triceratopsModel;
		this.shadowRadius = 0.15F * (float) triceratops.getGrowthStage();
		super.render(triceratops, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Triceratops triceratops, PoseStack poseStack, float scale) {
		float newScale = (triceratops.getGrowthStage() - (triceratops.isBaby() ? 0 : 2)) * (0.25F);

		poseStack.scale(1.0F * (1 + newScale), 1.0F * (1 + newScale), 1.0F * (1 + newScale));
	}

	@Override
	public ResourceLocation getTextureLocation(Triceratops triceratops) {
		return triceratops.textures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
	}
}
