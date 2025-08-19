package willatendo.fossilslegacy.server.gene.cosmetics.information.type;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextureInformationTypes;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformationType;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;
import java.util.Map;

public final class BlankTextureInformation implements TextureInformation {
    private static final BlankTextureInformation INSTANCE = new BlankTextureInformation();
    public static final MapCodec<BlankTextureInformation> CODEC = MapCodec.unit(() -> BlankTextureInformation.INSTANCE);

    @Override
    public TextureInformationType<?> type() {
        return FATextureInformationTypes.BLANK.get();
    }

    @Override
    public Map<ResourceKey<Texture>, ResourceLocation> getTextures(Registry<Texture> textureRegistry, String textureName, List<ResourceKey<Texture>> requiredTextures) {
        return Map.of();
    }
}
