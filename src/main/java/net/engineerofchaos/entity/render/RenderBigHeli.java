package net.engineerofchaos.entity.render;

import net.engineerofchaos.Main;
import net.engineerofchaos.entity.EntityBigHeli;
import net.engineerofchaos.entity.EntityHeli;
import net.engineerofchaos.entity.layers.LayerStallionBlades;
import net.engineerofchaos.entity.layers.LayerStallionRotors;
import net.engineerofchaos.entity.model.ModelBigHeli;
import net.engineerofchaos.entity.model.ModelHeli;
import net.engineerofchaos.entity.model.ModelStallionBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

import static net.minecraft.client.renderer.OpenGlHelper.glBlendFunc;
import static org.lwjgl.opengl.GL11.*;

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
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
}
