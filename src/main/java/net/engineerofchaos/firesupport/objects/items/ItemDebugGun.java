package net.engineerofchaos.firesupport.objects.items;

import net.engineerofchaos.firesupport.entity.projectile.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemDebugGun extends ItemBase{
    public ItemDebugGun(String name) {
        super(name);
        this.maxStackSize = 1;

    }

    protected ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isBullet(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isBullet(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isBullet(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isBullet(ItemStack stack)
    {
        return stack.getItem() instanceof ItemBullet;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack gun = playerIn.getHeldItem(handIn);
        ItemStack itemStack = this.findAmmo(playerIn);

        if (itemStack == ItemStack.EMPTY) {
            return new ActionResult<>(EnumActionResult.FAIL, gun);
        } else {
            //Vec3d look = playerIn.getLookVec();
            double f = Math.cos(-playerIn.rotationYaw * 0.017453292F - Math.PI);
            double f1 = Math.sin(-playerIn.rotationYaw * 0.017453292F - Math.PI);
            double f2 = -Math.cos(-playerIn.rotationPitch * 0.017453292F);
            double f3 = Math.sin(-playerIn.rotationPitch * 0.017453292F);
            Vec3d look = new Vec3d(f1 * f2, f3, f * f2);
            EntityBullet bullet = new EntityBullet(worldIn, playerIn.posX + look.x * 1.5D, playerIn.posY + look.y * 1.5D + 1D, playerIn.posZ + look.z * 1.5D);
            bullet.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 5F, 0.0F);
            if (!worldIn.isRemote) {
                worldIn.spawnEntity(bullet);
            }

            worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);

            return new ActionResult<>(EnumActionResult.SUCCESS, gun);
        }
    }
}
