package willatendo.fossilslegacy.server.jei.ingredient;

import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.registry.FARegistries;

public final class CoatTypeHelper implements IIngredientHelper<CoatType> {
    @Override
    public IIngredientType<CoatType> getIngredientType() {
        return FAIngredientTypes.COAT_TYPE;
    }

    @Override
    public String getDisplayName(CoatType coatType) {
        return coatType.displayInfo().name().getString();
    }

    @Override
    public String getUniqueId(CoatType coatType, UidContext uidContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        RegistryAccess registryAccess = clientLevel.registryAccess();
        return registryAccess.registryOrThrow(FARegistries.COAT_TYPES).getKey(coatType).toString();
    }

    @Override
    public String getDisplayModId(CoatType coatType) {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.level.registryAccess().registryOrThrow(FARegistries.COAT_TYPES).getKey(coatType).getNamespace();
    }

    @Override
    public long getAmount(CoatType coatType) {
        return 1;
    }

    @Override
    public ResourceLocation getResourceLocation(CoatType coatType) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        RegistryAccess registryAccess = clientLevel.registryAccess();
        return registryAccess.registryOrThrow(FARegistries.COAT_TYPES).getKey(coatType);
    }

    @Override
    public CoatType copyIngredient(CoatType coatType) {
        return coatType;
    }

    @Override
    public String getErrorInfo(@Nullable CoatType coatType) {
        if (coatType == null) {
            return "null";
        }
        String itemName = this.getResourceLocation(coatType).getPath();
        return coatType + " " + itemName;
    }
}
