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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.fossilslegacy.server.block.properties.FossilsLegacyBlockStateProperties;
import willatendo.fossilslegacy.server.block.properties.StringProperty;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.util.interfaces.CommandableEntity;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class DrumBlock extends Block {
    public static final StringProperty COMMAND_TYPE_PROPERTY = FossilsLegacyBlockStateProperties.COMMAND_TYPE;

    public DrumBlock(Properties properties) {
        super(properties);
        this.stateDefinition.any().setValue(COMMAND_TYPE_PROPERTY, "free_move");
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (itemStack.is(FossilsLegacyItemTags.DRUM_INSTRUMENT)) {
            CommandType currentCommandType = FossilsLegacyBuiltInRegistries.COMMAND_TYPES.get(FossilsLegacyUtils.resource(blockState.getValue(DrumBlock.COMMAND_TYPE_PROPERTY)));
            List<LivingEntity> allEntities = level.getEntitiesOfClass(LivingEntity.class, new AABB(blockPos).inflate(30.0D));
            for (LivingEntity livingEntity : allEntities) {
                if (livingEntity instanceof CommandableEntity commandableEntity) {
                    if (commandableEntity.willListenToDrum(player, interactionHand)) {
                        commandableEntity.setCommand(CommandType.get(blockState.getValue(COMMAND_TYPE_PROPERTY)));
                    }
                }
            }
            player.displayClientMessage(FossilsLegacyUtils.translation("block", "drum.hit", itemStack.getHoverName(), currentCommandType.getDescription()), true);
            if (level.isClientSide()) {
                player.playSound(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get());
            }
        } else {
            level.setBlock(blockPos, FossilsLegacyBlocks.DRUM.get().defaultBlockState().setValue(DrumBlock.COMMAND_TYPE_PROPERTY, CommandType.getNext(blockState.getValue(DrumBlock.COMMAND_TYPE_PROPERTY)).value().getName()), 3);
            if (level.isClientSide()) {
                player.playSound(FossilsLegacySoundEvents.DRUM_HIT.get());
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(COMMAND_TYPE_PROPERTY);
        super.createBlockStateDefinition(builder);
    }
}
