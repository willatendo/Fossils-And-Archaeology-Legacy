package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.animal.Animal;
import willatendo.fossilslegacy.server.entity.GrowingEntity;

public abstract class GrowingDinosaurRenderer<T extends Animal & GrowingEntity, E extends EntityModel<T>, M extends E, A extends E, L extends E> extends DinosaurRenderer<T, E, M, L> {
	private final M babyModel;
	private final A mainModel;
	private final L legacyModel;

	public GrowingDinosaurRenderer(Context context, M babyModel, A mainModel, L legacyModel, float shadowSize) {
		super(context, babyModel, legacyModel, shadowSize);
		this.babyModel = babyModel;
		this.mainModel = mainModel;
		this.legacyModel = legacyModel;
	}

	@Override
	public void render(T mob, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		if (!this.hasDeltWithModels) {
			if (!this.useLegacyModels()) {
				this.model = mob.isBaby() ? this.babyModel : this.mainModel;
			} else {
				this.model = legacyModel;
			}
			this.hasDeltWithModels = true;
		}
		this.shadowRadius = this.shadowScale(mob, this.useLegacyModels()) * (float) mob.getGrowthStage();
		super.render(mob, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(T mob, PoseStack poseStack, float scale) {
		float newScale = this.growScale(mob, this.useLegacyModels());

		poseStack.scale(1.0F * (1 + newScale), 1.0F * (1 + newScale), 1.0F * (1 + newScale));
	}

	public abstract float growScale(T mob, boolean isLegacyModel);

	public abstract float shadowScale(T mob, boolean isLegacyModel);
}
