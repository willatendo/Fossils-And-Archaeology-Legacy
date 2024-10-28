package willatendo.fossilslegacy.client.animation;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public enum BuiltInAnimationTypes implements BuiltInAnimationType {
    PTERANODON_BODY_FLY("pteranodon_body_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, PteranodonAnimations::pteranodonFlyingAnimation),

    LEGACY_BRACHIOSAURUS_WALK("legacy_brachiosaurus_walk", dinosaur -> true, BrachiosaurusAnimations::legacyBrachiosaurusWalkAnimation),
    LEGACY_CARNOTAURUS_WALK("legacy_carnotaurus_walk", dinosaur -> true, CarnotaurusAnimations::legacyCarnotaurusWalkAnimation),
    LEGACY_CRYOLOPHOSAURUS_WALK("legacy_cryolophosaurus_walk", dinosaur -> true, CrolophosaurusAnimations::legacyCryolophosaurusWalkAnimation),
    LEGACY_DILOPHOSAURUS_WALK("legacy_dilophosaurus_walk", dinosaur -> true, DilophosaurusAnimations::legacyDilophosaurusWalkAnimation),
    LEGACY_MOSASAURUS_SWIM("legacy_mosasaurus_swim", dinosaur -> true, MosasaurusAnimations::legacyMosasaurusSwimAnimation),
    LEGACY_PTERANODON_FLY("legacy_pteranodon_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, PteranodonAnimations::legacyPteranodonFlyingAnimation),
    LEGACY_PTERANODON_HEAD("legacy_pteranodon_head", dinosaur -> true, PteranodonAnimations::legacyPteranodonHeadAnimation),
    LEGACY_PTERANODON_WALK("legacy_pteranodon_walk", dinosaur -> true, PteranodonAnimations::legacyPteranodonWalkAnimation),
    LEGACY_STEGOSAURUS_WALK("legacy_stegosaurus_walk", dinosaur -> true, StegosaurusAnimations::legacyStegosaurusWalkAnimation),
    LEGACY_THERIZINOSAURUS_WALK("legacy_therizinosaurus_walk", dinosaur -> true, TherizinosaurusAnimations::legacyTherizinosaurusWalkAnimation),
    LEGACY_TRICERATOPS_WALK("legacy_triceratops_walk", dinosaur -> true, TriceratopsAnimations::legacyTriceratopsWalkAnimation),
    LEGACY_TYRANNOSAURUS_HEAD("legacy_tyrannosaurus_head", dinosaur -> true, TyrannosaursAnimations::legacyTyrannosaurusHeadAnimation),
    LEGACY_TYRANNOSAURUS_WALK("legacy_tyrannosaurus_walk", dinosaur -> true, TyrannosaursAnimations::legacyTyrannosaurusWalkAnimation, TyrannosaursAnimations::legacyTyrannosaurusWalkModelPrep),
    LEGACY_VELOCIRAPTOR_WALK("legacy_velociraptor_walk", dinosaur -> true, VelociraptorAnimations::legacyVelociraptorWalkAnimation),
    LEGACY_MAMMOTH_WALK("legacy_mammoth_walk", dinosaur -> true, MammothAnimations::legacyMammothWalkAnimation),
    LEGACY_SMILODON_SHAKE("legacy_smilodon_shake", dinosaur -> true, null, SmilodonAnimations::legacySmilodonShakeModelPrep),
    LEGACY_SMILODON_SIT("legacy_smilodon_sit", dinosaur -> true, null, SmilodonAnimations::legacySmilodonSitModelPrep),
    LEGACY_SMILODON_TAIL("legacy_smilodon_tail", dinosaur -> true, SmilodonAnimations::legacySmilodonTailAnimation),
    LEGACY_SMILODON_WALK("legacy_smilodon_walk", dinosaur -> true, SmilodonAnimations::legacySmilodonWalkAnimation);

    private final ResourceLocation id;
    private final Function<Dinosaur, Boolean> canUse;
    private final AnimationProvider animationProvider;
    private final ModelPrepProvider modelPrepProvider;

    BuiltInAnimationTypes(ResourceLocation id, Function<Dinosaur, Boolean> canUse, AnimationProvider animationProvider, ModelPrepProvider modelPrepProvider) {
        this.id = id;
        this.canUse = canUse;
        this.animationProvider = animationProvider;
        this.modelPrepProvider = modelPrepProvider;

        BuiltInAnimationType.VALUES.put(id, this);
    }

    BuiltInAnimationTypes(String id, Function<Dinosaur, Boolean> canUse, AnimationProvider animationProvider) {
        this(FossilsLegacyUtils.resource(id), canUse, animationProvider, null);
    }

    BuiltInAnimationTypes(String id, Function<Dinosaur, Boolean> canUse, AnimationProvider animationProivder, ModelPrepProvider modelPrepProvider) {
        this(FossilsLegacyUtils.resource(id), canUse, animationProivder, modelPrepProvider);
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean canUse(Dinosaur dinosaur) {
        return this.canUse.apply(dinosaur);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (this.animationProvider != null) {
            this.animationProvider.accept(dinosaur, jsonModel, limbSwing, limbSwingAmount, netHeadYaw);
        }
    }

    @Override
    public void prepareMobModel(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (this.modelPrepProvider != null) {
            this.modelPrepProvider.accept(dinosaur, jsonModel, limbSwing, limbSwingAmount, partialTick);
        }
    }

    public static void init() {
    }

    private interface AnimationProvider {
        void accept(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw);
    }

    private interface ModelPrepProvider {
        void accept(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw);
    }
}
