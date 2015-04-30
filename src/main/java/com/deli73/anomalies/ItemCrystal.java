package com.deli73.anomalies;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCrystal extends Item {
	public ItemCrystal(){
		setUnlocalizedName(Anomalies.MODID + "_" + "crystal");
		setTextureName(Anomalies.MODID + ":" + "crystal");
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
