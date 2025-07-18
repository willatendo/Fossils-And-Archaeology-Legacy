package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

public class DataDrivenRenderState extends LivingEntityRenderState {
    public Registry<Texture> textureRegistry;
    public Holder<ModelType> modelType;
    public Holder<Pattern> skin;
    public Holder<Pattern> pattern;
}
