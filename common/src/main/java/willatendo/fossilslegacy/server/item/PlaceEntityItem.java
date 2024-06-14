package willatendo.fossilslegacy.server.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;

import java.util.Objects;
import java.util.function.Supplier;

public class PlaceEntityItem extends Item {
    private final Supplier<EntityType<?>> entityType;

    public PlaceEntityItem(Supplier<EntityType<?>> entityType, Properties properties) {
        super(properties);
        this.entityType = entityType;
    }

    public Supplier<EntityType<?>> getEntityType() {
        return this.entityType;
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
                Entity entity = this.entityType.get().create(level);
                this.entityModification(entity);
                entity.setPos((double) placePos.getX() + 0.5D, placePos.getY() + 1.0D, (double) placePos.getZ() + 0.5D);
                double yOffset = getYOffset(serverLevel, blockPos, !Objects.equals(blockPos, placePos) && direction == Direction.UP, ((Entity) entity).getBoundingBox());
                entity.moveTo((double) placePos.getX() + 0.5D, (double) placePos.getY() + yOffset, (double) placePos.getZ() + 0.5D, Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F), 0.0F);
                if (entity instanceof Mob mob) {
                    mob.yHeadRot = mob.getYRot();
                    mob.yBodyRot = mob.getYRot();
                    mob.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(mob.blockPosition()), MobSpawnType.SPAWN_EGG, null);
                    mob.playAmbientSound();
                }
                level.addFreshEntity(entity);
                itemStack.shrink(1);
                level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
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

    public void entityModification(Entity entity) {
    }
}
