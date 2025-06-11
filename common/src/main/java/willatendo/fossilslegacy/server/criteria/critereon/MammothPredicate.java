package willatendo.fossilslegacy.server.criteria.critereon;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;

import java.util.Optional;

public record MammothPredicate(Optional<Boolean> sheared, Optional<DyeColor> color) implements EntitySubPredicate {
    public static final MapCodec<MammothPredicate> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.BOOL.optionalFieldOf("sheared").forGetter(MammothPredicate::sheared), DyeColor.CODEC.optionalFieldOf("geneColor").forGetter(MammothPredicate::color)).apply(instance, MammothPredicate::new));

    @Override
    public MapCodec<MammothPredicate> codec() {
        return FAEntitySubPredicates.MAMMOTH.get();
    }

    @Override
    public boolean matches(Entity entity, ServerLevel level, @Nullable Vec3 position) {
        if (entity instanceof Mammoth mammoth) {
            if (this.sheared.isPresent() && mammoth.isSheared() != this.sheared.get()) {
                return false;
            } else {
                return !this.color.isPresent() || mammoth.getColor() == this.color.get();
            }
        } else {
            return false;
        }
    }

    public static MammothPredicate hasWool(DyeColor dyeColor) {
        return new MammothPredicate(Optional.of(false), Optional.of(dyeColor));
    }
}
