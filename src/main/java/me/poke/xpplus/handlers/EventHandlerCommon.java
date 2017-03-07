package me.poke.xpplus.handlers;

import me.poke.xpplus.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class EventHandlerCommon{

	@SubscribeEvent(priority= EventPriority.NORMAL)
	public void onLivingEntityJump(LivingJumpEvent e){
		if (e.getEntity() instanceof EntityPlayer) { //check if player
			EntityPlayer player = (EntityPlayer)e.getEntity(); //get the player
			ItemStack stack = new ItemStack(ModItems.JumpCard);
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setBoolean("enabled", true);
			if(player.inventory.hasItemStack(stack)){
				if(player.inventory.getSlotFor(stack) != -1){
					player.motionY *= 2;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingFallEvent(LivingHurtEvent e){
		if (e.getEntity() instanceof EntityPlayer) { //check if player
			EntityPlayer player = (EntityPlayer)e.getEntity(); //get the player
			ItemStack stack = new ItemStack(ModItems.JumpCard);
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setBoolean("activated", true);
			if(player.inventory.hasItemStack(stack)){ 
				if(player.inventory.getSlotFor(stack) != -1){
					if(e.getSource() == DamageSource.fall){
						e.setCanceled(true);
					}
				}
			}
		}
	}

}

