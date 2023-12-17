package willatendo.fossilslegacy.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyItemTags {
	public static final TagRegister<Item> ITEM_TAGS = SimpleUtils.create(Registries.ITEM, FossilsLegacyUtils.ID);

	public static final TagKey<Item> BRACHIOSAURUS_COMMANDABLES = ITEM_TAGS.register("brachiosaurus_commandables");
	public static final TagKey<Item> CAKE_EGGS = ITEM_TAGS.register("cake_eggs");
	public static final TagKey<Item> DNA = ITEM_TAGS.register("dna");
	public static final TagKey<Item> DRUM_INSTRUMENT = ITEM_TAGS.register("drum_instrument");
	public static final TagKey<Item> PIGLIN_TAMING_HELMETS = ITEM_TAGS.register("piglin_taming_helmets");
	public static final TagKey<Item> PTERANODON_COMMANDABLES = ITEM_TAGS.register("pteranodon_commandables");
	public static final TagKey<Item> STEGOSAURUS_COMMANDABLES = ITEM_TAGS.register("stegosaurus_commandables");
	public static final TagKey<Item> TRICERATOPS_COMMANDABLES = ITEM_TAGS.register("triceratops_commandables");
	public static final TagKey<Item> TYRANNOSAURUS_COMMANDABLES = ITEM_TAGS.register("tyrannosaurus_commandables");
}
