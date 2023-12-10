package willatendo.fossilslegacy.server.entity;

import java.util.List;
import java.util.UUID;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.utils.DinosaurOrder;

public class Mosasaurus extends Animal implements DinosaurEncyclopediaInfo, HungryAnimal, PlayerRideable, OwnableEntity, TamesOnBirth, TameAccessor, DaysAlive, GrowingEntity, PlayerCommandable {

	protected Mosasaurus(EntityType<? extends Animal> p_27557_, Level p_27558_) {
		super(p_27557_, p_27558_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LivingEntity getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DinosaurOrder getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCommand(DinosaurOrder dinosaurOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public TagKey commandItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGrowthStage(int growthStage) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getGrowthStage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRealAge(int realAge) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRealAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getGrowthStages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAdultAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDaysAlive(int daysAlive) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDaysAlive() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOwnerUUID(UUID uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public UUID getOwnerUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHunger(int hunger) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHunger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHunger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Component> info() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		// TODO Auto-generated method stub
		return null;
	}

}
