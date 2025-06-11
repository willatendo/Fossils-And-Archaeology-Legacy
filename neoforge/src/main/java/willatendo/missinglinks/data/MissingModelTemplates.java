package willatendo.missinglinks.data;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import willatendo.missinglinks.server.util.MissingLinks2Utils;

import java.util.Optional;

public class MissingModelTemplates {
    public static final ModelTemplate TEMPLATE_LEVER = MissingModelTemplates.createMC("lever", MissingTextureSlot.BASE, MissingTextureSlot.LEVER, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LEVER_ON = MissingModelTemplates.createMC("lever_on", MissingTextureSlot.BASE, MissingTextureSlot.LEVER, TextureSlot.PARTICLE);

    public static ModelTemplate createMC(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(MissingLinks2Utils.mc("block/" + name)), Optional.empty(), requiredSlots);
    }

    public static ExtendedModelTemplateBuilder create(String name, TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.of(MissingLinks2Utils.resource("block/" + name)), Optional.empty(), requiredSlots));
    }

    public static ExtendedModelTemplateBuilder create(TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.empty(), Optional.empty(), requiredSlots));
    }

    public static ModelTemplate createItem(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(MissingLinks2Utils.resource("item/" + name)), Optional.empty(), requiredSlots);
    }
}
