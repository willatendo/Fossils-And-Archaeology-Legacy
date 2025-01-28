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
import willatendo.fossilslegacy.server.entity.entities.TamedZombifiedPiglin;

import java.util.Optional;

public class TameZombifiedPigmanTrigger extends SimpleCriterionTrigger<TameZombifiedPigmanTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer serverPlayer, TamedZombifiedPiglin zombifiedPigman) {
        LootContext lootContext = EntityPredicate.createContext(serverPlayer, zombifiedPigman);
        this.trigger(serverPlayer, (triggerInstance) -> triggerInstance.matches(lootContext));
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player,
                                  Optional<ContextAwarePredicate> entity) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(triggerInstance -> triggerInstance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player), EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("entity").forGetter(TriggerInstance::entity)).apply(triggerInstance, TriggerInstance::new));

        public static Criterion<TriggerInstance> tamedZombifiedPiglin() {
            return FLCriteriaTriggers.TAME_ZOMBIFIED_PIGMAN.get().createCriterion(new TriggerInstance(Optional.empty(), Optional.empty()));
        }

        public static Criterion<TriggerInstance> tamedZombifiedPiglin(EntityPredicate.Builder builder) {
            return FLCriteriaTriggers.TAME_ZOMBIFIED_PIGMAN.get().createCriterion(new TriggerInstance(Optional.empty(), Optional.of(EntityPredicate.wrap(builder))));
        }

        public boolean matches(LootContext lootContext) {
            return this.entity.isEmpty() || this.entity.get().matches(lootContext);
        }

        @Override
        public void validate(CriterionValidator criterionValidator) {
            SimpleCriterionTrigger.SimpleInstance.super.validate(criterionValidator);
            criterionValidator.validateEntity(this.entity, ".entity");
        }
    }
}
