package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FAUtils.ID)
public class FossilsLegacyData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        DataGenerator dataGenerator = gatherDataEvent.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = gatherDataEvent.getLookupProvider();

        dataGenerator.addProvider(gatherDataEvent.includeServer(), new FAForgeBuiltinProvider(packOutput, registries, FAUtils.ID));
    }
}
