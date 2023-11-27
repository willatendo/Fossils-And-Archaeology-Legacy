package willatendo.fossilslegacy.server.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class Fossil extends Entity {
	private static final EntityDataAccessor<Integer> FOSSIL = SynchedEntityData.defineId(Fossil.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(Fossil.class, EntityDataSerializers.INT);

	public float yBodyRot;
	public float yBodyRotO;
	public float yHeadRot;
	public float yHeadRotO;

	public Fossil(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	public ItemStack getPickedResult(HitResult hitResult) {
		return new ItemStack(FossilsLegacyItems.FOSSIL.get());
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(FOSSIL, 0);
		this.entityData.define(SIZE, 0);
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compoundTag) {
		this.setFossil(compoundTag.getInt("Fossil"));
		this.setSize(compoundTag.getInt("Size"));
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.putInt("Fossil", this.getFossil());
		compoundTag.putInt("Size", this.getSize());
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (itemStack.is(Items.BONE)) {
			this.setSize(this.getSize() + 1);
			itemStack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		if (itemStack.isEmpty()) {
			if (this.getSize() > 0) {
				this.setSize(this.getSize() - 1);
				player.addItem(new ItemStack(Items.BONE));
				return InteractionResult.SUCCESS;
			}
		}
		return super.interactAt(player, vec3, interactionHand);
	}

	public void setFossil(int fossils) {
		this.entityData.set(FOSSIL, fossils);
	}

	public int getFossil() {
		return this.entityData.get(FOSSIL);
	}

	public void setSize(int size) {
		this.entityData.set(SIZE, size);
	}

	public int getSize() {
		return this.entityData.get(SIZE);
	}
}
