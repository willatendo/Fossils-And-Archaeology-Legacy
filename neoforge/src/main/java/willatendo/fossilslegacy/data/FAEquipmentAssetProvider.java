package willatendo.fossilslegacy.data;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import willatendo.fossilslegacy.server.item.FAEquipmentAssets;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.function.BiConsumer;

public class FAEquipmentAssetProvider extends EquipmentAssetProvider {
    public FAEquipmentAssetProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(FAEquipmentAssets.ANCIENT, this.humanoid("ancient"));
        output.accept(FAEquipmentAssets.SCARAB_GEM, this.humanoid("scarab_gem"));
    }

    private EquipmentClientInfo humanoid(String name) {
        return EquipmentClientInfo.builder().addHumanoidLayers(FAUtils.resource(name)).build();
    }
}
