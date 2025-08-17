package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.api.data.EntityModelProvider;
import willatendo.fossilslegacy.client.model.dinosaur.*;

public class FAEntityModelProvider extends EntityModelProvider {
    public FAEntityModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.add(this.mod("ankylosaurus"), AnkylosaurusModels.ANKYLOSAURUS_MODEL);
        this.add(this.mod("baryonyx"), BaryonyxModels.BARYONYX_MODEL);
        this.add(this.mod("brachiosaurus"), BrachiosaurusModels.BRACHIOSAURUS_MODEL);
        this.add(this.mod("legacy_brachiosaurus"), BrachiosaurusModels.LEGACY_BRACHIOSAURUS_MODEL);
        this.add(this.mod("carnotaurus"), CarnotaurusModels.CARNOTAURUS_MODEL);
        this.add(this.mod("legacy_carnotaurus"), CarnotaurusModels.LEGACY_CARNOTAURUS_MODEL);
        this.add(this.mod("compsognathus"), CompsognathusModels.COMPSOGNATHUS_MODEL);
        this.add(this.mod("cryolophosaurus"), CryolophosaurusModels.CRYOLOPHOSAURUS_MODEL);
        this.add(this.mod("legacy_cryolophosaurus"), CryolophosaurusModels.LEGACY_CRYOLOPHOSAURUS_MODEL);
        this.add(this.mod("dilophosaurus"), DilophosaurusModels.DILOPHOSAURUS_MODEL);
        this.add(this.mod("legacy_dilophosaurus"), DilophosaurusModels.LEGACY_DILOPHOSAURUS_MODEL);
        this.add(this.mod("dimetrodon"), DimetrodonModels.DIMETRODON_MODEL);
        this.add(this.mod("distortus_rex"), DistortusRexModels.DISTORTUS_REX_MODEL);
        this.add(this.mod("dodo"), DodoModels.DODO_MODEL);
        this.add(this.mod("dryosaurus"), DryosaurusModels.DRYOSAURUS_MODEL);
        this.add(this.mod("elasmotherium"), ElasmotheriumModels.ELASMOTHERIUM_MODEL);
        this.add(this.mod("futabasaurus"), FutabasaurusModels.FUTABASAURUS_MODEL);
        this.add(this.mod("legacy_futabasaurus"), FutabasaurusModels.LEGACY_FUTABASAURUS_MODEL);
        this.add(this.mod("gallimimus"), GallimimusModels.GALLIMIMUS_MODEL);
        this.add(this.mod("ichthyosaurus"), IchthyosaurusModels.ICHTHYOSAURUS_MODEL);
        this.add(this.mod("indominus_rex"), IndominusRexModels.INDOMINUS_REX_MODEL);
        this.add(this.mod("mammoth"), MammothModels.MAMMOTH_MODEL);
        this.add(this.mod("legacy_mammoth"), MammothModels.LEGACY_MAMMOTH_MODEL);
        this.add(this.mod("moa"), MoaModels.MOA_MODEL);
        this.add(this.mod("mosasaurus"), MosasaurusModels.MOSASAURUS_MODEL);
        this.add(this.mod("legacy_mosasaurus"), MosasaurusModels.MOSASAURUS_LEGACY_MODEL);
        this.add(this.mod("pachycephalosaurus"), PachycephalosaurusModels.PACHYCEPHALOSAURUS_MODEL);
        this.add(this.mod("pteranodon"), PteranodonModels.PTERANODON_MODEL);
        this.add(this.mod("legacy_pteranodon"), PteranodonModels.LEGACY_PTERANODON_MODEL);
        this.add(this.mod("legacy_flying_pteranodon"), PteranodonModels.LEGACY_FLYING_PTERANODON_MODEL);
        this.add(this.mod("legacy_landing_pteranodon"), PteranodonModels.LEGACY_LANDING_PTERANODON_MODEL);
        this.add(this.mod("smilodon"), SmilodonModels.SMILODON_MODEL);
        this.add(this.mod("legacy_smilodon"), SmilodonModels.LEGACY_SMILODON_MODEL);
        this.add(this.mod("spinosaurus"), SpinosaurusModels.SPINOSAURUS_MODEL);
        this.add(this.mod("stegosaurus"), StegosaurusModels.STEGOSAURUS_MODEL);
        this.add(this.mod("legacy_stegosaurus"), StegosaurusModels.LEGACY_STEGOSAURUS_MODEL);
        this.add(this.mod("therizinosaurus"), TherizinosaurusModels.THERIZINOSAURUS_MODEL);
        this.add(this.mod("legacy_therizinosaurus"), TherizinosaurusModels.LEGACY_THERIZINOSAURUS_MODEL);
        this.add(this.mod("triceratops"), TriceratopsModels.TRICERATOPS_MODEL);
        this.add(this.mod("legacy_triceratops"), TriceratopsModels.LEGACY_TRICERATOPS_MODEL);
        this.add(this.mod("isotelus"), IsotelusModels.ISOTELUS_MODEL);
        this.add(this.mod("isotelus_larva"), IsotelusLarvaModels.ISOTELUS_LARVA_MODEL);
        this.add(this.mod("tyrannosaurus"), TyrannosaurusModels.TYRANNOSAURUS_MODEL);
        this.add(this.mod("knocked_out_tyrannosaurus"), TyrannosaurusModels.KNOCKED_OUT_TYRANNOSAURUS_MODEL);
        this.add(this.mod("legacy_tyrannosaurus"), TyrannosaurusModels.LEGACY_TYRANNOSAURUS_MODEL);
        this.add(this.mod("legacy_knocked_out_tyrannosaurus"), TyrannosaurusModels.LEGACY_KNOCKED_OUT_TYRANNOSAURUS_MODEL);
        this.add(this.mod("velociraptor"), VelociraptorModels.VELOCIRAPTOR_MODEL);
        this.add(this.mod("legacy_velociraptor"), VelociraptorModels.LEGACY_VELOCIRAPTOR_MODEL);
    }
}
