package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.menu.PalaeontologyTableMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class PalaeontologyTableScreen extends AbstractContainerScreen<PalaeontologyTableMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/palaeontology_table.png");
    private static final ResourceLocation FOSSIL_VARIANT_HIGHLIGHTED_SPRITE = FossilsLegacyUtils.resource("container/palaeontology_table/fossil_variant_highlighted");
    private static final ResourceLocation FOSSIL_VARIANT_SELECTED_SPRITE = FossilsLegacyUtils.resource("container/palaeontology_table/fossil_variant_selected");
    private static final ResourceLocation FOSSIL_VARIANT_SPRITE = FossilsLegacyUtils.resource("container/palaeontology_table/fossil_variant");
    private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/scroller");
    private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/scroller_disabled");
    private final List<Holder<FossilVariant>> fossilVariants = this.menu.getSelectableFossilVariants();
    private float scrollOffs;
    private boolean scrolling;
    private int startRow;

    public PalaeontologyTableScreen(PalaeontologyTableMenu palaeontologyTableMenu, Inventory inventory, Component title) {
        super(palaeontologyTableMenu, inventory, title);
        palaeontologyTableMenu.registerUpdateListener(this::containerChanged);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        super.render(guiGraphics, x, y, partialTicks);
        this.renderTooltip(guiGraphics, x, y);
    }

    private int totalRowCount() {
        return Mth.positiveCeilDiv(this.fossilVariants.size(), 4);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        guiGraphics.blitSprite(!this.fossilVariants.isEmpty() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE, this.leftPos + 124, this.topPos + 16 + (int) (41.0F * this.scrollOffs), 12, 15);

        if (!this.fossilVariants.isEmpty()) {
            int leftPos = this.leftPos + 67;
            int topPos = this.topPos + 16;

            draw:
            for (int row = 0; row < 3; ++row) {
                for (int column = 0; column < 3; ++column) {
                    int startRow = row + this.startRow;
                    int index = startRow * 3 + column;
                    if (index >= this.fossilVariants.size()) {
                        break draw;
                    }

                    int x = leftPos + column * 18;
                    int y = topPos + row * 18;
                    boolean flag = mouseX >= x && mouseY >= y && mouseX < x + 18 && mouseY < y + 18;
                    ResourceLocation texture;
                    if (index == this.menu.getSelectedFossilVariantIndex()) {
                        texture = FOSSIL_VARIANT_SELECTED_SPRITE;
                    } else if (flag) {
                        texture = FOSSIL_VARIANT_HIGHLIGHTED_SPRITE;
                    } else {
                        texture = FOSSIL_VARIANT_SPRITE;
                    }

                    guiGraphics.blitSprite(texture, x, y, 18, 18);

                    ItemStack itemStack = new ItemStack(FossilsLegacyItems.ARTICULATED_FOSSIL.get());
                    itemStack.set(FossilsLegacyDataComponents.FOSSIL_VARIANT.get(), this.fossilVariants.get(index));
                    guiGraphics.renderItem(itemStack, x + 1, y + 1);
                }
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        if (!this.fossilVariants.isEmpty()) {
            int leftPos = this.leftPos + 67;
            int topPos = this.topPos + 16;

            for (int row = 0; row < 3; ++row) {
                for (int column = 0; column < 3; ++column) {
                    double leftButton = mouseX - (leftPos + column * 18);
                    double rightButton = mouseY - (topPos + row * 18);
                    int startRow = row + this.startRow;
                    int size = startRow * 3 + column;
                    if (leftButton >= 0.0D && rightButton >= 0.0D && leftButton < 18.0D && rightButton < 18.0D && this.menu.clickMenuButton(this.minecraft.player, size)) {
                        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
                        this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, size);
                        return true;
                    }
                }
            }

            leftPos = this.leftPos + 124;
            topPos = this.topPos + 9;
            if (mouseX >= leftPos && mouseX < leftPos + 12 && mouseY >= topPos && mouseY < topPos + 53) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double pMouseX, double pMouseY, int pButton, double pDragX, double pDragY) {
        int rowCount = this.totalRowCount() - 4;
        if (this.scrolling && !this.fossilVariants.isEmpty() && rowCount > 0) {
            int topPos = this.topPos + 16;
            int maxTopPos = topPos + 54;
            this.scrollOffs = ((float) pMouseY - (float) topPos - 7.5F) / ((float) (maxTopPos - topPos) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startRow = Math.max((int) ((double) (this.scrollOffs * (float) rowCount) + 0.5), 0);
            return true;
        } else {
            return super.mouseDragged(pMouseX, pMouseY, pButton, pDragX, pDragY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        int rowCount = this.totalRowCount() - 4;
        if (!this.fossilVariants.isEmpty() && rowCount > 0) {
            float percentage = (float) scrollY / (float) rowCount;
            this.scrollOffs = Mth.clamp(this.scrollOffs - percentage, 0.0F, 1.0F);
            this.startRow = Math.max((int) (this.scrollOffs * (float) rowCount + 0.5F), 0);
        }

        return true;
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);

        if (!this.fossilVariants.isEmpty()) {
            int leftPos = this.leftPos + 67;
            int topPos = this.topPos + 16;

            draw:
            for (int row = 0; row < 3; ++row) {
                for (int column = 0; column < 3; ++column) {
                    int startRow = row + this.startRow;
                    int size = startRow * 3 + column;
                    if (size >= this.fossilVariants.size()) {
                        break draw;
                    }

                    int x = leftPos + column * 18;
                    int y = topPos + row * 18;
                    boolean flag = mouseX >= x && mouseY >= y && mouseX < x + 18 && mouseY < y + 18;
                    if (flag) {
                        guiGraphics.renderTooltip(this.font, Component.translatable(Util.makeDescriptionId("fossil_variant", ResourceLocation.parse(fossilVariants.get(size).getRegisteredName()))), mouseX, mouseY);
                    }
                }
            }
        }
    }

    private void containerChanged() {
        if (this.startRow >= this.totalRowCount()) {
            this.startRow = 0;
            this.scrollOffs = 0.0F;
        }
    }
}
