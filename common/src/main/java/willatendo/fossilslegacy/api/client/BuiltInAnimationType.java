package willatendo.fossilslegacy.api.client;

import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

import java.util.Map;

public interface BuiltInAnimationType {
    Map<ResourceLocation, BuiltInAnimationType> VALUES = Maps.newHashMap();

    ResourceLocation getId();

    boolean canUse(DinosaurRenderState dinosaurRenderState);

    void setupAnim(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw);

    static BuiltInAnimationType get(ResourceLocation id) {
        return BuiltInAnimationType.VALUES.get(id);
    }
}
