package willatendo.fossilslegacy.server.item.data_components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import willatendo.fossilslegacy.server.gene.cosmetics.CosmeticGeneHolder;
import willatendo.fossilslegacy.server.gene.cosmetics.FAModelGenes;
import willatendo.fossilslegacy.server.gene.cosmetics.FASkinGenes;

public record HeadDisplayInformation(int growthStage, CosmeticGeneHolder cosmeticGeneHolder) {
    public static final HeadDisplayInformation NONE = new HeadDisplayInformation(0, new CosmeticGeneHolder(FAModelGenes.ANKYLOSAURUS, FASkinGenes.ANKYLOSAURUS_2024));
    public static final Codec<HeadDisplayInformation> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("growth_stage").forGetter(HeadDisplayInformation::growthStage), CosmeticGeneHolder.CODEC.fieldOf("patternGenes").forGetter(HeadDisplayInformation::cosmeticGeneHolder)).apply(instance, HeadDisplayInformation::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, HeadDisplayInformation> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, HeadDisplayInformation::growthStage, CosmeticGeneHolder.STREAM_CODEC, HeadDisplayInformation::cosmeticGeneHolder, HeadDisplayInformation::new);

    public static HeadDisplayInformation loadAdditional(CompoundTag compoundTag) {
        int growthStage = compoundTag.getInt("growth_stage");
        return new HeadDisplayInformation(growthStage, CosmeticGeneHolder.loadAdditional(compoundTag));
    }

    public void saveAdditional(CompoundTag compoundTag) {
        compoundTag.putInt("growth_stage", this.growthStage());
        this.cosmeticGeneHolder().saveAdditional(compoundTag);
    }
}
