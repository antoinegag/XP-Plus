package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemNightCard extends Item {
	
	public ItemNightCard() {
		setUnlocalizedName(Reference.xpplusitems.NIGHT_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.NIGHT_CARD.getRegistryName());
		setCreativeTab(xpplus.XPPLUS_TAB);
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if(!worldIn.isRemote){
			if (playerIn.experienceLevel >= 10 && worldIn.getWorldTime() < 13000) {
				worldIn.setWorldTime(13000);
				playerIn.removeExperienceLevel(10);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Set the time to night for 10 levels");
	}

   @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
