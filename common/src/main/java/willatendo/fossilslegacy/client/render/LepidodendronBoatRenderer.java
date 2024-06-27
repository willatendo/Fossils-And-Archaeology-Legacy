package willatendo.fossilslegacy.client.render;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import org.joml.Quaternionf;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.util.BoatTypeAccessor;
import willatendo.fossilslegacy.server.entity.variants.BoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;

public class LepidodendronBoatRenderer extends EntityRenderer<Boat> {
    private final Map<BoatType, Pair<ResourceLocation, ListModel<Boat>>> modBoatResources;

    public LepidodendronBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context);
        this.shadowRadius = 0.8F;
        this.modBoatResources = FossilsLegacyBuiltInRegistries.BOAT_TYPES.stream().collect(ImmutableMap.toImmutableMap(boatType -> boatType, boatType -> Pair.of(LepidodendronBoatRenderer.getTextureLocation(boatType, chestBoat), this.createBoatModel(context, boatType, chestBoat))));
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, BoatType boatType, boolean chestBoat) {
        ModelLayerLocation modelLayerLocation = chestBoat ? FossilsLegacyModels.createChestBoatModelName(boatType) : FossilsLegacyModels.createBoatModelName(boatType);
        ModelPart modelPart = context.bakeLayer(modelLayerLocation);
        if (boatType.raft()) {
            return chestBoat ? new ChestRaftModel(modelPart) : new RaftModel(modelPart);
        } else {
            return chestBoat ? new ChestBoatModel(modelPart) : new BoatModel(modelPart);
        }
    }

    private static ResourceLocation getTextureLocation(BoatType boatType, boolean chestBoat) {
        return chestBoat ? FossilsLegacyUtils.resource("textures/entity/chest_boat/" + boatType.name() + ".png") : FossilsLegacyUtils.resource("textures/entity/boat/" + boatType.name() + ".png");
    }

    @Override
    public void render(Boat boat, float packedOverlay, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.375F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - packedOverlay));
        float hurtAnimation = (float) boat.getHurtTime() - partialTicks;
        float damageAnimation = boat.getDamage() - partialTicks;
        if (damageAnimation < 0.0F) {
            damageAnimation = 0.0F;
        }

        if (hurtAnimation > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(hurtAnimation) * hurtAnimation * damageAnimation / 10.0F * (float) boat.getHurtDir()));
        }

        float bubbleAnimation = boat.getBubbleAngle(partialTicks);
        if (!Mth.equal(bubbleAnimation, 0.0F)) {
            poseStack.mulPose(new Quaternionf().setAngleAxis(boat.getBubbleAngle(partialTicks) * 0.017453292F, 1.0F, 0.0F, 1.0F));
        }

        Pair<ResourceLocation, ListModel<Boat>> pair = this.modBoatResources.get(((BoatTypeAccessor) boat).getBoatType().value());
        ResourceLocation texture = pair.getFirst();
        ListModel<Boat> boatModel = pair.getSecond();
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
        boatModel.setupAnim(boat, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer boatVertexConsumer = multiBufferSource.getBuffer(boatModel.renderType(texture));
        boatModel.renderToBuffer(poseStack, boatVertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        if (!boat.isUnderWater()) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.waterMask());
            if (boatModel instanceof WaterPatchModel) {
                WaterPatchModel $$14 = (WaterPatchModel) boatModel;
                $$14.waterPatch().render(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            }
        }

        poseStack.popPose();
        super.render(boat, packedOverlay, partialTicks, poseStack, multiBufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Boat boat) {
        return this.modBoatResources.get(((BoatTypeAccessor) boat).getBoatType().value()).getFirst();
    }
}
