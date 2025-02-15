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
        this.add(AnkylosaurusModels.ANKYLOSAURUS_MODEL);
        this.add(BrachiosaurusModels.BRACHIOSAURUS_MODEL);
        this.add(BrachiosaurusModels.LEGACY_BRACHIOSAURUS_MODEL);
        this.add(CarnotaurusModels.CARNOTAURUS_MODEL);
        this.add(CarnotaurusModels.LEGACY_CARNOTAURUS_MODEL);
        this.add(CompsognathusModels.COMPSOGNATHUS_MODEL);
        this.add(CryolophosaurusModels.CRYOLOPHOSAURUS_MODEL);
        this.add(CryolophosaurusModels.LEGACY_CRYOLOPHOSAURUS_MODEL);
        this.add(DilophosaurusModels.DILOPHOSAURUS_MODEL);
        this.add(DilophosaurusModels.LEGACY_DILOPHOSAURUS_MODEL);
        this.add(DimetrodonModels.DIMETRODON_MODEL);
        this.add(DodoModels.DODO_MODEL);
        this.add(FutabasaurusModels.FUTABASAURUS_MODEL);
        this.add(FutabasaurusModels.LEGACY_FUTABASAURUS_MODEL);
        this.add(FutabasaurusModels.LEGACY_FUTABASAURUS_FOSSIL_MODEL);
        this.add(GallimimusModels.GALLIMIMUS_MODEL);
        this.add(MammothModels.MAMMOTH_MODEL);
        this.add(MammothModels.LEGACY_MAMMOTH_MODEL);
        this.add(MoaModels.MOA_MODEL);
        this.add(MosasaurusModels.MOSASAURUS_MODEL);
        this.add(MosasaurusModels.MOSASAURUS_LEGACY_MODEL);
        this.add(PachycephalosaurusModels.PACHYCEPHALOSAURUS_MODEL);
        this.add(PteranodonModels.PTERANODON_MODEL);
        this.add(PteranodonModels.LEGACY_PTERANODON_MODEL);
        this.add(PteranodonModels.LEGACY_FLYING_PTERANODON_MODEL);
        this.add(PteranodonModels.LEGACY_LANDING_PTERANODON_MODEL);
        this.add(SmilodonModels.SMILODON_MODEL);
        this.add(SmilodonModels.LEGACY_SMILODON_MODEL);
        this.add(SpinosaurusModels.SPINOSAURUS_MODEL);
        this.add(StegosaurusModels.STEGOSAURUS_MODEL);
        this.add(StegosaurusModels.LEGACY_STEGOSAURUS_MODEL);
        this.add(TherizinosaurusModels.THERIZINOSAURUS_MODEL);
        this.add(TherizinosaurusModels.LEGACY_THERIZINOSAURUS_MODEL);
        this.add(TyrannosaurusModels.TYRANNOSAURUS_MODEL);
        this.add(TyrannosaurusModels.KNOCKED_OUT_TYRANNOSAURUS_MODEL);
        this.add(TyrannosaurusModels.LEGACY_TYRANNOSAURUS_MODEL);
        this.add(TyrannosaurusModels.LEGACY_KNOCKED_OUT_TYRANNOSAURUS_MODEL);
        this.add(VelociraptorModels.VELOCIRAPTOR_MODEL);
        this.add(VelociraptorModels.LEGACY_VELOCIRAPTOR_MODEL);
    }
}
