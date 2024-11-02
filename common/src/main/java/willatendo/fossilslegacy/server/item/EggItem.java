package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class EggItem extends PlaceEntityItem<Egg> {
    protected final Holder<EggVariant> eggVariant;
    protected final TagKey<CoatType> applicableCoatTypes;

    public EggItem(Holder<EggVariant> eggVariant, TagKey<CoatType> applicableCoatTypes, Properties properties) {
        super(FossilsLegacyEntityTypes.EGG::get, properties);
        this.eggVariant = eggVariant;
        this.applicableCoatTypes = applicableCoatTypes;
        FossilsLegacyItems.EGGS.add(this);
    }

    public Holder<EggVariant> getEggVariant() {
        return this.eggVariant;
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        egg.setEggVariant(this.eggVariant);
        if (itemStack.has(FossilsLegacyDataComponents.COAT_TYPE.get())) {
            egg.setCoatType(itemStack.get(FossilsLegacyDataComponents.COAT_TYPE.get()));
        } else {
            Level level = egg.level();
            Registry<CoatType> coatTypeRegistry = level.registryAccess().registry(FossilsLegacyRegistries.COAT_TYPES).get();
            egg.setCoatType(coatTypeRegistry.getTag(this.applicableCoatTypes).get().getRandomElement(egg.getRandom()).get());
        }
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
