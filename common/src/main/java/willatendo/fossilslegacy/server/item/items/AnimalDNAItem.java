package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.function.Supplier;

public class AnimalDNAItem extends DNAItem {
    private final Supplier<EntityType<? extends Mob>> entityType;
    private final TagKey<ModelGene> applicableModelGenes;

    public AnimalDNAItem(GeologicalTimeScale.EraDescription eraDescription, Supplier<EntityType<? extends Mob>> entityType, TagKey<ModelGene> applicableModelGenes, Properties properties) {
        super(eraDescription, DNAItem.EmbryoType.ANIMAL, properties);
        this.entityType = entityType;
        this.applicableModelGenes = applicableModelGenes;
    }

    public AnimalDNAItem(GeologicalTimeScale.EraDescription eraDescription, Supplier<EntityType<? extends Mob>> entityType, Properties properties) {
        super(eraDescription, DNAItem.EmbryoType.ANIMAL, properties);
        this.entityType = entityType;
        this.applicableModelGenes = null;
    }

    public Supplier<EntityType<? extends Mob>> getEntityType() {
        return this.entityType;
    }

    public TagKey<ModelGene> getApplicableModelGenes() {
        return this.applicableModelGenes;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            Holder<ModelGene> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.model_gene", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.COSMETIC_GENE_HOLDER.get())) {
            CosmeticGeneHolder cosmeticGeneHolder = itemStack.get(FADataComponents.COSMETIC_GENE_HOLDER.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.skin_gene", cosmeticGeneHolder.getDisplayName(tooltipContext.registries())).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.GENE_HOLDER.get())) {
            AttributeGeneHolder attributeGeneHolder = itemStack.get(FADataComponents.GENE_HOLDER.get());
            attributeGeneHolder.addTooltips(tooltipComponents);
        }
    }
}
