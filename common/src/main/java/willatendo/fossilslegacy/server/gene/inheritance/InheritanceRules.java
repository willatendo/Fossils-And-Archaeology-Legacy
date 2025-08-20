package willatendo.fossilslegacy.server.gene.inheritance;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import willatendo.fossilslegacy.server.gene.InheritedGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public final class InheritanceRules {
    public static final SimpleRegistry<MapCodec<? extends InheritanceRules.RuleSource>> RULE_SOURCES = SimpleRegistry.create(FARegistries.INHERITANCE_RULE, FAUtils.ID);
    public static final SimpleRegistry<MapCodec<? extends InheritanceRules.ConditionSource>> RULE_CONDITIONS = SimpleRegistry.create(FARegistries.INHERITANCE_CONDITION, FAUtils.ID);

    static {
        RULE_SOURCES.register("always", () -> InheritanceRules.AlwaysRuleSource.CODEC);
        RULE_SOURCES.register("condition", () -> InheritanceRules.TestRuleSource.CODEC);
        RULE_SOURCES.register("random", () -> InheritanceRules.RandomRuleSource.CODEC);
        RULE_SOURCES.register("sequence", () -> InheritanceRules.SequenceRuleSource.CODEC);

        RULE_CONDITIONS.register("pattern_gene", () -> InheritanceRules.PatternGeneConditionSource.CODEC);
        RULE_CONDITIONS.register("not", () -> InheritanceRules.NotConditionSource.CODEC);
        RULE_CONDITIONS.register("skin_gene", () -> InheritanceRules.SkinGeneConditionSource.CODEC);
    }

    public static InheritanceRules.ConditionSource not(InheritanceRules.ConditionSource target) {
        return new InheritanceRules.NotConditionSource(target);
    }

    public static InheritanceRules.RandomRuleSource random() {
        return InheritanceRules.RandomRuleSource.INSTANCE;
    }

    public static InheritanceRules.AlwaysRuleSource always() {
        return InheritanceRules.AlwaysRuleSource.INSTANCE;
    }

    public static InheritanceRules.SkinGeneConditionSource isSkinGene(ResourceKey<SkinGene>... skinGenes) {
        return InheritanceRules.isSkinGene(List.of(skinGenes));
    }

    private static InheritanceRules.SkinGeneConditionSource isSkinGene(List<ResourceKey<SkinGene>> skinGenes) {
        return new InheritanceRules.SkinGeneConditionSource(skinGenes);
    }

    public static InheritanceRules.PatternGeneConditionSource isPatternGene(ResourceKey<PatternGene>... skinGenes) {
        return InheritanceRules.isPatternGene(List.of(skinGenes));
    }

    private static InheritanceRules.PatternGeneConditionSource isPatternGene(List<ResourceKey<PatternGene>> skinGenes) {
        return new InheritanceRules.PatternGeneConditionSource(skinGenes);
    }

    public static InheritanceRules.RuleSource ifTrue(InheritanceRules.ConditionSource ifTrue, InheritanceRules.RuleSource thenRun) {
        return new InheritanceRules.TestRuleSource(ifTrue, thenRun);
    }

    public static InheritanceRules.SequenceRuleSource sequence(RuleSource... rules) {
        if (rules.length == 0) {
            throw new IllegalArgumentException("Need at least 1 rule for a sequence");
        } else {
            return new InheritanceRules.SequenceRuleSource(Arrays.asList(rules));
        }
    }

    public interface RuleSource extends Function<Holder<? extends InheritedGene>, InheritanceRules.InheritanceRule> {
        Codec<InheritanceRules.RuleSource> CODEC = FABuiltInRegistries.INHERITANCE_RULE.byNameCodec().dispatch(InheritanceRules.RuleSource::codec, Function.identity());

        MapCodec<? extends InheritanceRules.RuleSource> codec();
    }

    public interface InheritanceRule {
        boolean tryApply(RandomSource randomSource, InheritedGene mom, InheritedGene dad);
    }

    public interface ConditionSource extends Function<Holder<? extends InheritedGene>, InheritanceRules.Condition> {
        Codec<InheritanceRules.ConditionSource> CODEC = FABuiltInRegistries.INHERITANCE_CONDITION.byNameCodec().dispatch(InheritanceRules.ConditionSource::codec, Function.identity());

        MapCodec<? extends InheritanceRules.ConditionSource> codec();
    }

    public interface Condition {
        boolean test();
    }

    record TestRuleSource(InheritanceRules.ConditionSource ifTrue, InheritanceRules.RuleSource thenRun) implements InheritanceRules.RuleSource {
        static final MapCodec<InheritanceRules.TestRuleSource> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(ConditionSource.CODEC.fieldOf("if_true").forGetter(TestRuleSource::ifTrue), RuleSource.CODEC.fieldOf("then_run").forGetter(TestRuleSource::thenRun)).apply(instance, TestRuleSource::new));

        @Override
        public MapCodec<? extends InheritanceRules.TestRuleSource> codec() {
            return CODEC;
        }

        @Override
        public InheritanceRules.InheritanceRule apply(Holder<? extends InheritedGene> inheritedGene) {
            return new InheritanceRules.TestRule(this.ifTrue.apply(inheritedGene), this.thenRun.apply(inheritedGene));
        }
    }

    public enum RandomRuleSource implements InheritanceRules.RuleSource {
        INSTANCE;

        static final MapCodec<InheritanceRules.RandomRuleSource> CODEC = MapCodec.unit(INSTANCE);

        @Override
        public MapCodec<? extends InheritanceRules.RandomRuleSource> codec() {
            return CODEC;
        }

        @Override
        public InheritanceRules.InheritanceRule apply(Holder<? extends InheritedGene> inheritedGene) {
            return new InheritanceRules.RandomRule(inheritedGene.value());
        }
    }

    public enum AlwaysRuleSource implements InheritanceRules.RuleSource {
        INSTANCE;

        static final MapCodec<InheritanceRules.AlwaysRuleSource> CODEC = MapCodec.unit(INSTANCE);

        @Override
        public MapCodec<? extends InheritanceRules.AlwaysRuleSource> codec() {
            return CODEC;
        }

        @Override
        public InheritanceRules.InheritanceRule apply(Holder<? extends InheritedGene> inheritedGene) {
            return new InheritanceRules.AlwaysRule(inheritedGene.value());
        }
    }

    public record SequenceRuleSource(List<InheritanceRules.RuleSource> sequence) implements InheritanceRules.RuleSource {
        public static final MapCodec<InheritanceRules.SequenceRuleSource> CODEC = RuleSource.CODEC.listOf().xmap(InheritanceRules.SequenceRuleSource::new, InheritanceRules.SequenceRuleSource::sequence).fieldOf("sequence");

        @Override
        public MapCodec<? extends RuleSource> codec() {
            return CODEC;
        }

        @Override
        public InheritanceRules.InheritanceRule apply(Holder<? extends InheritedGene> inheritedGene) {
            if (this.sequence.size() == 1) {
                return this.sequence.getFirst().apply(inheritedGene);
            } else {
                ImmutableList.Builder<InheritanceRules.InheritanceRule> builder = ImmutableList.builder();

                for (InheritanceRules.RuleSource ruleSource : this.sequence) {
                    builder.add(ruleSource.apply(inheritedGene));
                }

                return new InheritanceRules.SequenceRule(builder.build());
            }
        }
    }

    record SequenceRule(List<InheritanceRules.InheritanceRule> rules) implements InheritanceRules.InheritanceRule {
        @Override
        public boolean tryApply(RandomSource randomSource, InheritedGene mom, InheritedGene dad) {
            Iterator<InheritanceRules.InheritanceRule> iterator = this.rules.iterator();

            boolean applies;
            do {
                if (!iterator.hasNext()) {
                    return false;
                }

                InheritanceRules.InheritanceRule inheritanceRule = iterator.next();
                applies = inheritanceRule.tryApply(randomSource, mom, mom);
            } while (!applies);

            return applies;
        }
    }

    public static final class SkinGeneConditionSource implements InheritanceRules.ConditionSource {
        static final MapCodec<InheritanceRules.SkinGeneConditionSource> CODEC = ResourceKey.codec(FARegistries.SKIN_GENE).listOf().fieldOf("skin_gene_is").xmap(InheritanceRules::isSkinGene, skinGeneConditionSource -> skinGeneConditionSource.skinGenes);
        private final List<ResourceKey<SkinGene>> skinGenes;
        final Predicate<ResourceKey<SkinGene>> skinGeneNameTest;

        SkinGeneConditionSource(List<ResourceKey<SkinGene>> skinGenes) {
            this.skinGenes = skinGenes;
            Set<ResourceKey<SkinGene>> skinGeneSet = Set.copyOf(skinGenes);
            Objects.requireNonNull(skinGeneSet);
            this.skinGeneNameTest = skinGeneSet::contains;
        }

        @Override
        public MapCodec<? extends InheritanceRules.ConditionSource> codec() {
            return CODEC;
        }

        @Override
        public InheritanceRules.Condition apply(Holder<? extends InheritedGene> inheritedGene) {
            class SkinGeneCondition implements InheritanceRules.Condition {
                @Override
                public boolean test() {
                    if (inheritedGene.value() instanceof SkinGene) {
                        return ((Holder<SkinGene>) inheritedGene).is(InheritanceRules.SkinGeneConditionSource.this.skinGeneNameTest);
                    }
                    return false;
                }
            }

            return new SkinGeneCondition();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            } else {
                boolean equals;
                if (other instanceof InheritanceRules.SkinGeneConditionSource skinGeneConditionSource) {
                    equals = this.skinGenes.equals(skinGeneConditionSource.skinGenes);
                } else {
                    equals = false;
                }

                return equals;
            }
        }

        @Override
        public int hashCode() {
            return this.skinGenes.hashCode();
        }

        @Override
        public String toString() {
            return "SkinGeneConditionSource[biomes=" + this.skinGenes + "]";
        }
    }

    public static final class PatternGeneConditionSource implements InheritanceRules.ConditionSource {
        static final MapCodec<InheritanceRules.PatternGeneConditionSource> CODEC = ResourceKey.codec(FARegistries.PATTERN_GENE).listOf().fieldOf("pattern_gene_is").xmap(InheritanceRules::isPatternGene, skinGeneConditionSource -> skinGeneConditionSource.patternGenes);
        private final List<ResourceKey<PatternGene>> patternGenes;
        final Predicate<ResourceKey<PatternGene>> patternGeneNameTest;

        PatternGeneConditionSource(List<ResourceKey<PatternGene>> patternGenes) {
            this.patternGenes = patternGenes;
            Set<ResourceKey<PatternGene>> patternGeneSet = Set.copyOf(patternGenes);
            Objects.requireNonNull(patternGeneSet);
            this.patternGeneNameTest = patternGeneSet::contains;
        }

        @Override
        public MapCodec<? extends InheritanceRules.ConditionSource> codec() {
            return CODEC;
        }

        @Override
        public InheritanceRules.Condition apply(Holder<? extends InheritedGene> inheritedGene) {
            class PatternGeneCondition implements InheritanceRules.Condition {
                @Override
                public boolean test() {
                    if (inheritedGene.value() instanceof PatternGene) {
                        return ((Holder<PatternGene>) inheritedGene).is(InheritanceRules.PatternGeneConditionSource.this.patternGeneNameTest);
                    }
                    return false;
                }
            }

            return new PatternGeneCondition();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            } else {
                boolean equals;
                if (other instanceof InheritanceRules.PatternGeneConditionSource patternGeneConditionSource) {
                    equals = this.patternGenes.equals(patternGeneConditionSource.patternGenes);
                } else {
                    equals = false;
                }

                return equals;
            }
        }

        @Override
        public int hashCode() {
            return this.patternGenes.hashCode();
        }

        @Override
        public String toString() {
            return "PatternGeneConditionSource[biomes=" + this.patternGenes + "]";
        }
    }

    record NotConditionSource(InheritanceRules.ConditionSource target) implements InheritanceRules.ConditionSource {
        static final MapCodec<InheritanceRules.NotConditionSource> CODEC = InheritanceRules.ConditionSource.CODEC.xmap(InheritanceRules.NotConditionSource::new, InheritanceRules.NotConditionSource::target).fieldOf("invert");

        @Override
        public InheritanceRules.Condition apply(Holder<? extends InheritedGene> holder) {
            return new NotCondition(this.target.apply(holder));
        }

        @Override
        public MapCodec<? extends ConditionSource> codec() {
            return CODEC;
        }
    }


    record NotCondition(InheritanceRules.Condition target) implements InheritanceRules.Condition {
        @Override
        public boolean test() {
            return !this.target.test();
        }
    }

    record RandomRule(InheritedGene inheritedGene) implements InheritanceRules.InheritanceRule {
        @Override
        public boolean tryApply(RandomSource randomSource, InheritedGene mom, InheritedGene dad) {
            return this.inheritedGene == (randomSource.nextInt(2) == 0 ? mom : dad);
        }
    }

    record AlwaysRule(InheritedGene inheritedGene) implements InheritanceRules.InheritanceRule {
        @Override
        public boolean tryApply(RandomSource randomSource, InheritedGene mom, InheritedGene dad) {
            return true;
        }
    }

    record TestRule(InheritanceRules.Condition condition, InheritanceRules.InheritanceRule followUp) implements InheritanceRules.InheritanceRule {
        @Override
        public boolean tryApply(RandomSource randomSource, InheritedGene mom, InheritedGene dad) {
            return this.condition.test() && this.followUp.tryApply(randomSource, mom, dad);
        }
    }
}
