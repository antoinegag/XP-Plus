package me.poke.xpplus;

import me.poke.xpplus.handlers.EventHandlerCommon;
import me.poke.xpplus.handlers.ModGuiHandler;
import me.poke.xpplus.init.ModCrafting;
import me.poke.xpplus.init.ModItems;
import me.poke.xpplus.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class xpplus {

	@Instance
	public static xpplus instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final xpplusTab CREATIVE_TAB = new xpplusTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("XP-Plus PreInititialization...");
		
		ModItems.init();
		ModItems.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		System.out.println("XP-Plus Inititialization...");
		proxy.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new ModGuiHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
		ModCrafting.register();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println("XP-Plus Post Inititialization...");
	}
}
