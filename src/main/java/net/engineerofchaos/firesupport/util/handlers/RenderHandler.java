package net.engineerofchaos.firesupport.util.handlers;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.entity.EntityHeli;
import net.engineerofchaos.firesupport.entity.render.RenderBigHeli;
import net.engineerofchaos.firesupport.entity.render.RenderHeli;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityHeli.class, new IRenderFactory<EntityHeli>() {
            @Override
            public Render<? super EntityHeli> createRenderFor(RenderManager manager) {
                return new RenderHeli(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityBigHeli.class, new IRenderFactory<EntityBigHeli>() {
            @Override
            public Render<? super EntityBigHeli> createRenderFor(RenderManager manager) {
                return new RenderBigHeli(manager);
            }
        });
    }
}
