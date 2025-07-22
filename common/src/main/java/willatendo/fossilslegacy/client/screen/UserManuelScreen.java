package willatendo.fossilslegacy.client.screen;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.screen.user_manuel.UserManuelData;
import willatendo.fossilslegacy.server.menu.menus.UserManuelMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class UserManuelScreen extends AbstractContainerScreen<UserManuelMenu> {
    private static final ResourceLocation USER_MANUEL_TEXTURE = FAUtils.resource("textures/gui/container/user_manuel.png");

    public UserManuelScreen(UserManuelMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 280;
        this.imageHeight = 279;

        this.inventoryLabelX = 60;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        super.render(guiGraphics, x, y, partialTicks);
        this.renderTooltip(guiGraphics, x, y);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        guiGraphics.blit(RenderType::guiTextured, USER_MANUEL_TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 512, 512);

        ItemStack itemStack = this.menu.itemSlot.getItem(0);
        if (!itemStack.isEmpty()) {
            guiGraphics.drawString(this.font, itemStack.getHoverName(), this.leftPos + 170, this.topPos + 19, 0, false);

            UserManuelData.ItemPage itemPage = UserManuelData.getItemInformation(itemStack);
            List<ResourceLocation> recipes = itemPage.recipes();
            if (!recipes.isEmpty()) {
                Component clickForRecipes = Component.literal("Click for recipes").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.BOLD);
                guiGraphics.drawString(this.font, clickForRecipes, this.leftPos + 15, this.topPos + 35, 0, false);
            }
            List<Component> text = itemPage.information();
            int lastParagraph = 0;
            for (int i = 0; i < text.size(); i++) {
                Component paragraph = text.get(i);
                List<FormattedCharSequence> lines = this.font.split(paragraph, 116);
                for (int l = 0; l < lines.size(); l++) {
                    guiGraphics.drawString(this.font, lines.get(l), this.leftPos + 149, this.topPos + 35 + (l * 10) + lastParagraph, 0, false);
                    if (l == lines.size() - 1) {
                        lastParagraph += (l * 10) + 20;
                    }
                }
            }
        }
    }
}
