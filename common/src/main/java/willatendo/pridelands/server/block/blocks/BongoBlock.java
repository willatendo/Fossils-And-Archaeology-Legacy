package willatendo.pridelands.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.pridelands.server.sound.PridelandsSoundEvents;
import willatendo.pridelands.server.tag.PridelandsItemTags;

import javax.annotation
        .Nullable;

public class BongoBlock extends Block {
    public static final IntegerProperty NOTE = BlockStateProperties.NOTE;
    public static final VoxelShape SHAPE = Block.box(1.0F, 0.0F, 1.0F, 15.0F, 12.0F, 15.0F);

    public BongoBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(NOTE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    private void playNote(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
        level.blockEvent(pos, this, 0, 0);
        level.gameEvent(entity, GameEvent.NOTE_BLOCK_PLAY, pos);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (itemStack.is(PridelandsItemTags.OPENS_BONGO)) {

            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            blockState = blockState.cycle(NOTE);
            level.setBlock(blockPos, blockState, 3);
            this.playNote(player, blockState, level, blockPos);
            player.awardStat(Stats.TUNE_NOTEBLOCK);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if (!level.isClientSide) {
            this.playNote(player, blockState, level, blockPos);
            player.awardStat(Stats.PLAY_NOTEBLOCK);
        }
    }

    public static float getPitchFromNote(int note) {
        return (float) Math.pow(2.0, (double) (note - 12) / 12.0);
    }

    @Override
    protected boolean triggerEvent(BlockState blockState, Level level, BlockPos pos, int id, int param) {
        int note = blockState.getValue(NOTE);
        float pitch = BongoBlock.getPitchFromNote(note);
        level.addParticle(ParticleTypes.NOTE, (double) pos.getX() + 0.5, (double) pos.getY() + 1.2, (double) pos.getZ() + 0.5, (double) note / 24.0, 0.0, 0.0);

        level.playSeededSound(null, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, PridelandsSoundEvents.BONGO_HIT, SoundSource.RECORDS, 3.0F, pitch, level.random.nextLong());
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NOTE);
    }
}
