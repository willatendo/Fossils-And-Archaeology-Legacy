package willatendo.fossilslegacy.server.item.items;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.tags.FABlockTags;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class AncientHoeItem extends DiggerItem {
    public AncientHoeItem(ToolMaterial tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, FABlockTags.MINEABLE_WITH_ANCIENT_HOE, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = HoeItem.TILLABLES.get(level.getBlockState(blockPos).getBlock());
        if (pair == null) {
            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.getBlock() instanceof CropBlock cropBlock) {
                if (blockState.getValue(CropBlock.AGE) == cropBlock.getMaxAge()) {
                    Block.dropResources(blockState, level, blockPos);
                    Block.dropResources(blockState, level, blockPos);
                    level.playLocalSound(blockPos, blockState.getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
                    level.setBlock(blockPos, blockState.setValue(CropBlock.AGE, 0), 3);
                    itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                    return InteractionResult.SUCCESS;
                }
            }

            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(useOnContext)) {
                level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(useOnContext);
                    if (player != null) {
                        itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(useOnContext.getHand()));
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        return super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
    }
}
