package willatendo.fossilslegacy.server.item.items;

import willatendo.fossilslegacy.server.item.GeologicalTimeScale;

public class PlantDNAItem extends DNAItem {
    public PlantDNAItem(GeologicalTimeScale.EraDescription eraDescription, Properties properties) {
        super(eraDescription, DNAItem.EmbryoType.PLANT, properties);
    }
}
