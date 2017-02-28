package me.poke.xpplus.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting {

	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.BasicXPCrystal), " I ", "IEI", " I ", 'I', Items.IRON_INGOT, 'E', Items.EMERALD);
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.AdvancedXPCard), " I ", "INI", " I ", 'I', Items.IRON_INGOT, 'N', Items.NETHER_STAR);
	}
}
