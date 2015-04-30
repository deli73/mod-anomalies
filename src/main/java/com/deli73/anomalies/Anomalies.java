package com.deli73.anomalies;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Anomalies.MODID, version=Anomalies.VERSION)
public class Anomalies {
	public static final String MODID = "deli73_anomalies";
	public static final String VERSION="1.0";
	
	//items
	public static Item crystal;
	public static Item liquidEnergy;
	
	//tools
	public static Item harvester;
	ToolMaterial mat_anomaly = EnumHelper.addToolMaterial("anomalous", 1, 1000, 6f, 1f, 0);
	
	
	//blocks
	public static Block anomalyStone;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("Preinitializing");
		//items
		crystal = new ItemCrystal();
		liquidEnergy = new ItemLiquidEnergy(20, "liquid_energy");
		
		//tools
		harvester = new ItemHarvester(mat_anomaly, "harvester");
		
		//blocks
		anomalyStone = new BlockAnomalyStone(Material.rock, 3, 5, 8);
		
		//register items
		GameRegistry.registerItem(crystal, "Crystal");
		GameRegistry.registerItem(liquidEnergy, "LiquidEnergy");
		//register tools
		GameRegistry.registerItem(harvester, "Harvester");
		//register blocks
		GameRegistry.registerBlock(anomalyStone, "AnomalyStone");
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		System.out.println("Initializing");
		
		//crafting{
			GameRegistry.addShapedRecipe(new ItemStack(this.liquidEnergy),
					"S",
					"B",
					'S', this.crystal, 'B', Items.potionitem);
		//}
		//smelting{
			GameRegistry.addSmelting(anomalyStone, new ItemStack(crystal), 0.1f);
		//}
	}
}
