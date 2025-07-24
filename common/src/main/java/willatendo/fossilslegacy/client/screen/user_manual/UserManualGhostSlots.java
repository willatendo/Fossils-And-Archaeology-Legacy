package willatendo.fossilslegacy.client.screen.user_manual;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.recipebook.SlotSelectTime;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.menu.menus.UserManualMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class UserManualGhostSlots {
    private static final ResourceLocation SLOT_HIGHLIGHT_BACK_SPRITE = ResourceLocation.withDefaultNamespace("container/slot_highlight_back");
    private static final ResourceLocation SLOT_HIGHLIGHT_FRONT_SPRITE = ResourceLocation.withDefaultNamespace("container/slot_highlight_front");
    private final List<UserManualGhostSlots.Slot> slots = new ArrayList<>();
    private final Minecraft minecraft = Minecraft.getInstance();
    private final UserManualMenu menu;
    private final SlotSelectTime slotSelectTime;
    private UserManualGhostSlots.Slot hoveredSlot;
    private int leftPos;
    private int topPos;
    private int imageWidth;
    private int imageHeight;

    public UserManualGhostSlots(UserManualMenu menu, SlotSelectTime slotSelectTime, int leftPos, int topPos, int imageWidth, int imageHeight) {
        this.menu = menu;
        this.slotSelectTime = slotSelectTime;
        this.leftPos = leftPos;
        this.topPos = topPos;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public void add(UserManualGhostSlots.Slot slot) {
        if (!this.slots.contains(slot)) {
            this.slots.add(slot);
        }
    }

    public void clear() {
        this.slots.clear();
    }

    public int size() {
        return this.slots.size();
    }

    public void add(List<ItemStack> itemStacks, int x, int y, int width, int height) {
        this.add(new Slot(itemStacks, x, y, width, height));
    }

    public void addContainers(List<ItemLike> itemLikes, int x, int y, int width, int height) {
        this.add(new Slot(itemLikes.stream().map(ItemStack::new).toList(), x, y, width, height));
    }

    private UserManualGhostSlots.Slot getHoveredSlot(double mouseX, double mouseY) {
        Iterator<UserManualGhostSlots.Slot> slots = this.slots.iterator();

        for (UserManualGhostSlots.Slot slot : this.slots) {
            if (this.isHovering(slot, mouseX, mouseY)) {
                return slot;
            }
        }
        return null;
    }

    private boolean isHovering(UserManualGhostSlots.Slot slot, double mouseX, double mouseY) {
        return this.isHovering(slot.x, slot.y, 16, 16, mouseX, mouseY);
    }

    private boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
        return mouseX >= (double) (x - 1) && mouseX < (double) (x + width + 1) && mouseY >= (double) (y - 1) && mouseY < (double) (y + height + 1);
    }

    public void render(GuiGraphics guiGraphics, int x, int y) {
        this.hoveredSlot = this.getHoveredSlot(x, y);
        this.renderSlotHighlightBack(guiGraphics);
        this.renderSlots(guiGraphics);
        this.renderSlotHighlightFront(guiGraphics);
    }

    private void renderSlots(GuiGraphics guiGraphics) {
        for (UserManualGhostSlots.Slot slot : this.slots) {
            this.renderSlot(guiGraphics, slot);
        }
    }

    protected void renderSlot(GuiGraphics guiGraphics, UserManualGhostSlots.Slot slot) {
        int x = slot.x;
        int y = slot.y;
        List<ItemStack> itemStacks = slot.getItems();
        ItemStack itemStack = itemStacks.isEmpty() ? ItemStack.EMPTY : itemStacks.size() < 2 ? itemStacks.getFirst() : this.getItem(itemStacks, this.slotSelectTime.currentIndex());
        int seed = x + y * this.imageWidth;

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0.0F, 0.0F, 100.0F);

        guiGraphics.renderItem(itemStack, x, y, seed);
        guiGraphics.renderItemDecorations(this.minecraft.font, itemStack, x, y, null);

        guiGraphics.pose().popPose();
    }

    public ItemStack getItem(List<ItemStack> itemStacks, int index) {
        int size = itemStacks.size();
        return size == 0 ? ItemStack.EMPTY : itemStacks.get(index % size);
    }

    private void renderSlotHighlightBack(GuiGraphics guiGraphics) {
        if (this.hoveredSlot != null) {
            guiGraphics.blitSprite(RenderType::guiTextured, SLOT_HIGHLIGHT_BACK_SPRITE, this.hoveredSlot.x - 4, this.hoveredSlot.y - 4, 24, 24);
        }
    }

    private void renderSlotHighlightFront(GuiGraphics guiGraphics) {
        if (this.hoveredSlot != null) {
            guiGraphics.blitSprite(RenderType::guiTexturedOverlay, SLOT_HIGHLIGHT_FRONT_SPRITE, this.hoveredSlot.x - 4, this.hoveredSlot.y - 4, 24, 24);
        }
    }

    public void renderTooltips(GuiGraphics guiGraphics, int x, int y) {
        if (this.hoveredSlot != null) {
            List<ItemStack> itemStacks = this.hoveredSlot.getItems();
            ItemStack itemStack = itemStacks.isEmpty() ? ItemStack.EMPTY : itemStacks.size() < 2 ? itemStacks.getFirst() : this.getItem(itemStacks, this.slotSelectTime.currentIndex());
            if (this.menu.getCarried().isEmpty() || this.showTooltipWithItemInHand(itemStack)) {
                guiGraphics.renderTooltip(this.minecraft.font, this.getTooltipFromContainerItem(itemStack), itemStack.getTooltipImage(), x, y, itemStack.get(DataComponents.TOOLTIP_STYLE));
            }
        }
    }

    private boolean showTooltipWithItemInHand(ItemStack itemStack) {
        return itemStack.getTooltipImage().map(ClientTooltipComponent::create).map(ClientTooltipComponent::showTooltipWithItemInHand).orElse(false);
    }

    private List<Component> getTooltipFromContainerItem(ItemStack itemStack) {
        return Screen.getTooltipFromItem(this.minecraft, itemStack);
    }

    public static class Slot {
        List<ItemStack> itemStacks = List.of();
        final int x;
        final int y;
        final int width;
        final int height;

        public Slot(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public Slot(ItemStack itemStacks, int x, int y, int width, int height) {
            this.itemStacks = List.of(itemStacks);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public Slot(List<ItemStack> itemStacks, int x, int y, int width, int height) {
            this.itemStacks = itemStacks;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public List<ItemStack> getItems() {
            return this.itemStacks;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof UserManualGhostSlots.Slot slot) {
                return this.x == slot.x && this.y == slot.y && this.width == slot.width && this.height == slot.height;
            }
            return false;
        }
    }
}
