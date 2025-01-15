package willatendo.fossilslegacy.server.entity.pregnant;

import com.google.common.collect.Lists;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class PregnantSheep extends Sheep implements DinopediaInformation, PregnantAnimal<Sheep> {
    private static final EntityDataAccessor<Holder<CoatType>> OFFSPRING_COAT_TYPE = SynchedEntityData.defineId(PregnantSheep.class, FossilsLegacyEntityDataSerializers.COAT_TYPES.get());
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantSheep.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Holder<PregnancyType>> PREGNANCY = SynchedEntityData.defineId(PregnantSheep.class, FossilsLegacyEntityDataSerializers.PREGNANCY_TYPES.get());

    public PregnantSheep(EntityType<? extends Sheep> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.SHEEP_SPAWN_EGG.getDefaultInstance();
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public Level getLevel() {
        return this.level();
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
        this.addRemainingPregnancyTime(compoundTag);
        this.addPregnancyData(compoundTag);
        this.addCoatTypeData(compoundTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.readRemainingPregnancyTime(compoundTag);
        this.readPregnancyData(compoundTag);
        this.readCoatTypeData(compoundTag);
    }

    @Override
    public void tick() {
        super.tick();
        this.birthTick(this, this.level());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.defineCoatTypeData(OFFSPRING_COAT_TYPE, builder);
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
    public Holder<CoatType> getOffspringCoatType() {
        return this.entityData.get(OFFSPRING_COAT_TYPE);
    }

    @Override
    public void setOffspringCoatType(Holder<CoatType> coatTypeHolder) {
        this.entityData.set(OFFSPRING_COAT_TYPE, coatTypeHolder);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().value().entityType().get().create(level);
    }

    @Override
    public Sheep getBaseEntity(Level level) {
        return EntityType.SHEEP.create(level);
    }
}
