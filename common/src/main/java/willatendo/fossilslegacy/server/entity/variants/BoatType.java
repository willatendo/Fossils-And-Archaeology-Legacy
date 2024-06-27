package willatendo.fossilslegacy.server.entity.variants;

import net.minecraft.core.Holder;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.item.LepidodendronBoatItem;

public final record BoatType(String name, boolean raft, Holder<LepidodendronBoatItem> boat, Holder<LepidodendronBoatItem> chestBoat, Holder<Block> block) implements StringRepresentable {
    public BoatType(String name, Holder<LepidodendronBoatItem> boat, Holder<LepidodendronBoatItem> chestBoat, Holder<Block> block) {
        this(name, false, boat, chestBoat, block);
    }

    @Override
    public String getSerializedName() {
        return this.name();
    }
}
