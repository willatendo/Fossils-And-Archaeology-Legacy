package willatendo.fossilslegacy.server.jei.ingredient;

import mezz.jei.api.ingredients.IIngredientType;
import willatendo.fossilslegacy.server.coat_type.CoatType;

public final class FAIngredientTypes {
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
