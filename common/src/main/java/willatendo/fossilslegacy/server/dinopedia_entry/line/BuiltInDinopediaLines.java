package willatendo.fossilslegacy.server.dinopedia_entry.line;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.dinopedia_entry.FADinopediaLineTypes;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.entity.entities.Egg;
import willatendo.fossilslegacy.server.entity.util.interfaces.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.util.interfaces.RideableDinosaur;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BuiltInDinopediaLines implements DinopediaLine {
    public static final BuiltInDinopediaLines DISPLAY_NAME = BuiltInDinopediaLines.createDinosaur("display_name", Entity::getDisplayName, BuiltInDinopediaLines::alwaysTrue);
    public static final BuiltInDinopediaLines OWNER = BuiltInDinopediaLines.createDinosaur("owner", dinosaur -> FAUtils.translation("dinopedia", "owner", dinosaur.getOwner() != null ? dinosaur.getOwner().getDisplayName().getString() : FAUtils.translation("dinopedia", "wild").getString()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines AGE = BuiltInDinopediaLines.createDinosaur("age", dinosaur -> FAUtils.translation("dinopedia", "age", dinosaur.getDaysAlive()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines HEALTH = BuiltInDinopediaLines.createDinosaur("health", dinosaur -> FAUtils.translation("dinopedia", "health", (int) dinosaur.getHealth(), (int) dinosaur.getMaxHealth()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines HUNGER = BuiltInDinopediaLines.createDinosaur("hunger", dinosaur -> FAUtils.translation("dinopedia", "hunger", dinosaur.getHunger(), dinosaur.getMaxHunger()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines RIDEABLE = BuiltInDinopediaLines.createDinosaur("rideable", dinosaur -> FAUtils.translation("dinopedia", "rideable"), (dinosaur, player) -> BuiltInDinopediaLines.ownerCondition(dinosaur, player, dinosaur instanceof RideableDinosaur rideableDinosaur && dinosaur.getAge() >= rideableDinosaur.getMinRideableAge()));
    public static final BuiltInDinopediaLines ABLE_TO_FLY = BuiltInDinopediaLines.createDinosaur("able_to_fly", dinosaur -> FAUtils.translation("dinopedia", "able_to_fly"), (dinosaur, player) -> BuiltInDinopediaLines.ownerCondition(dinosaur, player, dinosaur instanceof RideableDinosaur rideableDinosaur && dinosaur.getAge() >= rideableDinosaur.getMinRideableAge()));
    public static final BuiltInDinopediaLines DANGEROUS = BuiltInDinopediaLines.createDinosaur("dangerous", dinosaur -> FAUtils.translation("dinopedia", "dangerous"), (dinosaur, player) -> dinosaur.getAge() > 3);
    public static final BuiltInDinopediaLines NOT_OWNER = BuiltInDinopediaLines.createDinosaur("not_owner", dinosaur -> FAUtils.translation("dinopedia", "not_owner"), (dinosaur, player) -> dinosaur.isTame() && !dinosaur.isOwnedBy(player));
    public static final BuiltInDinopediaLines WILD = BuiltInDinopediaLines.createDinosaur("wild", dinosaur -> FAUtils.translation("dinopedia", "wild"), (dinosaur, player) -> !dinosaur.isTame());
    public static final BuiltInDinopediaLines EGG_DISPLAY_NAME = BuiltInDinopediaLines.createEgg("egg_display_name", egg -> FAUtils.translation("dinopedia", "egg", egg.getOffspringType().getDescription().getString()), BuiltInDinopediaLines::alwaysTrue);
    public static final BuiltInDinopediaLines REMAINING_TIME = BuiltInDinopediaLines.createEgg("remaining_time", egg -> FAUtils.translation("dinopedia", "remaining_time", (int) Math.floor((((float) egg.getRemainingTime()) / egg.maxTime()) * 100) + "%"), BuiltInDinopediaLines::alwaysTrue);
    public static final BuiltInDinopediaLines STATUS = BuiltInDinopediaLines.createEgg("status", egg -> FAUtils.translation("dinopedia", "status", egg.getTemperature()), BuiltInDinopediaLines::alwaysTrue);
    public static final BuiltInDinopediaLines PREGNANT_DISPLAY_NAME = BuiltInDinopediaLines.createPregnant("pregnant_display_name", PregnantAnimal::getPregnantDisplayName, (pregnantAnimal, player) -> true);
    public static final BuiltInDinopediaLines PREGNANT_HEALTH = BuiltInDinopediaLines.createPregnant("pregnant_health", pregnantAnimal -> FAUtils.translation("dinopedia", "health", (int) pregnantAnimal.getPregnantHealth(), (int) pregnantAnimal.getPregnantMaxHealth()), (pregnantAnimal, player) -> true);
    public static final BuiltInDinopediaLines PREGNANCY_TIME = BuiltInDinopediaLines.createPregnant("pregnancy_time", pregnantAnimal -> FAUtils.translation("dinopedia", "pregnancy_time", (int) Math.floor((((float) pregnantAnimal.getRemainingTime()) / pregnantAnimal.maxTime()) * 100) + "%"), (pregnantAnimal, player) -> true);
    public static final BuiltInDinopediaLines PREGNANCY_TYPE = BuiltInDinopediaLines.createPregnant("pregnancy_type", pregnantAnimal -> FAUtils.translation("dinopedia", "embryo", pregnantAnimal.getPregnancyType().value().getDescription().getString()), (pregnantAnimal, player) -> true);

    public static Map<String, BuiltInDinopediaLines> BY_NAME;

    public static final MapCodec<BuiltInDinopediaLines> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("name").forGetter(builtInDinopediaLines -> builtInDinopediaLines.name)).apply(instance, BY_NAME::get));

    public static BuiltInDinopediaLines createDinosaur(String name, Function<Dinosaur, Component> line, BiFunction<Dinosaur, Player, Boolean> condition) {
        return BuiltInDinopediaLines.register(name, new BuiltInDinopediaLines(name) {
            @Override
            public boolean canUseLine(Entity entity, Player player) {
                if (entity instanceof Dinosaur dinosaur) {
                    return condition.apply(dinosaur, player);
                }
                return false;
            }

            @Override
            public Component getLine(Entity entity) {
                if (entity instanceof Dinosaur dinosaur) {
                    return line.apply(dinosaur);
                }
                return Component.empty();
            }
        });
    }

    public static BuiltInDinopediaLines createEgg(String name, Function<Egg, Component> line, BiFunction<Egg, Player, Boolean> condition) {
        return BuiltInDinopediaLines.register(name, new BuiltInDinopediaLines(name) {
            @Override
            public boolean canUseLine(Entity entity, Player player) {
                if (entity instanceof Egg egg) {
                    return condition.apply(egg, player);
                }
                return false;
            }

            @Override
            public Component getLine(Entity entity) {
                if (entity instanceof Egg egg) {
                    return line.apply(egg);
                }
                return Component.empty();
            }
        });
    }

    public static BuiltInDinopediaLines createPregnant(String name, Function<PregnantAnimal<?>, Component> line, BiFunction<PregnantAnimal<?>, Player, Boolean> condition) {
        return BuiltInDinopediaLines.register(name, new BuiltInDinopediaLines(name) {
            @Override
            public boolean canUseLine(Entity entity, Player player) {
                if (entity instanceof PregnantAnimal<?> pregnantAnimal) {
                    return condition.apply(pregnantAnimal, player);
                }
                return false;
            }

            @Override
            public Component getLine(Entity entity) {
                if (entity instanceof PregnantAnimal<?> pregnantAnimal) {
                    return line.apply(pregnantAnimal);
                }
                return Component.empty();
            }
        });
    }

    public static <T extends Entity> BuiltInDinopediaLines register(String name, BuiltInDinopediaLines builtInDinopediaLines) {
        if (BuiltInDinopediaLines.BY_NAME == null) {
            BuiltInDinopediaLines.BY_NAME = new HashMap<>();
        }
        BuiltInDinopediaLines.BY_NAME.put(name, builtInDinopediaLines);
        return builtInDinopediaLines;
    }

    private final String name;

    public BuiltInDinopediaLines(String name) {
        this.name = name;
    }

    public boolean canUseLine(Entity entity, Player player) {
        return false;
    }

    public Component getLine(Entity entity) {
        return Component.empty();
    }

    @Override
    public DinopediaLineType<?> type() {
        return FADinopediaLineTypes.BUILT_IN.get();
    }

    @Override
    public void addText(List<Component> text, Entity entity, Player player) {
        if (this.canUseLine(entity, player)) {
            text.add(this.getLine(entity));
        }
    }

    private static boolean alwaysTrue(Entity entity, Player player) {
        return true;
    }

    private static boolean ownerCondition(Dinosaur dinosaur, Player player) {
        return dinosaur.isTame() && dinosaur.isOwnedBy(player);
    }

    private static boolean ownerCondition(Dinosaur dinosaur, Player player, boolean additional) {
        return dinosaur.isTame() && dinosaur.isOwnedBy(player) && additional;
    }
}
