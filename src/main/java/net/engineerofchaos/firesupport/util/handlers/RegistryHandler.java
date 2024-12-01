package net.engineerofchaos.firesupport.util.handlers;

import net.engineerofchaos.firesupport.commands.CommandFSMoveAircraft;
import net.engineerofchaos.firesupport.init.EntityInit;
import net.engineerofchaos.firesupport.init.ItemInit;
import net.engineerofchaos.firesupport.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static void preInitRegistries() {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenderers();
    }

    public static void serverRegistries(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandFSMoveAircraft());
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }
//        for (Block block : BlockInit.BLOCKS) {
//            if (block instanceof IHasModel) {
//                ((IHasModel)block).registerModels();
//            }
//        }
    }
}
