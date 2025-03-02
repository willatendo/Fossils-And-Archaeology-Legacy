package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.model_type.FAModelTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

public class VelociraptorEggItem extends EggItem {
    public VelociraptorEggItem(GeologicalTimeScale.Period period, Properties properties) {
        super(FAEntityTypes.VELOCIRAPTOR_EGG::get, period, FAModelTypeTags.NON_LEGACY_VELOCIRAPTOR, properties);
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            egg.setCoatType(itemStack.get(FADataComponents.MODEL_TYPE.get()));
        } else {
            Level level = egg.level();
            Holder<Biome> biome = level.getBiome(egg.blockPosition());
            Registry<ModelType> coatTypeRegistry = level.registryAccess().lookupOrThrow(FARegistries.MODEL_TYPES);
            if (biome.value().coldEnoughToSnow(egg.blockPosition(), level.getSeaLevel())) {
                egg.setCoatType(coatTypeRegistry.get(FAModelTypes.WHITE_VELOCIRAPTOR).get());
            } else if (biome.value().getBaseTemperature() >= 2.0F) {
                egg.setCoatType(coatTypeRegistry.get(FAModelTypes.SANDY_VELOCIRAPTOR).get());
            } else {
                egg.setCoatType(coatTypeRegistry.get(FAModelTypes.VELOCIRAPTOR).get());
            }
        }
    }
}
