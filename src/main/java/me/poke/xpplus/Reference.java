package me.poke.xpplus;

public class Reference {

	public static final String MOD_ID = "xpplus";
	public static final String NAME = "XP-Plus";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSION="[1.10.2]";
	public static final String CLIENT_PROXY_CLASS = "me.poke.xpplus.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "me.poke.xpplus.proxy.ServerProxy";
	
	public static enum xpplusitems{
		//Bridges
		BASIC_CRYSTAL("BasicXPCrystal", "basic_xp_crystal"), 
		ADVANCED_CRYSTAL("AdvancedXPCrystal", "advanced_xp_crystal"),

		//Cards
		HEALING_CARD("HealingCard", "healing_card"),
		JUMP_CARD("JumpCard", "jump_card"),
		SPEED_CARD("SpeedCard", "speed_card"),
		DAY_CARD("DayCard", "day_card"),
		NIGHT_CARD("NightCard", "night_card"),
		CLEAR_CARD("ClearCard", "clear_card"),
		RAIN_CARD("RainCard", "rain_card"),
		HASTE_CARD("HasteCard", "haste_card"),
		RESISTANCE_CARD("ResistanceCard","resistance_card"),
		STRENGTH_CARD("StrengthCard", "strength_card"),
		//Card Holders
		UTILITY_HOLDER("UtilityHolder","utility_holder" );
		
		
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
