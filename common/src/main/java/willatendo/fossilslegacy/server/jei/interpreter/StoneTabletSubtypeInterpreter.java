package willatendo.fossilslegacy.server.jei.interpreter;

import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.Nullable;

public final class StoneTabletSubtypeInterpreter implements ISubtypeInterpreter<ItemStack> {
    public static final StoneTabletSubtypeInterpreter INSTANCE = new StoneTabletSubtypeInterpreter();

    @Override
    public @Nullable Object getSubtypeData(ItemStack ingredient, UidContext context) {
        CustomData customData = ingredient.get(DataComponents.ENTITY_DATA);
        if (customData == null) {
            return null;
        }
        CompoundTag compoundTag = customData.copyTag();
        return compoundTag.get("variant");
    }

    @Override
    public String getLegacyStringSubtypeInfo(ItemStack itemStack, UidContext uidContext) {
        CustomData customData = itemStack.get(DataComponents.ENTITY_DATA);
        if (customData == null) {
            return "";
        }
        CompoundTag compoundTag = customData.copyTag();
        Tag variant = compoundTag.get("variant");
        if (variant == null) {
            return "";
        }
        return variant.getAsString();
    }
}
