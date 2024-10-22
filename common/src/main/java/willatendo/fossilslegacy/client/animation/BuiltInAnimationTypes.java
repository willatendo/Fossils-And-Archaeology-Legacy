package willatendo.fossilslegacy.client.animation;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public enum BuiltInAnimationTypes implements BuiltInAnimationType {
    LEGACY_BRACHIOSAURUS_WALK("legacy_brachiosaurus_walk", dinosaur -> true, AnimationUtils::legacyBrachiosaurusWalkAnimation),
    CARNOTAURUS_WALK("carnotaurus_walk", dinosaur -> true, AnimationUtils::carnotaurusWalkAnimation),
    CRYOLOPHOSAURUS_WALK("cryolophosaurus_walk", dinosaur -> true, AnimationUtils::cryolophosaurusWalkAnimation),
    DILOPHOSAURUS_WALK("dilophosaurus_walk", dinosaur -> true, AnimationUtils::dilophosaurusWalkAnimation),
    MOSASAURUS_SWIM("mosasaurus_swim", dinosaur -> true, AnimationUtils::mosasaurusSwimAnimation),
    PTERANODON_FLY("pteranodon_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, AnimationUtils::pteranodonFlyingAnimation),
    PTERANODON_HEAD("pteranodon_head", dinosaur -> true, AnimationUtils::pteranodonHeadAnimation),
    PTERANODON_WALK("pteranodon_walk", dinosaur -> true, AnimationUtils::pteranodonWalkAnimation),
    STEGOSAURUS_WALK("stegosaurus_walk", dinosaur -> true, AnimationUtils::stegosaurusWalkAnimation),
    THERIZINOSAURUS_WALK("therizinosaurus_walk", dinosaur -> true, AnimationUtils::therizinosaurusWalkAnimation),
    LEGACY_TRICERATOPS_WALK("legacy_triceratops_walk", dinosaur -> true, AnimationUtils::legacyTriceratopsWalkAnimation),
    TYRANNOSAURUS_HEAD("tyrannosaurus_head", dinosaur -> true, AnimationUtils::tyrannosaurusHeadAnimation),
    TYRANNOSAURUS_WALK("tyrannosaurus_walk", dinosaur -> true, AnimationUtils::tyrannosaurusWalkAnimation, AnimationUtils::tyrannosaurusWalkModelPrep),
    LEGACY_VELOCIRAPTOR_WALK("legacy_velociraptor_walk", dinosaur -> true, AnimationUtils::legacyVelociraptorWalkAnimation),
    MAMMOTH_WALK("mammoth_walk", dinosaur -> true, AnimationUtils::mammothWalkAnimation),
    SMILODON_SHAKE("smilodon_shake", dinosaur -> true, null, AnimationUtils::smilodonShakeModelPrep),
    SMILODON_SIT("smilodon_sit", dinosaur -> true, null, AnimationUtils::smilodonSitModelPrep),
    SMILODON_TAIL("smilodon_tail", dinosaur -> true, AnimationUtils::smilodonTailAnimation),
    SMILODON_WALK("smilodon_walk", dinosaur -> true, AnimationUtils::smilodonWalkAnimation);

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
