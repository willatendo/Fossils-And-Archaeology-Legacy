package willatendo.fossilslegacy.server.block;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.client.screen.DNARecombinatorScreen;
import willatendo.fossilslegacy.server.block.entity.entities.DNARecombinatorBlockEntity;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.items.DNAItem;
import willatendo.fossilslegacy.server.menu.menus.DNARecombinatorMenu;
import willatendo.fossilslegacy.server.menu.slot.GeneticCodeSlot;
import willatendo.fossilslegacy.server.menu.slot.ResultSlot;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Arrays;
import java.util.function.IntFunction;

public enum DNARecombinatorMode implements StringRepresentable {
    COSMETICS("cosmetics", FAUtils.resource("textures/gui/container/dna_recombinator_cosmetics.png"), new ItemStack(FAItems.LEGACY_GENETIC_CODE.get()), (slotLayout, menu, inventory, player, DNARecombinatorBlockEntity) -> {
        slotLayout.addSlot(new Slot(DNARecombinatorBlockEntity, 0, 8, 22) {
            @Override
            public int getMaxStackSize() {
                return 1;
            }

            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof DNAItem;
            }

            @Nullable
            @Override
            public ResourceLocation getNoItemIcon() {
                return DNARecombinatorScreen.EMPTY_SLOT_DNA;
            }
        });

        slotLayout.addSlot(new ResultSlot(player, DNARecombinatorBlockEntity, 1, 68, 22));

        menu.geneticSlots[0] = slotLayout.addSlot(new GeneticCodeSlot(DNARecombinatorBlockEntity, 2, 178, 18));
        menu.geneticSlots[1] = slotLayout.addSlot(new GeneticCodeSlot(DNARecombinatorBlockEntity, 3, 178, 36));
        menu.geneticSlots[2] = slotLayout.addSlot(new GeneticCodeSlot(DNARecombinatorBlockEntity, 4, 178, 54));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                slotLayout.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 120 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            slotLayout.addSlot(new Slot(inventory, column, 8 + column * 18, 178));
        }
    }, 0, 1, 2, 3, 4),
    ATTRIBUTES("attributes", FAUtils.resource("textures/gui/container/dna_recombinator_attributes.png"), new ItemStack(FAItems.LEGACY_GENETIC_CODE.get()), (slotLayout, menu, inventory, player, DNARecombinatorBlockEntity) -> {
        slotLayout.addSlot(new Slot(DNARecombinatorBlockEntity, 5, 16, 35) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof DNAItem dnaItem && dnaItem.hasAttributes();
            }

            @Nullable
            @Override
            public ResourceLocation getNoItemIcon() {
                return DNARecombinatorScreen.EMPTY_SLOT_DNA;
            }
        });

        slotLayout.addSlot(new ResultSlot(player, DNARecombinatorBlockEntity, 6, 72, 35));
        slotLayout.addSlot(new ResultSlot(player, DNARecombinatorBlockEntity, 7, 90, 35));
        slotLayout.addSlot(new ResultSlot(player, DNARecombinatorBlockEntity, 8, 108, 35));
        slotLayout.addSlot(new ResultSlot(player, DNARecombinatorBlockEntity, 9, 126, 35));
        slotLayout.addSlot(new ResultSlot(player, DNARecombinatorBlockEntity, 10, 144, 35));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                slotLayout.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            slotLayout.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }
    }, 5, 6, 7, 8, 9, 10),
    HYBRIDIZATION("hybridization", FAUtils.resource("textures/gui/container/dna_recombinator_hybridization.png"), new ItemStack(FAItems.LEGACY_GENETIC_CODE.get()), (slotLayout, menu, inventory, player, DNARecombinatorBlockEntity) -> {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                slotLayout.addSlot(new Slot(inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            slotLayout.addSlot(new Slot(inventory, column, 8 + column * 18, 142));
        }
    }, 11, 12, 13, 14, 15, 16);

    private static final IntFunction<DNARecombinatorMode> BY_ID = ByIdMap.continuous(DNARecombinatorMode::getId, DNARecombinatorMode.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StringRepresentable.EnumCodec<DNARecombinatorMode> CODEC = StringRepresentable.fromEnum(DNARecombinatorMode::values);
    public static final StreamCodec<ByteBuf, DNARecombinatorMode> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, DNARecombinatorMode::getId);

    private final String name;
    private final Component displayName;
    private final ResourceLocation backgroundTexture;
    private final ItemStack icon;
    private final SlotConfiguration slotConfiguration;
    private final int[] validSlots;

    DNARecombinatorMode(String name, ResourceLocation backgroundTexture, ItemStack icon, SlotConfiguration slotConfiguration, int... validSlots) {
        this.name = name;
        this.displayName = FAUtils.translation("container", "dna_recombinator.tab." + name);
        this.backgroundTexture = backgroundTexture;
        this.icon = icon;
        this.slotConfiguration = slotConfiguration;
        this.validSlots = validSlots;
    }

    public int getId() {
        return this.ordinal();
    }

    public Component getDisplayName() {
        return this.displayName;
    }

    public ResourceLocation getBackgroundTexture() {
        return this.backgroundTexture;
    }

    public ItemStack getIconItem() {
        return this.icon;
    }

    public SlotConfiguration getSlotConfiguration() {
        return this.slotConfiguration;
    }

    public boolean contains(int slot) {
        return Arrays.stream(this.validSlots).boxed().toList().contains(slot);
    }

    public void save(CompoundTag compoundTag) {
        compoundTag.putInt("mode", this.ordinal());
    }

    public static DNARecombinatorMode load(CompoundTag compoundTag) {
        return DNARecombinatorMode.values()[compoundTag.getInt("mode")];
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public interface SlotConfiguration {
        void addSlots(SlotLayout slotLayout, DNARecombinatorMenu menu, Inventory inventory, Player player, DNARecombinatorBlockEntity dnaRecombinatorBlockEntity);
    }

    public interface SlotLayout {
        Slot addSlot(Slot slot);
    }
}
