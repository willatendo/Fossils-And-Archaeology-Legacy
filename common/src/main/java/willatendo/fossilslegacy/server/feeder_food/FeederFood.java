package willatendo.fossilslegacy.server.feeder_food;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Map;
import java.util.stream.Collectors;

public record FeederFood(ResourceLocation item, FeederInfo feederInfo) {
    public static final Codec<FeederFood> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("item").forGetter(FeederFood::item), FeederFood.FeederInfo.CODEC.fieldOf("fill_type").forGetter(FeederFood::feederInfo)).apply(instance, FeederFood::new));

    public Item getItem() {
        return BuiltInRegistries.ITEM.getValue(this.item);
    }

    public static Map<Item, FeederFood.FeederInfo> getFeederFood(RegistryAccess registryAccess) {
        return registryAccess.lookupOrThrow(FARegistries.FEEDER_FOOD).stream().collect(Collectors.toMap(feederFood -> BuiltInRegistries.ITEM.getValue(feederFood.item()), FeederFood::feederInfo));
    }

    public record FeederInfo(int fillAmount, FeederFood.FillType fillType) {
        public static final Codec<FeederFood.FeederInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_INT.fieldOf("fill_amount").forGetter(FeederFood.FeederInfo::fillAmount), FeederFood.FillType.CODEC.fieldOf("fill_type").forGetter(FeederFood.FeederInfo::fillType)).apply(instance, FeederFood.FeederInfo::new));

        public boolean sameFillType(FillType fillType) {
            return this.fillType == fillType;
        }

        public boolean isMeat() {
            return this.fillType == FillType.MEAT;
        }
    }

    public enum FillType implements StringRepresentable {
        PLANT("plant"),
        MEAT("meat");

        public static final Codec<FillType> CODEC = StringRepresentable.fromEnum(FeederFood.FillType::values);
        private final String name;

        FillType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}
