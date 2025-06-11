package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAStructureTags {
    private static final TagRegister<Structure> STRUCTURE_TAGS = TagRegister.create(Registries.STRUCTURE, FAUtils.ID);

    public static final TagKey<Structure> ICHTHYOSAURUS_LOCATED = STRUCTURE_TAGS.register("ichthyosaurus_located");
    public static final TagKey<Structure> ACADEMY = STRUCTURE_TAGS.register("academy");
    public static final TagKey<Structure> MACHU_PICCHU = STRUCTURE_TAGS.register("machu_picchu");
    public static final TagKey<Structure> MAYAN_TEMPLE = STRUCTURE_TAGS.register("mayan_temple");
    public static final TagKey<Structure> WEAPON_SHOP = STRUCTURE_TAGS.register("weapon_shop");
}
