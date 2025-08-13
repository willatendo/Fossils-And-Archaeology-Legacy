package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SkullSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import willatendo.fossilslegacy.client.model.dinosaur.head.HeadModel;
import willatendo.fossilslegacy.client.render.HeadBlockEntityRenderer;
import willatendo.fossilslegacy.server.item.FAHeadTypes;

import java.util.Optional;

public class HeadSpecialRenderer implements NoDataSpecialModelRenderer {
    private final FAHeadTypes faHeadTypes;
    private final HeadModel headModel;
    private final ResourceLocation textureOverride;
    private final float animation;

    public HeadSpecialRenderer(FAHeadTypes faHeadTypes, HeadModel headModel, ResourceLocation textureOverride, float animation) {
        this.faHeadTypes = faHeadTypes;
        this.headModel = headModel;
        this.textureOverride = textureOverride;
        this.animation = animation;
    }

    @Override
    public void render(ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        RenderType rendertype = HeadBlockEntityRenderer.getRenderType(this.faHeadTypes, this.textureOverride);
        HeadBlockEntityRenderer.renderSkull(null, 180.0F, this.animation, poseStack, multiBufferSource, packedLight, this.headModel, rendertype);
    }

    public record Unbaked(FAHeadTypes faHeadTypes, Optional<ResourceLocation> textureOverride, float animation) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<HeadSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(FAHeadTypes.CODEC.fieldOf("head_type").forGetter(HeadSpecialRenderer.Unbaked::faHeadTypes), ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(HeadSpecialRenderer.Unbaked::textureOverride), Codec.FLOAT.optionalFieldOf("animation", 0.0F).forGetter(HeadSpecialRenderer.Unbaked::animation)).apply(instance, HeadSpecialRenderer.Unbaked::new));

        public Unbaked(FAHeadTypes faHeadTypes) {
            this(faHeadTypes, Optional.empty(), 0.0F);
        }

        @Override
        public MapCodec<HeadSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
            HeadModel headModel = HeadBlockEntityRenderer.createModel(modelSet, this.faHeadTypes);
            ResourceLocation resourcelocation = this.textureOverride.map(resouceLocation -> resouceLocation.withPath(path -> "textures/entity/" + path + ".png")).orElse(null);
            return headModel != null ? new HeadSpecialRenderer(this.faHeadTypes, headModel, resourcelocation, this.animation) : null;
        }
    }
}
