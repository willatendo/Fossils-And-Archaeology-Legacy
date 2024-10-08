package willatendo.fossilslegacy.server.jei.ingredient;

import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.common.platform.IPlatformItemStackHelper;
import mezz.jei.common.platform.Services;
import mezz.jei.common.util.ErrorUtil;
import mezz.jei.common.util.RegistryUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.Optional;

public final class CoatTypeHelper implements IIngredientHelper<CoatType> {
    @Override
    public IIngredientType<CoatType> getIngredientType() {
        return FossilsLegacyIngredientTypes.COAT_TYPE;
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
        return registryAccess.registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getKey(coatType).toString();
    }

    @Override
    public String getDisplayModId(CoatType coatType) {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.level.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getKey(coatType).getNamespace();
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
        return registryAccess.registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getKey(coatType);
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
