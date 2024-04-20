package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyStructureSets {
	public static final ResourceKey<StructureSet> ACADEMY = create("academy");
	public static final ResourceKey<StructureSet> WEAPON_SHOP = create("weapon_shop");

	public static ResourceKey<StructureSet> create(String name) {
		return ResourceKey.create(Registries.STRUCTURE_SET, FossilsLegacyUtils.resource(name));
	}

	public static void bootstrap(BootstapContext<StructureSet> bootstapContext) {
		HolderGetter<Structure> structures = bootstapContext.lookup(Registries.STRUCTURE);
		bootstapContext.register(ACADEMY, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.ACADEMY), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272410)));
		bootstapContext.register(WEAPON_SHOP, new StructureSet(structures.getOrThrow(FossilsLegacyStructures.WEAPON_SHOP), new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1476272411)));

	}
}
