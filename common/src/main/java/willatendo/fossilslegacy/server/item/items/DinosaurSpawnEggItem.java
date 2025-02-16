package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.Objects;

public class DinosaurSpawnEggItem extends SpawnEggItem {
    public DinosaurSpawnEggItem(EntityType<? extends Dinosaur> entityType, Properties properties) {
        super(entityType, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(FAUtils.translation("item", "dinosaur_spawn_egg.desc").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            ServerLevel serverLevel = (ServerLevel) level;
            ItemStack itemStack = useOnContext.getItemInHand();
            BlockPos blockPos = useOnContext.getClickedPos();
            Direction direction = useOnContext.getClickedFace();
            BlockState blockState = level.getBlockState(blockPos);
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            Player player = useOnContext.getPlayer();
            if (blockEntity instanceof Spawner spawner) {
                EntityType<?> entityType = this.getType(level.registryAccess(), itemStack);
                spawner.setEntityId(entityType, level.getRandom());
                level.sendBlockUpdated(blockPos, blockState, blockState, 3);
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                itemStack.shrink(1);
                return InteractionResult.SUCCESS;
            } else {
                BlockPos blockPosAt;
                if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
                    blockPosAt = blockPos;
                } else {
                    blockPosAt = blockPos.relative(direction);
                }

                EntityType<?> entityType = this.getType(level.registryAccess(), itemStack);
                Entity entity = entityType.spawn(serverLevel, itemStack, player, blockPosAt, EntitySpawnReason.SPAWN_ITEM_USE, true, !Objects.equals(blockPos, blockPosAt) && direction == Direction.UP);
                if (entity instanceof Dinosaur dinosaur) {
                    if (!player.isCrouching()) {
                        dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage());
                    }
                }
                if (entity != null) {
                    itemStack.shrink(1);
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);
                }

                return InteractionResult.SUCCESS;
            }
        }
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        BlockHitResult playerPOVHitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (playerPOVHitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResult.PASS;
        } else if (level instanceof ServerLevel serverLevel) {
            BlockPos blockPos = playerPOVHitResult.getBlockPos();
            if (!(level.getBlockState(blockPos).getBlock() instanceof LiquidBlock)) {
                return InteractionResult.PASS;
            } else if (level.mayInteract(player, blockPos) && player.mayUseItemAt(blockPos, playerPOVHitResult.getDirection(), itemStack)) {
                EntityType<?> entityType = this.getType(serverLevel.registryAccess(), itemStack);
                Entity entity = entityType.spawn(serverLevel, itemStack, player, blockPos, EntitySpawnReason.SPAWN_ITEM_USE, false, false);
                if (entity instanceof Dinosaur dinosaur) {
                    if (!player.isCrouching()) {
                        dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage());
                    }
                }
                if (entity == null) {
                    return InteractionResult.PASS;
                } else {
                    itemStack.consume(1, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, entity.position());
                    return InteractionResult.SUCCESS;
                }
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            return InteractionResult.SUCCESS;
        }
    }

}
