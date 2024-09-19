package net.engineerofchaos.util.handlers;

import net.engineerofchaos.entity.EntityBigHeli;
import net.engineerofchaos.entity.EntityHeli;
import net.engineerofchaos.entity.render.RenderBigHeli;
import net.engineerofchaos.entity.render.RenderHeli;
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
