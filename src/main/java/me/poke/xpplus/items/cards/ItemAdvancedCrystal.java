package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAdvancedCrystal extends Item {
	public ItemAdvancedCrystal() {
		setUnlocalizedName(Reference.xpplusitems.ADVANCED_CRYSTAL.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.ADVANCED_CRYSTAL.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
	}
		
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
  
}
