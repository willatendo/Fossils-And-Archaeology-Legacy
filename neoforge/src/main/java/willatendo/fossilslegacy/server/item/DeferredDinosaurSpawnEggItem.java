package willatendo.fossilslegacy.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class DeferredDinosaurSpawnEggItem extends DeferredSpawnEggItem {
    public DeferredDinosaurSpawnEggItem(Supplier<EntityType<? extends Mob>> entityType, int backgroundColor, int highlightColor, Item.Properties properties) {
        super(entityType, backgroundColor, highlightColor, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(FossilsLegacyUtils.translation("item", "dinosaur_spawn_egg.desc").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        EntityType<?> entityType;
        Level level = useOnContext.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        }
        ItemStack itemStack = useOnContext.getItemInHand();
        BlockPos blockPos = useOnContext.getClickedPos();
        Direction direction = useOnContext.getClickedFace();
        BlockState blockState = level.getBlockState(blockPos);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof Spawner spawner) {
            entityType = this.getType(itemStack.getTag());
            spawner.setEntityId(entityType, level.getRandom());
            level.sendBlockUpdated(blockPos, blockState, blockState, 3);
            level.gameEvent(useOnContext.getPlayer(), GameEvent.BLOCK_CHANGE, blockPos);
            itemStack.shrink(1);
            return InteractionResult.CONSUME;
        }
        ServerLevel serverLevel = (ServerLevel) level;
        BlockPos blockPos2 = blockState.getCollisionShape(level, blockPos).isEmpty() ? blockPos : blockPos.relative(direction);
        entityType = this.getType(itemStack.getTag());
        Entity entity = entityType.create(level);
        if (entity instanceof Dinosaur dinosaur) {
            if (!useOnContext.getPlayer().isCrouching()) {
                dinosaur.setGrowthStage(dinosaur.getMaxGrowthStage());
            }
        }
        entity.setPos((double) blockPos2.getX() + 0.5, blockPos2.getY(), (double) blockPos2.getZ() + 0.5);
        double yOffset = getYOffset(serverLevel, blockPos, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP, ((Entity) entity).getBoundingBox());
        entity.moveTo((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + yOffset, (double) blockPos.getZ() + 0.5D, Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0f), 0.0f);
        if (entity instanceof Mob mob) {
            mob.yHeadRot = mob.getYRot();
            mob.yBodyRot = mob.getYRot();
            mob.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(mob.blockPosition()), MobSpawnType.SPAWN_EGG, null, null);
            mob.playAmbientSound();
        }
        level.addFreshEntity(entity);

        if (entity != null) {
            itemStack.shrink(1);
            level.gameEvent((Entity) useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
        }
        return InteractionResult.CONSUME;
    }

    public static double getYOffset(LevelReader levelReader, BlockPos blockPos, boolean bl, AABB aABB) {
        AABB aABBAtPos = new AABB(blockPos);
        if (bl) {
            aABBAtPos = aABBAtPos.expandTowards(0.0, -1.0, 0.0);
        }
        Iterable iterable = levelReader.getCollisions(null, aABBAtPos);
        return 1.0 + Shapes.collide(Direction.Axis.Y, aABB, iterable, bl ? -2.0 : -1.0);
    }
}
