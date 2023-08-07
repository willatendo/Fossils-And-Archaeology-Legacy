package willatendo.fossilslegacy.server.block;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.entity.PlayerCommandable;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.utils.DinosaurOrder;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class DrumBlock extends Block {
	public static final EnumProperty<DinosaurOrder> DINOSAUR_ORDER = EnumProperty.create("order", DinosaurOrder.class);

	public DrumBlock(Properties properties) {
		super(properties);
		this.stateDefinition.any().setValue(DINOSAUR_ORDER, DinosaurOrder.FOLLOW);
	}

	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (itemStack.is(FossilsLegacyItemTags.DRUM_INSTRUMENT)) {
			DinosaurOrder current = blockState.getValue(DrumBlock.DINOSAUR_ORDER);
			List<LivingEntity> allEntities = level.getEntitiesOfClass(LivingEntity.class, new AABB(blockPos).inflate(30.0D));
			for (LivingEntity livingEntity : allEntities) {
				if (livingEntity instanceof PlayerCommandable playerCommandable) {
					if (ForgeRegistries.ITEMS.tags().getTag(playerCommandable.commandItems()).contains(itemStack.getItem())) {
						playerCommandable.setCommand(blockState.getValue(DINOSAUR_ORDER));
					}
				}
			}
			player.displayClientMessage(FossilsLegacyUtils.translation("block", "drum.hit", itemStack.getHoverName(), current.getName()), true);
			if (level.isClientSide()) {
				player.playSound(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get());
			}
		} else {
			DinosaurOrder next = DinosaurOrder.FOLLOW;
			DinosaurOrder current = blockState.getValue(DrumBlock.DINOSAUR_ORDER);
			if (current == DinosaurOrder.FOLLOW) {
				next = DinosaurOrder.STAY;
			} else if (current == DinosaurOrder.STAY) {
				next = DinosaurOrder.FREE_MOVE;
			} else {
				next = DinosaurOrder.FOLLOW;
			}
			level.setBlock(blockPos, FossilsLegacyBlocks.DRUM.get().defaultBlockState().setValue(DrumBlock.DINOSAUR_ORDER, next), 3);
			if (level.isClientSide()) {
				player.playSound(FossilsLegacySoundEvents.DRUM_HIT.get());
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(DINOSAUR_ORDER);
		super.createBlockStateDefinition(builder);
	}
}
