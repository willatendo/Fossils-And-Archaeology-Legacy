package willatendo.fossilslegacy.server.entity.pregnant;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class PregnantWolf extends Wolf implements DinopediaInformation, PregnantAnimal<Wolf> {
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantWolf.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY = SynchedEntityData.defineId(PregnantWolf.class, FossilsLegacyEntityDataSerializers.PREGNANCY_TYPES.get());

    public PregnantWolf(EntityType<? extends Wolf> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.WOLF_SPAWN_EGG.getDefaultInstance();
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        information.add(this.getDisplayName());
        information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
        information.add(FossilsLegacyUtils.translation("dinopedia", "pregnancy_time", (int) Math.floor((((float) this.getRemainingTime()) / this.maxTime()) * 100) + "%"));
        information.add(FossilsLegacyUtils.translation("dinopedia", "embryo", this.getPregnancyType().value().getDescription().getString()));
        return information;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("PregnancyTime", this.getRemainingPregnancyTime());
        this.addPregnancyData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setRemainingPregnancyTime(compoundTag.getInt("PregnancyTime"));
        this.readPregnancyData(compoundTag);
    }

    @Override
    public void tick() {
        super.tick();
        this.birthTick(this, this.level());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.definePregnancyData(PREGNANCY, builder);
        builder.define(PREGNANCY_TIME, 0);
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
    public Holder<PregnancyType> getPregnancyType() {
        return this.entityData.get(PREGNANCY);
    }

    @Override
    public void setPregnancyType(Holder<PregnancyType> pregnancyType) {
        this.entityData.set(PREGNANCY, pregnancyType);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().value().entityType().get().create(level);
    }

    @Override
    public Wolf getBaseEntity(Level level) {
        return EntityType.WOLF.create(level);
    }
}
