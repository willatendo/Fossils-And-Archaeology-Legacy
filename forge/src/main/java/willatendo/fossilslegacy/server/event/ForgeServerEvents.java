package willatendo.fossilslegacy.server.event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import willatendo.fossilslegacy.client.FossilsLegacyClient;
import willatendo.fossilslegacy.server.entity.AncientLightningBolt;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FossilsLegacyUtils.ID)
public class ForgeServerEvents {
    @SubscribeEvent
    public static void pigmanCreation(EntityStruckByLightningEvent event) {
        if (event.getLightning() instanceof AncientLightningBolt ancientLightningBolt) {
            if (event.getEntity() instanceof Pig pig) {
                event.setCanceled(true);
                Level level = ancientLightningBolt.level();
                TamedZombifiedPiglin tamedZombifiedPiglin = FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get().create(level);
                tamedZombifiedPiglin.tame(((Player) ancientLightningBolt.getOwner()));
                tamedZombifiedPiglin.setItemInHand(InteractionHand.MAIN_HAND, FossilsLegacyItems.ANCIENT_SWORD.get().getDefaultInstance());
                tamedZombifiedPiglin.setItemSlot(EquipmentSlot.HEAD, FossilsLegacyItems.ANCIENT_HELMET.get().getDefaultInstance());
                tamedZombifiedPiglin.moveTo(pig.getX(), pig.getY(), pig.getZ());
                tamedZombifiedPiglin.setHealth(tamedZombifiedPiglin.getMaxHealth());
                level.addFreshEntity(tamedZombifiedPiglin);
                pig.discard();
            }
        }
    }
}
