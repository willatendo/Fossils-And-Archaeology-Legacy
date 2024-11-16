package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyStructureSets {
    public static final ResourceKey<StructureSet> ACADEMY = FossilsLegacyStructureSets.create("academy");
    public static final ResourceKey<StructureSet> LAB = FossilsLegacyStructureSets.create("lab");
    public static final ResourceKey<StructureSet> MACHU_PICCHU = FossilsLegacyStructureSets.create("machu_picchu");
    public static final ResourceKey<StructureSet> MAYAN_CITY = FossilsLegacyStructureSets.create("mayan_city");
    public static final ResourceKey<StructureSet> SMALL_MAYAN_TEMPLE = FossilsLegacyStructureSets.create("small_mayan_temple");
    public static final ResourceKey<StructureSet> MOAI = FossilsLegacyStructureSets.create("moai");
    public static final ResourceKey<StructureSet> TOTEM_POLE = FossilsLegacyStructureSets.create("totem_pole");
    public static final ResourceKey<StructureSet> WEAPON_SHOP = FossilsLegacyStructureSets.create("weapon_shop");

    public static ResourceKey<StructureSet> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<StructureSet> bootstrapContext) {
        HolderGetter<Structure> structures = bootstrapContext.lookup(Registries.STRUCTURE);
        bootstrapContext.register(ACADEMY, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.ACADEMY), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272410)));
        bootstrapContext.register(LAB, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.LAB), new RandomSpreadStructurePlacement(64, 16, RandomSpreadType.LINEAR, 1476272417)));
        bootstrapContext.register(MACHU_PICCHU, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.MACHU_PICCHU), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272416)));
        bootstrapContext.register(MAYAN_CITY, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.MAYAN_CITY), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272415)));
        bootstrapContext.register(SMALL_MAYAN_TEMPLE, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.SMALL_MAYAN_TEMPLE), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272414)));
        bootstrapContext.register(MOAI, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.MOAI), new RandomSpreadStructurePlacement(16, 4, RandomSpreadType.LINEAR, 1476272413)));
        bootstrapContext.register(TOTEM_POLE, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.TOTEM_POLE), new RandomSpreadStructurePlacement(16, 4, RandomSpreadType.LINEAR, 1476272412)));
        bootstrapContext.register(WEAPON_SHOP, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.WEAPON_SHOP), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272411)));
    }
}
