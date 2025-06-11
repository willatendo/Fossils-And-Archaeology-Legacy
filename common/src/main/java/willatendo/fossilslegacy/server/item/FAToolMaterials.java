package willatendo.fossilslegacy.server.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import willatendo.fossilslegacy.server.tags.FAItemTags;

public final class FAToolMaterials {
    public static final ToolMaterial ANCIENT = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, FAItemTags.ANCIENT_TOOL_MATERIALS);
    public static final ToolMaterial DAGGER = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, FAItemTags.DAGGER_TOOL_MATERIALS);
    public static final ToolMaterial SCARAB_GEM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4231, 10.0F, 5.0F, 17, FAItemTags.SCARAB_GEM_TOOL_MATERIALS);
    public static final ToolMaterial ICED_MEAT = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 4, 4.0F, 6.0F, 1, FAItemTags.ICED_MEAT_TOOL_MATERIALS);
}
