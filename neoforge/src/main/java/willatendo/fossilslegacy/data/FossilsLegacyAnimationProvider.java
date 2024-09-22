package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.AnimationProvider;
import willatendo.fossilslegacy.client.animation.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyAnimationProvider extends AnimationProvider {
    public FossilsLegacyAnimationProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.addAnimation(FossilsLegacyUtils.resource("brachiosaurus_walk"), BrachiosaurusAnimations.BRACHIOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("compsognathus_walk"), CompsognathusAnimations.COMPSOGNATHUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("dodo_float_down"), DodoAnimations.DODO_FALL);
        this.addAnimation(FossilsLegacyUtils.resource("dodo_walk"), DodoAnimations.DODO_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("futabasaurus_swim"), FutabasaurusAnimations.FUTABASAURUS_SWIM);
        this.addAnimation(FossilsLegacyUtils.resource("futabasaurus_walk"), FutabasaurusAnimations.FUTABASAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("pachycephalosaurus_walk"), PachycephalosaurusAnimations.PACHYCEPHALOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("triceratops_walk"), TriceratopsAnimations.TRICERATOPS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("velociraptor_walk"), VelociraptorAnimations.VELOCIRAPTOR_WALK);

        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK, "front_left_thigh", "front_left_calf", "front_right_thigh", "front_right_calf", "back_left_thigh", "back_left_calf", "back_right_thigh", "back_right_calf");
        this.addBuiltIn(BuiltInAnimationTypes.CARNOTAURUS_WALK, "right_thigh", "left_thigh");
        this.addBuiltIn(BuiltInAnimationTypes.CRYOLOPHOSAURUS_WALK, "right_thigh", "left_thigh");
        this.addBuiltIn(BuiltInAnimationTypes.DILOPHOSAURUS_WALK, "right_thigh", "right_leg", "right_foot", "left_thigh", "left_leg", "left_foot");
        this.addBuiltIn(BuiltInAnimationTypes.MOSASAURUS_SWIM, "body", "tail_1", "tail_2", "tail_3", "right_front_flipper", "left_front_flipper", "right_back_flipper", "left_back_flipper", "tail_2_spike", "tail_3_spike");
        this.addBuiltIn(BuiltInAnimationTypes.PTERANODON_HEAD, "crown", "upper_mouth", "lower_mouth", "head");
        this.addBuiltIn(BuiltInAnimationTypes.PTERANODON_WALK, "right_leg", "left_leg");
        this.addBuiltIn(BuiltInAnimationTypes.PTERANODON_FLY, "left_wing_1", "left_wing_2", "right_wing_1", "right_wing_2", "body", "neck_1", "neck_2", "tail", "crown", "head", "upper_mouth", "lower_mouth", "left_leg", "right_leg");
        this.addBuiltIn(BuiltInAnimationTypes.STEGOSAURUS_WALK, "tail_1", "tail_2", "tail_3", "left_front_leg", "right_front_leg", "left_front_foot", "right_front_foot", "left_back_leg", "right_back_leg", "left_back_foot", "right_back_foot", "back_plates_1", "back_plates_2", "back_plates_3", "thagomizer");
        this.addBuiltIn(BuiltInAnimationTypes.THERIZINOSAURUS_WALK, "right_thigh", "left_thigh");
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK, "lower_body", "back", "tail", "right_front_thigh", "right_front_leg", "left_front_thigh", "left_front_leg", "right_back_thigh", "right_back_leg", "left_back_thigh", "left_back_leg");
        this.addBuiltIn(BuiltInAnimationTypes.TYRANNOSAURUS_HEAD, "head", "snout", "jaw");
        this.addBuiltIn(BuiltInAnimationTypes.TYRANNOSAURUS_WALK, "left_thigh", "left_leg", "left_foot", "right_thigh", "right_leg", "right_foot", "body", "neck", "right_arm", "left_arm", "tail_base", "tail_mid", "tail_end", "head", "snout", "jaw");
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_VELOCIRAPTOR_WALK, "left_thigh", "right_leg", "right_foot", "right_hook_1", "right_hook_2", "right_thigh", "left_leg", "left_foot", "left_hook_1", "left_hook_2", "right_bicep", "right_hand", "left_bicep", "left_hand");
        this.addBuiltIn(BuiltInAnimationTypes.MAMMOTH_WALK, "right_arm", "left_arm", "right_leg", "left_leg", "nose_top", "nose_bottom");
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_SHAKE, "head", "right_ear", "left_ear", "left_tooth_bottom", "left_tooth_top", "right_tooth_bottom", "right_tooth_top", "snout", "jaw", "nose", "body", "back", "tail");
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_SIT, "body", "back", "tail", "left_front_leg", "left_back_leg", "right_front_leg", "right_back_leg");
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_TAIL, "tail");
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_WALK, "body", "back", "tail", "left_front_leg", "left_back_leg", "right_front_leg", "right_back_leg");
    }
}
