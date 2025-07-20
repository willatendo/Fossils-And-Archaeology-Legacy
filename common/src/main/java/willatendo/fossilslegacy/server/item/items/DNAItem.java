package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public abstract class DNAItem extends Item {
    private final GeologicalTimeScale.Period period;
    private final EmbryoType embryoType;

    public DNAItem(GeologicalTimeScale.Period period, EmbryoType embryoType,  Properties properties) {
        super(properties);
        this.period = period;
        this.embryoType = embryoType;
    }

    public GeologicalTimeScale.Period getPeriod() {
        return this.period;
    }

    public EmbryoType getEmbryoType() {
        return this.embryoType;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.PURITY.get())) {
            tooltipComponents.add(FAUtils.translation("item", "dna.purity", (int) Math.floor((((float) itemStack.get(FADataComponents.PURITY.get())) / 100) * 100) + "%").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    public static void addDNAItem(CreativeModeTab.Output output, Item item) {
        ItemStack itemStack = new ItemStack(item);
        itemStack.set(FADataComponents.PURITY.get(), 100);
        output.accept(itemStack);
    }

    public enum EmbryoType {
        ANIMAL,
        PLANT;
    }
}
