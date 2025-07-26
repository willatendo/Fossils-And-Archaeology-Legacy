package willatendo.fossilslegacy.client.user_manual;

import com.mojang.serialization.JsonOps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.Map;

public class UserManualItemDataLoader extends SimpleJsonResourceReloadListener<UserManualItemDisplayData> {
    public static final UserManualItemDataLoader INSTANCE = new UserManualItemDataLoader();
    private static final FileToIdConverter ASSET_LISTER = FileToIdConverter.json("fossilslegacy/user_manual/item_data");

    private UserManualItemDataLoader() {
        super(UserManualItemDisplayData.CODEC, ASSET_LISTER);
    }

    @Override
    protected Map<ResourceLocation, UserManualItemDisplayData> prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
        Map<ResourceLocation, UserManualItemDisplayData> map = new HashMap<>();
        scanDirectory(resourceManager, UserManualItemDataLoader.ASSET_LISTER, JsonOps.INSTANCE, UserManualItemDisplayData.CODEC, map);
        return map;
    }

    @Override
    protected void apply(Map<ResourceLocation, UserManualItemDisplayData> jsons, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        UserManualData.ITEM_DISPLAY_DATA.clear();

        jsons.forEach((resourceLocation, userManualDisplayData) -> {
            UserManualData.ITEM_DISPLAY_DATA.put(BuiltInRegistries.ITEM.getValue(resourceLocation), userManualDisplayData);
        });
    }
}
