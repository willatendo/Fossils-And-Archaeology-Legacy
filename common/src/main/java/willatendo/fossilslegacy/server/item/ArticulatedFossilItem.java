package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.tags.FossilsLegacyFossilVariantTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticulatedFossilItem extends PlaceEntityItem<Fossil> {
    public ArticulatedFossilItem(Properties properties) {
        super(FossilsLegacyEntityTypes.FOSSIL::get, properties);
    }

    @Override
    public Component getName(ItemStack itemStack) {
        if (itemStack.has(FossilsLegacyDataComponents.FOSSIL_VARIANT.get())) {
            Holder<FossilVariant> fossilVariantHolder = itemStack.get(FossilsLegacyDataComponents.FOSSIL_VARIANT.get());
            String[] name = fossilVariantHolder.getRegisteredName().split(":");
            return Component.translatable("item." + name[0] + ".articulated_fossil." + name[1]);
        }
        return super.getName(itemStack);
    }

    @Override
    public void entityModification(ItemStack itemStack, Fossil fossil) {
        Level level = fossil.level();
        if (itemStack.has(FossilsLegacyDataComponents.FOSSIL_VARIANT.get())) {
            fossil.setFossilVariant(itemStack.get(FossilsLegacyDataComponents.FOSSIL_VARIANT.get()));
        } else {
            List<Holder<FossilVariant>> fossilVariants = new ArrayList<>();
            level.registryAccess().registryOrThrow(FossilsLegacyRegistries.FOSSIL_VARIANTS).getTagOrEmpty(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL).forEach(fossilVariants::add);
            Optional<Holder<FossilVariant>> optional = Util.getRandomSafe(fossilVariants, fossil.level().getRandom());
            fossil.setFossilVariant(optional.get());
        }
        fossil.setSize(0);
    }
}
