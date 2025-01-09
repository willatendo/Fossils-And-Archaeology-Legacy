package willatendo.fossilslegacy.mixin.client;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Gui.class)
public interface RenderTextureOverlayAccessor {
    @Invoker("renderTextureOverlay")
    void fossil_renderTextureOverlay(GuiGraphics guiGraphics, ResourceLocation texture, float alpha);
}
