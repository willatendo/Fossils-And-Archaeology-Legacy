package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.blocks.HologramProjectorBlock;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.hologram.HologramType;
import willatendo.fossilslegacy.server.menu.menus.HologramProjectorMenu;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class HologramProjectorBlockEntity extends BlockEntity implements MenuProvider, Nameable {
    private final DyeColor color;
    private Holder<HologramType> hologramType;
    private Component name;

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
        if (this.name != null) {
            compoundTag.putString("custom_name", Component.Serializer.toJson(this.name, registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider registries) {
        super.loadAdditional(compoundTag, registries);
        if (compoundTag.contains("hologram_type")) {
            this.hologramType = registries.lookupOrThrow(FARegistries.HOLOGRAM_TYPE).getOrThrow(ResourceKey.create(FARegistries.HOLOGRAM_TYPE, ResourceLocation.parse(compoundTag.getString("hologram_type"))));
        }
        if (compoundTag.contains("custom_name", 8)) {
            this.name = BlockEntity.parseCustomNameSafe(compoundTag.getString("custom_name"), registries);
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

    @Override
    public Component getName() {
        return this.name != null ? this.name : FAUtils.translation("container", "hologram_projector");
    }

    @Override
    public Component getDisplayName() {
        return this.getName();
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory inventory, Player player) {
        return new HologramProjectorMenu(windowId, inventory, this);
    }
}
