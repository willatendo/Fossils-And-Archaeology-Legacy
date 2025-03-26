package willatendo.fossilslegacy.data;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public class FAModelTemplates {
    public static final ModelTemplate FROGSPAWN = FAModelTemplates.createMC("frogspawn", TextureSlot.TEXTURE, TextureSlot.PARTICLE).extend().renderType("cutout").build();
    public static final ExtendedModelTemplate TEMPLATE_CULTIVATOR = FAModelTemplates.create("template_cultivator", TextureSlot.SIDE, TextureSlot.TOP).renderType("translucent").build();
    public static final ExtendedModelTemplate TEMPLATE_CULTIVATOR_ACTIVE = FAModelTemplates.create("template_cultivator_active", TextureSlot.SIDE, TextureSlot.TOP).renderType("translucent").build();
    public static final ExtendedModelTemplate TEMPLATE_DECORATION_PLAQUE_POST = FAModelTemplates.create("template_decoration_plaque_post", FATextureSlot.POST).build();
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

    public static final ModelTemplate TEMPLATE_ARTICULATED_FOSSIL = FAModelTemplates.createItem("template_articulated_fossil", TextureSlot.PARTICLE);

    public static ModelTemplate createMC(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.mc("block/" + name)), Optional.empty(), requiredSlots);
    }

    public static ExtendedModelTemplateBuilder create(String name, TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.of(FAUtils.resource("block/" + name)), Optional.empty(), requiredSlots));
    }

    public static ModelTemplate createItem(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.resource("item/" + name)), Optional.empty(), requiredSlots);
    }
}
