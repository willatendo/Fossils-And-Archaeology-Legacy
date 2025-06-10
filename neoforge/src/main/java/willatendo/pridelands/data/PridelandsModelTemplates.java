package willatendo.pridelands.data;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import willatendo.pridelands.server.utils.PridelandsUtils;

import java.util.Optional;

public final class PridelandsModelTemplates {
    public static final ExtendedModelTemplate BONGO = PridelandsModelTemplates.create("template_bongo", TextureSlot.SIDE, TextureSlot.TOP).build();
    public static final ExtendedModelTemplate WIDE_TORCH = PridelandsModelTemplates.create("template_wide_torch", TextureSlot.TORCH).renderType("cutout").build();
    public static final ExtendedModelTemplate WIDE_WALL_TORCH = PridelandsModelTemplates.create("template_wide_wall_torch", TextureSlot.TORCH).renderType("cutout").build();

    public static final ModelTemplate CAKE = PridelandsModelTemplates.createMC("cake", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate CAKE_SLICE1 = PridelandsModelTemplates.createMC("cake_slice1", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate CAKE_SLICE2 = PridelandsModelTemplates.createMC("cake_slice2", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate CAKE_SLICE3 = PridelandsModelTemplates.createMC("cake_slice3", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate CAKE_SLICE4 = PridelandsModelTemplates.createMC("cake_slice4", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate CAKE_SLICE5 = PridelandsModelTemplates.createMC("cake_slice5", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate CAKE_SLICE6 = PridelandsModelTemplates.createMC("cake_slice6", TextureSlot.PARTICLE, TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.INSIDE);
    public static final ModelTemplate NETHER_PORTAL_NS = PridelandsModelTemplates.createMC("nether_portal_ns", TextureSlot.PARTICLE, PridelandsTextureSlot.PORTAL).extend().renderType("translucent").build();
    public static final ModelTemplate NETHER_PORTAL_EW = PridelandsModelTemplates.createMC("nether_portal_ew", TextureSlot.PARTICLE, PridelandsTextureSlot.PORTAL).extend().renderType("translucent").build();

    public static ModelTemplate createMC(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(PridelandsUtils.mc("block/" + name)), Optional.empty(), requiredSlots);
    }

    public static ExtendedModelTemplateBuilder create(String name, TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.of(PridelandsUtils.resource("block/" + name)), Optional.empty(), requiredSlots));
    }

    public static ExtendedModelTemplateBuilder create(TextureSlot... requiredSlots) {
        return ExtendedModelTemplateBuilder.of(new ModelTemplate(Optional.empty(), Optional.empty(), requiredSlots));
    }
}
