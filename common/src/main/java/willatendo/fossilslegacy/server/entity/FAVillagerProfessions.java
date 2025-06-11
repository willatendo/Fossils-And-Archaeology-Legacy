package willatendo.fossilslegacy.server.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAVillagerProfessions {
    public static final SimpleRegistry<VillagerProfession> VILLAGER_PROFESSIONS = SimpleRegistry.create(Registries.VILLAGER_PROFESSION, FAUtils.ID);

    public static final SimpleHolder<VillagerProfession> ARCHAEOLOGIST = FAVillagerProfessions.register("archaeologist", FAPoiTypes.ARCHAEOLOGIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);
    public static final SimpleHolder<VillagerProfession> PALAEONTOLOGIST = FAVillagerProfessions.register("palaeontologist", FAPoiTypes.PALAEONTOLOGIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);

    private static SimpleHolder<VillagerProfession> register(String id, ResourceKey<PoiType> jobSite, SoundEvent workSound) {
        return VILLAGER_PROFESSIONS.register(id, () -> new VillagerProfession(id, heldJobSite -> heldJobSite.is(jobSite), acquirableJobSite -> acquirableJobSite.is(jobSite), ImmutableSet.of(), ImmutableSet.of(), workSound));
    }
}
