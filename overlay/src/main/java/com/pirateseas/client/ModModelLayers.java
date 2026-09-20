package com.pirateseas.client;

import com.pirateseas.PirateSeas;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public final class ModModelLayers {
    public static final ModelLayerLocation PIRATE_HAT =
            new ModelLayerLocation(new ResourceLocation(PirateSeas.MOD_ID, "pirate_hat"), "main");
    public static final ModelLayerLocation CAPTAIN_HAT =
            new ModelLayerLocation(new ResourceLocation(PirateSeas.MOD_ID, "captain_hat"), "main");

    private ModModelLayers() {}
}
