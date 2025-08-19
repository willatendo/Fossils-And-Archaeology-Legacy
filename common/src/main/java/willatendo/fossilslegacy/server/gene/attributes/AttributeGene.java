package willatendo.fossilslegacy.server.gene.attributes;

import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;

public record AttributeGene(ResourceKey<AttributeGene> id, Holder<Attribute> geneEffect, float multiplication, int color, ChatFormatting displayColor, int height, ResourceLocation texture) {
    public static final Codec<Holder<AttributeGene>> CODEC = FABuiltInRegistries.GENE.holderByNameCodec();
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<AttributeGene>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.ATTRIBUTE_GENE);

    public String getDescriptionID() {
        return Util.makeDescriptionId("gene", this.id.location());
    }

    public Component getDisplayName() {
        return Component.translatable(this.getDescriptionID());
    }
}
