package willatendo.fossilslegacy.client.user_manual.draw;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.recipebook.SlotSelectTime;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.screen.UserManualScreen;

import java.util.List;

public interface SpriteDrawer {
    static SimpleSpriteDrawer simple(UserManualScreen screen, GuiGraphics guiGraphics, Font font, SlotSelectTime slotSelectTime, int leftPos, int topPos) {
        return new SimpleSpriteDrawer(screen, guiGraphics, font, slotSelectTime, leftPos, topPos);
    }

    void draw(int x, int y, int width, int height, int u, int v, ResourceLocation texture);

    void draw(int x, int y, Component component, int color);

    void drawSmall(int x, int y, Component component, int color);

    void draw(int x, int y, List<Component> components, int color);

    void drawSmall(int x, int y, List<Component> components, int color);

    void drawCentered(int x, int y, Component component, int color);

    void drawCenteredSmall(int x, int y, Component component, int color);

    void drawCentered(int x, int y, List<Component> components, int color);

    void drawCenteredSmall(int x, int y, List<Component> components, int color);

    final class SimpleSpriteDrawer implements SpriteDrawer {
        private final UserManualScreen screen;
        private final GuiGraphics guiGraphics;
        private final Font font;
        private final SlotSelectTime slotSelectTime;
        private final int leftPos;
        private final int topPos;

        private SimpleSpriteDrawer(UserManualScreen screen, GuiGraphics guiGraphics, Font font, SlotSelectTime slotSelectTime, int leftPos, int topPos) {
            this.screen = screen;
            this.guiGraphics = guiGraphics;
            this.font = font;
            this.slotSelectTime = slotSelectTime;
            this.leftPos = leftPos;
            this.topPos = topPos;
        }

        @Override
        public void draw(int x, int y, int width, int height, int u, int v, ResourceLocation texture) {
            this.guiGraphics.blitSprite(RenderType::guiTextured, texture, this.leftPos + x, this.topPos + y, width, height);
        }

        @Override
        public void draw(int x, int y, Component component, int color) {
            this.guiGraphics.drawString(this.font, component, this.leftPos + x, this.topPos + y, color, false);
        }

        @Override
        public void drawSmall(int x, int y, Component component, int color) {
            this.guiGraphics.pose().pushPose();
            this.guiGraphics.pose().scale(0.75F, 0.75F, 0.75F);
            this.draw(x, y, component, color);
            this.guiGraphics.pose().popPose();
        }

        @Override
        public void draw(int x, int y, List<Component> components, int color) {
            this.guiGraphics.drawString(this.font, this.getItem(components, this.slotSelectTime.currentIndex()), this.leftPos + x, this.topPos + y, color, false);
        }

        @Override
        public void drawSmall(int x, int y, List<Component> components, int color) {
            this.guiGraphics.pose().pushPose();
            this.guiGraphics.pose().scale(0.75F, 0.75F, 0.75F);
            this.draw(x, y, components, color);
            this.guiGraphics.pose().popPose();
        }

        @Override
        public void drawCentered(int x, int y, Component component, int color) {
            this.screen.drawCenteredStringNoShadow(this.guiGraphics, this.font, component, this.leftPos + x, this.topPos + y, color);
        }

        @Override
        public void drawCenteredSmall(int x, int y, Component component, int color) {
            this.guiGraphics.pose().pushPose();
            this.guiGraphics.pose().scale(0.75F, 0.75F, 0.75F);
            this.drawCentered(x, y, component, color);
            this.guiGraphics.pose().popPose();
        }

        @Override
        public void drawCentered(int x, int y, List<Component> components, int color) {
            this.screen.drawCenteredStringNoShadow(this.guiGraphics, this.font, this.getItem(components, this.slotSelectTime.currentIndex()), this.leftPos + x, this.topPos + y, color);
        }

        @Override
        public void drawCenteredSmall(int x, int y, List<Component> components, int color) {
            this.guiGraphics.pose().pushPose();
            this.guiGraphics.pose().scale(0.75F, 0.75F, 0.75F);
            this.drawCentered(x, y, this.getItem(components, this.slotSelectTime.currentIndex()), color);
            this.guiGraphics.pose().popPose();
        }

        public Component getItem(List<Component> components, int index) {
            int size = components.size();
            return size == 0 ? Component.empty() : components.get(index % size);
        }
    }
}
