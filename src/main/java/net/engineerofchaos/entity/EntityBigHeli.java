package net.engineerofchaos.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityBigHeli extends EntityGhast {
    //private final EntityBodyHelper bodyHelper;

    public EntityBigHeli(World worldIn) {
        super(worldIn);
        setSize(5.0f, 2.0f);
        //this.bodyHelper = createBodyHelper();

    }

//    @Nullable
//    @Override
//    public EntityAgeable createChild(EntityAgeable ageable) {
//        return null;
//    }

//    @Override
//    protected void entityInit() {
//        super.entityInit();
//    }

//    protected void initEntityAI() {
//        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 1.0F, 200));
//    }

    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {

    }
}
