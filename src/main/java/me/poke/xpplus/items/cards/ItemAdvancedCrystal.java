package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.item.Item;

public class ItemAdvancedCrystal extends Item {
	public ItemAdvancedCrystal() {
		setUnlocalizedName(Reference.xpplusitems.ADVANCED_CRYSTAL.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.ADVANCED_CRYSTAL.getRegistryName());
		setCreativeTab(xpplus.XPPLUS_TAB);
	}
}
