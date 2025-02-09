package willatendo.fossilslegacy.data.legacy;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class FALegacyModelProvider extends ModelProvider {
    public FALegacyModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators) {
        this.generateBlockModels(blockModelGenerators);
    }

    private void generateBlockModels(BlockModelGenerators blockModelGenerators) {
    }
}
