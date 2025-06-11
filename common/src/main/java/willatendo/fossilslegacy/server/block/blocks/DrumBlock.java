package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.properties.FABlockStateProperties;
import willatendo.fossilslegacy.server.block.properties.StringProperty;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandableEntity;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.sound.FASoundEvents;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class DrumBlock extends Block {
    public static final StringProperty COMMAND_TYPE_PROPERTY = FABlockStateProperties.COMMAND_TYPE;

    public DrumBlock(Properties properties) {
        super(properties);
        this.stateDefinition.any().setValue(COMMAND_TYPE_PROPERTY, "free_move");
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (itemStack.is(FAItemTags.DRUM_INSTRUMENT)) {
            CommandType currentCommandType = FABuiltInRegistries.COMMAND_TYPES.getValue(FAUtils.resource(blockState.getValue(DrumBlock.COMMAND_TYPE_PROPERTY)));
            List<LivingEntity> allEntities = level.getEntitiesOfClass(LivingEntity.class, new AABB(blockPos).inflate(30.0D));
            for (LivingEntity livingEntity : allEntities) {
                if (livingEntity instanceof CommandableEntity commandableEntity) {
                    if (commandableEntity.willListenToDrum(player, interactionHand)) {
                        commandableEntity.setCommand(CommandType.get(blockState.getValue(COMMAND_TYPE_PROPERTY)));
                    }
                }
            }
            player.displayClientMessage(FAUtils.translation("block", "drum.hit", itemStack.getHoverName(), currentCommandType.getDescription()), true);
            if (level.isClientSide()) {
                player.playSound(FASoundEvents.DRUM_TRIPLE_HIT.get());
            }
        } else {
            if (!level.isClientSide()) {
                level.setBlock(blockPos, FABlocks.DRUM.get().defaultBlockState().setValue(DrumBlock.COMMAND_TYPE_PROPERTY, CommandType.getNext(blockState.getValue(DrumBlock.COMMAND_TYPE_PROPERTY)).value().getName()), 3);
            } else {
                player.playSound(FASoundEvents.DRUM_HIT.get());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(COMMAND_TYPE_PROPERTY);
        super.createBlockStateDefinition(builder);
    }
}
