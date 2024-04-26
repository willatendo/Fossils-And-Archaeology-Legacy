package willatendo.fossilslegacy.experiments.server.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import willatendo.fossilslegacy.experiments.server.entity.type.ExperimentalEntityType;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class FossilsExperimentsEntityTypes {
    public static final SimpleHolder<ExperimentalEntityType<Carnotaurus>> CARNOTAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("carnotaurus", () -> ExperimentalEntityType.Builder.<Carnotaurus>of(Carnotaurus::new, MobCategory.CREATURE).sized(0.5F, 0.75F).build());
    public static final SimpleHolder<ExperimentalEntityType<Cryolophosaurus>> CRYOLOPHOSAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("cryolophosaurus", () -> ExperimentalEntityType.Builder.<Cryolophosaurus>of(Cryolophosaurus::new, MobCategory.CREATURE).sized(0.5F, 0.75F).build());
    public static final SimpleHolder<ExperimentalEntityType<Therizinosaurus>> THERIZINOSAURUS = FossilsLegacyEntityTypes.ENTITY_TYPES.register("therizinosaurus", () -> ExperimentalEntityType.Builder.<Therizinosaurus>of(Therizinosaurus::new, MobCategory.CREATURE).sized(0.5F, 0.75F).build());

    public static void init() {
    }
}
