package com.pirateseas.client;

import com.pirateseas.PirateSeas;
import com.pirateseas.client.model.PirateHatModel;
import com.pirateseas.registry.ModEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PirateSeas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PIRATE_HAT, PirateHatModel::createPirateLayer);
        event.registerLayerDefinition(ModModelLayers.CAPTAIN_HAT, PirateHatModel::createCaptainLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.PIRATE_DECKHAND.get(), PirateRenderer::new);
        event.registerEntityRenderer(ModEntities.PIRATE_GUNNER.get(), PirateRenderer::new);
        event.registerEntityRenderer(ModEntities.PIRATE_MUSKETEER.get(), PirateRenderer::new);
        event.registerEntityRenderer(ModEntities.PIRATE_CAPTAIN.get(), PirateRenderer::new);
        event.registerEntityRenderer(ModEntities.BULLET.get(), ThrownItemRenderer::new);
    }

    private ClientModEvents() {}
}
