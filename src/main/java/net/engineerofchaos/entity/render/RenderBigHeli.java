package net.engineerofchaos.entity.render;

import net.engineerofchaos.Main;
import net.engineerofchaos.entity.EntityBigHeli;
import net.engineerofchaos.entity.EntityHeli;
import net.engineerofchaos.entity.model.ModelBigHeli;
import net.engineerofchaos.entity.model.ModelHeli;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBigHeli extends RenderLiving<EntityBigHeli> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MODID + ":textures/entity/big_heli.png");

    public RenderBigHeli(RenderManager manager) {
        super(manager, new ModelBigHeli(), 0.5f);
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
