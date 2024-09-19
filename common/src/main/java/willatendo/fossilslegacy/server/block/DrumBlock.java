package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.fossilslegacy.server.entity.util.CommandType;
import willatendo.fossilslegacy.server.entity.util.interfaces.PlayerCommandableAccess;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class DrumBlock extends Block {
    public static final IntegerProperty DINOSAUR_ORDER = IntegerProperty.create("order", 1, 3);

    public DrumBlock(Properties properties) {
        super(properties);
        this.stateDefinition.any().setValue(DINOSAUR_ORDER, 1);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (itemStack.is(FossilsLegacyItemTags.DRUM_INSTRUMENT)) {
            CommandType current = CommandType.get(blockState.getValue(DrumBlock.DINOSAUR_ORDER));
            List<LivingEntity> allEntities = level.getEntitiesOfClass(LivingEntity.class, new AABB(blockPos).inflate(30.0D));
            for (LivingEntity livingEntity : allEntities) {
                if (livingEntity instanceof PlayerCommandableAccess playerCommandableAccess) {
                    if (playerCommandableAccess.willListenToDrum(player, interactionHand)) {
                        playerCommandableAccess.setCommand(CommandType.get(blockState.getValue(DINOSAUR_ORDER)));
                    }
                }
            }
            player.displayClientMessage(FossilsLegacyUtils.translation("block", "drum.hit", itemStack.getHoverName(), current.getComponent()), true);
            if (level.isClientSide()) {
                player.playSound(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get());
            }
        } else {
            level.setBlock(blockPos, FossilsLegacyBlocks.DRUM.get().defaultBlockState().setValue(DrumBlock.DINOSAUR_ORDER, CommandType.getNext(CommandType.get(blockState.getValue(DrumBlock.DINOSAUR_ORDER))).id()), 3);
            if (level.isClientSide()) {
                player.playSound(FossilsLegacySoundEvents.DRUM_HIT.get());
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(DINOSAUR_ORDER);
        super.createBlockStateDefinition(builder);
    }
}
