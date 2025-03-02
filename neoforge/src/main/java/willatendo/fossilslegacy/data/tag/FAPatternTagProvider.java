package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternTags;

import java.util.concurrent.CompletableFuture;

public class FAPatternTagProvider extends DataDrivenTagsProvider<Pattern> {
    public FAPatternTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.PATTERN, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAPatternTags.ANKYLOSAURUS_2024).add(FAPatterns.ANKYLOSAURUS_2024);
        this.tag(FAPatternTags.BRACHIOSAURUS_2024).add(FAPatterns.BRACHIOSAURUS_2024);
        this.tag(FAPatternTags.BRACHIOSAURUS_2011).add(FAPatterns.BRACHIOSAURUS_2011);
        this.tag(FAPatternTags.CARNOTAURUS_2024).add(FAPatterns.GREEN_CARNOTAURUS_2024, FAPatterns.RED_CARNOTAURUS_2024);
        this.tag(FAPatternTags.CARNOTAURUS_2011).add(FAPatterns.GREEN_CARNOTAURUS_2011, FAPatterns.RED_CARNOTAURUS_2011);
        this.tag(FAPatternTags.COMPSOGNATHUS_2024).add(FAPatterns.COMPSOGNATHUS_2024);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2024).add(FAPatterns.CRYOLOPHOSAURUS_2024);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2011).add(FAPatterns.CRYOLOPHOSAURUS_2011);
        this.tag(FAPatternTags.DILOPHOSAURUS_2024).add(FAPatterns.DILOPHOSAURUS_2024);
        this.tag(FAPatternTags.DILOPHOSAURUS_2011).add(FAPatterns.DILOPHOSAURUS_2011);
        this.tag(FAPatternTags.DODO_2024).add(FAPatterns.DODO_2024);
        this.tag(FAPatternTags.DIMETRODON_2024).add(FAPatterns.DIMETRODON_2024);
        this.tag(FAPatternTags.FUTABASAURUS_2024).add(FAPatterns.FUTABASAURUS_2024);
        this.tag(FAPatternTags.FUTABASAURUS_2011).add(FAPatterns.FUTABASAURUS_2011);
        this.tag(FAPatternTags.GALLIMIMUS_2024).add(FAPatterns.GALLIMIMUS_2024);
        this.tag(FAPatternTags.ICHTHYOSAURUS_2025).add(FAPatterns.ICHTHYOSAURUS_2025);
        this.tag(FAPatternTags.MAMMOTH_2024).add(FAPatterns.MAMMOTH_2024);
        this.tag(FAPatternTags.MAMMOTH_2011).add(FAPatterns.MAMMOTH_2011);
        this.tag(FAPatternTags.MOA_2024).add(FAPatterns.MOA_2024);
        this.tag(FAPatternTags.MOSASAURUS_2024).add(FAPatterns.MOSASAURUS_2024);
        this.tag(FAPatternTags.MOSASAURUS_2011).add(FAPatterns.MOSASAURUS_2011);
        this.tag(FAPatternTags.PACHYCEPHALOSAURUS_2024).add(FAPatterns.PACHYCEPHALOSAURUS_2024);
        this.tag(FAPatternTags.PTERANODON_2024).add(FAPatterns.PTERANODON_2024);
        this.tag(FAPatternTags.PTERANODON_2011).add(FAPatterns.PTERANODON_2011);
        this.tag(FAPatternTags.SMILODON_2024).add(FAPatterns.SMILODON_2024);
        this.tag(FAPatternTags.SMILODON_2011).add(FAPatterns.SMILODON_2011);
        this.tag(FAPatternTags.SPINOSAURUS_2024).add(FAPatterns.SPINOSAURUS_2024);
        this.tag(FAPatternTags.STEGOSAURUS_2024).add(FAPatterns.STEGOSAURUS_2024);
        this.tag(FAPatternTags.STEGOSAURUS_2011).add(FAPatterns.STEGOSAURUS_2011);
        this.tag(FAPatternTags.THERIZINOSAURUS_2024).add(FAPatterns.THERIZINOSAURUS_2024);
        this.tag(FAPatternTags.THERIZINOSAURUS_2011).add(FAPatterns.FEATHERED_THERIZINOSAURUS_2011, FAPatterns.FEATHERLESS_THERIZINOSAURUS_2011);
        this.tag(FAPatternTags.TRICERATOPS_2024).add(FAPatterns.BROWN_TRICERATOPS_2024, FAPatterns.GREEN_TRICERATOPS_2024);
        this.tag(FAPatternTags.TRICERATOPS_2011).add(FAPatterns.BROWN_TRICERATOPS_2011, FAPatterns.GREEN_TRICERATOPS_2011);
        this.tag(FAPatternTags.TYRANNOSAURUS_2024).add(FAPatterns.TYRANNOSAURUS_2024);
        this.tag(FAPatternTags.TYRANNOSAURUS_2011).add(FAPatterns.TYRANNOSAURUS_2011);
        this.tag(FAPatternTags.VELOCIRAPTOR_2024).add(FAPatterns.GREEN_VELOCIRAPTOR_2024, FAPatterns.SANDY_VELOCIRAPTOR_2024, FAPatterns.WHITE_VELOCIRAPTOR_2024);
        this.tag(FAPatternTags.VELOCIRAPTOR_2011).add(FAPatterns.GREEN_VELOCIRAPTOR_2011, FAPatterns.SANDY_VELOCIRAPTOR_2011, FAPatterns.WHITE_VELOCIRAPTOR_2011);
    }
}
