package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyStructureTags {
    private static final TagRegister<Structure> STRUCTURE_TAGS = TagRegister.create(Registries.STRUCTURE, FossilsLegacyUtils.ID);

    public static final TagKey<Structure> MAYAN_TEMPLE = STRUCTURE_TAGS.register("mayan_temple");
}
