package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.decoration_plaque_type.FADecorationPlaqueTypes;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FADecorationPlaqueTypeTags;

import java.util.concurrent.CompletableFuture;

public class FADecorationPlaqueTypeTagProvider extends DataDrivenTagsProvider<DecorationPlaqueType> {
    public FADecorationPlaqueTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, FARegistries.DECORATION_PLAQUE_TYPE, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(FADecorationPlaqueTypeTags.PLACEABLE).add(
                FADecorationPlaqueTypes.CARNIVORE,
                FADecorationPlaqueTypes.DOWN,
                FADecorationPlaqueTypes.HERBIVORE,
                FADecorationPlaqueTypes.LEFT,
                FADecorationPlaqueTypes.LEFT_AND_RIGHT,
                FADecorationPlaqueTypes.RIGHT,
                FADecorationPlaqueTypes.RIGHT_AND_LEFT,
                FADecorationPlaqueTypes.UP
        );
    }
}
