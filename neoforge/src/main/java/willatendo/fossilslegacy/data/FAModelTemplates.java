package willatendo.fossilslegacy.data;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public final class FAModelTemplates {
    public static final ModelTemplate FROGSPAWN = FAModelTemplates.createMC("frogspawn", TextureSlot.TEXTURE, TextureSlot.PARTICLE).extend().renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_CULTIVATOR = FAModelTemplates.create("template_cultivator", TextureSlot.SIDE, TextureSlot.TOP).renderType("translucent").build();
    public static final ExtendedModelTemplate TEMPLATE_CULTIVATOR_ACTIVE = FAModelTemplates.create("template_cultivator_active", TextureSlot.SIDE, TextureSlot.TOP).renderType("translucent").build();
    public static final ExtendedModelTemplate TEMPLATE_SHATTERED_CULTIVATOR = FAModelTemplates.create("template_shattered_cultivator", TextureSlot.SIDE).renderType("translucent").build();
    public static final ExtendedModelTemplate TEMPLATE_DNA_HYBRIDIZER = FAModelTemplates.create("template_dna_hybridizer", TextureSlot.FRONT).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_SMALL_CAGE = FAModelTemplates.create("template_small_cage").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_SMALL_CAGE_OPEN = FAModelTemplates.create("template_small_cage_open").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MEDIUM_CAGE_BOTTOM = FAModelTemplates.create("template_medium_cage_bottom").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MEDIUM_CAGE_BOTTOM_OPEN_RIGHT = FAModelTemplates.create("template_medium_cage_bottom_open_right").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MEDIUM_CAGE_BOTTOM_OPEN_LEFT = FAModelTemplates.create("template_medium_cage_bottom_open_left").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MEDIUM_CAGE_TOP = FAModelTemplates.create("template_medium_cage_top").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MEDIUM_CAGE_TOP_OPEN_LEFT = FAModelTemplates.create("template_medium_cage_top_open_left").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MEDIUM_CAGE_TOP_OPEN_RIGHT = FAModelTemplates.create("template_medium_cage_top_open_right").renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_CYCAD_HEAD_CONE = FAModelTemplates.create("template_cycad_head_cone", TextureSlot.SIDE, TextureSlot.TOP, FATextureSlot.LEAVES, FATextureSlot.HEAD).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_CYCAD_HEAD_NO_CONE = FAModelTemplates.create("template_cycad_head_no_cone", TextureSlot.SIDE, TextureSlot.TOP, FATextureSlot.LEAVES).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_CYCAD_LOG_1 = FAModelTemplates.create("template_cycad_log_1", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_CYCAD_LOG_2 = FAModelTemplates.create("template_cycad_log_2", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_CYCAD_LOG_3 = FAModelTemplates.create("template_cycad_log_3", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_COOKSONIA_1 = FAModelTemplates.create("template_cooksonia_1", TextureSlot.TEXTURE).build();
    public static final ExtendedModelTemplate TEMPLATE_COOKSONIA_2 = FAModelTemplates.create("template_cooksonia_2", TextureSlot.TEXTURE).build();
    public static final ExtendedModelTemplate TEMPLATE_COOKSONIA_3 = FAModelTemplates.create("template_cooksonia_3", TextureSlot.TEXTURE).build();
    public static final ExtendedModelTemplate TEMPLATE_COOKSONIA_4 = FAModelTemplates.create("template_cooksonia_4", TextureSlot.TEXTURE).build();
    public static final ExtendedModelTemplate TEMPLATE_CLAYTOSMUNDA = FAModelTemplates.create("template_claytosmunda", FATextureSlot.SHORT_LEAVES, FATextureSlot.TALL_LEAVES).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_CYCADEOIDEA = FAModelTemplates.create("template_cycadeoidea", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_DECORATION_PLAQUE_POST = FAModelTemplates.create("template_decoration_plaque_post", FATextureSlot.POST).build();
    public static final ExtendedModelTemplate TEMPLATE_PLANT_1 = FAModelTemplates.create("template_plant_1", FATextureSlot.PLANT_1).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_PLANT_2 = FAModelTemplates.create("template_plant_2", FATextureSlot.PLANT_2).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_PLANT_3 = FAModelTemplates.create("template_plant_3", FATextureSlot.PLANT_3).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_STEM_1 = FAModelTemplates.create("template_macrotaeniopteris_stem_1", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_STEM_2 = FAModelTemplates.create("template_macrotaeniopteris_stem_2", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_STEM_3 = FAModelTemplates.create("template_macrotaeniopteris_stem_3", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_STEM_4 = FAModelTemplates.create("template_macrotaeniopteris_stem_4", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_STEM_5 = FAModelTemplates.create("template_macrotaeniopteris_stem_5", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_LEAF_1 = FAModelTemplates.create("template_macrotaeniopteris_leaf_1", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_LEAF_2 = FAModelTemplates.create("template_macrotaeniopteris_leaf_2", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_LEAF_3 = FAModelTemplates.create("template_macrotaeniopteris_leaf_3", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_LEAF_4 = FAModelTemplates.create("template_macrotaeniopteris_leaf_4", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_MACROTAENIOPTERIS_LEAF_5 = FAModelTemplates.create("template_macrotaeniopteris_leaf_5", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_DIPTERIS = FAModelTemplates.create("template_dipteris", TextureSlot.TEXTURE).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_RAIL_RAMP_1 = FAModelTemplates.create("template_rail_ramp_1", TextureSlot.RAIL).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_RAIL_RAMP_2 = FAModelTemplates.create("template_rail_ramp_2", TextureSlot.RAIL).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_RAIL_RAMP_3 = FAModelTemplates.create("template_rail_ramp_3", TextureSlot.RAIL).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_RAIL_RAMP_4 = FAModelTemplates.create("template_rail_ramp_4", TextureSlot.RAIL).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_1 = FAModelTemplates.create("template_soup_cauldron_1", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_2 = FAModelTemplates.create("template_soup_cauldron_2", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_3 = FAModelTemplates.create("template_soup_cauldron_3", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_4 = FAModelTemplates.create("template_soup_cauldron_4", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_5 = FAModelTemplates.create("template_soup_cauldron_5", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_6 = FAModelTemplates.create("template_soup_cauldron_6", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_7 = FAModelTemplates.create("template_soup_cauldron_7", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_SOUP_CAULDRON_8 = FAModelTemplates.create("template_soup_cauldron_8", TextureSlot.CONTENT).build();
    public static final ExtendedModelTemplate TEMPLATE_COLORED_CROP = FAModelTemplates.create("template_colored_crop", TextureSlot.CROP, FATextureSlot.CROP_LEAVES).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_DNA_RECOMBINATOR = FAModelTemplates.create("template_dna_recombinator", TextureSlot.FRONT).build();
    public static final ExtendedModelTemplate TEMPLATE_TIME_MACHINE = FAModelTemplates.create("template_time_machine").build();
    public static final ExtendedModelTemplate TEMPLATE_VASE = FAModelTemplates.create("template_vase", TextureSlot.SIDE).build();
    public static final ExtendedModelTemplate TEMPLATE_LLAMA = FAModelTemplates.create("template_llama", TextureSlot.TEXTURE, TextureSlot.PARTICLE).build();
    public static final ExtendedModelTemplate TEMPLATE_LIQUID = FAModelTemplates.create(TextureSlot.PARTICLE).build();
    public static final ExtendedModelTemplate TEMPLATE_FROZEN_LEECH = FAModelTemplates.create("template_frozen_leech", TextureSlot.TEXTURE).build();
    public static final ExtendedModelTemplate TEMPLATE_RESTORATION_TABLE = FAModelTemplates.create("template_restoration_table", TextureSlot.TEXTURE).build();
    public static final ExtendedModelTemplate TEMPLATE_ZAMITES_HEAD = FAModelTemplates.create("template_zamites_head", TextureSlot.SIDE, TextureSlot.TOP, FATextureSlot.LEAVES).renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_ZAMITES_LOG_BRANCH = FAModelTemplates.create("template_zamites_log_branch", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_ZAMITES_LOG_SMALL = FAModelTemplates.create("template_zamites_log_small", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_ZAMITES_LOG_LARGE = FAModelTemplates.create("template_zamites_log_large", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_ZAMITES_BRANCH = FAModelTemplates.create("template_zamites_branch", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate TEMPLATE_ZAMITES_BRANCH_TOP = FAModelTemplates.create("template_zamites_branch_top", TextureSlot.SIDE, TextureSlot.TOP, FATextureSlot.LEAVES).renderType("cutout").build();

    public static final ModelTemplate TEMPLATE_ARTICULATED_FOSSIL = FAModelTemplates.createItem("template_articulated_fossil", TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_RIFLE = FAModelTemplates.createItem("template_rifle", TextureSlot.TEXTURE);

    public static ModelTemplate createMC(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.mc("block/" + name)), Optional.empty(), requiredSlots);
    }

    public static ExtendedModelTemplateBuilder create(String name, TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.of(FAUtils.resource("block/" + name)), Optional.empty(), requiredSlots));
    }

    public static ExtendedModelTemplateBuilder create(TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.empty(), Optional.empty(), requiredSlots));
    }

    public static ModelTemplate createItem(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.resource("item/" + name)), Optional.empty(), requiredSlots);
    }
}
