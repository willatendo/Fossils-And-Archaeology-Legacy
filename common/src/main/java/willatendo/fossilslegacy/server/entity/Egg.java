package willatendo.fossilslegacy.server.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Egg extends Animal implements TicksToBirth, DinopediaInformation {
    private static final EntityDataAccessor<EggVariant> EGG_VARIANT = SynchedEntityData.defineId(Egg.class, FossilsLegacyEntityDataSerializers.EGG_VARIANTS.get());
    private static final EntityDataAccessor<Integer> REMAINING_TIME = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> WARM = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.OPTIONAL_UUID);

    public Egg(EntityType<? extends Egg> egg, Level level) {
        super(egg, level);
    }

    public static AttributeSupplier eggAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0F).build();
    }

    @Override
    protected void dropExperience() {
    }

    @Override
    public void knockback(double xVelc, double yVelc, double zVelc) {
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return this.getEggVariant().loot();
    }

    @Override
    public void die(DamageSource damageSource) {
        this.dropAllDeathLoot(damageSource);
        this.discard();
    }

    @Override
    public ItemStack getPickResult() {
        return this.getEggVariant().pick().get().getDefaultInstance();
    }

    @Override
    public void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        if (offspring instanceof Dinosaur dinosaur) {
            dinosaur.onHatchFromEgg();
        }
    }

    @Override
    public void tick() {
        super.tick();

        this.setWarm(this.getEggVariant().shouldIncubate(this));

        if (this.getRemainingTime() < -500) {
            Player player = this.level().getNearestPlayer(this, 25.0D);
            if (player != null) {
                if (this.getEggVariant().wet()) {
                    player.sendSystemMessage(FossilsLegacyUtils.translation("entity", "egg.died.dry"));
                } else {
                    player.sendSystemMessage(FossilsLegacyUtils.translation("entity", "egg.died"));
                }
                this.discard();
            }
        }

        if (!this.isWarm()) {
            this.setRemainingTime(this.getRemainingTime() - 1);
        }

        if (this.getEggVariant().shouldIncubate(this)) {
            this.birthTick(this, this.level(), this.getOwnerUUID() != null ? Optional.of(this.getOwnerUUID()) : Optional.empty());
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EGG_VARIANT, FossilsLegacyBuiltInRegistries.EGG_VARIANTS.getOrThrow(FossilsLegacyEggVariants.TRICERATOPS.getKey()));
        this.entityData.define(REMAINING_TIME, 0);
        this.entityData.define(WARM, false);
        this.entityData.define(OWNER, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);

        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        compoundTag.putString("Variant", FossilsLegacyBuiltInRegistries.EGG_VARIANTS.getKey(this.getEggVariant()).toString());
        compoundTag.putInt("RemainingTime", this.getRemainingTime());
        compoundTag.putBoolean("Warm", this.isWarm());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);

        UUID uuid;
        if (compoundTag.hasUUID("Owner")) {
            uuid = compoundTag.getUUID("Owner");
        } else {
            String s = compoundTag.getString("Owner");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                this.setOwnerUUID(uuid);
            } catch (Throwable throwable) {
            }
        }

        EggVariant eggVariant = FossilsLegacyBuiltInRegistries.EGG_VARIANTS.get(ResourceLocation.tryParse(compoundTag.getString("Variant")));
        if (eggVariant != null) {
            this.setEggVariant(eggVariant);
        }
        this.setRemainingTime(compoundTag.getInt("RemainingTime"));
        this.setWarm(compoundTag.getBoolean("Warm"));
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getEggVariant().entityType().get().create(level);
    }

    @Override
    public int getRemainingTime() {
        return this.entityData.get(REMAINING_TIME);
    }

    @Override
    public void setRemainingTime(int remainingPregnancyTime) {
        this.entityData.set(REMAINING_TIME, remainingPregnancyTime);
    }

    public boolean isWarm() {
        return this.entityData.get(WARM);
    }

    public void setWarm(boolean warm) {
        this.entityData.set(WARM, warm);
    }

    public EggVariant getEggVariant() {
        return this.entityData.get(EGG_VARIANT);
    }

    public void setEggVariant(EggVariant eggVariant) {
        this.entityData.set(EGG_VARIANT, eggVariant);
    }

    public boolean isOwnedBy(LivingEntity livingEntity) {
        return livingEntity == this.getOwner();
    }

    public LivingEntity getOwner() {
        try {
            UUID uuid = this.getOwnerUUID();
            return uuid == null ? null : this.level().getPlayerByUUID(uuid);
        } catch (IllegalArgumentException illegalargumentexception) {
            return null;
        }
    }

    public UUID getOwnerUUID() {
        return this.entityData.get(OWNER).orElse((UUID) null);
    }

    public void setOwnerUUID(UUID uuid) {
        this.entityData.set(OWNER, Optional.ofNullable(uuid));
    }

    @Override
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        information.add(FossilsLegacyUtils.translation("dinopedia", "egg", this.getEggVariant().entityType().get().getDescription().getString()));
        information.add(FossilsLegacyUtils.translation("dinopedia", "remaining_time", (int) Math.floor((((float) this.getRemainingTime()) / this.maxTime()) * 100) + "%"));
        information.add(FossilsLegacyUtils.translation("dinopedia", "status", this.getEggVariant().getTemperature(this)));
        return information;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
