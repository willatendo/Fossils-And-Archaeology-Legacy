package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FADecorationPlaqueTypeTags;

import java.util.List;
import java.util.Optional;

public class DecorationPostBlockEntity extends BlockEntity {
    private static final String KEY = "decoration_plaque";
    private Holder<DecorationPlaqueType> decorationPlaqueType;

    public DecorationPostBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.DECORATION_POST.get(), blockPos, blockState);
    }

    public Holder<DecorationPlaqueType> getDecorationPlaqueType() {
        return this.decorationPlaqueType;
    }

    public void setDecorationPlaqueType(Holder<DecorationPlaqueType> decorationPlaqueType) {
        this.decorationPlaqueType = decorationPlaqueType;
    }

    public boolean setDecorationPlaqueType(ServerLevel serverLevel, Player player) {
        if (player.isCrouching()) {
            this.setDecorationPlaqueType(null);
        } else {
            List<Holder<DecorationPlaqueType>> decorationPlaqueTypes = serverLevel.registryAccess().lookupOrThrow(FARegistries.DECORATION_PLAQUE_TYPE).get(FADecorationPlaqueTypeTags.PLACEABLE).get().stream().toList();
            Holder<DecorationPlaqueType> decorationPlaqueTypeHolder;
            if (this.getDecorationPlaqueType() != null) {
                int index = decorationPlaqueTypes.indexOf(this.getDecorationPlaqueType()) + 1;
                if (index < decorationPlaqueTypes.size()) {
                    decorationPlaqueTypeHolder = decorationPlaqueTypes.get(index);
                } else {
                    decorationPlaqueTypeHolder = decorationPlaqueTypes.getFirst();
                }
            } else {
                decorationPlaqueTypeHolder = decorationPlaqueTypes.getFirst();
            }
            this.setDecorationPlaqueType(decorationPlaqueTypeHolder);
        }
        serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(player, this.getBlockState()));
        this.setChanged();
        serverLevel.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        return true;
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        if (compoundTag.contains(KEY)) {
            Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString(KEY))).map(id -> ResourceKey.create(FARegistries.DECORATION_PLAQUE_TYPE, id)).flatMap(resourceKey -> provider.lookupOrThrow(FARegistries.DECORATION_PLAQUE_TYPE).get(resourceKey)).ifPresent(this::setDecorationPlaqueType);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (this.decorationPlaqueType != null) {
            this.getDecorationPlaqueType().unwrapKey().ifPresent(modelType -> compoundTag.putString(KEY, modelType.location().toString()));
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        if (this.decorationPlaqueType != null) {
            this.getDecorationPlaqueType().unwrapKey().ifPresent(modelType -> compoundTag.putString(KEY, modelType.location().toString()));
        } else {
            if (compoundTag.contains(KEY)) {
                compoundTag.remove(KEY);
            }
        }
        return compoundTag;
    }
}
