package me.poke.xpplus.items.cards;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ToggleableItemBase extends Item{

    public static String ActivatedTooltip;
    public static int LevelCost;

    public void toggleItem(ItemStack stack, EntityPlayer playerIn){
        if(!stack.hasTagCompound()){
            setNewTagCompound(stack);
        }
        NBTTagCompound itemData = stack.getTagCompound();
        if(!itemData.getBoolean("activated")){
            if(playerIn.experienceLevel >= this.LevelCost){
                playerIn.removeExperienceLevel(this.LevelCost);
                itemData.setBoolean("activated", true);
            }else
                playerIn.addChatComponentMessage(new TextComponentTranslation("item.activate.noXp", new Object[0]));
        }else
            itemData.setBoolean("activated", false);
        addInformation(stack, playerIn, stack.getTooltip(playerIn, false), false); //Update the tooltip
    }

    /**
     * Gives a new NBTTag compound to the item stack with activated to false
     * @param stack ItemStack
     */
    public void setNewTagCompound(ItemStack stack){
        NBTTagCompound tag = new NBTTagCompound();
        stack.setTagCompound(tag);
        stack.getTagCompound().setBoolean("activated", false);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        setNewTagCompound(stack);
        addInformation(stack, playerIn, stack.getTooltip(playerIn, false), false);
        super.onCreated(stack, worldIn, playerIn);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        if(stack.hasTagCompound())
            return stack.getTagCompound().getBoolean("activated");
        else
            return false;
    }

    public void setTooltipMessage(String activatedTooltip){
        this.ActivatedTooltip = activatedTooltip;
    }

    public void setLevelCost(int level){
        this.LevelCost = level;
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        if(!stack.hasTagCompound()){
            setNewTagCompound(stack);
        }
        if(stack.getTagCompound().getBoolean("activated")){
            tooltip.add(this.ActivatedTooltip);
        }else{
            tooltip.add("Activate for " + this.LevelCost + " levels (Shift-Right Click)");
        }
        hasEffect(stack); //Update enchant effet
    }
}
