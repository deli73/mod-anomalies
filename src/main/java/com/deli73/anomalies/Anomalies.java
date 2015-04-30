package com.deli73.anomalies;

import com.deli73.anomalies.items.*;
import com.deli73.anomalies.util.Config;
import com.deli73.anomalies.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MODID, version=Reference.VERSION)
public class Anomalies {
	//blocks
	public static Block anomalyStone;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("Preinitializing");
		
		Config.load(event);
		
		ItemList.load();
		
		//blocks
		anomalyStone = new BlockAnomalyStone(Material.rock, 3, 5, 8);
		//register blocks
		GameRegistry.registerBlock(anomalyStone, "AnomalyStone");
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		System.out.println("Initializing");
		
		//crafting{
			GameRegistry.addShapedRecipe(new ItemStack(ItemList.liquidEnergy),
					"S",
					"B",
					'S', ItemList.crystal, 'B', Items.potionitem);
		//}
		//smelting{
			GameRegistry.addSmelting(anomalyStone, new ItemStack(ItemList.crystal), 0.1f);
		//}
	}
}
