package willatendo.fossilslegacy.server.registry;

import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.json_model.JsonModelType;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLineType;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.simplelibrary.server.util.SimpleRegistryBuilder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class FABuiltInRegistries {
    public static final Registry<CommandType> COMMAND_TYPES = SimpleUtils.createRegistry(FARegistries.COMMAND_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<DinopediaLineType<?>> DINOPEDIA_LINE_TYPES = SimpleUtils.createRegistry(FARegistries.DINOPEDIA_LINE_TYPE, SimpleRegistryBuilder.of().sync());
    public static final Registry<EggVariant> EGG_VARIANTS = SimpleUtils.createRegistry(FARegistries.EGG_VARIANTS, SimpleRegistryBuilder.of().sync());
    public static final Registry<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FARegistries.PREGNANCY_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<JsonModelType<?>> JSON_MODEL_TYPES = SimpleUtils.createRegistry(FARegistries.JSON_MODEL_TYPE, SimpleRegistryBuilder.of().sync());

    public static void init() {
    }
}
