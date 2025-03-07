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
import net.minecraft.core.*;
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
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pteranodon;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.GeneticInformation;
import willatendo.fossilslegacy.server.item.items.AnimalDNAItem;
import willatendo.fossilslegacy.server.menu.menus.DNARecombinatorMenu;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pattern.pattern.PatternHolder;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;
import willatendo.fossilslegacy.server.tags.FAPatternTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.Optional;

public class DNARecombinatorScreen extends AbstractContainerScreen<DNARecombinatorMenu> {
    private static final ResourceLocation TEXTURE = FAUtils.resource("textures/gui/container/dna_recombinator.png");
    private static final ResourceLocation GENE_SPRITE = FAUtils.resource("container/dna_recombinator/gene");
    private static final ResourceLocation GENETIC_CODE_TAB_SPRITE = FAUtils.resource("container/dna_recombinator/genetic_code_tab");
    private static final ResourceLocation MODEL_TAB_SPRITE = FAUtils.resource("container/dna_recombinator/model_tab");
    private static final ResourceLocation GENE_SLOT_HIGHLIGHT_BACK_SPRITE = FAUtils.resource("container/gene_slot_highlight_back");
    public static final ResourceLocation EMPTY_SLOT_DNA = FAUtils.resource("container/slot/dna");
    public static final ResourceLocation EMPTY_SLOT_GENETIC_CODE = FAUtils.resource("container/slot/genetic_code");
    private static final ResourceLocation EMPTY_SLOT_GENE = FAUtils.resource("container/slot/gene");

    private float xMouse;
    private float yMouse;
    private Holder<ModelType>[] modelTypes = null;
    private PatternHolder[] patterns = null;
    private int modelTypeSelection = 0;
    private int patternSelection = 0;
    private int modelTypeLength = 0;
    private int patternLength = 0;
    private boolean hasSetModelType = false;
    private boolean hasSetPattern = false;
    private boolean selectedPattern = false;

