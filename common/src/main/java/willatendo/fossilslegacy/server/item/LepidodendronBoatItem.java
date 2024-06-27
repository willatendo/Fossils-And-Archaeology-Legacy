package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.LepidodendronBoat;
import willatendo.fossilslegacy.server.entity.LepidodendronChestBoat;
import willatendo.fossilslegacy.server.entity.util.BoatTypeAccessor;
import willatendo.fossilslegacy.server.entity.variants.BoatType;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LepidodendronBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final Holder<BoatType> boatType;
    private final boolean hasChest;

    public LepidodendronBoatItem(boolean hasChest, Holder<BoatType> boatType, Item.Properties properties) {
        super(properties);
        this.hasChest = hasChest;
        this.boatType = boatType;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        HitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemStack);
        } else {
            Vec3 vec3 = player.getViewVector(1.0F);
            List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(vec3.scale(5.0)).inflate(1.0), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vec3 eyePos = player.getEyePosition();
                Iterator<Entity> entities = list.iterator();

                while (entities.hasNext()) {
                    Entity entity = entities.next();
                    AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (aabb.contains(eyePos)) {
                        return InteractionResultHolder.pass(itemStack);
                    }
                }
            }

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                Boat boat = this.getBoat(level, hitResult, itemStack, player);
                ((BoatTypeAccessor) boat).setBoatType(this.boatType);
                boat.setYRot(player.getYRot());
                if (!level.noCollision(boat, boat.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemStack);
                } else {
                    if (!level.isClientSide) {
                        level.addFreshEntity(boat);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, hitResult.getLocation());
                        itemStack.consume(1, player);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemStack);
            }
        }
    }

    private Boat getBoat(Level level, HitResult hitResult, ItemStack itemStack, Player player) {
        Vec3 vec3 = hitResult.getLocation();
        Boat boat = this.hasChest ? new LepidodendronChestBoat(level, vec3.x, vec3.y, vec3.z) : new LepidodendronBoat(level, vec3.x, vec3.y, vec3.z);
        if (level instanceof ServerLevel serverlevel) {
            EntityType.createDefaultStackConfig(serverlevel, itemStack, player).accept(boat);
        }

        return boat;
    }
}
