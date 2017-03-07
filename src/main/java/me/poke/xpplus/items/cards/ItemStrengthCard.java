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

public class ItemStrengthCard extends ToggleableItemBase {

	public ItemStrengthCard() {
		setUnlocalizedName(Reference.xpplusitems.STRENGTH_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.STRENGTH_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
		setLevelCost(30);
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.isSneaking()){
					toggleItem(stack, playerIn);
			}	
		}
		return super.onItemRightClick(stack, worldIn, playerIn, hand);
	}


	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn instanceof EntityPlayer){
			if(stack.getTagCompound().getBoolean("enabled")){
				((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(5),100,1));
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
}
