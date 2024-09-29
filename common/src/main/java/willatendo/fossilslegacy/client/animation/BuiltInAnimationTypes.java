package willatendo.fossilslegacy.client.animation;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.client.BuiltInAnimationType;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public enum BuiltInAnimationTypes implements BuiltInAnimationType {
    LEGACY_BRACHIOSAURUS_WALK("legacy_brachiosaurus_walk", dinosaur -> true, AnimationUtils::legacyBrachiosaurusWalkAnimation, "front_right_thigh", "front_right_calf", "front_left_thigh", "front_left_calf", "back_right_thigh", "back_right_calf", "back_left_thigh", "back_left_calf"),
    CARNOTAURUS_WALK("carnotaurus_walk", dinosaur -> true, AnimationUtils::carnotaurusWalkAnimation, "right_thigh", "left_thigh"),
    CRYOLOPHOSAURUS_WALK("cryolophosaurus_walk", dinosaur -> true, AnimationUtils::cryolophosaurusWalkAnimation, "right_thigh", "left_thigh"),
    DILOPHOSAURUS_WALK("dilophosaurus_walk", dinosaur -> true, AnimationUtils::dilophosaurusWalkAnimation, "right_thigh", "right_leg", "right_foot", "left_thigh", "left_leg", "left_foot"),
    MOSASAURUS_SWIM("mosasaurus_swim", dinosaur -> true, AnimationUtils::mosasaurusSwimAnimation, "body", "tail_1", "tail_2", "tail_3", "right_front_flipper", "left_front_flipper", "right_back_flipper", "left_back_flipper", "tail_2_spike", "tail_3_spike"),
    PTERANODON_FLY("pteranodon_fly", dinosaur -> dinosaur instanceof FlyingDinosaur, AnimationUtils::pteranodonFlyingAnimation, "right_wing_1", "left_wing_1", "right_wing_2", "left_wing_2", "body", "neck_1", "neck_2", "tail", "crown", "head", "upper_mouth", "lower_mouth", "right_leg", "left_leg"),
    PTERANODON_HEAD("pteranodon_head", dinosaur -> true, AnimationUtils::pteranodonHeadAnimation, "crown", "upper_mouth", "lower_mouth", "head"),
    PTERANODON_WALK("pteranodon_walk", dinosaur -> true, AnimationUtils::pteranodonWalkAnimation, "right_leg", "left_leg"),
    STEGOSAURUS_WALK("stegosaurus_walk", dinosaur -> true, AnimationUtils::stegosaurusWalkAnimation, "tail_1", "tail_2", "tail_3", "right_front_leg", "left_front_leg", "right_front_foot", "left_front_foot", "right_back_leg", "left_back_leg", "right_back_foot", "left_back_foot", "back_plates_1", "back_plates_2", "back_plates_3", "thagomizer"),
    THERIZINOSAURUS_WALK("therizinosaurus_walk", dinosaur -> true, AnimationUtils::therizinosaurusWalkAnimation, "right_thigh", "left_thigh"),
    LEGACY_TRICERATOPS_WALK("legacy_triceratops_walk", dinosaur -> true, AnimationUtils::legacyTriceratopsWalkAnimation, "lower_body", "back", "tail", "right_front_thigh", "left_front_thigh", "right_front_leg", "left_front_leg", "right_back_thigh", "left_back_thigh", "right_back_leg", "left_back_leg"),
    TYRANNOSAURUS_HEAD("tyrannosaurus_head", dinosaur -> true, AnimationUtils::tyrannosaurusHeadAnimation, "head", "snout", "jaw"),
    TYRANNOSAURUS_WALK("tyrannosaurus_walk", dinosaur -> true, AnimationUtils::tyrannosaurusWalkAnimation, AnimationUtils::tyrannosaurusWalkModelPrep, "right_thigh", "left_thigh", "right_leg", "left_leg", "right_foot", "left_foot", "body", "neck", "right_arm", "left_arm", "tail_base", "tail_mid", "tail_end", "head", "snout", "jaw"),
    LEGACY_VELOCIRAPTOR_WALK("legacy_velociraptor_walk", dinosaur -> true, AnimationUtils::legacyVelociraptorWalkAnimation, "right_thigh", "left_thigh", "right_leg", "left_leg", "right_foot", "left_foot", "right_hook_1", "left_hook_1", "right_hook_2", "left_hook_2", "right_bicep", "left_bicep", "right_hand", "left_hand"),
    MAMMOTH_WALK("mammoth_walk", dinosaur -> true, AnimationUtils::mammothWalkAnimation, "right_arm", "left_arm", "right_leg", "left_leg", "nose_top", "nose_bottom"),
    SMILODON_SHAKE("smilodon_shake", dinosaur -> true, null, AnimationUtils::smilodonShakeModelPrep, "head", "right_ear", "left_ear", "right_tooth_bottom", "left_tooth_bottom", "right_tooth_top", "left_tooth_top", "snout", "jaw", "nose", "body", "back", "tail"),
    SMILODON_SIT("smilodon_sit", dinosaur -> true, null, AnimationUtils::smilodonSitModelPrep, "body", "back", "tail", "right_front_leg", "left_front_leg", "right_back_leg", "left_back_leg"),
    SMILODON_TAIL("smilodon_tail", dinosaur -> true, AnimationUtils::smilodonTailAnimation, "tail"),
    SMILODON_WALK("smilodon_walk", dinosaur -> true, AnimationUtils::smilodonWalkAnimation, "body", "back", "tail", "right_front_leg", "left_front_leg", "right_back_leg", "left_back_leg");

    private final ResourceLocation id;
    private final Function<Dinosaur, Boolean> canUse;
    private final AnimationProvider animationProvider;
    private final ModelPrepProvider modelPrepProvider;
    private final String[] loadParts;

    BuiltInAnimationTypes(ResourceLocation id, Function<Dinosaur, Boolean> canUse, AnimationProvider animationProvider, ModelPrepProvider modelPrepProvider, String... loadParts) {
        this.id = id;
        this.canUse = canUse;
        this.animationProvider = animationProvider;
        this.modelPrepProvider = modelPrepProvider;
        this.loadParts = loadParts;

        AnimationUtils.VALUES.put(id, this);
    }

    BuiltInAnimationTypes(String id, Function<Dinosaur, Boolean> canUse, AnimationProvider animationProvider, String... loadParts) {
        this(FossilsLegacyUtils.resource(id), canUse, animationProvider, null, loadParts);
    }

    BuiltInAnimationTypes(String id, Function<Dinosaur, Boolean> canUse, AnimationProvider animationProivder, ModelPrepProvider modelPrepProvider, String... loadParts) {
        this(FossilsLegacyUtils.resource(id), canUse, animationProivder, modelPrepProvider, loadParts);
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public String[] loadParts() {
        return this.loadParts;
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
