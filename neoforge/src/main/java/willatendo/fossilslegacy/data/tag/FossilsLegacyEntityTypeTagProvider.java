package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.tags.FossilsLegacyEntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyEntityTypeTagProvider extends EntityTypeTagsProvider {
    public FossilsLegacyEntityTypeTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.PTERANODON.get());
        this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get());

        this.carnivoreFood(FossilsLegacyEntityTypeTags.CARNOTAURUS_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.tag(FossilsLegacyEntityTypeTags.COMPSOGNATHUS_VICTIMS).add(EntityType.CHICKEN, EntityType.PARROT, EntityType.PLAYER, FossilsLegacyEntityTypes.DODO.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.CRYOLOPHOSAURUS_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.DILOPHOSAURUS_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.DIMETRODON_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.MOSASAURUS_VICTIMS, EntityType.COD, EntityType.SALMON, EntityType.TROPICAL_FISH, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.SPINOSAURUS_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.TYRANNOSAURUS_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.VELOCIRAPTOR.get());
        this.carnivoreFood(FossilsLegacyEntityTypeTags.VELOCIRAPTOR_VICTIMS, FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), FossilsLegacyEntityTypes.CARNOTAURUS.get(), FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), FossilsLegacyEntityTypes.DIMETRODON.get(), FossilsLegacyEntityTypes.DODO.get(), FossilsLegacyEntityTypes.FUTABASAURUS.get(), FossilsLegacyEntityTypes.GALLIMIMUS.get(), FossilsLegacyEntityTypes.MAMMOTH.get(), FossilsLegacyEntityTypes.MOA.get(), FossilsLegacyEntityTypes.MOSASAURUS.get(), FossilsLegacyEntityTypes.NAUTILUS.get(), FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), FossilsLegacyEntityTypes.PTERANODON.get(), FossilsLegacyEntityTypes.SMILODON.get(), FossilsLegacyEntityTypes.SPINOSAURUS.get(), FossilsLegacyEntityTypes.STEGOSAURUS.get(), FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), FossilsLegacyEntityTypes.TRICERATOPS.get(), FossilsLegacyEntityTypes.TYRANNOSAURUS.get());
    }

    private void carnivoreFood(TagKey<EntityType<?>> tagKey, EntityType<?>... entityTypes) {
        this.tag(tagKey).add(EntityType.ARMADILLO, EntityType.CAMEL, EntityType.CAT, EntityType.CHICKEN, EntityType.COW, EntityType.DONKEY, EntityType.FOX, EntityType.GOAT, EntityType.HORSE, EntityType.LLAMA, EntityType.MOOSHROOM, EntityType.MULE, EntityType.OCELOT, EntityType.PANDA, EntityType.PARROT, EntityType.PIG, EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.PILLAGER, EntityType.PLAYER, EntityType.POLAR_BEAR, EntityType.RABBIT, EntityType.SHEEP, EntityType.TRADER_LLAMA, EntityType.TURTLE, EntityType.VILLAGER, EntityType.VINDICATOR, EntityType.WANDERING_TRADER, EntityType.WITCH, EntityType.WOLF).add(entityTypes);
    }
}