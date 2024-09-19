package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface CommandingType {
    boolean canCommand(Player player, InteractionHand interactionHand);

    boolean canCommandWithItem(ItemStack itemStack);

    static CommandingType none() {
        return new CommandingType() {
            @Override
            public boolean canCommand(Player player, InteractionHand interactionHand) {
                return false;
            }

            @Override
            public boolean canCommandWithItem(ItemStack itemStack) {
                return false;
            }
        };
    }

    static CommandingType hand() {
        return new CommandingType() {
            @Override
            public boolean canCommand(Player player, InteractionHand interactionHand) {
                return player.getItemInHand(interactionHand).isEmpty();
            }

            @Override
            public boolean canCommandWithItem(ItemStack itemStack) {
                return false;
            }
        };
    }

    static CommandingType tag(TagKey<Item> tag) {
        return new CommandingType() {
            @Override
            public boolean canCommand(Player player, InteractionHand interactionHand) {
                return player.getItemInHand(interactionHand).is(tag);
            }

            @Override
            public boolean canCommandWithItem(ItemStack itemStack) {
                return itemStack.is(tag);
            }
        };
    }
}
