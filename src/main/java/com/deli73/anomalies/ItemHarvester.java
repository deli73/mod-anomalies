package com.deli73.anomalies;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemHarvester extends ItemTool {
	private static Set blocks = Sets.newHashSet(new Block[] {Anomalies.anomalyStone});

	public ItemHarvester(ToolMaterial material, String name)
	{
		super(0, material, blocks);
		setUnlocalizedName(Anomalies.MODID + "_" + name);
		setTextureName(Anomalies.MODID + ":" + name);
	}
	
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p7, float xf, float yf, float zf)
	{
		//TODO: Add code to break anomaly block (actual block not yet implemented as of writing)
		return true;
	}

}
