package willatendo.fossilslegacy.client.animation;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.client.state.IchthyosaurusRenderState;
import willatendo.fossilslegacy.client.state.PteranodonRenderState;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.function.Function;

public enum BuiltInAnimationTypes implements BuiltInAnimationType {
    ICHTHYOSAUR_BODY_SWIM("ichthyosaur_body_swim", dinosaurRenderState -> dinosaurRenderState instanceof IchthyosaurusRenderState, IchthyosaurAnimations::icthyosaurusSwimAnimation),
    PTERANODON_BODY_FLY("pteranodon_body_fly", dinosaurRenderState -> dinosaurRenderState instanceof PteranodonRenderState, PteranodonAnimations::pteranodonFlyingAnimation),

    LEGACY_BRACHIOSAURUS_WALK("legacy_brachiosaurus_walk", dinosaurRenderState -> true, BrachiosaurusAnimations::legacyBrachiosaurusWalkAnimation),
    LEGACY_CARNOTAURUS_WALK("legacy_carnotaurus_walk", dinosaurRenderState -> true, CarnotaurusAnimations::legacyCarnotaurusWalkAnimation),
    LEGACY_CRYOLOPHOSAURUS_WALK("legacy_cryolophosaurus_walk", dinosaurRenderState -> true, CrolophosaurusAnimations::legacyCryolophosaurusWalkAnimation),
    LEGACY_DILOPHOSAURUS_WALK("legacy_dilophosaurus_walk", dinosaurRenderState -> true, DilophosaurusAnimations::legacyDilophosaurusWalkAnimation),
    LEGACY_FUTABASAURUS_SWIM("legacy_futabasaurus_swim", dinosaurRenderState -> true, FutabasaurusAnimations::legacyFutabasaurusSwimAnimation),
    LEGACY_MOSASAURUS_SWIM("legacy_mosasaurus_swim", dinosaurRenderState -> true, MosasaurusAnimations::legacyMosasaurusSwimAnimation),
    LEGACY_PTERANODON_FLY("legacy_pteranodon_fly", dinosaurRenderState -> dinosaurRenderState instanceof PteranodonRenderState, PteranodonAnimations::legacyPteranodonFlyingAnimation),
    LEGACY_PTERANODON_HEAD("legacy_pteranodon_head", dinosaurRenderState -> true, PteranodonAnimations::legacyPteranodonHeadAnimation),
    LEGACY_PTERANODON_WALK("legacy_pteranodon_walk", dinosaurRenderState -> true, PteranodonAnimations::legacyPteranodonWalkAnimation),
    LEGACY_STEGOSAURUS_WALK("legacy_stegosaurus_walk", dinosaurRenderState -> true, StegosaurusAnimations::legacyStegosaurusWalkAnimation),
    LEGACY_THERIZINOSAURUS_WALK("legacy_therizinosaurus_walk", dinosaurRenderState -> true, TherizinosaurusAnimations::legacyTherizinosaurusWalkAnimation),
    LEGACY_TRICERATOPS_WALK("legacy_triceratops_walk", dinosaurRenderState -> true, TriceratopsAnimations::legacyTriceratopsWalkAnimation),
    LEGACY_TYRANNOSAURUS_HEAD("legacy_tyrannosaurus_head", dinosaurRenderState -> true, TyrannosaurusAnimations::legacyTyrannosaurusHeadAnimation),
    LEGACY_TYRANNOSAURUS_WALK("legacy_tyrannosaurus_walk", dinosaurRenderState -> true, TyrannosaurusAnimations::legacyTyrannosaurusWalkAnimation),
    LEGACY_VELOCIRAPTOR_WALK("legacy_velociraptor_walk", dinosaurRenderState -> true, VelociraptorAnimations::legacyVelociraptorWalkAnimation),
    LEGACY_MAMMOTH_WALK("legacy_mammoth_walk", dinosaurRenderState -> true, MammothAnimations::legacyMammothWalkAnimation),
    LEGACY_SMILODON_SHAKE("legacy_smilodon_shake", dinosaurRenderState -> true, SmilodonAnimations::legacySmilodonShakeModelPrep),
    LEGACY_SMILODON_SIT("legacy_smilodon_sit", dinosaurRenderState -> true, SmilodonAnimations::legacySmilodonSitModelPrep),
    LEGACY_SMILODON_TAIL("legacy_smilodon_tail", dinosaurRenderState -> true, SmilodonAnimations::legacySmilodonTailAnimation),
    LEGACY_SMILODON_WALK("legacy_smilodon_walk", dinosaurRenderState -> true, SmilodonAnimations::legacySmilodonWalkAnimation);

    private final ResourceLocation id;
    private final Function<DinosaurRenderState, Boolean> canUse;
    private final AnimationProvider animationProvider;

    BuiltInAnimationTypes(ResourceLocation id, Function<DinosaurRenderState, Boolean> canUse, AnimationProvider animationProvider) {
        this.id = id;
        this.canUse = canUse;
        this.animationProvider = animationProvider;

        BuiltInAnimationType.VALUES.put(id, this);
    }

    BuiltInAnimationTypes(String id, Function<DinosaurRenderState, Boolean> canUse, AnimationProvider animationProvider) {
        this(FAUtils.resource(id), canUse, animationProvider);
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean canUse(DinosaurRenderState dinosaurRenderState) {
        return this.canUse.apply(dinosaurRenderState);
    }

    @Override
    public void setupAnim(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (this.animationProvider != null) {
            this.animationProvider.accept(dinosaurRenderState, jsonTypeModel, limbSwing, limbSwingAmount, netHeadYaw);
        }
    }

    public static void init() {
    }

    private interface AnimationProvider {
        void accept(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw);
    }
}
