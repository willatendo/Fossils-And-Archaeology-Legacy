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
    PTERANODON_HEAD("pteranodon_head", dinosaur -> true, AnimationUtils::pteranodonHeadAnimation),
    PTERANODON_WALK("pteranodon_walk", dinosaur -> true, AnimationUtils::pteranodonWalkAnimation),
    PTERANODON_FLY("pteranodon_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, AnimationUtils::pteranodonFlyingAnimation),
    STEGOSAURUS_WALK("stegosaurus_walk", dinosaur -> true, AnimationUtils::stegosaurusWalkAnimation),
    THERIZINOSAURUS_WALK("therizinosaurus_walk", dinosaur -> true, AnimationUtils::therizinosaurusWalkAnimation),
    LEGACY_TRICERATOPS_WALK("legacy_triceratops_walk", dinosaur -> true, AnimationUtils::legacyTriceratopsWalkAnimation),
    TYRANNOSAURUS_HEAD("tyrannosaurus_head", dinosaur -> true, AnimationUtils::tyrannosaurusHeadAnimation),
    TYRANNOSAURUS_WALK("tyrannosaurus_walk", dinosaur -> true, AnimationUtils::tyrannosaurusWalkAnimation, AnimationUtils::tyrannosaurusWalkModelPrep),
    LEGACY_VELOCIRAPTOR_WALK("legacy_velociraptor_walk", dinosaur -> true, AnimationUtils::legacyVelociraptorWalkAnimation),
    MAMMOTH_WALK("mammoth_walk", dinosaur -> true, AnimationUtils::mammothWalkAnimation),
    SMILODON_SHAKE("smilodon_shake", dinosaur -> true, null, AnimationUtils::smilodonShakeAnimation),
    SMILODON_SIT("smilodon_sit", dinosaur -> true, AnimationUtils::smilodonSitAnimation),
    SMILODON_TAIL("smilodon_tail", dinosaur -> true, AnimationUtils::smilodonTailAnimation),
    SMILODON_WALK("smilodon_walk", dinosaur -> true, AnimationUtils::smilodonWalkAnimation);

    private final ResourceLocation id;
    private final Function<Dinosaur, Boolean> canUse;
    private final AnimationProivder animationProivder;
    private final ModelPrepProivder modelPrepProivder;

    private BuiltInAnimationTypes(ResourceLocation id, Function<Dinosaur, Boolean> canUse, AnimationProivder animationProivder, ModelPrepProivder modelPrepProivder) {
        this.id = id;
        this.canUse = canUse;
        this.animationProivder = animationProivder;
        this.modelPrepProivder = modelPrepProivder;

        AnimationUtils.register(id, this);
    }

    private BuiltInAnimationTypes(String id, Function<Dinosaur, Boolean> canUse, AnimationProivder animationProivder) {
        this(FossilsLegacyUtils.resource(id), canUse, animationProivder, null);
    }

    private BuiltInAnimationTypes(String id, Function<Dinosaur, Boolean> canUse, AnimationProivder animationProivder, ModelPrepProivder modelPrepProivder) {
        this(FossilsLegacyUtils.resource(id), canUse, animationProivder, modelPrepProivder);
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
        if (this.animationProivder != null) {
            this.animationProivder.accept(dinosaur, jsonModel, limbSwing, limbSwingAmount, netHeadYaw);
        }
    }

    @Override
    public void prepareMobModel(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick) {
        if (this.modelPrepProivder != null) {
            this.modelPrepProivder.accept(dinosaur, jsonModel, limbSwing, limbSwingAmount, partialTick);
        }
    }

    public static void init() {
    }

    private interface AnimationProivder {
        void accept(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw);
    }

    private interface ModelPrepProivder {
        void accept(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw);
    }
}
