package willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.item.NameTagItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.goals.*;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.HighlyIntelligent;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.items.DebugItem;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FACoatTypeTags;
import willatendo.fossilslegacy.server.tags.FAEntityTypeTags;

import java.util.Optional;

public class Velociraptor extends Dinosaur implements DinopediaInformation, HighlyIntelligent {
    private static final EntityDataAccessor<Boolean> LEARNED_CHESTS = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<ItemStack> HELD_ITEM = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.ITEM_STACK);

    public Velociraptor(EntityType<? extends Velociraptor> entityType, Level level) {
        super(entityType, level);
        ((GroundPathNavigation) this.navigation).setCanOpenDoors(true);
    }

    public static AttributeSupplier velociraptorAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    @Override
    public EntityType<Egg> getEggEntityType() {
        return FAEntityTypes.VELOCIRAPTOR_EGG.get();
    }

    @Override
    public float maxUpStep() {
        return 1.0F;
    }

    @Override
    public int getMaxHunger() {
        return 100;
    }

    @Override
    public TagKey<CoatType> getCoatTypes() {
        return FACoatTypeTags.VELOCIRAPTOR;
    }

    @Override
    public int getMaxGrowthStage() {
        return 8;
    }

    @Override
    public double getMinHealth() {
        return 5.0F;
    }

    @Override
    public Diet getDiet() {
        return Diet.carnivore(this.level());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new DinoTemptGoal(this, 1.1D, false));
        this.goalSelector.addGoal(3, new DinoBabyFollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
        this.goalSelector.addGoal(6, new OpenDoorGoal(this, false) {
            @Override
            public void stop() {
            }
        });
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FAEntityTypeTags.VELOCIRAPTOR_VICTIMS, true));
    }

    @Override
    public InteractionResult additionalInteractions(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!itemStack.isEmpty() && this.getHeldItem() == ItemStack.EMPTY && !itemStack.is(FAItems.DINOPEDIA.get()) && !(itemStack.getItem() instanceof DebugItem) && !(itemStack.getItem() instanceof NameTagItem) && !(itemStack.getItem() instanceof LeadItem) && !this.isFood(itemStack)) {
            this.setHeldItem(new ItemStack(itemStack.getItem()));
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            return InteractionResult.CONSUME;
        } else {
            if (itemStack.isEmpty() && this.getHeldItem() != ItemStack.EMPTY) {
                player.setItemInHand(interactionHand, this.getHeldItem());
                this.setHeldItem(ItemStack.EMPTY);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LEARNED_CHESTS, false);
        builder.define(HELD_ITEM, ItemStack.EMPTY);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTame() ? this.getOverridenSoundEvent(FASoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT) : this.getOverridenSoundEvent(FASoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FASoundEvents.VELOCIRAPTOR_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FASoundEvents.VELOCIRAPTOR_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH);
    }

    @Override
    public void setLearnedChests(boolean learnedChests) {
        this.entityData.set(LEARNED_CHESTS, learnedChests);
    }

    @Override
    public boolean hasLearnedChests() {
        return this.entityData.get(LEARNED_CHESTS);
    }

    public void setHeldItem(ItemStack itemStack) {
        this.entityData.set(HELD_ITEM, itemStack);
    }

    public ItemStack getHeldItem() {
        return this.entityData.get(HELD_ITEM);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        this.addCoatType(compoundTag);
        compoundTag.putBoolean("LearnedChests", this.hasLearnedChests());
        if (!this.getHeldItem().isEmpty()) {
            compoundTag.put("HeldItem", this.getHeldItem().saveOptional(this.registryAccess()));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readCoatType(compoundTag);
        this.setLearnedChests(compoundTag.getBoolean("LearnedChests"));
        CompoundTag itemCompoundTag = compoundTag.getCompound("HeldItem");
        if (itemCompoundTag != null && !itemCompoundTag.isEmpty()) {
            this.setHeldItem(ItemStack.parseOptional(this.registryAccess(), itemCompoundTag));
        }
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.VELOCIRAPTOR);
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }


    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float damage) {
        if (this.isTame()) {
            if (damageSource.getEntity() instanceof Player player) {
                if (this.isOwnedBy(player)) {
                    this.sendMessageToOwnerOrElseAll(DinoSituation.HURT_ESCAPE);
                    this.setOwnerUUID(null);
                }
            }
        }
        return super.hurtServer(serverLevel, damageSource, damage);
    }
}
