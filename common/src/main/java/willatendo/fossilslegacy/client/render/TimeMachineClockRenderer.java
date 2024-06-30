package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.TimeMachineClockModel;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Calendar;

public class TimeMachineClockRenderer implements BlockEntityRenderer<TimeMachineBlockEntity> {
    public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entity/time_machine_clock.png");
    private final TimeMachineClockModel timeMachineClockModel;

    private int updateTick = 0;
    private final int tickReset = 600;
    private float hour = 0;
    private float minute = 0;
    private Calendar calendar = Calendar.getInstance();

    public TimeMachineClockRenderer(BlockEntityRendererProvider.Context context) {
        this.timeMachineClockModel = new TimeMachineClockModel(context.bakeLayer(FossilsLegacyModelLayers.TIME_MACHINE_CLOCK));
    }

    @Override
    public void render(TimeMachineBlockEntity timeMachineBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        float facing;
        poseStack.pushPose();
        poseStack.translate(0.5F, 2.25F, 0.5F);
        float bob = timeMachineBlockEntity.time + partialTicks;
        poseStack.translate(0.0F, 0.1F + Mth.sin(bob * 0.1F) * 0.01F, 0.0F);
        for (facing = timeMachineBlockEntity.rot - timeMachineBlockEntity.oRot; facing >= (float) Math.PI; facing -= (float) Math.PI * 2) {
        }
        while (facing < (float) (-Math.PI)) {
            facing += (float) Math.PI * 2;
        }
        float facingRot = timeMachineBlockEntity.oRot + facing * partialTicks;
        poseStack.mulPose(Axis.YP.rotation(-facingRot));
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        this.showTime(timeMachineBlockEntity);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE));
        this.timeMachineClockModel.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay);
        poseStack.popPose();
    }

    public void showTime(TimeMachineBlockEntity timeMachineBlockEntity) {
        if (this.updateTick == 0) {
            this.hour = (float) (this.calendar.get(Calendar.HOUR));
            this.minute = (float) (this.calendar.get(Calendar.MINUTE));
            this.updateTick = this.tickReset;
            this.timeMachineClockModel.setTime((float) ((this.hour / 12) * timeMachineBlockEntity.getCircleSize()), (float) ((this.minute / 60) * timeMachineBlockEntity.getCircleSize()));
        } else {
            this.updateTick--;
        }
    }
}
