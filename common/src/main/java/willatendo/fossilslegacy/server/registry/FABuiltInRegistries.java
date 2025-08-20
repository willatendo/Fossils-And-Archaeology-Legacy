package willatendo.fossilslegacy.server.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.dinopedia_entry.line.DinopediaLineType;
import willatendo.fossilslegacy.server.gene.attributes.AttributeGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.PackageTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.type.TextureType;
import willatendo.fossilslegacy.server.gene.inheritance.InheritanceRules;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.simplelibrary.server.util.SimpleRegistryBuilder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public final class FABuiltInRegistries {
    public static final Registry<CommandType> COMMAND_TYPES = SimpleUtils.createRegistry(FARegistries.COMMAND_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends CompositeTextureRules.ConditionSource>> COMPOSITE_TEXTURE_CONDITION = SimpleUtils.createRegistry(FARegistries.COMPOSITE_TEXTURE_CONDITION, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends CompositeTextureRules.RuleSource>> COMPOSITE_TEXTURE_RULE = SimpleUtils.createRegistry(FARegistries.COMPOSITE_TEXTURE_RULE, SimpleRegistryBuilder.of().sync());
    public static final Registry<DinopediaLineType<?>> DINOPEDIA_LINE_TYPES = SimpleUtils.createRegistry(FARegistries.DINOPEDIA_LINE_TYPE, SimpleRegistryBuilder.of().sync());
    public static final Registry<AttributeGene> GENE = SimpleUtils.createRegistry(FARegistries.ATTRIBUTE_GENE, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends InheritanceRules.ConditionSource>> INHERITANCE_CONDITION = SimpleUtils.createRegistry(FARegistries.INHERITANCE_CONDITION, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends InheritanceRules.RuleSource>> INHERITANCE_RULE = SimpleUtils.createRegistry(FARegistries.INHERITANCE_RULE, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends PackageTextureRules.ConditionSource>> PACKAGE_TEXTURE_CONDITION = SimpleUtils.createRegistry(FARegistries.PACKAGE_TEXTURE_CONDITION, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends PackageTextureRules.RuleSource>> PACKAGE_TEXTURE_RULE = SimpleUtils.createRegistry(FARegistries.PACKAGE_TEXTURE_RULE, SimpleRegistryBuilder.of().sync());
    public static final Registry<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FARegistries.PREGNANCY_TYPE, SimpleRegistryBuilder.of().sync());
    public static final Registry<MapCodec<? extends TextureType>> TEXTURE_TYPE = SimpleUtils.createRegistry(FARegistries.TEXTURE_TYPE, SimpleRegistryBuilder.of().sync());

    public static void init() {
    }
}
