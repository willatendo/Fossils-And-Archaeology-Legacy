package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;

public class ChromosomedEntityRenderState extends LivingEntityRenderState {
    public EntityType<?> type;
    public Holder<ModelGene> modelGene;
    public Holder<SkinGene> skinGene;
    public Holder<PatternGene> patternGene;
}
