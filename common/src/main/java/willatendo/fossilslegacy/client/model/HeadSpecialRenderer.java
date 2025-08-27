package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.model.dinosaur.head.HeadModel;
import willatendo.fossilslegacy.client.render.HeadBlockEntityRenderer;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAHeadTypes;
import willatendo.fossilslegacy.server.item.data_components.HeadDisplayInformation;

public class HeadSpecialRenderer implements SpecialModelRenderer<HeadDisplayInformation> {
    private final FAHeadTypes faHeadTypes;
    private final HeadModel headModel;
    private final float animation;

    public HeadSpecialRenderer(FAHeadTypes faHeadTypes, HeadModel headModel, float animation) {
        this.faHeadTypes = faHeadTypes;
        this.headModel = headModel;
        this.animation = animation;
    }

    @Override
    public void render(HeadDisplayInformation headDisplayInformation, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        HeadBlockEntityRenderer.renderHead(null, 180.0F, this.animation, poseStack, multiBufferSource, packedLight, this.headModel, this.faHeadTypes, headDisplayInformation, false);
    }

    @Override
    public HeadDisplayInformation extractArgument(ItemStack itemStack) {
        return itemStack.get(FADataComponents.HEAD_DISPLAY_INFORMATION.get());
    }

    public record Unbaked(FAHeadTypes faHeadTypes, float animation) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<HeadSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(FAHeadTypes.CODEC.fieldOf("head_type").forGetter(HeadSpecialRenderer.Unbaked::faHeadTypes), Codec.FLOAT.optionalFieldOf("animation", 0.0F).forGetter(HeadSpecialRenderer.Unbaked::animation)).apply(instance, HeadSpecialRenderer.Unbaked::new));

        public Unbaked(FAHeadTypes faHeadTypes) {
            this(faHeadTypes, 0.0F);
        }

        @Override
        public MapCodec<HeadSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
            HeadModel headModel = HeadBlockEntityRenderer.createModel(modelSet, this.faHeadTypes);
            return headModel != null ? new HeadSpecialRenderer(this.faHeadTypes, headModel, this.animation) : null;
        }
    }
}
