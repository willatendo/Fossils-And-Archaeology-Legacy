package willatendo.fossilslegacy.server.fuel;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Map;
import java.util.stream.Collectors;

public record FuelEntry(ResourceLocation fuel, Integer time) {
    public static final Codec<FuelEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("fuel").forGetter(FuelEntry::fuel), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("time").forGetter(FuelEntry::time)).apply(instance, FuelEntry::new));

    public static Map<Item, Integer> getFuel(HolderGetter<FuelEntry> holderGetter, TagKey<FuelEntry> fuelEntries) {
        return holderGetter.get(fuelEntries).get().stream().collect(Collectors.toMap(fuelEntry -> BuiltInRegistries.ITEM.getValue(fuelEntry.value().fuel()), fuelEntry -> fuelEntry.value().time()));
    }
}
