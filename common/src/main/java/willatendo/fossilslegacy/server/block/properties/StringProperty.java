package willatendo.fossilslegacy.server.block.properties;

import com.google.common.collect.Maps;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class StringProperty extends Property<String> {
    private final Map<String, Integer> valuesToIndex = Maps.newHashMap();
    private final List<String> values = new ArrayList<>();

    private StringProperty(String name, String... values) {
        super(name, String.class);
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            this.valuesToIndex.put(value, i);
            this.values.add(value);
        }
    }

    public static StringProperty create(String name, String... values) {
        return new StringProperty(name, values);
    }

    @Override
    public List<String> getPossibleValues() {
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

    @Override
    public int getInternalIndex(String string) {
        return this.valuesToIndex.get(string);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else {
            if (object instanceof StringProperty stringProperty) {
                if (super.equals(object)) {
                    return this.valuesToIndex.equals(stringProperty.valuesToIndex);
                }
            }

            return false;
        }
    }
}
