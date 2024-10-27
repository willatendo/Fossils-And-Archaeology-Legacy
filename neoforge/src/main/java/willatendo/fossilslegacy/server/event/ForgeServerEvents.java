package willatendo.fossilslegacy.server.event;

import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.client.PlayerUnlockedCoatTypesHelper;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.entity.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.genetics.cosmetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.tags.FossilsLegacyCoatTypeTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = FossilsLegacyUtils.ID)
public class ForgeServerEvents {
    @SubscribeEvent
    public static void entityStruckByLightningEvent(EntityStruckByLightningEvent event) {
        if (event.getLightning() instanceof AncientLightningBolt ancientLightningBolt) {
            if (event.getEntity() instanceof Pig pig) {
                event.setCanceled(true);
                Level level = ancientLightningBolt.level();
                TamedZombifiedPiglin tamedZombifiedPiglin = FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get().create(level);
                Player player = (Player) ancientLightningBolt.getOwner();
                tamedZombifiedPiglin.tame(player);
                tamedZombifiedPiglin.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
                tamedZombifiedPiglin.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
                tamedZombifiedPiglin.moveTo(pig.getX(), pig.getY(), pig.getZ());
                tamedZombifiedPiglin.setHealth(tamedZombifiedPiglin.getMaxHealth());
                level.addFreshEntity(tamedZombifiedPiglin);
                if (player instanceof ServerPlayer serverPlayer) {
                    FossilsLegacyCriteriaTriggers.TAME_ZOMBIFIED_PIGMAN.get().trigger(serverPlayer, tamedZombifiedPiglin);
                }
                pig.discard();
            }
        }
    }
}
