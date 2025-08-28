package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.blocks.HologramProjectorBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.hologram.HologramType;
import willatendo.fossilslegacy.server.registry.FARegistries;

public class HologramProjectorBlockEntity extends BlockEntity {
    private final DyeColor color;
    private Holder<HologramType> hologramType;

    public HologramProjectorBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(blockPos, blockState, ((HologramProjectorBlock) blockState.getBlock()).getColor());
    }

    public HologramProjectorBlockEntity(BlockPos blockPos, BlockState blockState, DyeColor color) {
        super(FABlockEntityTypes.HOLOGRAM_PROJECTOR.get(), blockPos, blockState);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }

    public Holder<HologramType> getHologramType() {
        return this.hologramType;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.saveAdditional(compoundTag, registries);
        if (this.hologramType != null) {
            compoundTag.putString("hologram_type", this.hologramType.getRegisteredName());
        }
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.loadAdditional(compoundTag, registries);
        if (compoundTag.contains("hologram_type")) {
            this.hologramType = registries.lookupOrThrow(FARegistries.HOLOGRAM_TYPE).getOrThrow(ResourceKey.create(FARegistries.HOLOGRAM_TYPE, ResourceLocation.parse(compoundTag.getString("hologram_type"))));
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundTag = new CompoundTag();
        if (this.hologramType != null) {
            compoundTag.putString("hologram_type", this.hologramType.getRegisteredName());
        }
        return compoundTag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
