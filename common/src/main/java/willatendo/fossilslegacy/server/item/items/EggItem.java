package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pattern.pattern.PatternHolder;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EggItem extends PlaceEntityItem<Egg> {
    public static final List<EggItem> EGGS = new ArrayList<>();
    private final GeologicalTimeScale.Period period;
    protected final TagKey<ModelType> applicableCoatTypes;

    public EggItem(Supplier<EntityType<Egg>> entityType, GeologicalTimeScale.Period period, TagKey<ModelType> applicableCoatTypes, Properties properties) {
        super(entityType, properties);
        this.period = period;
        this.applicableCoatTypes = applicableCoatTypes;
        EggItem.EGGS.add(this);
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        if (itemStack.has(FADataComponents.MODEL_TYPE.get()) && itemStack.has(FADataComponents.PATTERN_HOLDER.get())) {
            egg.setModelType(itemStack.get(FADataComponents.MODEL_TYPE.get()));
            PatternHolder patternHolder = itemStack.get(FADataComponents.PATTERN_HOLDER.get());
            egg.setSkin(patternHolder.skin());
            if (patternHolder.hasPattern()) {
                egg.setPattern(patternHolder.pattern().get());
            }
        } else {
            Level level = egg.level();
            HolderLookup<ModelType> modelTypeRegistry = level.holderLookup(FARegistries.MODEL_TYPES);
            HolderLookup<Pattern> patternRegistry = level.holderLookup(FARegistries.PATTERN);
            Holder<ModelType> modelType = modelTypeRegistry.getOrThrow(this.applicableCoatTypes).getRandomElement(egg.getRandom()).get();
            egg.setModelType(modelType);
            egg.setSkin(patternRegistry.getOrThrow(modelType.value().skins()).getRandomElement(egg.getRandom()).get());
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            Holder<ModelType> holder = itemStack.get(FADataComponents.MODEL_TYPE.get());
            tooltipComponents.add(FAUtils.translation("item", "model_type", holder.value().displayInfo().modelName()).withStyle(ChatFormatting.GRAY));
        }
        if (itemStack.has(FADataComponents.PATTERN_HOLDER.get())) {
            PatternHolder patternHolder = itemStack.get(FADataComponents.PATTERN_HOLDER.get());
            tooltipComponents.add(FAUtils.translation("item", "skin", patternHolder.getDisplayName()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }
}
