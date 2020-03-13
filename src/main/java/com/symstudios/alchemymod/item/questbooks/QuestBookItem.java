package com.symstudios.alchemymod.item.questbooks;

import com.symstudios.alchemymod.api.AlchemyAPI;
import com.symstudios.alchemymod.api.QuestBase;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class QuestBookItem extends Item {

	protected String name = "default";
	public QuestBookItem() {
		super(new Item.Properties().group(ItemGroup.MISC));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		QuestBase questType = AlchemyAPI.getQuest(name);
		if (questType != null)
		{
			questType.onItemRightClick(worldIn, playerIn, handIn);
		}

        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	}
	
}
