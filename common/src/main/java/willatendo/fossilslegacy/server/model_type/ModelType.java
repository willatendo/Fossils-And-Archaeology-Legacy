package willatendo.fossilslegacy.server.model_type;

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
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public record ModelType(DisplayInfo displayInfo, Models models, TagKey<Pattern> skins, TagKey<Pattern> patterns, BoundingBoxInfo boundingBoxInfo, AgeScaleInfo ageScaleInfo, Optional<OverrideInfo> overrideInfo) {
    public static final Codec<ModelType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(DisplayInfo.CODEC.fieldOf("display_info").forGetter(ModelType::displayInfo), Models.CODEC.fieldOf("models").forGetter(ModelType::models), TagKey.codec(FARegistries.PATTERN).fieldOf("skins").forGetter(ModelType::skins), TagKey.codec(FARegistries.PATTERN).fieldOf("patterns").forGetter(ModelType::patterns), BoundingBoxInfo.CODEC.fieldOf("bounding_box_info").forGetter(ModelType::boundingBoxInfo), AgeScaleInfo.CODEC.fieldOf("age_scale_info").forGetter(ModelType::ageScaleInfo), OverrideInfo.CODEC.optionalFieldOf("override_info").forGetter(ModelType::overrideInfo)).apply(instance, ModelType::new));
    public static final Codec<Holder<ModelType>> CODEC = RegistryFileCodec.create(FARegistries.MODEL_TYPES, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<ModelType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.MODEL_TYPES);

    public record DisplayInfo(Component modelName, int color, float displayScale, float displayYOffset) {
        public static final Codec<DisplayInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("model_name").forGetter(DisplayInfo::modelName), ExtraCodecs.POSITIVE_INT.fieldOf("geneColor").forGetter(DisplayInfo::color), ExtraCodecs.POSITIVE_FLOAT.fieldOf("display_scale").forGetter(DisplayInfo::displayScale), Codec.FLOAT.fieldOf("display_y_offset").forGetter(DisplayInfo::displayYOffset)).apply(instance, DisplayInfo::new));
    }

    public record Models(ResourceLocation model, Optional<ResourceLocation> flyingModel, Optional<ResourceLocation> landingModel, Optional<ResourceLocation> knockedOutModel) {
        public static final Codec<Models> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("model").forGetter(Models::model), ResourceLocation.CODEC.optionalFieldOf("flying_model").forGetter(Models::flyingModel), ResourceLocation.CODEC.optionalFieldOf("landing_model").forGetter(Models::landingModel), ResourceLocation.CODEC.optionalFieldOf("knocked_out_model").forGetter(Models::knockedOutModel)).apply(instance, Models::new));
    }

    public record Textures(ResourceLocation texture, Optional<ResourceLocation> babyTexture, Optional<ResourceLocation> furTexture, Optional<ResourceLocation> babyFurTexture, Optional<ResourceLocation> shearedTexture, Optional<ResourceLocation> aggressiveTexture, Optional<ResourceLocation> aggressiveBabyTexture, Optional<ResourceLocation> knockedOutTexture, Optional<ResourceLocation> eyeLayerTexture) {
        public static final Codec<Textures> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter(Textures::texture), ResourceLocation.CODEC.optionalFieldOf("baby_texture").forGetter(Textures::babyTexture), ResourceLocation.CODEC.optionalFieldOf("fur_texture").forGetter(Textures::furTexture), ResourceLocation.CODEC.optionalFieldOf("baby_fur_texture").forGetter(Textures::babyFurTexture), ResourceLocation.CODEC.optionalFieldOf("sheared_texture").forGetter(Textures::shearedTexture), ResourceLocation.CODEC.optionalFieldOf("aggressive_texture").forGetter(Textures::aggressiveTexture), ResourceLocation.CODEC.optionalFieldOf("aggressive_baby_texture").forGetter(Textures::aggressiveBabyTexture), ResourceLocation.CODEC.optionalFieldOf("knocked_out_texture").forGetter(Textures::knockedOutTexture), ResourceLocation.CODEC.optionalFieldOf("eye_layer_texture").forGetter(Textures::eyeLayerTexture)).apply(instance, Textures::new));
    }

    public record BoundingBoxInfo(float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth) {
        public static final Codec<BoundingBoxInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_width").forGetter(BoundingBoxInfo::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_height").forGetter(BoundingBoxInfo::boundingBoxHeight), Codec.FLOAT.fieldOf("bounding_box_growth").forGetter(BoundingBoxInfo::boundingBoxGrowth)).apply(instance, BoundingBoxInfo::new));
    }

    public record AgeScaleInfo(float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        public static final Codec<AgeScaleInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_width").forGetter(AgeScaleInfo::baseScaleWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_height").forGetter(AgeScaleInfo::baseScaleHeight), Codec.FLOAT.fieldOf("age_scale").forGetter(AgeScaleInfo::ageScale), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_size").forGetter(AgeScaleInfo::shadowSize), Codec.FLOAT.fieldOf("shadow_growth").forGetter(AgeScaleInfo::shadowGrowth)).apply(instance, AgeScaleInfo::new));
    }

    public record OverrideInfo(Optional<Component> animalName, Optional<ResourceLocation> ambientSound, Optional<ResourceLocation> hurtSound, Optional<ResourceLocation> deathSound) {
        public static final Codec<OverrideInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.optionalFieldOf("animal_name").forGetter(OverrideInfo::animalName), ResourceLocation.CODEC.optionalFieldOf("ambient_sound").forGetter(OverrideInfo::ambientSound), ResourceLocation.CODEC.optionalFieldOf("hurt_sound").forGetter(OverrideInfo::hurtSound), ResourceLocation.CODEC.optionalFieldOf("death_sound").forGetter(OverrideInfo::deathSound)).apply(instance, OverrideInfo::new));

        public Optional<SoundEvent> getAmbientSound() {
            return this.ambientSound().map(BuiltInRegistries.SOUND_EVENT::getValue);
        }

        public Optional<SoundEvent> getHurtSound() {
            return this.hurtSound().map(BuiltInRegistries.SOUND_EVENT::getValue);
        }

        public Optional<SoundEvent> getDeathSound() {
            return this.deathSound().map(BuiltInRegistries.SOUND_EVENT::getValue);
        }

        public static ModelType.OverrideInfo.Builder builder() {
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

    public static Builder build(Component name, int color, float displayScale, float displayYOffset, ResourceLocation model, TagKey<Pattern> skins, TagKey<Pattern> patterns, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        return new Builder(name, color, displayScale, displayYOffset, model, skins, patterns, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth);
    }

    public static class Builder {
        private final Component name;
        private final int color;
        private final float displayScale;
        private final float displayYOffset;
        private final ResourceLocation model;
        private Optional<ResourceLocation> flyingModel = Optional.empty();
        private Optional<ResourceLocation> landingModel = Optional.empty();
        private Optional<ResourceLocation> knockedOutModel = Optional.empty();
        private final TagKey<Pattern> skins;
        private final TagKey<Pattern> patterns;
        private final float boundingBoxWidth;
        private final float boundingBoxHeight;
        private final float boundingBoxGrowth;
        private final float baseScaleWidth;
        private final float baseScaleHeight;
        private final float ageScale;
        private final float shadowSize;
        private final float shadowGrowth;
        private Optional<OverrideInfo> overrideInfo = Optional.empty();

        private Builder(Component name, int color, float displayScale, float displayYOffset, ResourceLocation model, TagKey<Pattern> skins, TagKey<Pattern> patterns, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
            this.name = name;
            this.color = color;
            this.displayScale = displayScale;
            this.displayYOffset = displayYOffset;
            this.model = model;
            this.skins = skins;
            this.patterns = patterns;
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

        public Builder withOverrideInfo(OverrideInfo overrideInfo) {
            this.overrideInfo = Optional.of(overrideInfo);
            return this;
        }

        public ModelType build() {
            return new ModelType(new DisplayInfo(this.name, this.color, this.displayScale, this.displayYOffset), new Models(this.model, this.flyingModel, this.landingModel, this.knockedOutModel), this.skins, this.patterns, new BoundingBoxInfo(this.boundingBoxWidth, this.boundingBoxHeight, this.boundingBoxGrowth), new AgeScaleInfo(this.baseScaleWidth, this.baseScaleHeight, this.ageScale, this.shadowSize, this.shadowGrowth), this.overrideInfo);
        }
    }
}
