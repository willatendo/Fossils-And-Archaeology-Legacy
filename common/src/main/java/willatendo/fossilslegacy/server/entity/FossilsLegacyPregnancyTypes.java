package willatendo.fossilslegacy.server.entity;

import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacyPregnancyTypes {
    public static final SimpleRegistry<PregnancyType> PREGNANCY_TYPES = SimpleRegistry.create(FossilsLegacyRegistries.PREGNANCY_TYPES, FossilsLegacyUtils.ID);

    public static final SimpleHolder<PregnancyType> CAT = PREGNANCY_TYPES.register("cat", () -> new PregnancyType(() -> EntityType.CAT));
    public static final SimpleHolder<PregnancyType> COW = PREGNANCY_TYPES.register("cow", () -> new PregnancyType(() -> EntityType.COW));
    public static final SimpleHolder<PregnancyType> DOLPHIN = PREGNANCY_TYPES.register("dolphin", () -> new PregnancyType(() -> EntityType.DOLPHIN));
    public static final SimpleHolder<PregnancyType> DONKEY = PREGNANCY_TYPES.register("donkey", () -> new PregnancyType(() -> EntityType.DONKEY));
    public static final SimpleHolder<PregnancyType> FOX = PREGNANCY_TYPES.register("fox", () -> new PregnancyType(() -> EntityType.FOX));
    public static final SimpleHolder<PregnancyType> GOAT = PREGNANCY_TYPES.register("goat", () -> new PregnancyType(() -> EntityType.GOAT));
    public static final SimpleHolder<PregnancyType> HORSE = PREGNANCY_TYPES.register("horse", () -> new PregnancyType(() -> EntityType.HORSE));
    public static final SimpleHolder<PregnancyType> LLAMA = PREGNANCY_TYPES.register("llama", () -> new PregnancyType(() -> EntityType.LLAMA));
    public static final SimpleHolder<PregnancyType> MULE = PREGNANCY_TYPES.register("mule", () -> new PregnancyType(() -> EntityType.MULE));
    public static final SimpleHolder<PregnancyType> OCELOT = PREGNANCY_TYPES.register("ocelot", () -> new PregnancyType(() -> EntityType.OCELOT));
    public static final SimpleHolder<PregnancyType> PANDA = PREGNANCY_TYPES.register("panda", () -> new PregnancyType(() -> EntityType.PANDA));
    public static final SimpleHolder<PregnancyType> PIG = PREGNANCY_TYPES.register("pig", () -> new PregnancyType(() -> EntityType.PIG));
    public static final SimpleHolder<PregnancyType> POLAR_BEAR = PREGNANCY_TYPES.register("polar_bear", () -> new PregnancyType(() -> EntityType.POLAR_BEAR));
    public static final SimpleHolder<PregnancyType> RABBIT = PREGNANCY_TYPES.register("rabbit", () -> new PregnancyType(() -> EntityType.RABBIT));
    public static final SimpleHolder<PregnancyType> SHEEP = PREGNANCY_TYPES.register("sheep", () -> new PregnancyType(() -> EntityType.SHEEP));
    public static final SimpleHolder<PregnancyType> WOLF = PREGNANCY_TYPES.register("wolf", () -> new PregnancyType(() -> EntityType.WOLF));
    public static final SimpleHolder<PregnancyType> MAMMOTH = PREGNANCY_TYPES.register("mammoth", () -> new PregnancyType(() -> FossilsLegacyEntityTypes.MAMMOTH.get()));
    public static final SimpleHolder<PregnancyType> SMILODON = PREGNANCY_TYPES.register("smilodon", () -> new PregnancyType(() -> FossilsLegacyEntityTypes.SMILODON.get()));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(PREGNANCY_TYPES);
    }
}
