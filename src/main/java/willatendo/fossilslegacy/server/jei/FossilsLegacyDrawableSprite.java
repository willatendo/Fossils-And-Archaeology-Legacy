package willatendo.fossilslegacy.server.jei;

import org.joml.Matrix4f;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import mezz.jei.api.gui.drawable.IDrawableStatic;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;

public class FossilsLegacyDrawableSprite implements IDrawableStatic {
	private final FossilsLegacySpriteUploader fossilsLegacySpriteUploader;
	private final ResourceLocation resourceLocation;
	private final int width;
	private final int height;
	private int trimLeft;
	private int trimRight;
	private int trimTop;
	private int trimBottom;

	public FossilsLegacyDrawableSprite(FossilsLegacySpriteUploader fossilsLegacySpriteUploader, ResourceLocation resourceLocation, int width, int height) {
		this.fossilsLegacySpriteUploader = fossilsLegacySpriteUploader;
		this.resourceLocation = resourceLocation;
		this.width = width;
		this.height = height;
	}

	public FossilsLegacyDrawableSprite trim(int left, int right, int top, int bottom) {
		this.trimLeft = left;
		this.trimRight = right;
		this.trimTop = top;
		this.trimBottom = bottom;
		return this;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
		this.draw(guiGraphics, xOffset, yOffset, 0, 0, 0, 0);
	}

	@Override
	public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset, int maskTop, int maskBottom, int maskLeft, int maskRight) {
		TextureAtlasSprite textureAtlasSprite = this.fossilsLegacySpriteUploader.getSprite(this.resourceLocation);
		int textureWidth = this.width;
		int textureHeight = this.height;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, FossilsLegacyJEI.FOSSILS_LEGACY_TEXTURE_ATLAS);

		maskTop += trimTop;
		maskBottom += trimBottom;
		maskLeft += trimLeft;
		maskRight += trimRight;

		int x = xOffset + maskLeft;
		int y = yOffset + maskTop;
		int width = textureWidth - maskRight - maskLeft;
		int height = textureHeight - maskBottom - maskTop;
		float uSize = textureAtlasSprite.getU1() - textureAtlasSprite.getU0();
		float vSize = textureAtlasSprite.getV1() - textureAtlasSprite.getV0();

		float minU = textureAtlasSprite.getU0() + uSize * (maskLeft / (float) textureWidth);
		float minV = textureAtlasSprite.getV0() + vSize * (maskTop / (float) textureHeight);
		float maxU = textureAtlasSprite.getU1() - uSize * (maskRight / (float) textureWidth);
		float maxV = textureAtlasSprite.getV1() - vSize * (maskBottom / (float) textureHeight);

		Tesselator tessellator = Tesselator.getInstance();
		BufferBuilder bufferBuilder = tessellator.getBuilder();
		bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		Matrix4f matrix4f = guiGraphics.pose().last().pose();
		bufferBuilder.vertex(matrix4f, x, y + height, 0).uv(minU, maxV).endVertex();
		bufferBuilder.vertex(matrix4f, x + width, y + height, 0).uv(maxU, maxV).endVertex();
		bufferBuilder.vertex(matrix4f, x + width, y, 0).uv(maxU, minV).endVertex();
		bufferBuilder.vertex(matrix4f, x, y, 0).uv(minU, minV).endVertex();
		tessellator.end();
	}
}
