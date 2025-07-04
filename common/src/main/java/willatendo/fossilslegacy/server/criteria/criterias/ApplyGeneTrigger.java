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

public class ApplyGeneTrigger extends SimpleCriterionTrigger<ApplyGeneTrigger.TriggerInstance> {
    @Override
    public Codec<ApplyGeneTrigger.TriggerInstance> codec() {
        return ApplyGeneTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer serverPlayer) {
        this.trigger(serverPlayer, triggerInstance -> true);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<ApplyGeneTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(ApplyGeneTrigger.TriggerInstance::player)).apply(instance, ApplyGeneTrigger.TriggerInstance::new));

        public static Criterion<ApplyGeneTrigger.TriggerInstance> applyGene() {
            return FACriteriaTriggers.APPLY_GENE.get().createCriterion(new ApplyGeneTrigger.TriggerInstance(Optional.empty()));
        }
    }
}
