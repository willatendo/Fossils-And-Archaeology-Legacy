package willatendo.fossilslegacy.server.ancient_axe_bonus;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public record AncientAxeBonus(ResourceLocation input, ItemStack output, int minDrop, int maxDrop) {
    public static final Codec<AncientAxeBonus> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("input").forGetter(AncientAxeBonus::input), ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("output").forGetter(AncientAxeBonus::output), ExtraCodecs.POSITIVE_INT.fieldOf("min_drop").forGetter(AncientAxeBonus::minDrop), ExtraCodecs.POSITIVE_INT.fieldOf("max_drop").forGetter(AncientAxeBonus::maxDrop)).apply(instance, AncientAxeBonus::new));

    public Block getInput() {
        return BuiltInRegistries.BLOCK.getValue(this.input);
    }
}
