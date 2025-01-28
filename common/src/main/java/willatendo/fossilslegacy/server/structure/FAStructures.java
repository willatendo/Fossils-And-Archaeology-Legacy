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
import willatendo.fossilslegacy.server.structure.pool.*;
import willatendo.fossilslegacy.server.structure.structures.WeaponShopStructure;
import willatendo.fossilslegacy.server.tags.FABiomeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Optional;

public final class FAStructures {
    public static final ResourceKey<Structure> ACADEMY = create("academy");
    public static final ResourceKey<Structure> LAB = create("lab");
    public static final ResourceKey<Structure> MACHU_PICCHU = create("machu_picchu");
    public static final ResourceKey<Structure> MAYAN_CITY = create("mayan_city");
    public static final ResourceKey<Structure> SMALL_MAYAN_TEMPLE = create("small_mayan_temple");
    public static final ResourceKey<Structure> MOAI = create("moai");
    public static final ResourceKey<Structure> TOTEM_POLE = create("totem_pole");
    public static final ResourceKey<Structure> WEAPON_SHOP = create("weapon_shop");

    public static ResourceKey<Structure> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<Structure> bootstrapContext) {
        HolderGetter<Biome> biomes = bootstrapContext.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> structureTemplatePools = bootstrapContext.lookup(Registries.TEMPLATE_POOL);
        bootstrapContext.register(ACADEMY, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_ACADEMY)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(AcademyPools.START), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        bootstrapContext.register(LAB, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_LAB)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(LabPools.START), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        bootstrapContext.register(MACHU_PICCHU, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_MACHU_PICCHU)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(MachuPicchuPools.START), Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 116, List.of(), JigsawStructure.DEFAULT_DIMENSION_PADDING, JigsawStructure.DEFAULT_LIQUID_SETTINGS));
        bootstrapContext.register(MAYAN_CITY, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_MAYAN_TEMPLE)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(MayanCityPools.START), Optional.empty(), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 116, List.of(), JigsawStructure.DEFAULT_DIMENSION_PADDING, JigsawStructure.DEFAULT_LIQUID_SETTINGS));
        bootstrapContext.register(SMALL_MAYAN_TEMPLE, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_MAYAN_TEMPLE)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(SmallMayanTemplePools.START), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        bootstrapContext.register(MOAI, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_MOAI)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(MoaiPools.START), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        bootstrapContext.register(TOTEM_POLE, new JigsawStructure(new Structure.StructureSettings.Builder(biomes.getOrThrow(FABiomeTags.HAS_TOTEM_POLE)).terrainAdapation(TerrainAdjustment.BEARD_THIN).build(), structureTemplatePools.getOrThrow(TotemPolePools.START), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        bootstrapContext.register(WEAPON_SHOP, new WeaponShopStructure(new Structure.StructureSettings(biomes.getOrThrow(FABiomeTags.HAS_WEAPON_SHOP))));
    }
}
