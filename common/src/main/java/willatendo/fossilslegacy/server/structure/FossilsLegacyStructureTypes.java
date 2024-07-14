package willatendo.fossilslegacy.server.structure;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyStructureTypes {
    public static final SimpleRegistry<StructureType<?>> STRUCTURE_TYPE = SimpleRegistry.create(Registries.STRUCTURE_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<StructureType<AcademyStructure>> ACADEMY = STRUCTURE_TYPE.register("academy", () -> new StructureType<AcademyStructure>() {
        @Override
        public MapCodec<AcademyStructure> codec() {
            return AcademyStructure.CODEC;
        }
    });

    public static final SimpleHolder<StructureType<WeaponShopStructure>> WEAPON_SHOP = STRUCTURE_TYPE.register("weapon_shop", () -> new StructureType<WeaponShopStructure>() {
        @Override
        public MapCodec<WeaponShopStructure> codec() {
            return WeaponShopStructure.CODEC;
        }
    });
}
