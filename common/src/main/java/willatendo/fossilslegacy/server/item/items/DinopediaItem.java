package willatendo.fossilslegacy.server.item.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.ClientPlayerScreens;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;

public class DinopediaItem extends Item {
    public DinopediaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity instanceof DinopediaInformation dinopediaInformation) {
            if (player.level() instanceof ServerLevel) {
                return InteractionResult.PASS;
            }
            if (player.level().isClientSide()) {
                ClientPlayerScreens.openDinopediaScreen(player, livingEntity, dinopediaInformation);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResult.sidedSuccess(player.level().isClientSide());
            }
        }

        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
