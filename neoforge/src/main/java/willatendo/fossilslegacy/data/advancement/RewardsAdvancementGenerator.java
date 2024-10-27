package willatendo.fossilslegacy.data.advancement;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.core.HolderLookup;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Consumer;

public class RewardsAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> advancementHolderConsumer, ExistingFileHelper existingFileHelper) {
        AdvancementHolder rewardsRoot = Advancement.Builder.advancement().addCriterion("impossible", CriteriaTriggers.IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance())).save(advancementHolderConsumer, FossilsLegacyUtils.resource("rewards/root").toString());
        Advancement.Builder.advancement().parent(rewardsRoot).addCriterion("killed_anu", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(FossilsLegacyEntityTypes.ANU.get()))).save(advancementHolderConsumer, FossilsLegacyUtils.resource("rewards/legacy_models").toString());
    }
}
