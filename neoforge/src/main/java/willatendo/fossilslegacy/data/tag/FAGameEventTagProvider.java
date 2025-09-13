package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.GameEventTagsProvider;
import net.minecraft.tags.GameEventTags;
import net.minecraft.world.level.biome.Biomes;
import willatendo.fossilslegacy.server.block.FAGameEvents;
import willatendo.fossilslegacy.server.tags.FABiomeTags;

import java.util.concurrent.CompletableFuture;

public class FAGameEventTagProvider extends GameEventTagsProvider {
    public FAGameEventTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(GameEventTags.VIBRATIONS).add(FAGameEvents.CULTIVATOR_SHATTER.getKey());
        this.tag(GameEventTags.WARDEN_CAN_LISTEN).add(FAGameEvents.CULTIVATOR_SHATTER.getKey());
    }
}
