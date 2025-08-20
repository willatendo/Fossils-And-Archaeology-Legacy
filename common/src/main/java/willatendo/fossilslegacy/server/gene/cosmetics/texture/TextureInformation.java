package willatendo.fossilslegacy.server.gene.cosmetics.texture;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public record TextureInformation(Optional<ResourceLocation> texture, EyeTextures eyeTextures) {
    public static final Codec<TextureInformation> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(TextureInformation::texture), TextureInformation.EyeTextures.CODEC.fieldOf("eye_textures").forGetter(TextureInformation::eyeTextures)).apply(instance, TextureInformation::new));

    public static TextureInformation simple(ResourceLocation texture, ResourceLocation eyeTexture, ResourceLocation closedEyeTexture) {
        return new TextureInformation(Optional.of(texture), new EyeTextures(Optional.of(eyeTexture), Optional.of(closedEyeTexture)));
    }

    public static TextureInformation empty() {
        return new TextureInformation(Optional.empty(), new EyeTextures(Optional.empty(), Optional.empty()));
    }

    public record EyeTextures(Optional<ResourceLocation> eyeTexture, Optional<ResourceLocation> closedEyeTexture) {
        public static final Codec<EyeTextures> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.optionalFieldOf("eye_texture").forGetter(TextureInformation.EyeTextures::eyeTexture), ResourceLocation.CODEC.optionalFieldOf("closed_eye_texture").forGetter(TextureInformation.EyeTextures::closedEyeTexture)).apply(instance, TextureInformation.EyeTextures::new));
    }
}
