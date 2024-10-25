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
        this.addAnimation(FossilsLegacyUtils.resource("ankylosaurus_walk"), AnkylosaurusAnimations.ANKYLOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("brachiosaurus_walk"), BrachiosaurusAnimations.BRACHIOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("compsognathus_walk"), CompsognathusAnimations.COMPSOGNATHUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("cryolophosaurus_walk"), CrolophosaurusAnimations.CRYOLOPHOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("dodo_float_down"), DodoAnimations.DODO_FALL);
        this.addAnimation(FossilsLegacyUtils.resource("dodo_walk"), DodoAnimations.DODO_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("futabasaurus_swim"), FutabasaurusAnimations.FUTABASAURUS_SWIM);
        this.addAnimation(FossilsLegacyUtils.resource("futabasaurus_walk"), FutabasaurusAnimations.FUTABASAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("gallimimus_walk"), GallimimusAnimations.GALLIMIMUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("pachycephalosaurus_walk"), PachycephalosaurusAnimations.PACHYCEPHALOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("pteranodon_walk"), PteranodonAnimations.PTERANODON_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("pteranodon_fly"), PteranodonAnimations.PTERANODON_FLY);
        this.addAnimation(FossilsLegacyUtils.resource("pteranodon_land"), PteranodonAnimations.PTERANODON_LAND);
        this.addAnimation(FossilsLegacyUtils.resource("moa_walk"), MoaAnimations.MOA_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("spinosaurus_walk"), SpinosaurusAnimations.SPINOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("spinosaurus_swim"), SpinosaurusAnimations.SPINOSAURUS_SWIM);
        this.addAnimation(FossilsLegacyUtils.resource("triceratops_walk"), TriceratopsAnimations.TRICERATOPS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("velociraptor_walk"), VelociraptorAnimations.VELOCIRAPTOR_WALK);

        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.CARNOTAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_CRYOLOPHOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.DILOPHOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.MOSASAURUS_SWIM);
        this.addBuiltIn(BuiltInAnimationTypes.PTERANODON_BODY_FLY);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_PTERANODON_HEAD);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_PTERANODON_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_PTERANODON_FLY);
        this.addBuiltIn(BuiltInAnimationTypes.STEGOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.THERIZINOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.TYRANNOSAURUS_HEAD);
        this.addBuiltIn(BuiltInAnimationTypes.TYRANNOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_VELOCIRAPTOR_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.MAMMOTH_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_SHAKE);
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_SIT);
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_TAIL);
        this.addBuiltIn(BuiltInAnimationTypes.SMILODON_WALK);
    }
}
