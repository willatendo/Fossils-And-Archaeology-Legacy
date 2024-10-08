package willatendo.fossilslegacy.server.jei.interpreter;

import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;

public final class MagicConchSubtypeInterpreter implements ISubtypeInterpreter<ItemStack> {
    public static final MagicConchSubtypeInterpreter INSTANCE = new MagicConchSubtypeInterpreter();

    @Override
    public @Nullable Object getSubtypeData(ItemStack itemStack, UidContext uidContext) {
        CommandType commandType = itemStack.get(FossilsLegacyDataComponents.COMMAND_TYPE.get()).value();
        if (commandType == null) {
            return null;
        }
        return commandType;
    }

    @Override
    public String getLegacyStringSubtypeInfo(ItemStack itemStack, UidContext uidContext) {
        return this.getStringName(itemStack);
    }

    private String getStringName(ItemStack itemStack) {
        if (itemStack.getComponentsPatch().isEmpty()) {
            return "";
        }
        return itemStack.getOrDefault(FossilsLegacyDataComponents.COMMAND_TYPE.get(), FossilsLegacyCommandTypes.FREE_MOVE).getRegisteredName();
    }
}
