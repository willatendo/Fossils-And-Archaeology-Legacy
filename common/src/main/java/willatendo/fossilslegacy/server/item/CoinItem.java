package willatendo.fossilslegacy.server.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class CoinItem extends Item {
    public static final Map<ResourceKey<Level>, CoinItem> ITEM_MAP = new HashMap<>();
    private final ResourceKey<Level> destinedLevel;

    public CoinItem(ResourceKey<Level> destinedLevel, Properties properties) {
        super(properties);
        this.destinedLevel = destinedLevel;
        ITEM_MAP.put(destinedLevel, this);
    }

    public ResourceKey<Level> getDestinedLevel() {
        return this.destinedLevel;
    }
}
