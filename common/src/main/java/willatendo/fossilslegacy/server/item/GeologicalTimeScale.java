package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public final class GeologicalTimeScale {
    public interface EraDescription {
        void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag);
    }

    public static EraDescription range(GeologicalTimeScale.Period from, GeologicalTimeScale.Period to) {
        return (itemStack, tooltipContext, tooltipComponents, tooltipFlag) -> {
            if (from.getEra() != to.getEra()) {
                tooltipComponents.add(FAUtils.translation("item", "dna.era_range", FAUtils.translation("item", "dna.era." + from.getEra().getName()).withStyle(from.getEra().getChatFormatting()), FAUtils.translation("item", "dna.era." + to.getEra().getName()).withStyle(to.getEra().getChatFormatting())).withStyle(ChatFormatting.GRAY));
            } else {
                from.getEra().appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
            }
            tooltipComponents.add(FAUtils.translation("item", "dna.period_range", FAUtils.translation("item", "dna.period." + from.getName()).withColor(from.getColor()), FAUtils.translation("item", "dna.period." + to.getName()).withColor(to.getColor())).withStyle(ChatFormatting.GRAY));
        };
    }

    public enum Era implements EraDescription {
        CENOZOIC("cenozoic", ChatFormatting.BLUE),
        MESOZOIC("mesozoic", ChatFormatting.DARK_GREEN),
        PALEOZOIC("paleozoic", ChatFormatting.RED);

        private final String name;
        private final ChatFormatting chatFormatting;

        Era(String name, ChatFormatting chatFormatting) {
            this.name = name;
            this.chatFormatting = chatFormatting;
        }

        public String getName() {
            return this.name;
        }

        public ChatFormatting getChatFormatting() {
            return this.chatFormatting;
        }

        @Override
        public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            tooltipComponents.add(FAUtils.translation("item", "dna.era", FAUtils.translation("item", "dna.era." + this.name).withStyle(this.chatFormatting)).withStyle(ChatFormatting.GRAY));
        }
    }

    public enum Period implements EraDescription {
        QUATERNARY("quaternary", Era.CENOZOIC, 0x5555FF),
        NEOGENE("neogene", Era.CENOZOIC, 0x55FFFF),
        PALEOGENE("paleogene", Era.CENOZOIC, 0x00AAAA),
        CRETACEOUS("cretaceous", Era.MESOZOIC, 0x385A15),
        JURASSIC("jurassic", Era.MESOZOIC, 0x47A2CB),
        TRIASSIC("triassic", Era.MESOZOIC, 0x6E1089),
        PERMIAN("permian", Era.PALEOZOIC, 0xD93519),
        CARBONIFEROUS("carboniferous", Era.PALEOZOIC, 0x6F9389),
        DEVONIAN("devonian", Era.PALEOZOIC, 0xD87E2B),
        SILURIAN("silurian", Era.PALEOZOIC, 0xCFECC4),
        ORDOVICIAN("ordovician", Era.PALEOZOIC, 0x256240),
        CAMBRIAN("cambrian", Era.PALEOZOIC, 0x5C6D1F);

        private final String name;
        private final Era era;
        private final int color;

        Period(String name, Era era, int color) {
            this.name = name;
            this.era = era;
            this.color = color;
        }

        public String getName() {
            return this.name;
        }

        public Era getEra() {
            return this.era;
        }

        public int getColor() {
            return this.color;
        }

        @Override
        public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            this.era.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
            tooltipComponents.add(FAUtils.translation("item", "dna.period", FAUtils.translation("item", "dna.period." + this.name).withColor(this.color)).withStyle(ChatFormatting.GRAY));
        }
    }
}
