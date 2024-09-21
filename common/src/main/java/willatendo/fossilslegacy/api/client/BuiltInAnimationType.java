package willatendo.fossilslegacy.api.client;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public interface BuiltInAnimationType {
    ResourceLocation getId();

    boolean canUse(Dinosaur dinosaur);

    void setupAnim(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw);

    void prepareMobModel(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick);
}
