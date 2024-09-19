package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.resources.ResourceLocation;

public interface SubSpecies {
    int getSubSpecies();

    void setSubSpecies(int subSpecies);

    ResourceLocation[][] textures();

    default ResourceLocation[][] legacyTextures() {
        return this.textures();
    }
}
