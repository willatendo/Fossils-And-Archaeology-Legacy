package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyDataMapProvider extends DataMapProvider {
    public FossilsLegacyDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.COMPOSTABLES).add(FossilsLegacyBlocks.JURASSIC_FERN.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false).add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get().builtInRegistryHolder(), new Compostable(0.65F), false);
    }
}
