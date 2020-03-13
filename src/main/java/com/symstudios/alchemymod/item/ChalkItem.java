package com.symstudios.alchemymod.item;

import com.symstudios.alchemymod.AlchemyBlocks;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

public class ChalkItem extends Item {

	public ChalkItem() {
		super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).defaultMaxDamage(10));
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context)
    {
		context.getWorld().setBlockState(context.getPos().add(0, 1, 0), AlchemyBlocks.CHALK_BLOCK.get().getDefaultState());
		this.setDamage(context.getPlayer().getHeldItemMainhand(), context.getPlayer().getHeldItemMainhand().getDamage() + 1);
        return ActionResultType.PASS;
    }
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (this.getDamage(stack) > this.getMaxDamage())
		{
			stack.shrink(1);
		}
    }
	
}
