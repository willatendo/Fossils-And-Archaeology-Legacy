package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.JavelinModel;

public class JavelinSpecialRenderer implements NoDataSpecialModelRenderer {
    private final JavelinModel javelinModel;
    private final ResourceLocation texture;

    public JavelinSpecialRenderer(JavelinModel javelinModel, ResourceLocation texture) {
        this.javelinModel = javelinModel;
        this.texture = texture;
    }

    @Override
    public void render(ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(multiBufferSource, this.javelinModel.renderType(this.texture), false, hasFoilType);
        this.javelinModel.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay);
        poseStack.popPose();
    }

    public record Unbaked(ResourceLocation texture) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<JavelinSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter(JavelinSpecialRenderer.Unbaked::texture)).apply(instance, JavelinSpecialRenderer.Unbaked::new));

        @Override
        public MapCodec<JavelinSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet entityModelSet) {
            return new JavelinSpecialRenderer(new JavelinModel(entityModelSet.bakeLayer(FAModelLayers.HELD_JAVELIN)), this.texture);
        }
    }
}
