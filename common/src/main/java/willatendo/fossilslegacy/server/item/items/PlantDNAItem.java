package willatendo.fossilslegacy.server.item.items;

import willatendo.fossilslegacy.server.item.GeologicalTimeScale;

public class PlantDNAItem extends DNAItem {
    public PlantDNAItem(GeologicalTimeScale.Period period, Properties properties) {
        super(period, DNAItem.EmbryoType.PLANT, properties);
    }
}
