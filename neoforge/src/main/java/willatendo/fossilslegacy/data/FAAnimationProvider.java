package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.AnimationProvider;
import willatendo.fossilslegacy.client.animation.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FAAnimationProvider extends AnimationProvider {
    public FAAnimationProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.addAnimation(FossilsLegacyUtils.resource("ankylosaurus_walk"), AnkylosaurusAnimations.ANKYLOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("brachiosaurus_walk"), BrachiosaurusAnimations.BRACHIOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("carnotaurus_walk"), CarnotaurusAnimations.CARNOTAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("compsognathus_walk"), CompsognathusAnimations.COMPSOGNATHUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("cryolophosaurus_walk"), CrolophosaurusAnimations.CRYOLOPHOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("dilophosaurus_walk"), DilophosaurusAnimations.DILOPHOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("dimetrodon_walk"), DimetrodonAnimations.DIMETRODON_WALK);
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
        this.addAnimation(FossilsLegacyUtils.resource("mosasaurus_swim"), MosasaurusAnimations.MOSASAURUS_SWIM);
        this.addAnimation(FossilsLegacyUtils.resource("mosasaurus_walk"), MosasaurusAnimations.MOSASAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("mammoth_walk"), MammothAnimations.MAMMOTH_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("smilodon_walk"), SmilodonAnimations.SMILODON_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("smilodon_sit"), SmilodonAnimations.SMILODON_SIT);
        this.addAnimation(FossilsLegacyUtils.resource("spinosaurus_walk"), SpinosaurusAnimations.SPINOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("spinosaurus_swim"), SpinosaurusAnimations.SPINOSAURUS_SWIM);
        this.addAnimation(FossilsLegacyUtils.resource("stegosaurus_walk"), StegosaurusAnimations.STEGOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("therizinosaurus_walk"), TherizinosaurusAnimations.THERIZINOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("triceratops_walk"), TriceratopsAnimations.TRICERATOPS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("tyrannosaurus_walk"), TyrannosaursAnimations.TYRANNOSAURUS_WALK);
        this.addAnimation(FossilsLegacyUtils.resource("velociraptor_walk"), VelociraptorAnimations.VELOCIRAPTOR_WALK);

        this.addBuiltIn(BuiltInAnimationTypes.PTERANODON_BODY_FLY);

        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_CARNOTAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_CRYOLOPHOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_DILOPHOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_MOSASAURUS_SWIM);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_PTERANODON_HEAD);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_PTERANODON_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_PTERANODON_FLY);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_STEGOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_THERIZINOSAURUS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_MAMMOTH_WALK);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_SMILODON_SHAKE);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_SMILODON_SIT);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_SMILODON_TAIL);
        this.addBuiltIn(BuiltInAnimationTypes.LEGACY_SMILODON_WALK);
    }
}
