package com.symstudios.alchemymod.api.recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeInput {
	
	private ArrayList<Ingredient> ingredients;
	
	public RecipeInput(ArrayList<String> input)
	{
		setupRecipe(input);
	}
	
	private void setupRecipe(ArrayList<String> input)
	{
		ingredients = new ArrayList();
		HashMap<String, Integer> ingredientMap = new HashMap();
		
		for(String item : input)
		{
			if(ingredientMap.containsKey(item))
			{
				int count = ingredientMap.get(item) + 1;
				ingredientMap.put(item, count);
			} else
			{
				ingredientMap.put(item, 1);
			}
		}
		
		for(String key : ingredientMap.keySet())
			ingredients.add(new Ingredient(key, ingredientMap.get(key)));
	}
	
	public ArrayList<Ingredient> getIngredients()
	{
		return ingredients;
	}

}