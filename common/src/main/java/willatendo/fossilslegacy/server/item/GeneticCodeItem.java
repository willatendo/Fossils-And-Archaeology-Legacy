package willatendo.fossilslegacy.server.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

public class GeneticCodeItem extends Item {
    private final TagKey<CoatType> geneticInfo;

    public GeneticCodeItem(TagKey<CoatType> geneticInfo, Properties properties) {
        super(properties);
        this.geneticInfo = geneticInfo;
    }

    public TagKey<CoatType> getGeneticInfo() {
        return this.geneticInfo;
    }
}
