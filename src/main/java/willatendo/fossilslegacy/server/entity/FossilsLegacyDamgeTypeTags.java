package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyDamgeTypeTags {
	public static final TagRegister<DamageType> DAMAGE_TYPE_TAGS = SimpleUtils.create(Registries.DAMAGE_TYPE, FossilsLegacyUtils.ID);

	public static final TagKey<DamageType> TYRANNOSAURUS_IMMUNE = DAMAGE_TYPE_TAGS.register("tyrannosaurus_immune");
}
