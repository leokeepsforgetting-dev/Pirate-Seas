package com.pirateseas;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class GunItem extends Item {
    private final float damage, velocity, spread;
    private final int pellets, cooldown;

    public GunItem(float damage, float velocity, float spread, int pellets, int cooldown, Properties props) {
        super(props);
        this.damage = damage; this.velocity = velocity; this.spread = spread;
        this.pellets = pellets; this.cooldown = cooldown;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!player.getAbilities().instabuild) {
            int ball = find(player, ModContent.LEAD_BALL.get());
            int powder = find(player, Items.GUNPOWDER);
            if (ball < 0 || powder < 0) return InteractionResultHolder.fail(stack);
            if (!level.isClientSide) {
                player.getInventory().getItem(ball).shrink(1);
                player.getInventory().getItem(powder).shrink(1);
            }
        }

        if (!level.isClientSide) {
            for (int i=0;i<pellets;i++) {
                BulletEntity b = new BulletEntity(level, player, damage);
                b.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, velocity, spread);
                level.addFreshEntity(b);
            }
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 0.6f, 1.6f);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
        }
        player.getCooldowns().addCooldown(this, cooldown);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    private static int find(Player p, Item item) {
        for (int i=0;i<p.getInventory().getContainerSize();i++)
            if (p.getInventory().getItem(i).is(item)) return i;
        return -1;
    }
}
