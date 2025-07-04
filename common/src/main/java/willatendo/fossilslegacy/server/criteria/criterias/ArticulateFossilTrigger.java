package willatendo.fossilslegacy.server.criteria.criterias;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import willatendo.fossilslegacy.server.criteria.FACriteriaTriggers;

import java.util.Optional;

public class ArticulateFossilTrigger extends SimpleCriterionTrigger<ArticulateFossilTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return ArticulateFossilTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer serverPlayer) {
        this.trigger(serverPlayer, triggerInstance -> true);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<ArticulateFossilTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player)).apply(instance, TriggerInstance::new));

        public static Criterion<ArticulateFossilTrigger.TriggerInstance> articulateFossil() {
            return FACriteriaTriggers.ARTICULATE_FOSSIL.get().createCriterion(new ArticulateFossilTrigger.TriggerInstance(Optional.empty()));
        }
    }
}
