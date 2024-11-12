package net.engineerofchaos.firesupport.util.handlers;

import net.engineerofchaos.firesupport.commands.CommandFSMoveAircraft;
import net.engineerofchaos.firesupport.init.EntityInit;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries() {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenderers();
    }

    public static void serverRegistries(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandFSMoveAircraft());
    }
}
