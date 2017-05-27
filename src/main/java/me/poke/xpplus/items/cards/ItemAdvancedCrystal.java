package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemAdvancedCrystal extends Item {

	//This is only a crafting item
	public ItemAdvancedCrystal() {
		setUnlocalizedName(Reference.xpplusitems.ADVANCED_CRYSTAL.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.ADVANCED_CRYSTAL.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Unleash the power of experience");
	}
}
