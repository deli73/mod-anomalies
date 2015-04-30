package com.deli73.anomalies.util;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {
	protected static Configuration config;
	
	//item-related
	public static boolean wolfCanEatEnergy;
	
	//danger zone
	public static boolean ignoreTileErrors;
	public static boolean ignoreEntityErrors;
	public static boolean ignoreOtherErrors;
	
	public static void load(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
		
		wolfCanEatEnergy = config.getBoolean("wolfCanEatEnergy", Configuration.CATEGORY_GENERAL,
				true, "Whether or not Liquid Energy can be fed to wolves");
		
		ignoreTileErrors = config.getBoolean("ignoreTileErrors", Configuration.CATEGORY_GENERAL,
				true, "DANGER! Ignore consistency issues with tile entities being in the wrong block");
		ignoreEntityErrors = config.getBoolean("ignoreEntityErrors", Configuration.CATEGORY_GENERAL,
				true, "DANGER! Ignore potentially game-breaking issues with entities when possible");
		ignoreOtherErrors= config.getBoolean("ignoreTileErrors", Configuration.CATEGORY_GENERAL,
				true, "DANGER! Ignore any errors that don't inherently crash the game");
	}
}
