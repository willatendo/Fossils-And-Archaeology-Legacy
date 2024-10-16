package willatendo.fossilslegacy.server.entity;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class Fossil extends Mob {
    private static final EntityDataAccessor<Holder<FossilVariant>> FOSSIL_VARIANT = SynchedEntityData.defineId(Fossil.class, FossilsLegacyEntityDataSerializers.FOSSIL_VARIANTS.get());
    private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(Fossil.class, EntityDataSerializers.INT);
    private static MapCodec<Holder<FossilVariant>> VARIANT_MAP_CODEC = FossilVariant.CODEC.fieldOf("FossilVariant");
    private static Codec<Holder<FossilVariant>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

    public Fossil(EntityType<? extends Fossil> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier fossilAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D).build();
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    @Override
    public float getScale() {
        FossilVariant fossilVariant = this.getFossilVariant().value();
        return fossilVariant.baseScale() + (fossilVariant.sizeScale() * this.getSize());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    public void refreshDimensions() {
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        super.refreshDimensions();
        this.setPos(x, y, z);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        if (SIZE.equals(entityDataAccessor)) {
            this.refreshDimensions();
        }

        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(FossilsLegacyItems.FOSSIL.get());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FOSSIL_VARIANT, this.registryAccess().registryOrThrow(FossilsLegacyRegistries.FOSSIL_VARIANTS).getAny().orElseThrow());
        builder.define(SIZE, 1);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getFossilVariant()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
        compoundTag.putInt("Size", this.getSize());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setFossilVariant);
        this.setSize(compoundTag.getInt("Size"));
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.BONE)) {
            if (this.getSize() < this.getFossilVariant().value().maxSize()) {
                this.setSize(this.getSize() + 1);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        if (itemStack.isEmpty()) {
            if (this.getSize() >= 1) {
                this.setSize(this.getSize() - 1);
                if (!player.isCreative()) {
                    player.addItem(new ItemStack(Items.BONE));
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.interactAt(player, vec3, interactionHand);
    }

    public void setFossilVariant(Holder<FossilVariant> fossilVariant) {
        this.entityData.set(FOSSIL_VARIANT, fossilVariant);
    }

    public Holder<FossilVariant> getFossilVariant() {
        return this.entityData.get(FOSSIL_VARIANT);
    }

    public void setSize(int size) {
        this.entityData.set(SIZE, size);
    }

    public int getSize() {
        return this.entityData.get(SIZE);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage) {
        if (this.getSize() > 0) {
            for (int i = 0; i < this.getSize(); i++) {
                Block.popResource(this.level(), this.blockPosition(), new ItemStack(Items.BONE));
            }
        }
        Block.popResource(this.level(), this.blockPosition(), new ItemStack(FossilsLegacyItems.FOSSIL.get()));
        this.remove(RemovalReason.KILLED);
        return true;
    }
}
