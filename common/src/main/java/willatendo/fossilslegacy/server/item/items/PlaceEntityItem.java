package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class PlaceEntityItem<T extends Entity> extends Item {
    private final GeologicalTimeScale.Period period;
    private final Supplier<EntityType<T>> entityType;

    public PlaceEntityItem(GeologicalTimeScale.Period period, Supplier<EntityType<T>> entityType, Properties properties) {
        super(properties);
        this.period = period;
        this.entityType = entityType;
    }

    public PlaceEntityItem(Supplier<EntityType<T>> entityType, Properties properties) {
        this(null, entityType, properties);
    }

    public Supplier<EntityType<T>> getEntityType() {
        return this.entityType;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (this.period != null) {
            this.period.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemStack = useOnContext.getItemInHand();
            BlockPos blockPos = useOnContext.getClickedPos();
            Direction direction = useOnContext.getClickedFace();
            BlockState blockState = level.getBlockState(blockPos);
            BlockPos placePos;
            if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
                placePos = blockPos;
            } else {
                placePos = blockPos.relative(direction);
            }

            if (this.entityType.get() != null) {
                ServerLevel serverLevel = (ServerLevel) level;
                Player player = useOnContext.getPlayer();
                T entity = this.entityType.get().create(level, EntitySpawnReason.SPAWN_ITEM_USE);
                this.entityModification(itemStack, entity);
                entity.setPos((double) placePos.getX() + 0.5D, placePos.getY() + 1.0D, (double) placePos.getZ() + 0.5D);
                double yOffset = getYOffset(serverLevel, blockPos, !Objects.equals(blockPos, placePos) && direction == Direction.UP, ((Entity) entity).getBoundingBox());
                entity.moveTo((double) placePos.getX() + 0.5D, (double) placePos.getY() + yOffset, (double) placePos.getZ() + 0.5D, Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F), 0.0F);
                if (entity instanceof Mob mob) {
                    mob.yHeadRot = mob.getYRot();
                    mob.yBodyRot = mob.getYRot();
                    mob.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(mob.blockPosition()), EntitySpawnReason.SPAWN_ITEM_USE, null);
                    mob.playAmbientSound();
                }
                level.addFreshEntity(entity);
                itemStack.shrink(1);
                player.awardStat(Stats.ITEM_USED.get(this));
                level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);
            }

            return InteractionResult.CONSUME;
        }
    }

    public static double getYOffset(LevelReader levelReader, BlockPos blockPos, boolean bl, AABB aABB) {
        AABB aABBAtPos = new AABB(blockPos);
        if (bl) {
            aABBAtPos = aABBAtPos.expandTowards(0.0, -1.0, 0.0);
        }
        Iterable iterable = levelReader.getCollisions(null, aABBAtPos);
        return 1.0 + Shapes.collide(Direction.Axis.Y, aABB, iterable, bl ? -2.0 : -1.0);
    }

    public void entityModification(ItemStack itemStack, T entity) {
    }
}
