package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.EntityModelProvider;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.dinosaur.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.KnockedOutTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.TyrannosaurusModel;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyEntityModelProvider extends EntityModelProvider {
    public FossilsLegacyEntityModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    protected void getAll() {
        this.add("brachiosaurus", BrachiosaurusModel.createBodyLayer(), "walk", this.mod("brachiosaurus_walk"), "neck");
        this.add("legacy_brachiosaurus", LegacyBrachiosaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK);
        this.add("carnotaurus", CarnotaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.CARNOTAURUS_WALK);
        this.add("compsognathus", CompsognathusModel.createBodyLayer(), "walk", this.mod("compsognathus_walk"), "head");
        this.add("cryolophosaurus", CryolophosaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.CRYOLOPHOSAURUS_WALK);
        this.add("dilophosaurus", DilophosaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.DILOPHOSAURUS_WALK);
        this.add("futabasaurus", FutabasaurusModel.createBodyLayer(), "walk", this.mod("futabasaurus_walk"), "swim", this.mod("futabasaurus_swim"), "neck", "middle_neck", "head");
        this.add("legacy_futabasaurus", LegacyFutabasaurusModel.createBodyLayer());
        this.add("moa", MoaModel.createBodyLayer(), "walk", this.mod("moa_walk"), "neck");
        this.add("mosasaurus", MosasaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.MOSASAURUS_SWIM, "swim", BuiltInAnimationTypes.MOSASAURUS_SWIM);
        this.add("pachycephalosaurus", PachycephalosaurusModel.createBodyLayer(), "walk", this.mod("pachycephalosaurus_walk"), "head");
        this.add("pteranodon", GroundPteranodonModel.createBodyLayer(), "walk", BuiltInAnimationTypes.PTERANODON_WALK, "head", BuiltInAnimationTypes.PTERANODON_HEAD);
        this.add("flying_pteranodon", FlyingPteranodonModel.createBodyLayer(), "fly", BuiltInAnimationTypes.PTERANODON_FLY);
        this.add("landing_pteranodon", LandingPteranodonModel.createBodyLayer());
        this.add("stegosaurus", StegosaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.STEGOSAURUS_WALK);
        this.add("therizinosaurus", TherizinosaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.THERIZINOSAURUS_WALK);
        this.add("triceratops", TriceratopsModel.createBodyLayer(), "walk", this.mod("triceratops_walk"), "head");
        this.add("legacy_triceratops", LegacyTriceratopsModel.createBodyLayer(), "walk", BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK);
        this.add("tyrannosaurus", TyrannosaurusModel.createBodyLayer(), "walk", BuiltInAnimationTypes.TYRANNOSAURUS_WALK, "head", BuiltInAnimationTypes.TYRANNOSAURUS_HEAD);
        this.add("knocked_out_tyrannosaurus", KnockedOutTyrannosaurusModel.createBodyLayer());
        this.add("velociraptor", VelociraptorModel.createBodyLayer(), "walk", this.mod("velociraptor_walk"), "head");
        this.add("legacy_velociraptor", LegacyVelociraptorModel.createBodyLayer(), "walk", BuiltInAnimationTypes.LEGACY_VELOCIRAPTOR_WALK);
        this.add("dodo", DodoModel.createBodyLayer(), "walk", this.mod("dodo_walk"), "float_down", this.mod("dodo_float_down"), "head");
        this.add("smilodon", SmilodonModel.createBodyLayer(), "walk", BuiltInAnimationTypes.SMILODON_WALK, "sit", BuiltInAnimationTypes.SMILODON_SIT, "shake", BuiltInAnimationTypes.SMILODON_SHAKE, "tail", BuiltInAnimationTypes.SMILODON_TAIL);
        this.add("mammoth", MammothModel.createBodyLayer(), "walk", BuiltInAnimationTypes.MAMMOTH_WALK);
    }
}
