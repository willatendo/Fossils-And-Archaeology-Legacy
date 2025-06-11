package willatendo.missinglinks.data.model;

import net.minecraft.client.data.models.ItemModelGenerators;
import willatendo.missinglinks.server.util.MissingLinks2Utils;
import willatendo.simplelibrary.data.model.SimpleItemModelGenerator;

public class MissingItemModelGenerator extends SimpleItemModelGenerator {
    public MissingItemModelGenerator(ItemModelGenerators itemModelGenerators) {
        super(itemModelGenerators, MissingLinks2Utils.ID);
    }

    @Override
    public void run() {

    }
}
