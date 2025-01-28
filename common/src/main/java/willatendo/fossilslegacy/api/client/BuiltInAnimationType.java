package willatendo.fossilslegacy.api.client;

import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

import java.util.Map;

public interface BuiltInAnimationType {
    Map<ResourceLocation, BuiltInAnimationType> VALUES = Maps.newHashMap();

    ResourceLocation getId();

    boolean canUse(Dinosaur dinosaur);

    void setupAnim(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw);

    void prepareMobModel(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float partialTick);

    static BuiltInAnimationType get(ResourceLocation id) {
        return BuiltInAnimationType.VALUES.get(id);
    }
}
