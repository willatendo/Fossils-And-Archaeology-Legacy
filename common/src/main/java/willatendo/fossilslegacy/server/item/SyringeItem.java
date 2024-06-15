package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.entity.util.HungryAnimal;
import willatendo.fossilslegacy.server.entity.util.PregnantAnimal;
import willatendo.fossilslegacy.server.entity.util.TameAccessor;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;

public class SyringeItem extends Item {
    private final Holder<PregnancyType> pregnancyType;

    public SyringeItem(Holder<PregnancyType> pregnancyType, Properties properties) {
        super(properties);
        this.pregnancyType = pregnancyType;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (PregnantAnimal.getFromLivingEntity(livingEntity, player.level()) != null) {
            if (livingEntity instanceof AgeableMob ageableMob) {
                if (!ageableMob.isBaby()) {
                    PregnantAnimal<?> pregnantAnimal = PregnantAnimal.createFromLiving(livingEntity, player.level());
                    pregnantAnimal.setPregnancyType(this.getPregnancyType());
                    pregnantAnimal.setRemainingPregnancyTime(0);
                    if (pregnantAnimal instanceof HungryAnimal hungryAnimal) {
                        hungryAnimal.setHunger(((HungryAnimal) pregnantAnimal).getHunger());
                    }
                    if (pregnantAnimal instanceof TameAccessor tameAccessor) {
                        tameAccessor.setOwnerUUID(((TameAccessor) pregnantAnimal).getOwnerUUID());
                    }
                    itemStack.shrink(1);
                    return InteractionResult.sidedSuccess(player.level().isClientSide());
                } else {
                    return InteractionResult.PASS;
                }
            } else {
                PregnantAnimal<?> pregnantAnimal = PregnantAnimal.createFromLiving(livingEntity, player.level());
                pregnantAnimal.setPregnancyType(this.getPregnancyType());
                pregnantAnimal.setRemainingPregnancyTime(0);
                if (pregnantAnimal instanceof HungryAnimal hungryAnimal) {
                    hungryAnimal.setHunger(((HungryAnimal) pregnantAnimal).getHunger());
                }
                if (pregnantAnimal instanceof TameAccessor tameAccessor) {
                    tameAccessor.setOwnerUUID(((TameAccessor) pregnantAnimal).getOwnerUUID());
                }
                itemStack.shrink(1);
                return InteractionResult.sidedSuccess(player.level().isClientSide());
            }
        }
        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }

    public Holder<PregnancyType> getPregnancyType() {
        return this.pregnancyType;
    }
}
