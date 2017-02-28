package me.poke.xpplus;

import me.poke.xpplus.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class xpplusTab extends CreativeTabs {
	
	public xpplusTab() {
		super("tabxpplus");
	}
	
	@Override
	public Item getTabIconItem() {
		return ModItems.BasicXPCrystal;
	}
}
