package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Optional;
import java.util.UUID;

public class AncientLightningBolt extends LightningBolt implements OwnableEntity {
    protected static final EntityDataAccessor<Byte> FLAGS = SynchedEntityData.defineId(AncientLightningBolt.class, EntityDataSerializers.BYTE);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.defineId(AncientLightningBolt.class, EntityDataSerializers.OPTIONAL_UUID);

    public AncientLightningBolt(EntityType<? extends AncientLightningBolt> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FLAGS, (byte) 0);
        builder.define(OWNER_UUID, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }
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
    }

    @Override
    public UUID getOwnerUUID() {
        return this.entityData.get(OWNER_UUID).orElse((UUID) null);
    }

    public void setOwnerUUID(UUID uuid) {
        this.entityData.set(OWNER_UUID, Optional.ofNullable(uuid));
    }

    public void tame(Player player) {
        this.setTame(true);
        this.setOwnerUUID(player.getUUID());
    }

    public boolean isOwnedBy(LivingEntity livingEntity) {
        return livingEntity == this.getOwner();
    }

    public boolean isTame() {
        return (this.entityData.get(FLAGS) & 4) != 0;
    }

    public void setTame(boolean tame) {
        byte b0 = this.entityData.get(FLAGS);
        if (tame) {
            this.entityData.set(FLAGS, (byte) (b0 | 4));
        } else {
            this.entityData.set(FLAGS, (byte) (b0 & -5));
        }
    }

    @Override
    public boolean isAlliedTo(Entity entity) {
        if (this.isTame()) {
            LivingEntity owner = this.getOwner();
            if (entity == owner) {
                return true;
            }

            if (owner != null) {
                return owner.isAlliedTo(entity);
            }
        }

        return super.isAlliedTo(entity);
    }
}
