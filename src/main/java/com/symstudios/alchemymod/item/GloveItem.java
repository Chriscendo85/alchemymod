package com.symstudios.alchemymod.item;

import com.symstudios.alchemymod.api.AlchemyAPI;
import com.symstudios.alchemymod.api.circle.AlchemyCircle;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class GloveItem extends Item {

	public GloveItem() {
		super(new Item.Properties().group(ItemGroup.MISC));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemStack = playerIn.getHeldItem(handIn);
		
		// NOT SURE IF .hasUniqueId is the right thing to use
		
		if (!worldIn.isRemote && itemStack.hasTag() && itemStack.getTag().hasUniqueId("CircleName"))
		{
			String circleName = itemStack.getTag().getString("CircleName");
			AlchemyCircle circle = AlchemyAPI.findCircleFromName(circleName);
			if (circle != null) {
				circle.onGloveActivated(worldIn, playerIn, handIn);
			}
		}
	         return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	}
	
}
