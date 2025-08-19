package willatendo.fossilslegacy.server.registry;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.HeadDisplayInformation;
import willatendo.simplelibrary.server.registry.ItemRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public record FAItemRegistry(ItemRegistry itemRegistry) {
    public static final List<SimpleHolder<SignItem>> SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<HangingSignItem>> HANGING_SIGNS = new ArrayList<>();
    public static final List<SimpleHolder<BoatItem>> BOATS = new ArrayList<>();
    public static final List<SimpleHolder<BoatItem>> CHEST_BOATS = new ArrayList<>();

    public static SimpleHolder<SignItem> getSign(int i) {
        return SIGNS.get(i);
    }

    public static Item[] getSigns() {
        return SIGNS.stream().map(SimpleHolder::get).toArray(Item[]::new);
    }


    public static SimpleHolder<HangingSignItem> getHangingSign(int i) {
        return HANGING_SIGNS.get(i);
    }

    public static Item[] getHangingSigns() {
        return HANGING_SIGNS.stream().map(SimpleHolder::get).toArray(Item[]::new);
    }


    public static SimpleHolder<BoatItem> getBoat(int i) {
        return BOATS.get(i);
    }

    public static Item[] getBoats() {
        return BOATS.stream().map(SimpleHolder::get).toArray(Item[]::new);
    }

    public static SimpleHolder<BoatItem> getChestBoat(int i) {
        return CHEST_BOATS.get(i);
    }

    public static Item[] getChestBoats() {
        return CHEST_BOATS.stream().map(SimpleHolder::get).toArray(Item[]::new);
    }

    public SimpleHolder<SignItem> registerSign(SimpleHolder<FossilsStandingSignBlock> signBlock, SimpleHolder<FossilsWallSignBlock> wallSign) {
        SimpleHolder<SignItem> sign = this.registerBlock(signBlock, (block, properties) -> new SignItem(block, wallSign.get(), properties), () -> new Item.Properties().stacksTo(16));
        SIGNS.add(sign);
        return sign;
    }

    public SimpleHolder<HangingSignItem> registerHangingSign(SimpleHolder<FossilsCeilingHangingSignBlock> hangingSignBlock, SimpleHolder<FossilsWallHangingSignBlock> hangingWallSign) {
        SimpleHolder<HangingSignItem> hangingSign = this.registerBlock(hangingSignBlock, (block, properties) -> new HangingSignItem(block, hangingWallSign.get(), properties), () -> new Item.Properties().stacksTo(16));
        HANGING_SIGNS.add(hangingSign);
        return hangingSign;
    }

    public SimpleHolder<BoatItem> registerBoat(String name, Function<Item.Properties, BoatItem> boatItem) {
        SimpleHolder<BoatItem> boat = this.registerItem(name, boatItem, () -> new Item.Properties().stacksTo(1));
        BOATS.add(boat);
        return boat;
    }

    public SimpleHolder<BoatItem> registerChestBoat(String name, Function<Item.Properties, BoatItem> boatItem) {
        SimpleHolder<BoatItem> chestBoat = this.registerItem(name, boatItem, new Item.Properties().stacksTo(1));
        CHEST_BOATS.add(chestBoat);
        return chestBoat;
    }

    public SimpleHolder<StandingAndWallBlockItem> registerHead(SimpleHolder<HeadBlock> head, SimpleHolder<WallHeadBlock> wallHead) {
        return this.registerBlock(head, (block, properties) -> new StandingAndWallBlockItem(block, wallHead.get(), Direction.DOWN, properties.component(FADataComponents.HEAD_DISPLAY_INFORMATION.get(), HeadDisplayInformation.NONE)), () -> new Item.Properties().rarity(Rarity.UNCOMMON).equippableUnswappable(EquipmentSlot.HEAD));
    }

    public SimpleHolder<Item> registerItem(String name) {
        return this.itemRegistry.registerItem(name);
    }

    public SimpleHolder<Item> registerItem(String name, Item.Properties properties) {
        return this.itemRegistry.registerItem(name, properties);
    }

    public SimpleHolder<Item> registerItem(String name, Supplier<Item.Properties> properties) {
        return this.itemRegistry.registerItem(name, properties);
    }

    public <T extends Item> SimpleHolder<T> registerItem(String name, Function<Item.Properties, T> item) {
        return this.itemRegistry.registerItem(name, item);
    }

    public <T extends Item> SimpleHolder<T> registerItem(String name, Function<Item.Properties, T> item, Item.Properties properties) {
        return this.itemRegistry.registerItem(name, item, properties);
    }

    public <T extends Item> SimpleHolder<T> registerItem(String name, Function<Item.Properties, T> item, Supplier<Item.Properties> properties) {
        return this.itemRegistry.registerItem(name, item, properties);
    }

    public <B extends Block> SimpleHolder<BlockItem> registerBlock(SimpleHolder<B> block) {
        return this.registerBlock(block, BlockItem::new);
    }

    public <B extends Block> SimpleHolder<BlockItem> registerBlock(SimpleHolder<B> block, Supplier<Item.Properties> properties) {
        return this.registerBlock(block, BlockItem::new, properties);
    }

    public <I extends Item, B extends Block> SimpleHolder<I> registerBlock(SimpleHolder<B> block, BiFunction<B, Item.Properties, I> factory) {
        return this.registerBlock(block, factory, Item.Properties::new);
    }

    public <T extends Item, B extends Block> SimpleHolder<T> registerBlock(SimpleHolder<B> block, BiFunction<B, Item.Properties, T> factory, Supplier<Item.Properties> properties) {
        return this.registerItem(block.getId().getPath(), propertiesIn -> factory.apply(block.get(), propertiesIn), properties.get()::useBlockDescriptionPrefix);
    }
}
