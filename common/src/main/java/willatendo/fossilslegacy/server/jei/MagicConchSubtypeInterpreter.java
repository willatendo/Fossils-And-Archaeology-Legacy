package willatendo.fossilslegacy.server.jei;

import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;

public class MagicConchSubtypeInterpreter implements IIngredientSubtypeInterpreter<ItemStack> {
    public static final MagicConchSubtypeInterpreter INSTANCE = new MagicConchSubtypeInterpreter();

    private MagicConchSubtypeInterpreter() {
    }

    @Override
    public String apply(ItemStack itemStack, UidContext uidContext) {
        DinosaurCommand dinosaurCommand = itemStack.get(FossilsLegacyDataComponents.DINOSAUR_COMMAND.get());
        return dinosaurCommand.getOrder();
    }
}
