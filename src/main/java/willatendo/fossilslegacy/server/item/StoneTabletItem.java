package willatendo.fossilslegacy.server.item;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.StoneTablet;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariantTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.creativemodetab.CreativeModeTabFill;

public class StoneTabletItem extends Item implements CreativeModeTabFill {
	private static final Comparator<Holder<StoneTabletVariant>> STONE_TABLET_COMPARATOR = Comparator.comparing(Holder::value, Comparator.<StoneTabletVariant>comparingInt(paintingVariant -> paintingVariant.height() * paintingVariant.width()).thenComparing(StoneTabletVariant::width));
	private static final Component TOOLTIP_RANDOM_VARIANT = FossilsLegacyUtils.translation("stone_tablet", "random").withStyle(ChatFormatting.GRAY);

	public StoneTabletItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		BlockPos blockpos = useOnContext.getClickedPos();
		Direction direction = useOnContext.getClickedFace();
		BlockPos relativePos = blockpos.relative(direction);
		Player player = useOnContext.getPlayer();
		ItemStack itemStack = useOnContext.getItemInHand();
		if (player != null && !this.mayPlace(player, direction, itemStack, relativePos)) {
			return InteractionResult.FAIL;
		} else {
			Level level = useOnContext.getLevel();
			HangingEntity hangingentity = null;
			Optional<StoneTablet> stoneHieroglyph = StoneTablet.create(level, relativePos, direction);
			if (!stoneHieroglyph.isEmpty()) {
				hangingentity = stoneHieroglyph.get();
			}

			CompoundTag compoundtag = itemStack.getTag();
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

					itemStack.shrink(1);
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
			StoneTablet.loadVariant(entityTag).ifPresentOrElse((stoneTabletVariant) -> {
				toolTips.add(stoneTabletVariant.value().getName().withStyle(ChatFormatting.YELLOW));
				toolTips.add(stoneTabletVariant.value().getAuthor().withStyle(ChatFormatting.GRAY));
				toolTips.add(Component.translatable("painting.dimensions", Mth.positiveCeilDiv(stoneTabletVariant.value().width(), 16), Mth.positiveCeilDiv(stoneTabletVariant.value().height(), 16)));
			}, () -> {
				toolTips.add(TOOLTIP_RANDOM_VARIANT);
			});
		} else if (toolTipFlag.isCreative()) {
			toolTips.add(TOOLTIP_RANDOM_VARIANT);
		}
	}

	@Override
	public void fill(ItemDisplayParameters itemDisplayParameters, Output output) {
		output.accept(FossilsLegacyItems.STONE_TABLET.get());
		itemDisplayParameters.holders().lookup(FossilsLegacyRegistries.STONE_TABLET_VARIANTS).ifPresent(registryLookup -> StoneTabletItem.generatePresetStoneTablets(output, registryLookup, holder -> holder.is(FossilsLegacyStoneTabletVariantTags.PLACEABLE), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
	}

	private static void generatePresetStoneTablets(CreativeModeTab.Output output, HolderLookup.RegistryLookup<StoneTabletVariant> registryLookup, Predicate<Holder<StoneTabletVariant>> predicate, CreativeModeTab.TabVisibility tabVisibility) {
		registryLookup.listElements().filter(predicate).sorted(STONE_TABLET_COMPARATOR).forEach(reference -> {
			ItemStack itemStack = new ItemStack(FossilsLegacyItems.STONE_TABLET.get());
			CompoundTag compoundTag = itemStack.getOrCreateTagElement("EntityTag");
			StoneTablet.storeVariant(compoundTag, reference);
			output.accept(itemStack, tabVisibility);
		});
	}
}
