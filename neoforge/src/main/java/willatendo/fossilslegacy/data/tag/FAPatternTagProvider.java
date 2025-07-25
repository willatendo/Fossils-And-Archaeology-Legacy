package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternTags;

import java.util.concurrent.CompletableFuture;

public class FAPatternTagProvider extends DataDrivenTagsProvider<Pattern> {
    public FAPatternTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.PATTERN, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FAPatternTags.HAS_PATTERNS).add(FAPatterns.AMAZON_RAINFOREST, FAPatterns.CHAMPLAIN_VALLEY, FAPatterns.DEATH_VALLEY, FAPatterns.GAMBIA_RIVER_BASIN, FAPatterns.GREAT_SANDY_DESERT, FAPatterns.LIMPOPO_RIVER, FAPatterns.MANGROVE_FOREST, FAPatterns.QILIAN_MOUNTAINS, FAPatterns.SALAR_DEL_HUASCO, FAPatterns.SONORAN_DESERT, FAPatterns.SVALBARD, FAPatterns.YUKON_RIVER);

        this.tag(FAPatternTags.ANKYLOSAURUS_2024_SKINS).add(FAPatterns.ANKYLOSAURUS_2024, FAPatterns.AMAZON_RAINFOREST, FAPatterns.CHAMPLAIN_VALLEY, FAPatterns.DEATH_VALLEY, FAPatterns.GAMBIA_RIVER_BASIN, FAPatterns.GREAT_SANDY_DESERT, FAPatterns.LIMPOPO_RIVER, FAPatterns.MANGROVE_FOREST, FAPatterns.QILIAN_MOUNTAINS, FAPatterns.SALAR_DEL_HUASCO, FAPatterns.SONORAN_DESERT, FAPatterns.SVALBARD, FAPatterns.YUKON_RIVER);
        this.tag(FAPatternTags.ANKYLOSAURUS_2024_PATTERNS).add(FAPatterns.BLANK, FAPatterns.CHALCORANA, FAPatterns.LITHOBATES, FAPatterns.PAPURANA, FAPatterns.PELOPHYLAX, FAPatterns.PULCHRANA, FAPatterns.RANA);
        this.tag(FAPatternTags.BARYONYX_2025_SKINS).add(FAPatterns.BARYONYX_2025);
        this.tag(FAPatternTags.BARYONYX_2025_PATTERNS);
        this.tag(FAPatternTags.BRACHIOSAURUS_2024_SKINS).add(FAPatterns.BRACHIOSAURUS_2024);
        this.tag(FAPatternTags.BRACHIOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.BRACHIOSAURUS_2011_SKINS).add(FAPatterns.BRACHIOSAURUS_2011);
        this.tag(FAPatternTags.BRACHIOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.CARNOTAURUS_2024_SKINS).add(FAPatterns.GREEN_CARNOTAURUS_2024, FAPatterns.RED_CARNOTAURUS_2024);
        this.tag(FAPatternTags.CARNOTAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.CARNOTAURUS_2011_SKINS).add(FAPatterns.GREEN_CARNOTAURUS_2011, FAPatterns.RED_CARNOTAURUS_2011);
        this.tag(FAPatternTags.CARNOTAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.COMPSOGNATHUS_2024_SKINS).add(FAPatterns.COMPSOGNATHUS_2024);
        this.tag(FAPatternTags.COMPSOGNATHUS_2024_PATTERNS);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2024_SKINS).add(FAPatterns.CRYOLOPHOSAURUS_2024);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2011_SKINS).add(FAPatterns.CRYOLOPHOSAURUS_2011);
        this.tag(FAPatternTags.CRYOLOPHOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.DILOPHOSAURUS_2024_SKINS).add(FAPatterns.DILOPHOSAURUS_2024);
        this.tag(FAPatternTags.DILOPHOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.DILOPHOSAURUS_2011_SKINS).add(FAPatterns.DILOPHOSAURUS_2011);
        this.tag(FAPatternTags.DILOPHOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.DODO_2024_SKINS).add(FAPatterns.DODO_2024);
        this.tag(FAPatternTags.DODO_2024_PATTERNS);
        this.tag(FAPatternTags.DRYOSAURUS_2025_SKINS).add(FAPatterns.DRYOSAURUS_2025);
        this.tag(FAPatternTags.DRYOSAURUS_2025_PATTERNS);
        this.tag(FAPatternTags.DIMETRODON_2024_SKINS).add(FAPatterns.DIMETRODON_2024);
        this.tag(FAPatternTags.DIMETRODON_2024_PATTERNS);
        this.tag(FAPatternTags.DISTORTUS_REX_2025_SKINS).add(FAPatterns.DISTORTUS_REX_2025);
        this.tag(FAPatternTags.DISTORTUS_REX_2025_PATTERNS);
        this.tag(FAPatternTags.ELASMOTHERIUM_2025_SKINS).add(FAPatterns.ELASMOTHERIUM_2025);
        this.tag(FAPatternTags.ELASMOTHERIUM_2025_PATTERNS);
        this.tag(FAPatternTags.FUTABASAURUS_2024_SKINS).add(FAPatterns.FUTABASAURUS_2024);
        this.tag(FAPatternTags.FUTABASAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.FUTABASAURUS_2011_SKINS).add(FAPatterns.FUTABASAURUS_2011);
        this.tag(FAPatternTags.FUTABASAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.GALLIMIMUS_2024_SKINS).add(FAPatterns.GALLIMIMUS_2024);
        this.tag(FAPatternTags.GALLIMIMUS_2024_PATTERNS);
        this.tag(FAPatternTags.ICHTHYOSAURUS_2025_SKINS).add(FAPatterns.ICHTHYOSAURUS_2025);
        this.tag(FAPatternTags.ICHTHYOSAURUS_2025_PATTERNS);
        this.tag(FAPatternTags.ISOTELUS_2025_SKINS).add(FAPatterns.ISOTELUS_2025);
        this.tag(FAPatternTags.ISOTELUS_2025_PATTERNS);
        this.tag(FAPatternTags.ISOTELUS_LARVA_2025_SKINS).add(FAPatterns.ISOTELUS_LARVA_2025);
        this.tag(FAPatternTags.ISOTELUS_LARVA_2025_PATTERNS);
        this.tag(FAPatternTags.MAMMOTH_2024_SKINS).add(FAPatterns.MAMMOTH_2024);
        this.tag(FAPatternTags.MAMMOTH_2024_PATTERNS);
        this.tag(FAPatternTags.MAMMOTH_2011_SKINS).add(FAPatterns.MAMMOTH_2011);
        this.tag(FAPatternTags.MAMMOTH_2011_PATTERNS);
        this.tag(FAPatternTags.MOA_2024_SKINS).add(FAPatterns.MOA_2024);
        this.tag(FAPatternTags.MOA_2024_PATTERNS);
        this.tag(FAPatternTags.MOSASAURUS_2024_SKINS).add(FAPatterns.MOSASAURUS_2024);
        this.tag(FAPatternTags.MOSASAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.MOSASAURUS_2011_SKINS).add(FAPatterns.MOSASAURUS_2011);
        this.tag(FAPatternTags.MOSASAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.PACHYCEPHALOSAURUS_2024_SKINS).add(FAPatterns.PACHYCEPHALOSAURUS_2024);
        this.tag(FAPatternTags.PACHYCEPHALOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.PTERANODON_2024_SKINS).add(FAPatterns.PTERANODON_2024);
        this.tag(FAPatternTags.PTERANODON_2024_PATTERNS);
        this.tag(FAPatternTags.PTERANODON_2011_SKINS).add(FAPatterns.PTERANODON_2011);
        this.tag(FAPatternTags.PTERANODON_2011_PATTERNS);
        this.tag(FAPatternTags.SMILODON_2024_SKINS).add(FAPatterns.SMILODON_2024);
        this.tag(FAPatternTags.SMILODON_2024_PATTERNS);
        this.tag(FAPatternTags.SMILODON_2011_SKINS).add(FAPatterns.SMILODON_2011);
        this.tag(FAPatternTags.SMILODON_2011_PATTERNS);
        this.tag(FAPatternTags.SPINOSAURUS_2024_SKINS).add(FAPatterns.SPINOSAURUS_2024);
        this.tag(FAPatternTags.SPINOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.STEGOSAURUS_2024_SKINS).add(FAPatterns.STEGOSAURUS_2024);
        this.tag(FAPatternTags.STEGOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.STEGOSAURUS_2011_SKINS).add(FAPatterns.STEGOSAURUS_2011);
        this.tag(FAPatternTags.STEGOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.THERIZINOSAURUS_2024_SKINS).add(FAPatterns.THERIZINOSAURUS_2024);
        this.tag(FAPatternTags.THERIZINOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.THERIZINOSAURUS_2011_SKINS).add(FAPatterns.FEATHERED_THERIZINOSAURUS_2011, FAPatterns.FEATHERLESS_THERIZINOSAURUS_2011);
        this.tag(FAPatternTags.THERIZINOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.TRICERATOPS_2024_SKINS).add(FAPatterns.BROWN_TRICERATOPS_2024, FAPatterns.GREEN_TRICERATOPS_2024);
        this.tag(FAPatternTags.TRICERATOPS_2024_PATTERNS);
        this.tag(FAPatternTags.TRICERATOPS_2011_SKINS).add(FAPatterns.BROWN_TRICERATOPS_2011, FAPatterns.GREEN_TRICERATOPS_2011);
        this.tag(FAPatternTags.TRICERATOPS_2011_PATTERNS);
        this.tag(FAPatternTags.TYRANNOSAURUS_2024_SKINS).add(FAPatterns.TYRANNOSAURUS_2024);
        this.tag(FAPatternTags.TYRANNOSAURUS_2024_PATTERNS);
        this.tag(FAPatternTags.TYRANNOSAURUS_2011_SKINS).add(FAPatterns.TYRANNOSAURUS_2011);
        this.tag(FAPatternTags.TYRANNOSAURUS_2011_PATTERNS);
        this.tag(FAPatternTags.VELOCIRAPTOR_2024_SKINS).add(FAPatterns.GREEN_VELOCIRAPTOR_2024, FAPatterns.SANDY_VELOCIRAPTOR_2024, FAPatterns.WHITE_VELOCIRAPTOR_2024);
        this.tag(FAPatternTags.VELOCIRAPTOR_2024_PATTERNS);
        this.tag(FAPatternTags.VELOCIRAPTOR_2011_SKINS).add(FAPatterns.GREEN_VELOCIRAPTOR_2011, FAPatterns.SANDY_VELOCIRAPTOR_2011, FAPatterns.WHITE_VELOCIRAPTOR_2011);
        this.tag(FAPatternTags.VELOCIRAPTOR_2011_PATTERNS);
    }
}
