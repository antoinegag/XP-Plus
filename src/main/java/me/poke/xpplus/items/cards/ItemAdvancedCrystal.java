package me.poke.xpplus.items.cards;

import java.util.List;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemAdvancedCrystal extends Item {
	public ItemAdvancedCrystal() {
		setUnlocalizedName(Reference.xpplusitems.ADVANCED_CRYSTAL.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.ADVANCED_CRYSTAL.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Used to craft advanced cards");
	}
}
