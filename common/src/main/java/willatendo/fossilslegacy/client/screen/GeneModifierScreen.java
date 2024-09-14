package willatendo.fossilslegacy.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.ClientLevel;
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
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.item.DNAItem;
import willatendo.fossilslegacy.server.menu.GeneModifierMenu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class GeneModifierScreen extends AbstractContainerScreen<GeneModifierMenu> {
    private static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/container/gene_modification_table.png");
    private static final ResourceLocation GENE_SPRITE = FossilsLegacyUtils.resource("container/gene_modification_table/gene");
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
                EntityType<? extends Mob> entityType = dnaItem.getEntityType().get();
                Mob mob = entityType.create(clientLevel);
                mob.tickCount = Minecraft.getInstance().player.tickCount;
                InventoryScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos + 70, this.topPos + 10, this.leftPos + 70, this.topPos + 70, 17, 0.25F, this.xMouse, this.yMouse, mob);

                TagKey<CoatType> applicableCoatTypes = dnaItem.getApplicableCoatTypes();
                CoatType[] coatTypes = null;
                if (applicableCoatTypes != null) {
                    HolderGetter<CoatType> coatTypeHolderGetter = registryAccess.asGetterLookup().lookup(FossilsLegacyRegistries.COAT_TYPES).get();
                    HolderSet.Named<CoatType> namedHolderSet = coatTypeHolderGetter.get(applicableCoatTypes).get();
                    coatTypes = new CoatType[namedHolderSet.size()];
                    for (int i = 0; i < coatTypes.length; i++) {
                        coatTypes[i] = namedHolderSet.get(i).value();
                    }
                } else {
                    coatTypes = new CoatType[0];
                }

                if (coatTypes.length > 0) {
                    CoatType selectedCoatType = coatTypes[0];
                    float red = ((selectedCoatType.color() & 0xFF0000) >> 16) ;
                    float green = ((selectedCoatType.color() & 0xFF00) >> 8);
                    float blue = (selectedCoatType.color() & 0xFF);
                    RenderSystem.setShaderColor(red, green, blue, 1.0F);
                    guiGraphics.blitSprite(GENE_SPRITE, this.leftPos + 42, this.topPos + 61, 22, 8);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                }
            }
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0xC9C9C9, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
