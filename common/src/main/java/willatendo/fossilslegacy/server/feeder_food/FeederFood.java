package willatendo.fossilslegacy.server.feeder_food;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Map;

public class FeederFood {
    public static final Codec<FeederFood> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("id").forGetter(FeederFood::getId), ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("item_stack").forGetter(FeederFood::getItemStack), ExtraCodecs.POSITIVE_INT.fieldOf("amount").forGetter(FeederFood::getAmount), FillType.CODEC.fieldOf("fill_type").forGetter(FeederFood::getFillType)).apply(instance, FeederFood::new));
    public static final Map<Item, ResourceLocation> ITEM_TO_ID = Maps.newHashMap();
    private final ResourceLocation id;
    private final ItemStack itemStack;
    private final int amount;
    private final FillType fillType;

    public FeederFood(ResourceLocation id, ItemStack itemStack, int amount, FillType fillType) {
        this.id = id;
        this.itemStack = itemStack;
        this.amount = amount;
        this.fillType = fillType;

        ITEM_TO_ID.put(itemStack.getItem(), id);
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public int getAmount() {
        return this.amount;
    }

    public FillType getFillType() {
        return this.fillType;
    }

    public boolean sameFillType(FillType fillType) {
        return this.fillType == fillType;
    }


    public static FeederFood getFeederFood(LevelAccessor levelAccessor, ItemStack itemStack) {
        Registry<FeederFood> feederFoodRegistry = levelAccessor.registryAccess().registryOrThrow(FARegistries.FEEDER_FOOD);
        if (ITEM_TO_ID.containsKey(itemStack.getItem())) {
            return feederFoodRegistry.get(ITEM_TO_ID.get(itemStack.getItem()));
        }
        return null;
    }

    public enum FillType implements StringRepresentable {
        PLANT("plant"),
        MEAT("meat");

        public static final Codec<FeederFood.FillType> CODEC = StringRepresentable.fromEnum(FeederFood.FillType::values);
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
