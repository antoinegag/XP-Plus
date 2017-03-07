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

public class ItemClearCard extends Item {
	public ItemClearCard() {
		setUnlocalizedName(Reference.xpplusitems.CLEAR_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.CLEAR_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		int time = 400 + itemRand.nextInt(1000) * 20;
		if (!worldIn.isRemote) {
			if (playerIn.experienceLevel >= 5 && worldIn.getWorldInfo().isRaining()){
				WorldInfo worldInfo = worldIn.getWorldInfo();
				worldInfo.setCleanWeatherTime(time);
				worldInfo.setRainTime(0);
				worldInfo.setThunderTime(0);
				worldInfo.setRaining(false);
				worldInfo.setThundering(false);
				playerIn.removeExperienceLevel(5);
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Clear the weather for 5 levels");
	}

   @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}

