package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBasicCrystal extends Item {
	
	public ItemBasicCrystal() {
		setUnlocalizedName(Reference.xpplusitems.BASIC_CRYSTAL.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.BASIC_CRYSTAL.getRegistryName());
		setCreativeTab(xpplus.XPPLUS_TAB);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Let the Crystals drain power from your experience");
	}
	
}
