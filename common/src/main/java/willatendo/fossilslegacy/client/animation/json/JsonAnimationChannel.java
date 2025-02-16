package willatendo.fossilslegacy.client.animation.json;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public record JsonAnimationChannel(String bone, String target, List<JsonKeyframe> jsonKeyframes) {
    public static final Codec<JsonAnimationChannel> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.STRING.fieldOf("bone").forGetter(JsonAnimationChannel::bone), Codec.STRING.fieldOf("target").forGetter(JsonAnimationChannel::target), Codec.list(JsonKeyframe.CODEC).fieldOf("keyframes").forGetter(JsonAnimationChannel::jsonKeyframes)).apply(instance, JsonAnimationChannel::new));
}
