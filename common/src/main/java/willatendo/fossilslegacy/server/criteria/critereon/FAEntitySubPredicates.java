package willatendo.fossilslegacy.server.criteria.critereon;

import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.core.registries.Registries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FAEntitySubPredicates {
    public static final SimpleRegistry<MapCodec<? extends EntitySubPredicate>> ENTITY_SUB_PREDICATES = SimpleRegistry.create(Registries.ENTITY_SUB_PREDICATE_TYPE, FAUtils.ID);

    public static final SimpleHolder<MapCodec<MammothPredicate>> MAMMOTH = ENTITY_SUB_PREDICATES.register("mammoth", () -> MammothPredicate.CODEC);
}
