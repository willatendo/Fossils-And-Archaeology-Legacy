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
import willatendo.fossilslegacy.platform.FAModloaderHelper;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pteranodon;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.GeneticInformation;
import willatendo.fossilslegacy.server.item.items.AnimalDNAItem;
import willatendo.fossilslegacy.server.menu.menus.DNARecombinatorMenu;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
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

    private final RegistryAccess registryAccess;
    private final Registry<ModelType> modelTypeRegistry;
    private final Registry<Pattern> patternRegistry;
    private float xMouse;
    private float yMouse;
    private Holder<ModelType>[] modelTypes = null;
    private Holder<Pattern>[] skins = null;
    private Holder<Pattern>[] patterns = null;
    private int modelTypeSelection = 0;
    private int skinSelection = 0;
    private int patternSelection = 0;
    private int modelTypeLength = 0;
    private int skinLength = 0;
    private int patternLength = 0;
    private boolean hasSetModelType = false;
    private boolean hasSetSkin = false;
    private boolean hasSetPattern = false;
    private int selectedGene = 0;

    public DNARecombinatorScreen(DNARecombinatorMenu dnaRecombinatorMenu, Inventory inventory, Component title) {
        super(dnaRecombinatorMenu, inventory, title);
        this.registryAccess = inventory.player.registryAccess();
        this.modelTypeRegistry = this.registryAccess.lookupOrThrow(FARegistries.MODEL_TYPES);
        this.patternRegistry = this.registryAccess.lookupOrThrow(FARegistries.PATTERN);

        this.imageHeight = 202;
        this.inventoryLabelY = 109;
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
        guiGraphics.blitSprite(RenderType::guiTextured, MODEL_TAB_SPRITE, this.leftPos - 118, this.topPos, 120, 202);
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

                HolderGetter<Pattern> patternHolderGetter = clientLevel.holderLookup(FARegistries.PATTERN);
                if (this.modelTypeLength > 0) {
                    HolderSet.Named<Pattern> skinsHolderSet = patternHolderGetter.getOrThrow(this.modelTypes[this.modelTypeSelection].value().skins());
                    List<Holder<Pattern>> filteredSkinsHolderSet = Lists.newArrayList();
                    filteredSkinsHolderSet.addAll(skinsHolderSet.stream().filter(modelTypeHolder -> !modelTypeHolder.is(FAPatternTags.LOCKED)).toList());

                    for (int i = 0; i < 3; i++) {
                        if (this.getMenu().hasExtraGeneticCodeInSlot(i)) {
                            Slot geneticCodeSlot = this.getMenu().getGeneticCodeInSlot(i);
                            if (geneticCodeSlot.getItem().has(FADataComponents.GENETIC_INFORMATION.get())) {
                                GeneticInformation geneticInformation = geneticCodeSlot.getItem().get(FADataComponents.GENETIC_INFORMATION.get());
                                geneticInformation.carriedSkinsInformation().ifPresent(carriedSkinInformation -> filteredSkinsHolderSet.addAll(patternHolderGetter.get(carriedSkinInformation).get().stream().toList()));
                            }
                        }
                    }
                    if (!filteredSkinsHolderSet.isEmpty()) {
                        this.skins = new Holder[this.skinLength = filteredSkinsHolderSet.size()];
                        for (int i = 0; i < filteredSkinsHolderSet.size(); i++) {
                            this.skins[i] = filteredSkinsHolderSet.get(i);
                        }
                    } else {
                        this.skins = new Holder[0];
                        this.skinLength = 0;
                    }
                } else {
                    this.skins = new Holder[0];
                    this.skinLength = 0;
                }

                if (this.skinLength > 0 && !(this.skinSelection > this.skins.length) && this.skins[this.skinSelection] != null && !this.skins[this.skinSelection].is(FAPatterns.BLANK)) {
                    HolderSet.Named<Pattern> patternsHolderSet = patternHolderGetter.getOrThrow(this.modelTypes[this.modelTypeSelection].value().patterns());
                    List<Holder<Pattern>> filteredPatternsHolderSet = Lists.newArrayList();
                    filteredPatternsHolderSet.addAll(patternsHolderSet.stream().filter(modelTypeHolder -> !modelTypeHolder.is(FAPatternTags.LOCKED)).toList());

                    for (int i = 0; i < 3; i++) {
                        if (this.getMenu().hasExtraGeneticCodeInSlot(i)) {
                            Slot geneticCodeSlot = this.getMenu().getGeneticCodeInSlot(i);
                            if (geneticCodeSlot.getItem().has(FADataComponents.GENETIC_INFORMATION.get())) {
                                GeneticInformation geneticInformation = geneticCodeSlot.getItem().get(FADataComponents.GENETIC_INFORMATION.get());
                                geneticInformation.carriedPatternsInformation().ifPresent(carriedPatternInformation -> filteredPatternsHolderSet.addAll(patternHolderGetter.get(carriedPatternInformation).get().stream().toList()));
                            }
                        }
                    }
                    if (!filteredPatternsHolderSet.isEmpty()) {
                        this.patterns = new Holder[this.patternLength = filteredPatternsHolderSet.size()];
                        for (int i = 0; i < filteredPatternsHolderSet.size(); i++) {
                            this.patterns[i] = filteredPatternsHolderSet.get(i);
                        }
                    } else {
                        this.patterns = new Holder[0];
                        this.patternLength = 0;
                    }
                } else {
                    this.patterns = new Holder[0];
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

                if (itemStack.has(FADataComponents.PATTERN_HOLDER.get())) {
                    PatternHolder patternHolder = itemStack.get(FADataComponents.PATTERN_HOLDER.get());
                    if (!this.hasSetSkin) {
                        for (int i = 0; i < this.skins.length; i++) {
                            if (this.skins[i] != null && this.skins[i] == patternHolder.skin()) {
                                this.skinSelection = i;
                                this.hasSetSkin = true;
                                break;
                            }
                        }
                    }
                    if (!this.hasSetPattern && patternHolder.hasPattern()) {
                        for (int i = 0; i < this.patterns.length; i++) {
                            if (this.patterns[i] != null && this.patterns[i] == patternHolder.pattern().get()) {
                                this.patternSelection = i;
                                this.hasSetPattern = true;
                                break;
                            }
                        }
                    }
                }

                if (this.skinLength <= this.skinSelection) {
                    this.skinSelection = this.skinLength - 1;
                }

                if (this.selectedGene == 2 && !this.skins[this.skinSelection].is(FAPatternTags.HAS_PATTERNS)) {
                    this.selectedGene = 0;
                }

                if (this.modelTypes.length > 0 && this.skins.length > 0) {
                    if (this.selectedGene == 0) {
                        guiGraphics.blitSprite(RenderType::guiTextured, GENE_SLOT_HIGHLIGHT_BACK_SPRITE, this.leftPos + 44, this.topPos + 58, 26, 12);
                    } else if (this.selectedGene == 1) {
                        guiGraphics.blitSprite(RenderType::guiTextured, GENE_SLOT_HIGHLIGHT_BACK_SPRITE, this.leftPos + 44, this.topPos + 75, 26, 12);
                    } else if (this.selectedGene == 2) {
                        guiGraphics.blitSprite(RenderType::guiTextured, GENE_SLOT_HIGHLIGHT_BACK_SPRITE, this.leftPos + 44, this.topPos + 92, 26, 12);
                    }
                    if (this.modelTypeSelection >= this.modelTypes.length) {
                        this.modelTypeSelection = 0;
                    }
                    ModelType selectedModelType = this.modelTypes[this.modelTypeSelection].value();
                    float modelTypeRed = ((selectedModelType.displayInfo().color() & 0xFF0000) >> 16) / 255.0F;
                    float modelTypeGreen = ((selectedModelType.displayInfo().color() & 0xFF00) >> 8) / 255.0F;
                    float modelTypeBlue = (selectedModelType.displayInfo().color() & 0xFF) / 255.0F;
                    guiGraphics.blitSprite(RenderType::guiTextured, GENE_SPRITE, this.leftPos + 46, this.topPos + 60, 22, 8, ARGB.colorFromFloat(1.0F, modelTypeRed, modelTypeGreen, modelTypeBlue));
                    this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "dna_recombinator.navigation", this.modelTypeSelection + 1, this.modelTypeLength), this.leftPos + 120, this.topPos + 60, 0x404040);
                    Holder<Pattern> skin = this.skins[this.skinSelection];
                    float skinRed = ((skin.value().geneColor() & 0xFF0000) >> 16) / 255.0F;
                    float skinGreen = ((skin.value().geneColor() & 0xFF00) >> 8) / 255.0F;
                    float skinBlue = (skin.value().geneColor() & 0xFF) / 255.0F;
                    guiGraphics.blitSprite(RenderType::guiTextured, GENE_SPRITE, this.leftPos + 46, this.topPos + 77, 22, 8, ARGB.colorFromFloat(1.0F, skinRed, skinGreen, skinBlue));
                    this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "dna_recombinator.navigation", this.skinSelection + 1, this.skinLength), this.leftPos + 120, this.topPos + 77, 0x404040);
                    if (this.patterns.length > 0 && skin.is(FAPatternTags.HAS_PATTERNS)) {
                        Holder<Pattern> pattern = this.patterns[this.patternSelection];
                        float patternRed = ((pattern.value().geneColor() & 0xFF0000) >> 16) / 255.0F;
                        float patternGreen = ((pattern.value().geneColor() & 0xFF00) >> 8) / 255.0F;
                        float patternBlue = (pattern.value().geneColor() & 0xFF) / 255.0F;
                        guiGraphics.blitSprite(RenderType::guiTextured, GENE_SPRITE, this.leftPos + 46, this.topPos + 94, 22, 8, ARGB.colorFromFloat(1.0F, patternRed, patternGreen, patternBlue));
                        this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "dna_recombinator.navigation", this.patternSelection + 1, this.patternLength), this.leftPos + 120, this.topPos + 94, 0x404040);
                    } else {
                        this.drawCenteredStringNoShadow(guiGraphics, this.font, FAUtils.translation("container", "dna_recombinator.none", this.patternSelection + 1, this.patternLength), this.leftPos + 120, this.topPos + 94, 0x404040);
                    }
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
                if (mob instanceof Dinosaur dinosaur && this.modelTypes.length > 0 && this.skins.length > 0) {
                    Holder<ModelType> modelType = this.modelTypes[this.modelTypeSelection];
                    dinosaur.setModelType(modelType);
                    dinosaur.setSkin(this.skins[this.skinSelection]);
                    if (this.patterns.length > 0) {
                        dinosaur.setPattern(this.patterns[this.patternSelection]);
                    } else {
                        dinosaur.setPattern(this.patternRegistry.getOrThrow(FAPatterns.BLANK));
                    }
                    ModelType.DisplayInfo displayInfo = modelType.value().displayInfo();
                    DNARecombinatorScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos - 110, this.topPos + 17, this.leftPos - 3, this.topPos + 193, 16, displayInfo.displayScale(), displayInfo.displayYOffset(), this.xMouse, this.yMouse, mob);
                } else if (!(mob instanceof Dinosaur)) {
                    DNARecombinatorScreen.renderEntityInInventoryFollowsMouse(guiGraphics, this.leftPos - 110, this.topPos + 17, this.leftPos - 3, this.topPos + 193, 16, 1.0F, 0.25F, this.xMouse, this.yMouse, mob);
                }
            }
            if (this.modelTypes.length > 0 && this.skins.length > 0) {
                guiGraphics.drawString(this.font, FAUtils.translation("container", "dna_recombinator.navigate_left.tutorial", FAKeys.NAVIGATE_LEFT.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 80, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "dna_recombinator.navigate_right.tutorial", FAKeys.NAVIGATE_RIGHT.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 88, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "dna_recombinator.navigate_up.tutorial", FAKeys.NAVIGATE_UP.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 96, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "dna_recombinator.navigate_down.tutorial", FAKeys.NAVIGATE_DOWN.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 104, 0xFFFFFF, false);
                guiGraphics.drawString(this.font, FAUtils.translation("container", "dna_recombinator.apply_gene.tutorial", FAKeys.APPLY_GENE.getDefaultKey().getDisplayName()), this.leftPos + this.imageWidth + 2, this.topPos + 112, 0xFFFFFF, false);
            } else {
                this.renderScrollingString(guiGraphics, FAUtils.translation("container", "dna_recombinator.no_genome_applicable"), this.leftPos + 8, this.topPos + 47, 0x404040);
            }
        } else {
            this.createEmpty();
            this.modelTypeSelection = 0;
            this.skinSelection = 0;
            this.patternSelection = 0;
            this.hasSetModelType = false;
            this.hasSetSkin = false;
            this.hasSetPattern = false;

            this.renderScrollingString(guiGraphics, FAUtils.translation("container", "dna_recombinator.insert_dna"), this.leftPos - 22, this.topPos + 47, 0x404040);
        }
    }

    private void createEmpty() {
        this.modelTypes = new Holder[0];
        this.skins = new Holder[0];
        this.patterns = new Holder[0];
        this.modelTypeLength = 0;
        this.skinLength = 0;
        this.patternLength = 0;
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (this.menu.getCarried().isEmpty()) {
            if (this.modelTypeLength > 0 && (x >= this.leftPos + 44 && x <= this.leftPos + 69) && (y >= this.topPos + 58 && y <= this.topPos + 69)) {
                List<Component> tooltip = Lists.newArrayList();
                tooltip.add(this.modelTypes[this.modelTypeSelection].value().displayInfo().modelName());
                if (this.minecraft.options.advancedItemTooltips) {
                    tooltip.add(Component.literal(this.modelTypeRegistry.getKey(this.modelTypes[this.modelTypeSelection].value()).toString()).withStyle(ChatFormatting.DARK_GRAY));
                }
                guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
            }
            if (this.skinLength > 0 && (x >= this.leftPos + 44 && x <= this.leftPos + 69) && (y >= this.topPos + 75 && y <= this.topPos + 86)) {
                List<Component> tooltip = Lists.newArrayList();
                Pattern skin = this.skins[this.skinSelection].value();
                tooltip.add(skin.patternName());
                if (this.minecraft.options.advancedItemTooltips) {
                    tooltip.add(Component.literal(this.patternRegistry.getKey(skin).toString()).withStyle(ChatFormatting.DARK_GRAY));
                }
                guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
            }
            if (this.patternLength > 0 && (x >= this.leftPos + 44 && x <= this.leftPos + 69) && (y >= this.topPos + 92 && y <= this.topPos + 103)) {
                List<Component> tooltip = Lists.newArrayList();
                Holder<Pattern> pattern = this.patterns[this.patternSelection];
                if (!pattern.is(FAPatterns.BLANK) || this.skins[this.skinSelection].is(FAPatternTags.HAS_PATTERNS)) {
                    tooltip.add(pattern.value().patternName());
                    if (this.minecraft.options.advancedItemTooltips) {
                        tooltip.add(Component.literal(this.patternRegistry.getKey(pattern.value()).toString()).withStyle(ChatFormatting.DARK_GRAY));
                    }
                    guiGraphics.renderTooltip(this.font, tooltip, Optional.empty(), x, y);
                }
            }
        }
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (FAKeys.NAVIGATE_LEFT.matches(keyCode, scanCode)) {
            if (this.selectedGene == 0) {
                if (this.modelTypeSelection != 0) {
                    this.modelTypeSelection--;
                    return true;
                }
            } else if (this.selectedGene == 1) {
                if (this.skinSelection != 0) {
                    this.skinSelection--;
                    return true;
                }
            } else if (this.selectedGene == 2 && this.patternLength > 0) {
                if (this.patternSelection != 0) {
                    this.patternSelection--;
                    return true;
                }
            }
        }
        if (FAKeys.NAVIGATE_RIGHT.matches(keyCode, scanCode)) {
            if (this.selectedGene == 0) {
                if (this.modelTypeSelection != this.modelTypeLength - 1) {
                    this.modelTypeSelection++;
                    return true;
                }
            } else if (this.selectedGene == 1) {
                if (this.skinSelection != this.skinLength - 1) {
                    this.skinSelection++;
                    return true;
                }
            } else if (this.selectedGene == 2 && this.patternLength > 0) {
                if (this.patternSelection != this.patternLength - 1) {
                    this.patternSelection++;
                    return true;
                }
            }
        }
        if (FAKeys.APPLY_GENE.matches(keyCode, scanCode)) {
            if (this.modelTypeLength > 0 && this.skinLength > 0) {
                Optional<String> pattern = Optional.empty();
                if (this.patternLength > 0 && !this.patterns[this.patternSelection].is(FAPatterns.BLANK)) {
                    pattern = Optional.of(this.patternRegistry.getKey(this.patterns[this.patternSelection].value()).toString());
                }
                FAModloaderHelper.INSTANCE.sendApplyGenePacket(this.menu.DNARecombinatorBlockEntity.getBlockPos(), this.modelTypeRegistry.getKey(this.modelTypes[this.modelTypeSelection].value()).toString(), this.patternRegistry.getKey(this.skins[this.skinSelection].value()).toString(), pattern);
                return true;
            }
        }
        if (FAKeys.NAVIGATE_UP.matches(keyCode, keyCode)) {
            if (this.selectedGene > 0) {
                this.selectedGene--;
            }
            return true;
        }
        if (FAKeys.NAVIGATE_DOWN.matches(keyCode, keyCode)) {
            if (this.selectedGene < 3 && (this.selectedGene + 1 != 2 || this.skins[this.skinSelection].is(FAPatternTags.HAS_PATTERNS))) {
                this.selectedGene++;
            }
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
        guiGraphics.pose().translate(x, y, 150.0);
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
