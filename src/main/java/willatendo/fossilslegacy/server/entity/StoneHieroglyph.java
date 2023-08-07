package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class StoneHieroglyph extends HangingEntity {
	private static final EntityDataAccessor<Integer> STONE_HIEROGLYPH_TYPE = SynchedEntityData.defineId(StoneHieroglyph.class, EntityDataSerializers.INT);

	public StoneHieroglyph(EntityType<? extends StoneHieroglyph> entityType, Level level) {
		super(entityType, level);
	}

	private StoneHieroglyph(Level level, BlockPos blockPos) {
		super(FossilsLegacyEntities.STONE_HIEROGLYPH.get(), level, blockPos);
	}

	public StoneHieroglyph(Level level, BlockPos blockPos, Direction direction, StoneHieroglyphTypes stoneHieroglyphTypes) {
		this(level, blockPos);
		this.setStoneHieroglyph(stoneHieroglyphTypes);
		this.setDirection(direction);
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(STONE_HIEROGLYPH_TYPE, 0);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
		if (STONE_HIEROGLYPH_TYPE.equals(entityDataAccessor)) {
			this.recalculateBoundingBox();
		}
	}

	public void setStoneHieroglyph(StoneHieroglyphTypes stoneHieroglyphTypes) {
		this.entityData.set(STONE_HIEROGLYPH_TYPE, stoneHieroglyphTypes.ordinal());
	}

	public StoneHieroglyphTypes getStoneHieroglyph() {
		return StoneHieroglyphTypes.values()[this.entityData.get(STONE_HIEROGLYPH_TYPE)];
	}

	public static Optional<StoneHieroglyph> create(Level level, BlockPos blockPos, Direction direction) {
		StoneHieroglyph cavePainting = new StoneHieroglyph(level, blockPos);
		List<StoneHieroglyphTypes> list = new ArrayList<>();
		for (StoneHieroglyphTypes stoneHieroglyphTypes : cavePainting.getStoneHieroglyph().values()) {
			list.add(stoneHieroglyphTypes);
		}
		cavePainting.setDirection(direction);
		list.removeIf((stoneHieroglyphTypes) -> {
			cavePainting.setStoneHieroglyph(stoneHieroglyphTypes);
			return !cavePainting.survives();
		});
		if (list.isEmpty()) {
			return Optional.empty();
		} else {
			int i = list.stream().mapToInt(StoneHieroglyph::variantArea).max().orElse(0);
			list.removeIf((stoneHieroglyphTypes) -> {
				return variantArea(stoneHieroglyphTypes) < i;
			});
			Optional<StoneHieroglyphTypes> randomVarient = Util.getRandomSafe(list, cavePainting.random);
			if (randomVarient.isEmpty()) {
				return Optional.empty();
			} else {
				cavePainting.setStoneHieroglyph(randomVarient.get());
				cavePainting.setDirection(direction);
				return Optional.of(cavePainting);
			}
		}
	}

	private static int variantArea(StoneHieroglyphTypes stoneHieroglyphTypes) {
		return stoneHieroglyphTypes.getWidth() * stoneHieroglyphTypes.getHeight();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.putInt("Type", this.getStoneHieroglyph().ordinal());
		compoundTag.putByte("FacingDirection", (byte) this.direction.get2DDataValue());
		super.addAdditionalSaveData(compoundTag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		this.setStoneHieroglyph(StoneHieroglyphTypes.values()[compoundTag.getInt("Type")]);
		this.direction = Direction.from2DDataValue(compoundTag.getByte("FacingDirection"));
		super.readAdditionalSaveData(compoundTag);
		this.setDirection(this.direction);
	}

	@Override
	public int getWidth() {
		return this.getStoneHieroglyph().getWidth();
	}

	@Override
	public int getHeight() {
		return this.getStoneHieroglyph().getHeight();
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

			this.spawnAtLocation(FossilsLegacyItems.STONE_HIEROGLYPH.get());
		}
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
	public void lerpTo(double x, double y, double z, float pitch, float yaw, int p_31922_, boolean p_31923_) {
		this.setPos(x, y, z);
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
		return FossilsLegacyItems.STONE_HIEROGLYPH.get().getDefaultInstance();
	}
}
