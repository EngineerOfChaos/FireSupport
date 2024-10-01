package net.engineerofchaos.entity.layers;

import net.engineerofchaos.entity.EntityBigHeli;
import net.engineerofchaos.entity.model.ModelStallionBlades;
import net.engineerofchaos.entity.render.RenderBigHeli;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerStallionBlades implements LayerRenderer<EntityBigHeli> {

    private final RenderBigHeli heliRenderer;
    private final ModelStallionBlades rotorModel = new ModelStallionBlades();

    public LayerStallionBlades(RenderBigHeli heliRendererIn) {
        this.heliRenderer = heliRendererIn;
    }

    @Override
    public void doRenderLayer(EntityBigHeli entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.rotorModel.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
        this.rotorModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        if (!entitylivingbaseIn.isInvisible() && (entitylivingbaseIn.getRotorSpeed() < 200)) {
            this.rotorModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
