package fossilslegacy.server.item;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ModArmourItem extends ArmorItem {
	private final String texture;

	public ModArmourItem(String texture, ArmorMaterial armourMaterial, Type type, Properties properties) {
		super(armourMaterial, type, properties);
		this.texture = texture;
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot, String type) {
		return equipmentSlot == EquipmentSlot.LEGS ? FossilsLegacyUtils.resource("textures/models/armor/" + this.texture + "_2.png").toString() : FossilsLegacyUtils.resource("textures/models/armor/" + this.texture + "_1.png").toString();
	}
}
