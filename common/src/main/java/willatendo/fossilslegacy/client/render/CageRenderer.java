package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.server.block.entity.entities.CageBlockEntity;

public class CageRenderer implements BlockEntityRenderer<CageBlockEntity> {
    private final EntityRenderDispatcher entityRenderer;

    public CageRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.getEntityRenderer();
    }

    @Override
    public void render(CageBlockEntity cageBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        if (cageBlockEntity.getCompoundTag() != null) {
            EntityType<?> entityType = BuiltInRegistries.ENTITY_TYPE.getValue(ResourceLocation.parse(cageBlockEntity.getCompoundTag().getString("entity_type")));
            Entity entity = entityType.create(cageBlockEntity.getLevel(), EntitySpawnReason.TRIGGERED);
            entity.load(cageBlockEntity.getCompoundTag());
            poseStack.pushPose();
            poseStack.translate(0.5F, 0.0F, 0.5F);
            EntityRenderer entityRenderer = this.entityRenderer.getRenderer(entity);
            EntityRenderState entityRendererRenderState = entityRenderer.createRenderState();
            entityRenderer.extractRenderState(entity, entityRendererRenderState, partialTicks);
            entityRenderer.render(entityRendererRenderState, poseStack, multiBufferSource, packedLight);
            poseStack.popPose();
        }
    }
}
