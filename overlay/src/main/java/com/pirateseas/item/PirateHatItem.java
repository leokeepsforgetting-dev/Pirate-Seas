package com.pirateseas.item;

import com.pirateseas.PirateSeas;
import com.pirateseas.client.PirateHatClientExtensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class PirateHatItem extends ArmorItem {
    private final boolean captain;

    public PirateHatItem(boolean captain, Properties properties) {
        super(ArmorMaterials.LEATHER, Type.HELMET, properties);
        this.captain = captain;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new PirateHatClientExtensions(captain));
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return PirateSeas.MOD_ID + ":textures/models/armor/" +
                (captain ? "captain_hat_layer_1.png" : "pirate_hat_layer_1.png");
    }
}
