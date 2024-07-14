package willatendo.fossilslegacy.server.criteria;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyCriteriaTriggers {
    public static final SimpleRegistry<CriterionTrigger<?>> TRIGGER_TYPES = SimpleRegistry.create(Registries.TRIGGER_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<AnuOnEarthTrigger> ANU_ON_EARTH = TRIGGER_TYPES.register("anu_on_earth", () -> new AnuOnEarthTrigger());
    public static final SimpleHolder<CreateZombifiedPigmanTrigger> CREATE_ZOMBIFIED_PIGMAN = TRIGGER_TYPES.register("create_zombified_pigman", () -> new CreateZombifiedPigmanTrigger());
    public static final SimpleHolder<SummonAnuTrigger> SUMMON_ANU = TRIGGER_TYPES.register("summon_anu", () -> new SummonAnuTrigger());
    public static final SimpleHolder<TameZombifiedPigmanTrigger> TAME_ZOMBIFIED_PIGMAN = TRIGGER_TYPES.register("tame_zombified_pigman", () -> new TameZombifiedPigmanTrigger());
}
