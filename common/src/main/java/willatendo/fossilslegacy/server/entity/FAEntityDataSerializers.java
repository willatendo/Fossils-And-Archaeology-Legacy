package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.syncher.EntityDataSerializer;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;

import java.util.function.Supplier;

public final class FAEntityDataSerializers {
    public static final Supplier<EntityDataSerializer<Holder<CommandType>>> COMMAND_TYPES = FossilsModloaderHelper.INSTANCE.registerDataSerializer("command_types", ByteBufCodecs.holderRegistry(FARegistries.COMMAND_TYPES));
    public static final Supplier<EntityDataSerializer<Holder<FossilVariant>>> FOSSIL_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("fossil_variants", ByteBufCodecs.holderRegistry(FARegistries.FOSSIL_VARIANTS));
    public static final Supplier<EntityDataSerializer<Holder<ModelType>>> MODEL_TYPES = FossilsModloaderHelper.INSTANCE.registerDataSerializer("model_types", ByteBufCodecs.holderRegistry(FARegistries.MODEL_TYPES));
    public static final Supplier<EntityDataSerializer<Holder<Pattern>>> PATTERN = FossilsModloaderHelper.INSTANCE.registerDataSerializer("skin", ByteBufCodecs.holderRegistry(FARegistries.PATTERN));
    public static final Supplier<EntityDataSerializer<Holder<PregnancyType>>> PREGNANCY_TYPES = FossilsModloaderHelper.INSTANCE.registerDataSerializer("pregnancy_types", ByteBufCodecs.holderRegistry(FARegistries.PREGNANCY_TYPES));
    public static final Supplier<EntityDataSerializer<Holder<StoneTabletVariant>>> STONE_TABLET_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("stone_tablet_variants", ByteBufCodecs.holderRegistry(FARegistries.STONE_TABLET_VARIANTS));

    public static void init() {
    }
}
