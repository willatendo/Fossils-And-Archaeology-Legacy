package willatendo.fossilslegacy.server.jei.ingredient;

import mezz.jei.api.ingredients.IIngredientType;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

public final class FossilsLegacyIngredientTypes {
    public static final IIngredientType<CoatType> COAT_TYPE = new IIngredientType<>() {
        @Override
        public String getUid() {
            return "coat_type";
        }

        @Override
        public Class<CoatType> getIngredientClass() {
            return CoatType.class;
        }
    };
}
