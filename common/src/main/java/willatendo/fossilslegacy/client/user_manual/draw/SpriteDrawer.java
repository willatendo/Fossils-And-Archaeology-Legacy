package willatendo.fossilslegacy.client.user_manual.draw;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class SpriteDrawer {
    private final Map<SpriteInformation, ResourceLocation> spriteData = new HashMap<>();
    private final Map<TextInformation, Component> textData = new HashMap<>();

    public void draw(int x, int y, int width, int height, int u, int v, ResourceLocation texture) {
        this.spriteData.put(new SpriteInformation(new Coordinate(x, y), width, height, u, v), texture);
    }

    public void draw(int x, int y, Component component, int color) {
        this.textData.put(new TextInformation(new Coordinate(x, y), color), component);
    }

    public Set<Map.Entry<SpriteInformation, ResourceLocation>> forEachSprite() {
        return this.spriteData.entrySet();
    }

    public Set<Map.Entry<TextInformation, Component>> forEachText() {
        return this.textData.entrySet();
    }
}
