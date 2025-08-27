package willatendo.fossilslegacy.server.gene.cosmetics.texture;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.AffixType;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public final class CompositeTextureRules {
    public static final SimpleRegistry<MapCodec<? extends CompositeTextureRules.RuleSource>> RULE_SOURCES = SimpleRegistry.create(FARegistries.COMPOSITE_TEXTURE_RULE, FAUtils.ID);
    public static final SimpleRegistry<MapCodec<? extends CompositeTextureRules.ConditionSource>> RULE_CONDITIONS = SimpleRegistry.create(FARegistries.COMPOSITE_TEXTURE_CONDITION, FAUtils.ID);

    static {
        RULE_SOURCES.register("condition", () -> CompositeTextureRules.TestRuleSource.CODEC);
        RULE_SOURCES.register("composite_texture", () -> CompositeTextureRules.CompositeTextureRuleSource.CODEC);
        RULE_SOURCES.register("sequence", () -> CompositeTextureRules.SequenceRuleSource.CODEC);

        RULE_CONDITIONS.register("is_baby", () -> CompositeTextureRules.IsBabyConditionSource.CODEC);
        RULE_CONDITIONS.register("is_entity_type", () -> CompositeTextureRules.EntityTypeConditionSource.CODEC);
        RULE_CONDITIONS.register("is_tame", () -> CompositeTextureRules.IsTameConditionSource.CODEC);
        RULE_CONDITIONS.register("not", () -> CompositeTextureRules.NotConditionSource.CODEC);
    }

    public static CompositeTextureRules.EntityTypeConditionSource isEntity(ResourceKey<EntityType<?>>... skinGenes) {
        return CompositeTextureRules.isEntity(List.of(skinGenes));
    }

    private static CompositeTextureRules.EntityTypeConditionSource isEntity(List<ResourceKey<EntityType<?>>> skinGenes) {
        return new CompositeTextureRules.EntityTypeConditionSource(skinGenes);
    }

    public static CompositeTextureRules.RuleSource texture(String layer, Optional<String> eyeTexture, AffixType affixType, Optional<String> textureName) {
        return new CompositeTextureRules.CompositeTextureRuleSource(layer, eyeTexture, affixType, textureName);
    }

    public static CompositeTextureRules.RuleSource layer0(AffixType affixType, String affix) {
        return CompositeTextureRules.texture("layer0", Optional.empty(), affixType, Optional.of(affix));
    }

    public static CompositeTextureRules.RuleSource layer0(String eyeTexture) {
        return CompositeTextureRules.texture("layer0", Optional.of(eyeTexture), AffixType.NONE, Optional.empty());
    }

    public static CompositeTextureRules.RuleSource layer0() {
        return CompositeTextureRules.texture("layer0", Optional.empty(), AffixType.NONE, Optional.empty());
    }

    public static CompositeTextureRules.RuleSource layer1(AffixType affixType, String affix) {
        return CompositeTextureRules.texture("layer1", Optional.empty(), affixType, Optional.of(affix));
    }

    public static CompositeTextureRules.RuleSource layer1(String eyeTexture) {
        return CompositeTextureRules.texture("layer1", Optional.of(eyeTexture), AffixType.NONE, Optional.empty());
    }

    public static CompositeTextureRules.RuleSource layer1() {
        return CompositeTextureRules.texture("layer1", Optional.empty(), AffixType.NONE, Optional.empty());
    }

    public static CompositeTextureRules.ConditionSource not(CompositeTextureRules.ConditionSource target) {
        return new CompositeTextureRules.NotConditionSource(target);
    }

    public static CompositeTextureRules.ConditionSource isBaby() {
        return CompositeTextureRules.IsBabyConditionSource.INSTANCE;
    }

    public static CompositeTextureRules.ConditionSource isTame() {
        return CompositeTextureRules.IsTameConditionSource.INSTANCE;
    }

    public static CompositeTextureRules.RuleSource ifTrue(CompositeTextureRules.ConditionSource ifTrue, CompositeTextureRules.RuleSource thenRun) {
        return new CompositeTextureRules.TestRuleSource(ifTrue, thenRun);
    }

    public static CompositeTextureRules.SequenceRuleSource sequence(CompositeTextureRules.RuleSource... rules) {
        /*if (rules.length == 0) {
            throw new IllegalArgumentException("Need at least 1 rule for a sequence");
        } else {*/
        return new CompositeTextureRules.SequenceRuleSource(Arrays.asList(rules));
        //}
    }

    public interface RuleSource extends Function<ChromosomedEntityRenderState, CompositeTextureRules.TextureRule> {
        Codec<CompositeTextureRules.RuleSource> CODEC = FABuiltInRegistries.COMPOSITE_TEXTURE_RULE.byNameCodec().dispatch(CompositeTextureRules.RuleSource::codec, Function.identity());

        MapCodec<? extends CompositeTextureRules.RuleSource> codec();
    }

    public interface TextureRule {
        TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path, String baseTextureName);
    }

    public interface ConditionSource extends Function<ChromosomedEntityRenderState, CompositeTextureRules.Condition> {
        Codec<CompositeTextureRules.ConditionSource> CODEC = FABuiltInRegistries.COMPOSITE_TEXTURE_CONDITION.byNameCodec().dispatch(CompositeTextureRules.ConditionSource::codec, Function.identity());

        MapCodec<? extends CompositeTextureRules.ConditionSource> codec();
    }

    public interface Condition {
        boolean test();
    }

    record TestRuleSource(CompositeTextureRules.ConditionSource ifTrue, CompositeTextureRules.RuleSource thenRun) implements CompositeTextureRules.RuleSource {
        static final MapCodec<CompositeTextureRules.TestRuleSource> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(CompositeTextureRules.ConditionSource.CODEC.fieldOf("if_true").forGetter(CompositeTextureRules.TestRuleSource::ifTrue), CompositeTextureRules.RuleSource.CODEC.fieldOf("then_run").forGetter(CompositeTextureRules.TestRuleSource::thenRun)).apply(instance, CompositeTextureRules.TestRuleSource::new));

        @Override
        public MapCodec<? extends CompositeTextureRules.TestRuleSource> codec() {
            return CODEC;
        }

        @Override
        public CompositeTextureRules.TextureRule apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return new CompositeTextureRules.TestRule(this.ifTrue.apply(chromosomedEntityRenderState), this.thenRun.apply(chromosomedEntityRenderState));
        }
    }

    public record SequenceRuleSource(List<CompositeTextureRules.RuleSource> sequence) implements CompositeTextureRules.RuleSource {
        public static final MapCodec<CompositeTextureRules.SequenceRuleSource> CODEC = CompositeTextureRules.RuleSource.CODEC.listOf().xmap(CompositeTextureRules.SequenceRuleSource::new, CompositeTextureRules.SequenceRuleSource::sequence).fieldOf("sequence");

        @Override
        public MapCodec<? extends CompositeTextureRules.RuleSource> codec() {
            return CODEC;
        }

        @Override
        public CompositeTextureRules.TextureRule apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            if (this.sequence.size() == 1) {
                return this.sequence.getFirst().apply(chromosomedEntityRenderState);
            } else {
                ImmutableList.Builder<TextureRule> builder = ImmutableList.builder();

                for (CompositeTextureRules.RuleSource ruleSource : this.sequence) {
                    builder.add(ruleSource.apply(chromosomedEntityRenderState));
                }

                return new CompositeTextureRules.SequenceRule(builder.build());
            }
        }
    }

    record CompositeTextureRuleSource(String layer, Optional<String> eyeTexture, AffixType affixType, Optional<String> affix, TextureInformationRule rule) implements CompositeTextureRules.RuleSource {
        static final MapCodec<CompositeTextureRuleSource> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.fieldOf("layer").forGetter(CompositeTextureRules.CompositeTextureRuleSource::layer), Codec.STRING.optionalFieldOf("eye_texture").forGetter(CompositeTextureRules.CompositeTextureRuleSource::eyeTexture), AffixType.CODEC.fieldOf("affix_type").forGetter(CompositeTextureRules.CompositeTextureRuleSource::affixType), Codec.STRING.optionalFieldOf("affix").forGetter(CompositeTextureRules.CompositeTextureRuleSource::affix)).apply(instance, CompositeTextureRules.CompositeTextureRuleSource::new));

        CompositeTextureRuleSource(String layer, Optional<String> eyeTexture, AffixType affixType, Optional<String> textureName) {
            this(layer, eyeTexture, affixType, textureName, new TextureInformationRule(layer, eyeTexture, affixType, textureName));
        }

        @Override
        public MapCodec<? extends CompositeTextureRules.RuleSource> codec() {
            return CODEC;
        }

        @Override
        public CompositeTextureRules.TextureRule apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return this.rule;
        }
    }

    record SequenceRule(List<TextureRule> rules) implements CompositeTextureRules.TextureRule {
        @Override
        public TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path, String baseTextureName) {
            Iterator<TextureRule> iterator = this.rules.iterator();

            TextureInformation textureInformation;
            do {
                if (!iterator.hasNext()) {
                    return null;
                }

                TextureRule textureRule = iterator.next();
                textureInformation = textureRule.tryApply(chromosomedEntityRenderState, path, baseTextureName);
            } while (textureInformation == null);

            return textureInformation;
        }
    }

    public static final class EntityTypeConditionSource implements CompositeTextureRules.ConditionSource {
        static final MapCodec<CompositeTextureRules.EntityTypeConditionSource> CODEC = ResourceKey.codec(Registries.ENTITY_TYPE).listOf().fieldOf("entity_type_is").xmap(CompositeTextureRules::isEntity, entityTypeConditionSource -> entityTypeConditionSource.entityTypes);
        private final List<ResourceKey<EntityType<?>>> entityTypes;
        final Predicate<ResourceKey<EntityType<?>>> entityTypeNameTest;

        EntityTypeConditionSource(List<ResourceKey<EntityType<?>>> entityTypes) {
            this.entityTypes = entityTypes;
            Set<ResourceKey<EntityType<?>>> entityTypeSet = Set.copyOf(entityTypes);
            Objects.requireNonNull(entityTypeSet);
            this.entityTypeNameTest = entityTypeSet::contains;
        }

        @Override
        public MapCodec<? extends CompositeTextureRules.ConditionSource> codec() {
            return CODEC;
        }

        @Override
        public CompositeTextureRules.Condition apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            class EntityTypeCondition implements CompositeTextureRules.Condition {
                @Override
                public boolean test() {
                    return chromosomedEntityRenderState.type.builtInRegistryHolder().is(EntityTypeConditionSource.this.entityTypeNameTest);
                }
            }

            return new EntityTypeCondition();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            } else {
                boolean equals;
                if (other instanceof CompositeTextureRules.EntityTypeConditionSource entityTypeConditionSource) {
                    equals = this.entityTypes.equals(entityTypeConditionSource.entityTypes);
                } else {
                    equals = false;
                }

                return equals;
            }
        }

        @Override
        public int hashCode() {
            return this.entityTypes.hashCode();
        }

        @Override
        public String toString() {
            return "SkinGeneConditionSource[biomes=" + this.entityTypes + "]";
        }
    }

    record NotConditionSource(CompositeTextureRules.ConditionSource target) implements CompositeTextureRules.ConditionSource {
        static final MapCodec<CompositeTextureRules.NotConditionSource> CODEC = CompositeTextureRules.ConditionSource.CODEC.xmap(CompositeTextureRules.NotConditionSource::new, CompositeTextureRules.NotConditionSource::target).fieldOf("invert");

        @Override
        public CompositeTextureRules.Condition apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return new CompositeTextureRules.NotCondition(this.target.apply(chromosomedEntityRenderState));
        }

        @Override
        public MapCodec<? extends CompositeTextureRules.ConditionSource> codec() {
            return CODEC;
        }
    }

    enum IsBabyConditionSource implements CompositeTextureRules.ConditionSource {
        INSTANCE;
        static final MapCodec<CompositeTextureRules.IsBabyConditionSource> CODEC = MapCodec.unit(INSTANCE);

        @Override
        public CompositeTextureRules.Condition apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            class IsBaby implements CompositeTextureRules.Condition {
                @Override
                public boolean test() {
                    if (chromosomedEntityRenderState instanceof DinosaurRenderState dinosaurRenderState) {
                        return dinosaurRenderState.isBaby;
                    }
                    return false;
                }
            }
            return new IsBaby();
        }

        @Override
        public MapCodec<? extends CompositeTextureRules.ConditionSource> codec() {
            return CODEC;
        }
    }

    enum IsTameConditionSource implements CompositeTextureRules.ConditionSource {
        INSTANCE;
        static final MapCodec<CompositeTextureRules.IsTameConditionSource> CODEC = MapCodec.unit(INSTANCE);

        @Override
        public CompositeTextureRules.Condition apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            class IsBaby implements CompositeTextureRules.Condition {
                @Override
                public boolean test() {
                    if (chromosomedEntityRenderState instanceof DinosaurRenderState dinosaurRenderState) {
                        return dinosaurRenderState.isTame;
                    }
                    return false;
                }
            }
            return new IsBaby();
        }

        @Override
        public MapCodec<? extends CompositeTextureRules.ConditionSource> codec() {
            return CODEC;
        }
    }

    record NotCondition(CompositeTextureRules.Condition target) implements CompositeTextureRules.Condition {
        @Override
        public boolean test() {
            return !this.target.test();
        }
    }

    record TextureInformationRule(String layer, Optional<String> eyeTexture, AffixType affixType, Optional<String> affix) implements CompositeTextureRules.TextureRule {
        @Override
        public TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path, String baseTextureName) {
            String textureName = this.affix.isPresent() ? this.affixType.apply(baseTextureName, this.affix.get()) : baseTextureName;
            String eye = this.eyeTexture.orElse("adult");
            return TextureInformation.simple(path.withSuffix("/" + this.layer + "/" + textureName + ".png"), path.withSuffix("/eyes/" + eye + ".png"), path.withSuffix("/eyes/layer0/" + baseTextureName + ".png"));
        }
    }

    record TestRule(CompositeTextureRules.Condition condition, TextureRule followUp) implements CompositeTextureRules.TextureRule {
        @Override
        public TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState, ResourceLocation path, String baseTextureName) {
            return !this.condition.test() ? null : this.followUp.tryApply(chromosomedEntityRenderState, path, baseTextureName);
        }
    }
}
