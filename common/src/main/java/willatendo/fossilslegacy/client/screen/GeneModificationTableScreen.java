package willatendo.fossilslegacy.client.screen;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ARGB;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import willatendo.fossilslegacy.client.FAKeys;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pteranodon;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.items.AnimalDNAItem;
import willatendo.fossilslegacy.server.menu.menus.GeneModificationTableMenu;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.Optional;

public class GeneModificationTableScreen extends AbstractContainerScreen<GeneModificationTableMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/gene_modification_table.png");
    private static final ResourceLocation GENE_SPRITE = FAUtils.resource("container/gene_modification_table/gene");

    private float xMouse;
    private float yMouse;
    private CoatType[] coatTypes = null;
    private int selection = 0;
    private int size = 0;
    private boolean hasSet = false;

    public GeneModificationTableScreen(GeneModificationTableMenu geneModificationTableMenu, Inventory inventory, Component title) {
        super(geneModificationTableMenu, inventory, title);

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
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        Slot slot = this.menu.slots.get(0);
        if (slot.hasItem()) {
            ItemStack itemStack = slot.getItem();
            if (itemStack.getItem() instanceof AnimalDNAItem animalDNAItem) {
                ClientLevel clientLevel = this.minecraft.level;
                TagKey<CoatType> applicableCoatTypes = animalDNAItem.getApplicableCoatTypes();

                if (applicableCoatTypes != null) {
                    HolderGetter<CoatType> coatTypeHolderGetter = clientLevel.holderLookup(FARegistries.COAT_TYPES);
                    HolderSet.Named<CoatType> namedHolderSet = coatTypeHolderGetter.get(applicableCoatTypes).get();
                    List<Holder<CoatType>> filteredHolderSet = Lists.newArrayList();
                    if (this.getMenu().hasExtraGeneticCode()) {
                        filteredHolderSet.addAll(namedHolderSet.stream().toList());
                    } else {
                        List<Holder<CoatType>> withoutCoatTypes = Lists.newArrayList(namedHolderSet.stream().iterator());
                        withoutCoatTypes.removeAll(coatTypeHolderGetter.get(FACoatTypeTags.LEGACY).get().stream().toList());
                        filteredHolderSet.addAll(withoutCoatTypes);
                    }
                    if (!filteredHolderSet.isEmpty()) {
                        this.coatTypes = new CoatType[this.size = filteredHolderSet.size()];
                        for (int i = 0; i < this.coatTypes.length; i++) {
                            Holder<CoatType> coatTypeHolder = filteredHolderSet.get(i);
                            this.coatTypes[i] = coatTypeHolder.value();
                        }
                    } else {
                        this.coatTypes = new CoatType[0];
                        this.size = 0;
                    }
                } else {
                    this.coatTypes = new CoatType[0];
                    this.size = 0;
                }

                if (itemStack.has(FADataComponents.COAT_TYPE.get()) && !this.hasSet) {
                    for (int i = 0; i < this.coatTypes.length; i++) {
                        if (this.coatTypes[i] == itemStack.get(FADataComponents.COAT_TYPE.get()).value()) {
                            this.selection = i;
                            this.hasSet = true;
                            break;
                        }
                    }
                }

                if (this.coatTypes.length > 0) {
                    if (this.selection >= this.coatTypes.length) {
                        this.selection = 0;
                    }
                    CoatType selectedCoatType = this.coatTypes[this.selection];
                    float red = ((selectedCoatType.displayInfo().color() & 0xFF0000) >> 16) / 255.0F;
                    float green = ((selectedCoatType.displayInfo().color() & 0xFF00) >> 8) / 255.0F;
                    float blue = (selectedCoatType.displayInfo().color() & 0xFF) / 255.0F;
                    guiGraphics.blitSprite(RenderType::guiTextured, GENE_SPRITE, this.leftPos + 42, this.topPos + 61, 22, 8, ARGB.colorFromFloat(1.0F, red, green, blue));
                    this.renderScrollingString(guiGraphics, selectedCoatType.displayInfo().name(), this.leftPos + 8, this.topPos + 74, 0x404040);
                    this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "gene_modification_table.coat_type.location", this.selection + 1, this.size), this.leftPos + 53, this.topPos + 47, 0x404040);
                } else {
                    this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "gene_modification_table.coat_type.none", this.selection + 1, this.size), this.leftPos + 53, this.topPos + 47, 0x404040);
                }

                EntityType<? extends Mob> entityType = animalDNAItem.getEntityType().get();
                Mob mob = entityType.create(clientLevel, EntitySpawnReason.LOAD);
                mob.tickCount = this.minecraft.player.tickCount;
                if (mob instanceof Dinosaur dinosaur) {
                    dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage());
                }
                if (mob instanceof Pteranodon pteranodon) {
                    pteranodon.setOnGround(true);
                }
                if (mob instanceof Dinosaur dinosaur && this.coatTypes.length > 0) {
                    CoatType coatType = this.coatTypes[this.selection];
                    dinosaur.setCoatType(Holder.direct(coatType));
                    CoatType.DisplayInfo displayInfo = coatType.displayInfo();
                    GeneModificationTableScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos + 86, this.topPos + 15, this.leftPos + 131, this.topPos + 53, 16, displayInfo.displayScale(), displayInfo.displayYOffset(), this.xMouse, this.yMouse, mob);
                } else if (!(mob instanceof Dinosaur)) {
                    GeneModificationTableScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos + 86, this.topPos + 15, this.leftPos + 131, this.topPos + 53, 16, 1.0F, 0.25F, this.xMouse, this.yMouse, mob);
                }
            }
            if (this.coatTypes.length > 0) {
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.navigate_left.tutorial", FAKeys.NAVIGATE_LEFT.getDefaultKey().getDisplayName()), this.leftPos, (this.topPos + this.imageHeight) + 2, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.navigate_right.tutorial", FAKeys.NAVIGATE_RIGHT.getDefaultKey().getDisplayName()), this.leftPos, (this.topPos + this.imageHeight) + 10, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.apply_gene.tutorial", FAKeys.APPLY_GENE.getDefaultKey().getDisplayName()), this.leftPos, (this.topPos + this.imageHeight) + 18, 0xFFFFFF, false);
            } else {
                this.renderScrollingString(guiGraphics, FAUtils.translation("container", "gene_modification_table.coat_type.no_genome_applicable"), this.leftPos + 8, this.topPos + 74, 0x404040);
            }
        } else {
            this.coatTypes = new CoatType[0];
            this.size = 0;
            this.selection = 0;
            this.hasSet = false;

            this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "gene_modification_table.coat_type.none"), this.leftPos + 53, this.topPos + 47, 0x404040);
            this.renderScrollingString(guiGraphics, FAUtils.translation("container", "gene_modification_table.insert_dna"), this.leftPos + 8, this.topPos + 74, 0x404040);
        }
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (this.menu.getCarried().isEmpty() && this.size > 0 && (x >= this.leftPos + 40 && x <= this.leftPos + 65) && (y >= this.topPos + 59 && y <= this.topPos + 70)) {
            List<Component> tooltip = Lists.newArrayList();
            tooltip.add(this.coatTypes[this.selection].displayInfo().pattern());
            if (this.minecraft.options.advancedItemTooltips) {
                tooltip.add(Component.literal(this.minecraft.level.registryAccess().lookupOrThrow(FARegistries.COAT_TYPES).getKey(this.coatTypes[this.selection]).toString()).withStyle(ChatFormatting.DARK_GRAY));
            }
            guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
        }
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (FAKeys.NAVIGATE_LEFT.matches(keyCode, scanCode)) {
            if (this.selection != 0) {
                this.selection--;
                return true;
            }
        }
        if (FAKeys.NAVIGATE_RIGHT.matches(keyCode, scanCode)) {
            if (this.selection != this.size - 1) {
                this.selection++;
                return true;
            }
        }
        if (FAKeys.APPLY_GENE.matches(keyCode, scanCode)) {
            if (this.size > 0) {
                FossilsModloaderHelper.INSTANCE.sendApplyGenePacket(this.menu.geneModificationTableBlockEntity.getBlockPos(), this.minecraft.level.registryAccess().lookupOrThrow(FARegistries.COAT_TYPES).getKey(this.coatTypes[this.selection]).toString());
                return true;
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    private void renderScrollingString(GuiGraphics guiGraphics, Component component, int x, int y, int color) {
        this.renderScrollingString(guiGraphics, this.font, component, x, y, x + 158, y + 7, color);
    }

    private void renderScrollingString(GuiGraphics pGuiGraphics, Font font, Component component, int xMin, int yMin, int xMax, int yMax, int color) {
        this.renderScrollingString(pGuiGraphics, font, component, (xMin + xMax) / 2, xMin, yMin, xMax, yMax, color);
    }

    private void renderScrollingString(GuiGraphics guiGraphics, Font font, Component component, int centerX, int xMin, int yMin, int xMax, int pMaxY, int color) {
        int width = font.width(component);
        int y = (yMin + pMaxY - 9) / 2 + 1;
        int xDiffetrence = xMax - xMin;
        int widthMinusY;
        if (width > xDiffetrence) {
            widthMinusY = width - xDiffetrence;
            double time = (double) Util.getMillis() / 1000.0;
            double scaled = Math.max((double) widthMinusY * 0.5, 3.0);
            double change = Math.sin(1.5707963267948966 * Math.cos(6.283185307179586 * time / scaled)) / 2.0 + 0.5;
            double xPos = Mth.lerp(change, 0.0, widthMinusY);
            guiGraphics.enableScissor(xMin, yMin, xMax, pMaxY);
            guiGraphics.drawString(font, component, xMin - (int) xPos, y, color, false);
            guiGraphics.disableScissor();
        } else {
            widthMinusY = Mth.clamp(centerX, xMin + width / 2, xMax - width / 2);
            this.drawCenteredStringNoShadow(guiGraphics, font, component, widthMinusY, y, color);
        }
    }

    public static void renderEntityInInventoryFollowsMouse(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int scale, float displayScale, float yOffset, float mouseX, float mouseY, LivingEntity livingEntity) {
        float x = (left + right) / 2.0F;
        float y = (top + bottom) / 2.0F;
        guiGraphics.enableScissor(left, top, right, bottom);
        float mouseXLook = (float) Math.atan((x - mouseX) / 40.0F);
        float mouseYLook = (float) Math.atan((y - mouseY) / 40.0F);
        Quaternionf zRotation = new Quaternionf().rotateZ(3.1415927F);
        Quaternionf xRotation = new Quaternionf().rotateX(mouseYLook * 20.0F * 0.017453292F);
        zRotation.mul(xRotation);
        float yBodyRot = livingEntity.yBodyRot;
        float yRot = livingEntity.getYRot();
        float xRot = livingEntity.getXRot();
        float yHeadRotO = livingEntity.yHeadRotO;
        float yHeadRot = livingEntity.yHeadRot;
        livingEntity.yBodyRot = 180.0F + mouseXLook * 20.0F;
        livingEntity.setYRot(180.0F + mouseXLook * 40.0F);
        livingEntity.setXRot(-mouseYLook * 20.0F);
        livingEntity.yHeadRot = livingEntity.getYRot();
        livingEntity.yHeadRotO = livingEntity.getYRot();
        float entityScale = livingEntity.getScale();
        Vector3f vector3f = new Vector3f(0.0F, livingEntity.getBbHeight() / 2.0F + yOffset * entityScale, 0.0F);
        float normalizedScale = (float) scale / entityScale;
        GeneModificationTableScreen.renderEntityInInventory(guiGraphics, x, y, normalizedScale, displayScale, vector3f, zRotation, xRotation, livingEntity);
        livingEntity.yBodyRot = yBodyRot;
        livingEntity.setYRot(yRot);
        livingEntity.setXRot(xRot);
        livingEntity.yHeadRotO = yHeadRotO;
        livingEntity.yHeadRot = yHeadRot;
        guiGraphics.disableScissor();
    }


    public static void renderEntityInInventory(GuiGraphics guiGraphics, float x, float y, float scale, float displayScale, Vector3f translate, Quaternionf pose, Quaternionf cameraOrientation, LivingEntity livingEntity) {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(x, y, 50.0);
        guiGraphics.pose().scale(displayScale * scale, displayScale * scale, displayScale * -scale);
        guiGraphics.pose().translate(translate.x, translate.y, translate.z);
        guiGraphics.pose().mulPose(pose);
        Lighting.setupForEntityInInventory();
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        if (cameraOrientation != null) {
            entityRenderDispatcher.overrideCameraOrientation(cameraOrientation.conjugate(new Quaternionf()).rotateY(3.1415927F));
        }

        entityRenderDispatcher.setRenderShadow(false);
        guiGraphics.drawSpecial(multiBufferSource -> entityRenderDispatcher.render(livingEntity, 0.0, 0.0, 0.0, 1.0F, guiGraphics.pose(), multiBufferSource, 15728880));
        guiGraphics.flush();
        entityRenderDispatcher.setRenderShadow(true);
        guiGraphics.pose().popPose();
        Lighting.setupFor3DItems();
    }

    private void drawCenteredStringNoShadow(GuiGraphics guiGraphics, Font font, Component component, int x, int y, int color) {
        FormattedCharSequence formattedCharSequence = component.getVisualOrderText();
        guiGraphics.drawString(font, formattedCharSequence, x - font.width(formattedCharSequence) / 2, y, color, false);
    }
}
