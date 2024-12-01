package net.engineerofchaos.firesupport.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {
    public EntityBullet(World worldIn) {
        super(worldIn);
    }
    public EntityBullet(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }
    public EntityBullet(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            this.setDead();
            if (result.entityHit instanceof EntityLivingBase) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), 1);
                EntityLivingBase entity = (EntityLivingBase) result.entityHit;
                entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 3));
            }
        }
    }
}
