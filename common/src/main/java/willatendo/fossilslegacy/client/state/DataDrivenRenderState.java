package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

public class DataDrivenRenderState extends LivingEntityRenderState {
    public Registry<Texture> textureRegistry;
    public Holder<ModelGene> modelType;
    public Holder<PatternGene> skin;
    public Holder<PatternGene> pattern;
}
