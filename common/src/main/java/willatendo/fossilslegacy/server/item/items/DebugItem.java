package willatendo.fossilslegacy.server.item.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.network.NetworkUtils;
import willatendo.fossilslegacy.network.clientbound.ClientboundOpenDebugGeneticsScreenPacket;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

import java.util.function.BiFunction;

public class DebugItem extends Item {
    private final BiFunction<Dinosaur, Player, InteractionResult> useOnFunction;

    public DebugItem(BiFunction<Dinosaur, Player, InteractionResult> useOnFunction, Properties properties) {
        super(properties.stacksTo(1));
        this.useOnFunction = useOnFunction;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }

    public static BiFunction<Dinosaur, Player, InteractionResult> debugMaxHunger() {
        return (dinosaur, player) -> {
            dinosaur.setHunger(dinosaur.getMaxHunger());
            return InteractionResult.SUCCESS;
        };
    }

    public static BiFunction<Dinosaur, Player, InteractionResult> debugMaxHealth() {
        return (dinosaur, player) -> {
            dinosaur.setHealth(dinosaur.getMaxHealth());
            return InteractionResult.SUCCESS;
        };
    }

    public static BiFunction<Dinosaur, Player, InteractionResult> debugFullGrown() {
        return (dinosaur, player) -> {
            dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage(), true);
            return InteractionResult.SUCCESS;
        };
    }

    public static BiFunction<Dinosaur, Player, InteractionResult> debugBaby() {
        return (dinosaur, player) -> {
            dinosaur.setGrowthStage(0, true);
            return InteractionResult.SUCCESS;
        };
    }

    public static BiFunction<Dinosaur, Player, InteractionResult> debugTame() {
        return (dinosaur, player) -> {
            dinosaur.setOwnerUUID(player.getUUID());
            return InteractionResult.SUCCESS;
        };
    }

    public static BiFunction<Dinosaur, Player, InteractionResult> debugChangeGenetics() {
        return (dinosaur, player) -> {
            if (player instanceof ServerPlayer serverPlayer) {
                NetworkUtils.sendToClient(serverPlayer, new ClientboundOpenDebugGeneticsScreenPacket(dinosaur.getId()));
            }
            return InteractionResult.SUCCESS;
        };
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity instanceof Dinosaur dinosaur) {
            return this.useOnFunction.apply(dinosaur, player);
        }
        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
