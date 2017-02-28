package me.poke.xpplus.proxy;

import me.poke.xpplus.init.ModItems;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		ModItems.registerRenders();
	}

}
