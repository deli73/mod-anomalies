package com.deli73.anomalies.items;

import com.deli73.anomalies.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLiquidEnergy extends ItemFood {
	private int secondpotionId;
	private int secondpotionDuration;
	private int secondpotionAmplifier;
	private float secondpotionEffectProbability;
	
	public ItemLiquidEnergy(int food, String name, boolean wolf){
		super(food, 0f, wolf);
		setUnlocalizedName(Reference.MODID + "_" + name);
		setTextureName(Reference.MODID + ":" + name);
		setPotionEffect(Potion.moveSpeed.id, 10, 0, 1f);
		addSecondPotionEffect(Potion.digSpeed.id, 30, 0, .75f);
		setMaxStackSize(16);
		setAlwaysEdible();
	}
	
	//Overridden for sounds
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        --stack.stackSize;
        player.getFoodStats().func_151686_a(this, stack);
        world.playSoundAtEntity(player, "liquid.lavapop", 0.5f, world.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(stack, world, player);
        return stack;
    }
	
	//Overridden to add a second effect
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
		super.onFoodEaten(stack, world, player);
		
		if(!world.isRemote && this.secondpotionId > 0 &&
				world.rand.nextFloat() < this.secondpotionEffectProbability){
			player.addPotionEffect(new PotionEffect(this.secondpotionId, this.secondpotionDuration*20,
					this.secondpotionAmplifier));
		}
	}
	
	public ItemFood addSecondPotionEffect(int p1, int p2, int p3, float p4){
		this.secondpotionId=p1;
		this.secondpotionDuration=p2;
		this.secondpotionAmplifier=p3;
		this.secondpotionEffectProbability=p4;
		return this;
	}
}
