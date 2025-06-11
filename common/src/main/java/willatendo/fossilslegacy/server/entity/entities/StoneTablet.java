package willatendo.fossilslegacy.server.entity.entities;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.tags.FAStoneTabletVariantTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StoneTablet extends HangingEntity implements VariantHolder<Holder<StoneTabletVariant>> {
    private static final EntityDataAccessor<Holder<StoneTabletVariant>> STONE_TABLET_VARIANT = SynchedEntityData.defineId(StoneTablet.class, FAEntityDataSerializers.STONE_TABLET_VARIANTS.get());
    public static final MapCodec<Holder<StoneTabletVariant>> VARIANT_MAP_CODEC = StoneTabletVariant.CODEC.fieldOf("variant");
    public static final Codec<Holder<StoneTabletVariant>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

    public StoneTablet(EntityType<? extends StoneTablet> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(STONE_TABLET_VARIANT, this.registryAccess().lookupOrThrow(FARegistries.STONE_TABLET_VARIANT).getAny().orElseThrow());
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        if (STONE_TABLET_VARIANT.equals(entityDataAccessor)) {
            this.recalculateBoundingBox();
        }
    }

    @Override
    public void setVariant(Holder<StoneTabletVariant> stoneTabletVariant) {
        this.entityData.set(STONE_TABLET_VARIANT, stoneTabletVariant);
    }

    @Override
    public Holder<StoneTabletVariant> getVariant() {
        return this.entityData.get(STONE_TABLET_VARIANT);
    }

    public static Optional<StoneTablet> create(Level level, BlockPos blockPos, Direction direction) {
        StoneTablet stoneTablet = new StoneTablet(level, blockPos);
        List<Holder<StoneTabletVariant>> stoneTabletVariants = new ArrayList<>();
        Iterable<Holder<StoneTabletVariant>> stoneTabletVariantIterable = level.registryAccess().lookupOrThrow(FARegistries.STONE_TABLET_VARIANT).getTagOrEmpty(FAStoneTabletVariantTags.PLACEABLE);
        Objects.requireNonNull(stoneTabletVariantIterable);
        stoneTabletVariantIterable.forEach(stoneTabletVariants::add);
        if (stoneTabletVariants.isEmpty()) {
            return Optional.empty();
        } else {
            stoneTablet.setDirection(direction);
            stoneTabletVariants.removeIf(holder -> {
                stoneTablet.setVariant(holder);
                return !stoneTablet.survives();
            });
            if (stoneTabletVariants.isEmpty()) {
                return Optional.empty();
            } else {
                int area = stoneTabletVariants.stream().mapToInt(StoneTablet::variantArea).max().orElse(0);
                stoneTabletVariants.removeIf(holder -> StoneTablet.variantArea(holder) < area);
                Optional<Holder<StoneTabletVariant>> stoneTabletVariantHolder = Util.getRandomSafe(stoneTabletVariants, stoneTablet.random);
                if (stoneTabletVariantHolder.isEmpty()) {
                    return Optional.empty();
                }
                stoneTablet.setVariant(stoneTabletVariantHolder.get());
                stoneTablet.setDirection(direction);
                return Optional.of(stoneTablet);
            }
        }
    }

    private StoneTablet(Level level, BlockPos blockPos) {
        super(FAEntityTypes.STONE_TABLET.get(), level, blockPos);
    }

    private static int variantArea(Holder<StoneTabletVariant> stoneTabletVariant) {
        return stoneTabletVariant.value().area();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getVariant()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
        compoundTag.putByte("facing", (byte) this.direction.get2DDataValue());
        super.addAdditionalSaveData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setVariant);
        this.direction = Direction.from2DDataValue(compoundTag.getByte("facing"));
        super.readAdditionalSaveData(compoundTag);
        this.setDirection(this.direction);
    }

    @Override
    protected AABB calculateBoundingBox(BlockPos blockPos, Direction direction) {
        Vec3 vec3 = Vec3.atCenterOf(blockPos).relative(direction, -0.46875);
        StoneTabletVariant stoneTabletVariant = this.getVariant().value();
        double withOffset = this.offsetForStoneTabletSize(stoneTabletVariant.width());
        double heightOffset = this.offsetForStoneTabletSize(stoneTabletVariant.height());
        Direction counterClockWise = direction.getCounterClockWise();
        Vec3 relative = vec3.relative(counterClockWise, withOffset).relative(Direction.UP, heightOffset);
        Direction.Axis axis = direction.getAxis();
        double xWidth = axis == Direction.Axis.X ? 0.0625 : (double) stoneTabletVariant.width();
        double height = stoneTabletVariant.height();
        double zWidth = axis == Direction.Axis.Z ? 0.0625 : (double) stoneTabletVariant.width();
        return AABB.ofSize(relative, xWidth, height, zWidth);
    }

    private double offsetForStoneTabletSize(int size) {
        return size % 2 == 0 ? 0.5 : 0.0;
    }

    @Override
    public void dropItem(ServerLevel serverLevel, Entity entity) {
        if (serverLevel.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.STONE_BREAK, 1.0F, 1.0F);
            if (entity instanceof Player player) {
                if (player.hasInfiniteMaterials()) {
                    return;
                }
            }

            this.spawnAtLocation(serverLevel, FAItems.STONE_TABLET.get());
        }
    }

    @Override
    public void playPlacementSound() {
        this.playSound(SoundEvents.STONE_PLACE, 1.0F, 1.0F);
    }

    @Override
    public void moveTo(double x, double y, double z, float pitch, float yaw) {
        this.setPos(x, y, z);
    }

    @Override
    public void lerpTo(double x, double y, double z, float pitch, float yaw, int p_31922_) {
        this.setPos(x, y, z);
    }

    @Override
    public Vec3 trackingPosition() {
        return Vec3.atLowerCornerOf(this.pos);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        this.setDirection(Direction.from3DDataValue(clientboundAddEntityPacket.getData()));
    }

    @Override
    public ItemStack getPickResult() {
        return FAItems.STONE_TABLET.get().getDefaultInstance();
    }
}
