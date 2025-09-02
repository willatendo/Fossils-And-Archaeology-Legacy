package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.level.levelgen.structure.Structure;
import willatendo.fossilslegacy.server.structure.FAStructures;
import willatendo.fossilslegacy.server.tags.FAStructureTags;

import java.util.concurrent.CompletableFuture;

public class FAStructureTagProvider extends StructureTagsProvider {
    public FAStructureTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(packOutput, registries, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(FAStructureTags.ICHTHYOSAURUS_LOCATED).addTag(StructureTags.OCEAN_RUIN).addTag(StructureTags.SHIPWRECK);
        this.tag(FAStructureTags.ACADEMY).add(FAStructures.ACADEMY);
        this.tag(FAStructureTags.MACHU_PICCHU).add(FAStructures.MACHU_PICCHU);
        this.tag(FAStructureTags.MAYAN_TEMPLE).add(FAStructures.SMALL_MAYAN_TEMPLE, FAStructures.MAYAN_CITY);
        this.tag(FAStructureTags.WEAPON_SHOP).add(FAStructures.WEAPON_SHOP);
    }
}
