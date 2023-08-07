package willatendo.fossilslegacy.server.criteria;

import com.google.gson.JsonObject;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.LootContext;
import willatendo.fossilslegacy.server.entity.ZombifiedPigman;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class TameZombifiedPigmanTrigger extends SimpleCriterionTrigger<TameZombifiedPigmanTrigger.TriggerInstance> {
	protected static final ResourceLocation ID = FossilsLegacyUtils.resource("tame_zombified_pigman");

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public TameZombifiedPigmanTrigger.TriggerInstance createInstance(JsonObject jsonObject, ContextAwarePredicate contextAwarePredicate, DeserializationContext deserializationContext) {
		ContextAwarePredicate contextawarePredicate = EntityPredicate.fromJson(jsonObject, "entity", deserializationContext);
		return new TameZombifiedPigmanTrigger.TriggerInstance(contextAwarePredicate, contextawarePredicate);
	}

	public void trigger(ServerPlayer serverPlayer, ZombifiedPigman zombifiedPigman) {
		LootContext lootContext = EntityPredicate.createContext(serverPlayer, zombifiedPigman);
		this.trigger(serverPlayer, (triggerInstance) -> {
			return triggerInstance.matches(lootContext);
		});
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance {
		private final ContextAwarePredicate entity;

		public TriggerInstance(ContextAwarePredicate contextAwarePredicate, ContextAwarePredicate entity) {
			super(TameZombifiedPigmanTrigger.ID, contextAwarePredicate);
			this.entity = entity;
		}

		public static TameZombifiedPigmanTrigger.TriggerInstance tamedAnimal() {
			return new TameZombifiedPigmanTrigger.TriggerInstance(ContextAwarePredicate.ANY, ContextAwarePredicate.ANY);
		}

		public static TameZombifiedPigmanTrigger.TriggerInstance tamedAnimal(EntityPredicate entityPredicate) {
			return new TameZombifiedPigmanTrigger.TriggerInstance(ContextAwarePredicate.ANY, EntityPredicate.wrap(entityPredicate));
		}

		public boolean matches(LootContext lootContext) {
			return this.entity.matches(lootContext);
		}

		@Override
		public JsonObject serializeToJson(SerializationContext serializationContext) {
			JsonObject jsonobject = super.serializeToJson(serializationContext);
			jsonobject.add("entity", this.entity.toJson(serializationContext));
			return jsonobject;
		}
	}
}