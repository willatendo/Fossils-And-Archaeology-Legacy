package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.tags.FAEntityTypeTags;
import willatendo.fossilslegacy.server.tags.FAModelTypeTags;

import java.util.Optional;

public class Mosasaurus extends Dinosaur implements DinopediaInformation {
    public Mosasaurus(EntityType<? extends Mosasaurus> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    public static AttributeSupplier mosasaurusAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 7.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    public static boolean checkMosasaurusSpawnRules(EntityType<Mosasaurus> entityType, ServerLevelAccessor serverLevelAccessor, EntitySpawnReason entitySpawnReason, BlockPos blockPos, RandomSource randomSource) {
        return blockPos.getY() >= (serverLevelAccessor.getSeaLevel() - 13) && blockPos.getY() <= serverLevelAccessor.getSeaLevel() && serverLevelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && serverLevelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER);
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.MOSASAURUS_EGG.get();
    }

    @Override
    public int getMaxHunger() {
        return 500;
    }

    @Override
    public TagKey<ModelType> getModelTypes() {
        return FAModelTypeTags.MOSASAURUS;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    public double getMinHealth() {
        return 7.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.piscivore(this.level());
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new MosasaurusPathNavigation(this, level);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(5, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new DinoNearestAttackableTargetGoal<>(this, FAEntityTypeTags.MOSASAURUS_VICTIMS, true));
    }

    @Override
    public void travel(Vec3 vec3) {
        if (this.isControlledByLocalInstance() && this.isInWater()) {
            this.moveRelative(0.1F, vec3);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(vec3);
        }
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.MOSASAURUS);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.none();
    }

    public static class MosasaurusPathNavigation extends AmphibiousPathNavigation {
        public MosasaurusPathNavigation(Mob mob, Level level) {
            super(mob, level);
        }

        @Override
        public boolean isStableDestination(BlockPos blockPos) {
            return this.level.getBlockState(blockPos).is(Blocks.WATER);
        }
    }
}
