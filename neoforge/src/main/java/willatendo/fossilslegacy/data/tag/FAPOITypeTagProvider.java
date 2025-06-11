package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import willatendo.fossilslegacy.server.entity.FAPoiTypes;

import java.util.concurrent.CompletableFuture;

public class FAPOITypeTagProvider extends PoiTypeTagsProvider {
    public FAPOITypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(FAPoiTypes.ARCHAEOLOGIST, FAPoiTypes.PALAEONTOLOGIST);
    }
}
