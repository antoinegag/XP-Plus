package me.poke.xpplus.items.cards;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemJumpCard extends ToggleableItemBase {
	
	public ItemJumpCard() {
		setUnlocalizedName(Reference.xpplusitems.JUMP_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.JUMP_CARD.getRegistryName());
		setCreativeTab(xpplus.XPPLUS_TAB);
		setMaxStackSize(1);
		setLevelCost(30);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.isSneaking()){
				toggleItem(new ItemStack(ModItems.JumpCard), playerIn);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, hand);
	}

}
