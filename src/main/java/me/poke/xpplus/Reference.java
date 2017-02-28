package me.poke.xpplus;

public class Reference {

	public static final String MOD_ID = "xpplus";
	public static final String NAME = "XP-Plus";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSION="[1.10.2]";
	public static final String CLIENT_PROXY_CLASS = "me.poke.xpplus.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "me.poke.xpplus.proxy.CommonProxy";
	
	public static enum xpplusitems{
		
		BASIC_CRYSTAL("BasicXPCrystal", "basic_xp_crystal"),
		ADVANCED_CRYSTAL("AdvancedXPCrystal", "advanced_xp_crystal"), 
		HEALING_CARD("HealingCard", "healing_card"),
		DAY_CARD("DayCard", "day_card"),
		NIGHT_CARD("NightCard", "night_card"),
		CLEAR_CARD("ClearCard", "clear_card"),
		RAIN_CARD("RainCard", "rain_card");
		
		private String unlocalizedName;
		private String registryName;
		
		xpplusitems(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName(){
			return unlocalizedName;
		}
		
		public String getRegistryName(){
			return registryName;
		}
		
	}
	
	
}
