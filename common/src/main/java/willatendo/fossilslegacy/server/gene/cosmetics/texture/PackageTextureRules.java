package willatendo.fossilslegacy.server.gene.cosmetics.texture;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public final class PackageTextureRules {
    public static final SimpleRegistry<MapCodec<? extends PackageTextureRules.RuleSource>> RULE_SOURCES = SimpleRegistry.create(FARegistries.PACKAGE_TEXTURE_RULE, FAUtils.ID);
    public static final SimpleRegistry<MapCodec<? extends PackageTextureRules.ConditionSource>> RULE_CONDITIONS = SimpleRegistry.create(FARegistries.PACKAGE_TEXTURE_CONDITION, FAUtils.ID);

    static {
        RULE_SOURCES.register("condition", () -> PackageTextureRules.TestRuleSource.CODEC);
        RULE_SOURCES.register("package_texture", () -> PackageTextureRuleSource.CODEC);
        RULE_SOURCES.register("sequence", () -> PackageTextureRules.SequenceRuleSource.CODEC);

        RULE_CONDITIONS.register("is_baby", () -> PackageTextureRules.IsBabyConditionSource.CODEC);
        RULE_CONDITIONS.register("not", () -> PackageTextureRules.NotConditionSource.CODEC);
    }

    public static PackageTextureRules.RuleSource texture(TextureInformation textureInformation) {
        return new PackageTextureRuleSource(textureInformation);
    }

    public static PackageTextureRules.ConditionSource not(PackageTextureRules.ConditionSource target) {
        return new PackageTextureRules.NotConditionSource(target);
    }

    public static PackageTextureRules.ConditionSource isBaby() {
        return PackageTextureRules.IsBabyConditionSource.INSTANCE;
    }

    public static PackageTextureRules.RuleSource ifTrue(PackageTextureRules.ConditionSource ifTrue, PackageTextureRules.RuleSource thenRun) {
        return new PackageTextureRules.TestRuleSource(ifTrue, thenRun);
    }

    public static PackageTextureRules.SequenceRuleSource sequence(PackageTextureRules.RuleSource... rules) {
        /*if (rules.length == 0) {
            throw new IllegalArgumentException("Need at least 1 rule for a sequence");
        } else {*/
            return new PackageTextureRules.SequenceRuleSource(Arrays.asList(rules));
        //}
    }

    public interface RuleSource extends Function<ChromosomedEntityRenderState, PackageTextureRules.TextureRule> {
        Codec<PackageTextureRules.RuleSource> CODEC = FABuiltInRegistries.PACKAGE_TEXTURE_RULE.byNameCodec().dispatch(PackageTextureRules.RuleSource::codec, Function.identity());

        MapCodec<? extends PackageTextureRules.RuleSource> codec();
    }

    public interface TextureRule {
        TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState);
    }

    public interface ConditionSource extends Function<ChromosomedEntityRenderState, PackageTextureRules.Condition> {
        Codec<PackageTextureRules.ConditionSource> CODEC = FABuiltInRegistries.PACKAGE_TEXTURE_CONDITION.byNameCodec().dispatch(PackageTextureRules.ConditionSource::codec, Function.identity());

        MapCodec<? extends PackageTextureRules.ConditionSource> codec();
    }

    public interface Condition {
        boolean test();
    }

    record TestRuleSource(PackageTextureRules.ConditionSource ifTrue, PackageTextureRules.RuleSource thenRun) implements PackageTextureRules.RuleSource {
        static final MapCodec<PackageTextureRules.TestRuleSource> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(PackageTextureRules.ConditionSource.CODEC.fieldOf("if_true").forGetter(PackageTextureRules.TestRuleSource::ifTrue), PackageTextureRules.RuleSource.CODEC.fieldOf("then_run").forGetter(PackageTextureRules.TestRuleSource::thenRun)).apply(instance, PackageTextureRules.TestRuleSource::new));

        @Override
        public MapCodec<? extends PackageTextureRules.TestRuleSource> codec() {
            return CODEC;
        }

        @Override
        public PackageTextureRules.TextureRule apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return new PackageTextureRules.TestRule(this.ifTrue.apply(chromosomedEntityRenderState), this.thenRun.apply(chromosomedEntityRenderState));
        }
    }

    public record SequenceRuleSource(List<PackageTextureRules.RuleSource> sequence) implements PackageTextureRules.RuleSource {
        public static final MapCodec<PackageTextureRules.SequenceRuleSource> CODEC = PackageTextureRules.RuleSource.CODEC.listOf().xmap(PackageTextureRules.SequenceRuleSource::new, PackageTextureRules.SequenceRuleSource::sequence).fieldOf("sequence");

        @Override
        public MapCodec<? extends PackageTextureRules.RuleSource> codec() {
            return CODEC;
        }

        @Override
        public PackageTextureRules.TextureRule apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            if (this.sequence.size() == 1) {
                return this.sequence.getFirst().apply(chromosomedEntityRenderState);
            } else {
                ImmutableList.Builder<TextureRule> builder = ImmutableList.builder();

                for (PackageTextureRules.RuleSource ruleSource : this.sequence) {
                    builder.add(ruleSource.apply(chromosomedEntityRenderState));
                }

                return new PackageTextureRules.SequenceRule(builder.build());
            }
        }
    }

    record PackageTextureRuleSource(TextureInformation textureInformation, PackageTextureRules.StateRule rule) implements PackageTextureRules.RuleSource {
        static final MapCodec<PackageTextureRules.PackageTextureRuleSource> CODEC = TextureInformation.CODEC.xmap(PackageTextureRuleSource::new, PackageTextureRuleSource::textureInformation).fieldOf("texture");

        PackageTextureRuleSource(TextureInformation textureInformation) {
            this(textureInformation, new PackageTextureRules.StateRule(textureInformation));
        }

        @Override
        public MapCodec<? extends PackageTextureRules.RuleSource> codec() {
            return CODEC;
        }

        @Override
        public PackageTextureRules.TextureRule apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return this.rule;
        }
    }

    record SequenceRule(List<TextureRule> rules) implements PackageTextureRules.TextureRule {
        @Override
        public TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            Iterator<TextureRule> iterator = this.rules.iterator();

            TextureInformation textureInformation;
            do {
                if (!iterator.hasNext()) {
                    return null;
                }

                TextureRule textureRule = iterator.next();
                textureInformation = textureRule.tryApply(chromosomedEntityRenderState);
            } while (textureInformation == null);

            return textureInformation;
        }
    }

    record NotConditionSource(PackageTextureRules.ConditionSource target) implements PackageTextureRules.ConditionSource {
        static final MapCodec<PackageTextureRules.NotConditionSource> CODEC = PackageTextureRules.ConditionSource.CODEC.xmap(PackageTextureRules.NotConditionSource::new, PackageTextureRules.NotConditionSource::target).fieldOf("invert");

        @Override
        public PackageTextureRules.Condition apply(ChromosomedEntityRenderState dinosaur) {
            return new PackageTextureRules.NotCondition(this.target.apply(dinosaur));
        }

        @Override
        public MapCodec<? extends PackageTextureRules.ConditionSource> codec() {
            return CODEC;
        }
    }

    enum IsBabyConditionSource implements PackageTextureRules.ConditionSource {
        INSTANCE;
        static final MapCodec<PackageTextureRules.IsBabyConditionSource> CODEC = MapCodec.unit(INSTANCE);

        @Override
        public PackageTextureRules.Condition apply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            class IsBaby implements PackageTextureRules.Condition {
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
        public MapCodec<? extends PackageTextureRules.ConditionSource> codec() {
            return CODEC;
        }
    }

    record NotCondition(PackageTextureRules.Condition target) implements PackageTextureRules.Condition {
        @Override
        public boolean test() {
            return !this.target.test();
        }
    }

    record StateRule(TextureInformation textureInformation) implements PackageTextureRules.TextureRule {
        @Override
        public TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return this.textureInformation();
        }
    }

    record TestRule(PackageTextureRules.Condition condition, TextureRule followUp) implements PackageTextureRules.TextureRule {
        @Override
        public TextureInformation tryApply(ChromosomedEntityRenderState chromosomedEntityRenderState) {
            return !this.condition.test() ? null : this.followUp.tryApply(chromosomedEntityRenderState);
        }
    }
}
