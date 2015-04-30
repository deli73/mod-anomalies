package com.deli73.anomalies;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockAnomalyStone extends Block {
	String name = "anomaly_stone";
	private int spawnchance;
	private int spawnmax;
	private int spawnspread;
	
	public BlockAnomalyStone(Material material, int spawnchance, int spawnmax, int spawnspread) {
		super(material);
		this.spawnchance = spawnchance;
		this.spawnmax = spawnmax;
		this.spawnspread = spawnspread;
		
		setBlockName(Anomalies.MODID + "_" + name);
		setBlockTextureName(Anomalies.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeGlass);
		
		setHarvestLevel("pickaxe", 0);
		
	}
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion boom){
		Random r = world.rand;
		if(r.nextInt(this.spawnchance) == 0){
		//block has a one in spawnchance chance of spawning more of itself when destroyed by explosion
			int spawnnum = r.nextInt(spawnmax) + 1; //spawn up to spawnmax blocks
			
			//locational variables used in placement
			int distx;int disty;int distz; //distance moved
			int dx;   int dy;   int dz;
			int nx;   int ny;   int nz;
			
			for(int i=0; i<spawnnum; i++){
				distx = r.nextInt(spawnspread)+1;
				disty = r.nextInt(spawnspread)+1;
				distz = r.nextInt(spawnspread)+1;
				
				dx = r.nextBoolean() ? distx : -distx;
				dy = r.nextBoolean() ? disty : -disty;
				dz = r.nextBoolean() ? distz : -distz;
				
				nx = x + dx;
				ny = y + dy;
				nz = z + dz;
				
				if(world.isAirBlock(nx, ny, nz)//set block only if it won't be destroyed after placement
				&& !(boom.affectedBlockPositions.contains(new ChunkPosition(nx, ny, nz))) ){
					world.setBlock(nx, ny, nz, Anomalies.anomalyStone);
				}
			}
			
			//remove original block
			world.setBlockToAir(x, y, z);
		}
	}

}
