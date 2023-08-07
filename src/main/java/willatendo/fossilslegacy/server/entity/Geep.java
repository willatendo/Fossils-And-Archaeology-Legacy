package willatendo.fossilslegacy.server.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;

public class Geep extends Sheep {
	public Geep(EntityType<? extends Geep> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public Geep getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return null;
	}

	@Override
	public ResourceLocation getDefaultLootTable() {
		if (this.isSheared()) {
			return this.getType().getDefaultLootTable();
		} else {
			ResourceLocation resourcelocation;
			switch (this.getColor()) {
			case WHITE:
				resourcelocation = FossilsLegacyLootTables.GEEP_WHITE;
				break;
			case ORANGE:
				resourcelocation = FossilsLegacyLootTables.GEEP_ORANGE;
				break;
			case MAGENTA:
				resourcelocation = FossilsLegacyLootTables.GEEP_MAGENTA;
				break;
			case LIGHT_BLUE:
				resourcelocation = FossilsLegacyLootTables.GEEP_LIGHT_BLUE;
				break;
			case YELLOW:
				resourcelocation = FossilsLegacyLootTables.GEEP_YELLOW;
				break;
			case LIME:
				resourcelocation = FossilsLegacyLootTables.GEEP_LIME;
				break;
			case PINK:
				resourcelocation = FossilsLegacyLootTables.GEEP_PINK;
				break;
			case GRAY:
				resourcelocation = FossilsLegacyLootTables.GEEP_GRAY;
				break;
			case LIGHT_GRAY:
				resourcelocation = FossilsLegacyLootTables.GEEP_LIGHT_GRAY;
				break;
			case CYAN:
				resourcelocation = FossilsLegacyLootTables.GEEP_CYAN;
				break;
			case PURPLE:
				resourcelocation = FossilsLegacyLootTables.GEEP_PURPLE;
				break;
			case BLUE:
				resourcelocation = FossilsLegacyLootTables.GEEP_BLUE;
				break;
			case BROWN:
				resourcelocation = FossilsLegacyLootTables.GEEP_BROWN;
				break;
			case GREEN:
				resourcelocation = FossilsLegacyLootTables.GEEP_GREEN;
				break;
			case RED:
				resourcelocation = FossilsLegacyLootTables.GEEP_RED;
				break;
			case BLACK:
				resourcelocation = FossilsLegacyLootTables.GEEP_BLACK;
				break;
			default:
				throw new IncompatibleClassChangeError();
			}

			return resourcelocation;
		}
	}
}
