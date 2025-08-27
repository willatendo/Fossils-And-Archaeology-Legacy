package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.HeadDisplayInformation;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class HeadBlockItem extends StandingAndWallBlockItem {
    public HeadBlockItem(Block block, Block wallBlock, Direction attachmentDirection, Properties properties) {
        super(block, wallBlock, attachmentDirection, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.HEAD_DISPLAY_INFORMATION.get())) {
            HeadDisplayInformation headDisplayInformation = itemStack.get(FADataComponents.HEAD_DISPLAY_INFORMATION.get());
            CosmeticGeneHolder cosmeticGeneHolder = headDisplayInformation.cosmeticGeneHolder();
            tooltipComponents.add(FAUtils.translation("block", "head.skin_gene", cosmeticGeneHolder.getDisplayName(tooltipContext.registries())).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(FAUtils.translation("block", "head.growth_stage", headDisplayInformation.growthStage()));
        }
    }
}
