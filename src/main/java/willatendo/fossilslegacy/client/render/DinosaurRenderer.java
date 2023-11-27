package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public abstract class DinosaurRenderer<T extends Mob, E extends EntityModel<T>, M extends E, L extends E> extends MobRenderer<T, E> implements LegacyModels {
	private final M mainModel;
	private final L legacyModel;
	protected boolean hasDeltWithModels = false;

	public DinosaurRenderer(Context context, M model, L legacyModel, float shadowSize) {
		super(context, model, shadowSize);
		this.mainModel = model;
		this.legacyModel = legacyModel;
	}

	@Override
	public void render(T mob, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		if (!this.hasDeltWithModels) {
			this.model = this.useLegacyModels() ? this.legacyModel : this.mainModel;
			this.hasDeltWithModels = true;
		}
		super.render(mob, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(T mob, PoseStack poseStack, float scale) {
		if (this.useLegacyModels()) {
			poseStack.scale(this.legacyScaleFactor(mob), this.legacyScaleFactor(mob), this.legacyScaleFactor(mob));
		}
		super.scale(mob, poseStack, scale);
	}

	public abstract float legacyScaleFactor(T mob);

	public abstract ResourceLocation getTextures(T mob);

	public abstract ResourceLocation getLegacyTextures(T mob);

	@Override
	public ResourceLocation getTextureLocation(T mob) {
		return this.useLegacyModels() ? this.getLegacyTextures(mob) : this.getTextures(mob);
	}
}
