package willatendo.fossilslegacy.server.entity.pregnant;

import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.DinopediaInformation;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.fossilslegacy.server.utils.SyringeAnimals;

public class PregnantPolarBear extends PolarBear implements DinopediaInformation, PregnantAnimal {
	private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantPolarBear.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> PREGNANCY = SynchedEntityData.defineId(PregnantPolarBear.class, EntityDataSerializers.INT);

	public PregnantPolarBear(EntityType<? extends PolarBear> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public ItemStack getPickResult() {
		return Items.POLAR_BEAR_SPAWN_EGG.getDefaultInstance();
	}

	@Override
	public List<Component> info(Player player) {
		return List.of(FossilsLegacyUtils.translation("encyclopedia", "polar_bear"), FossilsLegacyUtils.translation("encyclopedia", "health", (int) this.getHealth()), FossilsLegacyUtils.translation("encyclopedia", "pregnancy_time", this.getRemainingPregnancyTime() - 5999), FossilsLegacyUtils.translation("encyclopedia", "embryo", FossilsLegacyUtils.translation("encyclopedia", this.getPregnancy().toString().toLowerCase()).getString()));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("PregnancyTime", this.getRemainingPregnancyTime());
		compoundTag.putInt("Pregnancy", this.getPregnancy().ordinal());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.setRemainingPregnancyTime(compoundTag.getInt("PregnancyTime"));
		this.setPregnancy(SyringeAnimals.values()[compoundTag.getInt("Pregnancy")]);
	}

	@Override
	public void tick() {
		super.tick();
		this.birthTick(this, this.level());
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PREGNANCY, 0);
		this.entityData.define(PREGNANCY_TIME, 6000);
	}

	@Override
	public int getRemainingPregnancyTime() {
		return this.entityData.get(PREGNANCY_TIME);
	}

	@Override
	public void setRemainingPregnancyTime(int remainingPregnancyTime) {
		this.entityData.set(PREGNANCY_TIME, remainingPregnancyTime);
	}

	@Override
	public SyringeAnimals getPregnancy() {
		return SyringeAnimals.values()[this.entityData.get(PREGNANCY)];
	}

	@Override
	public void setPregnancy(SyringeAnimals syringeAnimals) {
		this.entityData.set(PREGNANCY, syringeAnimals.ordinal());
	}

	@Override
	public Entity getOffspring(Level level) {
		return this.getPregnancy().getEntityType().get().create(level);
	}

	@Override
	public Entity getBaseEntity(Level level) {
		return EntityType.POLAR_BEAR.create(level);
	}
}
