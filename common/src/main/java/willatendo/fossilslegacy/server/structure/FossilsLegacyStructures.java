package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
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
        bootstrapContext.register(ACADEMY, new AcademyStructure(new Structure.StructureSettings(biomes.getOrThrow(FossilsLegacyBiomeTags.HAS_ACADEMY))));
        bootstrapContext.register(WEAPON_SHOP, new WeaponShopStructure(new Structure.StructureSettings(biomes.getOrThrow(FossilsLegacyBiomeTags.HAS_WEAPON_SHOP))));
    }
}
