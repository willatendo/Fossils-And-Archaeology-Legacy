package willatendo.fossilslegacy.server.jei.ingredient;

import com.mojang.blaze3d.systems.RenderSystem;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.TooltipFlag;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class CoatTypeRenderer implements IIngredientRenderer<CoatType> {
    private final ResourceLocation geneSprite;
    private final int width;
    private final int height;

    public CoatTypeRenderer(ResourceLocation geneSprite, int width, int height) {
        this.geneSprite = geneSprite;
        this.width = width;
        this.height = height;
    }

    public CoatTypeRenderer(String geneSprite, int width, int height) {
        this(FossilsLegacyUtils.resource("jei/icon/" + geneSprite), width, height);
    }

    @Override
    public void render(GuiGraphics guiGraphics, CoatType ingredient) {
        this.render(guiGraphics, ingredient, 0, 0);
    }

    @Override
    public void render(GuiGraphics guiGraphics, CoatType coatType, int x, int y) {
        float red = ((coatType.displayInfo().color() & 0xFF0000) >> 16) / 255.0F;
        float green = ((coatType.displayInfo().color() & 0xFF00) >> 8) / 255.0F;
        float blue = (coatType.displayInfo().color() & 0xFF) / 255.0F;
        RenderSystem.setShaderColor(red, green, blue, 1.0F);
        guiGraphics.blitSprite(this.geneSprite, x, y, this.width, this.height);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public List<Component> getTooltip(CoatType coatType, TooltipFlag tooltipFlag) {
        List<Component> tooltip = Lists.newArrayList();
        tooltip.add(coatType.displayInfo().pattern());
        Minecraft minecraft = Minecraft.getInstance();
        if (tooltipFlag.isAdvanced()) {
            tooltip.add(Component.literal(minecraft.level.registryAccess().registry(FossilsLegacyRegistries.COAT_TYPES).get().getKey(coatType).toString()).withStyle(ChatFormatting.DARK_GRAY));
        }
        return tooltip;
    }

    @Override
    public void getTooltip(ITooltipBuilder iTooltipBuilder, CoatType coatType, TooltipFlag tooltipFlag) {
        iTooltipBuilder.add(coatType.displayInfo().name());
        iTooltipBuilder.add(coatType.displayInfo().pattern());
        Minecraft minecraft = Minecraft.getInstance();
        if (tooltipFlag.isAdvanced()) {
            iTooltipBuilder.add(Component.literal(minecraft.level.registryAccess().registry(FossilsLegacyRegistries.COAT_TYPES).get().getKey(coatType).toString()).withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
