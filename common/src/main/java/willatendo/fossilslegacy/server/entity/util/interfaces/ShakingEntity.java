package willatendo.fossilslegacy.server.entity.util.interfaces;

public interface ShakingEntity extends WetFurEntity {
    float getHeadRollAngle(float f);

    float getBodyRollAngle(float ageInTicks, float max);
}
