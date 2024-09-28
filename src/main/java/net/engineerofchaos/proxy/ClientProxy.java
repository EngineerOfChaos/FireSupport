package net.engineerofchaos.proxy;

import net.engineerofchaos.entity.EntityBigHeli;
import net.engineerofchaos.entity.model.ModelBigHeli;
import net.engineerofchaos.entity.render.RenderBigHeli;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
    public void preInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBigHeli.class, m -> new RenderBigHeli(m));
    }
}
