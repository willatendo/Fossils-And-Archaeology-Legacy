package willatendo.fossilslegacy.server.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.creativemodetab.CreativeModeTabFill;

public class MagicConchItem extends Item implements CreativeModeTabFill {
	public MagicConchItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> components, TooltipFlag tooltipFlag) {
		components.add(FossilsLegacyUtils.translation("item", BuiltInRegistries.ITEM.getKey(this).getPath() + ".desc", this.getOrder(itemStack).getComponent()).withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, components, tooltipFlag);
	}

	public static DinosaurCommand getOrder(ItemStack itemStack) {
		CompoundTag compoundTag = itemStack.getOrCreateTag();
		return DinosaurCommand.load(compoundTag);
	}

	@Override
	public void fill(ItemDisplayParameters itemDisplayParameters, Output output) {
		for (DinosaurCommand dinosaurCommand : DinosaurCommand.values()) {
			ItemStack magicConch = new ItemStack(FossilsLegacyItems.MAGIC_CONCH.get());
			CompoundTag compoundTag = magicConch.getOrCreateTag();
			DinosaurCommand.save(compoundTag, dinosaurCommand);
			output.accept(magicConch);
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		player.getCooldowns().addCooldown(this, 10);

		for (Futabasaurus plesiosaurus : level.getEntitiesOfClass(Futabasaurus.class, new AABB(player.blockPosition()).inflate(30.0D))) {
			if (plesiosaurus.isOwnedBy(player)) {
				if (level.isClientSide()) {
					level.addParticle(ParticleTypes.NOTE, plesiosaurus.getBlockX(), plesiosaurus.getBlockY() + 1.2D, plesiosaurus.getBlockZ(), 0.0D, 0.0D, 0.0D);
				}
				plesiosaurus.setCommand(getOrder(player.getItemInHand(interactionHand)));
			}
		}

		player.startUsingItem(interactionHand);
		player.sendSystemMessage(FossilsLegacyUtils.translation("item", "magic_conch.use", this.getOrder(player.getItemInHand(interactionHand)).getComponent()));
		player.awardStat(Stats.ITEM_USED.get(this));
		return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
	}

	@Override
	public int getUseDuration(ItemStack itemStack) {
		return 140;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemStack) {
		return UseAnim.TOOT_HORN;
	}
}
