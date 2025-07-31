package willatendo.fossilslegacy.server.item.items;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.level.FALevels;

public class CoinItem extends Item {
    private final ResourceKey<Level> destinedLevel;

    public CoinItem(ResourceKey<Level> destinedLevel, Properties properties) {
        super(properties);
        this.destinedLevel = destinedLevel;
    }

    public ResourceKey<Level> getDestinedLevel() {
        return this.destinedLevel;
    }

    public static ItemStack getCoin(ResourceKey<Level> currentLevel, ResourceKey<Level> destinedLevel) {
        if (destinedLevel == Level.OVERWORLD) {
            if (currentLevel == FALevels.PREHISTORY) {
                return new ItemStack(FAItems.PREHISTORIC_COIN.get());
            }
            if (currentLevel == Level.NETHER) {
                return new ItemStack(FAItems.ICE_AGE_COIN.get());
            }
        }
        return new ItemStack(FAItems.OVERWORLD_COIN.get());
    }
}
