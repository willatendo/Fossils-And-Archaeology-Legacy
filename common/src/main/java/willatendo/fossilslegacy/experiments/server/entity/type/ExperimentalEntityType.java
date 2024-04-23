package willatendo.fossilslegacy.experiments.server.entity.type;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;

public class ExperimentalEntityType<T extends Entity> extends EntityType<T> {
    public ExperimentalEntityType(EntityFactory entityFactory, MobCategory mobCategory, boolean canSpawnFarFromPlayer, boolean serialize, boolean summon, boolean fireImmune, ImmutableSet<Block> immuneTo, EntityDimensions entityDimensions, int clientTrackingRange, int updateInterval, FeatureFlagSet featureFlagSet) {
        super(entityFactory, mobCategory, canSpawnFarFromPlayer, serialize, summon, fireImmune, immuneTo, entityDimensions, clientTrackingRange, updateInterval, featureFlagSet);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return FossilsModloaderHelper.INSTANCE.shouldEnableExperiments();
    }

    public static class Builder<T extends Entity> {
        private final EntityFactory<T> entityFactory;
        private final MobCategory mobCategory;
        private ImmutableSet<Block> immuneTo = ImmutableSet.of();
        private boolean serialize = true;
        private boolean summon = true;
        private boolean fireImmune;
        private boolean canSpawnFarFromPlayer;
        private int clientTrackingRange = 5;
        private int updateInterval = 3;
        private EntityDimensions entityDimensions = EntityDimensions.scalable(0.6F, 1.8F);
        private FeatureFlagSet requiredFeatures;

        private Builder(EntityFactory<T> entityFactory, MobCategory mobCategory) {
            this.requiredFeatures = FeatureFlags.VANILLA_SET;
            this.entityFactory = entityFactory;
            this.mobCategory = mobCategory;
            this.canSpawnFarFromPlayer = mobCategory == MobCategory.CREATURE || mobCategory == MobCategory.MISC;
        }

        public static <T extends Entity> ExperimentalEntityType.Builder<T> of(EntityFactory<T> entityFactory, MobCategory mobCategory) {
            return new ExperimentalEntityType.Builder(entityFactory, mobCategory);
        }

        public ExperimentalEntityType.Builder<T> sized(float width, float height) {
            this.entityDimensions = EntityDimensions.scalable(width, height);
            return this;
        }

        public ExperimentalEntityType.Builder<T> noSummon() {
            this.summon = false;
            return this;
        }

        public ExperimentalEntityType.Builder<T> noSave() {
            this.serialize = false;
            return this;
        }

        public ExperimentalEntityType.Builder<T> fireImmune() {
            this.fireImmune = true;
            return this;
        }

        public ExperimentalEntityType.Builder<T> immuneTo(Block... blocks) {
            this.immuneTo = ImmutableSet.copyOf(blocks);
            return this;
        }

        public ExperimentalEntityType.Builder<T> canSpawnFarFromPlayer() {
            this.canSpawnFarFromPlayer = true;
            return this;
        }

        public ExperimentalEntityType.Builder<T> clientTrackingRange(int clientTrackingRange) {
            this.clientTrackingRange = clientTrackingRange;
            return this;
        }

        public ExperimentalEntityType.Builder<T> updateInterval(int updateInterval) {
            this.updateInterval = updateInterval;
            return this;
        }

        public EntityType<T> build() {
            return new EntityType(this.entityFactory, this.mobCategory, this.serialize, this.summon, this.fireImmune, this.canSpawnFarFromPlayer, this.immuneTo, this.entityDimensions, this.clientTrackingRange, this.updateInterval, this.requiredFeatures);
        }
    }
}
