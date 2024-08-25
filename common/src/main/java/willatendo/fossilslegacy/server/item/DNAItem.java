package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class DNAItem extends Item {
    private final TagKey<CoatType> applicableCoatTypes;

    public DNAItem(Properties properties, TagKey<CoatType> applicableCoatTypes) {
        super(properties);
        this.applicableCoatTypes = applicableCoatTypes;
    }

    public DNAItem(Properties properties) {
        super(properties);
        this.applicableCoatTypes = null;
    }

    public TagKey<CoatType> getApplicableCoatTypes() {
        return applicableCoatTypes;
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
