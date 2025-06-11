package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

public class VelociraptorEggItem extends EggItem {
    public VelociraptorEggItem(GeologicalTimeScale.Period period, Properties properties) {
        super(FAEntityTypes.VELOCIRAPTOR_EGG::get, period, FAModelTypeTags.NON_LEGACY_VELOCIRAPTOR, properties);
    }

    @Override
    public void entityModification(ItemStack itemStack, Egg egg) {
        if (itemStack.has(FADataComponents.MODEL_TYPE.get())) {
            egg.setModelType(itemStack.get(FADataComponents.MODEL_TYPE.get()));
            egg.setSkin(itemStack.get(FADataComponents.PATTERN_HOLDER.get()).skin());
        } else {
            Level level = egg.level();
            Holder<Biome> biome = level.getBiome(egg.blockPosition());
            Registry<Pattern> patternRegistry = level.registryAccess().lookupOrThrow(FARegistries.PATTERN);
            if (biome.value().coldEnoughToSnow(egg.blockPosition(), level.getSeaLevel())) {
                egg.setSkin(patternRegistry.get(FAPatterns.WHITE_VELOCIRAPTOR_2011).get());
            } else if (biome.value().getBaseTemperature() >= 2.0F) {
                egg.setSkin(patternRegistry.get(FAPatterns.SANDY_VELOCIRAPTOR_2011).get());
            } else {
                egg.setSkin(patternRegistry.get(FAPatterns.GREEN_VELOCIRAPTOR_2011).get());
            }
        }
    }
}
