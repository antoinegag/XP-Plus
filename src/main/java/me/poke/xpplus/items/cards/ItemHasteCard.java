package me.poke.xpplus.items.cards;

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

import java.util.List;

public class ItemHasteCard extends ToggleableItemBase {

	public ItemHasteCard() {
		setUnlocalizedName(Reference.xpplusitems.HASTE_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.HASTE_CARD.getRegistryName());
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
					if(playerIn.experienceLevel >= 30){
						playerIn.removeExperienceLevel(30);
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
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			boolean activated = stack.getTagCompound().getBoolean("activated");
			if(activated){
				tooltip.add("Activated - Mine faster!");
			}else{
				tooltip.add("Activate for 30 levels (Shift-Right Click)");
			}
			hasEffect(stack); //Update enchant effet
		}else{
			setNewTagCompound(stack);
			tooltip.add("Activate for 30 levels (Shift-Right Click)");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if(stack.hasTagCompound())
			return stack.getTagCompound().getBoolean("activated");
		else{
			setNewTagCompound(stack);
			return false;
		}
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
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn instanceof EntityPlayer){
			if(stack.getTagCompound().getBoolean("activated")){
				((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(3),100,1));
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		setNewTagCompound(stack);
		addInformation(stack, playerIn, stack.getTooltip(playerIn, false), false);
		super.onCreated(stack, worldIn, playerIn);
	}
}
