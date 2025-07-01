package willatendo.fossilslegacy.server.item.items;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFossilVariantTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticulatedFossilItem extends PlaceEntityItem<Fossil> {
    public ArticulatedFossilItem(Properties properties) {
        super(FAEntityTypes.FOSSIL::get, properties);
    }

    @Override
    public Component getName(ItemStack itemStack) {
        if (itemStack.has(FADataComponents.FOSSIL_VARIANT.get())) {
            Holder<FossilVariant> fossilVariantHolder = itemStack.get(FADataComponents.FOSSIL_VARIANT.get());
            String[] name = fossilVariantHolder.getRegisteredName().split(":");
            return Component.translatable("item." + name[0] + ".articulated_fossil." + name[1]);
        }
        return super.getName(itemStack);
    }

    @Override
    public void entityModification(ItemStack itemStack, Fossil fossil) {
        Level level = fossil.level();
        if (itemStack.has(FADataComponents.FOSSIL_VARIANT.get())) {
            fossil.setFossilVariant(itemStack.get(FADataComponents.FOSSIL_VARIANT.get()));
        } else {
            List<Holder<FossilVariant>> fossilVariants = new ArrayList<>();
            level.registryAccess().lookupOrThrow(FARegistries.FOSSIL_VARIANTS).getTagOrEmpty(FAFossilVariantTags.PLACEABLE_FROM_FOSSIL).forEach(fossilVariants::add);
            Optional<Holder<FossilVariant>> optional = Util.getRandomSafe(fossilVariants, fossil.level().getRandom());
            fossil.setFossilVariant(optional.get());
        }
        fossil.setSize(0);
    }

    @Override
    public boolean rotationModification(Player player, BlockPos placePos, double yOffset, RandomSource randomSource, Fossil entity) {
        if (player.isCrouching()) {
            return false;
        } else {
            entity.moveTo((double) placePos.getX() + 0.5D, (double) placePos.getY() + yOffset, (double) placePos.getZ() + 0.5D, player.getYRot() + 180.0F, 0.0F);
            return true;
        }
    }
}
