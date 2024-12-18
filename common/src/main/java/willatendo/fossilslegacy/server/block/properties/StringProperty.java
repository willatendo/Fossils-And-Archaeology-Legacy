package willatendo.fossilslegacy.server.block.properties;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StringProperty extends Property<String> {
    private final List<String> values = Lists.newArrayList();

    private StringProperty(String name, String... values) {
        super(name, String.class);
        this.values.addAll(List.of(values));
    }

    public static StringProperty create(String name, String... values) {
        return new StringProperty(name, values);
    }

    @Override
    public Collection<String> getPossibleValues() {
        return this.values;
    }

    @Override
    public String getName(String string) {
        return string;
    }

    @Override
    public Optional<String> getValue(String string) {
        return Optional.of(string);
    }
}
