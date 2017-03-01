package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.item.Item;

public class ItemSpeedCard extends Item {
	
	public ItemSpeedCard() {
		setUnlocalizedName(Reference.xpplusitems.SPEED_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.SPEED_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
	}
}