    public DNARecombinatorScreen(DNARecombinatorMenu dnaRecombinatorMenu, Inventory inventory, Component title) {
        super(dnaRecombinatorMenu, inventory, title);

        this.imageHeight = 185;
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
        guiGraphics.blitSprite(RenderType::guiTextured, GENETIC_CODE_TAB_SPRITE, this.leftPos + 173, this.topPos, 29, 78);
        guiGraphics.blitSprite(RenderType::guiTextured, MODEL_TAB_SPRITE, this.leftPos - 118, this.topPos, 120, 185);
        guiGraphics.blitSprite(RenderType::guiTextured, EMPTY_SLOT_GENE, this.leftPos + 44, this.topPos + 58, 26, 12);
        guiGraphics.blitSprite(RenderType::guiTextured, EMPTY_SLOT_GENE, this.leftPos + 44, this.topPos + 75, 26, 12);
        Slot slot = this.menu.slots.get(0);
        if (slot.hasItem()) {
            ItemStack itemStack = slot.getItem();
            if (itemStack.getItem() instanceof AnimalDNAItem animalDNAItem) {
                ClientLevel clientLevel = this.minecraft.level;
                TagKey<ModelType> applicableModelTypes = animalDNAItem.getApplicableCoatTypes();

                if (applicableModelTypes != null) {
                    HolderGetter<ModelType> modelTypeHolderGetter = clientLevel.holderLookup(FARegistries.MODEL_TYPES);
                    HolderSet.Named<ModelType> namedHolderSet = modelTypeHolderGetter.get(applicableModelTypes).get();
                    List<Holder<ModelType>> filteredHolderSet = Lists.newArrayList();
                    filteredHolderSet.addAll(namedHolderSet.stream().filter(modelTypeHolder -> !modelTypeHolder.is(FAModelTypeTags.LOCKED)).toList());

                    for (int i = 0; i < 3; i++) {
                        if (this.getMenu().hasExtraGeneticCodeInSlot(i)) {
                            Slot geneticCodeSlot = this.getMenu().getGeneticCodeInSlot(i);
                            if (geneticCodeSlot.getItem().has(FADataComponents.GENETIC_INFORMATION.get())) {
                                GeneticInformation geneticInformation = geneticCodeSlot.getItem().get(FADataComponents.GENETIC_INFORMATION.get());
                                geneticInformation.carriedModelInformation().ifPresent(carriedModelInformation -> filteredHolderSet.addAll(modelTypeHolderGetter.get(carriedModelInformation).get().stream().filter(modelTypeHolder -> modelTypeHolder.is(applicableModelTypes)).toList()));
                            }
                        }
                    }
                    if (!filteredHolderSet.isEmpty()) {
                        this.modelTypes = new Holder[this.modelTypeLength = filteredHolderSet.size()];
                        for (int i = 0; i < this.modelTypes.length; i++) {
                            this.modelTypes[i] = filteredHolderSet.get(i);
                        }
                    } else {
                        this.modelTypes = new Holder[0];
                        this.modelTypeLength = 0;
                    }
                } else {
                    this.modelTypes = new Holder[0];
                    this.modelTypeLength = 0;
                }

                if (this.modelTypeLength <= this.modelTypeSelection) {
                    this.modelTypeSelection = this.modelTypeLength - 1;
                }

                if (this.modelTypeLength > 0) {
                    HolderGetter<Pattern> patternHolderGetter = clientLevel.holderLookup(FARegistries.PATTERN);
                    HolderSet.Named<Pattern> skinsHolderSet = patternHolderGetter.getOrThrow(this.modelTypes[this.modelTypeSelection].value().skins());
                    HolderSet.Named<Pattern> patternsHolderSet = patternHolderGetter.getOrThrow(this.modelTypes[this.modelTypeSelection].value().patterns());
                    List<Holder<Pattern>> filteredSkinsHolderSet = Lists.newArrayList();
                    List<Holder<Pattern>> filteredPatternsHolderSet = Lists.newArrayList();
                    filteredSkinsHolderSet.addAll(skinsHolderSet.stream().filter(modelTypeHolder -> !modelTypeHolder.is(FAPatternTags.LOCKED)).toList());
                    filteredPatternsHolderSet.addAll(patternsHolderSet.stream().filter(modelTypeHolder -> !modelTypeHolder.is(FAPatternTags.LOCKED)).toList());

                    for (int i = 0; i < 3; i++) {
                        if (this.getMenu().hasExtraGeneticCodeInSlot(i)) {
                            Slot geneticCodeSlot = this.getMenu().getGeneticCodeInSlot(i);
                            if (geneticCodeSlot.getItem().has(FADataComponents.GENETIC_INFORMATION.get())) {
                                GeneticInformation geneticInformation = geneticCodeSlot.getItem().get(FADataComponents.GENETIC_INFORMATION.get());
                                geneticInformation.carriedSkinsInformation().ifPresent(carriedSkinInformation -> filteredSkinsHolderSet.addAll(patternHolderGetter.get(carriedSkinInformation).get().stream().toList()));
                                geneticInformation.carriedPatternsInformation().ifPresent(carriedPatternInformation -> filteredPatternsHolderSet.addAll(patternHolderGetter.get(carriedPatternInformation).get().stream().toList()));
                            }
                        }
                    }
                    if (!filteredSkinsHolderSet.isEmpty()) {
                        boolean hasPatterns = !filteredPatternsHolderSet.isEmpty();
                        int size = this.patternLength = filteredSkinsHolderSet.size();
                        int withPatterns = size * (filteredPatternsHolderSet.size() + 1);
                        this.patterns = new PatternHolder[hasPatterns ? withPatterns : size];
                        for (int i = 0; i < size; i++) {
                            this.patterns[i] = new PatternHolder(filteredSkinsHolderSet.get(i));
                        }
                        if (hasPatterns) {
                            for (int i = 0; i < filteredPatternsHolderSet.size(); i++) {
                                for (int z = 0; z < size; z++) {
                                    if (filteredSkinsHolderSet.get(z).is(FAPatternTags.HAS_PATTERNS)) {
                                        this.patterns[z + (size * i)] = new PatternHolder(filteredSkinsHolderSet.get(z), Optional.of(filteredPatternsHolderSet.get(i)));
                                    }
                                }
                            }
                        }
                    } else {
                        this.patterns = new PatternHolder[0];
                        this.patternLength = 0;
                    }
                } else {
                    this.patterns = new PatternHolder[0];
                    this.patternLength = 0;
                }

                if (itemStack.has(FADataComponents.MODEL_TYPE.get()) && !this.hasSetModelType) {
                    for (int i = 0; i < this.modelTypes.length; i++) {
                        if (this.modelTypes[i] == itemStack.get(FADataComponents.MODEL_TYPE.get())) {
                            this.modelTypeSelection = i;
                            this.hasSetModelType = true;
                            break;
                        }
                    }
                }

                if (itemStack.has(FADataComponents.PATTERN_HOLDER.get()) && !this.hasSetPattern) {
                    for (int i = 0; i < this.patterns.length; i++) {
                        if (this.patterns[i] != null && this.patterns[i].equals(itemStack.get(FADataComponents.PATTERN_HOLDER.get()))) {
                            this.patternSelection = i;
                            this.hasSetPattern = true;
                            break;
                        }
                    }
                }

                if (this.patternLength <= this.patternSelection) {
                    this.patternSelection = this.patternLength - 1;
                }

                if (this.modelTypes.length > 0 && this.patterns.length > 0) {
                    if (!this.selectedPattern) {
                        guiGraphics.blitSprite(RenderType::guiTextured, GENE_SLOT_HIGHLIGHT_BACK_SPRITE, this.leftPos + 44, this.topPos + 58, 26, 12);
                    } else {
                        guiGraphics.blitSprite(RenderType::guiTextured, GENE_SLOT_HIGHLIGHT_BACK_SPRITE, this.leftPos + 44, this.topPos + 75, 26, 12);
                    }
                    if (this.modelTypeSelection >= this.modelTypes.length) {
                        this.modelTypeSelection = 0;
                    }
                    ModelType selectedModelType = this.modelTypes[this.modelTypeSelection].value();
                    float modelTypeRed = ((selectedModelType.displayInfo().color() & 0xFF0000) >> 16) / 255.0F;
                    float modelTypeGreen = ((selectedModelType.displayInfo().color() & 0xFF00) >> 8) / 255.0F;
                    float modelTypeBlue = (selectedModelType.displayInfo().color() & 0xFF) / 255.0F;
                    guiGraphics.blitSprite(RenderType::guiTextured, GENE_SPRITE, this.leftPos + 46, this.topPos + 60, 22, 8, ARGB.colorFromFloat(1.0F, modelTypeRed, modelTypeGreen, modelTypeBlue));
                    this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "gene_modification_table.coat_type.location", this.modelTypeSelection + 1, this.modelTypeLength), this.leftPos + 120, this.topPos + 60, 0x404040);
                    PatternHolder patternHolder = this.patterns[this.patternSelection];
                    float patternTypeRed = ((patternHolder.getGeneColor() & 0xFF0000) >> 16) / 255.0F;
                    float patternTypeGreen = ((patternHolder.getGeneColor() & 0xFF00) >> 8) / 255.0F;
                    float patternTypeBlue = (patternHolder.getGeneColor() & 0xFF) / 255.0F;
                    guiGraphics.blitSprite(RenderType::guiTextured, GENE_SPRITE, this.leftPos + 46, this.topPos + 77, 22, 8, ARGB.colorFromFloat(1.0F, patternTypeRed, patternTypeGreen, patternTypeBlue));
                    this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "gene_modification_table.coat_type.location", this.patternSelection + 1, this.patternLength), this.leftPos + 120, this.topPos + 77, 0x404040);
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
                if (mob instanceof Dinosaur dinosaur && this.modelTypes.length > 0 && this.patterns.length > 0) {
                    Holder<ModelType> modelType = this.modelTypes[this.modelTypeSelection];
                    PatternHolder patternHolder = this.patterns[this.patternSelection];
                    dinosaur.setModelType(modelType);
                    dinosaur.setSkin(patternHolder.skin());
                    if (patternHolder.hasPattern()) {
                        dinosaur.setPattern(patternHolder.pattern().get());
                    }
                    ModelType.DisplayInfo displayInfo = modelType.value().displayInfo();
                    DNARecombinatorScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos - 112, this.topPos + 17, this.leftPos - 6, this.topPos + 176, 16, displayInfo.displayScale(), displayInfo.displayYOffset(), this.xMouse, this.yMouse, mob);
                } else if (!(mob instanceof Dinosaur)) {
                    DNARecombinatorScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos - 112, this.topPos + 17, this.leftPos - 6, this.topPos + 176, 16, 1.0F, 0.25F, this.xMouse, this.yMouse, mob);
                }
            }
            if (this.modelTypes.length > 0 && this.patterns.length > 0) {
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.navigate_left.tutorial", FAKeys.NAVIGATE_LEFT.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 80, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.navigate_right.tutorial", FAKeys.NAVIGATE_RIGHT.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 88, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.navigate_up.tutorial", FAKeys.NAVIGATE_UP.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 96, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.navigate_down.tutorial", FAKeys.NAVIGATE_DOWN.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 104, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "gene_modification_table.apply_gene.tutorial", FAKeys.APPLY_GENE.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 112, 0xFFFFFF, false);
            } else {
                this.renderScrollingString(guiGraphics, FAUtils.translation("container", "gene_modification_table.coat_type.no_genome_applicable"), this.leftPos + 8, this.topPos + 47, 0x404040);
            }
        } else {
            this.createEmpty();
            this.modelTypeSelection = 0;
            this.patternSelection = 0;
            this.hasSetModelType = false;
            this.hasSetPattern = false;

            this.renderScrollingString(guiGraphics, FAUtils.translation("container", "gene_modification_table.insert_dna"), this.leftPos - 22, this.topPos + 47, 0x404040);
        }
    }

    private void createEmpty() {
        this.modelTypes = new Holder[0];
        this.patterns = new PatternHolder[0];
        this.modelTypeLength = 0;
        this.patternLength = 0;
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (this.menu.getCarried().isEmpty()) {
            RegistryAccess registryAccess = this.minecraft.level.registryAccess();
            if (this.modelTypeLength > 0 && (x >= this.leftPos + 44 && x <= this.leftPos + 69) && (y >= this.topPos + 58 && y <= this.topPos + 69)) {
                List<Component> tooltip = Lists.newArrayList();
                tooltip.add(this.modelTypes[this.modelTypeSelection].value().displayInfo().modelName());
                if (this.minecraft.options.advancedItemTooltips) {
                    Registry<ModelType> modelType = registryAccess.lookupOrThrow(FARegistries.MODEL_TYPES);
                    tooltip.add(Component.literal(modelType.getKey(this.modelTypes[this.modelTypeSelection].value()).toString()).withStyle(ChatFormatting.DARK_GRAY));
                }
                guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
            }
            if (this.patternLength > 0 && (x >= this.leftPos + 44 && x <= this.leftPos + 69) && (y >= this.topPos + 75 && y <= this.topPos + 86)) {
                List<Component> tooltip = Lists.newArrayList();
                tooltip.add(this.patterns[this.patternSelection].getDisplayName());
                if (this.minecraft.options.advancedItemTooltips) {
                    Registry<Pattern> pattern = registryAccess.lookupOrThrow(FARegistries.PATTERN);
                    tooltip.add(Component.literal(pattern.getKey(this.patterns[this.patternSelection].skin().value()).toString()).withStyle(ChatFormatting.DARK_GRAY));
                }
                guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
            }
        }
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (FAKeys.NAVIGATE_LEFT.matches(keyCode, scanCode)) {
            if (this.selectedPattern) {
                if (this.patternSelection != 0) {
                    this.patternSelection--;
                    return true;
                }
            } else {
                if (this.modelTypeSelection != 0) {
                    this.modelTypeSelection--;
                    return true;
                }
            }
        }
        if (FAKeys.NAVIGATE_RIGHT.matches(keyCode, scanCode)) {
            if (this.selectedPattern) {
                if (this.patternSelection != this.patternLength - 1) {
                    this.patternSelection++;
                    return true;
                }

            } else {
                if (this.modelTypeSelection != this.modelTypeLength - 1) {
                    this.modelTypeSelection++;
                    return true;
                }
            }
        }
        if (FAKeys.APPLY_GENE.matches(keyCode, scanCode)) {
            if (this.modelTypeLength > 0 && this.patternLength > 0) {
                RegistryAccess registryAccess = this.minecraft.level.registryAccess();
                Registry<Pattern> patternRegistry = registryAccess.lookupOrThrow(FARegistries.PATTERN);
                Optional<String> pattern = Optional.empty();
                Optional<Holder<Pattern>> patternHolder = this.patterns[this.patternSelection].pattern();
                if (patternHolder.isPresent()) {
                    pattern = Optional.of(patternRegistry.getKey(patternHolder.get().value()).toString());
                }
                FossilsModloaderHelper.INSTANCE.sendApplyGenePacket(this.menu.DNARecombinatorBlockEntity.getBlockPos(), registryAccess.lookupOrThrow(FARegistries.MODEL_TYPES).getKey(this.modelTypes[this.modelTypeSelection].value()).toString(), patternRegistry.getKey(this.patterns[this.patternSelection].skin().value()).toString(), pattern);
                return true;
            }
        }
        if (FAKeys.NAVIGATE_UP.matches(keyCode, keyCode)) {
            this.selectedPattern = false;
            return true;
        }
        if (FAKeys.NAVIGATE_DOWN.matches(keyCode, keyCode)) {
            this.selectedPattern = true;
            return true;
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
        DNARecombinatorScreen.renderEntityInInventory(guiGraphics, x, y, normalizedScale, displayScale, vector3f, zRotation, xRotation, livingEntity);
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
