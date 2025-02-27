package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.EntityModelHolder;
import willatendo.fossilslegacy.api.data.EntityModelProvider;
import willatendo.fossilslegacy.client.animation.BuiltInAnimationTypes;
import willatendo.fossilslegacy.client.model.dinosaur.*;

public class FAEntityModelProvider extends EntityModelProvider {
    public FAEntityModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.add(EntityModelHolder.builder(this.mod("ankylosaurus"), AnkylosaurusModels.createAnkylosaurusBodyLayer()).withAnimation("walk", this.mod("ankylosaurus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("brachiosaurus"), BrachiosaurusModels.createBrachiosaurusBodyLayer()).withAnimation("walk", this.mod("brachiosaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_brachiosaurus"), BrachiosaurusModels.createLegacyBrachiosaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_BRACHIOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("carnotaurus"), CarnotaurusModels.createCarnotaurusBodyLayer()).withAnimation("walk", this.mod("carnotaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_carnotaurus"), CarnotaurusModels.createLegacyCarnotaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_CARNOTAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("compsognathus"), CompsognathusModels.createCompsognathusBodyLayer()).withAnimation("walk", this.mod("compsognathus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("cryolophosaurus"), CryolophosaurusModels.createCryolophosaurusBodyLayer()).withAnimation("walk", this.mod("cryolophosaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_cryolophosaurus"), CryolophosaurusModels.createLegacyCryolophosaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_CRYOLOPHOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("dilophosaurus"), DilophosaurusModels.createDilophosaurusBodyLayer()).withAnimation("walk", this.mod("dilophosaurus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_dilophosaurus"), DilophosaurusModels.createLegacyDilophosaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_DILOPHOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("dimetrodon"), DimetrodonModels.createDimetrodonBodyLayer()).withAnimation("walk", this.mod("dimetrodon_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("futabasaurus"), FutabasaurusModels.createFutabasaurusBodyLayer()).withAnimation("walk", this.mod("futabasaurus_walk")).withAnimation("swim", this.mod("futabasaurus_swim")).withHeadPeices("neck", "middle_neck", "head").build());
        this.addBuiltIn(this.mod("legacy_futabasaurus"));
        this.addBuiltIn(this.mod("legacy_futabasaurus_fossil"));
        this.add(EntityModelHolder.builder(this.mod("gallimimus"), GallimimusModels.createGallimimusBodyLayer()).withAnimation("walk", this.mod("gallimimus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("moa"), MoaModels.createMoaBodyLayer()).withAnimation("walk", this.mod("moa_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("mosasaurus"), MosasaurusModels.createMosasaurusBodyLayer()).withAnimation("walk", this.mod("mosasaurus_walk")).withAnimation("swim", this.mod("mosasaurus_swim")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_mosasaurus"), MosasaurusModels.createLegacyMosasaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_MOSASAURUS_SWIM).withBuiltInAnimation("swim", BuiltInAnimationTypes.LEGACY_MOSASAURUS_SWIM).build());
        this.add(EntityModelHolder.builder(this.mod("pachycephalosaurus"), PachycephalosaurusModels.createPachycephalosaurusBodyLayer()).withAnimation("walk", this.mod("pachycephalosaurus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("pteranodon"), PteranodonModels.createPteranodonBodyLayer()).withAnimation("walk", this.mod("pteranodon_walk")).withAnimation("fly", this.mod("pteranodon_fly"), BuiltInAnimationTypes.PTERANODON_BODY_FLY.getId()).withAnimation("land", this.mod("pteranodon_land")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_pteranodon"), PteranodonModels.createLegacyPteranodonBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_PTERANODON_WALK).withBuiltInAnimation("head", BuiltInAnimationTypes.LEGACY_PTERANODON_HEAD).build());
        this.add(EntityModelHolder.builder(this.mod("legacy_flying_pteranodon"), PteranodonModels.createLegacyFlyingPteranodonBodyLayer()).withBuiltInAnimation("fly", BuiltInAnimationTypes.LEGACY_PTERANODON_FLY).build());
        this.add(EntityModelHolder.builder(this.mod("legacy_landing_pteranodon"), PteranodonModels.createLegacyLandingPteranodonBodyLayer()).build());
        this.add(EntityModelHolder.builder(this.mod("stegosaurus"), StegosaurusModels.createStegosaurusBodyLayer()).withAnimation("walk", this.mod("stegosaurus_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_stegosaurus"), StegosaurusModels.createLegacyStegosaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_STEGOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("therizinosaurus"), TherizinosaurusModels.createTherizinosaurusBodyLayer()).withAnimation("walk", this.mod("therizinosaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_therizinosaurus"), TherizinosaurusModels.createLegacyTherizinosaurusBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_THERIZINOSAURUS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("triceratops"), TriceratopsModels.createTriceratopsBodyLayer()).withAnimation("walk", this.mod("triceratops_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_triceratops"), TriceratopsModels.createLegacyTriceratopsBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_TRICERATOPS_WALK).build());
        this.add(EntityModelHolder.builder(this.mod("tyrannosaurus"), TyrannosaurusModels.createTyrannosaurusBodyLayer()).withAnimation("walk", this.mod("tyrannosaurus_walk")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("knocked_out_tyrannosaurus"), TyrannosaurusModels.createKnockedOutTyrannosaurusBodyLayer()).withHeadPeices("neck").build());
        this.addBuiltIn(this.mod("legacy_tyrannosaurus"));
        this.addBuiltIn(this.mod("legacy_tyrannosaurus_fossil"));
        this.add(EntityModelHolder.builder(this.mod("legacy_knocked_out_tyrannosaurus"), TyrannosaurusModels.createLegacyKnockedOutTyrannosaurusBodyLayer()).build());
        this.add(EntityModelHolder.builder(this.mod("velociraptor"), VelociraptorModels.createVelociraptorBodyLayer()).withAnimation("walk", this.mod("velociraptor_walk")).withHeadPeices("head").build());
        this.addBuiltIn(this.mod("legacy_velociraptor"));
        this.addBuiltIn(this.mod("legacy_velociraptor_fossil"));
        this.add(EntityModelHolder.builder(this.mod("dodo"), DodoModels.createDodoBodyLayer()).withAnimation("walk", this.mod("dodo_walk")).withAnimation("float_down", this.mod("dodo_float_down")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("spinosaurus"), SpinosaurusModels.createSpinosaurusBodyLayer()).withAnimation("walk", this.mod("spinosaurus_walk")).withAnimation("swim", this.mod("spinosaurus_swim")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("smilodon"), SmilodonModels.createSmilodonBodyLayer()).withAnimation("walk", this.mod("smilodon_walk")).withAnimation("sit", this.mod("smilodon_sit")).withHeadPeices("neck").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_smilodon"), SmilodonModels.createLegacySmilodonBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_SMILODON_WALK).withBuiltInAnimation("sit", BuiltInAnimationTypes.LEGACY_SMILODON_SIT).withBuiltInAnimation("shake", BuiltInAnimationTypes.LEGACY_SMILODON_SHAKE).withBuiltInAnimation("tail", BuiltInAnimationTypes.LEGACY_SMILODON_TAIL).colored().overrideReset().build());
        this.add(EntityModelHolder.builder(this.mod("mammoth"), MammothModels.createMammothBodyLayer()).withAnimation("walk", this.mod("mammoth_walk")).withHeadPeices("head").build());
        this.add(EntityModelHolder.builder(this.mod("legacy_mammoth"), MammothModels.createLegacyMammothBodyLayer()).withBuiltInAnimation("walk", BuiltInAnimationTypes.LEGACY_MAMMOTH_WALK).build());
    }
}
