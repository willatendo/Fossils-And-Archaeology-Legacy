package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.core.Holder;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;

public record ArticulatedFossilRecipe(int fossilCount, Holder<FossilVariant> fossilVariant) {
}
