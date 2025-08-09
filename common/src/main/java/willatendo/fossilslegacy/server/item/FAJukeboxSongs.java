package willatendo.fossilslegacy.server.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.JukeboxSong;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FAJukeboxSongs {
    public static final ResourceKey<JukeboxSong> TRIASSIC = create("triassic");
    public static final ResourceKey<JukeboxSong> JURASSIC = create("jurassic");
    public static final ResourceKey<JukeboxSong> CRETACEOUS = create("cretaceous");

    private static ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<JukeboxSong> bootstrapContext, ResourceKey<JukeboxSong> resourceKey, Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        bootstrapContext.register(resourceKey, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", resourceKey.location())), lengthInSeconds, comparatorOutput));
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> bootstrapContext) {
        FAJukeboxSongs.register(bootstrapContext, TRIASSIC, SoundEvents.MUSIC_DISC_13, 178, 10);
        FAJukeboxSongs.register(bootstrapContext, JURASSIC, SoundEvents.MUSIC_DISC_CAT, 185, 9);
        FAJukeboxSongs.register(bootstrapContext, CRETACEOUS, SoundEvents.MUSIC_DISC_BLOCKS, 345, 8);
    }
}
