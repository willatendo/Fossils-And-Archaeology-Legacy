package willatendo.fossilslegacy.data;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public class FAModelTemplates {
    public static final ModelTemplate FROGSPAWN = FAModelTemplates.createMC("frogspawn", TextureSlot.TEXTURE, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_CULTIVATOR = FAModelTemplates.create("template_cultivator", TextureSlot.SIDE, TextureSlot.TOP);
    public static final ModelTemplate TEMPLATE_CULTIVATOR_ACTIVE = FAModelTemplates.create("template_cultivator_active", TextureSlot.SIDE, TextureSlot.TOP);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_1 = FAModelTemplates.create("template_soup_cauldron_1", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_2 = FAModelTemplates.create("template_soup_cauldron_2", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_3 = FAModelTemplates.create("template_soup_cauldron_3", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_4 = FAModelTemplates.create("template_soup_cauldron_4", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_5 = FAModelTemplates.create("template_soup_cauldron_5", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_6 = FAModelTemplates.create("template_soup_cauldron_6", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_7 = FAModelTemplates.create("template_soup_cauldron_7", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_SOUP_CAULDRON_8 = FAModelTemplates.create("template_soup_cauldron_8", TextureSlot.CONTENT);
    public static final ModelTemplate TEMPLATE_COLORED_CROP = FAModelTemplates.create("template_colored_crop", TextureSlot.CROP, FATextureSlot.CROP_LEAVES);
    public static final ModelTemplate TEMPLATE_GENE_MODIFICATION_TABLE = FAModelTemplates.create("template_gene_modification_table", TextureSlot.FRONT);
    public static final ModelTemplate TEMPLATE_TIME_MACHINE = FAModelTemplates.create("template_time_machine");
    public static final ModelTemplate TEMPLATE_VASE = FAModelTemplates.create("template_vase", TextureSlot.SIDE);
    public static final ModelTemplate TEMPLATE_LLAMA = FAModelTemplates.create("template_llama", TextureSlot.TEXTURE, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_ARTICULATED_FOSSIL = FAModelTemplates.createItem("template_articulated_fossil",  TextureSlot.PARTICLE);

    public static ModelTemplate createMC(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.mc("block/" + name)), Optional.empty(), requiredSlots);
    }

    public static ModelTemplate create(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.resource("block/" + name)), Optional.empty(), requiredSlots);
    }

    public static ModelTemplate createItem(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(FAUtils.resource("item/" + name)), Optional.empty(), requiredSlots);
    }
}
