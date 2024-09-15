package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;

public class VelociraptorEggItem extends EggItem {
    public VelociraptorEggItem(Holder<EggVariant> eggVariant, Properties properties) {
        super(eggVariant, FossilsLegacyCoatTypeTags.NON_LEGACY_VELOCIRAPTOR, properties);
    }

    @Override
    public void entityModification(ItemStack itemStack, Entity entity) {
        Egg egg = (Egg) entity;
        egg.setEggVariant(this.eggVariant);
        if (itemStack.has(FossilsLegacyDataComponents.COAT_TYPE.get())) {
            egg.setCoatType(itemStack.get(FossilsLegacyDataComponents.COAT_TYPE.get()));
        } else {
            Level level = egg.level();
            Holder<Biome> biome = level.getBiome(egg.blockPosition());
            Registry<CoatType> coatTypeRegistry = level.registryAccess().registry(FossilsLegacyRegistries.COAT_TYPES).get();
            if (biome.value().coldEnoughToSnow(egg.blockPosition())) {
                egg.setCoatType(coatTypeRegistry.getHolder(FossilsLegacyCoatTypes.WHITE_VELOCIRAPTOR).get());
            } else if (biome.value().getBaseTemperature() >= 2.0F) {
                egg.setCoatType(coatTypeRegistry.getHolder(FossilsLegacyCoatTypes.SANDY_VELOCIRAPTOR).get());
            } else {
                egg.setCoatType(coatTypeRegistry.getHolder(FossilsLegacyCoatTypes.GREEN_VELOCIRAPTOR).get());
            }
        }
    }
}
