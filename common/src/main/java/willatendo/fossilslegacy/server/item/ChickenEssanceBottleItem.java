package willatendo.fossilslegacy.server.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.server.entity.util.GrowingEntity;

public class ChickenEssanceBottleItem extends DrinkingGlassBottleItem {
    public ChickenEssanceBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity instanceof GrowingEntity growingEntity) {
            if (growingEntity.getGrowthStage() < growingEntity.getMaxGrowthStage()) {
                growingEntity.setGrowthStage(growingEntity.getGrowthStage() + 1);
                livingEntity.setHealth((float) (livingEntity.getHealth() + growingEntity.getMinHealth()));
                ItemUtils.createFilledResult(itemStack, player, Items.GLASS_BOTTLE.getDefaultInstance());
                return InteractionResult.sidedSuccess(player.level().isClientSide());
            }
        }

        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
