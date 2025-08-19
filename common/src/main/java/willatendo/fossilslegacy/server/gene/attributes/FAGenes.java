package willatendo.fossilslegacy.server.gene.attributes;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.ai.attributes.Attributes;
import willatendo.fossilslegacy.server.registry.GeneRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public final class FAGenes {
    public static final GeneRegistry GENES = GeneRegistry.createGene(FAUtils.ID);

    public static final SimpleHolder<AttributeGene> HEALTH = GENES.registerGene("health", id -> new AttributeGene(id, Attributes.MAX_HEALTH, 0.05F, 0xFF0606, ChatFormatting.RED, 0, FAUtils.mc("textures/mob_effect/regeneration.png")));
    public static final SimpleHolder<AttributeGene> SPEED = GENES.registerGene("speed", id -> new AttributeGene(id, Attributes.MOVEMENT_SPEED, 0.05F, 0x8B3833, ChatFormatting.WHITE, 1, FAUtils.mc("textures/mob_effect/speed.png")));
    public static final SimpleHolder<AttributeGene> ARMOR = GENES.registerGene("armor", id -> new AttributeGene(id, Attributes.ARMOR, 0.05F, 0x7E95A5, ChatFormatting.DARK_AQUA, 2, FAUtils.mc("textures/mob_effect/resistance.png")));
    public static final SimpleHolder<AttributeGene> ATTACK = GENES.registerGene("attack", id -> new AttributeGene(id, Attributes.ATTACK_DAMAGE, 0.05F, 0x444444, ChatFormatting.DARK_GRAY, 3, FAUtils.mc("textures/mob_effect/strength.png")));
}
