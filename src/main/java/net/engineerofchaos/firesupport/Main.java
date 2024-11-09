package net.engineerofchaos.firesupport;

import net.engineerofchaos.firesupport.proxy.CommonProxy;
import net.engineerofchaos.firesupport.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
	modid = Main.MODID,
	name = Main.NAME,
	version = Main.VERSION
)
public class Main {
	// Key info
	public static final String MODID = "firesupport";
	public static final String NAME = "Fire Support";
	public static final String VERSION = "0.0.1";

	// Create instance
	@Mod.Instance
	public static Main instance;

	// Proxy setup
	public static final String CLIENT = "net.engineerofchaos.firesupport.proxy.ClientProxy";
	public static final String COMMON = "net.engineerofchaos.firesupport.proxy.CommonProxy";

	@SidedProxy(clientSide = CLIENT, serverSide = COMMON)
	public static CommonProxy proxy;

	// Initialisation events
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
		proxy.preInit();
		LOGGER.info("PreInit Event");
	}
	public void init(FMLInitializationEvent event) {

		LOGGER.info("Init Event");
	}
	public void postInit(FMLPostInitializationEvent event) {

		LOGGER.info("PostInit Event");
	}


	// Logger
	public static final Logger LOGGER = LogManager.getLogger(MODID);
}
