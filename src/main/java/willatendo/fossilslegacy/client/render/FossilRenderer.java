package willatendo.fossilslegacy.client.render;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.scores.Team;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.fossils.AbstractSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.BrachiosaurusLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PlesiosaurusLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PteranodonLegacySkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsLegacySkeletonModel;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.Fossils;

public class FossilRenderer extends EntityRenderer<Fossil> implements LegacyModels {
	private AbstractSkeletonModel model;
	private AbstractSkeletonModel[][] models;

	public FossilRenderer(Context context) {
		super(context);
		this.models = new AbstractSkeletonModel[][] { { new BrachiosaurusLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_BRACHIOSAURS_SKELETON)), new PlesiosaurusLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_PLESIOSAURUS_SKELETON)), new PteranodonLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_PTERANODON_SKELETON)), new TriceratopsLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_TRICERATOPS_SKELETON)) }, { new BrachiosaurusLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_BRACHIOSAURS_SKELETON)), new PlesiosaurusLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_PLESIOSAURUS_SKELETON)), new PteranodonLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_PTERANODON_SKELETON)), new TriceratopsLegacySkeletonModel(context.bakeLayer(FossilsLegacyModels.LEGACY_TRICERATOPS_SKELETON)) } };
	}

	@Override
	public void render(Fossil fossil, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.model = this.models[this.useLegacyModels() ? 1 : 0][fossil.getFossil()];

		poseStack.pushPose();

		boolean shouldSit = fossil.isPassenger() && (fossil.getVehicle() != null && fossil.getVehicle().shouldRiderSit());
		this.model.riding = shouldSit;
		this.model.young = false;
		float bodyRot = Mth.rotLerp(packedOverlay, fossil.yBodyRotO, fossil.yBodyRot);
		float headRot = Mth.rotLerp(packedOverlay, fossil.yHeadRotO, fossil.yHeadRot);
		float netHeadYaw = headRot - bodyRot;
		if (shouldSit && fossil.getVehicle() instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) fossil.getVehicle();
			bodyRot = Mth.rotLerp(packedOverlay, livingentity.yBodyRotO, livingentity.yBodyRot);
			netHeadYaw = headRot - bodyRot;
			float wraped = Mth.wrapDegrees(netHeadYaw);
			if (wraped < -85.0F) {
				wraped = -85.0F;
			}

			if (wraped >= 85.0F) {
				wraped = 85.0F;
			}

			bodyRot = headRot - wraped;
			if (wraped * wraped > 2500.0F) {
				bodyRot += wraped * 0.2F;
			}

			netHeadYaw = headRot - bodyRot;
		}

		float headPitch = Mth.lerp(packedOverlay, fossil.xRotO, fossil.getXRot());
		if (isEntityUpsideDown(fossil)) {
			headPitch *= -1.0F;
			netHeadYaw *= -1.0F;
		}

		float ageInTicks = this.getBob(fossil, packedOverlay);
		this.setupRotations(fossil, poseStack, ageInTicks, bodyRot, packedOverlay);
		poseStack.scale(-1.0F, -1.0F, 1.0F);
		this.scale(fossil, poseStack, packedOverlay);
		poseStack.translate(0.0F, -1.501F, 0.0F);
		float limbSwingAmount = 0.0F;
		float limbSwing = 0.0F;
		if (!shouldSit && fossil.isAlive()) {
			if (limbSwingAmount > 1.0F) {
				limbSwingAmount = 1.0F;
			}
		}

		poseStack.mulPose(Axis.YP.rotation(fossil.getYRot()));

		this.model.prepareMobModel(fossil, limbSwing, limbSwingAmount, packedOverlay);
		this.model.setupAnim(fossil, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

		this.scale(fossil, poseStack, packedOverlay);
		Minecraft minecraft = Minecraft.getInstance();
		boolean visible = this.isBodyVisible(fossil);
		boolean notInvisible = !visible && !fossil.isInvisibleTo(minecraft.player);
		boolean glowing = minecraft.shouldEntityAppearGlowing(fossil);
		RenderType renderType = this.getRenderType(fossil, visible, notInvisible, glowing);
		if (renderType != null) {
			VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
			int i = getOverlayCoords(fossil, this.getWhiteOverlayProgress(fossil, packedOverlay));
			this.model.renderToBuffer(poseStack, vertexConsumer, partialTicks, i, 1.0F, 1.0F, 1.0F, notInvisible ? 0.15F : 1.0F);
		}

		poseStack.popPose();
		super.render(fossil, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	public static int getOverlayCoords(Fossil fossil, float u) {
		return OverlayTexture.pack(OverlayTexture.u(u), OverlayTexture.v(fossil.hurtTime > 0 || fossil.deathTime > 0));
	}

	protected void setupRotations(Fossil fossil, PoseStack poseStack, float bob, float p_115320_, float packedOverlay) {
		if (this.isShaking(fossil)) {
			p_115320_ += (float) (Math.cos((double) fossil.tickCount * 3.25D) * Math.PI * (double) 0.4F);
		}

		if (!fossil.hasPose(Pose.SLEEPING)) {
			poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - p_115320_));
		}

		if (isEntityUpsideDown(fossil)) {
			poseStack.translate(0.0F, fossil.getBbHeight() + 0.1F, 0.0F);
			poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
		}
	}

	protected boolean isShaking(Fossil fossil) {
		return fossil.isFullyFrozen();
	}

	protected float getBob(Fossil fossil, float packedOverlay) {
		return (float) fossil.tickCount + packedOverlay;
	}

	@Override
	protected boolean shouldShowName(Fossil fossil) {
		if (fossil.shouldShowName() || fossil.hasCustomName() && fossil == this.entityRenderDispatcher.crosshairPickEntity) {
			double distance = this.entityRenderDispatcher.distanceToSqr(fossil);
			float distanceToSee = fossil.isDiscrete() ? 32.0F : 64.0F;
			if (distance >= (double) (distanceToSee * distanceToSee)) {
				return false;
			} else {
				Minecraft minecraft = Minecraft.getInstance();
				LocalPlayer localPlayer = minecraft.player;
				boolean flag = !fossil.isInvisibleTo(localPlayer);
				Team team = fossil.getTeam();
				Team playerTeam = localPlayer.getTeam();
				if (team != null) {
					Team.Visibility teamVisibility = team.getNameTagVisibility();
					switch (teamVisibility) {
					case ALWAYS:
						return flag;
					case NEVER:
						return false;
					case HIDE_FOR_OTHER_TEAMS:
						return playerTeam == null ? flag : team.isAlliedTo(playerTeam) && (team.canSeeFriendlyInvisibles() || flag);
					case HIDE_FOR_OWN_TEAM:
						return playerTeam == null ? flag : !team.isAlliedTo(playerTeam) && flag;
					default:
						return true;
					}
				}

				return Minecraft.renderNames() && fossil != minecraft.getCameraEntity() && flag && !fossil.isVehicle();
			}
		} else {
			return false;
		}
	}

	public static boolean isEntityUpsideDown(Fossil fossil) {
		if (fossil.hasCustomName()) {
			String name = ChatFormatting.stripFormatting(fossil.getName().getString());
			if ("Dinnerbone".equals(name) || "Grumm".equals(name)) {
				return true;
			}
		}
		return false;
	}

	protected void scale(Fossil fossil, PoseStack poseStack, float packedOverlay) {
		poseStack.scale(1.0F * (1 + fossil.getSize() * 0.25F), 1.0F * (1 + fossil.getSize() * 0.25F), 1.0F * (1 + fossil.getSize() * 0.25F));
	}

	protected boolean isBodyVisible(Fossil fossil) {
		return !fossil.isInvisible();
	}

	protected float getFlipDegrees(Fossil fossil) {
		return 90.0F;
	}

	protected float getWhiteOverlayProgress(Fossil fossil, float packedOverlay) {
		return 0.0F;
	}

	@Nullable
	protected RenderType getRenderType(Fossil fossil, boolean visible, boolean notInvisible, boolean glowing) {
		ResourceLocation resourcelocation = this.getTextureLocation(fossil);
		if (notInvisible) {
			return RenderType.itemEntityTranslucentCull(resourcelocation);
		} else if (visible) {
			return this.model.renderType(resourcelocation);
		} else {
			return glowing ? RenderType.outline(resourcelocation) : null;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Fossil fossil) {
		return Fossils.values()[fossil.getFossil()].getFossilTexture();
	}
}
