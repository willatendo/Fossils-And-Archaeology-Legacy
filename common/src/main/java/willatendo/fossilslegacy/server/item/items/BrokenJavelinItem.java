package willatendo.fossilslegacy.server.item.items;

import net.minecraft.world.item.ToolMaterial;

public class BrokenJavelinItem extends JavelinItem {
    public BrokenJavelinItem(ToolMaterial toolMaterial, Properties properties) {
        super(toolMaterial, properties.durability(toolMaterial.durability() / 2));
    }
}
