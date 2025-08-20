package willatendo.fossilslegacy.server.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.FAModelGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.FASkinGenes;

public record Chromosome(CosmeticGeneHolder cosmeticGeneHolder, AttributeGeneHolder attributeGeneHolder) {
    public static final Chromosome BLANK = new Chromosome(new CosmeticGeneHolder(FAModelGenes.ANKYLOSAURUS, FASkinGenes.ANKYLOSAURUS_2024), new AttributeGeneHolder());
    public static final Codec<Chromosome> CODEC = RecordCodecBuilder.create(instance -> instance.group(CosmeticGeneHolder.CODEC.fieldOf("cosmetics").forGetter(Chromosome::cosmeticGeneHolder), AttributeGeneHolder.CODEC.fieldOf("attributes").forGetter(Chromosome::attributeGeneHolder)).apply(instance, Chromosome::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, Chromosome> STREAM_CODEC = StreamCodec.composite(CosmeticGeneHolder.STREAM_CODEC, Chromosome::cosmeticGeneHolder, AttributeGeneHolder.STREAM_CODEC, Chromosome::attributeGeneHolder, Chromosome::new);

    public void saveAdditional(CompoundTag compoundTag) {
        CompoundTag cosmetics = new CompoundTag();
        this.cosmeticGeneHolder.saveAdditional(cosmetics);
        compoundTag.put("cosmetics", cosmetics);
        CompoundTag attributes = new CompoundTag();
        this.attributeGeneHolder.saveAdditional(attributes);
        compoundTag.put("attributes", attributes);
    }

    public static Chromosome loadAdditional(CompoundTag compoundTag) {
        CosmeticGeneHolder cosmeticGeneHolder = CosmeticGeneHolder.loadAdditional(compoundTag.getCompound("cosmetics"));
        AttributeGeneHolder attributeGeneHolder = AttributeGeneHolder.loadAdditional(compoundTag.getCompound("attributes"));

        return new Chromosome(cosmeticGeneHolder, attributeGeneHolder);
    }
}
