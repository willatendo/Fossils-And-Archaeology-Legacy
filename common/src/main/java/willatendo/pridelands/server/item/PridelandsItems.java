package willatendo.pridelands.server.item;

import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.item.items.JarItem;
import willatendo.pridelands.server.item.items.LionKingTicketItem;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.server.registry.ItemRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public final class PridelandsItems {
    public static final ItemRegistry ITEMS = SimpleRegistry.createItem(PridelandsUtils.ID);

    public static final SimpleHolder<Item> LION = ITEMS.registerItem("lion", new Item.Properties().food(PridelandsFoods.LION));
    public static final SimpleHolder<Item> COOKED_LION = ITEMS.registerItem("cooked_lion", new Item.Properties().food(PridelandsFoods.COOKED_LION));
    public static final SimpleHolder<Item> MANGO = ITEMS.registerItem("mango", new Item.Properties().food(PridelandsFoods.MANGO));
    public static final SimpleHolder<Item> CHOCOLATE_MUFASA = ITEMS.registerItem("chocolate_mufasa", new Item.Properties().food(PridelandsFoods.CHOCOLATE_MUFASA));
    public static final SimpleHolder<Item> ZEBRA = ITEMS.registerItem("zebra", new Item.Properties().food(PridelandsFoods.ZEBRA));
    public static final SimpleHolder<Item> COOKED_ZEBRA = ITEMS.registerItem("cooked_zebra", new Item.Properties().food(PridelandsFoods.COOKED_ZEBRA));
    public static final SimpleHolder<Item> RHINO = ITEMS.registerItem("rhino", new Item.Properties().food(PridelandsFoods.RHINO));
    public static final SimpleHolder<Item> COOKED_RHINO = ITEMS.registerItem("cooked_rhino", new Item.Properties().food(PridelandsFoods.COOKED_RHINO));
    public static final SimpleHolder<Item> CORN = ITEMS.registerItem("corn", new Item.Properties().food(PridelandsFoods.CORN));
    public static final SimpleHolder<Item> POPCORN = ITEMS.registerItem("popcorn", new Item.Properties().food(PridelandsFoods.POPCORN));
    public static final SimpleHolder<Item> OUTLANDER = ITEMS.registerItem("outlander", new Item.Properties().food(PridelandsFoods.OUTLANDER));
    // Passion Fruit
    public static final SimpleHolder<Item> BUG_STEW = ITEMS.registerItem("bug_stew", new Item.Properties().food(PridelandsFoods.BUG_STEW).usingConvertsTo(Items.BOWL));
    public static final SimpleHolder<Item> CROCODILE = ITEMS.registerItem("crocodile", new Item.Properties().food(PridelandsFoods.CROCODILE));
    public static final SimpleHolder<Item> KIWANO_SLICE = ITEMS.registerItem("kiwano_slice", new Item.Properties().food(PridelandsFoods.KIWANO_SLICE));
    public static final SimpleHolder<Item> YAM = ITEMS.registerItem("yam", new Item.Properties().food(PridelandsFoods.YAM));
    public static final SimpleHolder<Item> ROASTED_YAM = ITEMS.registerItem("roasted_yam", new Item.Properties().food(PridelandsFoods.ROASTED_YAM));
    public static final SimpleHolder<Item> BANANA = ITEMS.registerItem("banana", new Item.Properties().food(PridelandsFoods.BANANA));
    public static final SimpleHolder<Item> BANANA_BREAD = ITEMS.registerItem("banana_bread", new Item.Properties().food(PridelandsFoods.BANANA_BREAD));
    public static final SimpleHolder<Item> HYENA_BONE = ITEMS.registerItem("hyena_bone");
    public static final SimpleHolder<Item> BLUE_FEATHER = ITEMS.registerItem("blue_feather");
    public static final SimpleHolder<Item> YELLOW_FEATHER = ITEMS.registerItem("yellow_feather");
    public static final SimpleHolder<Item> RED_FEATHER = ITEMS.registerItem("red_feather");
    public static final SimpleHolder<Item> HYENA_BONE_SHARD = ITEMS.registerItem("hyena_bone_shard");
    public static final SimpleHolder<Item> ZEBRA_HIDE = ITEMS.registerItem("zebra_hide");
    public static final SimpleHolder<Item> SILVER_INGOT = ITEMS.registerItem("silver_ingot");
    public static final SimpleHolder<Item> GROUND_TERMITE = ITEMS.registerItem("ground_termite");
    public static final SimpleHolder<Item> LION_FUR = ITEMS.registerItem("lion_fur");
    public static final SimpleHolder<Item> RHINO_HORN = ITEMS.registerItem("rhino_horn");
    public static final SimpleHolder<Item> GROUND_RHINO_HORN = ITEMS.registerItem("ground_rhino_horn");
    public static final SimpleHolder<Item> GEMSBOK_HIDE = ITEMS.registerItem("gemsbok_hide");
    public static final SimpleHolder<Item> GEMSBOK_HORN = ITEMS.registerItem("gemsbok_horn");
    public static final SimpleHolder<Item> PEACOCK_GEM = ITEMS.registerItem("peacock_gem");
    public static final SimpleHolder<Item> MAIZE_STALKS = ITEMS.registerItem("maize_stalks");
    public static final SimpleHolder<Item> NUKA_SHARD = ITEMS.registerItem("nuka_shard");
    public static final SimpleHolder<Item> OUTLANDER_FUR = ITEMS.registerItem("outlander_fur");
    public static final SimpleHolder<Item> KIVULITE_INGOT = ITEMS.registerItem("kivulite_ingot");
    public static final SimpleHolder<Item> POISON_POWDER = ITEMS.registerItem("poison_powder");
    public static final SimpleHolder<Item> ZAZU_EGG = ITEMS.registerItem("zazu_egg");
    public static final SimpleHolder<Item> KIWANO_SEEDS = ITEMS.registerItem("kiwano_seeds");
    public static final SimpleHolder<Item> FLAMINGO_FEATHER = ITEMS.registerItem("flamingo_feather");
    public static final SimpleHolder<Item> HYENA_MEAL = ITEMS.registerItem("hyena_meal");
    public static final SimpleHolder<Item> CORN_KERNELS = ITEMS.registerItem("corn_kernels");
    public static final SimpleHolder<Item> DRIED_MAIZE = ITEMS.registerItem("dried_maize");
    public static final SimpleHolder<JarItem> PRIDESTONE_JAR = ITEMS.registerItem("pridestone_jar", properties -> new JarItem(Fluids.EMPTY, properties), new Item.Properties().stacksTo(16));
    public static final SimpleHolder<JarItem> WATER_PRIDESTONE_JAR = ITEMS.registerItem("water_pridestone_jar", properties -> new JarItem(Fluids.WATER, properties), () -> new Item.Properties().craftRemainder(PridelandsItems.PRIDESTONE_JAR.get()).stacksTo(1));
    public static final SimpleHolder<JarItem> LAVA_PRIDESTONE_JAR = ITEMS.registerItem("lava_pridestone_jar", properties -> new JarItem(Fluids.LAVA, properties), () -> new Item.Properties().craftRemainder(PridelandsItems.PRIDESTONE_JAR.get()).stacksTo(1));
    public static final SimpleHolder<Item> ZEBRA_MILK_PRIDESTONE_JAR = ITEMS.registerItem("zebra_milk_pridestone_jar", () -> new Item.Properties().component(DataComponents.CONSUMABLE, PridelandsConsumables.ZEBRA_MILK_PRIDESTONE_JAR).craftRemainder(PridelandsItems.PRIDESTONE_JAR.get()).usingConvertsTo(PridelandsItems.PRIDESTONE_JAR.get()).stacksTo(1));
    public static final SimpleHolder<Item> MANGO_JUICE_PRIDESTONE_JAR = ITEMS.registerItem("mango_juice_pridestone_jar", () -> new Item.Properties().food(PridelandsFoods.MANGO_JUICE).craftRemainder(PridelandsItems.PRIDESTONE_JAR.get()).usingConvertsTo(PridelandsItems.PRIDESTONE_JAR.get()).stacksTo(1));
    public static final SimpleHolder<Item> C_NOTE = ITEMS.registerItem("c_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> D_NOTE = ITEMS.registerItem("d_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> E_NOTE = ITEMS.registerItem("e_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> F_NOTE = ITEMS.registerItem("f_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> G_NOTE = ITEMS.registerItem("g_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> A_NOTE = ITEMS.registerItem("a_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> B_NOTE = ITEMS.registerItem("b_note", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final SimpleHolder<Item> PRIDESTONE_SWORD = ITEMS.registerItem("pridestone_sword", properties -> new SwordItem(ToolMaterial.STONE, 3.0F, -2.4F, properties));
    public static final SimpleHolder<Item> PRIDESTONE_SHOVEL = ITEMS.registerItem("pridestone_shovel", properties -> new ShovelItem(ToolMaterial.STONE, 1.5F, -3.0F, properties));
    public static final SimpleHolder<Item> PRIDESTONE_PICKAXE = ITEMS.registerItem("pridestone_pickaxe", properties -> new PickaxeItem(ToolMaterial.STONE, 1.0F, -2.8F, properties));
    public static final SimpleHolder<Item> PRIDESTONE_AXE = ITEMS.registerItem("pridestone_axe", properties -> new HoeItem(ToolMaterial.STONE, 7.0F, -3.2F, properties));
    public static final SimpleHolder<Item> PRIDESTONE_HOE = ITEMS.registerItem("pridestone_hoe", properties -> new AxeItem(ToolMaterial.STONE, -1.0F, -2.0F, properties));
    public static final SimpleHolder<Item> SILVER_SWORD = ITEMS.registerItem("silver_sword", properties -> new SwordItem(ToolMaterial.IRON, 3.0F, -2.4F, properties));
    public static final SimpleHolder<Item> SILVER_SHOVEL = ITEMS.registerItem("silver_shovel", properties -> new ShovelItem(ToolMaterial.IRON, 1.5F, -3.0F, properties));
    public static final SimpleHolder<Item> SILVER_PICKAXE = ITEMS.registerItem("silver_pickaxe", properties -> new PickaxeItem(ToolMaterial.IRON, 1.0F, -2.8F, properties));
    public static final SimpleHolder<Item> SILVER_AXE = ITEMS.registerItem("silver_axe", properties -> new HoeItem(ToolMaterial.IRON, 6.0F, -3.1F, properties));
    public static final SimpleHolder<Item> SILVER_HOE = ITEMS.registerItem("silver_hoe", properties -> new AxeItem(ToolMaterial.IRON, -2.0F, -1.0F, properties));
    public static final SimpleHolder<Item> PEACOCK_SWORD = ITEMS.registerItem("peacock_sword", properties -> new SwordItem(ToolMaterial.DIAMOND, 3.0F, -2.4F, properties));
    public static final SimpleHolder<Item> PEACOCK_SHOVEL = ITEMS.registerItem("peacock_shovel", properties -> new ShovelItem(ToolMaterial.DIAMOND, 1.5F, -3.0F, properties));
    public static final SimpleHolder<Item> PEACOCK_PICKAXE = ITEMS.registerItem("peacock_pickaxe", properties -> new PickaxeItem(ToolMaterial.DIAMOND, 1.0F, -2.8F, properties));
    public static final SimpleHolder<Item> PEACOCK_AXE = ITEMS.registerItem("peacock_axe", properties -> new HoeItem(ToolMaterial.DIAMOND, 5.0F, -3.0F, properties));
    public static final SimpleHolder<Item> PEACOCK_HOE = ITEMS.registerItem("peacock_hoe", properties -> new AxeItem(ToolMaterial.DIAMOND, -3.0F, 0.0F, properties));
    public static final SimpleHolder<LionKingTicketItem> LION_KING_TICKET = ITEMS.registerItem("lion_king_ticket", LionKingTicketItem::new, new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final SimpleHolder<StandingAndWallBlockItem> HYENA_BONE_TORCH = ITEMS.registerItem("hyena_bone_torch", properties -> new StandingAndWallBlockItem(PridelandsBlocks.HYENA_BONE_TORCH.get(), PridelandsBlocks.HYENA_BONE_WALL_TORCH.get(), Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix());

    static {
        List<SimpleHolder<? extends Block>> exceptions = List.of(PridelandsBlocks.PRIDELANDS_PORTAL, PridelandsBlocks.HYENA_BONE_TORCH, PridelandsBlocks.HYENA_BONE_WALL_TORCH);
        PridelandsBlocks.BLOCKS.getEntriesView().stream().filter(simpleHolder -> !exceptions.contains(simpleHolder)).forEach(simpleHolder -> ITEMS.registerItem(simpleHolder.getId().getPath(), properties -> new BlockItem(simpleHolder.get(), properties.useBlockDescriptionPrefix())));
    }
}
