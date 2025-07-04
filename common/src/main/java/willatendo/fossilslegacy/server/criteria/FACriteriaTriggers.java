package willatendo.fossilslegacy.server.criteria;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.criteria.criterias.*;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FACriteriaTriggers {
    public static final SimpleRegistry<CriterionTrigger<?>> TRIGGER_TYPES = SimpleRegistry.create(Registries.TRIGGER_TYPE, FAUtils.ID);

    public static final SimpleHolder<AnuOnEarthTrigger> ANU_ON_EARTH = TRIGGER_TYPES.register("anu_on_earth", AnuOnEarthTrigger::new);
    public static final SimpleHolder<ApplyGeneTrigger> APPLY_GENE = TRIGGER_TYPES.register("apply_gene", ApplyGeneTrigger::new);
    public static final SimpleHolder<ArticulateFossilTrigger> ARTICULATE_FOSSIL = TRIGGER_TYPES.register("articulate_fossil", ArticulateFossilTrigger::new);
    public static final SimpleHolder<CreateZombifiedPigmanTrigger> CREATE_ZOMBIFIED_PIGMAN = TRIGGER_TYPES.register("create_zombified_pigman", CreateZombifiedPigmanTrigger::new);
    public static final SimpleHolder<SummonAnuTrigger> SUMMON_ANU = TRIGGER_TYPES.register("summon_anu", SummonAnuTrigger::new);
    public static final SimpleHolder<TameZombifiedPigmanTrigger> TAME_ZOMBIFIED_PIGMAN = TRIGGER_TYPES.register("tame_zombified_pigman", TameZombifiedPigmanTrigger::new);
}
