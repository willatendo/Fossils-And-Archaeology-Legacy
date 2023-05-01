package fossilslegacy.server.item;

import java.util.List;
import java.util.Optional;

import fossilslegacy.server.entity.CavePainting;
import fossilslegacy.server.entity.CavePaintingTypes;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class CavePaintingItem extends Item {
	private static final Component TOOLTIP_RANDOM_VARIANT = FossilsLegacyUtils.translation("cave_painting", "random").withStyle(ChatFormatting.GRAY);

	public CavePaintingItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		BlockPos blockpos = useOnContext.getClickedPos();
		Direction direction = useOnContext.getClickedFace();
		BlockPos blockpos1 = blockpos.relative(direction);
		Player player = useOnContext.getPlayer();
		ItemStack itemstack = useOnContext.getItemInHand();
		if (player != null && !this.mayPlace(player, direction, itemstack, blockpos1)) {
			return InteractionResult.FAIL;
		} else {
			Level level = useOnContext.getLevel();
			HangingEntity hangingentity = null;
			Optional<CavePainting> cavePainting = CavePainting.create(level, blockpos1, direction);
			if (!cavePainting.isEmpty()) {
				hangingentity = cavePainting.get();
			}

			CompoundTag compoundtag = itemstack.getTag();
			if (compoundtag != null) {
				EntityType.updateCustomEntityTag(level, player, hangingentity, compoundtag);
			}

			if (hangingentity.survives()) {
				if (!level.isClientSide()) {
					hangingentity.playPlacementSound();
					level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentity.position());
					level.addFreshEntity(hangingentity);
				}

				itemstack.shrink(1);
				return InteractionResult.sidedSuccess(level.isClientSide);
			} else {
				return InteractionResult.CONSUME;
			}
		}
	}

	protected boolean mayPlace(Player player, Direction direction, ItemStack itemStack, BlockPos blockPos) {
		return !direction.getAxis().isVertical() && player.mayUseItemAt(blockPos, direction, itemStack);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> toolTips, TooltipFlag toolTipFlag) {
		super.appendHoverText(itemStack, level, toolTips, toolTipFlag);
		CompoundTag compoundTag = itemStack.getTag();
		if (compoundTag != null && compoundTag.contains("EntityTag", 10)) {
			CompoundTag entityTag = compoundTag.getCompound("EntityTag");
			Optional.of(entityTag.getInt("Type")).ifPresentOrElse((cavePaintingType) -> {
				if (cavePaintingType < CavePaintingTypes.values().length) {
					CavePaintingTypes cavePaintingTypes = CavePaintingTypes.values()[cavePaintingType];
					toolTips.add(cavePaintingTypes.getName().withStyle(ChatFormatting.YELLOW));
					toolTips.add(cavePaintingTypes.getAuthor().withStyle(ChatFormatting.GRAY));
					toolTips.add(Component.translatable("painting.dimensions", Mth.positiveCeilDiv(cavePaintingTypes.getWidth(), 16), Mth.positiveCeilDiv(cavePaintingTypes.getHeight(), 16)));
				} else {
					toolTips.add(TOOLTIP_RANDOM_VARIANT);
				}
			}, () -> {
				toolTips.add(TOOLTIP_RANDOM_VARIANT);
			});
		} else if (toolTipFlag.isCreative()) {
			toolTips.add(TOOLTIP_RANDOM_VARIANT);
		}
	}
}
