package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.core.Holder;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;

public record ArticulatedFossilRecipe(int fossilCount, Holder<FossilVariant> fossilVariant) {
}
