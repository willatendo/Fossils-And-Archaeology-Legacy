package willatendo.fossilslegacy.server.egg_variant;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.function.Function;
import java.util.function.Supplier;

public record EggVariant(EggSize eggSize, ResourceLocation texture, boolean wet, Function<Egg, Boolean> incubate, ResourceKey<LootTable> lootTable, Supplier<EntityType> entityType, Supplier<Item> pick) {
    public static final Codec<Holder<EggVariant>> CODEC = FABuiltInRegistries.EGG_VARIANTS.holderByNameCodec();

    public Component getTemperature(Egg egg) {
        if (this.wet) {
            return this.shouldIncubate(egg) ? FAUtils.translation("dinopedia", "wet") : FAUtils.translation("dinopedia", "dry");
        } else {
            return this.shouldIncubate(egg) ? FAUtils.translation("dinopedia", "warm") : FAUtils.translation("dinopedia", "cold");
        }
    }

    public boolean shouldIncubate(Egg egg) {
        return this.incubate.apply(egg);
    }

    public static boolean isWarm(Egg egg) {
        return egg.level().getBrightness(LightLayer.BLOCK, egg.blockPosition()) > 10.0F;
    }

    public enum EggSize {
        SMALL,
        REGULAR;
    }
}
