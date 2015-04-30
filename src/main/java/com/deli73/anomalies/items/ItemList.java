package com.deli73.anomalies.items;

import com.deli73.anomalies.util.Config;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemList {
	//items
	public static Item crystal;
	public static Item liquidEnergy;
	//tools
	public static Item harvester;
	static ToolMaterial mat_anomaly = EnumHelper.addToolMaterial("anomalous", 1, 1000, 6f, 1f, 0);
	
	public static void load(){
		//items
		crystal = new ItemCrystal();
		liquidEnergy = new ItemLiquidEnergy(20, "liquid_energy", Config.wolfCanEatEnergy);
				
		//tools
		harvester = new ItemHarvester(mat_anomaly, "harvester");
		
		//register items
		GameRegistry.registerItem(ItemList.crystal, "Crystal");
		GameRegistry.registerItem(ItemList.liquidEnergy, "LiquidEnergy");
		//register tools
		GameRegistry.registerItem(ItemList.harvester, "Harvester");
		
	}
}
