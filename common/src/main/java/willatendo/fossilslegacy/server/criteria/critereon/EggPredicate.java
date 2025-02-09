package willatendo.fossilslegacy.server.criteria.critereon;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.egg_variant.EggVariant;
import willatendo.fossilslegacy.server.entity.entities.Egg;

import java.util.Optional;

public record EggPredicate(Optional<Holder<EggVariant>> eggVariant) implements EntitySubPredicate {
    public static final MapCodec<EggPredicate> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(EggVariant.CODEC.optionalFieldOf("variant").forGetter(EggPredicate::eggVariant)).apply(instance, EggPredicate::new));

    @Override
    public MapCodec<EggPredicate> codec() {
        return FAEntitySubPredicates.EGG.get();
    }

    @Override
    public boolean matches(Entity entity, ServerLevel serverLevel, Vec3 vec3) {
        if (!(entity instanceof Egg egg)) {
            return false;
        } else {
            return this.eggVariant().isPresent() && egg.getEggVariant() == this.eggVariant().get();
        }
    }

    public static EggPredicate isEggVariant(Holder<EggVariant> eggVariant) {
        return new EggPredicate(Optional.of(eggVariant));
    }
}
