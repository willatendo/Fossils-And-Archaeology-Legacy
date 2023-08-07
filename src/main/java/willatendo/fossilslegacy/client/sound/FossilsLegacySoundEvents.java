package willatendo.fossilslegacy.client.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacySoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FossilsLegacyUtils.ID);

	public static final RegistryObject<SoundEvent> MAMMOTH_AMBIENT = SOUND_EVENTS.register("entity.mammoth.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.mammoth.ambient")));
	public static final RegistryObject<SoundEvent> MAMMOTH_HURT = SOUND_EVENTS.register("entity.mammoth.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.mammoth.hurt")));
	public static final RegistryObject<SoundEvent> MAMMOTH_DEATH = SOUND_EVENTS.register("entity.mammoth.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.mammoth.death")));
	public static final RegistryObject<SoundEvent> SMILODON_AMBIENT = SOUND_EVENTS.register("entity.smilodon.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.smilodon.ambient")));
	public static final RegistryObject<SoundEvent> SMILODON_HURT = SOUND_EVENTS.register("entity.smilodon.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.smilodon.hurt")));
	public static final RegistryObject<SoundEvent> SMILODON_DEATH = SOUND_EVENTS.register("entity.smilodon.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.smilodon.death")));
	public static final RegistryObject<SoundEvent> TRICERATOPS_AMBIENT = SOUND_EVENTS.register("entity.triceratops.ambient", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.triceratops.ambient")));
	public static final RegistryObject<SoundEvent> TRICERATOPS_HURT = SOUND_EVENTS.register("entity.triceratops.hurt", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.triceratops.hurt")));
	public static final RegistryObject<SoundEvent> TRICERATOPS_DEATH = SOUND_EVENTS.register("entity.triceratops.death", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("entity.triceratops.death")));

	public static final RegistryObject<SoundEvent> DRUM_HIT = SOUND_EVENTS.register("block.drum.hit", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("block.drum.hit")));
	public static final RegistryObject<SoundEvent> DRUM_TRIPLE_HIT = SOUND_EVENTS.register("block.drum.triple_hit", () -> SoundEvent.createVariableRangeEvent(FossilsLegacyUtils.resource("block.drum.triple_hit")));
}
