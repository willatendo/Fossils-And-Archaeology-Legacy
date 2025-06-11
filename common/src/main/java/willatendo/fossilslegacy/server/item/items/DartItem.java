package willatendo.fossilslegacy.server.item.items;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.entities.projectile.Dart;

public class DartItem extends Item implements ProjectileItem {
    private final Dart.Color color;
    private final int potency;

    public DartItem(Dart.Color color, int potency, Properties properties) {
        super(properties);
        this.color = color;
        this.potency = potency;
    }

    public Dart createDart(Level level, ItemStack ammo, LivingEntity shooter, ItemStack weapon) {
        return new Dart(level, shooter, ammo.copyWithCount(1), weapon, this.color, this.potency);
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return new Dart(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1), null, this.color, this.potency);
    }
}
