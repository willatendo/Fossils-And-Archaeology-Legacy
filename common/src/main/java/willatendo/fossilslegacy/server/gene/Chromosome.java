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

public final class Chromosome {
    public static final Chromosome BLANK = new Chromosome(new CosmeticGeneHolder(FAModelGenes.ANKYLOSAURUS, FASkinGenes.ANKYLOSAURUS_2024), new AttributeGeneHolder());
    public static final Codec<Chromosome> CODEC = RecordCodecBuilder.create(instance -> instance.group(CosmeticGeneHolder.CODEC.fieldOf("cosmetics").forGetter(Chromosome::getCosmeticGeneHolder), AttributeGeneHolder.CODEC.fieldOf("attributes").forGetter(Chromosome::getAttributeGeneHolder)).apply(instance, Chromosome::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, Chromosome> STREAM_CODEC = StreamCodec.composite(CosmeticGeneHolder.STREAM_CODEC, Chromosome::getCosmeticGeneHolder, AttributeGeneHolder.STREAM_CODEC, Chromosome::getAttributeGeneHolder, Chromosome::new);
    private final CosmeticGeneHolder cosmeticGeneHolder;
    private final AttributeGeneHolder attributeGeneHolder;

    public Chromosome(CosmeticGeneHolder cosmeticGeneHolder, AttributeGeneHolder attributeGeneHolder) {
        this.cosmeticGeneHolder = cosmeticGeneHolder;
        this.attributeGeneHolder = attributeGeneHolder;
    }

    public CosmeticGeneHolder getCosmeticGeneHolder() {
        return this.cosmeticGeneHolder;
    }

    public AttributeGeneHolder getAttributeGeneHolder() {
        return this.attributeGeneHolder;
    }

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
