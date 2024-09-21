package willatendo.fossilslegacy.data;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.api.data.AnimationProvider;
import willatendo.fossilslegacy.client.animation.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Map;

public class FossilsLegacyAnimationProvider extends AnimationProvider {
    public FossilsLegacyAnimationProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll(Map<ResourceLocation, AnimationDefinition> animationDefinitions) {
        animationDefinitions.put(FossilsLegacyUtils.resource("brachiosaurus_walk"), BrachiosaurusAnimations.BRACHIOSAURUS_WALK);
        animationDefinitions.put(FossilsLegacyUtils.resource("compsognathus_walk"), CompsognathusAnimations.COMPSOGNATHUS_WALK);
        animationDefinitions.put(FossilsLegacyUtils.resource("dodo_float_down"), DodoAnimations.DODO_FALL);
        animationDefinitions.put(FossilsLegacyUtils.resource("dodo_walk"), DodoAnimations.DODO_WALK);
        animationDefinitions.put(FossilsLegacyUtils.resource("futabasaurus_swim"), FutabasaurusAnimations.FUTABASAURUS_SWIM);
        animationDefinitions.put(FossilsLegacyUtils.resource("futabasaurus_walk"), FutabasaurusAnimations.FUTABASAURUS_WALK);
        animationDefinitions.put(FossilsLegacyUtils.resource("pachycephalosaurus_walk"), PachycephalosaurusAnimations.PACHYCEPHALOSAURUS_WALK);
        animationDefinitions.put(FossilsLegacyUtils.resource("triceratops_walk"), TriceratopsAnimations.TRICERATOPS_WALK);
        animationDefinitions.put(FossilsLegacyUtils.resource("velociraptor_walk"), VelociraptorAnimations.VELOCIRAPTOR_WALK);
    }
}
