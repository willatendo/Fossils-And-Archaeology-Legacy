package willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ConversionParams;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;

public class IsotelusLarva extends WaterAnimal {
    public static int ticksToBeTrilobite = Math.abs(-24000);
    private int age;

    public IsotelusLarva(EntityType<? extends IsotelusLarva> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            this.setAge(this.age + 1);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("age", this.age);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setAge(compoundTag.getInt("age"));
    }

    private int getAge() {
        return this.age;
    }

    private void ageUp(int offset) {
        this.setAge(this.age + offset * 20);
    }

    private void setAge(int age) {
        this.age = age;
        if (this.age >= IsotelusLarva.ticksToBeTrilobite) {
            this.ageUp();
        }
    }

    private void ageUp() {
        if (this.level() instanceof ServerLevel serverlevel) {
            this.convertTo(FAEntityTypes.ISOTELUS.get(), ConversionParams.single(this, false, false), isotelus -> {
                isotelus.finalizeSpawn(serverlevel, this.level().getCurrentDifficultyAt(isotelus.blockPosition()), EntitySpawnReason.CONVERSION, null);
                isotelus.setPersistenceRequired();
                isotelus.fudgePositionAfterSizeChange(this.getDimensions(this.getPose()));
                this.playSound(SoundEvents.TADPOLE_GROW_UP, 0.15F, 1.0F);
            });
        }
    }
}
