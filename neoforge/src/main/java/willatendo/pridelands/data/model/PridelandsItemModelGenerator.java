package willatendo.pridelands.data.model;

import net.minecraft.client.data.models.ItemModelGenerators;
import willatendo.pridelands.server.item.PridelandsItems;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.data.model.SimpleItemModelGenerator;

public class PridelandsItemModelGenerator extends SimpleItemModelGenerator {
    public PridelandsItemModelGenerator(ItemModelGenerators itemModelGenerators) {
        super(itemModelGenerators, PridelandsUtils.ID);
    }

    @Override
    public void run() {
        this.generatedItem(PridelandsItems.LION.get());
        this.generatedItem(PridelandsItems.COOKED_LION.get());
        this.generatedItem(PridelandsItems.MANGO.get());
        this.generatedItem(PridelandsItems.CHOCOLATE_MUFASA.get());
        this.generatedItem(PridelandsItems.ZEBRA.get());
        this.generatedItem(PridelandsItems.COOKED_ZEBRA.get());
        this.generatedItem(PridelandsItems.RHINO.get());
        this.generatedItem(PridelandsItems.COOKED_RHINO.get());
        this.generatedItem(PridelandsItems.MANGO_JUICE_PRIDESTONE_JAR.get());
        this.generatedItem(PridelandsItems.CORN.get());
        this.generatedItem(PridelandsItems.POPCORN.get());
        this.generatedItem(PridelandsItems.OUTLANDER.get());
        this.generatedItem(PridelandsItems.BUG_STEW.get());
        this.generatedItem(PridelandsItems.CROCODILE.get());
        this.generatedItem(PridelandsItems.KIWANO_SLICE.get());
        this.generatedItem(PridelandsItems.YAM.get());
        this.generatedItem(PridelandsItems.ROASTED_YAM.get());
        this.generatedItem(PridelandsItems.BANANA.get());
        this.generatedItem(PridelandsItems.BANANA_BREAD.get());
        this.handheldItem(PridelandsItems.HYENA_BONE.get());
        this.generatedItem(PridelandsItems.BLUE_FEATHER.get());
        this.generatedItem(PridelandsItems.YELLOW_FEATHER.get());
        this.generatedItem(PridelandsItems.RED_FEATHER.get());
        this.generatedItem(PridelandsItems.HYENA_BONE_SHARD.get());
        this.generatedItem(PridelandsItems.ZEBRA_HIDE.get());
        this.generatedItem(PridelandsItems.SILVER_INGOT.get());
        this.generatedItem(PridelandsItems.GROUND_TERMITE.get());
        this.generatedItem(PridelandsItems.LION_FUR.get());
        this.generatedItem(PridelandsItems.RHINO_HORN.get());
        this.generatedItem(PridelandsItems.GROUND_RHINO_HORN.get());
        this.generatedItem(PridelandsItems.GEMSBOK_HIDE.get());
        this.generatedItem(PridelandsItems.GEMSBOK_HORN.get());
        this.generatedItem(PridelandsItems.PEACOCK_GEM.get());
        this.generatedItem(PridelandsItems.MAIZE_STALKS.get());
        this.generatedItem(PridelandsItems.NUKA_SHARD.get());
        this.generatedItem(PridelandsItems.OUTLANDER_FUR.get());
        this.generatedItem(PridelandsItems.KIVULITE_INGOT.get());
        this.generatedItem(PridelandsItems.POISON_POWDER.get());
        this.generatedItem(PridelandsItems.ZAZU_EGG.get());
        this.generatedItem(PridelandsItems.KIWANO_SEEDS.get());
        this.generatedItem(PridelandsItems.FLAMINGO_FEATHER.get());
        this.generatedItem(PridelandsItems.HYENA_MEAL.get());
        this.generatedItem(PridelandsItems.CORN_KERNELS.get());
        this.generatedItem(PridelandsItems.DRIED_MAIZE.get());
        this.generatedItem(PridelandsItems.PRIDESTONE_JAR.get());
        this.generatedItem(PridelandsItems.WATER_PRIDESTONE_JAR.get());
        this.generatedItem(PridelandsItems.LAVA_PRIDESTONE_JAR.get());
        this.generatedItem(PridelandsItems.ZEBRA_MILK_PRIDESTONE_JAR.get());
        this.generatedItem(PridelandsItems.C_NOTE.get());
        this.generatedItem(PridelandsItems.D_NOTE.get());
        this.generatedItem(PridelandsItems.E_NOTE.get());
        this.generatedItem(PridelandsItems.F_NOTE.get());
        this.generatedItem(PridelandsItems.G_NOTE.get());
        this.generatedItem(PridelandsItems.A_NOTE.get());
        this.generatedItem(PridelandsItems.B_NOTE.get());
        this.handheldItem(PridelandsItems.PRIDESTONE_SWORD.get());
        this.handheldItem(PridelandsItems.PRIDESTONE_SHOVEL.get());
        this.handheldItem(PridelandsItems.PRIDESTONE_PICKAXE.get());
        this.handheldItem(PridelandsItems.PRIDESTONE_AXE.get());
        this.handheldItem(PridelandsItems.PRIDESTONE_HOE.get());
        this.handheldItem(PridelandsItems.SILVER_SWORD.get());
        this.handheldItem(PridelandsItems.SILVER_SHOVEL.get());
        this.handheldItem(PridelandsItems.SILVER_PICKAXE.get());
        this.handheldItem(PridelandsItems.SILVER_AXE.get());
        this.handheldItem(PridelandsItems.SILVER_HOE.get());
        this.handheldItem(PridelandsItems.PEACOCK_SWORD.get());
        this.handheldItem(PridelandsItems.PEACOCK_SHOVEL.get());
        this.handheldItem(PridelandsItems.PEACOCK_PICKAXE.get());
        this.handheldItem(PridelandsItems.PEACOCK_AXE.get());
        this.handheldItem(PridelandsItems.PEACOCK_HOE.get());
        this.generatedItem(PridelandsItems.LION_KING_TICKET.get());
    }
}
