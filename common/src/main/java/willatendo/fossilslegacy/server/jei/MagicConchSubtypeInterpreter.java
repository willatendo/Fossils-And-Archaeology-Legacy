package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.entity.util.CommandType;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;

public class MagicConchSubtypeInterpreter implements IIngredientSubtypeInterpreter<ItemStack> {
    public static final MagicConchSubtypeInterpreter INSTANCE = new MagicConchSubtypeInterpreter();

    private MagicConchSubtypeInterpreter() {
    }

    @Override
    public String apply(ItemStack itemStack, UidContext uidContext) {
        CommandType commandType = itemStack.get(FossilsLegacyDataComponents.COMMAND_TYPE.get());
        return commandType.name();
    }
}
