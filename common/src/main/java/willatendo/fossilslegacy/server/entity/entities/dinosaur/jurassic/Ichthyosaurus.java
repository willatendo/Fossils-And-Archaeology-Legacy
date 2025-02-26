package willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;

public class Ichthyosaurus extends Dinosaur implements DinopediaInformation {
    public Ichthyosaurus(EntityType<? extends Dinosaur> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public TagKey<CoatType> getCoatTypes() {
        return null;
    }

    @Override
    public Diet getDiet() {
        return null;
    }

    @Override
    public CommandingType commandItems() {
        return null;
    }

    @Override
    public int getMaxGrowthStage() {
        return 0;
    }

    @Override
    public int getMaxHunger() {
        return 0;
    }
}
