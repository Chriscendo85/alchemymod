package com.symstudios.alchemymod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class InvisibiliaItem extends Item {

	public InvisibiliaItem() {
		super(new Properties().group(ItemGroup.FOOD).maxStackSize(64).food(new Food.Builder().setAlwaysEdible().build()));
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		entityLiving.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 600));
		return stack;
	   }
	
}
