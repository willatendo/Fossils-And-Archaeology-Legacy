package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import willatendo.fossilslegacy.server.fuel.FAFuelEntries;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;

import java.util.concurrent.CompletableFuture;

public class FAFuelEntryTagProvider extends DataDrivenTagsProvider<FuelEntry> {
    public FAFuelEntryTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.FUEL_ENTRY, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAFuelEntryTags.CULTIVATOR).add(FAFuelEntries.FOSSIL, FAFuelEntries.RAW_CHICKEN_SOUP_BUCKET, FAFuelEntries.RAW_BERRY_MEDLEY_BUCKET, FAFuelEntries.AXOLOTLSPAWN, FAFuelEntries.ANKYLOSAURUS_EGG, FAFuelEntries.BRACHIOSAURUS_EGG, FAFuelEntries.CARNOTAURUS_EGG, FAFuelEntries.COMPSOGNATHUS_EGG, FAFuelEntries.CRYOLOPHOSAURUS_EGG, FAFuelEntries.DILOPHOSAURUS_EGG, FAFuelEntries.DIMETRODON_EGG, FAFuelEntries.DODO_EGG, FAFuelEntries.FROGSPAWN, FAFuelEntries.FUTABASAURUS_EGG, FAFuelEntries.GALLIMIMUS_EGG, FAFuelEntries.INCUBATED_CHICKEN_EGG, FAFuelEntries.INCUBATED_DODO_EGG, FAFuelEntries.INCUBATED_MOA_EGG, FAFuelEntries.INCUBATED_PARROT_EGG, FAFuelEntries.MOA_EGG, FAFuelEntries.MOSASAURUS_EGG, FAFuelEntries.NAUTILUS_EGGS, FAFuelEntries.PACHYCEPHALOSAURUS_EGG, FAFuelEntries.PTERANODON_EGG, FAFuelEntries.SPINOSAURUS_EGG, FAFuelEntries.STEGOSAURUS_EGG, FAFuelEntries.THERIZINOSAURUS_EGG, FAFuelEntries.TRICERATOPS_EGG, FAFuelEntries.TYRANNOSAURUS_EGG, FAFuelEntries.VELOCIRAPTOR_EGG, FAFuelEntries.RAW_ANKYLOSAURUS, FAFuelEntries.RAW_BRACHIOSAURUS, FAFuelEntries.RAW_CARNOTAURUS, FAFuelEntries.RAW_COMPSOGNATHUS, FAFuelEntries.RAW_CRYOLOPHOSAURUS, FAFuelEntries.RAW_DILOPHOSAURUS, FAFuelEntries.RAW_DIMETRODON, FAFuelEntries.RAW_DODO, FAFuelEntries.RAW_GALLIMIMUS, FAFuelEntries.RAW_MOA, FAFuelEntries.RAW_MAMMOTH, FAFuelEntries.RAW_MOSASAURUS, FAFuelEntries.RAW_FUTABASAURUS, FAFuelEntries.RAW_PACHYCEPHALOSAURUS, FAFuelEntries.RAW_PTERANODON, FAFuelEntries.RAW_SMILODON, FAFuelEntries.RAW_SPINOSAURUS, FAFuelEntries.RAW_STEGOSAURUS, FAFuelEntries.RAW_THERIZINOSAURUS, FAFuelEntries.RAW_TRICERATOPS, FAFuelEntries.RAW_TYRANNOSAURUS, FAFuelEntries.RAW_VELOCIRAPTOR, FAFuelEntries.PORKCHOP, FAFuelEntries.COD, FAFuelEntries.SALMON, FAFuelEntries.TROPICAL_FISH, FAFuelEntries.BEEF, FAFuelEntries.MUTTON, FAFuelEntries.RABBIT, FAFuelEntries.CHICKEN, FAFuelEntries.EGG, FAFuelEntries.SLIME_BALL, FAFuelEntries.MILK_BUCKET);
        this.tag(FAFuelEntryTags.ARCHAEOLOGY_WORKBENCH).add(FAFuelEntries.RELIC_SCRAP);
    }
}
