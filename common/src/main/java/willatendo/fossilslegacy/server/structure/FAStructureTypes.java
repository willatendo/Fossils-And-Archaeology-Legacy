package willatendo.fossilslegacy.server.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import willatendo.fossilslegacy.server.structure.structures.WeaponShopStructure;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAStructureTypes {
    public static final SimpleRegistry<StructureType<?>> STRUCTURE_TYPE = SimpleRegistry.create(Registries.STRUCTURE_TYPE, FAUtils.ID);

    public static final SimpleHolder<StructureType<WeaponShopStructure>> WEAPON_SHOP = STRUCTURE_TYPE.register("weapon_shop", () -> () -> WeaponShopStructure.CODEC);
}
