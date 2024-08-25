package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class EggItem extends PlaceEntityItem {
    private final Holder<EggVariant> eggVariant;

    public EggItem(Holder<EggVariant> eggVariant, Properties properties) {
        super(() -> FossilsLegacyEntityTypes.EGG.get(), properties);
        this.eggVariant = eggVariant;
        FossilsLegacyItems.EGGS.add(this);
    }

    public Holder<EggVariant> getEggVariant() {
        return this.eggVariant;
    }

    @Override
    public void entityModification(Entity entity) {
        ((Egg) entity).setEggVariant(this.eggVariant);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        if (itemStack.has(FossilsLegacyDataComponents.COAT_TYPE.get())) {
            Holder<CoatType> holder = itemStack.get(FossilsLegacyDataComponents.COAT_TYPE.get());
            components.add(FossilsLegacyUtils.translation("item", "dna.coat_type", holder.value().name()).withStyle(ChatFormatting.GRAY));
            super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
        } else {
            super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
        }
    }
}
