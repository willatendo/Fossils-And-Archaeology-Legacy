package fossilslegacy.server.item;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class FossilsLegacyItemTags {
	public static final TagKey<Item> CAKE_EGGS = create("cake_eggs");
	public static final TagKey<Item> DNA = create("dna");
	public static final TagKey<Item> DRUM_INSTRUMENT = create("drum_instrument");
	public static final TagKey<Item> HIGH_CHANCE_FOSSIL_OUTPUTS = create("analyzer_outputs/high_chance_fossil");
	public static final TagKey<Item> LOW_CHANCE_FOSSIL_OUTPUTS = create("analyzer_outputs/low_chance_fossil");
	public static final TagKey<Item> FROZEN_MEAT_OUTPUTS = create("analyzer_outputs/frozen_meat");
	public static final TagKey<Item> BEEF_OUTPUTS = create("analyzer_outputs/beef");
	public static final TagKey<Item> PORKCHOP_OUTPUTS = create("analyzer_outputs/porkchop");
	public static final TagKey<Item> MUTTON_OUTPUTS = create("analyzer_outputs/mutton");
	public static final TagKey<Item> CHICKEN_OUTPUTS = create("analyzer_outputs/chicken");
	public static final TagKey<Item> RABBIT_OUTPUTS = create("analyzer_outputs/rabbit");
	public static final TagKey<Item> TRICERATOPS_MEAT_OUTPUTS = create("analyzer_outputs/triceratops_meat");
	public static final TagKey<Item> TRICERATOPS_COMMANDABLES = create("triceratops_commandables");
	public static final TagKey<Item> UTAHRAPTOR_MEAT_OUTPUTS = create("analyzer_outputs/utahraptor_meat");
	public static final TagKey<Item> TYRANNOSAURUS_MEAT_OUTPUTS = create("analyzer_outputs/tyrannosaurus_meat");
	public static final TagKey<Item> PTEROSAURUS_MEAT_OUTPUTS = create("analyzer_outputs/pterosaurus_meat");
	public static final TagKey<Item> PLESIOSAURUS_MEAT_OUTPUTS = create("analyzer_outputs/plesiosaurus_meat");
	public static final TagKey<Item> MOSASAURUS_MEAT_OUTPUTS = create("analyzer_outputs/mosasaurus_meat");
	public static final TagKey<Item> STEGOSAURUS_MEAT_OUTPUTS = create("analyzer_outputs/stegosaurus_meat");
	public static final TagKey<Item> DILOPHOSAURUS_MEAT_OUTPUTS = create("analyzer_outputs/dilophosaurus_meat");
	public static final TagKey<Item> BRACHIOSAURUS_MEAT_OUTPUTS = create("analyzer_outputs/brachiosaurus_meat");
	public static final TagKey<Item> SMILODON_MEAT_OUTPUTS = create("analyzer_outputs/smilodon_meat");
	public static final TagKey<Item> MAMMOTH_MEAT_OUTPUTS = create("analyzer_outputs/mammoth_meat");
	public static final TagKey<Item> PIGLIN_TAMER = create("piglin_tamer");
	public static final TagKey<Item> RELIC_SCRAP_OUTPUTS = create("analyzer_outputs/relic_scrap");

	public static TagKey<Item> create(String name) {
		return TagKey.create(Registries.ITEM, FossilsLegacyUtils.resource(name));
	}
}
