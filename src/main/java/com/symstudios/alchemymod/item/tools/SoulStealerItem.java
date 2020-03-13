package com.symstudios.alchemymod.item.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SoulStealerItem extends Item {
	
	public SoulStealerItem(String registryName) {
		super(new Item.Properties().group(ItemGroup.MISC));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 600));
		stack.damageItem(1, attacker, item -> {});
		target.getPersistentData().putBoolean("Soul", true);
		return true;
	}
	
}
