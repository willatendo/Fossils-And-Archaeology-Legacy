package willatendo.fossilslegacy.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.WrapWithCondition;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import willatendo.fossilslegacy.server.event.ModCallbacks;

@Mixin(LightningBolt.class)
public class LightningBoltMixin {
	@WrapWithCondition(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;thunderHit(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LightningBolt;)V"))
	private boolean shouldStrikeEntity(Entity entity, ServerLevel level, LightningBolt lightningBolt) {
		return ModCallbacks.ENTITY_STRUCK_BY_LIGHTING.invoker().onEntityStruckByLightning(entity, lightningBolt);
	}
}
