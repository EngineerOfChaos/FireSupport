package net.engineerofchaos.firesupport.entity.render;

import net.engineerofchaos.firesupport.Main;
import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.layers.LayerStallionBlades;
import net.engineerofchaos.firesupport.entity.layers.LayerStallionRotors;
import net.engineerofchaos.firesupport.entity.model.ModelBigHeli;
import net.engineerofchaos.firesupport.entity.model.ModelStallionBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBigHeli extends RenderLiving<EntityBigHeli> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MODID + ":textures/entity/big_heli.png");

    private final ModelBase model = new ModelBigHeli();

    public RenderBigHeli(RenderManager manager) {
        super(manager, new ModelStallionBase(), 0.5f);
        this.addLayer(new LayerStallionRotors(this));
        this.addLayer(new LayerStallionBlades(this));
    }

    public void doRender(EntityBigHeli entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableNormalize();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        GlStateManager.disableBlend();
        GlStateManager.disableNormalize();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBigHeli entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityBigHeli entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        EntityPlayer nearestPlayer = entityLiving.world.<EntityPlayer>getClosestPlayerToEntity(entityLiving, 100);
        if (nearestPlayer != null) {
            //nearestPlayer.sendMessage(new TextComponentString("Rendering: partialTicks = " + partialTicks));
        }

        // Call GLStatemanager.rotate() before super.applyRotations() for global rotations
        //super.applyRotations(entityLiving, ageInTicks, entityLiving.getRenderYaw(partialTicks), partialTicks);

        GlStateManager.rotate(180.0F - entityLiving.getRenderYaw(partialTicks), 0.0F, 1.0F, 0.0F);

        // get random direction to turn on crash


        if (entityLiving.deathTime > 0)
        {
            float x = entityLiving.crashDirection.x;
            float z = entityLiving.crashDirection.y;
            float f = ((float)entityLiving.deathTime + partialTicks - 1.0F) / 20.0F * 0.1F; // * 1.6
            f = MathHelper.sqrt(f);

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            GlStateManager.rotate(f * this.getDeathMaxRotation(entityLiving), x, 0.0F, z);
        }

        // Call GLStatemanager.rotate() after super.applyRotations() for local rotations
        GlStateManager.rotate(entityLiving.getRenderRoll(partialTicks), 0, 0, 1F);
    }
}
