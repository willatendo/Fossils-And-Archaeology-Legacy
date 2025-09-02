package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import willatendo.fossilslegacy.server.tags.FABiomeTags;

import java.util.concurrent.CompletableFuture;

public class FABiomeTagProvider extends BiomeTagsProvider {
    public FABiomeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FABiomeTags.HAS_ACADEMY).add(Biomes.JUNGLE, Biomes.DESERT, Biomes.PLAINS);
        this.tag(FABiomeTags.HAS_LAB).add(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.PLAINS);
        this.tag(FABiomeTags.HAS_MACHU_PICCHU).add(Biomes.MEADOW);
        this.tag(FABiomeTags.HAS_MAYAN_TEMPLE).add(Biomes.SPARSE_JUNGLE);
        this.tag(FABiomeTags.HAS_MOAI).add(Biomes.BEACH);
        this.tag(FABiomeTags.HAS_PIRATE_SHIP).add(Biomes.OCEAN);
        this.tag(FABiomeTags.HAS_TOTEM_POLE).add(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
        this.tag(FABiomeTags.HAS_WEAPON_SHOP).add(Biomes.OCEAN, Biomes.PLAINS);
    }
}
