package net.engineerofchaos.entity.render;

import net.engineerofchaos.Main;
import net.engineerofchaos.entity.EntityHeli;
import net.engineerofchaos.entity.model.ModelHeli;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHeli extends RenderLiving<EntityHeli> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MODID + ":textures/entity/heli.png");

    public RenderHeli(RenderManager manager) {
        super(manager, new ModelHeli(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHeli entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityHeli entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
}
