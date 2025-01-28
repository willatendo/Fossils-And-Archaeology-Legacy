package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class EggItem extends PlaceEntityItem<Egg> {
    public static final List<EggItem> EGGS = new ArrayList<>();
    protected final Holder<EggVariant> eggVariant;
    protected final TagKey<CoatType> applicableCoatTypes;

    public EggItem(Holder<EggVariant> eggVariant, TagKey<CoatType> applicableCoatTypes, Properties properties) {
        super(FAEntityTypes.EGG::get, properties);
        this.eggVariant = eggVariant;
        this.applicableCoatTypes = applicableCoatTypes;
        EggItem.EGGS.add(this);
    }

    public Holder<EggVariant> getEggVariant() {
        return this.eggVariant;
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        egg.setEggVariant(this.eggVariant);
        if (itemStack.has(FADataComponents.COAT_TYPE.get())) {
            egg.setCoatType(itemStack.get(FADataComponents.COAT_TYPE.get()));
        } else {
            Level level = egg.level();
            Registry<CoatType> coatTypeRegistry = level.registryAccess().registry(FARegistries.COAT_TYPES).get();
            egg.setCoatType(coatTypeRegistry.getTag(this.applicableCoatTypes).get().getRandomElement(egg.getRandom()).get());
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        if (itemStack.has(FADataComponents.COAT_TYPE.get())) {
            Holder<CoatType> holder = itemStack.get(FADataComponents.COAT_TYPE.get());
            components.add(FossilsLegacyUtils.translation("item", "dna.coat_type", holder.value().displayInfo().name()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
    }
}
