package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FossilsLegacyItemModelProvider extends ItemModelProvider implements FossilsDataProvider.BasicItemModelsProvider {
    public FossilsLegacyItemModelProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        FossilsDataProvider.addItemModels(this);
    }

    @Override
    public String getModId() {
        return this.modid;
    }

    @Override
    public void basicItem(ItemLike itemLike, ResourceLocation texture) {
        Item item = itemLike.asItem();
        this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", texture);
    }

    @Override
    public void handheldItem(ItemLike itemLike, ResourceLocation texture) {
        Item item = itemLike.asItem();
        this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/handheld")).texture("layer0", texture);
    }

    @Override
    public void spawnEggItem(ItemLike itemLike, ResourceLocation texture) {
        Item item = itemLike.asItem();
        this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }

    @Override
    public void blockItem(ItemLike itemLike, ResourceLocation model) {
        Item item = itemLike.asItem();
        this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(model));
    }
}
