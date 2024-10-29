package willatendo.fossilslegacy.server.entity.dinosaur.guadalupian;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEggVariants;
import willatendo.fossilslegacy.server.entity.util.DinoUtils;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandingType;
import willatendo.fossilslegacy.server.entity.util.interfaces.Diet;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class Dimetrodon extends Dinosaur implements DinopediaInformation {
    public Dimetrodon(EntityType<? extends Dimetrodon> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier dimetrodonAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.ATTACK_DAMAGE, 4.0D).build();
    }

    @Override
    public float maxUpStep() {
        return DinoUtils.getStepHeights(12, 0.5F, 1.0F)[this.getGrowthStage()];
    }

    @Override
    public int getMaxHunger() {
        return 500;
    }

    @Override
    public Diet getDiet() {
        return Diet.carnivore(this.level());
    }

    @Override
    public TagKey<CoatType> getCoatTypes() {
        return FossilsLegacyCoatTypeTags.DIMETRODON;
    }

    @Override
    public Holder<EggVariant> getEggVariant() {
        return FossilsLegacyEggVariants.DIMETRODON;
    }

    @Override
    public int getMaxGrowthStage() {
        return 12;
    }

    @Override
    public double getMinHealth() {
        return 10.0F;
    }

    @Override
    public CommandingType commandItems() {
        return CommandingType.tag(FossilsLegacyItemTags.DIMETRODON_COMMANDABLES);
    }

    @Override
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        if (this.isTame() && this.isOwnedBy(player)) {
            information.add(this.getDisplayName());
            information.add(FossilsLegacyUtils.translation("dinopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "age", this.getDaysAlive()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
            information.add(FossilsLegacyUtils.translation("dinopedia", "hunger", this.getHunger(), this.getMaxHunger()));
        } else {
            information.add(this.getDisplayName());
            if (this.isTame()) {
                information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
            } else {
                information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
            }
        }
        return information;
    }
}
