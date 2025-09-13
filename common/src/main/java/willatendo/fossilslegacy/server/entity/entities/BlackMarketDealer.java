package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.FAVillagerTrades;

import java.util.EnumSet;

public class BlackMarketDealer extends AbstractVillager implements Consumable.OverrideConsumeSound {
    private BlockPos wanderTarget;
    private int despawnDelay;

    public BlackMarketDealer(EntityType<? extends BlackMarketDealer> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionContents.createItemStack(Items.POTION, Potions.INVISIBILITY), SoundEvents.WANDERING_TRADER_DISAPPEARED, blackMarketDealer -> this.level().isDay() && !blackMarketDealer.isInvisible()));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.WANDERING_TRADER_REAPPEARED, blackMarketDealer -> this.level().isNight() && blackMarketDealer.isInvisible()));
        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, IronGolem.class, 8.0F, 0.5, 0.5));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.5));
        this.goalSelector.addGoal(1, new LookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(2, new BlackMarketDealer.WanderToPositionGoal(this, 2.0, 0.35));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.35));
        this.goalSelector.addGoal(9, new InteractGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!itemStack.is(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (interactionHand == InteractionHand.MAIN_HAND) {
                player.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.level().isClientSide) {
                if (this.getOffers().isEmpty()) {
                    return InteractionResult.CONSUME;
                }

                this.setTradingPlayer(player);
                this.openTradingScreen(player, this.getDisplayName(), 1);
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(player, interactionHand);
        }
    }

    @Override
    protected void updateTrades() {
        VillagerTrades.ItemListing[] itemListings1 = FAVillagerTrades.BLACK_MARKET_DEALER_TRADES.get(1);
        VillagerTrades.ItemListing[] itemListings2 = FAVillagerTrades.BLACK_MARKET_DEALER_TRADES.get(2);
        if (itemListings1 != null && itemListings2 != null) {
            MerchantOffers merchantOffers = this.getOffers();
            this.addOffersFromItemListings(merchantOffers, itemListings1, 5);
            VillagerTrades.ItemListing itemListing = itemListings2[this.random.nextInt(itemListings2.length)];
            MerchantOffer merchantOffer = itemListing.getOffer(this, this.random);
            if (merchantOffer != null) {
                merchantOffers.add(merchantOffer);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("despawn_delay", this.despawnDelay);
        if (this.wanderTarget != null) {
            compoundTag.put("wander_target", NbtUtils.writeBlockPos(this.wanderTarget));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("despawn_delay", 99)) {
            this.despawnDelay = compoundTag.getInt("despawn_delay");
        }

        NbtUtils.readBlockPos(compoundTag, "wander_target").ifPresent(blockPos -> this.wanderTarget = blockPos);
        this.setAge(Math.max(0, this.getAge()));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    protected void rewardTradeXp(MerchantOffer merchantOffer) {
        if (merchantOffer.shouldRewardExp()) {
            int amount = 3 + this.random.nextInt(4);
            this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY() + 0.5, this.getZ(), amount));
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTrading() ? SoundEvents.WANDERING_TRADER_TRADE : SoundEvents.WANDERING_TRADER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.WANDERING_TRADER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WANDERING_TRADER_DEATH;
    }

    @Override
    public SoundEvent getConsumeSound(ItemStack itemStack) {
        return itemStack.is(Items.MILK_BUCKET) ? SoundEvents.WANDERING_TRADER_DRINK_MILK : SoundEvents.WANDERING_TRADER_DRINK_POTION;
    }

    @Override
    protected SoundEvent getTradeUpdatedSound(boolean getYesSound) {
        return getYesSound ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.WANDERING_TRADER_YES;
    }

    public void setDespawnDelay(int despawnDelay) {
        this.despawnDelay = despawnDelay;
    }

    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            this.maybeDespawn();
        }
    }

    private void maybeDespawn() {
        if (this.despawnDelay > 0 && !this.isTrading() && --this.despawnDelay == 0) {
            this.discard();
        }
    }

    public void setWanderTarget(BlockPos wanderTarget) {
        this.wanderTarget = wanderTarget;
    }

    BlockPos getWanderTarget() {
        return this.wanderTarget;
    }

    class WanderToPositionGoal extends Goal {
        final BlackMarketDealer trader;
        final double stopDistance;
        final double speedModifier;

        WanderToPositionGoal(BlackMarketDealer trader, double stopDistance, double speedModifier) {
            this.trader = trader;
            this.stopDistance = stopDistance;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public void stop() {
            this.trader.setWanderTarget(null);
            BlackMarketDealer.this.navigation.stop();
        }

        @Override
        public boolean canUse() {
            BlockPos blockPos = this.trader.getWanderTarget();
            return blockPos != null && this.isTooFarAway(blockPos, this.stopDistance);
        }

        @Override
        public void tick() {
            BlockPos blockPos = this.trader.getWanderTarget();
            if (blockPos != null && BlackMarketDealer.this.navigation.isDone()) {
                if (this.isTooFarAway(blockPos, 10.0)) {
                    Vec3 vec3 = (new Vec3((double) blockPos.getX() - this.trader.getX(), (double) blockPos.getY() - this.trader.getY(), (double) blockPos.getZ() - this.trader.getZ())).normalize();
                    Vec3 scaked = vec3.scale(10.0).add(this.trader.getX(), this.trader.getY(), this.trader.getZ());
                    BlackMarketDealer.this.navigation.moveTo(scaked.x, scaked.y, scaked.z, this.speedModifier);
                } else {
                    BlackMarketDealer.this.navigation.moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.speedModifier);
                }
            }
        }

        private boolean isTooFarAway(BlockPos blockPos, double distance) {
            return !blockPos.closerToCenterThan(this.trader.position(), distance);
        }
    }
}
