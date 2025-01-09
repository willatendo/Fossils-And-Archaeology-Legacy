package willatendo.fossilslegacy.server.entity.util;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.entity.util.interfaces.GrowingEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.TameAccessor;
import willatendo.fossilslegacy.server.level.FossilsLegacyGameRules;

public class BlockBreakRule {
    private final Animal animal;
    private final Level level;
    private final int minimumAge;
    private final TagKey<Block> blockTag;

    public BlockBreakRule(Animal animal, int minimumAge, TagKey<Block> blockTag) {
        this.animal = animal;
        this.level = animal.level();
        this.minimumAge = minimumAge;
        this.blockTag = blockTag;
    }

    public boolean canUse() {
        if (this.level instanceof ServerLevel) {
            if (this.level.getGameRules().getBoolean(FossilsLegacyGameRules.RULE_DOANIMALBLOCKBREAKING) && this.animal instanceof GrowingEntity growningEntity) {
                if (growningEntity.getGrowthStage() >= this.minimumAge) {
                    if (this.animal instanceof TameAccessor tameAccessor) {
                        return !tameAccessor.isTame();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void tick() {
        for (int xOffset = (int) Math.round(this.animal.getBoundingBox().minX) - 1; xOffset <= (int) Math.round(this.animal.getBoundingBox().maxX) + 1; xOffset++) {
            for (int yOffset = (int) Math.round(this.animal.getBoundingBox().minY); (yOffset <= (int) Math.round(this.animal.getBoundingBox().maxY) + 3) && (yOffset <= 127); yOffset++) {
                for (int zOffset = (int) Math.round(this.animal.getBoundingBox().minZ) - 1; zOffset <= (int) Math.round(this.animal.getBoundingBox().maxZ) + 1; zOffset++) {
                    BlockPos blockPos = new BlockPos(xOffset, yOffset, zOffset);
                    BlockState blockState = this.level.getBlockState(blockPos);
                    if (!blockState.isAir() && blockState.isSolid()) {
                        if (yOffset < -64) {
                            return;
                        }
                        if (yOffset < this.animal.getY()) {
                            continue;
                        }
                        if (!blockState.is(this.blockTag)) {
                            this.level.playLocalSound(blockPos, blockState.getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
                            this.level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                }
            }
        }
    }
}
