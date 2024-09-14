package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.item.DNAItem;
import willatendo.fossilslegacy.server.menu.GeneModifierMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class GeneModifierScreen extends AbstractContainerScreen<GeneModifierMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/gene_modifier.png");
    private float xMouse;
    private float yMouse;

    public GeneModifierScreen(GeneModifierMenu geneModifierMenu, Inventory inventory, Component title) {
        super(geneModifierMenu, inventory, title);
        this.imageHeight = 187;
        this.inventoryLabelY = 93;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.xMouse = (float) mouseX;
        this.yMouse = (float) mouseY;
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        Slot slot = this.menu.slots.get(0);
        if (slot.hasItem()) {
            ItemStack itemStack = slot.getItem();
            if (itemStack.getItem() instanceof DNAItem dnaItem) {
                EntityType<? extends Mob> entityType = dnaItem.getEntityType().get();
                Mob mob = entityType.create(this.menu.player.level());
                InventoryScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos + 70, this.topPos + 10, this.leftPos + 70, this.topPos + 70, 17, 0.25F, this.xMouse, this.yMouse, mob);
            }
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0xC9C9C9, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
