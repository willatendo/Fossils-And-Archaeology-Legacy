package willatendo.fossilslegacy.server.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import willatendo.fossilslegacy.server.item.MagicConchItem;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.List;
import java.util.function.Consumer;

public class LootOneItemOfManyRandom extends LootPoolSingletonContainer {
	public static final Codec<LootOneItemOfManyRandom> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("max_weight").orElse(100).forGetter(lootOneItemOfManyRandom -> lootOneItemOfManyRandom.maxWeight), Codec.list(ItemAndChance.CODEC).fieldOf("results").forGetter(lootOneItemOfManyRandom -> lootOneItemOfManyRandom.itemAndChances)).and(LootItem.singletonFields(instance)).apply(instance, LootOneItemOfManyRandom::new));
	private final List<ItemAndChance> itemAndChances;
	private final int maxWeight;

	private LootOneItemOfManyRandom(int maxWeight, List<ItemAndChance> itemAndChances, int weight, int quaility, List<LootItemCondition> conditions, List<LootItemFunction> compositeFunction) {
		super(weight, quaility, conditions, compositeFunction);
		this.itemAndChances = itemAndChances;
		this.maxWeight = maxWeight;
	}

	@Override
	protected void createItemStack(Consumer<ItemStack> consumer, LootContext lootContext) {
		int random = lootContext.getRandom().nextInt(this.maxWeight);
		for (ItemAndChance itemAndChance : this.itemAndChances) {
			if (itemAndChance.lowWeight() <= random && random < itemAndChance.highWeight()) {
				ItemStack itemStack = new ItemStack(itemAndChance.item());
				if (itemStack.getItem() instanceof MagicConchItem magicConchItem) {
					MagicConchItem.setOrder(itemStack, DinosaurCommand.getRandom());
				}
				consumer.accept(itemStack);
				break;
			}
		}
	}

	@Override
	public LootPoolEntryType getType() {
		return FossilsLegacyLootPoolEntryTypes.LOOT_ONE_ITEM_OF_MANY_RANDOM.get();
	}

	public static LootPoolSingletonContainer.Builder<?> lootTableItem(int maxWeight, ItemAndChance... itemAndChances) {
		return LootItem.simpleBuilder((i, j, list, list2) -> new LootOneItemOfManyRandom(maxWeight, SimpleUtils.toList(itemAndChances), i, j, list, list2));
	}

	public static record ItemAndChance(Holder<Item> item, int lowWeight, int highWeight) {
		public ItemAndChance(ItemLike itemLike, int lowWeight, int highWeight) {
			this(itemLike.asItem().builtInRegistryHolder(), lowWeight, highWeight);
		}

		private static final Codec<ItemAndChance> CODEC = RecordCodecBuilder.create(instance -> instance.group(BuiltInRegistries.ITEM.holderByNameCodec().fieldOf("item").forGetter(analyzationRecipe -> analyzationRecipe.item), Codec.INT.fieldOf("low_weight").orElse(100).forGetter(analyzationRecipe -> analyzationRecipe.lowWeight), Codec.INT.fieldOf("high_weight").orElse(100).forGetter(analyzationRecipe -> analyzationRecipe.highWeight)).apply(instance, ItemAndChance::new));
	}
}
