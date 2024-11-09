package net.engineerofchaos.firesupport.entity.layers;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.model.ModelStallionRotors;
import net.engineerofchaos.firesupport.entity.render.RenderBigHeli;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerStallionRotors implements LayerRenderer<EntityBigHeli> {

    private final RenderBigHeli heliRenderer;
    private final ModelStallionRotors rotorModel = new ModelStallionRotors();

    public LayerStallionRotors(RenderBigHeli heliRendererIn) {
        this.heliRenderer = heliRendererIn;
    }

    @Override
    public void doRenderLayer(EntityBigHeli entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.rotorModel.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
        if (!entitylivingbaseIn.isInvisible() && (entitylivingbaseIn.getRotorSpeed() >= 180)) {
            this.rotorModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
