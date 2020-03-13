package com.symstudios.alchemymod.api;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class QuestBase {

	private String name;
	
	public QuestBase(String name)
	{
		this.name = name;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	}
	
	public String getName()
	{
		return this.name;
	}
	
}
