package willatendo.fossilslegacy.server.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FABlockTypes {
    public static final SimpleRegistry<MapCodec<? extends Block>> BLOCK_TYPES = SimpleRegistry.create(Registries.BLOCK_TYPE, FAUtils.ID);

    private static void register(String id, MapCodec<? extends Block> blockCodec) {
        BLOCK_TYPES.register(id, () -> blockCodec);
    }

    static {
        FABlockTypes.register("analyzer", AnalyzerBlock.CODEC);
        FABlockTypes.register("archaeology_workbench", ArchaeologyWorkbenchBlock.CODEC);
        FABlockTypes.register("axolotlspawn", AxolotlspawnBlock.CODEC);
        FABlockTypes.register("claytosmunda", ClaytosmundaBlock.CODEC);
        FABlockTypes.register("cooked_berry_medley_cauldron", CookedBerryMedleyCauldronBlock.CODEC);
        FABlockTypes.register("cooked_chicken_soup_cauldron", CookedChickenSoupCauldronBlock.CODEC);
        FABlockTypes.register("cooksonia", CooksoniaBlock.CODEC);
        FABlockTypes.register("corner_track", CornerTrackBlock.CODEC);
        FABlockTypes.register("cultivator", CultivatorBlock.CODEC);
        FABlockTypes.register("cycad_head", CycadHeadBlock.CODEC);
        FABlockTypes.register("cycad_log", CycadLogBlock.CODEC);
        FABlockTypes.register("decoration_post", DecorationPostBlock.CODEC);
        FABlockTypes.register("dipteris", DipterisBlock.CODEC);
        FABlockTypes.register("dna_coder", DNACoderBlock.CODEC);
        FABlockTypes.register("dna_hybridizer", DNAHybridizerBlock.CODEC);
        FABlockTypes.register("dna_recombinator", DNARecombinatorBlock.CODEC);
        FABlockTypes.register("drum", DrumBlock.CODEC);
        FABlockTypes.register("frozen_leech", FrozenLeechBlock.CODEC);
        FABlockTypes.register("horsetail", HorsetailBlock.CODEC);
        FABlockTypes.register("iced_stone", IcedStoneBlock.CODEC);
        FABlockTypes.register("jurassic_fern", JurassicFernBlock.CODEC);
        FABlockTypes.register("large_cage", LargeCageBlock.CODEC);
        FABlockTypes.register("leech_in_ice", LeechInIceBlock.CODEC);
        FABlockTypes.register("llama_statue", LlamaStatueBlock.CODEC);
        FABlockTypes.register("macrotaeniopteris", MacrotaeniopterisBlock.CODEC);
        FABlockTypes.register("mayan_vase", MayanVaseBlock.CODEC);
        FABlockTypes.register("medium_cage", MediumCageBlock.CODEC);
        FABlockTypes.register("palaeontology_table", PalaeontologyTableBlock.CODEC);
        FABlockTypes.register("permafrost", PermafrostBlock.CODEC);
        FABlockTypes.register("ramp_track", RampTrackBlock.CODEC);
        FABlockTypes.register("raw_berry_medley_cauldron", RawBerryMedleyCauldronBlock.CODEC);
        FABlockTypes.register("raw_chicken_soup_cauldron", RawChickenSoupCauldronBlock.CODEC);
        FABlockTypes.register("salvinia", SalviniaBlock.CODEC);
        FABlockTypes.register("shattered_cultivator", ShatteredCultivatorBlock.CODEC);
        FABlockTypes.register("skull", SkullBlock.CODEC);
        FABlockTypes.register("small_cage", SmallCageBlock.CODEC);
        FABlockTypes.register("straight_track", StraightTrackBlock.CODEC);
        FABlockTypes.register("tall_horsetail", TallHorsetailBlock.CODEC);
        FABlockTypes.register("time_machine", TimeMachineBlock.CODEC);
        FABlockTypes.register("weathering_copper_llama_statue", WeatheringCopperLlamaStatueBlock.CODEC);
        FABlockTypes.register("zamites_branch", ZamitesBranchBlock.CODEC);
        FABlockTypes.register("zamites_head", ZamitesHeadBlock.CODEC);
        FABlockTypes.register("zamites_log", ZamitesLogBlock.CODEC);
    }
}
