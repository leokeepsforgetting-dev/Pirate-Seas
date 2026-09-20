package com.pirateseas;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class BulletEntity extends ThrowableItemProjectile {
    private float damage = 7f;

    public BulletEntity(EntityType<? extends BulletEntity> type, Level level) { super(type, level); }
    public BulletEntity(Level level, LivingEntity owner, float damage) {
        super(ModContent.BULLET.get(), owner, level);
        this.damage = damage;
    }

    @Override protected Item getDefaultItem() { return ModContent.LEAD_BALL.get(); }
    @Override protected float getGravity() { return 0.015f; }

    @Override
    protected void onHitEntity(EntityHitResult hit) {
        Entity owner = getOwner();
        hit.getEntity().hurt(damageSources().thrown(this, owner), damage);
        discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult hit) {
        super.onHitBlock(hit);
        discard();
    }
}
