package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.RaidHeroGift;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyVillagerProfessions;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyDataMapProvider extends DataMapProvider {
    public FossilsLegacyDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.COMPOSTABLES).add(FossilsLegacyBlocks.JURASSIC_FERN.get().asItem().builtInRegistryHolder(), new Compostable(0.65F), false).add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get().builtInRegistryHolder(), new Compostable(0.65F), false).add(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get().asItem().builtInRegistryHolder(), new Compostable(0.3F), false).add(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get().asItem().builtInRegistryHolder(), new Compostable(0.3F), false).add(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get().asItem().builtInRegistryHolder(), new Compostable(0.3F), false).add(FossilsLegacyBlocks.SIGILLARIA_SAPLING.get().asItem().builtInRegistryHolder(), new Compostable(0.3F), false).add(FossilsLegacyBlocks.CALAMITES_LEAVES.get().asItem().builtInRegistryHolder(), new Compostable(0.3F), false).add(FossilsLegacyBlocks.CALAMITES_SAPLING.get().asItem().builtInRegistryHolder(), new Compostable(0.3F), false);
        this.builder(NeoForgeDataMaps.RAID_HERO_GIFTS).add(FossilsLegacyVillagerProfessions.ARCHAEOLOGIST.getKey(), new RaidHeroGift(FossilsLegacyLootTables.ARCHAEOLOGIST_GIFT), false).add(FossilsLegacyVillagerProfessions.PALAEONTOLOGIST.getKey(), new RaidHeroGift(FossilsLegacyLootTables.PALAEONTOLOGIST_GIFT), false);
    }
}
