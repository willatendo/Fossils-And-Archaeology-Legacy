package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.entity.genetics.cosmetics.CoatType;

import java.util.Optional;

public class MammothRenderer extends CoatTypeMobRenderer<Mammoth> {
    public MammothRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Mammoth mammoth, CoatType coatType) {
        return mammoth.isSheared() ? coatType.textures().shearedTexture() : Optional.empty();
    }
}
