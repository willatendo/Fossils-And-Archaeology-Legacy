package willatendo.fossilslegacy.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public class DebugGeneticsScreen extends Screen {
    private final ChromosomedEntity chromosomedEntity;
    private final Registry<SkinGene> skinGeneRegistry;
    private final Registry<PatternGene> patternGeneRegistry;
    private final Registry<ModelGene> modelGeneRegistry;

    public DebugGeneticsScreen(ChromosomedEntity chromosomedEntity) {
        super(Component.empty());
        this.chromosomedEntity = chromosomedEntity;
        RegistryAccess registryAccess = Minecraft.getInstance().level.registryAccess();
        this.skinGeneRegistry = registryAccess.lookupOrThrow(FARegistries.SKIN_GENE);
        this.patternGeneRegistry = registryAccess.lookupOrThrow(FARegistries.PATTERN_GENE);
        this.modelGeneRegistry = registryAccess.lookupOrThrow(FARegistries.MODEL_GENE);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.drawCenteredStringMinusShadow(guiGraphics, this.font, this.modelGeneRegistry.getOrThrow(this.chromosomedEntity.getChromosome1().cosmeticGeneHolder().modelGene()).value().displayInfo().modelName(), 0, 0, 0, false);
        this.drawCenteredStringMinusShadow(guiGraphics, this.font, this.skinGeneRegistry.getOrThrow(this.chromosomedEntity.getChromosome1().cosmeticGeneHolder().skinGene()).value().skinName(), 0, 10, 0, false);
        Optional<ResourceKey<PatternGene>> patternGene = this.chromosomedEntity.getChromosome1().cosmeticGeneHolder().patternGene();
        patternGene.ifPresent(patternGeneResourceKey -> this.drawCenteredStringMinusShadow(guiGraphics, this.font, this.patternGeneRegistry.getOrThrow(patternGeneResourceKey).value().patternName(), 0, 20, 0, false));

        this.drawCenteredStringMinusShadow(guiGraphics, this.font, this.modelGeneRegistry.getOrThrow(this.chromosomedEntity.getChromosome2().cosmeticGeneHolder().modelGene()).value().displayInfo().modelName(), 0, 60, 0, false);
        this.drawCenteredStringMinusShadow(guiGraphics, this.font, this.skinGeneRegistry.getOrThrow(this.chromosomedEntity.getChromosome2().cosmeticGeneHolder().skinGene()).value().skinName(), 0, 70, 0, false);
        patternGene = this.chromosomedEntity.getChromosome2().cosmeticGeneHolder().patternGene();
        patternGene.ifPresent(patternGeneResourceKey -> this.drawCenteredStringMinusShadow(guiGraphics, this.font, this.patternGeneRegistry.getOrThrow(patternGeneResourceKey).value().patternName(), 0, 80, 0, false));
    }

    private void drawCenteredStringMinusShadow(GuiGraphics guiGraphics, Font font, Component text, int x, int y, int color, boolean centered) {
        int drawX = x + 36;
        if (centered) {
            drawX = x - (font.width(text) / 2) + (192 / 2);
        }
        guiGraphics.drawString(font, text, drawX, y, color, false);
    }
}
