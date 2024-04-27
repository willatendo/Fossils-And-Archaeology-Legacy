package willatendo.fossilslegacy.server.entity.pregnant;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.FossilsLegacyPregnancyTypes;
import willatendo.fossilslegacy.server.entity.PregnancyType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class PregnantCow extends Cow implements DinopediaInformation, PregnantAnimal {
    private static final EntityDataAccessor<Integer> PREGNANCY_TIME = SynchedEntityData.defineId(PregnantCow.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<PregnancyType> PREGNANCY = SynchedEntityData.defineId(PregnantCow.class, FossilsLegacyEntityDataSerializers.PREGNANCY_TYPES.get());

    public PregnantCow(EntityType<? extends Cow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack getPickResult() {
        return Items.COW_SPAWN_EGG.getDefaultInstance();
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
        information.add(FossilsLegacyUtils.translation("dinopedia", "pregnancy_time", this.getRemainingPregnancyTime()));
        information.add(FossilsLegacyUtils.translation("dinopedia", "embryo", this.getPregnancyType().getDescription().getString()));
        return information;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("PregnancyTime", this.getRemainingPregnancyTime());
        compoundTag.putString("Variant", FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES.getKey(this.getPregnancyType()).toString());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setRemainingPregnancyTime(compoundTag.getInt("PregnancyTime"));
        PregnancyType pregnancyType = FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES.get(ResourceLocation.tryParse(compoundTag.getString("Variant")));
        if (pregnancyType != null) {
            this.setPregnancyType(pregnancyType);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.birthTick(this, this.level());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(PREGNANCY, FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES.getOrThrow(FossilsLegacyPregnancyTypes.CAT.getKey()));
        this.entityData.define(PREGNANCY_TIME, 0);
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
    public PregnancyType getPregnancyType() {
        return this.entityData.get(PREGNANCY);
    }

    @Override
    public void setPregnancyType(PregnancyType pregnancyType) {
        this.entityData.set(PREGNANCY, pregnancyType);
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getPregnancyType().entityType().get().create(level);
    }

    @Override
    public Entity getBaseEntity(Level level) {
        return EntityType.COW.create(level);
    }
}
