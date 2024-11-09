package net.engineerofchaos.firesupport.proxy;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.render.RenderBigHeli;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
    public void preInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBigHeli.class, m -> new RenderBigHeli(m));
    }
}
