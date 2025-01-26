package willatendo.fossilslegacy.server.item;

import com.google.common.collect.Lists;
import net.minecraft.world.item.Item;

import java.util.List;

public class DNAItem extends Item {
    public static final List<DNAItem> DNA = Lists.newArrayList();
    private final EmbryoType embryoType;

    public DNAItem(EmbryoType embryoType, Properties properties) {
        super(properties);
        this.embryoType = embryoType;

        DNA.add(this);
    }

    public EmbryoType getEmbryoType() {
        return this.embryoType;
    }

    public enum EmbryoType {
        ANIMAL,
        PLANT;
    }
}
