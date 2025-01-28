package willatendo.fossilslegacy.server.jei.interpreter;

import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FADataComponents;

public final class ArticulatedFossilSubtypeInterpreter implements ISubtypeInterpreter<ItemStack> {
    public static final ArticulatedFossilSubtypeInterpreter INSTANCE = new ArticulatedFossilSubtypeInterpreter();

    @Override
    public @Nullable Object getSubtypeData(ItemStack itemStack, UidContext uidContext) {
        FossilVariant fossilVariant = itemStack.get(FADataComponents.FOSSIL_VARIANT.get()).value();
        if (fossilVariant == null) {
            return null;
        }
        return fossilVariant;
    }

    @Override
    public String getLegacyStringSubtypeInfo(ItemStack itemStack, UidContext uidContext) {
        return this.getStringName(itemStack);
    }

    private String getStringName(ItemStack itemStack) {
        if (itemStack.getComponentsPatch().isEmpty()) {
            return "";
        }
        Holder<FossilVariant> fossilVariantHolder = itemStack.get(FADataComponents.FOSSIL_VARIANT.get());
        return fossilVariantHolder != null ? fossilVariantHolder.getRegisteredName() : "";
    }
}
