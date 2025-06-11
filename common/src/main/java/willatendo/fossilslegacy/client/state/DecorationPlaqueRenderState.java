package willatendo.fossilslegacy.client.state;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;

public class DecorationPlaqueRenderState extends EntityRenderState {
    public Direction direction;
    @Nullable
    public DecorationPlaqueType type;
    public int[] lightCoords;

    public DecorationPlaqueRenderState() {
        this.direction = Direction.NORTH;
        this.lightCoords = new int[0];
    }
}
