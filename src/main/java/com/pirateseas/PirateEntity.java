package com.pirateseas;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PirateEntity extends Zombie implements RangedAttackMob {
    public PirateEntity(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
        if (type == ModContent.CAPTAIN.get()) {
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModContent.CAPTAINS_SABRE.get()));
            setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModContent.CAPTAIN_HAT.get()));
        } else if (type == ModContent.MUSKETEER.get()) {
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModContent.MUSKET.get()));
            setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModContent.PIRATE_HAT.get()));
        } else if (type == ModContent.GUNNER.get()) {
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModContent.FLINTLOCK.get()));
            setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModContent.PIRATE_HAT.get()));
        } else {
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModContent.CUTLASS.get()));
            setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModContent.PIRATE_HAT.get()));
        }
    }

    public static AttributeSupplier.Builder attributes(double hp, double attack, double speed) {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH, hp)
                .add(Attributes.ATTACK_DAMAGE, attack)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.FOLLOW_RANGE, 40.0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        if (getType() == ModContent.GUNNER.get() || getType() == ModContent.MUSKETEER.get()) {
            goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0,
                    getType() == ModContent.MUSKETEER.get() ? 48 : 34,
                    getType() == ModContent.MUSKETEER.get() ? 24f : 16f));
        }
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (level().isClientSide) return;
        float damage = getType() == ModContent.MUSKETEER.get() ? 10f : 6f;
        float velocity = getType() == ModContent.MUSKETEER.get() ? 2.65f : 1.9f;
        float spread = getType() == ModContent.MUSKETEER.get() ? 1.5f : 5f;
        BulletEntity b = new BulletEntity(level(), this, damage);
        b.shoot(target.getX() - getX(), target.getEyeY() - b.getY(), target.getZ() - getZ(), velocity, spread);
        level().addFreshEntity(b);
    }

    @Override
    protected boolean convertsInWater() { return false; }
}
