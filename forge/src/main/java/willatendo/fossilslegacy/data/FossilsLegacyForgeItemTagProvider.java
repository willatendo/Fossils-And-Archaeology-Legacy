package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.util.TagRegister;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyForgeItemTagProvider extends ItemTagsProvider {
    private static final TagRegister<Item> FORGE_TAGS = TagRegister.create(Registries.ITEM, "forge");
    private static final TagKey<Item> EGGS = FORGE_TAGS.register("eggs");
    private static final TagKey<Item> BUCKETS = FORGE_TAGS.register("buckets");
    private static final TagKey<Item> GEMS = FORGE_TAGS.register("gems");
    private static final TagKey<Item> TOOLS = FORGE_TAGS.register("tools");
    private static final TagKey<Item> BONES = FORGE_TAGS.register("bones");
    private static final TagKey<Item> SEEDS = FORGE_TAGS.register("seeds");
    private static final TagKey<Item> SHEARS = FORGE_TAGS.register("shears");
    private static final TagKey<Item> FENCE_GATES_WOODEN = FORGE_TAGS.register("fence_gates/wooden");

    public FossilsLegacyForgeItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tagEquipment(FossilsLegacyItems.SCARAB_GEM_SWORD.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_HELMET.get(), FossilsLegacyItems.SCARAB_GEM_CHESTPLATE.get(), FossilsLegacyItems.SCARAB_GEM_LEGGINGS.get(), FossilsLegacyItems.SCARAB_GEM_BOOTS.get());
        this.tagEquipment(FossilsLegacyItems.ANCIENT_SWORD.get(), FossilsLegacyItems.ANCIENT_PICKAXE.get(), FossilsLegacyItems.ANCIENT_AXE.get(), FossilsLegacyItems.ANCIENT_SHOVEL.get(), FossilsLegacyItems.ANCIENT_HOE.get(), FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), FossilsLegacyItems.ANCIENT_BOOTS.get());

        this.tag(FossilsLegacyForgeItemTagProvider.BUCKETS).add(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        this.tag(FossilsLegacyForgeItemTagProvider.SEEDS).add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        this.tag(FossilsLegacyForgeItemTagProvider.SHEARS).add(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get());
        this.tag(FossilsLegacyForgeItemTagProvider.EGGS).addTags(FossilsLegacyItemTags.CAKE_EGGS);
        this.tag(FossilsLegacyForgeItemTagProvider.GEMS).add(FossilsLegacyItems.SCARAB_GEM.get());
        this.tag(FossilsLegacyForgeItemTagProvider.BONES).add(FossilsLegacyItems.FOSSIL.get());
        this.tag(FossilsLegacyForgeItemTagProvider.FENCE_GATES_WOODEN).add(FossilsLegacyItems.LEPIDODENDRON_FENCE_GATE, FossilsLegacyItems.SIGILLARIA_FENCE_GATE, FossilsLegacyItems.CALAMITES_FENCE_GATE);
    }

    private void tagEquipment(Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item helmet, Item chestplate, Item leggings, Item boots) {
        this.tag(FossilsLegacyForgeItemTagProvider.TOOLS).add(sword, pickaxe, axe, shovel, hoe);
    }
}
