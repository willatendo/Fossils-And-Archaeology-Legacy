package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EggItem extends PlaceEntityItem<Egg> {
    public static final List<EggItem> EGGS = new ArrayList<>();
    private final GeologicalTimeScale.Period period;
    protected final TagKey<ModelGene> applicableCoatTypes;

    public EggItem(Supplier<EntityType<Egg>> entityType, GeologicalTimeScale.Period period, TagKey<ModelGene> applicableCoatTypes, Properties properties) {
        super(entityType, properties);
        this.period = period;
        this.applicableCoatTypes = applicableCoatTypes;
        EggItem.EGGS.add(this);
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        if (itemStack.has(FADataComponents.MODEL_TYPE.get()) && itemStack.has(FADataComponents.COSMETIC_GENE_HOLDER.get())) {
            egg.setModelType(itemStack.get(FADataComponents.MODEL_TYPE.get()));
            CosmeticGeneHolder cosmeticGeneHolder = itemStack.get(FADataComponents.COSMETIC_GENE_HOLDER.get());
            egg.setSkin(cosmeticGeneHolder.skinGene(egg.registryAccess()));
            if (cosmeticGeneHolder.hasPattern()) {
                egg.setPattern(cosmeticGeneHolder.patternGene(egg.registryAccess()));
            }
        } else {
            Level level = egg.level();
            HolderLookup<ModelGene> modelTypeRegistry = level.holderLookup(FARegistries.MODEL_GENE);
            HolderLookup<PatternGene> patternRegistry = level.holderLookup(FARegistries.PATTERN_GENE);
            Holder<ModelGene> modelType = modelTypeRegistry.getOrThrow(this.applicableCoatTypes).getRandomElement(egg.getRandom()).get();
            egg.setModelType(modelType);
            egg.setSkin(patternRegistry.getOrThrow(modelType.value().skinGenes()).getRandomElement(egg.getRandom()).get());
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            Holder<ModelGene> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.model_type", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.COSMETIC_GENE_HOLDER.get())) {
            CosmeticGeneHolder cosmeticGeneHolder = itemStack.get(FADataComponents.COSMETIC_GENE_HOLDER.get());
            tooltipComponents.add(FAUtils.translation("item", "dna.skinGenes", cosmeticGeneHolder.getDisplayName(tooltipContext.registries())).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.GENE_HOLDER.get())) {
            AttributeGeneHolder attributeGeneHolder = itemStack.get(FADataComponents.GENE_HOLDER.get());
            attributeGeneHolder.addTooltips(tooltipComponents);
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }
}
