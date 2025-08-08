package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FADataComponents;

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
        if (itemStack.has(FADataComponents.FOSSIL_VARIANT.get())) {
            fossil.setFossilVariant(itemStack.get(FADataComponents.FOSSIL_VARIANT.get()));
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
