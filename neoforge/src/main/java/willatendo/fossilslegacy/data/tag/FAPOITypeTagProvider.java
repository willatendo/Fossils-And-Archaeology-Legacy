package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.entity.FAPoiTypes;

import java.util.concurrent.CompletableFuture;

public class FAPOITypeTagProvider extends PoiTypeTagsProvider {
    public FAPOITypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(FAPoiTypes.ARCHAEOLOGIST, FAPoiTypes.PALAEONTOLOGIST);
    }
}
