package com.pirateseas;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PirateSeas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {
    @SubscribeEvent
    public static void renderers(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(ModContent.DECKHAND.get(), ZombieRenderer::new);
        e.registerEntityRenderer(ModContent.GUNNER.get(), ZombieRenderer::new);
        e.registerEntityRenderer(ModContent.MUSKETEER.get(), ZombieRenderer::new);
        e.registerEntityRenderer(ModContent.CAPTAIN.get(), ZombieRenderer::new);
        e.registerEntityRenderer(ModContent.BULLET.get(), ThrownItemRenderer::new);
    }
}
