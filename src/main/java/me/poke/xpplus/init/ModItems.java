package me.poke.xpplus.init;

import me.poke.xpplus.Reference;
import me.poke.xpplus.items.cards.ItemAdvancedCrystal;
import me.poke.xpplus.items.cards.ItemBasicCrystal;
import me.poke.xpplus.items.cards.ItemDayCard;
import me.poke.xpplus.items.cards.ItemHealingCard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item BasicXPCrystal, AdvancedXPCrystal, HealingCard, DayCard;
	
	public static void init(){
		BasicXPCrystal = new ItemBasicCrystal();
		AdvancedXPCrystal = new ItemAdvancedCrystal();
		HealingCard = new ItemHealingCard();
		DayCard = new ItemDayCard();
	}
	
	public static void register(){
		GameRegistry.register(BasicXPCrystal);
		GameRegistry.register(AdvancedXPCrystal);
		GameRegistry.register(HealingCard);	
		GameRegistry.register(DayCard);
	}
	
	public static void registerRenders(){
		registerRender(BasicXPCrystal);
		registerRender(AdvancedXPCrystal);
		registerRender(HealingCard);
		registerRender(DayCard);
		
	}
	
	private static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
