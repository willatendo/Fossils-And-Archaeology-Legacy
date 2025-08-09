package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.gene.GeneHolder;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.PatternHolder;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.function.Supplier;

public class AnimalDNAItem extends DNAItem {
    private final Supplier<EntityType<? extends Mob>> entityType;
    private final TagKey<ModelType> applicableCoatTypes;

    public AnimalDNAItem(GeologicalTimeScale.EraDescription eraDescription, Supplier<EntityType<? extends Mob>> entityType, TagKey<ModelType> applicableCoatTypes, Properties properties) {
        super(eraDescription, DNAItem.EmbryoType.ANIMAL, properties);
        this.entityType = entityType;
        this.applicableCoatTypes = applicableCoatTypes;
    }

    public AnimalDNAItem(GeologicalTimeScale.EraDescription eraDescription, Supplier<EntityType<? extends Mob>> entityType, Properties properties) {
        super(eraDescription, DNAItem.EmbryoType.ANIMAL, properties);
        this.entityType = entityType;
        this.applicableCoatTypes = null;
    }

    public Supplier<EntityType<? extends Mob>> getEntityType() {
        return this.entityType;
    }

    public TagKey<ModelType> getApplicableCoatTypes() {
        return this.applicableCoatTypes;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            Holder<ModelType> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.model_type", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.PATTERN_HOLDER.get())) {
            PatternHolder patternHolder = itemStack.get(FADataComponents.PATTERN_HOLDER.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.skin", patternHolder.getDisplayName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.GENE_HOLDER.get())) {
            GeneHolder geneHolder = itemStack.get(FADataComponents.GENE_HOLDER.get());
            geneHolder.addTooltips(tooltipComponents);
        }
    }
}
