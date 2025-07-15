package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.block.entity.entities.CageBlockEntity;

public class BoltCutterItem extends Item {
    public BoltCutterItem(Properties properties) {
        super(properties.durability(46));
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        BlockPos blockPos = useOnContext.getClickedPos();
        Level level = useOnContext.getLevel();
        if (level.getBlockEntity(blockPos) instanceof CageBlockEntity cageBlockEntity && cageBlockEntity.getLock() != null) {
            Player player = useOnContext.getPlayer();
            ItemStack itemStack = useOnContext.getItemInHand();
            cageBlockEntity.setLock(null);
            itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            level.playSound(player, blockPos, SoundEvents.ITEM_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResult.SUCCESS;
        }
        return super.useOn(useOnContext);
    }
}
