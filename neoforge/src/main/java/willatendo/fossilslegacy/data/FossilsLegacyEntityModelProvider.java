package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.EntityModelHolder;
import willatendo.fossilslegacy.api.data.EntityModelProvider;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.dinosaur.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.*;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.pteranodon.LandingPteranodonModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.KnockedOutLegacyTyrannosaurusModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus.LegacyTyrannosaurusModel;

public class FossilsLegacyEntityModelProvider extends EntityModelProvider {
    public FossilsLegacyEntityModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.add(EntityModelHolder.builder(this.mod("ankylosaurus"), AnkylosaurusModel.createBodyLayer()).withAnimation("walk", this.mod("ankylosaurus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("brachiosaurus"), BrachiosaurusModel.createBodyLayer()).withAnimation("walk", this.mod("brachiosaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_brachiosaurus"), LegacyBrachiosaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("carnotaurus"), CarnotaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.CARNOTAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("compsognathus"), CompsognathusModel.createBodyLayer()).withAnimation("walk", this.mod("compsognathus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("cryolophosaurus"), CryolophosaurusModel.createBodyLayer()).withAnimation("walk", this.mod("cryolophosaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_cryolophosaurus"), LegacyCryolophosaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_CRYOLOPHOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("dilophosaurus"), DilophosaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.DILOPHOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("futabasaurus"), FutabasaurusModel.createBodyLayer()).withAnimation("walk", this.mod("futabasaurus_walk")).withAnimation("swim", this.mod("futabasaurus_swim")).withHeadPeices("neck", "middle_neck", "head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_futabasaurus"), LegacyFutabasaurusModel.createBodyLayer()).build());
        this.add(EntityModelHolder.builder(this.mod("gallimimus"), GallimimusModel.createBodyLayer()).withAnimation("walk", this.mod("gallimimus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("moa"), MoaModel.createBodyLayer()).withAnimation("walk", this.mod("moa_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_mosasaurus"), MosasaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.MOSASAURUS_SWIM).withBuiltInAnimation("swim", BuiltInAnimationTypes.MOSASAURUS_SWIM).build());
        this.add(EntityModelHolder.builder(this.mod("pachycephalosaurus"), PachycephalosaurusModel.createBodyLayer()).withAnimation("walk", this.mod("pachycephalosaurus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("pteranodon"), GroundPteranodonModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.PTERANODON_WALK).withBuiltInAnimation("head", BuiltInAnimationTypes.PTERANODON_HEAD).build());
        this.add(EntityModelHolder.builder(this.mod("flying_pteranodon"), FlyingPteranodonModel.createBodyLayer()).withBuiltInAnimation("fly", BuiltInAnimationTypes.PTERANODON_FLY).build());
        this.add(EntityModelHolder.builder(this.mod("landing_pteranodon"), LandingPteranodonModel.createBodyLayer()).build());
        this.add(EntityModelHolder.builder(this.mod("stegosaurus"), StegosaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.STEGOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("therizinosaurus"), TherizinosaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.THERIZINOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("triceratops"), TriceratopsModel.createBodyLayer()).withAnimation("walk", this.mod("triceratops_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_triceratops"), LegacyTriceratopsModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("baby_tyrannosaurus"), TyrannosaurusModels.baby()).build());
        this.add(EntityModelHolder.builder(this.mod("tyrannosaurus"), TyrannosaurusModels.adult()).build());
        this.add(EntityModelHolder.builder(this.mod("knocked_out_tyrannosaurus"), TyrannosaurusModels.knockedOut()).build());
        this.add(EntityModelHolder.builder(this.mod("legacy_tyrannosaurus"), LegacyTyrannosaurusModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.TYRANNOSAURUS_WALK).withBuiltInAnimation("head", BuiltInAnimationTypes.TYRANNOSAURUS_HEAD).build());
        this.add(EntityModelHolder.builder(this.mod("legacy_knocked_out_tyrannosaurus"), KnockedOutLegacyTyrannosaurusModel.createBodyLayer()).build());
        this.add(EntityModelHolder.builder(this.mod("velociraptor"), VelociraptorModel.createBodyLayer()).withAnimation("walk", this.mod("velociraptor_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_velociraptor"), LegacyVelociraptorModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_VELOCIRAPTOR_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("dodo"), DodoModel.createBodyLayer()).withAnimation("walk", this.mod("dodo_walk")).withAnimation("float_down", this.mod("dodo_float_down")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("spinosaurus"), SpinosaurusModel.createBodyLayer()).withAnimation("walk", this.mod("spinosaurus_walk")).withAnimation("swim", this.mod("spinosaurus_swim")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("smilodon"), SmilodonModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.SMILODON_WALK).withBuiltInAnimation("sit", BuiltInAnimationTypes.SMILODON_SIT).withBuiltInAnimation("shake", BuiltInAnimationTypes.SMILODON_SHAKE).withBuiltInAnimation("tail", BuiltInAnimationTypes.SMILODON_TAIL).build());
        this.add(EntityModelHolder.builder(this.mod("mammoth"), MammothModel.createBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.MAMMOTH_WALK).build());
    }
}
