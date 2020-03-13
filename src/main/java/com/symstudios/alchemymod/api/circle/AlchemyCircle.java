package com.symstudios.alchemymod.api.circle;

import java.util.ArrayList;

import com.symstudios.alchemymod.api.recipe.Ingredient;
import com.symstudios.alchemymod.api.recipe.RecipeInput;
import com.symstudios.alchemymod.tileentity.TileEntityAlchemyCircle;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AlchemyCircle {
	
	private String name;
	private ArrayList<Ingredient> ingredients;
	
	public AlchemyCircle(String name)
	{
		this.ingredients = new ArrayList();
		this.name = name;
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		this.ingredients.add(ingredient);
	}
	
	public void onCircleActivated(TileEntityAlchemyCircle circle, World world, BlockPos pos, BlockState state, PlayerEntity player) {}

	public boolean matchesRecipe(RecipeInput input)
	{
		for(Ingredient ingredient : ingredients)
		{
			if(!input.getIngredients().contains(ingredient))
				return false;
		}
		return true;
	}
	
	public void onCircleCollided(TileEntityAlchemyCircle circle, World worldIn, BlockPos pos, BlockState state, Entity entityIn)
    {
		
    }
	
	public void onGloveActivated(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		
	}
	
	public String getName()
	{
		return name;
	}
	
}