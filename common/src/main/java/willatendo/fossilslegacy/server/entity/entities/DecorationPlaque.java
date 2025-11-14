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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.block.entity.entities.DecorationPostBlockEntity;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FADecorationPlaqueTypeTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DecorationPlaque extends HangingEntity implements VariantHolder<Holder<DecorationPlaqueType>> {
    private static final EntityDataAccessor<Holder<DecorationPlaqueType>> DECORATION_PLAQUE_TYPE = SynchedEntityData.defineId(DecorationPlaque.class, FAEntityDataSerializers.DECORATION_PLAQUE_TYPE.get());
    public static final MapCodec<Holder<DecorationPlaqueType>> VARIANT_MAP_CODEC = DecorationPlaqueType.CODEC.fieldOf("variant");
    public static final Codec<Holder<DecorationPlaqueType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();
    private ItemStack plaqueItemStack;

    public DecorationPlaque(EntityType<? extends DecorationPlaque> entityType, Level level) {
        super(entityType, level);
        this.plaqueItemStack = new ItemStack(FAItems.DECORATION_PLAQUE.get());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(DECORATION_PLAQUE_TYPE, this.registryAccess().lookupOrThrow(FARegistries.DECORATION_PLAQUE_TYPE).getAny().orElseThrow());
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        if (DECORATION_PLAQUE_TYPE.equals(entityDataAccessor)) {
            this.recalculateBoundingBox();
        }
    }

    @Override
    public void setVariant(Holder<DecorationPlaqueType> decorationPlaqueType) {
        this.entityData.set(DECORATION_PLAQUE_TYPE, decorationPlaqueType);
    }

    @Override
    public Holder<DecorationPlaqueType> getVariant() {
        return this.entityData.get(DECORATION_PLAQUE_TYPE);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand interactionHand) {
        if (!this.level().isClientSide() && player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
            ServerLevel serverLevel = (ServerLevel) this.level();
            List<Holder<DecorationPlaqueType>> decorationPlaqueTypes = serverLevel.registryAccess().lookupOrThrow(FARegistries.DECORATION_PLAQUE_TYPE).get(FADecorationPlaqueTypeTags.PLACEABLE).get().stream().filter(decorationPlaqueTypeHolder -> {
                DecorationPlaqueType decorationPlaqueType = decorationPlaqueTypeHolder.value();
                DecorationPlaqueType thisDecorationPlaqueType = this.getVariant().value();
                return thisDecorationPlaqueType.width() == decorationPlaqueType.width() && thisDecorationPlaqueType.height() == decorationPlaqueType.height();
            }).toList();
            Holder<DecorationPlaqueType> decorationPlaqueTypeHolder;
            if (this.getVariant() != null) {
                int index = decorationPlaqueTypes.indexOf(this.getVariant()) + 1;
                if (index < decorationPlaqueTypes.size()) {
                    decorationPlaqueTypeHolder = decorationPlaqueTypes.get(index);
                } else {
                    decorationPlaqueTypeHolder = decorationPlaqueTypes.getFirst();
                }
            } else {
                decorationPlaqueTypeHolder = decorationPlaqueTypes.getFirst();
            }
            this.setVariant(decorationPlaqueTypeHolder);
            return InteractionResult.SUCCESS;
        }
        return super.interact(player, interactionHand);
    }

    public static Optional<DecorationPlaque> create(Level level, BlockPos blockPos, ItemStack plaqueItemStack, Direction direction) {
        DecorationPlaque decorationPlaque = new DecorationPlaque(level, blockPos, plaqueItemStack);
        List<Holder<DecorationPlaqueType>> decorationPlaqueTypes = new ArrayList<>();
        Iterable<Holder<DecorationPlaqueType>> decorationPlaqueTypeIterable = level.registryAccess().lookupOrThrow(FARegistries.DECORATION_PLAQUE_TYPE).getTagOrEmpty(FADecorationPlaqueTypeTags.PLACEABLE);
        Objects.requireNonNull(decorationPlaqueTypeIterable);
        decorationPlaqueTypeIterable.forEach(decorationPlaqueTypes::add);
        if (decorationPlaqueTypes.isEmpty()) {
            return Optional.empty();
        } else {
            decorationPlaque.setDirection(direction);
            decorationPlaqueTypes.removeIf(holder -> {
                decorationPlaque.setVariant(holder);
                return !decorationPlaque.survives();
            });
            if (decorationPlaqueTypes.isEmpty()) {
                return Optional.empty();
            } else {
                int area = decorationPlaqueTypes.stream().mapToInt(DecorationPlaque::variantArea).max().orElse(0);
                decorationPlaqueTypes.removeIf(holder -> DecorationPlaque.variantArea(holder) < area);
                Optional<Holder<DecorationPlaqueType>> decorationPlaqueTypeHolder = Util.getRandomSafe(decorationPlaqueTypes, decorationPlaque.random);
                if (decorationPlaqueTypeHolder.isEmpty()) {
                    return Optional.empty();
                }
                decorationPlaque.setVariant(decorationPlaqueTypeHolder.get());
                decorationPlaque.setDirection(direction);
                return Optional.of(decorationPlaque);
            }
        }
    }

    private DecorationPlaque(Level level, BlockPos blockPos, ItemStack plaqueItemStack) {
        super(FAEntityTypes.DECORATION_PLAQUE.get(), level, blockPos);
        this.plaqueItemStack = plaqueItemStack;
    }

    private static int variantArea(Holder<DecorationPlaqueType> decorationPlaqueType) {
        return decorationPlaqueType.value().area();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getVariant()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
        compoundTag.putByte("facing", (byte) this.direction.get2DDataValue());
        compoundTag.put("plaque_type", this.plaqueItemStack.save(this.registryAccess()));
        super.addAdditionalSaveData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setVariant);
        this.direction = Direction.from2DDataValue(compoundTag.getByte("facing"));
        super.readAdditionalSaveData(compoundTag);
        this.setDirection(this.direction);
        this.plaqueItemStack = ItemStack.parseOptional(this.registryAccess(), compoundTag.getCompound("plaque_type"));
    }

    @Override
    protected AABB calculateBoundingBox(BlockPos blockPos, Direction direction) {
        Vec3 vec3 = Vec3.atCenterOf(blockPos).relative(direction, -0.46875);
        DecorationPlaqueType decorationPlaqueType = this.getVariant().value();
        double withOffset = this.offsetForDecorationPlaqueSize(decorationPlaqueType.width());
        double heightOffset = this.offsetForDecorationPlaqueSize(decorationPlaqueType.height());
        Direction counterClockWise = direction.getCounterClockWise();
        Vec3 relative = vec3.relative(counterClockWise, withOffset).relative(Direction.UP, heightOffset);
        Direction.Axis axis = direction.getAxis();
        double xWidth = axis == Direction.Axis.X ? 0.0625 : (double) decorationPlaqueType.width();
        double height = decorationPlaqueType.height();
        double zWidth = axis == Direction.Axis.Z ? 0.0625 : (double) decorationPlaqueType.width();
        return AABB.ofSize(relative, xWidth, height, zWidth);
    }

    private double offsetForDecorationPlaqueSize(int size) {
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

            this.spawnAtLocation(serverLevel, this.plaqueItemStack);
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
        return this.plaqueItemStack;
    }
}
