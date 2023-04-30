package fossilslegacy.server.item;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class FossilsLegacyItemTags {
	public static final TagKey<Item> CAKE_EGGS = create("cake_eggs");
	public static final TagKey<Item> DNA = create("dna");
	public static final TagKey<Item> DRUM_INSTRUMENT = create("drum_instrument");
	public static final TagKey<Item> HIGH_CHANCE_FOSSIL_OUTPUTS = create("high_chance_fossil_outputs");
	public static final TagKey<Item> LOW_CHANCE_FOSSIL_OUTPUTS = create("low_chance_fossil_outputs");
	public static final TagKey<Item> FROZEN_MEAT_OUTPUTS = create("frozen_meat_outputs");
	public static final TagKey<Item> BEEF_OUTPUTS = create("beef_outputs");
	public static final TagKey<Item> PORKCHOP_OUTPUTS = create("porkchop_outputs");
	public static final TagKey<Item> MUTTON_OUTPUTS = create("mutton_outputs");
	public static final TagKey<Item> CHICKEN_OUTPUTS = create("chicken_outputs");
	public static final TagKey<Item> RABBIT_OUTPUTS = create("rabbit_outputs");
	public static final TagKey<Item> TRICERATOPS_MEAT_OUTPUTS = create("triceratops_meat_outputs");
	public static final TagKey<Item> TRICERATOPS_COMMANDABLES = create("triceratops_commandables");
	public static final TagKey<Item> UTAHRAPTOR_MEAT_OUTPUTS = create("utahraptor_meat_outputs");
	public static final TagKey<Item> TYRANNOSAURUS_MEAT_OUTPUTS = create("tyrannosaurus_meat_outputs");
	public static final TagKey<Item> PTEROSAURUS_MEAT_OUTPUTS = create("pterosaurus_meat_outputs");
	public static final TagKey<Item> PLESIOSAURUS_MEAT_OUTPUTS = create("plesiosaurus_meat_outputs");
	public static final TagKey<Item> MOSASAURUS_MEAT_OUTPUTS = create("mosasaurus_meat_outputs");
	public static final TagKey<Item> STEGOSAURUS_MEAT_OUTPUTS = create("stegosaurus_meat_outputs");
	public static final TagKey<Item> DILOPHOSAURUS_MEAT_OUTPUTS = create("dilophosaurus_meat_outputs");
	public static final TagKey<Item> BRACHIOSAURUS_MEAT_OUTPUTS = create("brachiosaurus_meat_outputs");
	public static final TagKey<Item> SMILODON_MEAT_OUTPUTS = create("smilodon_meat_outputs");
	public static final TagKey<Item> MAMMOTH_MEAT_OUTPUTS = create("mammoth_meat_outputs");
	public static final TagKey<Item> PIGLIN_TAMER = create("piglin_tamer");
	public static final TagKey<Item> RELIC_SCRAP_OUTPUTS = create("relic_scrap_outputs");

	public static TagKey<Item> create(String name) {
		return TagKey.create(Registries.ITEM, FossilsLegacyUtils.resource(name));
	}
}
