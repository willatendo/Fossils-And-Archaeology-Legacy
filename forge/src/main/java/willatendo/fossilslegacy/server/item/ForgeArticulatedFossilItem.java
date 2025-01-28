package willatendo.fossilslegacy.server.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import willatendo.fossilslegacy.client.FABlockEntityWithoutLevelRenderer;
import willatendo.fossilslegacy.server.item.items.ArticulatedFossilItem;

import java.util.function.Consumer;

public class ForgeArticulatedFossilItem extends ArticulatedFossilItem {
    public ForgeArticulatedFossilItem(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return FABlockEntityWithoutLevelRenderer.INSTANCE;
            }
        });
    }
}
