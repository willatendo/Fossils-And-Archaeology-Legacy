package willatendo.fossilslegacy.server.gene.cosmetics;

import com.mojang.serialization.MapCodec;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.CompositeTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.PackageTextureInformation;
import willatendo.fossilslegacy.server.gene.cosmetics.information.TextureInformationType;
import willatendo.fossilslegacy.server.gene.cosmetics.information.type.BlankTextureInformation;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FATextureInformationTypes {
    public static final SimpleRegistry<TextureInformationType<?>> PATTERN_INFORMATION_TYPES = SimpleRegistry.create(FARegistries.TEXTURE_INFORMATION_TYPE, FAUtils.ID);

    public static final SimpleHolder<TextureInformationType<BlankTextureInformation>> BLANK = FATextureInformationTypes.register("blank", BlankTextureInformation.CODEC);
    public static final SimpleHolder<TextureInformationType<CompositeTextureInformation>> COMPOSITE = FATextureInformationTypes.register("composite", CompositeTextureInformation.CODEC);
    public static final SimpleHolder<TextureInformationType<PackageTextureInformation>> PACKAGE = FATextureInformationTypes.register("package", PackageTextureInformation.CODEC);

    private static <T extends TextureInformation> SimpleHolder<TextureInformationType<T>> register(String id, MapCodec<T> codec) {
        return PATTERN_INFORMATION_TYPES.register(id, () -> () -> codec);
    }
}
