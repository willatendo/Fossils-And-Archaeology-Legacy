package willatendo.fossilslegacy.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import willatendo.fossilslegacy.server.entity.Anu;

public class AnuModel extends AgeableListModel<Anu> implements ArmedModel, HeadedModel {
    public final ModelPart root;
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;
    public ArmPose leftArmPose = ArmPose.EMPTY;
    public ArmPose rightArmPose = ArmPose.EMPTY;
    public float swimAmount;

    public AnuModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull, true, 16.0f, 0.0f, 2.0f, 2.0f, 20.0f);
        this.root = root;
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(-6.0F, 6.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(6.0F, 6.0F, 0.0F));
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 17).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 3.0F, 2.0F).texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(24, 2).addBox(-2.0F, -11.0F, -8.0F, 4.0F, 3.0F, 12.0F).texOffs(0, 17).addBox(2.0F, -13.0F, 3.0F, 2.0F, 5.0F, 1.0F).texOffs(0, 17).addBox(-4.0F, -13.0F, 3.0F, 2.0F, 5.0F, 1.0F).texOffs(0, 17).addBox(2.0F, -15.0F, 3.0F, 2.0F, 2.0F, 1.0F).texOffs(0, 17).addBox(-4.0F, -15.0F, 3.0F, 2.0F, 2.0F, 1.0F).texOffs(0, 0).addBox(2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-3.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
        partDefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(47, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F).mirror(false), PartPose.offset(-2.0F, 14.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(47, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(2.0F, 14.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(40, 18).addBox(-4.0F, -5.0F, -2.0F, 8.0F, 10.0F, 4.0F), PartPose.offset(0.0F, 9.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg);
    }

    @Override
    public void prepareMobModel(Anu anu, float position, float speed, float packedOverlay) {
        this.swimAmount = anu.getSwimAmount(packedOverlay);
        super.prepareMobModel(anu, position, speed, packedOverlay);
    }

    @Override
    public void setupAnim(Anu anu, float packedOverlay, float position, float speed, float bob, float xRot) {
        boolean lastArmed;
        boolean falling = anu.getFallFlyingTicks() > 4;
        boolean swimming = anu.isVisuallySwimming();
        this.head.yRot = bob * ((float) Math.PI / 180);
        this.head.xRot = falling ? -0.7853982F : (this.swimAmount > 0.0F ? (swimming ? this.rotlerpRad(this.swimAmount, this.head.xRot, -0.7853982F) : this.rotlerpRad(this.swimAmount, this.head.xRot, xRot * ((float) Math.PI / 180))) : xRot * ((float) Math.PI / 180));
        this.body.yRot = 0.0F;
        this.rightArm.z = 0.0F;
        this.rightArm.x = -5.0F;
        this.leftArm.z = 0.0F;
        this.leftArm.x = 5.0F;
        float k = 1.0F;
        if (falling) {
            k = (float) anu.getDeltaMovement().lengthSqr();
            k /= 0.2F;
            k *= k * k;
        }
        if (k < 1.0f) {
            k = 1.0f;
        }
        this.rightArm.xRot = Mth.cos(packedOverlay * 0.6662F + (float) Math.PI) * 2.0F * position * 0.5F / k;
        this.leftArm.xRot = Mth.cos(packedOverlay * 0.6662F) * 2.0F * position * 0.5F / k;
        this.rightArm.zRot = 0.0F;
        this.leftArm.zRot = 0.0F;
        this.rightLeg.xRot = Mth.cos(packedOverlay * 0.6662F) * 1.4F * position / k;
        this.leftLeg.xRot = Mth.cos(packedOverlay * 0.6662F + (float) Math.PI) * 1.4F * position / k;
        this.rightLeg.yRot = 0.005F;
        this.leftLeg.yRot = -0.005F;
        this.rightLeg.zRot = 0.005F;
        this.leftLeg.zRot = -0.005F;
        if (this.riding) {
            this.rightArm.xRot += -0.62831855F;
            this.leftArm.xRot += -0.62831855F;
            this.rightLeg.xRot = -1.4137167F;
            this.rightLeg.yRot = 0.31415927F;
            this.rightLeg.zRot = 0.07853982F;
            this.leftLeg.xRot = -1.4137167F;
            this.leftLeg.yRot = -0.31415927F;
            this.leftLeg.zRot = -0.07853982F;
        }
        this.rightArm.yRot = 0.0F;
        this.leftArm.yRot = 0.0F;
        boolean rightArmed = lastArmed = anu.getMainArm() == HumanoidArm.RIGHT;
        if (anu.isUsingItem()) {
            if (rightArmed == lastArmed) {
                this.poseRightArm(anu);
            } else {
                this.poseLeftArm(anu);
            }
        } else {
            if (lastArmed != rightArmed) {
                this.poseLeftArm(anu);
                this.poseRightArm(anu);
            } else {
                this.poseRightArm(anu);
                this.poseLeftArm(anu);
            }
        }
        this.setupAttackAnimation(anu, speed);
        this.body.xRot = 0.0F;
        this.rightLeg.z = 0.0F;
        this.leftLeg.z = 0.0F;
        this.rightLeg.y = 12.0F;
        this.leftLeg.y = 12.0F;
        this.head.y = 2.0F;
        this.body.y = 7.0F;
        this.leftArm.y = 4.0F;
        this.rightArm.y = 4.0F;
        if (this.rightArmPose != ArmPose.SPYGLASS) {
            AnimationUtils.bobModelPart(this.rightArm, speed, 1.0F);
        }
        if (this.leftArmPose != ArmPose.SPYGLASS) {
            AnimationUtils.bobModelPart(this.leftArm, speed, -1.0F);
        }
        if (this.swimAmount > 0.0F) {
            float o;
            float n;
            float l = packedOverlay % 26.0F;
            HumanoidArm humanoidArm = this.getAttackArm(anu);
            float m = humanoidArm == HumanoidArm.RIGHT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
            n = humanoidArm == HumanoidArm.LEFT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
            if (!anu.isUsingItem()) {
                if (l < 14.0F) {
                    this.leftArm.xRot = this.rotlerpRad(n, this.leftArm.xRot, 0.0F);
                    this.rightArm.xRot = Mth.lerp(m, this.rightArm.xRot, 0.0F);
                    this.leftArm.yRot = this.rotlerpRad(n, this.leftArm.yRot, (float) Math.PI);
                    this.rightArm.yRot = Mth.lerp(m, this.rightArm.yRot, (float) Math.PI);
                    this.leftArm.zRot = this.rotlerpRad(n, this.leftArm.zRot, (float) Math.PI + 1.8707964F * this.quadraticArmUpdate(l) / this.quadraticArmUpdate(14.0F));
                    this.rightArm.zRot = Mth.lerp(m, this.rightArm.zRot, (float) Math.PI - 1.8707964F * this.quadraticArmUpdate(l) / this.quadraticArmUpdate(14.0F));
                } else if (l >= 14.0F && l < 22.0F) {
                    o = (l - 14.0F) / 8.0F;
                    this.leftArm.xRot = this.rotlerpRad(n, this.leftArm.xRot, 1.5707964F * o);
                    this.rightArm.xRot = Mth.lerp(m, this.rightArm.xRot, 1.5707964F * o);
                    this.leftArm.yRot = this.rotlerpRad(n, this.leftArm.yRot, (float) Math.PI);
                    this.rightArm.yRot = Mth.lerp(m, this.rightArm.yRot, (float) Math.PI);
                    this.leftArm.zRot = this.rotlerpRad(n, this.leftArm.zRot, 5.012389F - 1.8707964F * o);
                    this.rightArm.zRot = Mth.lerp(m, this.rightArm.zRot, 1.2707963F + 1.8707964F * o);
                } else if (l >= 22.0F && l < 26.0F) {
                    o = (l - 22.0F) / 4.0F;
                    this.leftArm.xRot = this.rotlerpRad(n, this.leftArm.xRot, 1.5707964F - 1.5707964F * o);
                    this.rightArm.xRot = Mth.lerp(m, this.rightArm.xRot, 1.5707964F - 1.5707964F * o);
                    this.leftArm.yRot = this.rotlerpRad(n, this.leftArm.yRot, (float) Math.PI);
                    this.rightArm.yRot = Mth.lerp(m, this.rightArm.yRot, (float) Math.PI);
                    this.leftArm.zRot = this.rotlerpRad(n, this.leftArm.zRot, (float) Math.PI);
                    this.rightArm.zRot = Mth.lerp(m, this.rightArm.zRot, (float) Math.PI);
                }
            }
            o = 0.3F;
            this.leftLeg.xRot = Mth.lerp(this.swimAmount, this.leftLeg.xRot, 0.3f * Mth.cos(packedOverlay * 0.33333334F + (float) Math.PI));
            this.rightLeg.xRot = Mth.lerp(this.swimAmount, this.rightLeg.xRot, 0.3f * Mth.cos(packedOverlay * 0.33333334F));
        }
    }

    private void poseRightArm(Anu anu) {
        switch (this.rightArmPose) {
            case EMPTY: {
                this.rightArm.yRot = 0.0F;
                break;
            }
            case BLOCK: {
                this.poseBlockingArm(this.rightArm, true);
                break;
            }
            case ITEM: {
                this.rightArm.xRot = this.rightArm.xRot * 0.5F - 0.31415927F;
                this.rightArm.yRot = 0.0F;
                break;
            }
            case THROW_SPEAR: {
                this.rightArm.xRot = this.rightArm.xRot * 0.5F - (float) Math.PI;
                this.rightArm.yRot = 0.0F;
                break;
            }
            case BOW_AND_ARROW: {
                this.rightArm.yRot = -0.1F + this.head.yRot;
                this.leftArm.yRot = 0.1F + this.head.yRot + 0.4F;
                this.rightArm.xRot = -1.5707964F + this.head.xRot;
                this.leftArm.xRot = -1.5707964F + this.head.xRot;
                break;
            }
            case CROSSBOW_CHARGE: {
                AnimationUtils.animateCrossbowCharge(this.rightArm, this.leftArm, anu, true);
                break;
            }
            case CROSSBOW_HOLD: {
                AnimationUtils.animateCrossbowHold(this.rightArm, this.leftArm, this.head, true);
                break;
            }
            case BRUSH: {
                this.rightArm.xRot = this.rightArm.xRot * 0.5F - 0.62831855F;
                this.rightArm.yRot = 0.0f;
                break;
            }
            case SPYGLASS: {
                this.rightArm.xRot = Mth.clamp(this.head.xRot - 1.9198622F - (anu.isCrouching() ? 0.2617994F : 0.0F), -2.4F, 3.3F);
                this.rightArm.yRot = this.head.yRot - 0.2617994F;
                break;
            }
            case TOOT_HORN: {
                this.rightArm.xRot = Mth.clamp(this.head.xRot, -1.2F, 1.2F) - 1.4835298F;
                this.rightArm.yRot = this.head.yRot - 0.5235988F;
            }
        }
    }

    private void poseLeftArm(Anu anu) {
        switch (this.leftArmPose) {
            case EMPTY: {
                this.leftArm.yRot = 0.0F;
                break;
            }
            case BLOCK: {
                this.poseBlockingArm(this.leftArm, false);
                break;
            }
            case ITEM: {
                this.leftArm.xRot = this.leftArm.xRot * 0.5F - 0.31415927F;
                this.leftArm.yRot = 0.0F;
                break;
            }
            case THROW_SPEAR: {
                this.leftArm.xRot = this.leftArm.xRot * 0.5F - (float) Math.PI;
                this.leftArm.yRot = 0.0F;
                break;
            }
            case BOW_AND_ARROW: {
                this.rightArm.yRot = -0.1F + this.head.yRot - 0.4F;
                this.leftArm.yRot = 0.1F + this.head.yRot;
                this.rightArm.xRot = -1.5707964F + this.head.xRot;
                this.leftArm.xRot = -1.5707964F + this.head.xRot;
                break;
            }
            case CROSSBOW_CHARGE: {
                AnimationUtils.animateCrossbowCharge(this.rightArm, this.leftArm, anu, false);
                break;
            }
            case CROSSBOW_HOLD: {
                AnimationUtils.animateCrossbowHold(this.rightArm, this.leftArm, this.head, false);
                break;
            }
            case BRUSH: {
                this.leftArm.xRot = this.leftArm.xRot * 0.5F - 0.62831855F;
                this.leftArm.yRot = 0.0f;
                break;
            }
            case SPYGLASS: {
                this.leftArm.xRot = Mth.clamp(this.head.xRot - 1.9198622F - (anu.isCrouching() ? 0.2617994F : 0.0F), -2.4F, 3.3F);
                this.leftArm.yRot = this.head.yRot + 0.2617994F;
                break;
            }
            case TOOT_HORN: {
                this.leftArm.xRot = Mth.clamp(this.head.xRot, -1.2F, 1.2F) - 1.4835298F;
                this.leftArm.yRot = this.head.yRot + 0.5235988F;
            }
        }
    }

    private void poseBlockingArm(ModelPart modelPart, boolean right) {
        modelPart.xRot = modelPart.xRot * 0.5F - 0.9424779F + Mth.clamp(this.head.xRot, -1.3962634F, 0.43633232F);
        modelPart.yRot = (right ? -30.0f : 30.0F) * ((float) Math.PI / 180) + Mth.clamp(this.head.yRot, -0.5235988F, 0.5235988F);
    }

    protected void setupAttackAnimation(Anu anu, float f) {
        if (this.attackTime <= 0.0F) {
            return;
        }
        HumanoidArm humanoidArm = this.getAttackArm(anu);
        ModelPart modelPart = this.getArm(humanoidArm);
        float g = this.attackTime;
        this.body.yRot = Mth.sin(Mth.sqrt(g) * ((float) Math.PI * 2)) * 0.2F;
        if (humanoidArm == HumanoidArm.LEFT) {
            this.body.yRot *= -1.0f;
        }
        this.rightArm.z = Mth.sin(this.body.yRot) * 5.0F;
        this.rightArm.x = -Mth.cos(this.body.yRot) * 5.0F;
        this.leftArm.z = -Mth.sin(this.body.yRot) * 5.0F;
        this.leftArm.x = Mth.cos(this.body.yRot) * 5.0F;
        this.rightArm.yRot += this.body.yRot;
        this.leftArm.yRot += this.body.yRot;
        this.leftArm.xRot += this.body.yRot;
        g = 1.0F - this.attackTime;
        g *= g;
        g *= g;
        g = 1.0F - g;
        float h = Mth.sin(g * (float) Math.PI);
        float i = Mth.sin(this.attackTime * (float) Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
        modelPart.xRot -= h * 1.2F + i;
        modelPart.yRot += this.body.yRot * 2.0F;
        modelPart.zRot += Mth.sin(this.attackTime * (float) Math.PI) * -0.4F;
    }

    protected float rotlerpRad(float f, float g, float h) {
        float i = (h - g) % ((float) Math.PI * 2);
        if (i < (float) (-Math.PI)) {
            i += (float) Math.PI * 2;
        }
        if (i >= (float) Math.PI) {
            i -= (float) Math.PI * 2;
        }
        return g + f * i;
    }

    private float quadraticArmUpdate(float f) {
        return -65.0F * f + f * f;
    }

    public void setAllVisible(boolean visible) {
        this.head.visible = visible;
        this.body.visible = visible;
        this.rightArm.visible = visible;
        this.leftArm.visible = visible;
        this.rightLeg.visible = visible;
        this.leftLeg.visible = visible;
    }

    @Override
    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
        this.getArm(humanoidArm).translateAndRotate(poseStack);
    }

    protected ModelPart getArm(HumanoidArm humanoidArm) {
        if (humanoidArm == HumanoidArm.LEFT) {
            return this.leftArm;
        }
        return this.rightArm;
    }

    @Override
    public ModelPart getHead() {
        return this.head;
    }

    private HumanoidArm getAttackArm(Anu anu) {
        HumanoidArm humanoidArm = anu.getMainArm();
        return anu.swingingArm == InteractionHand.MAIN_HAND ? humanoidArm : humanoidArm.getOpposite();
    }

    public static enum ArmPose {
        EMPTY(false),
        ITEM(false),
        BLOCK(false),
        BOW_AND_ARROW(true),
        THROW_SPEAR(false),
        CROSSBOW_CHARGE(true),
        CROSSBOW_HOLD(true),
        SPYGLASS(false),
        TOOT_HORN(false),
        BRUSH(false);

        private final boolean twoHanded;

        private ArmPose(boolean bl) {
            this.twoHanded = bl;
        }

        public boolean isTwoHanded() {
            return this.twoHanded;
        }
    }
}
