package willatendo.fossilslegacy.server.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FADamageTypeTags {
    private static final TagRegister<DamageType> DAMAGE_TYPE_TAGS = TagRegister.create(Registries.DAMAGE_TYPE, FAUtils.ID);

    public static final TagKey<DamageType> SPINOSAURUS_IMMUNE = DAMAGE_TYPE_TAGS.register("spinosaurus_immune");
    public static final TagKey<DamageType> TYRANNOSAURUS_IMMUNE = DAMAGE_TYPE_TAGS.register("tyrannosaurus_immune");
}
