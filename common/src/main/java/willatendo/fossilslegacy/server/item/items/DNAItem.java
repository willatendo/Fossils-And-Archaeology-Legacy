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

    public DNAItem(GeologicalTimeScale.Period period, EmbryoType embryoType, Properties properties) {
        super(properties);
        this.period = period;
        this.embryoType = embryoType;

        DNA.add(this);
    }

    public EmbryoType getEmbryoType() {
        return this.embryoType;
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
