package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.item.FADataComponents;

import java.util.UUID;

public class CageBlockEntity extends BlockEntity {
    private static final String ENTITY_DATA = "entity_data";
    private CompoundTag compoundTag;
    private UUID lock = null;

    public CageBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.CAGE.get(), blockPos, blockState);
    }

    public CompoundTag getCompoundTag() {
        return this.compoundTag;
    }

    public void setCompoundTag(CompoundTag compoundTag) {
        this.compoundTag = compoundTag;
    }

    public UUID getLock() {
        return this.lock;
    }

    public void setLock(UUID lock) {
        this.lock = lock;
    }

    public boolean canOpen(ItemStack itemStack) {
        return lock == null || itemStack.has(FADataComponents.LOCK.get()) && itemStack.get(FADataComponents.LOCK.get()).equals(this.lock);
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (compoundTag.contains(ENTITY_DATA)) {
            this.compoundTag = compoundTag.getCompound(ENTITY_DATA);
        }
        if (this.lock != null) {
            compoundTag.putUUID("lock", this.getLock());
        }
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        if (this.compoundTag != null) {
            compoundTag.put(ENTITY_DATA, this.compoundTag);
        }
        if (compoundTag.contains("lock")) {
            this.setLock(compoundTag.getUUID("lock"));
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        if (this.compoundTag != null) {
            compoundTag.put(ENTITY_DATA, this.compoundTag);
        }
        if (this.lock != null) {
            compoundTag.putUUID("lock", this.getLock());
        }
        return compoundTag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
