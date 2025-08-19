package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.data_components.HeadDisplayInformation;

public class HeadBlockEntity extends BlockEntity {
    public HeadDisplayInformation headDisplayInformation;

    public HeadBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.HEAD.get(), blockPos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.saveAdditional(compoundTag, registries);
        if (this.headDisplayInformation != null) {
            CompoundTag headDisplayInformation = new CompoundTag();
            this.headDisplayInformation.saveAdditional(headDisplayInformation);
            compoundTag.put("head_display_information", headDisplayInformation);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.loadAdditional(compoundTag, registries);
        if (compoundTag.contains("head_display_information")) {
            this.headDisplayInformation = HeadDisplayInformation.loadAdditional(compoundTag.getCompound("head_display_information"));
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundTag = new CompoundTag();
        if (this.headDisplayInformation != null) {
            CompoundTag headDisplayInformation = new CompoundTag();
            this.headDisplayInformation.saveAdditional(headDisplayInformation);
            compoundTag.put("head_display_information", headDisplayInformation);
        }
        return compoundTag;
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(FADataComponents.HEAD_DISPLAY_INFORMATION.get(), this.headDisplayInformation);
    }

    @Override
    protected void applyImplicitComponents(DataComponentInput dataComponentInput) {
        super.applyImplicitComponents(dataComponentInput);
        this.headDisplayInformation = dataComponentInput.getOrDefault(FADataComponents.HEAD_DISPLAY_INFORMATION.get(), HeadDisplayInformation.NONE);
    }

    @Override
    public void removeComponentsFromTag(CompoundTag compoundTag) {
        compoundTag.remove("head_display_information");
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
