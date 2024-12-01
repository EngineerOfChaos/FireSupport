package net.engineerofchaos.firesupport.objects.items;

import net.engineerofchaos.firesupport.entity.projectile.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemBullet extends ItemBase {
    public ItemBullet(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        Vec3d look = playerIn.getLookVec();
        EntityBullet bullet = new EntityBullet(worldIn, playerIn.posX + look.x * 1.5D, playerIn.posY + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
        bullet.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.5F);
        if (!worldIn.isRemote) {
            worldIn.spawnEntity(bullet);
        }
        worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (!playerIn.capabilities.isCreativeMode) {
            stack.shrink(1);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
