package com.pirateseas.client;

import com.pirateseas.client.model.PirateHatModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class PirateHatClientExtensions implements IClientItemExtensions {
    private final boolean captain;
    private HumanoidModel<?> cachedModel;

    public PirateHatClientExtensions(boolean captain) {
        this.captain = captain;
    }

    @Override
    public @NotNull HumanoidModel<?> getHumanoidArmorModel(
            LivingEntity livingEntity,
            ItemStack itemStack,
            EquipmentSlot equipmentSlot,
            HumanoidModel<?> original) {

        if (cachedModel == null) {
            cachedModel = new PirateHatModel(
                    Minecraft.getInstance().getEntityModels().bakeLayer(
                            captain ? ModModelLayers.CAPTAIN_HAT : ModModelLayers.PIRATE_HAT));
        }
        return cachedModel;
    }
}
