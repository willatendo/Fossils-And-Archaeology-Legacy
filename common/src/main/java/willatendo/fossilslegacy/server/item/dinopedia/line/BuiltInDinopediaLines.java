package willatendo.fossilslegacy.server.item.dinopedia.line;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.RideableDinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BuiltInDinopediaLines implements DinopediaLine {
    public static final BuiltInDinopediaLines DISPLAY_NAME = BuiltInDinopediaLines.create("display_name", Entity::getDisplayName, BuiltInDinopediaLines::alwaysTrue);
    public static final BuiltInDinopediaLines OWNER = BuiltInDinopediaLines.create("owner", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "owner", dinosaur.getOwner() != null ? dinosaur.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("dinopedia", "wild").getString()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines AGE = BuiltInDinopediaLines.create("age", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "age", dinosaur.getDaysAlive()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines HEALTH = BuiltInDinopediaLines.create("health", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "health", (int) dinosaur.getHealth(), (int) dinosaur.getMaxHealth()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines HUNGER = BuiltInDinopediaLines.create("hunger", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "hunger", dinosaur.getHunger(), dinosaur.getMaxHunger()), BuiltInDinopediaLines::ownerCondition);
    public static final BuiltInDinopediaLines RIDEABLE = BuiltInDinopediaLines.create("rideable", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "rideable"), (dinosaur, player) -> BuiltInDinopediaLines.ownerCondition(dinosaur, player, dinosaur instanceof RideableDinosaur rideableDinosaur && dinosaur.getAge() >= rideableDinosaur.getMinRideableAge()));
    public static final BuiltInDinopediaLines ABLE_TO_FLY = BuiltInDinopediaLines.create("able_to_fly", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "able_to_fly"), (dinosaur, player) -> BuiltInDinopediaLines.ownerCondition(dinosaur, player, dinosaur instanceof RideableDinosaur rideableDinosaur && dinosaur.getAge() >= rideableDinosaur.getMinRideableAge()));
    public static final BuiltInDinopediaLines DANGEROUS = BuiltInDinopediaLines.create("dangerous", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "dangerous"), (dinosaur, player) -> dinosaur.getAge() > 3);
    public static final BuiltInDinopediaLines NOT_OWNER = BuiltInDinopediaLines.create("not_owner", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "not_owner"), (dinosaur, player) -> dinosaur.isTame() && !dinosaur.isOwnedBy(player));
    public static final BuiltInDinopediaLines WILD = BuiltInDinopediaLines.create("wild", dinosaur -> FossilsLegacyUtils.translation("dinopedia", "wild"), (dinosaur, player) -> !dinosaur.isTame());

    public static Map<String, BuiltInDinopediaLines> BY_NAME;

    public static final MapCodec<BuiltInDinopediaLines> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("name").forGetter(builtInDinopediaLines -> builtInDinopediaLines.name)).apply(instance, BY_NAME::get));

    public static BuiltInDinopediaLines create(String name, Function<Dinosaur, Component> line, BiFunction<Dinosaur, Player, Boolean> condition) {
        BuiltInDinopediaLines builtInDinopediaLines = new BuiltInDinopediaLines(name) {
            @Override
            public boolean canUseLine(Dinosaur dinosaur, Player player) {
                return condition.apply(dinosaur, player);
            }

            @Override
            public Component getLine(Dinosaur dinosaur) {
                return line.apply(dinosaur);
            }
        };
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

    public boolean canUseLine(Dinosaur dinosaur, Player player) {
        return false;
    }

    public Component getLine(Dinosaur dinosaur) {
        return Component.empty();
    }

    @Override
    public DinopediaLineType<?> type() {
        return FossilsLegacyDinopediaLineTypes.BUILT_IN.get();
    }

    @Override
    public void addText(List<Component> text, Dinosaur dinosaur, Player player) {
        if (this.canUseLine(dinosaur, player)) {
            text.add(this.getLine(dinosaur));
        }
    }

    private static boolean alwaysTrue(Dinosaur dinosaur, Player player) {
        return true;
    }

    private static boolean ownerCondition(Dinosaur dinosaur, Player player) {
        return dinosaur.isTame() && dinosaur.isOwnedBy(player);
    }

    private static boolean ownerCondition(Dinosaur dinosaur, Player player, boolean additional) {
        return dinosaur.isTame() && dinosaur.isOwnedBy(player) && additional;
    }
}
