package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.client.FossilsLegacyKeys;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.util.CoatTypeEntity;
import willatendo.fossilslegacy.server.item.DNAItem;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.menu.GeneModificationTableMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Optional;

public class GeneModificationScreen extends AbstractContainerScreen<GeneModificationTableMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/gene_modification_table.png");
    private static final ResourceLocation GENE_SPRITE = FossilsLegacyUtils.resource("container/gene_modification_table/gene");
    private float xMouse;
    private float yMouse;
    private CoatType[] coatTypes = null;
    private int selection = 0;
    private int size = 0;
    private boolean hasSet = false;

    public GeneModificationScreen(GeneModificationTableMenu geneModifierMenu, Inventory inventory, Component title) {
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
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        Slot slot = this.menu.slots.get(0);
        if (slot.hasItem()) {
            ItemStack itemStack = slot.getItem();
            if (itemStack.getItem() instanceof DNAItem dnaItem) {
                ClientLevel clientLevel = Minecraft.getInstance().level;
                RegistryAccess registryAccess = clientLevel.registryAccess();
                TagKey<CoatType> applicableCoatTypes = dnaItem.getApplicableCoatTypes();

                if (applicableCoatTypes != null) {
                    HolderGetter<CoatType> coatTypeHolderGetter = registryAccess.asGetterLookup().lookup(FossilsLegacyRegistries.COAT_TYPES).get();
                    HolderSet.Named<CoatType> namedHolderSet = coatTypeHolderGetter.get(applicableCoatTypes).get();
                    this.coatTypes = new CoatType[this.size = namedHolderSet.size()];
                    for (int i = 0; i < this.coatTypes.length; i++) {
                        this.coatTypes[i] = namedHolderSet.get(i).value();
                    }
                } else {
                    this.coatTypes = new CoatType[0];
                    this.size = 0;
                }

                if (itemStack.has(FossilsLegacyDataComponents.COAT_TYPE.get()) && !this.hasSet) {
                    for (int i = 0; i < this.coatTypes.length; i++) {
                        if (this.coatTypes[i] == itemStack.get(FossilsLegacyDataComponents.COAT_TYPE.get()).value()) {
                            this.selection = i;
                            this.hasSet = true;
                            break;
                        }
                    }
                }

                if (this.coatTypes.length > 0) {
                    CoatType selectedCoatType = this.coatTypes[this.selection];
                    float red = ((selectedCoatType.color() & 0xFF0000) >> 16) / 255.0F;
                    float green = ((selectedCoatType.color() & 0xFF00) >> 8) / 255.0F;
                    float blue = (selectedCoatType.color() & 0xFF) / 255.0F;
                    RenderSystem.setShaderColor(red, green, blue, 1.0F);
                    guiGraphics.blitSprite(GENE_SPRITE, this.leftPos + 42, this.topPos + 61, 22, 8);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    guiGraphics.drawString(this.font, selectedCoatType.name(), this.leftPos + 8, this.topPos + 74, 0xC9C9C9, false);
                    guiGraphics.drawCenteredString(this.font, FossilsLegacyUtils.translation("container", "gene_modification_table.coat_type.location", this.selection + 1, this.size), this.leftPos + 53, this.topPos + 47, 0xC9C9C9);
                } else {
                    guiGraphics.drawCenteredString(this.font, FossilsLegacyUtils.translation("container", "gene_modification_table.coat_type.none", this.selection + 1, this.size), this.leftPos + 53, this.topPos + 47, 0xC9C9C9);
                }

                EntityType<? extends Mob> entityType = dnaItem.getEntityType().get();
                Mob mob = entityType.create(clientLevel);
                if (mob instanceof Dinosaur dinosaur) {
                    dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage());
                }
                if (mob instanceof CoatTypeEntity coatTypeEntity && this.coatTypes.length > 0) {
                    coatTypeEntity.setCoatType(Holder.direct(this.coatTypes[this.selection]));
                }
                mob.tickCount = Minecraft.getInstance().player.tickCount;
                InventoryScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos + 86, this.topPos + 13, this.leftPos + 131, this.topPos + 53, 18, 0.25F, this.xMouse, this.yMouse, mob);
            }
        } else {
            this.coatTypes = new CoatType[0];
            this.size = 0;
            this.selection = 0;
            this.hasSet = false;

            guiGraphics.drawCenteredString(this.font, FossilsLegacyUtils.translation("container", "gene_modification_table.coat_type.none", this.selection + 1, this.size), this.leftPos + 53, this.topPos + 47, 0xC9C9C9);
        }
        guiGraphics.drawString(this.font, FossilsLegacyUtils.translation("container", "gene_modification_table.navigate_left.tutorial", FossilsLegacyKeys.NAVIGATE_LEFT.getDefaultKey().getDisplayName()), this.leftPos, (this.topPos + this.imageHeight) + 2, 0xFFFFFF, false);
        guiGraphics.drawString(this.font, FossilsLegacyUtils.translation("container", "gene_modification_table.navigate_right.tutorial", FossilsLegacyKeys.NAVIGATE_RIGHT.getDefaultKey().getDisplayName()), this.leftPos, (this.topPos + this.imageHeight) + 10, 0xFFFFFF, false);
        guiGraphics.drawString(this.font, FossilsLegacyUtils.translation("container", "gene_modification_table.apply_gene.tutorial", FossilsLegacyKeys.APPLY_GENE.getDefaultKey().getDisplayName()), this.leftPos, (this.topPos + this.imageHeight) + 18, 0xFFFFFF, false);
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (this.menu.getCarried().isEmpty() && this.size > 0 && (x >= this.leftPos + 40 && x <= this.leftPos + 65) && (y >= this.topPos + 59 && y <= this.topPos + 70)) {
            List<Component> tooltip = Lists.newArrayList();
            tooltip.add(this.coatTypes[this.selection].pattern());
            if (this.minecraft.options.advancedItemTooltips) {
                tooltip.add(Component.literal(this.minecraft.level.registryAccess().registry(FossilsLegacyRegistries.COAT_TYPES).get().getKey(this.coatTypes[this.selection]).toString()).withStyle(ChatFormatting.DARK_GRAY));
            }
            guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
        }
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (FossilsLegacyKeys.NAVIGATE_LEFT.matches(keyCode, scanCode)) {
            if (this.selection != 0) {
                this.selection--;
                return true;
            }
        }
        if (FossilsLegacyKeys.NAVIGATE_RIGHT.matches(keyCode, scanCode)) {
            if (this.selection != this.size - 1) {
                this.selection++;
                return true;
            }
        }
        if (FossilsLegacyKeys.APPLY_GENE.matches(keyCode, scanCode)) {
            if (this.size > 0) {
                FossilsModloaderHelper.INSTANCE.sendApplyGenePacket(this.menu.geneModificationTableBlockEntity.getBlockPos(), this.minecraft.level.registryAccess().registry(FossilsLegacyRegistries.COAT_TYPES).get().getKey(this.coatTypes[this.selection]).toString());
                return true;
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0xC9C9C9, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
    }
}
