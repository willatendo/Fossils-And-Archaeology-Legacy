package willatendo.fossilslegacy.experiments.server.entity;

import willatendo.fossilslegacy.experiments.server.item.FossilsExperimentsItems;
import willatendo.fossilslegacy.server.entity.EggVariant;
import willatendo.simplelibrary.server.registry.SimpleHolder;

import static willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants.register;

public class FossilsExperimentsEggVariants {
    public static final SimpleHolder<EggVariant> CARNOTAURUS = register("carnotaurus", () -> FossilsExperimentsEntityTypes.CARNOTAURUS.get(), () -> FossilsExperimentsItems.CARNOTAURUS_EGG.get());
    public static final SimpleHolder<EggVariant> CRYOLOPHOSAURUS = register("cryolophosaurus", () -> FossilsExperimentsEntityTypes.CRYOLOPHOSAURUS.get(), () -> FossilsExperimentsItems.CARNOTAURUS_EGG.get());
    public static final SimpleHolder<EggVariant> THERIZINOSAURUS = register("therizinosaurus", () -> FossilsExperimentsEntityTypes.THERIZINOSAURUS.get(), () -> FossilsExperimentsItems.THERIZINOSAURUS_EGG.get());

    public static void init() {
    }
}
