package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import willatendo.fossilslegacy.platform.FAModloaderHelper;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;

import java.util.function.Supplier;

public final class FAEntityDataSerializers {
    public static final Supplier<EntityDataSerializer<Holder<CommandType>>> COMMAND_TYPES = FAModloaderHelper.INSTANCE.registerDataSerializer("command_types", ByteBufCodecs.holderRegistry(FARegistries.COMMAND_TYPES));
    public static final Supplier<EntityDataSerializer<Holder<DecorationPlaqueType>>> DECORATION_PLAQUE_TYPE = FAModloaderHelper.INSTANCE.registerDataSerializer("decoration_plaque_type", ByteBufCodecs.holderRegistry(FARegistries.DECORATION_PLAQUE_TYPE));
    public static final Supplier<EntityDataSerializer<Holder<FossilVariant>>> FOSSIL_VARIANTS = FAModloaderHelper.INSTANCE.registerDataSerializer("fossil_variants", ByteBufCodecs.holderRegistry(FARegistries.FOSSIL_VARIANTS));
    public static final Supplier<EntityDataSerializer<Holder<ModelType>>> MODEL_TYPES = FAModloaderHelper.INSTANCE.registerDataSerializer("model_types", ByteBufCodecs.holderRegistry(FARegistries.MODEL_TYPES));
    public static final Supplier<EntityDataSerializer<Holder<Pattern>>> PATTERN = FAModloaderHelper.INSTANCE.registerDataSerializer("skin", ByteBufCodecs.holderRegistry(FARegistries.PATTERN));
    public static final Supplier<EntityDataSerializer<Holder<PregnancyType>>> PREGNANCY_TYPES = FAModloaderHelper.INSTANCE.registerDataSerializer("pregnancy_types", ByteBufCodecs.holderRegistry(FARegistries.PREGNANCY_TYPE));
    public static final Supplier<EntityDataSerializer<Holder<StoneTabletVariant>>> STONE_TABLET_VARIANTS = FAModloaderHelper.INSTANCE.registerDataSerializer("stone_tablet_variants", ByteBufCodecs.holderRegistry(FARegistries.STONE_TABLET_VARIANT));
    public static final Supplier<EntityDataSerializer<FossilRotations>> FOSSIL_ROTATIONS = FAModloaderHelper.INSTANCE.registerDataSerializer("fossil_rotations", EntityDataSerializer.forValueType(FossilRotations.STREAM_CODEC));

    public static void init() {
    }
}
