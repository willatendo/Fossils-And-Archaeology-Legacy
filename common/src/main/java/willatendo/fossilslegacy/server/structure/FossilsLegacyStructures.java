package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;

public class FossilsLegacyStructures {
    public static final ResourceKey<Structure> ACADEMY = create("academy");
    public static final ResourceKey<Structure> WEAPON_SHOP = create("weapon_shop");

    public static ResourceKey<Structure> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE, FossilsLegacyUtils.resource(name));
    }

    public static Structure.StructureSettings structure(HolderSet<Biome> holderSet, GenerationStep.Decoration decoration, TerrainAdjustment terrainAdjustment) {
        return Structures.structure(holderSet, Map.of(), decoration, terrainAdjustment);
    }

    public static Structure.StructureSettings structure(HolderSet<Biome> holderSet, TerrainAdjustment terrainAdjustment) {
        return Structures.structure(holderSet, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, terrainAdjustment);
    }

    public static void bootstrap(BootstrapContext<Structure> bootstrapContext) {
        HolderGetter<Biome> biomes = bootstrapContext.lookup(Registries.BIOME);
        bootstrapContext.register(ACADEMY, new AcademyStructure(FossilsLegacyStructures.structure(biomes.getOrThrow(FossilsLegacyBiomeTags.HAS_ACADEMY), TerrainAdjustment.NONE)));
        bootstrapContext.register(WEAPON_SHOP, new WeaponShopStructure(FossilsLegacyStructures.structure(biomes.getOrThrow(FossilsLegacyBiomeTags.HAS_WEAPON_SHOP), TerrainAdjustment.NONE)));
    }
}
