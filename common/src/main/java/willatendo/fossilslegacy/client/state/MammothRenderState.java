package willatendo.fossilslegacy.client.state;

import net.minecraft.world.item.DyeColor;

public class MammothRenderState extends DinosaurRenderState {
    public boolean isSheared;
    public DyeColor woolColor;
    public int id;

    public MammothRenderState() {
        this.woolColor = DyeColor.WHITE;
    }
}
