package me.poke.xpplus.items.cards;

import java.util.List;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemDayCard extends Item{

	public ItemDayCard() {
		setUnlocalizedName(Reference.xpplusitems.DAY_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.HEALING_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.experienceLevel >= 10 && worldIn.getWorldTime() > 13000){
				worldIn.setWorldTime(0);
				playerIn.removeExperienceLevel(10);
			}		
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Set the time to day for 10 levels");
	}
}
