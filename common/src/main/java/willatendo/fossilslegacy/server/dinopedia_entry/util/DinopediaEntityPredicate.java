package willatendo.fossilslegacy.server.dinopedia_entry.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.*;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Team;

import java.util.Optional;

public record DinopediaEntityPredicate(boolean always, Optional<EntityTypePredicate> entityType, Optional<DistancePredicate> distanceToPlayer, Optional<MovementPredicate> movement, Optional<MobEffectsPredicate> effects, Optional<NbtPredicate> nbt, Optional<EntityFlagsPredicate> flags, Optional<EntityEquipmentPredicate> equipment, Optional<Integer> periodicTick, Optional<DinopediaEntityPredicate> vehicle, Optional<DinopediaEntityPredicate> passenger, Optional<DinopediaEntityPredicate> targetedEntity, Optional<String> team, Optional<SlotsPredicate> slots) {
    public static final Codec<DinopediaEntityPredicate> CODEC = Codec.recursive("DinopediaPredicate", dinopediaPredicate -> RecordCodecBuilder.create(instance -> instance.group(Codec.BOOL.optionalFieldOf("always", false).forGetter(DinopediaEntityPredicate::always), EntityTypePredicate.CODEC.optionalFieldOf("type").forGetter(DinopediaEntityPredicate::entityType), DistancePredicate.CODEC.optionalFieldOf("distance").forGetter(DinopediaEntityPredicate::distanceToPlayer), MovementPredicate.CODEC.optionalFieldOf("movement").forGetter(DinopediaEntityPredicate::movement), MobEffectsPredicate.CODEC.optionalFieldOf("effects").forGetter(DinopediaEntityPredicate::effects), NbtPredicate.CODEC.optionalFieldOf("nbt").forGetter(DinopediaEntityPredicate::nbt), EntityFlagsPredicate.CODEC.optionalFieldOf("flags").forGetter(DinopediaEntityPredicate::flags), EntityEquipmentPredicate.CODEC.optionalFieldOf("equipment").forGetter(DinopediaEntityPredicate::equipment), ExtraCodecs.POSITIVE_INT.optionalFieldOf("periodic_tick").forGetter(DinopediaEntityPredicate::periodicTick), dinopediaPredicate.optionalFieldOf("vehicle").forGetter(DinopediaEntityPredicate::vehicle), dinopediaPredicate.optionalFieldOf("passenger").forGetter(DinopediaEntityPredicate::passenger), dinopediaPredicate.optionalFieldOf("targeted_entity").forGetter(DinopediaEntityPredicate::targetedEntity), Codec.STRING.optionalFieldOf("team").forGetter(DinopediaEntityPredicate::team), SlotsPredicate.CODEC.optionalFieldOf("slots").forGetter(DinopediaEntityPredicate::slots)).apply(instance, DinopediaEntityPredicate::new)));

    public boolean matches(Player player, Entity entity) {
        return this.matches(player.level(), player.position(), entity);
    }

    public boolean matches(Level level, Vec3 position, Entity entity) {
        if (this.always) {
            return true;
        }
        if (entity == null) {
            return false;
        } else if (this.entityType.isPresent() && !this.entityType.get().matches(entity.getType())) {
            return false;
        } else {
            if (position == null) {
                if (this.distanceToPlayer.isPresent()) {
                    return false;
                }
            } else if (this.distanceToPlayer.isPresent() && !this.distanceToPlayer.get().matches(position.x, position.y, position.z, entity.getX(), entity.getY(), entity.getZ())) {
                return false;
            }

            Vec3 vec33;
            if (this.movement.isPresent()) {
                vec33 = entity.getKnownMovement();
                Vec3 vec31 = vec33.scale(20.0);
                if (!this.movement.get().matches(vec31.x, vec31.y, vec31.z, entity.fallDistance)) {
                    return false;
                }
            }


            if (this.effects.isPresent() && !this.effects.get().matches(entity)) {
                return false;
            } else if (this.flags.isPresent() && !this.flags.get().matches(entity)) {
                return false;
            } else if (this.equipment.isPresent() && !this.equipment.get().matches(entity)) {
                return false;
            } else if (this.vehicle.isPresent() && !this.vehicle.get().matches(level, position, entity.getVehicle())) {
                return false;
            } else if (this.passenger.isPresent() && entity.getPassengers().stream().noneMatch(entityIn -> this.passenger.get().matches(level, position, entityIn))) {
                return false;
            } else if (this.targetedEntity.isPresent() && !this.targetedEntity.get().matches(level, position, entity instanceof Mob ? ((Mob) entity).getTarget() : null)) {
                return false;
            } else if (this.periodicTick.isPresent() && entity.tickCount % (Integer) this.periodicTick.get() != 0) {
                return false;
            } else {
                if (this.team.isPresent()) {
                    Team team = entity.getTeam();
                    if (team == null || !((String) this.team.get()).equals(team.getName())) {
                        return false;
                    }
                }

                return (this.slots.isEmpty() || this.slots.get().matches(entity)) && (this.nbt.isEmpty() || this.nbt.get().matches(entity));
            }
        }
    }

