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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAdvancedCrystal extends Item {
	public ItemAdvancedCrystal() {
		setUnlocalizedName(Reference.xpplusitems.ADVANCED_CRYSTAL.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.ADVANCED_CRYSTAL.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
	}
		
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
    
    @Override 	//DEBUG ONLY
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
    		EnumHand hand) {
    	
    	System.out.println("Player experience: " + playerIn.experience);
    	System.out.println("Player level: " + playerIn.experienceLevel);
    	System.out.println("Player totalexpericen: " + playerIn.experienceTotal );
    	System.out.println("xp Bar Cap" + playerIn.xpBarCap());
    	System.out.println("XP Seed: " + playerIn.getXPSeed());
    	//playerIn.addExperience();
   
    	return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
