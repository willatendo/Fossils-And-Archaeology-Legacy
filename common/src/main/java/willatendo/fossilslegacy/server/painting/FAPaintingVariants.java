package willatendo.fossilslegacy.server.painting;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;

public final class FAPaintingVariants {
    public static final ResourceKey<PaintingVariant> AGE_OF_REPTILES = create("age_of_reptiles");

    public static ResourceKey<PaintingVariant> create(String name) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, FAUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<PaintingVariant> bootstrapContext) {
        FAPaintingVariants.register(bootstrapContext, AGE_OF_REPTILES, 3, 2);
    }

    private static void register(BootstrapContext<PaintingVariant> bootstrapContext, ResourceKey<PaintingVariant> resourceKey, int width, int height) {
        FAPaintingVariants.register(bootstrapContext, resourceKey, width, height, true);
    }

    private static void register(BootstrapContext<PaintingVariant> bootstrapContext, ResourceKey<PaintingVariant> resourceKey, int width, int height, boolean hasAuthor) {
        bootstrapContext.register(resourceKey, new PaintingVariant(width, height, resourceKey.location(), Optional.of(Component.translatable(resourceKey.location().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW)), hasAuthor ? Optional.of(Component.translatable(resourceKey.location().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY)) : Optional.empty()));
    }
}
