package willatendo.fossilslegacy.server.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.blocks.AxolotlspawnBlock;
import willatendo.fossilslegacy.server.block.blocks.JurassicFernBlock;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FABlockTypes {
    public static final SimpleRegistry<MapCodec<? extends Block>> BLOCK_TYPES = SimpleRegistry.create(Registries.BLOCK_TYPE, FAUtils.ID);

    public static final SimpleHolder<MapCodec<? extends Block>> AXOLOTLSPAWN = BLOCK_TYPES.register("axolotlspawn", () -> AxolotlspawnBlock.CODEC);
    public static final SimpleHolder<MapCodec<? extends Block>> JURASSIC_FERN = BLOCK_TYPES.register("jurassic_fern", () -> JurassicFernBlock.CODEC);
}
