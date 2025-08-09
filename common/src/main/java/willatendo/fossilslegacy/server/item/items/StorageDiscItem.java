package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.PatternHolder;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class StorageDiscItem extends Item {
    public StorageDiscItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag customData = itemStack.get(DataComponents.CUSTOM_DATA).copyTag();
            Item item = BuiltInRegistries.ITEM.getValue(ResourceLocation.parse(customData.getString("dna_item")));
            tooltipComponents.add(FAUtils.translation("item", "storage_disc.type", item.getName()).withStyle(ChatFormatting.GRAY));
            if (item instanceof DNAItem dnaItem) {
                dnaItem.getEraDescription().appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
            }
        }
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            Holder<ModelType> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.model_type", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.PATTERN_HOLDER.get())) {
            PatternHolder patternHolder = itemStack.get(FADataComponents.PATTERN_HOLDER.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.skin", patternHolder.getDisplayName()).withStyle(ChatFormatting.GRAY));

        }
        if (itemStack.has(FADataComponents.PURITY.get())) {
            tooltipComponents.add(FAUtils.translation("item", "dna.purity", (int) Math.floor((((float) itemStack.get(FADataComponents.PURITY.get())) / 100) * 100) + "%").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    public static void copyDNA(ItemStack storageDisc, ItemStack dna) {
        if (dna.getItem() instanceof DNAItem dnaItem) {
            CompoundTag data = new CompoundTag();
            data.putString("dna_item", BuiltInRegistries.ITEM.getKey(dnaItem).toString());
            storageDisc.set(DataComponents.CUSTOM_DATA, CustomData.of(data));
            if (dna.has(FADataComponents.MODEL_TYPE.get())) {
                storageDisc.set(FADataComponents.MODEL_TYPE.get(), dna.get(FADataComponents.MODEL_TYPE.get()));
            }
            if (dna.has(FADataComponents.PATTERN_HOLDER.get())) {
                storageDisc.set(FADataComponents.PATTERN_HOLDER.get(), dna.get(FADataComponents.PATTERN_HOLDER.get()));
            }
            if (dna.has(FADataComponents.PURITY.get())) {
                storageDisc.set(FADataComponents.PURITY.get(), dna.get(FADataComponents.PURITY.get()));
            }
            if (dna.has(FADataComponents.GENETIC_CODE.get())) {
                storageDisc.set(FADataComponents.GENETIC_CODE.get(), dna.get(FADataComponents.GENETIC_CODE.get()));
            }
        }
    }

    public static ItemStack loadDNA(ItemStack storageDisc) {
        if (storageDisc.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag data = storageDisc.get(DataComponents.CUSTOM_DATA).copyTag();
            ItemStack dna = new ItemStack(BuiltInRegistries.ITEM.getValue(ResourceLocation.parse(data.getString("dna_item"))));
            if (storageDisc.has(FADataComponents.MODEL_TYPE.get())) {
                dna.set(FADataComponents.MODEL_TYPE.get(), storageDisc.get(FADataComponents.MODEL_TYPE.get()));
            }
            if (storageDisc.has(FADataComponents.PATTERN_HOLDER.get())) {
                dna.set(FADataComponents.PATTERN_HOLDER.get(), storageDisc.get(FADataComponents.PATTERN_HOLDER.get()));
            }
            if (storageDisc.has(FADataComponents.PURITY.get())) {
                dna.set(FADataComponents.PURITY.get(), storageDisc.get(FADataComponents.PURITY.get()));
            }
            if (storageDisc.has(FADataComponents.GENETIC_CODE.get())) {
                dna.set(FADataComponents.GENETIC_CODE.get(), storageDisc.get(FADataComponents.GENETIC_CODE.get()));
            }
            return dna;
        }
        return ItemStack.EMPTY;
    }
}
