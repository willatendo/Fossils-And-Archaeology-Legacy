package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;

public class StoneTabletRenderState extends EntityRenderState {
    public Direction direction;
    @Nullable
    public StoneTabletVariant variant;
    public int[] lightCoords;

    public StoneTabletRenderState() {
        this.direction = Direction.NORTH;
        this.lightCoords = new int[0];
    }
}
