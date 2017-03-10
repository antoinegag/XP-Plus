package me.poke.xpplus.items.holder;

import me.poke.xpplus.Reference;
import me.poke.xpplus.items.cards.ToggleableItemBase;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemUtilityHolder extends Item{
    public ItemUtilityHolder() {
        setUnlocalizedName(Reference.xpplusitems.UTILITY_HOLDER.getUnlocalizedName());
        setRegistryName(Reference.xpplusitems.UTILITY_HOLDER.getRegistryName());
        setCreativeTab(xpplus.CREATIVE_TAB);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (worldIn.isRemote){
            playerIn.openGui(xpplus.instance, 0, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setBoolean("haste", true);
        super.onCreated(stack, worldIn, playerIn);
    }

    public void setNewTagCompound(ItemStack stack){
        NBTTagCompound tag = new NBTTagCompound();
        stack.setTagCompound(tag);
        stack.getTagCompound().setBoolean("haste", false);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof EntityPlayer){
            if (!stack.hasTagCompound())
                setNewTagCompound(stack);
            if(stack.getTagCompound().getBoolean("haste")){
                //((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(1),100,2));
                //((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(11),100,0));
                ((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(3),100,1));
                //((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(5),100,1));
            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
