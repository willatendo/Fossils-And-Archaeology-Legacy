package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.coat_type.FACoatTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;

public class VelociraptorEggItem extends EggItem {
    public VelociraptorEggItem(GeologicalTimeScale.Period period, Properties properties) {
        super(FAEntityTypes.VELOCIRAPTOR_EGG::get, period, FACoatTypeTags.NON_LEGACY_VELOCIRAPTOR, properties);
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        if (itemStack.has(FADataComponents.COAT_TYPE.get())) {
            egg.setCoatType(itemStack.get(FADataComponents.COAT_TYPE.get()));
        } else {
            Level level = egg.level();
            Holder<Biome> biome = level.getBiome(egg.blockPosition());
            Registry<CoatType> coatTypeRegistry = level.registryAccess().lookupOrThrow(FARegistries.COAT_TYPES);
            if (biome.value().coldEnoughToSnow(egg.blockPosition(), level.getSeaLevel())) {
                egg.setCoatType(coatTypeRegistry.get(FACoatTypes.WHITE_VELOCIRAPTOR).get());
            } else if (biome.value().getBaseTemperature() >= 2.0F) {
                egg.setCoatType(coatTypeRegistry.get(FACoatTypes.SANDY_VELOCIRAPTOR).get());
            } else {
                egg.setCoatType(coatTypeRegistry.get(FACoatTypes.GREEN_VELOCIRAPTOR).get());
            }
        }
    }
}
