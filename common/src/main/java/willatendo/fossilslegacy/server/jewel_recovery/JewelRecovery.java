package willatendo.fossilslegacy.server.jewel_recovery;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.List;

public record JewelRecovery(ResourceLocation block, List<JewelEntry> jewelEntries) {
    public static final Codec<JewelRecovery> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("block").forGetter(JewelRecovery::block), Codec.list(JewelRecovery.JewelEntry.CODEC).fieldOf("entries").forGetter(JewelRecovery::jewelEntries)).apply(instance, JewelRecovery::new));

    public Block getBlock() {
        return BuiltInRegistries.BLOCK.get(this.block);
    }

    public List<ItemStack> outputs() {
        return this.jewelEntries.stream().map(JewelEntry::jewel).toList();
    }

    public SimpleWeightedRandomList<ItemStack> getJewels() {
        SimpleWeightedRandomList.Builder<ItemStack> weightedRandomList = SimpleWeightedRandomList.builder();
        this.jewelEntries.forEach(jewelEntry -> {
            weightedRandomList.add(jewelEntry.jewel(), jewelEntry.weight());
        });
        return weightedRandomList.build();
    }

    public record JewelEntry(ItemStack jewel, int weight) {
        public static final Codec<JewelEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("jewel").forGetter(JewelRecovery.JewelEntry::jewel), ExtraCodecs.POSITIVE_INT.fieldOf("weight").forGetter(JewelRecovery.JewelEntry::weight)).apply(instance, JewelRecovery.JewelEntry::new));
    }
}
