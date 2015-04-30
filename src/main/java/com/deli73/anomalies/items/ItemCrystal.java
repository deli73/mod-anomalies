package com.deli73.anomalies.items;

import com.deli73.anomalies.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCrystal extends Item {
	public ItemCrystal(){
		setUnlocalizedName(Reference.MODID + "_" + "crystal");
		setTextureName(Reference.MODID + ":" + "crystal");
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
