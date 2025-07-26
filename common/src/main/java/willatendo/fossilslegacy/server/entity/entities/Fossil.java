package willatendo.fossilslegacy.server.entity.entities;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.network.NetworkUtils;
import willatendo.fossilslegacy.network.clientbound.ClientboundOpenFossilScreenPacket;
import willatendo.fossilslegacy.server.criteria.FACriteriaTriggers;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAItemTags;

public class Fossil extends Mob {
    private static final EntityDataAccessor<Holder<FossilVariant>> FOSSIL_VARIANT = SynchedEntityData.defineId(Fossil.class, FAEntityDataSerializers.FOSSIL_VARIANTS.get());
    private static final EntityDataAccessor<FossilRotations> FOSSIL_ROTATIONS = SynchedEntityData.defineId(Fossil.class, FAEntityDataSerializers.FOSSIL_ROTATIONS.get());
    private static final EntityDataAccessor<FossilPositions> FOSSIL_POSITIONS = SynchedEntityData.defineId(Fossil.class, FAEntityDataSerializers.FOSSIL_POSITIONS.get());
    private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(Fossil.class, EntityDataSerializers.INT);
    private static Codec<Holder<FossilVariant>> VARIANT_CODEC = FossilVariant.VARIANT_MAP_CODEC.codec();

    public Fossil(EntityType<? extends Fossil> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier fossilAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D).build();
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        FossilVariant fossilVariant = this.getFossilVariant().value();
        return this.dimensions = EntityDimensions.scalable(fossilVariant.boundingBoxWidth() + (fossilVariant.boundingBoxGrowth() * this.getSize()), fossilVariant.boundingBoxHeight() + (fossilVariant.boundingBoxGrowth() * this.getSize()));
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    public float renderScaleWidth() {
        FossilVariant fossilVariant = this.getFossilVariant().value();
        return fossilVariant.baseScaleWidth() + (fossilVariant.sizeScale() * (float) this.getSize());
    }

    public float renderScaleHeight() {
        FossilVariant fossilVariant = this.getFossilVariant().value();
        return fossilVariant.baseScaleHeight() + (fossilVariant.sizeScale() * (float) this.getSize());
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

    public EntityDimensions getEntityDimensions(int size) {
        FossilVariant fossilVariant = this.getFossilVariant().value();
        return EntityDimensions.scalable(fossilVariant.boundingBoxWidth() + (fossilVariant.boundingBoxGrowth() * size), fossilVariant.boundingBoxHeight() + (fossilVariant.boundingBoxGrowth() * size));
    }


    @Override
    public boolean isBaby() {
        return this.getSize() < this.getFossilVariant().value().maxSize() / 2;
    }

    @Override
    public void tick() {
        if (!this.isNoAi()) {
            if (this.dimensions.width() != this.getEntityDimensions(this.getSize()).width() || this.dimensions.height() != this.getEntityDimensions(this.getSize()).height()) {
                this.refreshDimensions();
            }
        }
        super.tick();
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
        ItemStack itemStack = new ItemStack(FAItems.ARTICULATED_FOSSIL.get());
        itemStack.set(FADataComponents.FOSSIL_VARIANT.get(), this.getFossilVariant());
        return itemStack;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FOSSIL_VARIANT, this.registryAccess().lookupOrThrow(FARegistries.FOSSIL_VARIANTS).getAny().orElseThrow());
        builder.define(FOSSIL_ROTATIONS, new FossilRotations());
        builder.define(FOSSIL_POSITIONS, new FossilPositions());
        builder.define(SIZE, 1);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getFossilVariant()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
        compoundTag.putInt("Size", this.getSize());
        CompoundTag partRotations = new CompoundTag();
        this.getFossilRotations().addAdditionalSaveData(partRotations);
        compoundTag.put("part_rotations", partRotations);
        CompoundTag partPositions = new CompoundTag();
        this.getFossilPositions().addAdditionalSaveData(partPositions);
        compoundTag.put("part_positions", partPositions);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setFossilVariant);
        this.setSize(compoundTag.getInt("Size"));
        this.setFossilRotations(FossilRotations.readAdditionalSaveData(compoundTag.getCompound("part_rotations")));
        this.setFossilPositions(FossilPositions.readAdditionalSaveData(compoundTag.getCompound("part_positions")));
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getMainHandItem();
        if (itemStack.is(Items.BONE)) {
            if (this.getSize() < this.getFossilVariant().value().maxSize()) {
                this.setSize(this.getSize() + 1);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        } else if (itemStack.is(FAItemTags.HAMMERS)) {
            if (player instanceof ServerPlayer serverPlayer) {
                FACriteriaTriggers.ARTICULATE_FOSSIL.get().trigger(serverPlayer);
                NetworkUtils.sendToClient(serverPlayer, new ClientboundOpenFossilScreenPacket(this.getId(), this.getFossilRotations(), this.getFossilPositions(), this.level().registryAccess().lookupOrThrow(FARegistries.FOSSIL_VARIANTS).getKey(this.getFossilVariant().value()).toString()));
            }
            return InteractionResult.SUCCESS;
        } else if (itemStack.isEmpty()) {
            if (this.getSize() >= 1) {
                this.setSize(this.getSize() - 1);
                if (!player.isCreative()) {
                    player.addItem(new ItemStack(Items.BONE));
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public void setFossilVariant(Holder<FossilVariant> fossilVariant) {
        this.entityData.set(FOSSIL_VARIANT, fossilVariant);
    }

    public Holder<FossilVariant> getFossilVariant() {
        return this.entityData.get(FOSSIL_VARIANT);
    }

    public void setFossilRotations(FossilRotations fossilVariant) {
        this.entityData.set(FOSSIL_ROTATIONS, fossilVariant);
    }

    public FossilRotations getFossilRotations() {
        return this.entityData.get(FOSSIL_ROTATIONS);
    }

    public void setFossilPositions(FossilPositions fossilVariant) {
        this.entityData.set(FOSSIL_POSITIONS, fossilVariant);
    }

    public FossilPositions getFossilPositions() {
        return this.entityData.get(FOSSIL_POSITIONS);
    }

    public void setSize(int size) {
        this.entityData.set(SIZE, size);
        this.refreshDimensions();
    }

    public int getSize() {
        return this.entityData.get(SIZE);
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float damage) {
        if (!damageSource.isCreativePlayer()) {
            if (this.getSize() > 0) {
                for (int i = 0; i < this.getSize(); i++) {
                    Block.popResource(this.level(), this.blockPosition(), new ItemStack(Items.BONE));
                }
            }
            ItemStack articulatedFossil = new ItemStack(FAItems.ARTICULATED_FOSSIL.get());
            articulatedFossil.set(FADataComponents.FOSSIL_VARIANT.get(), this.getFossilVariant());
            Block.popResource(this.level(), this.blockPosition(), articulatedFossil);
        }
        this.remove(RemovalReason.KILLED);
        return true;
    }
}
