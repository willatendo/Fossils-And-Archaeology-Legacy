package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;

public abstract class LegacyEntityRenderer<T extends Mob> extends MobRenderer<T, EntityModel<T>> {
    public LegacyEntityRenderer(EntityRendererProvider.Context context, EntityModel<T> model, EntityModel<T> legacyModel, float shadowSize) {
        super(context, FossilsModloaderHelper.INSTANCE.legacyModels() ? legacyModel : model, shadowSize);
    }

    protected boolean legacyModels() {
        return FossilsModloaderHelper.INSTANCE.legacyModels();
    }

    protected abstract ResourceLocation legacyTextureLocation(T mob);

    protected abstract ResourceLocation textureLocation(T mob);

    @Override
    public ResourceLocation getTextureLocation(T mob) {
        return this.legacyModels() ? this.legacyTextureLocation(mob) : this.textureLocation(mob);
    }
}
