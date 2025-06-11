package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.block.entity.entities.CultivatorBlockEntity;
import willatendo.fossilslegacy.server.block.properties.FABlockStateProperties;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.stats.FAStats;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class CultivatorBlock extends Block implements EntityBlock {
    public static final BooleanProperty ACTIVE = FABlockStateProperties.ACTIVE;
    private final DyeColor dyeColor;

    public CultivatorBlock(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
        this.stateDefinition.any().setValue(ACTIVE, false);
    }

    public void shatter(Level level, BlockPos blockPos, CultivatorBlockEntity cultivatorBlockEntity) {
        level.setBlock(blockPos, Blocks.WATER.defaultBlockState(), 3);
        level.removeBlockEntity(blockPos);
        level.playLocalSound(blockPos, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F, false);

        for (Player player : level.players()) {
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.sendSystemMessage(FAUtils.translation("block", "cultivator.shatter"));
            }
        }

        popResource(level, blockPos, new ItemStack(Items.IRON_INGOT, 3));
        Containers.dropContents(level, blockPos, cultivatorBlockEntity);

        int chance = level.getRandom().nextInt(100);
        LivingEntity monster = null;
        if (chance <= 5) {
            monster = EntityType.CREEPER.create(level, EntitySpawnReason.TRIGGERED);
        }
        if (chance > 5 && chance < 10) {
            monster = EntityType.ZOMBIFIED_PIGLIN.create(level, EntitySpawnReason.TRIGGERED);
        }
        if (chance >= 10) {
            monster = FAEntityTypes.FAILURESAURUS.get().create(level, EntitySpawnReason.TRIGGERED);
        }

        monster.moveTo(blockPos, level.getRandom().nextFloat() * 360F, 0.0F);
        level.addFreshEntity(monster);
    }

    @Override
    public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int a, int b) {
        super.triggerEvent(blockState, level, blockPos, a, b);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity == null ? false : blockEntity.triggerEvent(a, b);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity instanceof MenuProvider ? (MenuProvider) blockEntity : null;
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newBlockState, boolean flag) {
        if (!blockState.is(newBlockState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof CultivatorBlockEntity cultivatorBlockEntity) {
                if (level instanceof ServerLevel) {
                    Containers.dropContents(level, blockPos, cultivatorBlockEntity);
                }
                level.updateNeighbourForOutputSignal(blockPos, this);
            }

            super.onRemove(blockState, level, blockPos, newBlockState, flag);
        }
    }

    @Override
    public InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof CultivatorBlockEntity cultivatorBlockEntity && player instanceof ServerPlayer serverPlayer) {
                SimpleUtils.openContainer(cultivatorBlockEntity, blockPos, serverPlayer);
                player.awardStat(FAStats.INTERACT_WITH_CULTIVATOR);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        BlockEntityTicker<T> blockEntityTicker = null;
        if (level instanceof ServerLevel serverlevel) {
            blockEntityTicker = SimpleUtils.createTickerHelper(blockEntityType, FABlockEntityTypes.CULTIVATOR.get(), (levelIn, blockPosIn, blockStateIn, cultivatorBlockEntityIn) -> {
                CultivatorBlockEntity.serverTick(serverlevel, blockPosIn, blockStateIn, cultivatorBlockEntityIn);
            });
        } else {
            blockEntityTicker = SimpleUtils.createTickerHelper(blockEntityType, FABlockEntityTypes.CULTIVATOR.get(), (levelIn, blockPosIn, blockStateIn, cultivatorBlockEntityIn) -> {
                CultivatorBlockEntity.clientTick(level, blockPosIn, blockStateIn, cultivatorBlockEntityIn);
            });
        }
        return blockEntityTicker;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CultivatorBlockEntity(this.dyeColor, blockPos, blockState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
        super.createBlockStateDefinition(builder);
    }
}
