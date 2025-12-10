package willatendo.fossilslegacy.server.item.items;

import willatendo.fossilslegacy.server.item.GeologicalTimeScale;

public class PlantDNAItem extends DNAItem {
    public PlantDNAItem(GeologicalTimeScale.TimeScaleDescription timeScaleDescription, Properties properties) {
        super(timeScaleDescription, DNAItem.EmbryoType.PLANT, properties);
    }
}
