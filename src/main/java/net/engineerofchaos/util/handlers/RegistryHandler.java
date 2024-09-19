package net.engineerofchaos.util.handlers;

import net.engineerofchaos.init.EntityInit;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries() {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenderers();
    }
}
