package willatendo.fossilslegacy.server.config.cloth;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.*;

@Config(name = FossilsLegacyUtils.ID)
@Config.Gui.Background("minecraft:textures/block/dirt.png")
@Config.Gui.CategoryBackground(category = "common", background = "minecraft:textures/block/stone.png")
@Config.Gui.CategoryBackground(category = "server", background = "minecraft:textures/block/deepslate.png")
public class FossilsLegacyConfig extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.TransitiveObject
    public Client client = new Client();
    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject
    public Common common = new Common();

    @Config(name = "client")
    public static final class Client implements ConfigData {
        @Comment("If true, some dinosaurs will have feathers")
        private boolean featheredDinosaurs = FEATHERED_DINOSAURUS;

        public boolean featheredDinosaurs() {
            return this.featheredDinosaurs;
        }
    }

    @Config(name = "common")
    public static final class Common implements ConfigData {
        @Comment("If true, animals will starve")
        private boolean animalsStarve = SHOULD_ANU_SPAWN;

        @Comment("If true, some animals will be able to break blocks")
        private boolean animalsBreakBlocks = WILL_ANIMALS_BREAK_BLOCKS;

        @Comment("If true, animals will grow")
        private boolean animalsGrow = WILL_ANIMALS_GROW;

        @Comment("If true, anu will spawn once in the nether")
        private boolean anuSpawns = WILL_ANIMALS_STARVE;

        public boolean willAnimalsStarve() {
            return this.animalsStarve;
        }

        public boolean willAnimalsBreakBlocks() {
            return this.animalsBreakBlocks;
        }

        public boolean willAnimalsGrow() {
            return this.animalsGrow;
        }

        public boolean shouldAnuSpawn() {
            return this.anuSpawns;
        }
    }
}
