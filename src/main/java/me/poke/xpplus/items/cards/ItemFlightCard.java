package me.poke.xpplus.items.cards;

import java.util.List;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlightCard extends Item {

	public ItemFlightCard() {
		setUnlocalizedName(Reference.xpplusitems.FLIGHT_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.FLIGHT_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.isSneaking()){
				NBTTagCompound itemData = stack.getTagCompound();
				if(!stack.hasTagCompound())
					setNewTagCompound(stack);
				if(!itemData.getBoolean("activated")){
					if(playerIn.experienceLevel >= 100){
						playerIn.removeExperienceLevel(100);
						itemData.setBoolean("activated", true);
					}else
						playerIn.addChatComponentMessage(new TextComponentTranslation("item.activate.noXp", new Object[0]));		
				}else
					itemData.setBoolean("activated", false);
				addInformation(stack, playerIn, stack.getTooltip(playerIn, false), false); //Update the tooltip		
			}	
		}
		return super.onItemRightClick(stack, worldIn, playerIn, hand);
	}
	
	/**
	 * Gives a new NBTTag compound to the item stack with activated to false
	 * @param stack ItemStack
	 */
	public void setNewTagCompound(ItemStack stack){
		NBTTagCompound tag = new NBTTagCompound();
		stack.setTagCompound(tag);
		tag.setBoolean("activated", false);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		setNewTagCompound(stack);
		addInformation(stack, playerIn, stack.getTooltip(playerIn, false), false);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if(!stack.hasTagCompound())
			setNewTagCompound(stack);
		return stack.getTagCompound().getBoolean("activated");
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(!stack.hasTagCompound())
			setNewTagCompound(stack);
		if(stack.getTagCompound().getBoolean("activated"))
			tooltip.add("Activated - Creative Flight!");
		else
			tooltip.add("Activate for 100 levels (Shift-Right Click)");
		hasEffect(stack);
	}
	
	/*
	 * TODO: Actually set creative flight 
	 */
	
}
