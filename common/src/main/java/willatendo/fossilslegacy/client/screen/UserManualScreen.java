package willatendo.fossilslegacy.client.screen;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.gui.screens.recipebook.SlotSelectTime;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import willatendo.fossilslegacy.client.screen.user_manual.UserManualGhostSlots;
import willatendo.fossilslegacy.client.user_manual.SyncedData;
import willatendo.fossilslegacy.client.user_manual.UserManualData;
import willatendo.fossilslegacy.client.user_manual.UserManualItemDisplayData;
import willatendo.fossilslegacy.client.user_manual.draw.*;
import willatendo.fossilslegacy.client.user_manual.loot.DrawLootRecipe;
import willatendo.fossilslegacy.client.user_manual.recipe.type.RecipeTypeDrawInformationHolder;
import willatendo.fossilslegacy.server.menu.menus.UserManualMenu;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserManualScreen extends AbstractContainerScreen<UserManualMenu> {
    private static final ResourceLocation USER_MANUEL_TEXTURE = FAUtils.resource("textures/gui/container/user_manual.png");
    private static final ResourceLocation TAB_SPRITE = FAUtils.resource("container/user_manual/tab");
    private static final ResourceLocation SLOT_SPRITE = FAUtils.resource("container/user_manual/slot");
    private static final ResourceLocation LOOT_SPRITE = FAUtils.resource("container/user_manual/loot");
    private static final Component DROPS = FAUtils.translation("item", "user_manual.drops").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.BOLD);
    private static final Component RECIPES = FAUtils.translation("item", "user_manual.recipes").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.BOLD);
    private final SlotSelectTime slotSelectTime = () -> Mth.floor(this.time / 30.0F);
    private final RecipeMap recipeMap = SyncedData.getRecipes();
    private final Player player;
    private PageButton forwardRecipeButton;
    private PageButton backRecipeButton;
    private ItemStack lastItemStack;
    private boolean drawRecipes = false;
    private boolean drawDrops = false;
    private int recipePage = 0;
    private int recipePages = 0;
    private List<ResourceKey<Recipe<?>>> recipes;
    private int dropPage = 0;
    private int dropPages = 0;
    private List<DrawLootRecipe> drops;
    private float time;
    private UserManualGhostSlots recipeSlots;
    private UserManualGhostSlots dropSlots;

    public UserManualScreen(UserManualMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.player = inventory.player;
        this.imageWidth = 280;
        this.imageHeight = 279;

        this.inventoryLabelX = 60;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void init() {
        super.init();
        int leftPos = this.leftPos + this.imageWidth;
        int topPos = this.topPos + 68;
        this.recipeSlots = new UserManualGhostSlots(this.menu, this.slotSelectTime, this.leftPos, this.topPos, this.imageWidth, this.imageHeight);
        this.dropSlots = new UserManualGhostSlots(this.menu, this.slotSelectTime, this.leftPos, this.topPos, this.imageWidth, this.imageHeight);
        this.forwardRecipeButton = this.addRenderableWidget(new PageButton(leftPos + 153, topPos + 140, true, button -> {
            this.recipePage++;
            this.updateButtonVisibility();
            this.recipeSlots.clear();
        }, false));
        this.backRecipeButton = this.addRenderableWidget(new PageButton(leftPos, topPos + 140, false, button -> {
            this.recipePage--;
            this.updateButtonVisibility();
            this.recipeSlots.clear();
        }, false));
        this.updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        ItemStack itemStack = this.menu.itemSlot.getItem(0);
        if (!itemStack.isEmpty()) {
            this.recipes = UserManualData.getItemDisplayData(itemStack).displayedRecipes();
            this.drops = UserManualData.getItemDisplayData(itemStack).displayedLootRecipes();
        } else {
            this.recipes = List.of();
            this.drops = List.of();
        }

        this.recipePages = (int) Math.ceil((double) this.recipes.size() / 2.0D);
        this.dropPages = (int) Math.ceil((double) this.drops.size() / 2.0D);

        this.forwardRecipeButton.visible = this.recipePage < this.recipePages - 1 && this.drawRecipes;
        this.backRecipeButton.visible = this.recipePage > 0 && this.drawRecipes;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
        if (!Screen.hasControlDown()) {
            this.time += partialTicks;
        }
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
        if (this.lastItemStack != itemStack) {
            if (this.recipeSlots.size() > 0) {
                this.recipeSlots.clear();
            }
            if (this.dropSlots.size() > 0) {
                this.dropSlots.clear();
            }

            this.drawRecipes = false;
            this.drawDrops = false;
            this.recipePage = 0;
            this.dropPage = 0;
            this.updateButtonVisibility();
        }
        if (!itemStack.isEmpty()) {
            this.lastItemStack = itemStack;
            List<FormattedCharSequence> name = this.font.split(itemStack.getHoverName(), 98);
            if (name.size() == 1) {
                guiGraphics.drawString(this.font, name.getFirst(), this.leftPos + 170, this.topPos + 19, 0, false);
            } else {
                for (int i = 0; i < name.size(); i++) {
                    guiGraphics.drawString(this.font, name.get(i), this.leftPos + 170, this.topPos + 24 - ((10 * name.size()) / 2) + (10 * i), 0, false);
                }
            }

            UserManualItemDisplayData userManualItemDisplayData = UserManualData.getItemDisplayData(itemStack);
            if (!this.drops.isEmpty()) {
                guiGraphics.drawString(this.font, DROPS, this.leftPos + 15, this.topPos + 15, 0, false);
            }
            if (!this.recipes.isEmpty()) {
                guiGraphics.drawString(this.font, RECIPES, this.leftPos + 15, this.topPos + 35, 0, false);
            }
            List<Component> text = userManualItemDisplayData.displayedParagraphs();
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

            if (this.drawRecipes) {
                this.updateButtonVisibility();
                int leftPos = this.leftPos + this.imageWidth;
                int topPos = this.topPos + 68;
                guiGraphics.blitSprite(RenderType::guiTextured, TAB_SPRITE, leftPos, topPos, 176, 136);
                this.drawCenteredStringNoShadow(guiGraphics, this.font, Component.literal((this.recipePage + 1) + "/" + this.recipePages), leftPos + (176 / 2), topPos + 5, 4210752);
                for (int i = 0; i < 2; i++) {
                    int index = i + (this.recipePage * 2);
                    if (!(index >= this.recipes.size())) {
                        RecipeHolder<?> recipeHolder = this.recipeMap.byKey(this.recipes.get(index));
                        if (recipeHolder == null) {
                            FAUtils.LOGGER.error("RECIPE: {} IS NULL!", this.recipes.get(index));
                        } else {
                            Recipe<?> recipe = recipeHolder.value();
                            RecipeTypeDrawInformationHolder recipeTypePage = UserManualData.getRecipeTypeDrawInformation(recipe.getType());
                            if (recipeTypePage != RecipeTypeDrawInformationHolder.EMPTY && recipeTypePage != null) {
                                if (i == 1) {
                                    topPos += 59;
                                }
                                guiGraphics.blitSprite(RenderType::guiTextured, recipeTypePage.texture(), leftPos + recipeTypePage.xOffset(), topPos + recipeTypePage.yOffset(), recipeTypePage.width(), recipeTypePage.height());
                                guiGraphics.blitSprite(RenderType::guiTextured, SLOT_SPRITE, leftPos + 7, topPos + 34, 18, 18);
                                SlotPlacer slotPlacer = new SlotPlacer();
                                SpriteDrawer spriteDrawer = new SpriteDrawer();
                                recipeTypePage.drawRecipe().draw(this.player.level(), recipe, slotPlacer, spriteDrawer);
                                this.recipeSlots.addContainers(Arrays.asList(recipeTypePage.containers()), leftPos + 8, topPos + 35, 16, 16);
                                for (Map.Entry<Coordinate, List<ItemStack>> entry : slotPlacer.forEach()) {
                                    Coordinate coordinate = entry.getKey();
                                    this.recipeSlots.add(entry.getValue(), leftPos + coordinate.x() + recipeTypePage.xOffset(), topPos + coordinate.y() + recipeTypePage.yOffset(), 16, 16);
                                }
                                for (Map.Entry<SpriteInformation, ResourceLocation> entry : spriteDrawer.forEachSprite()) {
                                    SpriteInformation spriteInformation = entry.getKey();
                                    Coordinate coordinate = spriteInformation.coordinate();
                                    guiGraphics.blitSprite(RenderType::guiTextured, entry.getValue(), leftPos + coordinate.x(), topPos + coordinate.y(), spriteInformation.width(), spriteInformation.height());
                                }
                                for (Map.Entry<TextInformation, Component> entry : spriteDrawer.forEachText()) {
                                    TextInformation textInformation = entry.getKey();
                                    Coordinate coordinate = textInformation.coordinate();
                                    guiGraphics.drawString(this.font, entry.getValue(), leftPos + coordinate.x(), topPos + coordinate.y(), textInformation.color(), false);
                                }
                                for (Map.Entry<TextInformation, Component> entry : spriteDrawer.forEachCenteredText()) {
                                    TextInformation textInformation = entry.getKey();
                                    Coordinate coordinate = textInformation.coordinate();
                                    this.drawCenteredStringNoShadow(guiGraphics, this.font, entry.getValue(), leftPos + coordinate.x(), topPos + coordinate.y(), textInformation.color());
                                }
                            }
                        }
                    }
                }
            } else {
                if (this.recipeSlots.size() > 0) {
                    this.recipeSlots.clear();
                }

                this.drawRecipes = false;
                this.recipePage = 0;
                this.updateButtonVisibility();
            }

            if (this.drawDrops) {
                this.updateButtonVisibility();
                int leftPos = this.leftPos - 176;
                int topPos = this.topPos + 68;
                guiGraphics.blitSprite(RenderType::guiTextured, TAB_SPRITE, leftPos, topPos, 176, 136);
                this.drawCenteredStringNoShadow(guiGraphics, this.font, Component.literal((this.dropPage + 1) + "/" + this.dropPages), leftPos + (176 / 2), topPos + 5, 4210752);
                for (int i = 0; i < 2; i++) {
                    int index = i + (this.dropPage * 2);
                    if (!(index >= this.drops.size())) {
                        DrawLootRecipe drawLootRecipe = this.drops.get(index);
                        if (drawLootRecipe == null) {
                            FAUtils.LOGGER.error("DROP: {} IS NULL!", this.drops.get(index));
                        } else {
                            if (i == 1) {
                                topPos += 59;
                            }
                            guiGraphics.blitSprite(RenderType::guiTextured, LOOT_SPRITE, leftPos + 32, topPos + 34, 108, 18);
                            SlotPlacer slotPlacer = new SlotPlacer();
                            SpriteDrawer spriteDrawer = new SpriteDrawer();
                            drawLootRecipe.draw(this.player.level(), slotPlacer, spriteDrawer);
                            for (Map.Entry<Coordinate, List<ItemStack>> entry : slotPlacer.forEach()) {
                                Coordinate coordinate = entry.getKey();
                                this.dropSlots.add(entry.getValue(), leftPos + coordinate.x() + 32, topPos + coordinate.y() + 34, 16, 16);
                            }
                            for (Map.Entry<SpriteInformation, ResourceLocation> entry : spriteDrawer.forEachSprite()) {
                                SpriteInformation spriteInformation = entry.getKey();
                                Coordinate coordinate = spriteInformation.coordinate();
                                guiGraphics.blitSprite(RenderType::guiTextured, entry.getValue(), leftPos + coordinate.x(), topPos + coordinate.y(), spriteInformation.width(), spriteInformation.height());
                            }
                            for (Map.Entry<TextInformation, Component> entry : spriteDrawer.forEachText()) {
                                TextInformation textInformation = entry.getKey();
                                Coordinate coordinate = textInformation.coordinate();
                                guiGraphics.drawString(this.font, entry.getValue(), leftPos + coordinate.x(), topPos + coordinate.y(), textInformation.color(), false);
                            }
                            for (Map.Entry<TextInformation, Component> entry : spriteDrawer.forEachCenteredText()) {
                                TextInformation textInformation = entry.getKey();
                                Coordinate coordinate = textInformation.coordinate();
                                this.drawCenteredStringNoShadow(guiGraphics, this.font, entry.getValue(), leftPos + coordinate.x(), topPos + coordinate.y(), textInformation.color());
                            }
                        }
                    }
                }
            } else {
                if (this.dropSlots.size() > 0) {
                    this.dropSlots.clear();
                }

                this.drawDrops = false;
                this.dropPage = 0;
            }
        } else {
            if (this.recipeSlots.size() > 0) {
                this.recipeSlots.clear();
            }
            if (this.dropSlots.size() > 0) {
                this.dropSlots.clear();
            }

            this.drawRecipes = false;
            this.drawDrops = false;
            this.recipePage = 0;
            this.dropPage = 0;
            this.updateButtonVisibility();
        }

        if (this.drawDrops) {
            this.dropSlots.render(guiGraphics, x, y);
        }

        if (this.drawRecipes) {
            this.recipeSlots.render(guiGraphics, x, y);
        }
    }

    @Override
    protected void handleSlotStateChanged(int slotId, int containerId, boolean newState) {
        super.handleSlotStateChanged(slotId, containerId, newState);
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (this.drawDrops) {
            this.dropSlots.renderTooltips(guiGraphics, x, y);
        }
        if (this.drawRecipes) {
            this.recipeSlots.renderTooltips(guiGraphics, x, y);
        }
    }

    @Override
    public boolean mouseClicked(double x, double y, int button) {
        if ((x >= this.leftPos + 15 && x <= this.leftPos + 15 + this.font.width(DROPS)) && (y >= this.topPos + 15 && y <= this.topPos + 15 + this.font.lineHeight) && !this.drops.isEmpty()) {
            this.drawDrops = !this.drawDrops;
            if (!this.drawDrops) {
                this.dropPages = 0;
            }
            this.updateButtonVisibility();
            return true;
        }

        if ((x >= this.leftPos + 15 && x <= this.leftPos + 15 + this.font.width(RECIPES)) && (y >= this.topPos + 35 && y <= this.topPos + 35 + this.font.lineHeight) && !this.recipes.isEmpty()) {
            this.drawRecipes = !this.drawRecipes;
            if (!this.drawRecipes) {
                this.recipePage = 0;
            }
            this.updateButtonVisibility();
            return true;
        }

        return super.mouseClicked(x, y, button);
    }

    private void drawCenteredStringNoShadow(GuiGraphics guiGraphics, Font font, Component component, int x, int y, int color) {
        FormattedCharSequence formattedCharSequence = component.getVisualOrderText();
        guiGraphics.drawString(font, formattedCharSequence, x - font.width(formattedCharSequence) / 2, y, color, false);
    }
}
