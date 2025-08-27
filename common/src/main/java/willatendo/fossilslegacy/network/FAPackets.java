package willatendo.fossilslegacy.network;

import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAPackets {
    public static final ResourceLocation CLIENTBOUND_OPEN_DEBUG_GENETICS_SCREEN = FAUtils.resource("clientbound_open_debug_genetics_screen");
    public static final ResourceLocation CLIENTBOUND_OPEN_DINOPEDIA_SCREEN = FAUtils.resource("open_dinopedia_screen");
    public static final ResourceLocation CLIENTBOUND_OPEN_FOSSIL_SCREEN = FAUtils.resource("open_fossil_screen");

    public static final ResourceLocation SERVERBOUND_ADD_NOTIFIED_PLAYER = FAUtils.resource("add_notified_player");
    public static final ResourceLocation SERVERBOUND_DAMAGE_HAMMER = FAUtils.resource("damage_hammer");
    public static final ResourceLocation SERVERBOUND_REMOVE_NOTIFIED_PLAYER = FAUtils.resource("remove_notified_player");
    public static final ResourceLocation SERVERBOUND_SET_FOSSIL_PART_POSITIONS = FAUtils.resource("set_fossil_part_positions");
    public static final ResourceLocation SERVERBOUND_SET_FOSSIL_PART_ROTATIONS = FAUtils.resource("set_fossil_part_rotations");
    public static final ResourceLocation SERVERBOUND_SET_DNA_RECOMBINATOR_GENE = FAUtils.resource("set_dna_recombinator_gene");
    public static final ResourceLocation SERVERBOUND_START_TIME_MACHINE = FAUtils.resource("start_time_machine");
    public static final ResourceLocation SERVERBOUND_VEHICLE_SINK = FAUtils.resource("vehicle_sink");
}
