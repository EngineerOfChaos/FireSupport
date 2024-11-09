package net.engineerofchaos.firesupport.util.handlers;

import net.engineerofchaos.firesupport.init.EntityInit;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries() {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenderers();
    }
}
