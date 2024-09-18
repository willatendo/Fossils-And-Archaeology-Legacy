package willatendo.fossilslegacy.client.model.json;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.dinosaur.base.DinosaurModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class JsonModel extends DinosaurModel<Dinosaur> {
    private final JsonModelLoader.Animations animations;

    public JsonModel(ResourceLocation id, ModelPart root) {
        super(root);
        this.animations = JsonModelLoader.getAnimations(id);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        if (this.animations.swimAnimation().isPresent() && dinosaur.isInWaterOrBubble()) {
            this.animations.swimAnimation().ifPresent(resourceLocation -> this.animateWalk(JsonAnimationLoader.getAnimations().get(resourceLocation), limbSwing, limbSwingAmount, 2.0F, 2.5F));
        } else {
            this.animations.walkAnimation().ifPresent(resourceLocation -> this.animateWalk(JsonAnimationLoader.getAnimations().get(resourceLocation), limbSwing, limbSwingAmount, 2.0F, 2.5F));
        }
    }
}
