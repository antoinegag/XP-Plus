package me.poke.xpplus.items.cards;

import java.util.List;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemJumpCard extends Item {
	
	public ItemJumpCard() {
		setUnlocalizedName(Reference.xpplusitems.JUMP_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.JUMP_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.isSneaking()){
				NBTTagCompound itemData = stack.getTagCompound();
				if(stack.hasTagCompound()){
					if(!itemData.getBoolean("activated")){
						if(playerIn.experienceLevel >= 30){
						playerIn.removeExperienceLevel(30);
						itemData.setBoolean("activated", true);
						}else{
							playerIn.addChatComponentMessage(new TextComponentTranslation("item.activate.noXp", new Object[0]));
						}
						
					}else{
						itemData.setBoolean("activated", false);
						playerIn.capabilities.setPlayerWalkSpeed(1);
					}
				}else{
					setNewTagCompound(stack);
				}
				addInformation(stack, playerIn, stack.getTooltip(playerIn, false), false);
			}
		}
		return super.onItemRightClick(stack, worldIn, playerIn, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			boolean activated = stack.getTagCompound().getBoolean("activated");
			if(activated){
				tooltip.add("Activated - Jump 4 blocks high!");
			}else{
				tooltip.add("Activate for 30 levels (Shift-Right Click)");
			}
			hasEffect(stack);
		}else{
			setNewTagCompound(stack);
			tooltip.add("Activate for 30 levels (Shift-Right Click)");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		if(stack.hasTagCompound()){
		return stack.getTagCompound().getBoolean("activated");
		}else{
			setNewTagCompound(stack);
			return false;
		}
	}
	
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
	
}
