package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.AnimationProvider;
import willatendo.fossilslegacy.client.animation.*;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FAAnimationProvider extends AnimationProvider {
    public FAAnimationProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.addAnimation(FAUtils.resource("ankylosaurus_walk"), AnkylosaurusAnimations.ANKYLOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("brachiosaurus_walk"), BrachiosaurusAnimations.BRACHIOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("carnotaurus_walk"), CarnotaurusAnimations.CARNOTAURUS_WALK);
        this.addAnimation(FAUtils.resource("compsognathus_walk"), CompsognathusAnimations.COMPSOGNATHUS_WALK);
        this.addAnimation(FAUtils.resource("cryolophosaurus_walk"), CrolophosaurusAnimations.CRYOLOPHOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("dilophosaurus_walk"), DilophosaurusAnimations.DILOPHOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("dimetrodon_walk"), DimetrodonAnimations.DIMETRODON_WALK);
        this.addAnimation(FAUtils.resource("dodo_float_down"), DodoAnimations.DODO_FALL);
        this.addAnimation(FAUtils.resource("dodo_walk"), DodoAnimations.DODO_WALK);
        this.addAnimation(FAUtils.resource("futabasaurus_swim"), FutabasaurusAnimations.FUTABASAURUS_SWIM);
        this.addAnimation(FAUtils.resource("futabasaurus_walk"), FutabasaurusAnimations.FUTABASAURUS_WALK);
        this.addAnimation(FAUtils.resource("gallimimus_walk"), GallimimusAnimations.GALLIMIMUS_WALK);
        this.addAnimation(FAUtils.resource("ichthyosaurus_idle"), IchthyosaurAnimations.ICHTHYOSAURUS_IDLE);
        this.addAnimation(FAUtils.resource("ichthyosaurus_swim"), IchthyosaurAnimations.ICHTHYOSAURUS_SWIM);
        this.addAnimation(FAUtils.resource("pachycephalosaurus_walk"), PachycephalosaurusAnimations.PACHYCEPHALOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("pteranodon_walk"), PteranodonAnimations.PTERANODON_WALK);
        this.addAnimation(FAUtils.resource("pteranodon_fly"), PteranodonAnimations.PTERANODON_FLY);
        this.addAnimation(FAUtils.resource("pteranodon_land"), PteranodonAnimations.PTERANODON_LAND);
        this.addAnimation(FAUtils.resource("moa_walk"), MoaAnimations.MOA_WALK);
        this.addAnimation(FAUtils.resource("mosasaurus_swim"), MosasaurusAnimations.MOSASAURUS_SWIM);
        this.addAnimation(FAUtils.resource("mosasaurus_walk"), MosasaurusAnimations.MOSASAURUS_WALK);
        this.addAnimation(FAUtils.resource("mammoth_walk"), MammothAnimations.MAMMOTH_WALK);
        this.addAnimation(FAUtils.resource("smilodon_walk"), SmilodonAnimations.SMILODON_WALK);
        this.addAnimation(FAUtils.resource("smilodon_sit"), SmilodonAnimations.SMILODON_SIT);
        this.addAnimation(FAUtils.resource("spinosaurus_walk"), SpinosaurusAnimations.SPINOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("spinosaurus_swim"), SpinosaurusAnimations.SPINOSAURUS_SWIM);
        this.addAnimation(FAUtils.resource("stegosaurus_walk"), StegosaurusAnimations.STEGOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("therizinosaurus_walk"), TherizinosaurusAnimations.THERIZINOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("triceratops_walk"), TriceratopsAnimations.TRICERATOPS_WALK);
        this.addAnimation(FAUtils.resource("tyrannosaurus_walk"), TyrannosaurusAnimations.TYRANNOSAURUS_WALK);
        this.addAnimation(FAUtils.resource("velociraptor_walk"), VelociraptorAnimations.VELOCIRAPTOR_WALK);
    }
}
