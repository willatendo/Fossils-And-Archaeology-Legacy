package willatendo.fossilslegacy.server.item.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;

import java.util.List;

public class PlaceOnWaterBlockPeriodItem extends PlaceOnWaterBlockItem {
    private final GeologicalTimeScale.Period period;

    public PlaceOnWaterBlockPeriodItem(GeologicalTimeScale.Period period, Block block, Properties properties) {
        super(block, properties);
        this.period = period;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }
}
