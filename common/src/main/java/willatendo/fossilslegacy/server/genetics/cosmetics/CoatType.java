package willatendo.fossilslegacy.server.genetics.cosmetics;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;

import java.util.Optional;

public record CoatType(DisplayInfo displayInfo, Models models, Textures textures, BoundingBoxInfo boundingBoxInfo, AgeScaleInfo ageScaleInfo) {
    public static final Codec<CoatType> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(DisplayInfo.CODEC.fieldOf("display_info").forGetter(CoatType::displayInfo), Models.CODEC.fieldOf("models").forGetter(CoatType::models), Textures.CODEC.fieldOf("textures").forGetter(CoatType::textures), BoundingBoxInfo.CODEC.fieldOf("bounding_box_info").forGetter(CoatType::boundingBoxInfo), AgeScaleInfo.CODEC.fieldOf("age_scale_info").forGetter(CoatType::ageScaleInfo)).apply(instance, CoatType::new));
    public static final Codec<Holder<CoatType>> CODEC = RegistryFileCodec.create(FossilsLegacyRegistries.COAT_TYPES, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<CoatType>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.COAT_TYPES);

    public record DisplayInfo(Component name, Component pattern, int color, float displayScale, float displayYOffset) {
        public static final Codec<DisplayInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ComponentSerialization.CODEC.fieldOf("name").forGetter(DisplayInfo::name), ComponentSerialization.CODEC.fieldOf("pattern").forGetter(DisplayInfo::pattern), ExtraCodecs.POSITIVE_INT.fieldOf("color").forGetter(DisplayInfo::color), ExtraCodecs.POSITIVE_FLOAT.fieldOf("display_scale").forGetter(DisplayInfo::displayScale), Codec.FLOAT.fieldOf("display_y_offset").forGetter(DisplayInfo::displayYOffset)).apply(instance, DisplayInfo::new));
    }

    public record Models(ResourceLocation model, Optional<ResourceLocation> flyingModel, Optional<ResourceLocation> landingModel, Optional<ResourceLocation> knockedOutModel) {
        public static final Codec<Models> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("model").forGetter(Models::model), ResourceLocation.CODEC.optionalFieldOf("flying_model").forGetter(Models::flyingModel), ResourceLocation.CODEC.optionalFieldOf("landing_model").forGetter(Models::landingModel), ResourceLocation.CODEC.optionalFieldOf("knocked_out_model").forGetter(Models::knockedOutModel)).apply(instance, Models::new));
    }

    public record Textures(ResourceLocation texture, Optional<ResourceLocation> babyTexture, Optional<ResourceLocation> shearedTexture, Optional<ResourceLocation> aggressiveTexture, Optional<ResourceLocation> aggressiveBabyTexture, Optional<ResourceLocation> knockedOutTexture) {
        public static final Codec<Textures> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter(Textures::texture), ResourceLocation.CODEC.optionalFieldOf("baby_texture").forGetter(Textures::babyTexture), ResourceLocation.CODEC.optionalFieldOf("sheared_texture").forGetter(Textures::shearedTexture), ResourceLocation.CODEC.optionalFieldOf("aggressive_texture").forGetter(Textures::aggressiveTexture), ResourceLocation.CODEC.optionalFieldOf("aggressive_baby_texture").forGetter(Textures::aggressiveBabyTexture), ResourceLocation.CODEC.optionalFieldOf("knocked_out_texture").forGetter(Textures::knockedOutTexture)).apply(instance, Textures::new));
    }

    public record BoundingBoxInfo(float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth) {
        public static final Codec<BoundingBoxInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_width").forGetter(BoundingBoxInfo::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_height").forGetter(BoundingBoxInfo::boundingBoxWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("bounding_box_growth").forGetter(BoundingBoxInfo::boundingBoxGrowth)).apply(instance, BoundingBoxInfo::new));
    }

    public record AgeScaleInfo(float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        public static final Codec<AgeScaleInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_width").forGetter(AgeScaleInfo::baseScaleWidth), ExtraCodecs.POSITIVE_FLOAT.fieldOf("base_scale_height").forGetter(AgeScaleInfo::baseScaleHeight), ExtraCodecs.POSITIVE_FLOAT.fieldOf("age_scale").forGetter(AgeScaleInfo::ageScale), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_size").forGetter(AgeScaleInfo::shadowSize), ExtraCodecs.POSITIVE_FLOAT.fieldOf("shadow_growth").forGetter(AgeScaleInfo::shadowGrowth)).apply(instance, AgeScaleInfo::new));
    }

    public static Builder build(Component name, Component pattern, int color, float displayScale, float displayYOffset, ResourceLocation model, ResourceLocation texture, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
        return new Builder(name, pattern, color, displayScale, displayYOffset, model, texture, boundingBoxWidth, boundingBoxHeight, boundingBoxGrowth, baseScaleWidth, baseScaleHeight, ageScale, shadowSize, shadowGrowth);
    }

    public static class Builder {
        private final Component name;
        private final Component pattern;
        private final int color;
        private final float displayScale;
        private final float displayYOffset;
        private final ResourceLocation model;
        private Optional<ResourceLocation> flyingModel = Optional.empty();
        private Optional<ResourceLocation> landingModel = Optional.empty();
        private Optional<ResourceLocation> knockedOutModel = Optional.empty();
        private final ResourceLocation texture;
        private Optional<ResourceLocation> babyTexture = Optional.empty();
        private Optional<ResourceLocation> shearedTexture = Optional.empty();
        private Optional<ResourceLocation> aggressiveTexture = Optional.empty();
        private Optional<ResourceLocation> aggressiveBabyTexture = Optional.empty();
        private Optional<ResourceLocation> knockedOutTexture = Optional.empty();
        private final float boundingBoxWidth;
        private final float boundingBoxHeight;
        private final float boundingBoxGrowth;
        private final float baseScaleWidth;
        private final float baseScaleHeight;
        private final float ageScale;
        private final float shadowSize;
        private final float shadowGrowth;

        private Builder(Component name, Component pattern, int color, float displayScale, float displayYOffset, ResourceLocation model, ResourceLocation texture, float boundingBoxWidth, float boundingBoxHeight, float boundingBoxGrowth, float baseScaleWidth, float baseScaleHeight, float ageScale, float shadowSize, float shadowGrowth) {
            this.name = name;
            this.pattern = pattern;
            this.color = color;
            this.displayScale = displayScale;
            this.displayYOffset = displayYOffset;
            this.model = model;
            this.texture = texture;
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

        public Builder withBabyTexture(ResourceLocation babyTexture) {
            this.babyTexture = Optional.of(babyTexture);
            return this;
        }

        public Builder withShearedTexture(ResourceLocation shearedTexture) {
            this.shearedTexture = Optional.of(shearedTexture);
            return this;
        }

        public Builder withAggressiveTexture(ResourceLocation aggressiveTexture) {
            this.aggressiveTexture = Optional.of(aggressiveTexture);
            return this;
        }

        public Builder withAggressiveTexture(ResourceLocation aggressiveTexture, ResourceLocation aggressiveBabyTexture) {
            this.aggressiveTexture = Optional.of(aggressiveTexture);
            this.aggressiveBabyTexture = Optional.of(aggressiveBabyTexture);
            return this;
        }

        public Builder withKnockedOutTexture(ResourceLocation knockedOutTexture) {
            this.knockedOutTexture = Optional.of(knockedOutTexture);
            return this;
        }

        public CoatType build() {
            return new CoatType(new DisplayInfo(this.name, this.pattern, this.color, this.displayScale, this.displayYOffset), new Models(this.model, this.flyingModel, this.landingModel, this.knockedOutModel), new Textures(this.texture, this.babyTexture, this.shearedTexture, this.aggressiveTexture, this.aggressiveBabyTexture, this.knockedOutTexture), new BoundingBoxInfo(this.boundingBoxWidth, this.boundingBoxHeight, this.boundingBoxGrowth), new AgeScaleInfo(this.baseScaleWidth, this.baseScaleHeight, this.ageScale, this.shadowSize, this.shadowGrowth));
        }
    }
}
