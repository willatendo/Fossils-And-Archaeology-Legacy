package willatendo.fossilslegacy.server.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.server.utils.DinosaurOrder;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.FillCreativeTab;

public class MagicConchItem extends Item implements FillCreativeTab {
	public MagicConchItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
		components.add(FossilsLegacyUtils.translation("item", ForgeRegistries.ITEMS.getKey(this).getPath() + ".desc", this.getOrder(itemStack).getName()).withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, components, tooltipFlag);
	}

	public static DinosaurOrder getOrder(ItemStack itemStack) {
		CompoundTag compoundTag = itemStack.getOrCreateTag();
		return DinosaurOrder.getOrderFromInteger(compoundTag.getInt("Order"));
	}

	@Override
	public void fillCreativeTab(ItemDisplayParameters itemDisplayParameters, Output output) {
		for (int i = 0; i < 3; i++) {
			ItemStack magicConch = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
			CompoundTag compoundTag = magicConch.getOrCreateTag();
			compoundTag.putInt("Order", i);
			output.accept(magicConch);
		}
	}

//	@Override
//	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
//		// Change to for all Plesiosaurs
//		player.getCooldowns().addCooldown(this, 10);
//		if (level.isClientSide()) {
//			level.addParticle(ParticleTypes.NOTE, player.getBlockX(), player.getBlockY() + 1.2D, player.getBlockZ(), 0.0D, 0.0D, 0.0D);
//		}
//		player.startUsingItem(interactionHand);
//		player.sendSystemMessage(FossilsLegacyUtils.translation("order", "magic_conch.use", this.getOrder(player.getItemInHand(interactionHand)).getName()));
//		player.awardStat(Stats.ITEM_USED.get(this));
//		return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
//	}
//
//	@Override
//	public int getUseDuration(ItemStack itemStack) {
//		return 140;
//	}
//
//	@Override
//	public UseAnim getUseAnimation(ItemStack itemStack) {
//		return UseAnim.TOOT_HORN;
//	}
}
