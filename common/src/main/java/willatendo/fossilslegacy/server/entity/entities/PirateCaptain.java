package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.item.FAItems;

public class PirateCaptain extends Bones {
    public PirateCaptain(EntityType<? extends PirateCaptain> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 30.0F).add(Attributes.MOVEMENT_SPEED, 0.25).build();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        super.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        this.setGuaranteedDrop(EquipmentSlot.MAINHAND);
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(FAItems.DIAMOND_JAVELIN.get()));
        this.setGuaranteedDrop(EquipmentSlot.OFFHAND);
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(FAItems.CAPTAINS_HAT.get()));
    }
}
