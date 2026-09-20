package com.pirateseas;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PirateSeas.MOD_ID)
public class PirateSeas {
    public static final String MOD_ID = "pirate_seas";

    public PirateSeas() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModContent.ITEMS.register(bus);
        ModContent.ENTITIES.register(bus);
        ModContent.TABS.register(bus);
        bus.addListener(this::attributes);
        bus.addListener(this::setup);
    }

    private void attributes(EntityAttributeCreationEvent e) {
        e.put(ModContent.DECKHAND.get(), PirateEntity.attributes(24, 5, 0.28).build());
        e.put(ModContent.GUNNER.get(), PirateEntity.attributes(22, 3, 0.27).build());
        e.put(ModContent.MUSKETEER.get(), PirateEntity.attributes(20, 3, 0.25).build());
        e.put(ModContent.CAPTAIN.get(), PirateEntity.attributes(44, 8, 0.30).build());
    }

    private void setup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            SpawnPlacements.register(ModContent.DECKHAND.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModContent.GUNNER.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModContent.MUSKETEER.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModContent.CAPTAIN.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        });
    }
}
