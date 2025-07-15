package willatendo.fossilslegacy.server.item.items;

import com.google.common.collect.Lists;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;

import java.util.List;

public class DNAItem extends Item {
    public static final List<DNAItem> DNA = Lists.newArrayList();
    private final GeologicalTimeScale.Period period;
    private final EmbryoType embryoType;
    private final boolean hasAttributes;

    public DNAItem(GeologicalTimeScale.Period period, EmbryoType embryoType, boolean hasAttributes, Properties properties) {
        super(properties);
        this.period = period;
        this.embryoType = embryoType;
        this.hasAttributes = hasAttributes;

        DNA.add(this);
    }

    public DNAItem(GeologicalTimeScale.Period period, EmbryoType embryoType, Properties properties) {
        this(period, embryoType, false, properties);
    }

    public EmbryoType getEmbryoType() {
        return this.embryoType;
    }

    public boolean hasAttributes() {
        return this.hasAttributes;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    public enum EmbryoType {
        ANIMAL,
        PLANT;
    }
}
