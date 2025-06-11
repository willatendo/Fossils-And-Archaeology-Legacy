package willatendo.fossilslegacy.server.criteria.criterias;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.CriterionValidator;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.LootContext;
import willatendo.fossilslegacy.server.criteria.FLCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.entities.Anu;

import java.util.Optional;

public class SummonAnuTrigger extends SimpleCriterionTrigger<SummonAnuTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer serverPlayer, Anu anu) {
        LootContext lootContext = EntityPredicate.createContext(serverPlayer, anu);
        this.trigger(serverPlayer, (triggerInstance) -> triggerInstance.matches(lootContext));
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player, Optional<ContextAwarePredicate> entity) implements SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(triggerInstance -> {
            return triggerInstance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player), EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("entity").forGetter(TriggerInstance::entity)).apply(triggerInstance, TriggerInstance::new);
        });

        public static Criterion<TriggerInstance> summonAnu() {
            return FLCriteriaTriggers.SUMMON_ANU.get().createCriterion(new TriggerInstance(Optional.empty(), Optional.empty()));
        }

        public boolean matches(LootContext lootContext) {
            return this.entity.isEmpty() || this.entity.get().matches(lootContext);
        }

        @Override
        public void validate(CriterionValidator criterionValidator) {
            SimpleInstance.super.validate(criterionValidator);
            criterionValidator.validateEntity(this.entity, ".entity");
        }
    }
}
