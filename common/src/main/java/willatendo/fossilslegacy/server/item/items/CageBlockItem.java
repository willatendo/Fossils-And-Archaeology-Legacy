package willatendo.fossilslegacy.server.item.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.entity.entities.CageBlockEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.TranquilizableEntity;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class CageBlockItem extends BlockItem {
    private final int maxWidth;
    private final int maxHeight;

    public CageBlockItem(int maxWidth, int maxHeight, Block block, Properties properties) {
        super(block, properties);
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos blockPos, Level level, Player player, ItemStack itemStack, BlockState blockState) {
        if (itemStack.has(DataComponents.CUSTOM_DATA) && level.getBlockEntity(blockPos) instanceof CageBlockEntity cageBlockEntity) {
            cageBlockEntity.setCompoundTag(itemStack.get(DataComponents.CUSTOM_DATA).copyTag());
        }
        return super.updateCustomBlockEntityTag(blockPos, level, player, itemStack, blockState);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltips, TooltipFlag tooltipFlag) {
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CustomData customData = itemStack.get(DataComponents.CUSTOM_DATA);
            CompoundTag compoundTag = customData.copyTag();
            EntityType<?> entityType = BuiltInRegistries.ENTITY_TYPE.getValue(ResourceLocation.parse(compoundTag.getString("entity_type")));
            tooltips.add(FAUtils.translation("block", "small_cage.desc", compoundTag.contains("CustomName") ? Component.Serializer.fromJson(compoundTag.getString("CustomName"), tooltipContext.registries()) : entityType.getDescription()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltips, tooltipFlag);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity.dimensions.width() <= this.maxWidth && livingEntity.dimensions.height() <= this.maxHeight && livingEntity instanceof TranquilizableEntity tranquilizableEntity && tranquilizableEntity.isTranquilized()) {
            CompoundTag entityInformaiton = new CompoundTag();
            entityInformaiton.putString("entity_type", BuiltInRegistries.ENTITY_TYPE.getKey(livingEntity.getType()).toString());
            livingEntity.saveWithoutId(entityInformaiton);
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(entityInformaiton));
            player.setItemInHand(interactionHand, itemStack);
            livingEntity.remove(Entity.RemovalReason.DISCARDED);
            FAUtils.LOGGER.info("Data: {}", entityInformaiton);
            return InteractionResult.SUCCESS;
        }
        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
