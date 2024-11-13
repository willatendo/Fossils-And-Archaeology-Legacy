package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.tags.FossilsLegacyBiomeTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyBiomeTagProvider extends BiomeTagsProvider {
    public FossilsLegacyBiomeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FossilsLegacyBiomeTags.HAS_ACADEMY).add(Biomes.JUNGLE, Biomes.DESERT, Biomes.PLAINS);
        this.tag(FossilsLegacyBiomeTags.HAS_MAYAN_TEMPLE).add(Biomes.SPARSE_JUNGLE);
        this.tag(FossilsLegacyBiomeTags.HAS_MOAI).add(Biomes.BEACH);
        this.tag(FossilsLegacyBiomeTags.HAS_TOTEM_POLE).add(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
        this.tag(FossilsLegacyBiomeTags.HAS_WEAPON_SHOP).add(Biomes.OCEAN, Biomes.PLAINS);
    }
}
