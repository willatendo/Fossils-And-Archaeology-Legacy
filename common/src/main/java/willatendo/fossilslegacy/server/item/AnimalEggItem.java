package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.ThrownAnimalEgg;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.function.Supplier;

public class AnimalEggItem extends Item implements ProjectileItem {
    private final Supplier<EntityType<? extends Animal>> animal;
    private final boolean incubated;
    private TagKey<CoatType> coatTypes;

    public AnimalEggItem(Supplier<EntityType<? extends Animal>> animal, boolean incubated, Properties properties) {
        super(properties);
        this.animal = animal;
        this.incubated = incubated;
    }

    public AnimalEggItem(Supplier<EntityType<? extends Animal>> animal, boolean incubated, TagKey<CoatType> coatTypes, Properties properties) {
        this(animal, incubated, properties);
        this.coatTypes = coatTypes;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            ThrownAnimalEgg thrownAnimalEgg = new ThrownAnimalEgg(level, player, this.animal.get(), this.incubated);
            if (this.coatTypes != null) {
                thrownAnimalEgg.setCoatType(level.registryAccess().lookup(FossilsLegacyRegistries.COAT_TYPES).get().get(this.coatTypes).get().getRandomElement(level.getRandom()).get().value());
            }
            thrownAnimalEgg.setItem(itemStack);
            thrownAnimalEgg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(thrownAnimalEgg);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemStack.consume(1, player);

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        ThrownAnimalEgg thrownIncubatedEgg = new ThrownAnimalEgg(level, position.x(), position.y(), position.z(), this.animal.get(), this.incubated);
        thrownIncubatedEgg.setItem(itemStack);
        return thrownIncubatedEgg;
    }
}
