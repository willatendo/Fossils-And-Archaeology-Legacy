package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.TriceratopsLegacyModel;
import willatendo.fossilslegacy.client.model.triceratops.BabyTriceratopsModel;
import willatendo.fossilslegacy.client.model.triceratops.TriceratopsModel;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsRenderer extends GrowingDinosaurRenderer<Triceratops, EntityModel<Triceratops>, BabyTriceratopsModel, TriceratopsModel, TriceratopsLegacyModel> {

	public TriceratopsRenderer(Context context) {
		super(context, new BabyTriceratopsModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS_BABY)), new TriceratopsModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS_ADULT)), new TriceratopsLegacyModel(context.bakeLayer(FossilsLegacyModels.LEGACY_TRICERATOPS)), 0.15F);
	}

	@Override
	public float growScale(Triceratops triceratops, boolean isLegacyModel) {
		return isLegacyModel ? (triceratops.getGrowthStage() * 0.5F) : (triceratops.getGrowthStage() - (triceratops.isBaby() ? 0 : 2)) * 0.25F;
	}

	@Override
	public float shadowScale(Triceratops triceratops, boolean isLegacyModel) {
		return 0.15F;
	}

	@Override
	public float legacyScaleFactor(Triceratops triceratops) {
		return 1.0F;
	}

	@Override
	public ResourceLocation getTextures(Triceratops triceratops) {
		return triceratops.textures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
	}

	@Override
	public ResourceLocation getLegacyTextures(Triceratops triceratops) {
		return triceratops.legacyTextures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
	}
}
