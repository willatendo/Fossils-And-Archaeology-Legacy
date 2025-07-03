package willatendo.fossilslegacy.network;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAPackets {
    public static final ResourceLocation CLIENTBOUND_FOSSIL_SCREEN = FAUtils.resource("fossil_screen");

    public static final ResourceLocation SERVERBOUND_DAMAGE_HAMMER = FAUtils.resource("damage_hammer");
    public static final ResourceLocation SERVERBOUND_SET_FOSSIL_PART_POSITIONS = FAUtils.resource("set_fossil_part_positions");
    public static final ResourceLocation SERVERBOUND_SET_FOSSIL_PART_ROTATIONS = FAUtils.resource("set_fossil_part_rotations");
    public static final ResourceLocation SERVERBOUND_SET_DNA_RECOMBINATOR_GENE = FAUtils.resource("set_dna_recombinator_gene");
    public static final ResourceLocation SERVERBOUND_START_TIME_MACHINE = FAUtils.resource("start_time_machine");
    public static final ResourceLocation SERVERBOUND_VEHICLE_SINK = FAUtils.resource("vehicle_sink");
}
