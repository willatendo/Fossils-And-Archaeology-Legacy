package willatendo.fossilslegacy.server.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.registry.VillagerProfessionRegistry;

public final class FAVillagerProfessions {
    public static final VillagerProfessionRegistry VILLAGER_PROFESSIONS = SimpleRegistry.createVillagerProfession(FAUtils.ID);

    public static final SimpleHolder<VillagerProfession> ARCHAEOLOGIST = VILLAGER_PROFESSIONS.registerSimple("archaeologist", FAPoiTypes.ARCHAEOLOGIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);
    public static final SimpleHolder<VillagerProfession> PALAEONTOLOGIST = VILLAGER_PROFESSIONS.registerSimple("palaeontologist", FAPoiTypes.PALAEONTOLOGIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);
    public static final SimpleHolder<VillagerProfession> GENETICIST = VILLAGER_PROFESSIONS.registerSimple("geneticist", FAPoiTypes.GENETICIST, SoundEvents.VILLAGER_WORK_CARTOGRAPHER);
}
