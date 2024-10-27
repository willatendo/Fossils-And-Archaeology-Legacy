package willatendo.fossilslegacy.client.animation;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public enum BuiltInAnimationTypes implements BuiltInAnimationType {
    LEGACY_BRACHIOSAURUS_WALK("legacy_brachiosaurus_walk", dinosaur -> true, BrachiosaurusAnimations::legacyBrachiosaurusWalkAnimation),
    LEGACY_CARNOTAURUS_WALK("legacy_carnotaurus_walk", dinosaur -> true, CarnotaurusAnimations::carnotaurusWalkAnimation),
    LEGACY_CRYOLOPHOSAURUS_WALK("legacy_cryolophosaurus_walk", dinosaur -> true, CrolophosaurusAnimations::legacyCryolophosaurusWalkAnimation),
    DILOPHOSAURUS_WALK("dilophosaurus_walk", dinosaur -> true, AnimationUtils::dilophosaurusWalkAnimation),
    MOSASAURUS_SWIM("mosasaurus_swim", dinosaur -> true, AnimationUtils::mosasaurusSwimAnimation),
    PTERANODON_BODY_FLY("pteranodon_body_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, PteranodonAnimations::pteranodonFlyingAnimation),
    LEGACY_PTERANODON_FLY("legacy_pteranodon_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, PteranodonAnimations::legacyPteranodonFlyingAnimation),
    LEGACY_PTERANODON_HEAD("legacy_pteranodon_head", dinosaur -> true, PteranodonAnimations::legacyPteranodonHeadAnimation),
    LEGACY_PTERANODON_WALK("legacy_pteranodon_walk", dinosaur -> true, PteranodonAnimations::legacyPteranodonWalkAnimation),
    STEGOSAURUS_WALK("stegosaurus_walk", dinosaur -> true, AnimationUtils::stegosaurusWalkAnimation),
    THERIZINOSAURUS_WALK("therizinosaurus_walk", dinosaur -> true, AnimationUtils::therizinosaurusWalkAnimation),
    LEGACY_TRICERATOPS_WALK("legacy_triceratops_walk", dinosaur -> true, TriceratopsAnimations::legacyTriceratopsWalkAnimation),
    TYRANNOSAURUS_HEAD("tyrannosaurus_head", dinosaur -> true, AnimationUtils::tyrannosaurusHeadAnimation),
    TYRANNOSAURUS_WALK("tyrannosaurus_walk", dinosaur -> true, AnimationUtils::tyrannosaurusWalkAnimation, AnimationUtils::tyrannosaurusWalkModelPrep),
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
