package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSpeedCard extends ToggleableItemBase {
	
	public ItemSpeedCard() {
		setUnlocalizedName(Reference.xpplusitems.SPEED_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.SPEED_CARD.getRegistryName());
		setCreativeTab(xpplus.XPPLUS_TAB);
		setMaxStackSize(1);
		setLevelCost(30);
	}


	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,
													EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.isSneaking()){
				toggleItem(playerIn.getHeldItem(hand), playerIn);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, hand);
	}

	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn instanceof EntityPlayer){
			if(stack.getTagCompound().getBoolean("enabled")){
				((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(1),100,2));
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
