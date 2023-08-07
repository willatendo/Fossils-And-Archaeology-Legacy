package willatendo.fossilslegacy.server.item;

import java.util.List;
import java.util.Optional;

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
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.entity.StoneHieroglyph;
import willatendo.fossilslegacy.server.entity.StoneHieroglyphTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.FillCreativeTab;

public class StoneHieroglyphItem extends Item implements FillCreativeTab {
	private static final Component TOOLTIP_RANDOM_VARIANT = FossilsLegacyUtils.translation("stone_hieroglyph", "random").withStyle(ChatFormatting.GRAY);

	public StoneHieroglyphItem(Properties properties) {
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
			Optional<StoneHieroglyph> stoneHieroglyph = StoneHieroglyph.create(level, blockpos1, direction);
			if (!stoneHieroglyph.isEmpty()) {
				hangingentity = stoneHieroglyph.get();
			}

			CompoundTag compoundtag = itemstack.getTag();
			if (compoundtag != null) {
				EntityType.updateCustomEntityTag(level, player, hangingentity, compoundtag);
			}

			if (hangingentity != null) {
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
				StoneHieroglyphTypes cavePaintingTypes = StoneHieroglyphTypes.values()[cavePaintingType];
				toolTips.add(cavePaintingTypes.getName().withStyle(ChatFormatting.YELLOW));
				toolTips.add(cavePaintingTypes.getAuthor().withStyle(ChatFormatting.GRAY));
				toolTips.add(Component.translatable("painting.dimensions", Mth.positiveCeilDiv(cavePaintingTypes.getWidth(), 16), Mth.positiveCeilDiv(cavePaintingTypes.getHeight(), 16)));
			}, () -> {
				toolTips.add(TOOLTIP_RANDOM_VARIANT);
			});
		} else if (toolTipFlag.isCreative()) {
			toolTips.add(TOOLTIP_RANDOM_VARIANT);
		}
	}

	@Override
	public void fillCreativeTab(ItemDisplayParameters itemDisplayParameters, Output output) {
		for (int i = 0; i < StoneHieroglyphTypes.values().length; i++) {
			ItemStack itemStack = new ItemStack(FossilsLegacyItems.STONE_HIEROGLYPH.get());
			CompoundTag compoundTag = itemStack.getOrCreateTagElement("EntityTag");
			compoundTag.putInt("Type", i);
			output.accept(itemStack);
		}
	}
}
