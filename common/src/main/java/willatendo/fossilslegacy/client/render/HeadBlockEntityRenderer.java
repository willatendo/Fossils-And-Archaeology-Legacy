package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import willatendo.fossilslegacy.client.FAModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.head.*;
import willatendo.fossilslegacy.server.block.blocks.AbstractHeadBlock;
import willatendo.fossilslegacy.server.block.blocks.WallHeadBlock;
import willatendo.fossilslegacy.server.block.entity.entities.HeadBlockEntity;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.item.FAHeadTypes;
import willatendo.fossilslegacy.server.item.data_components.HeadDisplayInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class HeadBlockEntityRenderer implements BlockEntityRenderer<HeadBlockEntity> {
    private static final Map<FAHeadTypes, ResourceLocation> TEXTURE_BY_HEAD = Util.make(() -> {
        Map<FAHeadTypes, ResourceLocation> map = new HashMap<>();
        map.put(FAHeadTypes.ANKYLOSAURUS, FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus.png"));
        map.put(FAHeadTypes.BARYONYX, FAUtils.resource("textures/entity/baryonyx/baryonyx.png"));
        map.put(FAHeadTypes.BRACHIOSAURUS, FAUtils.resource("textures/entity/brachiosaurus/brachiosaurus.png"));
        map.put(FAHeadTypes.CARNOTAURUS, FAUtils.resource("textures/entity/carnotaurus/red_carnotaurus_adult.png"));
        map.put(FAHeadTypes.COMPSOGNATHUS, FAUtils.resource("textures/entity/compsognathus/compsognathus.png"));
        map.put(FAHeadTypes.CRYOLOPHOSAURUS, FAUtils.resource("textures/entity/cryolophosaurus/cryolophosaurus.png"));
        map.put(FAHeadTypes.DILOPHOSAURUS, FAUtils.resource("textures/entity/dilophosaurus/dilophosaurus.png"));
        map.put(FAHeadTypes.DIMETRODON, FAUtils.resource("textures/entity/dimetrodon/dimetrodon_adult.png"));
        map.put(FAHeadTypes.DISTORTUS_REX, FAUtils.resource("textures/entity/distortus_rex/distortus_rex.png"));
        map.put(FAHeadTypes.DODO, FAUtils.resource("textures/entity/dodo/dodo.png"));
        map.put(FAHeadTypes.DRYOSAURUS, FAUtils.resource("textures/entity/dryosaurus/dryosaurus.png"));
        map.put(FAHeadTypes.ELASMOTHERIUM, FAUtils.resource("textures/entity/elasmotherium/elasmotherium.png"));
        map.put(FAHeadTypes.FUTABASAURUS, FAUtils.resource("textures/entity/futabasaurus/futabasaurus.png"));
        map.put(FAHeadTypes.GALLIMIMUS, FAUtils.resource("textures/entity/gallimimus/gallimimus_adult.png"));
        map.put(FAHeadTypes.ICHTHYOSAURUS, FAUtils.resource("textures/entity/ichthyosaurus/ichthyosaurus.png"));
        map.put(FAHeadTypes.MAMMOTH, FAUtils.resource("textures/entity/mammoth/mammoth_adult_fur.png"));
        map.put(FAHeadTypes.MOA, FAUtils.resource("textures/entity/moa/moa.png"));
        map.put(FAHeadTypes.MOSASAURUS, FAUtils.resource("textures/entity/mosasaurus/mosasaurus.png"));
        map.put(FAHeadTypes.PACHYCEPHALOSAURUS, FAUtils.resource("textures/entity/pachycephalosaurus/pachycephalosaurus_adult.png"));
        map.put(FAHeadTypes.PTERANODON, FAUtils.resource("textures/entity/pteranodon/pteranodon_adult.png"));
        map.put(FAHeadTypes.SMILODON, FAUtils.resource("textures/entity/smilodon/smilodon_adult.png"));
        map.put(FAHeadTypes.SPINOSAURUS, FAUtils.resource("textures/entity/spinosaurus/spinosaurus_adult.png"));
        map.put(FAHeadTypes.STEGOSAURUS, FAUtils.resource("textures/entity/stegosaurus/stegosaurus_adult.png"));
        map.put(FAHeadTypes.THERIZINOSAURUS, FAUtils.resource("textures/entity/therizinosaurus/therizinosaurus_adult.png"));
        map.put(FAHeadTypes.TRICERATOPS, FAUtils.resource("textures/entity/triceratops/green_triceratops_adult.png"));
        map.put(FAHeadTypes.TYRANNOSAURUS, FAUtils.resource("textures/entity/tyrannosaurus/tyrannosaurus_adult.png"));
        map.put(FAHeadTypes.VELOCIRAPTOR, FAUtils.resource("textures/entity/velociraptor/green_velociraptor_adult.png"));
        return map;
    });

    private final Function<FAHeadTypes, HeadModel> modelByHead;

    public static HeadModel createModel(EntityModelSet modelSet, FAHeadTypes faHeadTypes) {
        HeadModel headModel;
        switch (faHeadTypes) {
            case ANKYLOSAURUS ->
                    headModel = new AnkylosaursHeadModel(modelSet.bakeLayer(FAModelLayers.ANKYLOSAURUS_HEAD));
            case BARYONYX -> headModel = new BaryonyxHeadModel(modelSet.bakeLayer(FAModelLayers.BARYONYX_HEAD));
            case BRACHIOSAURUS ->
                    headModel = new BrachiosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.BRACHIOSAURUS_HEAD));
            case CARNOTAURUS ->
                    headModel = new CarnotaurusHeadModel(modelSet.bakeLayer(FAModelLayers.CARNOTAURUS_HEAD));
            case COMPSOGNATHUS ->
                    headModel = new CompsognathusHeadModel(modelSet.bakeLayer(FAModelLayers.COMPSOGNATHUS_HEAD));
            case CRYOLOPHOSAURUS ->
                    headModel = new CryolophosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.CRYOLOPHOSAURUS_HEAD));
            case DILOPHOSAURUS ->
                    headModel = new DilophosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.DILOPHOSAURUS_HEAD));
            case DIMETRODON -> headModel = new DimetrodonHeadModel(modelSet.bakeLayer(FAModelLayers.DIMETRODON_HEAD));
            case DISTORTUS_REX ->
                    headModel = new DistortusRexHeadModel(modelSet.bakeLayer(FAModelLayers.DISTORTUS_REX_HEAD));
            case DODO -> headModel = new DodoHeadModel(modelSet.bakeLayer(FAModelLayers.DODO_HEAD));
            case DRYOSAURUS -> headModel = new DryosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.DRYOSAURUS_HEAD));
            case ELASMOTHERIUM ->
                    headModel = new ElasmotheriumHeadModel(modelSet.bakeLayer(FAModelLayers.ELASMOTHERIUM_HEAD));
            case FUTABASAURUS ->
                    headModel = new FutabasaurusHeadModel(modelSet.bakeLayer(FAModelLayers.FUTABASAURUS_HEAD));
            case GALLIMIMUS -> headModel = new GallimimusHeadModel(modelSet.bakeLayer(FAModelLayers.GALLIMIMUS_HEAD));
            case ICHTHYOSAURUS ->
                    headModel = new IchthyosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.ICHTHYOSAURUS_HEAD));
            case MAMMOTH -> headModel = new MammothHeadModel(modelSet.bakeLayer(FAModelLayers.MAMMOTH_HEAD));
            case MOA -> headModel = new MoaHeadModel(modelSet.bakeLayer(FAModelLayers.MOA_HEAD));
            case MOSASAURUS -> headModel = new MosasaurusHeadModel(modelSet.bakeLayer(FAModelLayers.MOSASAURUS_HEAD));
            case PACHYCEPHALOSAURUS ->
                    headModel = new PachycephalosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.PACHYCEPHALOSAURUS_HEAD));
            case PTERANODON -> headModel = new PteranodonHeadModel(modelSet.bakeLayer(FAModelLayers.PTERANODON_HEAD));
            case SMILODON -> headModel = new SmilodonHeadModel(modelSet.bakeLayer(FAModelLayers.SMILODON_HEAD));
            case SPINOSAURUS ->
                    headModel = new SpinosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.SPINOSAURUS_HEAD));
            case STEGOSAURUS ->
                    headModel = new StegosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.STEGOSAURUS_HEAD));
            case THERIZINOSAURUS ->
                    headModel = new TherizinosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.THERIZINOSAURUS_HEAD));
            case TRICERATOPS ->
                    headModel = new TriceratopsHeadModel(modelSet.bakeLayer(FAModelLayers.TRICERATOPS_HEAD));
            case TYRANNOSAURUS ->
                    headModel = new TyrannosaurusHeadModel(modelSet.bakeLayer(FAModelLayers.TYRANNOSAURUS_HEAD));
            case VELOCIRAPTOR ->
                    headModel = new VelociraptorHeadModel(modelSet.bakeLayer(FAModelLayers.VELOCIRAPTOR_HEAD));
            default -> throw new MatchException(null, null);
        }
        return headModel;
    }

    public HeadBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.modelByHead = Util.memoize(faHeadTypes -> HeadBlockEntityRenderer.createModel(context.getModelSet(), faHeadTypes));
    }

    @Override
    public void render(HeadBlockEntity headBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BlockState blockState = headBlockEntity.getBlockState();
        boolean flag = blockState.getBlock() instanceof WallHeadBlock;
        Direction direction = flag ? blockState.getValue(WallHeadBlock.FACING) : null;
        int rotation = flag ? RotationSegment.convertToSegment(direction.getOpposite()) : blockState.getValue(SkullBlock.ROTATION);
        FAHeadTypes faHeadTypes = ((AbstractHeadBlock) blockState.getBlock()).getType();
        RenderType renderType = HeadBlockEntityRenderer.getRenderType(faHeadTypes);
        HeadBlockEntityRenderer.renderHead(direction, RotationSegment.convertToDegrees(rotation), 0, poseStack, multiBufferSource, packedLight, this.modelByHead.apply(faHeadTypes), renderType, headBlockEntity.headDisplayInformation, true);
    }

    public static void renderHead(Direction direction, float yRot, float mouthAnimation, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, HeadModel headModel, RenderType renderType, HeadDisplayInformation headDisplayInformation, boolean scale) {
        poseStack.pushPose();
        if (direction == null) {
            poseStack.translate(0.5F, 0.0F, 0.5F);
        } else {
            poseStack.translate(0.5F - (float) direction.getStepX() * 0.25F, 0.25F, 0.5F - (float) direction.getStepZ() * 0.25F);
        }

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (headDisplayInformation != null) {
            PatternGene skin = headDisplayInformation.cosmeticGeneHolder().skinGene(clientLevel.registryAccess()).value();
            PatternGene patternGene = headDisplayInformation.cosmeticGeneHolder().patternGene(clientLevel.registryAccess()).value();
            Registry<Texture> textureRegistry = clientLevel.registryAccess().lookupOrThrow(FARegistries.TEXTURE);
            if (scale) {

            }
            headModel.setupAnim(mouthAnimation, yRot, 0.0F);
            headModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(skin.getTexture(textureRegistry, FATextures.BASE, "ankylosaurus", List.of(FATextures.BASE)))), packedLight, OverlayTexture.NO_OVERLAY);
            if (skin.hasEyeTexture(textureRegistry, "ankylosaurus", List.of(FATextures.BASE))) {
                headModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(skin.getEyeTexture(textureRegistry, "ankylosaurus", List.of(FATextures.BASE)))), packedLight, OverlayTexture.NO_OVERLAY);
            }
        }
        poseStack.popPose();
    }

    public static RenderType getRenderType(FAHeadTypes faHeadTypes) {
        return HeadBlockEntityRenderer.getRenderType(faHeadTypes, null);
    }

    public static RenderType getRenderType(FAHeadTypes faHeadTypes, ResourceLocation textureOverride) {
        return RenderType.entityCutoutNoCullZOffset(textureOverride != null ? textureOverride : HeadBlockEntityRenderer.TEXTURE_BY_HEAD.get(faHeadTypes));
    }
}
