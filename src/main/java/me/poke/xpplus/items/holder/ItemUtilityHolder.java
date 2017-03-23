package me.poke.xpplus.items.holder;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemUtilityHolder extends Item{
    public ItemUtilityHolder() {
        setUnlocalizedName(Reference.xpplusitems.UTILITY_HOLDER.getUnlocalizedName());
        setRegistryName(Reference.xpplusitems.UTILITY_HOLDER.getRegistryName());
        setCreativeTab(xpplus.XPPLUS_TAB);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (worldIn.isRemote){

        }

        return super.onItemRightClick(worldIn, playerIn, hand);
    }
}
