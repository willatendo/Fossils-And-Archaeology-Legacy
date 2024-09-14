package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.function.BiFunction;

public class DebugItem extends Item {
    private final String type;
    private final BiFunction<Dinosaur, Player, InteractionResult> function;

    private DebugItem(String type, BiFunction<Dinosaur, Player, InteractionResult> function, Properties properties) {
        super(properties.stacksTo(1));
        this.type = type;
        this.function = function;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }

    public static DebugItem debugMaxHunger() {
        return new DebugItem("set_max_hunger", (dinosaur, player) -> {
            dinosaur.setHunger(dinosaur.getMaxHunger());
            return InteractionResult.SUCCESS;
        }, new Item.Properties());
    }

    public static DebugItem debugMaxHealth() {
        return new DebugItem("set_max_health", (dinosaur, player) -> {
            dinosaur.setHealth(dinosaur.getMaxHealth());
            return InteractionResult.SUCCESS;
        }, new Item.Properties());
    }

    public static DebugItem debugFullGrown() {
        return new DebugItem("set_full_grown", (dinosaur, player) -> {
            dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage());
            return InteractionResult.SUCCESS;
        }, new Item.Properties());
    }

    public static DebugItem debugBaby() {
        return new DebugItem("set_baby", (dinosaur, player) -> {
            dinosaur.setGrowthStage(0);
            return InteractionResult.SUCCESS;
        }, new Item.Properties());
    }

    public static DebugItem debugTame() {
        return new DebugItem("set_owner_as_me", (dinosaur, player) -> {
            dinosaur.setOwnerUUID(player.getUUID());
            return InteractionResult.SUCCESS;
        }, new Item.Properties());
    }

    public static DebugItem debugChangeGenetics() {
        return new DebugItem("change_genetics", (dinosaur, player) -> {
            if (player instanceof LocalPlayer) {
                Minecraft minecraft = Minecraft.getInstance();
            }
            return InteractionResult.SUCCESS;
        }, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(FossilsLegacyUtils.translation("debugItem", "type", FossilsLegacyUtils.translation("debugItem", this.type)).withStyle(ChatFormatting.GRAY));
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity instanceof Dinosaur dinosaur) {
            return this.function.apply(dinosaur, player);
        }
        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
