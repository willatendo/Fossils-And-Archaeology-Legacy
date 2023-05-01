package fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fossilslegacy.server.item.FossilsLegacyItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CavePainting extends HangingEntity {
	private static final EntityDataAccessor<Integer> CAVE_PAINTING_TYPE = SynchedEntityData.defineId(CavePainting.class, EntityDataSerializers.INT);

	public CavePainting(EntityType<? extends CavePainting> entityType, Level level) {
		super(entityType, level);
	}

	private CavePainting(Level level, BlockPos blockPos) {
		super(FossilsLegacyEntities.CAVE_PAINTING.get(), level, blockPos);
	}

	public CavePainting(Level level, BlockPos blockPos, Direction direction, CavePaintingTypes cavePaintingTypes) {
		this(level, blockPos);
		this.setVariant(cavePaintingTypes);
		this.setDirection(direction);
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(CAVE_PAINTING_TYPE, 0);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
		if (CAVE_PAINTING_TYPE.equals(entityDataAccessor)) {
			this.recalculateBoundingBox();
		}
	}

	public void setVariant(CavePaintingTypes cavePaintingTypes) {
		this.entityData.set(CAVE_PAINTING_TYPE, cavePaintingTypes.ordinal());
	}

	public CavePaintingTypes getVariant() {
		return CavePaintingTypes.values()[this.entityData.get(CAVE_PAINTING_TYPE)];
	}

	public static Optional<CavePainting> create(Level level, BlockPos blockPos, Direction direction) {
		CavePainting cavePainting = new CavePainting(level, blockPos);
		List<CavePaintingTypes> list = new ArrayList<>();
		for (CavePaintingTypes cavePaintingTypes : cavePainting.getVariant().values()) {
			list.add(cavePaintingTypes);
		}
		cavePainting.setDirection(direction);
		list.removeIf((cavePaintingTypes) -> {
			cavePainting.setVariant(cavePaintingTypes);
			return !cavePainting.survives();
		});
		if (list.isEmpty()) {
			return Optional.empty();
		} else {
			int i = list.stream().mapToInt(CavePainting::variantArea).max().orElse(0);
			list.removeIf((p_218883_) -> {
				return variantArea(p_218883_) < i;
			});
			Optional<CavePaintingTypes> randomVarient = Util.getRandomSafe(list, cavePainting.random);
			if (randomVarient.isEmpty()) {
				return Optional.empty();
			} else {
				cavePainting.setVariant(randomVarient.get());
				cavePainting.setDirection(direction);
				return Optional.of(cavePainting);
			}
		}
	}

	private static int variantArea(CavePaintingTypes cavePaintingTypes) {
		return cavePaintingTypes.getWidth() * cavePaintingTypes.getHeight();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.putInt("Type", this.getVariant().ordinal());
		compoundTag.putByte("FacingDirection", (byte) this.direction.get2DDataValue());
		super.addAdditionalSaveData(compoundTag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		this.setVariant(CavePaintingTypes.values()[compoundTag.getInt("Type")]);
		this.direction = Direction.from2DDataValue(compoundTag.getByte("FacingDirection"));
		super.readAdditionalSaveData(compoundTag);
		this.setDirection(this.direction);
	}

	@Override
	public int getWidth() {
		return this.getVariant().getWidth();
	}

	@Override
	public int getHeight() {
		return this.getVariant().getHeight();
	}

	@Override
	public void dropItem(Entity entity) {
		if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
			this.playSound(SoundEvents.PAINTING_BREAK, 1.0F, 1.0F);
			if (entity instanceof Player player) {
				if (player.getAbilities().instabuild) {
					return;
				}
			}

			this.spawnAtLocation(FossilsLegacyItems.CAVE_PAINTING.get());
		}
	}

	@Override
	public void playPlacementSound() {
		this.playSound(SoundEvents.PAINTING_PLACE, 1.0F, 1.0F);
	}

	@Override
	public void moveTo(double p_31929_, double p_31930_, double p_31931_, float p_31932_, float p_31933_) {
		this.setPos(p_31929_, p_31930_, p_31931_);
	}

	@Override
	public void lerpTo(double p_31917_, double p_31918_, double p_31919_, float p_31920_, float p_31921_, int p_31922_, boolean p_31923_) {
		this.setPos(p_31917_, p_31918_, p_31919_);
	}

	@Override
	public Vec3 trackingPosition() {
		return Vec3.atLowerCornerOf(this.pos);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
	}

	@Override
	public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
		super.recreateFromPacket(clientboundAddEntityPacket);
		this.setDirection(Direction.from3DDataValue(clientboundAddEntityPacket.getData()));
	}

	@Override
	public ItemStack getPickedResult(HitResult hitResult) {
		return FossilsLegacyItems.CAVE_PAINTING.get().getDefaultInstance();
	}
}
