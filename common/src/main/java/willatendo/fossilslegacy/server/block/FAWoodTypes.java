package willatendo.fossilslegacy.server.block;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FAWoodTypes {
    public static final WoodType CALAMITES = register("calamites", FABlockSetTypes.SIGILLARIA);
    public static final WoodType LEPIDODENDRON = register("lepidodendron", FABlockSetTypes.LEPIDODENDRON);
    public static final WoodType SIGILLARIA = register("sigillaria", FABlockSetTypes.SIGILLARIA);

    public static WoodType register(String id, BlockSetType blockSetType) {
        return WoodType.register(new WoodType(FossilsLegacyUtils.ID + ":" + id, blockSetType));
    }

    public static void register(WoodType woodType) {
        ResourceLocation resourceLocation = ResourceLocation.parse(woodType.name());
        Sheets.SIGN_MATERIALS.put(woodType, new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "entity/signs/" + resourceLocation.getPath())));
        Sheets.HANGING_SIGN_MATERIALS.put(woodType, new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "entity/signs/hanging/" + resourceLocation.getPath())));
    }
}
