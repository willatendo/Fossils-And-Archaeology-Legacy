package willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.item.FAItems;

public class Nautilus extends WaterAnimal {
    public float xBodyRot;
    public float xBodyRotO;
    public float zBodyRot;
    public float zBodyRotO;
    public float tentacleMovement;
    public float oldTentacleMovement;
    public float tentacleAngle;
    public float oldTentacleAngle;
    private float speed;
    private float tentacleSpeed;
    private float rotateSpeed;
    private float tx;
    private float ty;
    private float tz;

    public Nautilus(EntityType<? extends Nautilus> entityType, Level level) {
        super(entityType, level);
        this.random.setSeed(this.getId());
        this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }

    public static AttributeSupplier nautilusAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).build();
    }

    public static boolean checkNautilusSpawnRules(EntityType<Nautilus> entityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
        return blockPos.getY() >= (serverLevelAccessor.getSeaLevel() - 13) && blockPos.getY() <= serverLevelAccessor.getSeaLevel() && serverLevelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && serverLevelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.isEmpty()) {
            player.addItem(new ItemStack(FAItems.NAUTILUS.get()));
            this.discard();
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.interactAt(player, vec3, interactionHand);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Nautilus.NautilusRandomMovementGoal(this));
        this.goalSelector.addGoal(1, new Nautilus.NautilusFleeGoal());
    }

    @Override
    public boolean canBeLeashed() {
        return !this.isLeashed();
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.xBodyRotO = this.xBodyRot;
        this.zBodyRotO = this.zBodyRot;
        this.oldTentacleMovement = this.tentacleMovement;
        this.oldTentacleAngle = this.tentacleAngle;
        this.tentacleMovement += this.tentacleSpeed;
        if ((double) this.tentacleMovement > (Math.PI * 2D)) {
            if (this.level().isClientSide) {
                this.tentacleMovement = ((float) Math.PI * 2F);
            } else {
                this.tentacleMovement -= ((float) Math.PI * 2F);
                if (this.random.nextInt(10) == 0) {
                    this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
                }

                this.level().broadcastEntityEvent(this, (byte) 19);
            }
        }

        if (this.isInWaterOrBubble()) {
            if (this.tentacleMovement < (float) Math.PI) {
                float movement = this.tentacleMovement / (float) Math.PI;
                this.tentacleAngle = Mth.sin(movement * movement * (float) Math.PI) * (float) Math.PI * 0.25F;
                if ((double) movement > 0.75D) {
                    this.speed = 1.0F;
                    this.rotateSpeed = 1.0F;
                } else {
                    this.rotateSpeed *= 0.8F;
                }
            } else {
                this.tentacleAngle = 0.0F;
                this.speed *= 0.9F;
                this.rotateSpeed *= 0.99F;
            }

            if (!this.level().isClientSide) {
                this.setDeltaMovement((double) (this.tx * this.speed), (double) (this.ty * this.speed), (double) (this.tz * this.speed));
            }

            Vec3 vec3 = this.getDeltaMovement();
            double horizontalDistance = vec3.horizontalDistance();
            this.yBodyRot += (-((float) Mth.atan2(vec3.x, vec3.z)) * (180F / (float) Math.PI) - this.yBodyRot) * 0.1F;
            this.setYRot(this.yBodyRot);
            this.zBodyRot += (float) Math.PI * this.rotateSpeed * 1.5F;
            this.xBodyRot += (-((float) Mth.atan2(horizontalDistance, vec3.y)) * (180F / (float) Math.PI) - this.xBodyRot) * 0.1F;
        } else {
            this.tentacleAngle = Mth.abs(Mth.sin(this.tentacleMovement)) * (float) Math.PI * 0.25F;
            if (!this.level().isClientSide) {
                double yVec = this.getDeltaMovement().y;
                if (this.hasEffect(MobEffects.LEVITATION)) {
                    yVec = 0.05D * (double) (this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1);
                } else if (!this.isNoGravity()) {
                    yVec -= 0.08D;
                }

                this.setDeltaMovement(0.0D, yVec * (double) 0.98F, 0.0D);
            }

            this.xBodyRot += (-90.0F - this.xBodyRot) * 0.02F;
        }
    }

    @Override
    public void travel(Vec3 vec3) {
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    public void setMovementVector(float xVec, float yVec, float zVec) {
        this.tx = xVec;
        this.ty = yVec;
        this.tz = zVec;
    }

    public boolean hasMovementVector() {
        return this.tx != 0.0F || this.ty != 0.0F || this.tz != 0.0F;
    }

    class NautilusFleeGoal extends Goal {
        private int fleeTicks;

        @Override
        public boolean canUse() {
            LivingEntity lastHurtEntity = Nautilus.this.getLastHurtByMob();
            if (Nautilus.this.isInWater() && lastHurtEntity != null) {
                return Nautilus.this.distanceToSqr(lastHurtEntity) < 100.0D;
            } else {
                return false;
            }
        }

        @Override
        public void start() {
            this.fleeTicks = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            ++this.fleeTicks;
            LivingEntity lastHurtEntity = Nautilus.this.getLastHurtByMob();
            if (lastHurtEntity != null) {
                Vec3 vec3 = new Vec3(Nautilus.this.getX() - lastHurtEntity.getX(), Nautilus.this.getY() - lastHurtEntity.getY(), Nautilus.this.getZ() - lastHurtEntity.getZ());
                BlockState blockState = Nautilus.this.level().getBlockState(BlockPos.containing(Nautilus.this.getX() + vec3.x, Nautilus.this.getY() + vec3.y, Nautilus.this.getZ() + vec3.z));
                FluidState fluidState = Nautilus.this.level().getFluidState(BlockPos.containing(Nautilus.this.getX() + vec3.x, Nautilus.this.getY() + vec3.y, Nautilus.this.getZ() + vec3.z));
                if (fluidState.is(FluidTags.WATER) || blockState.isAir()) {
                    double size = vec3.length();
                    if (size > 0.0D) {
                        vec3.normalize();
                        double scale = 3.0D;
                        if (size > 5.0D) {
                            scale -= (size - 5.0D) / 5.0D;
                        }

                        if (scale > 0.0D) {
                            vec3 = vec3.scale(scale);
                        }
                    }

                    if (blockState.isAir()) {
                        vec3 = vec3.subtract(0.0D, vec3.y, 0.0D);
                    }

                    Nautilus.this.setMovementVector((float) vec3.x / 20.0F, (float) vec3.y / 20.0F, (float) vec3.z / 20.0F);
                }

                if (this.fleeTicks % 10 == 5) {
                    Nautilus.this.level().addParticle(ParticleTypes.BUBBLE, Nautilus.this.getX(), Nautilus.this.getY(), Nautilus.this.getZ(), 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    class NautilusRandomMovementGoal extends Goal {
        private final Nautilus nautilus;

        public NautilusRandomMovementGoal(Nautilus nautilus) {
            this.nautilus = nautilus;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            int noActionTime = this.nautilus.getNoActionTime();
            if (noActionTime > 100) {
                this.nautilus.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if (this.nautilus.getRandom().nextInt(reducedTickDelay(50)) == 0 || !this.nautilus.wasTouchingWater || !this.nautilus.hasMovementVector()) {
                float rotation = this.nautilus.getRandom().nextFloat() * ((float) Math.PI * 2F);
                float xVec = Mth.cos(rotation) * 0.2F;
                float yVec = -0.1F + this.nautilus.getRandom().nextFloat() * 0.2F;
                float zVec = Mth.sin(rotation) * 0.2F;
                this.nautilus.setMovementVector(xVec, yVec, zVec);
            }
        }
    }
}
