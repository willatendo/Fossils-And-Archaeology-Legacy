package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructures;
import willatendo.fossilslegacy.server.tags.FossilsLegacyStructureTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyStructureTagProvider extends DataDrivenTagsProvider<Structure> {
    public FossilsLegacyStructureTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, Registries.STRUCTURE, registries, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(FossilsLegacyStructureTags.MAYAN_TEMPLE).add(FossilsLegacyStructures.SMALL_MAYAN_TEMPLE);
    }
}
