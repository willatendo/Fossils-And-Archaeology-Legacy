package willatendo.fossilslegacy.server.item.items;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.model_type.ModelType;

public class GeneticCodeItem extends Item {
    private final TagKey<ModelType> geneticInfo;

    public GeneticCodeItem(TagKey<ModelType> geneticInfo, Properties properties) {
        super(properties);
        this.geneticInfo = geneticInfo;
    }

    public TagKey<ModelType> getGeneticInfo() {
        return this.geneticInfo;
    }
}
