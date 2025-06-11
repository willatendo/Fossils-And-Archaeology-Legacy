package willatendo.fossilslegacy.server.level;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.dimension.FALevelStems;

public final class FALevels {
    public static final ResourceKey<Level> PREHISTORY = Registries.levelStemToLevel(FALevelStems.PREHISTORY);
}
