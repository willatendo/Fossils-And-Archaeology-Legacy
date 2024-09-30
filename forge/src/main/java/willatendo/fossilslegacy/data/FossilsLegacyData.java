package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class FossilsLegacyData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        DataGenerator dataGenerator = gatherDataEvent.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = gatherDataEvent.getLookupProvider();

        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyForgeBuiltinProvider(packOutput, registries, FossilsLegacyUtils.ID));
        FossilsLegacyForgeBlockTagProvider fossilsLegacyForgeBlockTagProvider = new FossilsLegacyForgeBlockTagProvider(packOutput, registries, FossilsLegacyUtils.ID, existingFileHelper);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), fossilsLegacyForgeBlockTagProvider);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FossilsLegacyForgeItemTagProvider(packOutput, registries, fossilsLegacyForgeBlockTagProvider.contentsGetter(), FossilsLegacyUtils.ID, existingFileHelper));
    }
}
