package willatendo.fossilslegacy.server.item.items;

import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.tags.FAModelGeneTags;

public class VelociraptorEggItem extends EggItem {
    public VelociraptorEggItem(GeologicalTimeScale.Period period, Properties properties) {
        super(FAEntityTypes.VELOCIRAPTOR_EGG::get, period, FAModelGeneTags.NON_LEGACY_VELOCIRAPTOR, properties);
    }
}
