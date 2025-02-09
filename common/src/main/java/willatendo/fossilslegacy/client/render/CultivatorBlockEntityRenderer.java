package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.AnimalFetusModel;
import willatendo.fossilslegacy.client.model.PlantEmbryoModel;
import willatendo.fossilslegacy.server.block.blocks.CultivatorBlock;
import willatendo.fossilslegacy.server.block.entity.entities.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class CultivatorBlockEntityRenderer implements BlockEntityRenderer<CultivatorBlockEntity> {
    private static final ResourceLocation ANIMAL_FETUS_TEXTURE = FAUtils.resource("textures/entity/animal_fetus.png");
    private static final ResourceLocation PLANT_EMBRYO_TEXTURE = FAUtils.resource("textures/entity/plant_embryo.png");
    private final AnimalFetusModel animalFetusModel;
    private final PlantEmbryoModel plantEmbryoModel;

    public CultivatorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.animalFetusModel = new AnimalFetusModel(context.bakeLayer(FAModelLayers.ANIMAL_FETUS));
        this.plantEmbryoModel = new PlantEmbryoModel(context.bakeLayer(FAModelLayers.PLANT_EMBRYO));
    }

    @Override
    public void render(CultivatorBlockEntity cultivatorBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        ItemStack itemStack0 = cultivatorBlockEntity.getItem(0);
        if (!itemStack0.isEmpty() && itemStack0.getItem() instanceof DNAItem dnaItem) {
            if (cultivatorBlockEntity.getBlockState().getValue(CultivatorBlock.ACTIVE)) {
                poseStack.pushPose();
                poseStack.scale(1.0F, -1.0F, -1.0F);
                poseStack.translate(0.5F, -1.35F, -0.5F);
                poseStack.scale(0.75F, 0.75F, 0.75F);
                float tick = (float) cultivatorBlockEntity.time + partialTicks;
                poseStack.translate(0.0F, 0.1F + Mth.sin(tick * 0.1F) * 0.01F, 0.0F);

                float rot;
                for (rot = cultivatorBlockEntity.rot - cultivatorBlockEntity.oRot; rot >= 3.1415927F; rot -= 6.2831855F) {
                }

                while (rot < -3.1415927F) {
                    rot += 6.2831855F;
                }

                poseStack.mulPose(Axis.YP.rotation(-(cultivatorBlockEntity.oRot + rot * partialTicks)));
                switch (dnaItem.getEmbryoType()) {
                    case ANIMAL ->
                            this.animalFetusModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(ANIMAL_FETUS_TEXTURE)), packedLight, packedOverlay);
                    case PLANT ->
                            this.plantEmbryoModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(PLANT_EMBRYO_TEXTURE)), packedLight, packedOverlay);
                }
                poseStack.popPose();
            }
        }
    }
}
