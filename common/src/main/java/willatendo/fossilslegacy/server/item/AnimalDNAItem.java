package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.function.Supplier;

public class AnimalDNAItem extends DNAItem {
    private final Supplier<EntityType<? extends Mob>> entityType;
    private final TagKey<CoatType> applicableCoatTypes;

    public AnimalDNAItem(Supplier<EntityType<? extends Mob>> entityType, TagKey<CoatType> applicableCoatTypes, Properties properties) {
        super(DNAItem.EmbryoType.ANIMAL, properties);
        this.entityType = entityType;
        this.applicableCoatTypes = applicableCoatTypes;
    }

    public AnimalDNAItem(Supplier<EntityType<? extends Mob>> entityType, Properties properties) {
        super(DNAItem.EmbryoType.ANIMAL, properties);
        this.entityType = entityType;
        this.applicableCoatTypes = null;
    }

    public Supplier<EntityType<? extends Mob>> getEntityType() {
        return this.entityType;
    }

    public TagKey<CoatType> getApplicableCoatTypes() {
        return this.applicableCoatTypes;
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
