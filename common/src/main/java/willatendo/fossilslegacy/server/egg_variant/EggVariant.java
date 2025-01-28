package willatendo.fossilslegacy.server.egg_variant;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;
import java.util.function.Supplier;

public record EggVariant(EggSize eggSize, ResourceLocation texture, boolean wet, Function<Egg, Boolean> incubate, ResourceKey<LootTable> lootTable, Supplier<EntityType> entityType, Supplier<Item> pick) {
    public Component getTemperature(Egg egg) {
        if (this.wet) {
            return this.shouldIncubate(egg) ? FossilsLegacyUtils.translation("dinopedia", "wet") : FossilsLegacyUtils.translation("dinopedia", "dry");
        } else {
            return this.shouldIncubate(egg) ? FossilsLegacyUtils.translation("dinopedia", "warm") : FossilsLegacyUtils.translation("dinopedia", "cold");
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
