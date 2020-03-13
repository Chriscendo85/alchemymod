package com.symstudios.alchemymod.api.recipe;

import net.minecraft.item.Item;

public class Ingredient {
	
	private String item;
	private int amount;
	
	public Ingredient(Item item, int amount)
	{
		this(item.getRegistryName().toString(), amount);
	}
	
	public Ingredient(String item, int amount)
	{
		this.item = item;
		this.amount = amount;
	}
	
	public String getItem()
	{
		return item;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	@Override
	public String toString()
	{
		return this.item + "-" + amount;
	}
	
	@Override
	public boolean equals(Object object)
	{
        if (object == this)
        	return true; 
  
        if (!(object instanceof Ingredient))
        	return false;
        
        Ingredient ingred = (Ingredient) object;
        return ingred.getItem().equalsIgnoreCase(item) && ingred.getAmount() == amount;
	}

}