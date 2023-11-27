package willatendo.fossilslegacy.server.entity;

import net.minecraft.resources.ResourceLocation;

public interface SubSpecies {
	int getSubSpecies();

	void setSubSpecies(int subSpecies);

	ResourceLocation[][] textures();

	ResourceLocation[][] legacyTextures();
}
