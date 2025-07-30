package willatendo.fossilslegacy.client.user_manual.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public record Drop(Item drop, Optional<Component> description) {
    public static final Codec<Drop> CODEC = RecordCodecBuilder.create(instance -> instance.group(BuiltInRegistries.ITEM.byNameCodec().fieldOf("drop").forGetter(Drop::drop), ComponentSerialization.CODEC.optionalFieldOf("description").forGetter(Drop::description)).apply(instance, Drop::new));

    public static Drop drop(ItemLike itemLike, Component chance) {
        return new Drop(itemLike.asItem(), Optional.of(chance));
    }

    public static Drop silkTouch(ItemLike itemLike) {
        return new Drop(itemLike.asItem(), Optional.of(FAUtils.translation("item", "user_manual.drop.requirement.silk_touch")));
    }

    public static Drop drop(ItemLike itemLike) {
        return new Drop(itemLike.asItem(), Optional.empty());
    }
}

