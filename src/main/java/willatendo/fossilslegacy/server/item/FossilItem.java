package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.Fossils;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;

public class FossilItem extends Item {
	public FossilItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		Level level = useOnContext.getLevel();
		if (!level.isClientSide()) {
			RandomSource randomSource = level.getRandom();
			Fossil fossil = FossilsLegacyEntities.FOSSIL.get().create(level);
			int skeleton = randomSource.nextInt(Fossils.values().length);
			fossil.setFossil(skeleton);
			fossil.setSize(1);
			Direction direction = useOnContext.getClickedFace();
			fossil.moveTo(useOnContext.getClickedPos().relative(direction), (float) randomSource.nextInt(360), 0.0F);
			level.addFreshEntity(fossil);
			Player player = useOnContext.getPlayer();
			InteractionHand interactionHand = useOnContext.getHand();
			player.getItemInHand(interactionHand).shrink(1);
		}
		return InteractionResult.sidedSuccess(level.isClientSide());
	}
}
