package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import willatendo.fossilslegacy.server.gene.cosmetics.FASkinGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FASkinGeneTags;

import java.util.concurrent.CompletableFuture;

public class FASkinTagProvider extends TagsProvider<SkinGene> {
    public FASkinTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.SKIN_GENE, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FASkinGeneTags.HAS_PATTERNS).add(FASkinGenes.AMAZON_RAINFOREST, FASkinGenes.CHAMPLAIN_VALLEY, FASkinGenes.DEATH_VALLEY, FASkinGenes.GAMBIA_RIVER_BASIN, FASkinGenes.GREAT_SANDY_DESERT, FASkinGenes.LIMPOPO_RIVER, FASkinGenes.MANGROVE_FOREST, FASkinGenes.QILIAN_MOUNTAINS, FASkinGenes.SALAR_DEL_HUASCO, FASkinGenes.SONORAN_DESERT, FASkinGenes.SVALBARD, FASkinGenes.YUKON_RIVER);

        this.tag(FASkinGeneTags.ANKYLOSAURUS_2024_SKINS).add(FASkinGenes.ANKYLOSAURUS_2024, FASkinGenes.ALBINO_ANKYLOSAURUS, FASkinGenes.AMAZON_RAINFOREST, FASkinGenes.CHAMPLAIN_VALLEY, FASkinGenes.DEATH_VALLEY, FASkinGenes.GAMBIA_RIVER_BASIN, FASkinGenes.GREAT_SANDY_DESERT, FASkinGenes.LIMPOPO_RIVER, FASkinGenes.MANGROVE_FOREST, FASkinGenes.QILIAN_MOUNTAINS, FASkinGenes.SALAR_DEL_HUASCO, FASkinGenes.SONORAN_DESERT, FASkinGenes.SVALBARD, FASkinGenes.YUKON_RIVER);
        this.tag(FASkinGeneTags.BARYONYX_2025_SKINS).add(FASkinGenes.BARYONYX_2025, FASkinGenes.AMAZON_RAINFOREST, FASkinGenes.CHAMPLAIN_VALLEY, FASkinGenes.DEATH_VALLEY, FASkinGenes.GAMBIA_RIVER_BASIN, FASkinGenes.GREAT_SANDY_DESERT, FASkinGenes.LIMPOPO_RIVER, FASkinGenes.MANGROVE_FOREST, FASkinGenes.QILIAN_MOUNTAINS, FASkinGenes.SALAR_DEL_HUASCO, FASkinGenes.SONORAN_DESERT, FASkinGenes.SVALBARD, FASkinGenes.YUKON_RIVER);
        this.tag(FASkinGeneTags.BRACHIOSAURUS_2024_SKINS).add(FASkinGenes.BRACHIOSAURUS_2024, FASkinGenes.AMAZON_RAINFOREST);
        this.tag(FASkinGeneTags.BRACHIOSAURUS_2011_SKINS).add(FASkinGenes.BRACHIOSAURUS_2011);
        this.tag(FASkinGeneTags.CARNOTAURUS_2024_SKINS).add(FASkinGenes.GREEN_CARNOTAURUS_2024, FASkinGenes.RED_CARNOTAURUS_2024);
        this.tag(FASkinGeneTags.CARNOTAURUS_2011_SKINS).add(FASkinGenes.GREEN_CARNOTAURUS_2011, FASkinGenes.RED_CARNOTAURUS_2011);
        this.tag(FASkinGeneTags.COMPSOGNATHUS_2024_SKINS).add(FASkinGenes.COMPSOGNATHUS_2024);
        this.tag(FASkinGeneTags.CRYOLOPHOSAURUS_2024_SKINS).add(FASkinGenes.CRYOLOPHOSAURUS_2024);
        this.tag(FASkinGeneTags.CRYOLOPHOSAURUS_2011_SKINS).add(FASkinGenes.CRYOLOPHOSAURUS_2011);
        this.tag(FASkinGeneTags.DILOPHOSAURUS_2024_SKINS).add(FASkinGenes.DILOPHOSAURUS_2024);
        this.tag(FASkinGeneTags.DILOPHOSAURUS_2011_SKINS).add(FASkinGenes.DILOPHOSAURUS_2011);
        this.tag(FASkinGeneTags.DODO_2024_SKINS).add(FASkinGenes.DODO_2024);
        this.tag(FASkinGeneTags.DRYOSAURUS_2025_SKINS).add(FASkinGenes.DRYOSAURUS_2025);
        this.tag(FASkinGeneTags.DIMETRODON_2024_SKINS).add(FASkinGenes.DIMETRODON_2024);
        this.tag(FASkinGeneTags.DISTORTUS_REX_2025_SKINS).add(FASkinGenes.DISTORTUS_REX_2025);
        this.tag(FASkinGeneTags.ELASMOTHERIUM_2025_SKINS).add(FASkinGenes.ELASMOTHERIUM_2025);
        this.tag(FASkinGeneTags.FUTABASAURUS_2024_SKINS).add(FASkinGenes.FUTABASAURUS_2024);
        this.tag(FASkinGeneTags.FUTABASAURUS_2011_SKINS).add(FASkinGenes.FUTABASAURUS_2011);
        this.tag(FASkinGeneTags.GALLIMIMUS_2024_SKINS).add(FASkinGenes.GALLIMIMUS_2024);
        this.tag(FASkinGeneTags.ICHTHYOSAURUS_2025_SKINS).add(FASkinGenes.ICHTHYOSAURUS_2025);
        this.tag(FASkinGeneTags.ISOTELUS_2025_SKINS).add(FASkinGenes.ISOTELUS_2025);
        this.tag(FASkinGeneTags.ISOTELUS_LARVA_2025_SKINS).add(FASkinGenes.ISOTELUS_LARVA_2025);
        this.tag(FASkinGeneTags.MAMMOTH_2024_SKINS).add(FASkinGenes.MAMMOTH_2024);
        this.tag(FASkinGeneTags.MAMMOTH_2011_SKINS).add(FASkinGenes.MAMMOTH_2011);
        this.tag(FASkinGeneTags.MOA_2024_SKINS).add(FASkinGenes.MOA_2024);
        this.tag(FASkinGeneTags.MOSASAURUS_2024_SKINS).add(FASkinGenes.MOSASAURUS_2024);
        this.tag(FASkinGeneTags.MOSASAURUS_2011_SKINS).add(FASkinGenes.MOSASAURUS_2011);
        this.tag(FASkinGeneTags.PACHYCEPHALOSAURUS_2024_SKINS).add(FASkinGenes.PACHYCEPHALOSAURUS_2024);
        this.tag(FASkinGeneTags.PTERANODON_2024_SKINS).add(FASkinGenes.PTERANODON_2024);
        this.tag(FASkinGeneTags.PTERANODON_2011_SKINS).add(FASkinGenes.PTERANODON_2011);
        this.tag(FASkinGeneTags.SMILODON_2024_SKINS).add(FASkinGenes.SMILODON_2024);
        this.tag(FASkinGeneTags.SMILODON_2011_SKINS).add(FASkinGenes.SMILODON_2011);
        this.tag(FASkinGeneTags.SPINOSAURUS_2024_SKINS).add(FASkinGenes.SPINOSAURUS_2024);
        this.tag(FASkinGeneTags.STEGOSAURUS_2024_SKINS).add(FASkinGenes.STEGOSAURUS_2024);
        this.tag(FASkinGeneTags.STEGOSAURUS_2011_SKINS).add(FASkinGenes.STEGOSAURUS_2011);
        this.tag(FASkinGeneTags.THERIZINOSAURUS_2024_SKINS).add(FASkinGenes.THERIZINOSAURUS_2024);
        this.tag(FASkinGeneTags.THERIZINOSAURUS_2011_SKINS).add(FASkinGenes.FEATHERED_THERIZINOSAURUS_2011, FASkinGenes.FEATHERLESS_THERIZINOSAURUS_2011);
        this.tag(FASkinGeneTags.TRICERATOPS_2024_SKINS).add(FASkinGenes.BROWN_TRICERATOPS_2024, FASkinGenes.GREEN_TRICERATOPS_2024);
        this.tag(FASkinGeneTags.TRICERATOPS_2011_SKINS).add(FASkinGenes.BROWN_TRICERATOPS_2011, FASkinGenes.GREEN_TRICERATOPS_2011);
        this.tag(FASkinGeneTags.TYRANNOSAURUS_2024_SKINS).add(FASkinGenes.TYRANNOSAURUS_2024);
        this.tag(FASkinGeneTags.TYRANNOSAURUS_2011_SKINS).add(FASkinGenes.TYRANNOSAURUS_2011);
        this.tag(FASkinGeneTags.VELOCIRAPTOR_2024_SKINS).add(FASkinGenes.GREEN_VELOCIRAPTOR_2024, FASkinGenes.SANDY_VELOCIRAPTOR_2024, FASkinGenes.WHITE_VELOCIRAPTOR_2024);
        this.tag(FASkinGeneTags.VELOCIRAPTOR_2011_SKINS).add(FASkinGenes.GREEN_VELOCIRAPTOR_2011, FASkinGenes.SANDY_VELOCIRAPTOR_2011, FASkinGenes.WHITE_VELOCIRAPTOR_2011);
    }
}
