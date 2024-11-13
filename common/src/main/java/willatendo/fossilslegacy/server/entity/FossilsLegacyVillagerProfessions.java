package willatendo.fossilslegacy.server.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import willatendo.fossilslegacy.server.entity.poi.FossilsLegacyPoiTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyVillagerProfessions {
    public static final SimpleRegistry<VillagerProfession> VILLAGER_PROFESSIONS = SimpleRegistry.create(Registries.VILLAGER_PROFESSION, FossilsLegacyUtils.ID);

    public static final SimpleHolder<VillagerProfession> ARCHAEOLOGIST = FossilsLegacyVillagerProfessions.register("archaeologist", FossilsLegacyPoiTypes.ARCHAEOLOGIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);
    public static final SimpleHolder<VillagerProfession> PALAEONTOLOGIST = FossilsLegacyVillagerProfessions.register("palaeontologist", FossilsLegacyPoiTypes.PALAEONTOLOGIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);


    private static SimpleHolder<VillagerProfession> register(String id, ResourceKey<PoiType> jobSite, SoundEvent workSound) {
        return VILLAGER_PROFESSIONS.register(id, () -> new VillagerProfession(id, heldJobSite -> heldJobSite.is(jobSite), acquirableJobSite -> acquirableJobSite.is(jobSite), ImmutableSet.of(), ImmutableSet.of(), workSound));
    }

}
