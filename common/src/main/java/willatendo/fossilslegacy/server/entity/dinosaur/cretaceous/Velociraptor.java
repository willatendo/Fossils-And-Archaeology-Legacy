package willatendo.fossilslegacy.server.entity.dinosaur.cretaceous;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.item.NameTagItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants;
import willatendo.fossilslegacy.server.entity.goal.*;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.interfaces.*;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.item.DebugItem;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.tags.FossilsLegacyEntityTypeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Velociraptor extends Dinosaur implements DinopediaInformation, HighlyIntelligent, CoatTypeEntity {
    private static final EntityDataAccessor<Boolean> LEARNED_CHESTS = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<ItemStack> HELD_ITEM = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.ITEM_STACK);

    public Velociraptor(EntityType<? extends Velociraptor> entityType, Level level) {
        super(entityType, level);
        ((GroundPathNavigation) this.navigation).setCanOpenDoors(true);
    }

    public static AttributeSupplier velociraptorAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D).build();
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
        return FossilsLegacyCoatTypeTags.VELOCIRAPTOR;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.VELOCIRAPTOR;
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
        this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, FossilsLegacyEntityTypeTags.VELOCIRAPTOR_VICTIMS, true));
    }

    @Override
    public InteractionResult additionalInteractions(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!itemStack.isEmpty() && this.getHeldItem() == ItemStack.EMPTY && !itemStack.is(FossilsLegacyItems.DINOPEDIA.get()) && !(itemStack.getItem() instanceof DebugItem) && !(itemStack.getItem() instanceof NameTagItem) && !(itemStack.getItem() instanceof LeadItem) && !this.isFood(itemStack)) {
            this.setHeldItem(new ItemStack(itemStack.getItem()));
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            return InteractionResult.CONSUME;
        } else {
            if (itemStack.isEmpty() && this.getHeldItem() != ItemStack.EMPTY) {
                player.setItemInHand(interactionHand, this.getHeldItem());
                this.setHeldItem(ItemStack.EMPTY);
                return InteractionResult.sidedSuccess(player.level().isClientSide());
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
        return this.isTame() ? this.getOverridenSoundEvent(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT) : this.getOverridenSoundEvent(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get(), CoatType.OverrideInfo.OverridenSoundType.AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.VELOCIRAPTOR_HURT.get(), CoatType.OverrideInfo.OverridenSoundType.HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.getOverridenSoundEvent(FossilsLegacySoundEvents.VELOCIRAPTOR_DEATH.get(), CoatType.OverrideInfo.OverridenSoundType.DEATH);
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
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        if (this.isTame() && this.isOwnedBy(player)) {
            information.add(this.getDisplayName());
            information.add(FossilsLegacyUtils.translation("dinopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "age", this.getDaysAlive()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "hunger", this.getHunger(), this.getMaxHunger()));
        } else {
            information.add(this.getDisplayName());
            if (this.isTame()) {
                information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
            } else {
                information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
            }
        }
        return information;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.hand();
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage) {
        if (this.isTame()) {
            if (damageSource.getEntity() instanceof Player player) {
                if (this.isOwnedBy(player)) {
                    this.sendMessageToOwnerOrElseAll(DinoSituation.HURT_ESCAPE);
                    this.setOwnerUUID(null);
                }
            }
        }
        return super.hurt(damageSource, damage);
    }
}
