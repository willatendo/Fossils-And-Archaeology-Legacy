package willatendo.fossilslegacy.server.block.properties;

import com.google.common.collect.Maps;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StringProperty extends Property<String> {
    private final Map<String, Integer> values = Maps.newHashMap();

    private StringProperty(String name, String... values) {
        super(name, String.class);
        for (int i = 0; i < values.length; i++) {
            this.values.put(values[i], i);
        }
    }

    public static StringProperty create(String name, String... values) {
        return new StringProperty(name, values);
    }

    @Override
    public List<String> getPossibleValues() {
        return this.values.keySet().stream().toList();
    }

    @Override
    public String getName(String string) {
        return string;
    }

    @Override
    public Optional<String> getValue(String string) {
        return Optional.of(string);
    }

    @Override
    public int getInternalIndex(String s) {
        return this.values.get(s);
    }
}