    public static class Builder {
        private Optional<EntityTypePredicate> entityType = Optional.empty();
        private Optional<DistancePredicate> distanceToPlayer = Optional.empty();
        private Optional<MovementPredicate> movement = Optional.empty();
        private Optional<MobEffectsPredicate> effects = Optional.empty();
        private Optional<NbtPredicate> nbt = Optional.empty();
        private Optional<EntityFlagsPredicate> flags = Optional.empty();
        private Optional<EntityEquipmentPredicate> equipment = Optional.empty();
        private Optional<Integer> periodicTick = Optional.empty();
        private Optional<DinopediaEntityPredicate> vehicle = Optional.empty();
        private Optional<DinopediaEntityPredicate> passenger = Optional.empty();
        private Optional<DinopediaEntityPredicate> targetedEntity = Optional.empty();
        private Optional<String> team = Optional.empty();
        private Optional<SlotsPredicate> slots = Optional.empty();

        private Builder() {
        }

        public static DinopediaEntityPredicate always() {
            return new DinopediaEntityPredicate(true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
        }

        public static DinopediaEntityPredicate.Builder entity() {
            return new DinopediaEntityPredicate.Builder();
        }

        public DinopediaEntityPredicate.Builder of(EntityType<?> entityType) {
            this.entityType = Optional.of(EntityTypePredicate.of(entityType));
            return this;
        }

        public DinopediaEntityPredicate.Builder of(TagKey<EntityType<?>> entityTypeTag) {
            this.entityType = Optional.of(EntityTypePredicate.of(entityTypeTag));
            return this;
        }

        public DinopediaEntityPredicate.Builder entityType(EntityTypePredicate entityType) {
            this.entityType = Optional.of(entityType);
            return this;
        }

        public DinopediaEntityPredicate.Builder distance(DistancePredicate distanceToPlayer) {
            this.distanceToPlayer = Optional.of(distanceToPlayer);
            return this;
        }

        public DinopediaEntityPredicate.Builder moving(MovementPredicate movement) {
            this.movement = Optional.of(movement);
            return this;
        }

        public DinopediaEntityPredicate.Builder effects(MobEffectsPredicate.Builder effects) {
            this.effects = effects.build();
            return this;
        }

        public DinopediaEntityPredicate.Builder nbt(NbtPredicate nbt) {
            this.nbt = Optional.of(nbt);
            return this;
        }

        public DinopediaEntityPredicate.Builder flags(EntityFlagsPredicate.Builder flags) {
            this.flags = Optional.of(flags.build());
            return this;
        }

        public DinopediaEntityPredicate.Builder equipment(EntityEquipmentPredicate.Builder equipment) {
            this.equipment = Optional.of(equipment.build());
            return this;
        }

        public DinopediaEntityPredicate.Builder equipment(EntityEquipmentPredicate equipment) {
            this.equipment = Optional.of(equipment);
            return this;
        }

        public DinopediaEntityPredicate.Builder periodicTick(int periodicTick) {
            this.periodicTick = Optional.of(periodicTick);
            return this;
        }

        public DinopediaEntityPredicate.Builder vehicle(DinopediaEntityPredicate.Builder vehicle) {
            this.vehicle = Optional.of(vehicle.build());
            return this;
        }

        public DinopediaEntityPredicate.Builder passenger(DinopediaEntityPredicate.Builder passenger) {
            this.passenger = Optional.of(passenger.build());
            return this;
        }

        public DinopediaEntityPredicate.Builder targetedEntity(DinopediaEntityPredicate.Builder targetedEntity) {
            this.targetedEntity = Optional.of(targetedEntity.build());
            return this;
        }

        public DinopediaEntityPredicate.Builder team(String team) {
            this.team = Optional.of(team);
            return this;
        }

        public DinopediaEntityPredicate.Builder slots(SlotsPredicate slots) {
            this.slots = Optional.of(slots);
            return this;
        }

        public DinopediaEntityPredicate build() {
            return new DinopediaEntityPredicate(false, this.entityType, this.distanceToPlayer, this.movement, this.effects, this.nbt, this.flags, this.equipment, this.periodicTick, this.vehicle, this.passenger, this.targetedEntity, this.team, this.slots);
        }
    }
}
