package willatendo.fossilslegacy.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

@Mixin(Sheep.class)
public abstract class SheepMixin extends Animal implements Shearable {
	public SheepMixin(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}

	@Inject(at = @At("HEAD"), method = "mobInteract", cancellable = true)
	private void fLInject_shears(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> interactionResult) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (itemStack.is(FossilsLegacyItems.TOOTH_DAGGER.get())) {
			if (!this.level().isClientSide && this.readyForShearing()) {
				this.shear(SoundSource.PLAYERS);
				this.gameEvent(GameEvent.SHEAR, player);
				itemStack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(interactionHand));
				interactionResult.setReturnValue(InteractionResult.SUCCESS);
			}
			player.swing(interactionHand);
			interactionResult.setReturnValue(InteractionResult.CONSUME);
		}
	}
}
