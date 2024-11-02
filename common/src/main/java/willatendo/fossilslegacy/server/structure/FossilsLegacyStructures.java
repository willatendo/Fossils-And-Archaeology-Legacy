package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import willatendo.fossilslegacy.server.structure.pool.AcademyPools;
import willatendo.fossilslegacy.server.tags.FossilsLegacyBiomeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyStructures {
    public static final ResourceKey<Structure> ACADEMY = create("academy");
    public static final ResourceKey<Structure> WEAPON_SHOP = create("weapon_shop");

    public static ResourceKey<Structure> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<Structure> bootstrapContext) {
        HolderGetter<Biome> biomes = bootstrapContext.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> structureTemplatePools = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        bootstrapContext.register(ACADEMY, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FossilsLegacyBiomeTags.HAS_ACADEMY)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(AcademyPools.START), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), true, Heightmap.Types.WORLD_SURFACE_WG));
        bootstrapContext.register(WEAPON_SHOP, new WeaponShopStructure(new Structure.StructureSettings(biomes.getOrThrow(FossilsLegacyBiomeTags.HAS_WEAPON_SHOP))));
    }
}
