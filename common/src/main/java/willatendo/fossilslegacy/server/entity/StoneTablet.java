package willatendo.fossilslegacy.server.entity;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoneTablet extends HangingEntity implements VariantHolder<Holder<StoneTabletVariant>> {
    private static final EntityDataAccessor<Holder<StoneTabletVariant>> STONE_TABLET_VARIANT = SynchedEntityData.defineId(StoneTablet.class, FossilsLegacyEntityDataSerializers.STONE_TABLET_VARIANTS.get());
    private static final ResourceKey<StoneTabletVariant> DEFAULT_VARIANT = FossilsLegacyStoneTabletVariants.LIGHTING.getKey();
    public static final MapCodec<Holder<StoneTabletVariant>> VARIANT_MAP_CODEC = FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.registry().holderByNameCodec().fieldOf("variant");
    public static final Codec<Holder<StoneTabletVariant>> CODEC = VARIANT_MAP_CODEC.codec();

    private static Holder<StoneTabletVariant> getDefaultVariant() {
        return FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.getHolderOrThrow(DEFAULT_VARIANT);
    }

    public StoneTablet(EntityType<? extends StoneTablet> entityType, Level level) {
        super(entityType, level);
    }

    private StoneTablet(Level level, BlockPos blockPos) {
        super(FossilsLegacyEntityTypes.STONE_TABLET.get(), level, blockPos);
    }

    public StoneTablet(Level level, BlockPos blockPos, Direction direction, Holder<StoneTabletVariant> stoneTabletVariant) {
        this(level, blockPos);
        this.setVariant(stoneTabletVariant);
        this.setDirection(direction);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(STONE_TABLET_VARIANT, getDefaultVariant());
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
        FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.getTagOrEmpty(FossilsLegacyStoneTabletVariantTags.PLACEABLE).forEach(stoneTabletVariants::add);
        if (stoneTabletVariants.isEmpty()) {
            return Optional.empty();
        }
        stoneTablet.setDirection(direction);
        stoneTabletVariants.removeIf(holder -> {
            stoneTablet.setVariant(holder);
            return !stoneTablet.survives();
        });
        if (stoneTabletVariants.isEmpty()) {
            return Optional.empty();
        }
        int i = stoneTabletVariants.stream().mapToInt(StoneTablet::variantArea).max().orElse(0);
        stoneTabletVariants.removeIf(holder -> StoneTablet.variantArea(holder) < i);
        Optional<Holder<StoneTabletVariant>> optional = Util.getRandomSafe(stoneTabletVariants, stoneTablet.random);
        if (optional.isEmpty()) {
            return Optional.empty();
        }
        stoneTablet.setVariant(optional.get());
        stoneTablet.setDirection(direction);
        return Optional.of(stoneTablet);
    }

    private static int variantArea(Holder<StoneTabletVariant> stoneTabletVariant) {
        return stoneTabletVariant.value().width() * stoneTabletVariant.value().height();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        StoneTablet.storeVariant(compoundTag, this.getVariant());
        compoundTag.putByte("FacingDirection", (byte) this.direction.get2DDataValue());
        super.addAdditionalSaveData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        Holder holder = CODEC.parse(NbtOps.INSTANCE, compoundTag).result().orElseGet(StoneTablet::getDefaultVariant);
        this.setVariant(holder);
        this.direction = Direction.from2DDataValue(compoundTag.getByte("FacingDirection"));
        super.readAdditionalSaveData(compoundTag);
        this.setDirection(this.direction);
    }

    public static void storeVariant(CompoundTag compoundTag, Holder<StoneTabletVariant> stoneTabletVariant) {
        compoundTag.putString("Variant", stoneTabletVariant.unwrapKey().orElse(DEFAULT_VARIANT).location().toString());
    }

    @Override
    public void dropItem(Entity entity) {
        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.PAINTING_BREAK, 1.0F, 1.0F);
            if (entity instanceof Player player) {
                if (player.getAbilities().instabuild) {
                    return;
                }
            }

            this.spawnAtLocation(FossilsLegacyItems.STONE_TABLET.get());
        }
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
        double height = (double) stoneTabletVariant.height();
        double zWidth = axis == Direction.Axis.Z ? 0.0625 : (double) stoneTabletVariant.width();
        return AABB.ofSize(relative, xWidth, height, zWidth);
    }

    private double offsetForStoneTabletSize(int size) {
        return size % 2 == 0 ? 0.5 : 0.0;
    }

    @Override
    public void playPlacementSound() {
        this.playSound(SoundEvents.PAINTING_PLACE, 1.0F, 1.0F);
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
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        this.setDirection(Direction.from3DDataValue(clientboundAddEntityPacket.getData()));
    }

    @Override
    public ItemStack getPickResult() {
        return FossilsLegacyItems.STONE_TABLET.get().getDefaultInstance();
    }
}
