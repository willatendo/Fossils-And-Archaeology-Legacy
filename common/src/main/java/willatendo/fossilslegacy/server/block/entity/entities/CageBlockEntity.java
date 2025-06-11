package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;

public class CageBlockEntity extends BlockEntity {
    private static final String ENTITY_DATA = "entity_data";
    private CompoundTag compoundTag;

    public CageBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.CAGE.get(), blockPos, blockState);
    }

    public CompoundTag getCompoundTag() {
        return this.compoundTag;
    }

    public void setCompoundTag(CompoundTag compoundTag) {
        this.compoundTag = compoundTag;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (compoundTag.contains(ENTITY_DATA)) {
            this.compoundTag = compoundTag.getCompound(ENTITY_DATA);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        if (this.compoundTag != null) {
            compoundTag.put(ENTITY_DATA, this.compoundTag);
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        if (this.compoundTag != null) {
            compoundTag.put(ENTITY_DATA, this.compoundTag);
        }
        return compoundTag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
