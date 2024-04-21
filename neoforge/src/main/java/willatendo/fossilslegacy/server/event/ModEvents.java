package willatendo.fossilslegacy.server.event;

import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import willatendo.fossilslegacy.FossilsLegacyNeoforgeMod;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.dispenser.DispenseEntityItemBehavior;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.NeoForgeRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.nio.file.Path;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FossilsLegacyUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void clientSetup(FMLCommonSetupEvent event) {
        ModEvents.addToMaps();
    }

    @SubscribeEvent
    public static void creativeModTabModification(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
                event.accept(items.get());
            }
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.getEntries().putAfter(new ItemStack(Items.ALLAY_SPAWN_EGG), new ItemStack(FossilsLegacyItems.ANU_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.BLAZE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.CREEPER_SPAWN_EGG), new ItemStack(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.EVOKER_SPAWN_EGG), new ItemStack(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get()), new ItemStack(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.MAGMA_CUBE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.MOOSHROOM_SPAWN_EGG), new ItemStack(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.MULE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.POLAR_BEAR_SPAWN_EGG), new ItemStack(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.SLIME_SPAWN_EGG), new ItemStack(FossilsLegacyItems.SMILODON_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.SQUID_SPAWN_EGG), new ItemStack(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.TRADER_LLAMA_SPAWN_EGG), new ItemStack(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.TURTLE_SPAWN_EGG), new ItemStack(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        NeoForgeRegister.register(event, FossilsLegacyNeoforgeMod.REGISTRIES.toArray(SimpleRegistry[]::new));
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(FossilsLegacyEntityTypes.ANU.get(), Anu.anuAttributes());
        event.put(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), Brachiosaurus.brachiosaurusAttributes());
        event.put(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), Dilophosaurus.dilophosaurusAttributes());
        event.put(FossilsLegacyEntityTypes.EGG.get(), Egg.eggAttributes());
        event.put(FossilsLegacyEntityTypes.FAILURESAURUS.get(), Failuresaurus.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.FOSSIL.get(), Fossil.fossilAttributes());
        event.put(FossilsLegacyEntityTypes.MAMMOTH.get(), Mammoth.mammothAttributes());
        event.put(FossilsLegacyEntityTypes.MOSASAURUS.get(), Mosasaurus.mosasaurusAttributes());
        event.put(FossilsLegacyEntityTypes.NAUTILUS.get(), Nautilus.nautilusAttributes());
        event.put(FossilsLegacyEntityTypes.FUTABASAURUS.get(), Futabasaurus.plesiosaurusAttributes());
        event.put(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), Cat.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_COW.get(), Cow.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), Dolphin.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), Donkey.createBaseChestedHorseAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), Fox.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), Goat.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), Horse.createBaseHorseAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), Llama.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), Mammoth.mammothAttributes());
        event.put(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), Smilodon.smilodonAttributes());
        event.put(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), Mule.createBaseChestedHorseAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), Ocelot.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), Panda.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), Pig.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), PolarBear.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), Rabbit.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), Sheep.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), Wolf.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.PTERANODON.get(), Pteranodon.pteranodonAttributes());
        event.put(FossilsLegacyEntityTypes.SMILODON.get(), Smilodon.smilodonAttributes());
        event.put(FossilsLegacyEntityTypes.STEGOSAURUS.get(), Stegosaurus.stegosaurusAttributes());
        event.put(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), ZombifiedPiglin.createAttributes().build());
        event.put(FossilsLegacyEntityTypes.TRICERATOPS.get(), Triceratops.triceratopsAttributes());
        event.put(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), Tyrannosaurus.tyrannosaurusAttributes());
        event.put(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), Velociraptor.velociraptorAttributes());
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById(FossilsLegacyUtils.ID).getFile().findResource("resourcepacks/fa_legacy_textures");
            event.addRepositorySource(consumer -> {
                Pack pack = Pack.readMetaAndCreate(FossilsLegacyUtils.resource("resourcepacks.fa_legacy_textures").toString(), FossilsLegacyUtils.translation("pack", "resourcepacks.fa_legacy_textures"), false, new PathPackResources.PathResourcesSupplier(resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
                if (pack != null) {
                    consumer.accept(pack);
                }
            });
        }
    }


    public static void registerRegistries(NewRegistryEvent event) {
        event.register(FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS.registry());
        event.register(FossilsLegacyBuiltInRegistries.EGG_VARIANTS.registry());
        event.register(FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.registry());
    }

    public static void addToMaps() {
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyBlocks.JURASSIC_FERN.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0.65F);

        FossilsLegacyItems.EGGS.forEach(eggItem -> DispenserBlock.registerBehavior(eggItem.get(), new DispenseEntityItemBehavior(entity -> ((Egg) entity).setEggVariant(eggItem.get().getEggVariant()))));
        DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS_EGGS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.NAUTILUS.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.FOSSIL.get(), new DispenseEntityItemBehavior());
        DispenserBlock.registerBehavior(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
                return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
                    thrownIncubatedEgg.setItem(itemStack);
                    thrownIncubatedEgg.setEggType(0);
                });
            }
        });
        DispenserBlock.registerBehavior(FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
                return Util.make(new ThrownIncubatedEgg(level, position.x(), position.y(), position.z()), thrownIncubatedEgg -> {
                    thrownIncubatedEgg.setItem(itemStack);
                    thrownIncubatedEgg.setEggType(1);
                });
            }
        });
    }
}
