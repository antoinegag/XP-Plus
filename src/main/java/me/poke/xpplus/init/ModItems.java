package me.poke.xpplus.init;

import me.poke.xpplus.items.cards.ItemAdvancedCrystal;
import me.poke.xpplus.items.cards.ItemBasicCrystal;
import me.poke.xpplus.items.cards.ItemClearCard;
import me.poke.xpplus.items.cards.ItemDayCard;
import me.poke.xpplus.items.cards.ItemHealingCard;
import me.poke.xpplus.items.cards.ItemJumpCard;
import me.poke.xpplus.items.cards.ItemNightCard;
import me.poke.xpplus.items.cards.ItemRainCard;
import me.poke.xpplus.items.cards.ItemSpeedCard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item BasicXPCrystal, AdvancedXPCrystal, HealingCard, DayCard, NightCard, ClearCard, RainCard, JumpCard, SpeedCard;
	
	public static void init(){
		BasicXPCrystal = new ItemBasicCrystal();
		AdvancedXPCrystal = new ItemAdvancedCrystal();
		HealingCard = new ItemHealingCard();
		DayCard = new ItemDayCard();
		NightCard = new ItemNightCard();
		ClearCard = new ItemClearCard();
		RainCard = new ItemRainCard();
		JumpCard = new ItemJumpCard();
		SpeedCard = new ItemSpeedCard();
	}
	
	public static void register(){
		GameRegistry.register(BasicXPCrystal);
		GameRegistry.register(AdvancedXPCrystal);
		GameRegistry.register(HealingCard);	
		GameRegistry.register(DayCard);
		GameRegistry.register(NightCard);
		GameRegistry.register(ClearCard);
		GameRegistry.register(RainCard);
		GameRegistry.register(JumpCard);
		GameRegistry.register(SpeedCard);
	}
	
	public static void registerRenders(){
		registerRender(BasicXPCrystal);
		registerRender(AdvancedXPCrystal);
		registerRender(HealingCard);
		registerRender(DayCard);
		registerRender(NightCard);
		registerRender(ClearCard);
		registerRender(RainCard);
		registerRender(JumpCard);
		registerRender(SpeedCard);
	}
	
	private static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
