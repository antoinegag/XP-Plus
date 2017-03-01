package me.poke.xpplus.items.cards;

import java.util.List;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHealingCard extends Item {
	public ItemHealingCard() {
		setUnlocalizedName(Reference.xpplusitems.HEALING_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.HEALING_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand) {
		if(!worldIn.isRemote){
			if(player.experienceLevel >= 5 && player.getHealth() != player.getMaxHealth()){
				player.heal(player.getMaxHealth());
				player.removeExperienceLevel(5);
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, player, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Heal yourself for 5 levels");
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
}
