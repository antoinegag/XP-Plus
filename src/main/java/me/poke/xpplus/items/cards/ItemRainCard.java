package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemRainCard extends Item {
	
	public ItemRainCard() {
		setUnlocalizedName(Reference.xpplusitems.RAIN_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.RAIN_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Sets the rain for 5 levels");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		int time = 400 + itemRand.nextInt(1000) * 20;
		if (!worldIn.isRemote) {
			if (playerIn.experienceLevel >= 5 && !worldIn.getWorldInfo().isRaining()){
				WorldInfo worldInfo = worldIn.getWorldInfo();
				worldInfo.setCleanWeatherTime(0);
				worldInfo.setRainTime(time);
				worldInfo.setThunderTime(time);
				worldInfo.setRaining(true);
				worldInfo.setThundering(false);
				playerIn.removeExperienceLevel(5);
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
	
   @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

}
