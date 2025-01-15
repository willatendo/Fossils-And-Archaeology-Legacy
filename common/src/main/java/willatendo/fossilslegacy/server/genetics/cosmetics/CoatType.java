package willatendo.fossilslegacy.server.genetics.cosmetics;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.genetics.PatternType;

import java.util.List;
import java.util.Optional;

public record CoatType(DisplayInfo displayInfo, Models models, List<Pattern> patterns, BoundingBoxInfo boundingBoxInfo, AgeScaleInfo ageScaleInfo, Optional<OverrideInfo> overrideInfo) {
    public static final Codec<CoatType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(DisplayInfo.CODEC.fieldOf("display_info").forGetter(CoatType::displayInfo), Models.CODEC.fieldOf("models").forGetter(CoatType::models), Codec.list(Pattern.CODEC).fieldOf("patterns").forGetter(CoatType::patterns), BoundingBoxInfo.CODEC.fieldOf("bounding_box_info").forGetter(CoatType::boundingBoxInfo), AgeScaleInfo.CODEC.fieldOf("age_scale_info").forGetter(CoatType::ageScaleInfo), OverrideInfo.CODEC.optionalFieldOf("override_info").forGetter(CoatType::overrideInfo)).apply(instance, CoatType::new));
    public static final Codec<Holder<CoatType>> CODEC = RegistryFileCodec.create(FossilsLegacyRegistries.COAT_TYPES, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<CoatType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.COAT_TYPES);

    public record DisplayInfo(Component name, Component pattern, int color, float displayScale, float displayYOffset) {
        public static final Codec<DisplayInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("name").forGetter(DisplayInfo::name), ComponentSerialization.CODEC.fieldOf("pattern").forGetter(DisplayInfo::pattern), ExtraCodecs.POSITIVE_INT.fieldOf("color").forGetter(DisplayInfo::color), ExtraCodecs.POSITIVE_FLOAT.fieldOf("display_scale").forGetter(DisplayInfo::displayScale), Codec.FLOAT.fieldOf("display_y_offset").forGetter(DisplayInfo::displayYOffset)).apply(instance, DisplayInfo::new));
    }

    public record Models(ResourceLocation model, Optional<ResourceLocation> flyingModel, Optional<ResourceLocation> landingModel, Optional<ResourceLocation> knockedOutModel) {
        public static final Codec<Models> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("model").forGetter(Models::model), ResourceLocation.CODEC.optionalFieldOf("flying_model").forGetter(Models::flyingModel), ResourceLocation.CODEC.optionalFieldOf("landing_model").forGetter(Models::landingModel), ResourceLocation.CODEC.optionalFieldOf("knocked_out_model").forGetter(Models::knockedOutModel)).apply(instance, Models::new));
    }

    public record Pattern(Textures textures, PatternType patternType) {
        public static final Codec<Pattern> CODEC = RecordCodecBuilder.create(instance -> instance.group(Textures.CODEC.fieldOf("textures").forGetter(Pattern::textures), PatternType.CODEC.fieldOf("pattern_type").forGetter(Pattern::patternType)).apply(instance, Pattern::new));

        public static Builder builder(ResourceLocation texture, PatternType patternType) {
            return new Builder(texture, patternType);
        }

        public static class Builder {
            private final ResourceLocation texture;
            private final PatternType patternType;
            private Optional<ResourceLocation> babyTexture = Optional.empty();
            private Optional<ResourceLocation> furTexture = Optional.empty();
            private Optional<ResourceLocation> babyFurTexture = Optional.empty();
            private Optional<ResourceLocation> shearedTexture = Optional.empty();
            private Optional<ResourceLocation> aggressiveTexture = Optional.empty();
            private Optional<ResourceLocation> aggressiveBabyTexture = Optional.empty();
            private Optional<ResourceLocation> knockedOutTexture = Optional.empty();
            private Optional<ResourceLocation> eyeLayerTexture = Optional.empty();

            private Builder(ResourceLocation texture, PatternType patternType) {
                this.texture = texture;
                this.patternType = patternType;
            }

            public CoatType.Pattern.Builder withBabyTexture(ResourceLocation babyTexture) {
                this.babyTexture = Optional.of(babyTexture);
                return this;
            }

            public CoatType.Pattern.Builder withFurTexture(ResourceLocation furTexture) {
                this.furTexture = Optional.of(furTexture);
                return this;
            }

            public CoatType.Pattern.Builder withBabyFurTexture(ResourceLocation babyFurTexture) {
                this.babyFurTexture = Optional.of(babyFurTexture);
                return this;
            }

            public CoatType.Pattern.Builder withShearedTexture(ResourceLocation shearedTexture) {
                this.shearedTexture = Optional.of(shearedTexture);
                return this;
            }

            public CoatType.Pattern.Builder withAggressiveTexture(ResourceLocation aggressiveTexture) {
                this.aggressiveTexture = Optional.of(aggressiveTexture);
                return this;
            }

            public CoatType.Pattern.Builder withAggressiveTexture(ResourceLocation aggressiveTexture, ResourceLocation aggressiveBabyTexture) {
                this.aggressiveTexture = Optional.of(aggressiveTexture);
                this.aggressiveBabyTexture = Optional.of(aggressiveBabyTexture);
                return this;
            }

            public CoatType.Pattern.Builder withKnockedOutTexture(ResourceLocation knockedOutTexture) {
                this.knockedOutTexture = Optional.of(knockedOutTexture);
                return this;
            }

            public CoatType.Pattern.Builder withEyeLayerTexture(ResourceLocation eyeLayerTexture) {
                this.eyeLayerTexture = Optional.of(eyeLayerTexture);
                return this;
            }

            public Pattern build() {
                return new Pattern(new Textures(this.texture, this.babyTexture, this.furTexture, this.babyFurTexture, this.shearedTexture, this.aggressiveTexture, this.aggressiveBabyTexture, this.knockedOutTexture, this.eyeLayerTexture), this.patternType);
            }
        }
    }

    public record Textures(ResourceLocation texture, Optional<ResourceLocation> babyTexture, Optional<ResourceLocation> furTexture, Optional<ResourceLocation> babyFurTexture, Optional<ResourceLocation> shearedTexture, Optional<ResourceLocation> aggressiveTexture, Optional<ResourceLocation> aggressiveBabyTexture, Optional<ResourceLocation> knockedOutTexture, Optional<ResourceLocation> eyeLayerTexture) {
        public static final Codec<Textures> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter(Textures::texture), ResourceLocation.CODEC.optionalFieldOf("baby_texture").forGetter(Textures::babyTexture), ResourceLocation.CODEC.optionalFieldOf("fur_texture").forGetter(Textures::furTexture), ResourceLocation.CODEC.optionalFieldOf("baby_fur_texture").forGetter(Textures::babyFurTexture), ResourceLocation.CODEC.optionalFieldOf("sheared_texture").forGetter(Textures::shearedTexture), ResourceLocation.CODEC.optionalFieldOf("aggressive_texture").forGetter(Textures::aggressiveTexture), ResourceLocation.CODEC.optionalFieldOf("aggressive_baby_texture").forGetter(Textures::aggressiveBabyTexture), ResourceLocation.CODEC.optionalFieldOf("knocked_out_texture").forGetter(Textures::knockedOutTexture), ResourceLocation.CODEC.optionalFieldOf("eye_layer_texture").forGetter(Textures::eyeLayerTexture)).apply(instance, Textures::new));
    }

    public record BoundingBoxInfo(float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth) {
        public static final Codec<BoundingBoxInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_width").forGetter(BoundingBoxInfo::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_height").forGetter(BoundingBoxInfo::boundingBoxHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_growth").forGetter(BoundingBoxInfo::boundingBoxGrowth)).apply(instance, BoundingBoxInfo::new));
    }

    public record AgeScaleInfo(float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        public static final Codec<AgeScaleInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_width").forGetter(AgeScaleInfo::baseScaleWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_height").forGetter(AgeScaleInfo::baseScaleHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("age_scale").forGetter(AgeScaleInfo::ageScale), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_size").forGetter(AgeScaleInfo::shadowSize), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_growth").forGetter(AgeScaleInfo::shadowGrowth)).apply(instance, AgeScaleInfo::new));
    }

    public record OverrideInfo(Optional<Component> animalName, Optional<ResourceLocation> ambientSound, Optional<ResourceLocation> hurtSound, Optional<ResourceLocation> deathSound) {
        public static final Codec<OverrideInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.optionalFieldOf("animal_name").forGetter(OverrideInfo::animalName), ResourceLocation.CODEC.optionalFieldOf("ambient_sound").forGetter(OverrideInfo::ambientSound), ResourceLocation.CODEC.optionalFieldOf("hurt_sound").forGetter(OverrideInfo::hurtSound), ResourceLocation.CODEC.optionalFieldOf("death_sound").forGetter(OverrideInfo::deathSound)).apply(instance, OverrideInfo::new));

        public Optional<SoundEvent> getAmbientSound() {
            return this.ambientSound().map(BuiltInRegistries.SOUND_EVENT::get);
        }

        public Optional<SoundEvent> getHurtSound() {
            return this.hurtSound().map(BuiltInRegistries.SOUND_EVENT::get);
        }

        public Optional<SoundEvent> getDeathSound() {
            return this.deathSound().map(BuiltInRegistries.SOUND_EVENT::get);
        }

        public static CoatType.OverrideInfo.Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private Optional<Component> animalName = Optional.empty();
            private Optional<ResourceLocation> ambientSound = Optional.empty();
            private Optional<ResourceLocation> hurtSound = Optional.empty();
            private Optional<ResourceLocation> deathSound = Optional.empty();

            private Builder() {
            }

            public Builder withOverridedName(Component overridedName) {
                this.animalName = Optional.of(overridedName);
                return this;
            }

            public Builder withOverridedAmbientSound(ResourceLocation overridedAmbientSound) {
                this.ambientSound = Optional.of(overridedAmbientSound);
                return this;
            }

            public Builder withOverridedHurtSound(ResourceLocation overridedHurtSound) {
                this.hurtSound = Optional.of(overridedHurtSound);
                return this;
            }

            public Builder withOverridedDeathSound(ResourceLocation overridedDeathSound) {
                this.deathSound = Optional.of(overridedDeathSound);
                return this;
            }

            public OverrideInfo build() {
                return new OverrideInfo(this.animalName, this.ambientSound, this.hurtSound, this.deathSound);
            }
        }

        public enum OverridenSoundType {
            AMBIENT,
            HURT,
            DEATH;
        }
    }

    public static Builder build(Component name, Component pattern, int color, float displayScale, float displayYOffset, ResourceLocation model, CoatType.Pattern.Builder basicPattern, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        return new Builder(name, pattern, color, displayScale, displayYOffset, model, basicPattern, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth);
    }

    public static class Builder {
        private final Component name;
        private final Component patternName;
        private final int color;
        private final float displayScale;
        private final float displayYOffset;
        private final ResourceLocation model;
        private Optional<ResourceLocation> flyingModel = Optional.empty();
        private Optional<ResourceLocation> landingModel = Optional.empty();
        private Optional<ResourceLocation> knockedOutModel = Optional.empty();
        private final List<Pattern> patterns = Lists.newArrayList();
        private final float boundingBoxWidth;
        private final float boundingBoxHeight;
        private final float boundingBoxGrowth;
        private final float baseScaleWidth;
        private final float baseScaleHeight;
        private final float ageScale;
        private final float shadowSize;
        private final float shadowGrowth;
        private Optional<OverrideInfo> overrideInfo = Optional.empty();

        private Builder(Component name, Component pattern, int color, float displayScale, float displayYOffset, ResourceLocation model, Pattern.Builder patternBuilder, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
            this.name = name;
            this.patternName = pattern;
            this.color = color;
            this.displayScale = displayScale;
            this.displayYOffset = displayYOffset;
            this.model = model;
            this.patterns.add(patternBuilder.build());
            this.boundingBoxWidth = boundingBoxWidth;
            this.boundingBoxHeight = boundingBoxHeight;
            this.boundingBoxGrowth = boundingBoxGrowth;
            this.baseScaleWidth = baseScaleWidth;
            this.baseScaleHeight = baseScaleHeight;
            this.ageScale = ageScale;
            this.shadowSize = shadowSize;
            this.shadowGrowth = shadowGrowth;
        }

        public Builder withFlyingModels(ResourceLocation flyingModel, ResourceLocation landingModel) {
            this.flyingModel = Optional.of(flyingModel);
            this.landingModel = Optional.of(landingModel);
            return this;
        }

        public Builder withKnockoutModel(ResourceLocation knockoutModel) {
            this.knockedOutModel = Optional.of(knockoutModel);
            return this;
        }

        public Builder withPattern(CoatType.Pattern.Builder builder) {
            this.patterns.add(builder.build());
            return this;
        }


        public Builder withOverrideInfo(OverrideInfo overrideInfo) {
            this.overrideInfo = Optional.of(overrideInfo);
            return this;
        }

        public CoatType build() {
            return new CoatType(new DisplayInfo(this.name, this.patternName, this.color, this.displayScale, this.displayYOffset), new Models(this.model, this.flyingModel, this.landingModel, this.knockedOutModel), this.patterns, new BoundingBoxInfo(this.boundingBoxWidth, this.boundingBoxHeight, this.boundingBoxGrowth), new AgeScaleInfo(this.baseScaleWidth, this.baseScaleHeight, this.ageScale, this.shadowSize, this.shadowGrowth), this.overrideInfo);
        }
    }
}
