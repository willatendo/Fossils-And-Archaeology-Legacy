package willatendo.fossilslegacy.client.user_manual.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public record Drop(ItemStack itemStack, Optional<Component> description) {
    public static final Codec<Drop> CODEC = RecordCodecBuilder.create(instance -> instance.group(ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("drop").forGetter(Drop::itemStack), ComponentSerialization.CODEC.optionalFieldOf("description").forGetter(Drop::description)).apply(instance, Drop::new));


    public static Drop drop(ItemLike itemLike, Component description) {
        return Drop.drop(new ItemStack(itemLike.asItem()), description);
    }

    public static Drop silkTouch(ItemLike itemLike) {
        return Drop.silkTouch(new ItemStack(itemLike.asItem()));
    }

    public static Drop shears(ItemLike itemLike) {
        return Drop.shears(new ItemStack(itemLike.asItem()));
    }

    public static Drop drop(ItemLike itemLike) {
        return Drop.drop(new ItemStack(itemLike.asItem()));
    }

    public static Drop drop(ItemStack itemStack, Component chance) {
        return new Drop(itemStack, Optional.of(chance));
    }

    public static Drop silkTouch(ItemStack itemStack) {
        return new Drop(itemStack, Optional.of(FAUtils.translation("item", "user_manual.drop.requirement.silk_touch")));
    }

    public static Drop shears(ItemStack itemStack) {
        return new Drop(itemStack, Optional.of(FAUtils.translation("item", "user_manual.drop.requirement.shears")));
    }

    public static Drop drop(ItemStack itemStack) {
        return new Drop(itemStack, Optional.empty());
    }
}

