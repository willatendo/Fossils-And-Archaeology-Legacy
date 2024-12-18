package willatendo.fossilslegacy.server.item;

import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.function.Supplier;

public class DNAItem extends Item {
    public static final List<DNAItem> DNA = Lists.newArrayList();
    private final TagKey<CoatType> applicableCoatTypes;
    private final Supplier<EntityType<? extends Mob>> entityType;

    public DNAItem(Properties properties, TagKey<CoatType> applicableCoatTypes, Supplier<EntityType<? extends Mob>> entityType) {
        super(properties);
        this.applicableCoatTypes = applicableCoatTypes;
        this.entityType = entityType;

        DNA.add(this);
    }

    public DNAItem(Properties properties, Supplier<EntityType<? extends Mob>> entityType) {
        super(properties);
        this.entityType = entityType;
        this.applicableCoatTypes = null;

        DNA.add(this);
    }

    public TagKey<CoatType> getApplicableCoatTypes() {
        return this.applicableCoatTypes;
    }

    public Supplier<EntityType<? extends Mob>> getEntityType() {
        return this.entityType;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        if (itemStack.has(FossilsLegacyDataComponents.COAT_TYPE.get())) {
            Holder<CoatType> holder = itemStack.get(FossilsLegacyDataComponents.COAT_TYPE.get());
            components.add(FossilsLegacyUtils.translation("item", "dna.coat_type", holder.value().displayInfo().name()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
    }
}
